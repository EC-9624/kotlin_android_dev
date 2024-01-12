package com.example.eccpizza

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.eccpizza.databinding.FragmentMenuDetailsBinding
import com.example.eccpizza.model.Menu

class MenuDetailFragment : Fragment() {
    private lateinit var binding: FragmentMenuDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuDetailsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        parentFragmentManager.setFragmentResultListener(MenuListFragment.REQUEST_MENU_DETAIL,this){_,bundle->
            val selectedMenu : Menu = bundle.getParcelable("SELECTED_MENU")!!
            binding.tvDetail.text = selectedMenu.detail
            binding.tvPrice.text = "¥" + selectedMenu.price.toString()
            binding.tvName.text = selectedMenu.pname
            Glide.with(binding.root.context)
                .load(selectedMenu.image_url)
                .into(binding.ivImg)
        }
    }
}