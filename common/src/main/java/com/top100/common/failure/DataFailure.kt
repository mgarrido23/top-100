package com.top100.common.failure

/**
 * This Throwable is to send from domain to presentation
 */
sealed class DataFailure : LayerFailure.DataFailure() {
    object Network : DataFailure()

    object NotFoundError : DataFailure()

    object RefreshTokenExpiredError : DataFailure()

    object ServiceUnavailableError : DataFailure()

    object RequestTimeoutError : DataFailure()

    object Unknown : DataFailure()

    data class Custom(
        val code: Int,
        val msg: String?
    ) : DataFailure()
}
