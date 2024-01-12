package com.example.eccpizza

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.eccpizza.adapter.MenuAdapter
import com.example.eccpizza.databinding.FragmentMenuListBinding
import com.example.eccpizza.model.Menu
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MenuListFragment : Fragment() {
    private lateinit var binding: FragmentMenuListBinding
    private val menuList = mutableListOf<Menu>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =FragmentMenuListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MenuAdapter(menuList) { selectedMenu ->

            parentFragmentManager.setFragmentResult(
                REQUEST_MENU_DETAIL,
                bundleOf("SELECTED_MENU" to selectedMenu)
            )

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, MenuDetailFragment()) // Assuming MenuDetailFragment is the correct target fragment
                .addToBackStack(null)
                .commit()
        }
        fetchData(adapter)



        binding.rvMenuList.adapter = adapter
        binding.rvMenuList.layoutManager = GridLayoutManager(context,2)

    }
    private fun fetchData(adapter: MenuAdapter) {
        menuList.clear()
        var completedRequests = 0  // 成功したAPIリクエストの数をカウントする変数

        val retrofit = Retrofit.Builder()
            .baseUrl("https://click.ecc.ac.jp/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(MenuApi::class.java)

        api.getMenu().enqueue(object : Callback<List<Menu>> {
            override fun onResponse(call: Call<List<Menu>>, response: Response<List<Menu>>) {
                if (response.isSuccessful) {
                    val menuResponses = response.body()
                    if (menuResponses != null) {
                        for (menuResponse in menuResponses) {

                            val menu = Menu(
                                menuResponse.product_no,
                                menuResponse.pname,
                                menuResponse.category,
                                "￥" + menuResponse.price,
                                menuResponse.image_url,
                                menuResponse.detail
                            )
                            Log.d("MenuListFragment", "onResponse: $menu")
                            menuList.add(menu)
                        }
                        adapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<List<Menu>>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })
    }

    companion object{
        val REQUEST_MENU_DETAIL = "REQUEST_MENU_DETAIL"
        val SELECTED_MENU = "SELECTED_MENU"
    }
}