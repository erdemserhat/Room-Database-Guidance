package com.erdemserhat.room_database_guidance.ui.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.erdemserhat.room_database_guidance.R
import com.erdemserhat.room_database_guidance.data.model.User
import com.erdemserhat.room_database_guidance.viewmodel.UserViewModel
import com.erdemserhat.room_database_guidance.databinding.FragmentAddBinding

class AddFragment : Fragment() {
    private lateinit var binding:FragmentAddBinding
    //declare view-model
    private lateinit var mUserViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater)
        val view = binding.root
        //instantiate view-model
        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        binding.addButton.setOnClickListener {
            insertDataToDatabase()
        }






        return view

    }

    private fun insertDataToDatabase() {
        if(checkInput()){
            val firstName = binding.firstNameET.text
            val lastName = binding.lastNameET.text
            val age = binding.AgeET.text

            //don't worry about id parameter just pass "0" it will  be adjusted.
            val user = User(0,firstName.toString(),lastName.toString(),Integer.parseInt(age.toString()))
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(),"Successfully Added",Toast.LENGTH_SHORT).show()
            //Navigate to list
            findNavController().navigate(R.id.action_addFragment_to_listFragment2)

        }else{
            Toast.makeText(requireContext(),"Please fill out all fields",Toast.LENGTH_SHORT).show()
        }

    }

    private fun checkInput():Boolean {
        return !((TextUtils.isEmpty(binding.firstNameET.toString()) && TextUtils.isEmpty(binding.lastNameET.toString())) && TextUtils.isEmpty(
            binding.AgeET.toString()
        ))
    }


}