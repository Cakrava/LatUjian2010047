package com.example.latihan_api.app

import com.example.latihan_api.model.BarangModel
import com.example.latihan_api.model.ResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("tblProduk/save")
    fun saveBarang(
        @Body data: BarangModel
    ): Call<ResponseModel>

    @GET("barang")
    fun getBarang(): Call<ResponseModel>
}
