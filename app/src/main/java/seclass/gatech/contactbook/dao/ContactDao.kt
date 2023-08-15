package seclass.gatech.contactbook.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import seclass.gatech.contactbook.entities.Contact

@Dao
interface ContactDao{

    @Query("SELECT * FROM contact ORDER BY contact_name ASC")
    fun getContactInAscendingOrder() : Flow<List<Contact>>

    @Insert
    suspend fun addContact(contact: Contact)
}