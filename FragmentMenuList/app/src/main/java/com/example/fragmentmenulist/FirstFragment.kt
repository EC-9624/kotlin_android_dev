package com.example.fragmentmenulist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fragmentmenulist.adapter.MenuAdapter
import com.example.fragmentmenulist.databinding.FragmentFirstBinding
import com.example.fragmentmenulist.model.Menu

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menulist = listOf(
            Menu(getString(R.string.text_cheese_doria_name),getString(R.string.text_cheese_doria_category),getString(R.string.text_cheese_doria_doria_detail),R.drawable.doria),
            Menu(getString(R.string.text_cheese_salad_name),getString(R.string.text_cheese_salad_category),getString(R.string.text_cheese_salad_detail),R.drawable.sarada),
            Menu(getString(R.string.text_corn_soup_name),getString(R.string.text_corn_soup_category),getString(R.string.text_corn_soup_detail),R.drawable.cornsoup),
            Menu(getString(R.string.text_hamburg_name),getString(R.string.text_hamburg_category),getString(R.string.text_hamburg_detail),R.drawable.hamburg)

        )

        val adapter = MenuAdapter(menulist){ selectedMenu ->
            parentFragmentManager.setFragmentResult(
                REQUEST_MENU_DETAIL,
                bundleOf("SELECTED_MENU" to selectedMenu)
            )

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView2,SecondFragment())
                .addToBackStack(null)
                .commit()
        }
        binding.rvProfilelist.adapter = adapter
        binding.rvProfilelist.layoutManager = GridLayoutManager(context,2)
    }

    companion object{
        val REQUEST_MENU_DETAIL = "REQUEST_MENU_DETAIL"
    }
}