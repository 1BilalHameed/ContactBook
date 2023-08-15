package seclass.gatech.contactbook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import seclass.gatech.contactbook.databinding.ItemContactBookBinding
import seclass.gatech.contactbook.entities.Contact

class ContactListAdapter(private val contactList: List<Contact>) :
    RecyclerView.Adapter<ContactListAdapter.ContactViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding =
            ItemContactBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding, binding.root)
    }

    override fun getItemCount(): Int = contactList.size

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {

        val contact = contactList[position]
        holder.bind(contact)

    }

    inner class ContactViewHolder(private val binding: ItemContactBookBinding, itemView: View) :
        ViewHolder(itemView) {
        fun bind(contact: Contact) {
            binding.textViewContactName.text = contact.contactName
            binding.textViewContactNumber.text = contact.contactNumber
        }

    }


}