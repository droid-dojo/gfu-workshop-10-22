package gfu.workshop.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gfu.workshop.post.data.ImagePost
import gfu.workshop.post.ui.ImagePostCard

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostList(posts: List<ImagePost>, modifier: Modifier) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {

        items(posts) { imagePost ->
            ImagePostCard(post = imagePost)
        }
    }
}