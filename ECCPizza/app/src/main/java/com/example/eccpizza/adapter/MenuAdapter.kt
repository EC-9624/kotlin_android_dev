package com.example.eccpizza.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.eccpizza.databinding.MenuItemBinding
import com.example.eccpizza.model.Menu

class MenuAdapter(private val menuList : List<Menu>, private val onMenuClicked: (Menu) -> Unit) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: MenuItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(menu: Menu) {
            binding.tvName.text = menu.pname
            binding.tvPrice.text = menu.price.toString()
            Glide.with(binding.root.context)
                .load(menu.image_url)
                .into(binding.ivImg)
            binding.root.setOnClickListener {
                onMenuClicked(menu)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MenuItemBinding.inflate(inflater,parent,false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuAdapter.ViewHolder, position: Int) {
        val menu : Menu = menuList[position]
        holder.bind(menu)
    }

    override fun getItemCount(): Int {
        return menuList.size
    }
}