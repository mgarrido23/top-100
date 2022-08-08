package com.top100.common.failure

/**
 * All kind of possible failures we can get when we do a Api request
 **/
sealed class ApiFailure : LayerFailure.DataFailure() {
    data class ServiceUnavailableError(val serverMessage: String? = null) : ApiFailure()
    object JsonParseError : ApiFailure()
    object RequestTimeoutError : ApiFailure()
    object ForbiddenError : ApiFailure()
    object NotFoundError : ApiFailure()
    object AuthRequiredError : ApiFailure()
    object RefreshTokenExpiredError : ApiFailure()
    data class ServiceBodyFailure(
        val internalCode: Int,
        val internalMessage: String?
    ) : ApiFailure()
}

fun ApiFailure.toDataFailure(): LayerFailure.DataFailure {
    return when (this) {
        is ApiFailure.ServiceUnavailableError -> DataFailure.ServiceUnavailableError
        is ApiFailure.RequestTimeoutError -> DataFailure.RequestTimeoutError
        is ApiFailure.NotFoundError -> DataFailure.NotFoundError
        is ApiFailure.RefreshTokenExpiredError -> DataFailure.RefreshTokenExpiredError
        is ApiFailure.ServiceBodyFailure -> DataFailure.Custom(internalCode, internalMessage)
        else -> DataFailure.Unknown
    }
}
