package seclass.gatech.contactbook.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import seclass.gatech.contactbook.application.ContactApplication
import seclass.gatech.contactbook.databinding.ActivityMainBinding
import seclass.gatech.contactbook.viewmodel.ContactViewModel
import seclass.gatech.contactbook.viewmodel.ContactViewModelFactory
import androidx.activity.viewModels
import seclass.gatech.contactbook.adapter.ContactListAdapter
import seclass.gatech.contactbook.entities.Contact


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var contactListAdapter : ContactListAdapter


    private val contactViewModel: ContactViewModel by viewModels {
        ContactViewModelFactory((application as ContactApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observerDataChange()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setContactListAdapter(contactList : List<Contact>){
        contactListAdapter = ContactListAdapter(contactList)
        binding.recyclerViewContactBook.adapter = contactListAdapter
        contactListAdapter.notifyDataSetChanged()
    }


    private fun observerDataChange(){

        contactViewModel.allContacts.observe(this) { contactList ->

            if (contactList.isNotEmpty()){
                setContactListAdapter(contactList)
            }else{
                // show no data
                Toast.makeText(this, "no data to show", Toast.LENGTH_SHORT).show()
            }
        }
    }

}