package com.top100.app.presentation.screens.albums.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.top100.app.R
import com.top100.app.presentation.model.PAlbum
import com.top100.app.presentation.theme.AppTheme
import com.top100.app.presentation.theme.albumItemText
import com.top100.app.presentation.theme.black75
import com.top100.app.presentation.theme.blackTransparent

@Composable
fun AlbumItem(
    album: PAlbum,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        elevation = dimensionResource(id = R.dimen.size_0),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.size_6)),
        onClick = onClick,
    ) {
        Box {

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(album.artworkUrl100)
                    .crossfade(true)
                    .build(),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                MaterialTheme.colors.blackTransparent,
                                MaterialTheme.colors.black75
                            )
                        )
                    )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomStart)
                        .padding(dimensionResource(id = R.dimen.size_3)),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(
                        dimensionResource(id = R.dimen.size_1)
                    )
                ) {
                    Text(
                        text = album.name, overflow = TextOverflow.Ellipsis,
                        maxLines = 2,
                        color = MaterialTheme.colors.albumItemText,
                        style = MaterialTheme.typography.subtitle1,
                    )
                    Text(
                        text = album.artistName, overflow = TextOverflow.Ellipsis,
                        maxLines = 2,
                        color = MaterialTheme.colors.albumItemText,
                        style = MaterialTheme.typography.caption,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun AlbumItemPreview() {
    AppTheme {
        AlbumItem(
            album = getMockAlbum(),
            onClick = {},
        )
    }
}

fun getMockAlbum() = PAlbum(
    artistId = "",
    artistName = "AlbumName",
    artistUrl = "",
    artworkUrl100 = "https://is1-ssl.mzstatic.com/image/thumb/Music112/v4/0b/" +
        "4d/82/0b4d825c-fe2a-fe9b-b318-eaa7201d924b/075597906660.jpg/100x100bb.jpg",
    contentAdvisoryRating = "",
    genres = listOf(),
    id = "",
    kind = "",
    name = "Albunnn",
    releaseDate = "",
    url = ""
)
