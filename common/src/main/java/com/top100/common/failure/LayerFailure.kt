package com.top100.common.failure

/**
 * Base class for Failure/Error handling across all features and layers
 */
sealed class LayerFailure : Throwable() {
    /*** Extend this class for data specific failures. i.e. server side or database side failures. */
    abstract class DataFailure : LayerFailure()

    /*** Extend this class for feature specific failures. */
    abstract class FeatureFailure : LayerFailure()
}
