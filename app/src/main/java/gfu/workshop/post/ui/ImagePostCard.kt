package gfu.workshop.post.ui

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import gfu.workshop.R
import gfu.workshop.post.data.ImagePost
import gfu.workshop.post.data.User
import gfu.workshop.ui.theme.WorkshopGfuTheme
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun ImagePostCard(post: ImagePost) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {

            UserInfo(post.author)

            SubcomposeAsyncImage(
                model = post.imageUrl,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(4 / 3f),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                loading = {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize()
                    )
                },
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconWithTextButton(
                    icon = Icons.Default.FavoriteBorder,
                    text = stringResource(id = R.string.likes, post.likes)
                )

                IconWithTextButton(
                    icon = painterResource(id = R.drawable.ic_baseline_comment_24),
                    text = "${post.comments}"
                )
            }
        }
    }
}

fun getCount(): Int {
    Thread.sleep(5_000)
    return Random.nextInt()
}

suspend fun getCountAsync(): Int {
    delay(1_000)
    return Random.nextInt()
}


@Composable
fun IconWithTextButton(
    icon: ImageVector,
    text: String,
) {
    TextButton(onClick = {}) {
        Icon(imageVector = icon, contentDescription = null)
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = text)
    }
}

@Composable
fun IconWithTextButton(
    icon: Painter,
    text: String,
) {
    TextButton(onClick = {

    }) {
        Icon(painter = icon, contentDescription = null)
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = text)
    }
}


@Composable
fun UserInfo(user: User) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Image(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(Color.Gray)
                .border(width = 1.5.dp, color = MaterialTheme.colors.primary, shape = CircleShape),
            painter = painterResource(id = R.drawable.angelo),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Column {
            Text(
                text = user.name,
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1,
            )
            Text(text = user.location, modifier = Modifier.fillMaxWidth(), maxLines = 1)
        }
    }
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ImagePostCardPreview() {
    WorkshopGfuTheme() {
        ImagePostCard(
            post = ImagePost(
                author = User(name = "Hans Peter", location = "Zuhause", avatarUrl = ""),
                imageUrl = "",
                likes = 1337,
                comments = 99
            )
        )
    }
}