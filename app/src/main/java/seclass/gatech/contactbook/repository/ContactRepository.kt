package seclass.gatech.contactbook.repository

import seclass.gatech.contactbook.dao.ContactDao
import seclass.gatech.contactbook.entities.Contact

class ContactRepository(private val contactDao: ContactDao) {

    val allContacts = contactDao.getContactInAscendingOrder()

    suspend fun addContact(contact: Contact) {
        contactDao.addContact(contact)
    }
}