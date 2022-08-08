package com.top100.app.presentation.screens.albums.detail

import android.webkit.URLUtil
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.top100.app.R
import com.top100.app.presentation.components.AppBackButton
import com.top100.app.presentation.components.AppButton
import com.top100.app.presentation.components.AppChip
import com.top100.app.presentation.model.PAlbum
import com.top100.app.presentation.model.PGenre
import com.top100.app.presentation.theme.AppTheme
import com.top100.app.presentation.theme.albumDetailCaption
import com.top100.app.presentation.theme.albumDetailExtraInfo
import com.top100.app.presentation.theme.albumDetailTitle
import com.top100.app.presentation.theme.chips
import com.top100.app.presentation.theme.extraInfoAlbumDetail

@Composable
fun AlbumsDetailScreen(
    viewModel: AlbumDetailViewModel,
    albumId: String,
    onBackPress: () -> Unit
) {
    val album by viewModel.album.collectAsState()
    viewModel.getAlbumById(albumId)

    AlbumsDetailScreenContent(
        album = album,
        backButtonClick = {
            onBackPress()
        }
    )
}

@Composable
private fun AlbumsDetailScreenContent(
    album: PAlbum?,
    backButtonClick: () -> Unit
) {
    if (album != null) {
        val uriHandler = LocalUriHandler.current
        Surface {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.Start
            ) {
                Box {
                    AsyncImage(
                        model = album.artworkUrl400,
                        modifier = Modifier
                            .fillMaxWidth(),
                        placeholder = painterResource(R.drawable.ic_picture_place_holder),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth
                    )

                    AppBackButton(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(
                                start = dimensionResource(id = R.dimen.size_4),
                                top = dimensionResource(id = R.dimen.size_4)
                            )
                            .statusBarsPadding(),

                        onClick = {
                            backButtonClick()
                        }
                    )
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = dimensionResource(id = R.dimen.size_3))
                        .padding(horizontal = dimensionResource(id = R.dimen.size_4)),
                    text = album.artistName,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    color = MaterialTheme.colors.albumDetailCaption,
                    style = MaterialTheme.typography.body1,
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(id = R.dimen.size_4)),
                    text = album.name,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    color = MaterialTheme.colors.albumDetailTitle,
                    style = MaterialTheme.typography.h4,
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = dimensionResource(id = R.dimen.size_2))
                        .padding(horizontal = dimensionResource(id = R.dimen.size_4))
                ) {
                    album.genres.forEach {
                        AppChip(
                            text = it.name,
                            color = MaterialTheme.colors.chips,
                            modifier = Modifier.clickable {
                                if (URLUtil.isValidUrl(it.url)) {
                                    uriHandler.openUri(it.url)
                                }
                            }
                        )
                        Spacer(Modifier.width(dimensionResource(id = R.dimen.size_2)))
                    }
                }
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter)
                            .navigationBarsPadding(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (album.releaseDate.isNotEmpty()) {
                            Text(
                                text = stringResource(
                                    R.string.album_detail_release_date,
                                    album.releaseDateFormatted
                                ),
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 2,
                                color = MaterialTheme.colors.albumDetailExtraInfo,
                                style = MaterialTheme.typography.extraInfoAlbumDetail,
                            )
                        }

                        Text(
                            text = stringResource(R.string.albums_detail_copyright),
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 2,
                            color = MaterialTheme.colors.albumDetailExtraInfo,
                            style = MaterialTheme.typography.extraInfoAlbumDetail,
                        )
                        Spacer(Modifier.height(dimensionResource(id = R.dimen.size_7)))
                        AppButton(
                            text = stringResource(id = R.string.album_detail_button_visit),
                            onClick = {
                                if (URLUtil.isValidUrl(album.url)) {
                                    uriHandler.openUri(album.url)
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun AlbumsDetailScreenContentPreview() {
    AppTheme {
        AlbumsDetailScreenContent(
            album = getMockAlbum(),
            backButtonClick = {
            }
        )
    }
}

fun getMockAlbum() = PAlbum(
    artistId = "",
    artistName = "Artist Name",
    artistUrl = "",
    artworkUrl100 = "https://is1-ssl.mzstatic.com/image/thumb/Music112/v4/0b/4d/82/" +
        "0b4d825c-fe2a-fe9b-b318-eaa7201d924b/075597906660.jpg/100x100bb.jpg",
    contentAdvisoryRating = "",
    genres = listOf(
        PGenre(
            "",
            "Reggeaton",
            ""
        )
    ),
    id = "",
    kind = "",
    name = "Album Name",
    releaseDate = "",
    url = ""
)
