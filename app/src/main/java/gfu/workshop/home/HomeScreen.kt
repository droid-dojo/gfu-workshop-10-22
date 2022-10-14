package gfu.workshop.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import gfu.workshop.data.DuckRepository
import gfu.workshop.post.data.ImagePost
import gfu.workshop.post.data.User

@Composable
fun HomeScreen() {

    //HINWEIS: Dies sollte in einem Viewmodel passieren
    var posts: List<ImagePost> by remember {
        mutableStateOf(emptyList())
    }
    val context = LocalContext.current
    val repository = remember(context) { DuckRepository(context) }

    LaunchedEffect(repository) {
        val ducks = repository.getDuckList()
        posts = ducks.map {
            ImagePost(
                author = User(name = "Hans Peter", location = "Zuhause", avatarUrl = ""),
                imageUrl = it.url,
                likes = 1337,
                comments = 99
            )
        }
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
        topBar = {
            HomeScreenToolbar()
        },
        content = { innerPadding ->
            PostList(posts = posts, modifier = Modifier.padding(innerPadding))
        }
    )
}