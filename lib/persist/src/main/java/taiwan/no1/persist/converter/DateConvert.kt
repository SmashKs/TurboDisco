package taiwan.no1.persist.converter

import androidx.room.TypeConverter
import kotlinx.datetime.Instant

class DateConvert {
    @TypeConverter
    fun fromTimestamp(value: Long?) = value?.let(Instant::fromEpochMilliseconds)

    @TypeConverter
    fun dateToTimestamp(date: Instant?) = date?.toEpochMilliseconds()
}
