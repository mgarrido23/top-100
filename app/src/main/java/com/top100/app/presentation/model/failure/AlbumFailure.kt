package com.top100.app.presentation.model.failure

import com.top100.common.failure.LayerFailure

sealed class AlbumFailure : LayerFailure.FeatureFailure() {

    object FetchAlbumsFailure : AlbumFailure()
}
