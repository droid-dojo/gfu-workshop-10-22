package gfu.workshop.post.data

data class ImagePost(
    val author: User,
    val imageUrl: String,
    val likes: Int,
    val comments: Int,
)

