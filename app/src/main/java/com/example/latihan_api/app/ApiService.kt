package com.example.latihan_api.app

import com.example.latihan_api.model.SekolahModel
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
        @Body data: SekolahModel
    ): Call<ResponseModel>

    @GET("sekolah")
    fun getSekolah(): Call<ResponseModel>
}
