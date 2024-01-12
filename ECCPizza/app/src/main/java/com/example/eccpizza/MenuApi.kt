package com.example.eccpizza
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.eccpizza.model.Menu


interface MenuApi {
    @GET("ecc/yishida/pizzaDB.php")
    fun getMenu() : Call<List<Menu>>
}