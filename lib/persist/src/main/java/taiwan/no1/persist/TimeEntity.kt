package taiwan.no1.persist

import androidx.room.ColumnInfo
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class TimeEntity(
    @ColumnInfo(name = "created_at")
    val createdAt: Instant = Clock.System.now(),
    @ColumnInfo(name = "updated_at")
    val updatedAt: Instant = Clock.System.now(),
)
