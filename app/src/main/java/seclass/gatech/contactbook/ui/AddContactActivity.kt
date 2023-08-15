package seclass.gatech.contactbook.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import seclass.gatech.contactbook.databinding.ActivityAddContactBinding

class AddContactActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}