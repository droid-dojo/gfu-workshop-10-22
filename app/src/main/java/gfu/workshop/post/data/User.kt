package gfu.workshop.post.data

data class User(
    val name: String,
    val location: String,
    val avatarUrl: String,
)


fun getUser(userId: Int): User {
    return when(userId) {
        1234 -> User(name = "Franz", location = "Dahoam", avatarUrl = "")
        999 -> User(name = "Brigitte", location = "Darmstadt", avatarUrl = "")
        else -> throw IllegalArgumentException("Unknown userid $userId")
    }
}
