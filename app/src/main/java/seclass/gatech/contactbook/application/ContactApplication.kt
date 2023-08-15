package seclass.gatech.contactbook.application

import android.app.Application
import seclass.gatech.contactbook.db.ContactBookDatabase
import seclass.gatech.contactbook.repository.ContactRepository

class ContactApplication : Application() {

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts

    val database by lazy {ContactBookDatabase.getDatabaseInstance(this)}
    val repository by lazy {ContactRepository(database.contactDao())}

}