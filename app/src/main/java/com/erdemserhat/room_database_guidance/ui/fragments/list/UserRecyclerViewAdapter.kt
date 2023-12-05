    package com.erdemserhat.room_database_guidance.ui.fragments.list

    import android.os.Bundle
    import android.view.LayoutInflater
    import android.view.ViewGroup
    import androidx.navigation.findNavController
    import androidx.recyclerview.widget.RecyclerView
    import com.erdemserhat.room_database_guidance.R
    import com.erdemserhat.room_database_guidance.data.model.User
    import com.erdemserhat.room_database_guidance.databinding.RecyclerRowBinding

    class UserRecyclerViewAdapter():RecyclerView.Adapter<UserRecyclerViewAdapter.UserHolder>() {
        private var userList = emptyList<User>()
        object selectedUser {
            var user:User? = null
        }
        // Using the activityViewModels() Kotlin property delegate from the
        // fragment-ktx artifact to retrieve the ViewModel in the activity scope.



        class UserHolder(val binding:RecyclerRowBinding):RecyclerView.ViewHolder(binding.root){


        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
            val binding : RecyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)

            return UserHolder(binding)
        }

        override fun getItemCount(): Int {
            return userList.size

        }

        override fun onBindViewHolder(holder: UserHolder, position: Int) {
            val currentItem = userList[position]

            holder.binding.orderId.text=currentItem.id.toString()
            holder.binding.recyclerviewAgeTV.text=currentItem.age.toString()
            holder.binding.recyclerviewLastNameTV.text=currentItem.lastName
            holder.binding.recyclerviewFirstNameTV.text = currentItem.firstName

            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)




            holder.binding.recyclerRowItem.setOnClickListener{

               // selectedUser.user = currentItem

                //holder.itemView.findNavController().navigate(R.id.action_listFragment_to_updateFragment)
                holder.itemView.findNavController().navigate(action)


            }
        }

        fun setData(user:List<User>){
            this.userList = user
            this.notifyDataSetChanged()
        }
    }