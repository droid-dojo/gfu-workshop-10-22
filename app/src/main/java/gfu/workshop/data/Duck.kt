package gfu.workshop.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Duck(
    @PrimaryKey val url: String
)