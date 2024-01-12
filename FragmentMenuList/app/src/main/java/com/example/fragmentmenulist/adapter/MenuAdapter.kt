package com.example.fragmentmenulist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fragmentmenulist.databinding.MenuItemBinding
import com.example.fragmentmenulist.model.Menu

class MenuAdapter(private val menuList: List<Menu> , private val onMenuClicked: (Menu) -> Unit) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    inner class MenuViewHolder(private val binding: MenuItemBinding) : RecyclerView.ViewHolder(binding.root) {
        // Implement any ViewHolder specific logic here
        fun bind(menu:Menu){
            binding.tvName.text = menu.name
            binding.tvCategory.text = menu.category
            Glide.with(binding.root.context)
                .load(menu.imgResID)
                .into(binding.ivImg)
            binding.root.setOnClickListener {
                onMenuClicked(menu)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.MenuViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MenuItemBinding.inflate(inflater, parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuAdapter.MenuViewHolder, position: Int) {
        // Implement how data should be bound to the ViewHolder here
        val menu : Menu = menuList[position]
        holder.bind(menu)
    }

    override fun getItemCount(): Int {
        return menuList.size
    }
}
