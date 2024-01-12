package com.example.fragmentmenulist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.fragmentmenulist.databinding.FragmentSecondBinding
import com.example.fragmentmenulist.model.Menu

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        parentFragmentManager.setFragmentResultListener(FirstFragment.REQUEST_MENU_DETAIL,this){ _,bundle ->
        val selectedMenu : Menu = bundle.getParcelable("SELECTED_MENU")!!
            binding.tvName.text = selectedMenu.name
            binding.tvDetail.text = selectedMenu.detail
            binding.tvType.text = selectedMenu.category
            Glide.with(binding.root.context)
                .load(selectedMenu.imgResID)
                .into(binding.ivProfile)
        }
    }
}
