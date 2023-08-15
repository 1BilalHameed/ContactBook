package seclass.gatech.contactbook.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class Contact(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "contact_name")
    val contactName: String,
    @ColumnInfo(name = "contact_number")
    val contactNumber: String
)
