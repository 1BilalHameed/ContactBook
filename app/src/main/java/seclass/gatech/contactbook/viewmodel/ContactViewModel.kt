package seclass.gatech.contactbook.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import seclass.gatech.contactbook.entities.Contact
import seclass.gatech.contactbook.repository.ContactRepository


class ContactViewModel(private val contactRepository : ContactRepository) : ViewModel() {

    val allContacts = contactRepository.allContacts.asLiveData()

    fun addContact(contact : Contact) = viewModelScope.launch { contactRepository.addContact(contact) }


}