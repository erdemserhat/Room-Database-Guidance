package com.erdemserhat.room_database_guidance.ui.fragments.update

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.erdemserhat.room_database_guidance.R

import com.erdemserhat.room_database_guidance.data.model.User
import com.erdemserhat.room_database_guidance.viewmodel.UserViewModel
import com.erdemserhat.room_database_guidance.databinding.FragmentUpdateBinding
import com.erdemserhat.room_database_guidance.ui.fragments.list.UserRecyclerViewAdapter

class UpdateFragment : Fragment() {
    private lateinit var mUserViewModel: UserViewModel
    private lateinit var binding:FragmentUpdateBinding
    private val args by navArgs<UpdateFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdateBinding.inflate(inflater)
        val view = binding.root
        val selectedUser = UserRecyclerViewAdapter.selectedUser.user

        //init viewmodel
        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]



        binding.editFirstNameET.setText(args.currentUser.firstName)
        binding.editLastName.setText(args.currentUser.lastName)
        binding.editAgeET.setText(args.currentUser.age.toString())




        /*
        binding.editFirstNameET.setText(selectedUser?.firstName.toString())
        binding.editLastName.setText(selectedUser?.lastName.toString())
        selectedUser?.age?.let { binding.editAgeET.setText(it.toString()) }

         */

        binding.uploadButton.setOnClickListener {
            if(checkInput()){
                selectedUser?.firstName=binding.editFirstNameET.text.toString();
                selectedUser?.lastName=binding.editLastName.text.toString();
                selectedUser?.age=Integer.parseInt(binding.editAgeET.text.toString())
                mUserViewModel.updateUser(selectedUser!!)

                findNavController().navigate(R.id.action_updateFragment_to_listFragment)


            }
        }








        return view
    }

    private fun checkInput():Boolean {
        return !((TextUtils.isEmpty(binding.editFirstNameET.toString()) && TextUtils.isEmpty(binding.editLastName.toString())) && TextUtils.isEmpty(
            binding.editAgeET.toString()
        ))
    }


}