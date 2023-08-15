package seclass.gatech.contactbook.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import seclass.gatech.contactbook.dao.ContactDao
import seclass.gatech.contactbook.entities.Contact

@Database(entities = [Contact::class], version = 1, exportSchema = false)
abstract class ContactBookDatabase : RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object {

        @Volatile
        private var INSTANCE: ContactBookDatabase? = null

        fun getDatabaseInstance(context: Context): ContactBookDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactBookDatabase::class.java,
                    "contact_book_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}