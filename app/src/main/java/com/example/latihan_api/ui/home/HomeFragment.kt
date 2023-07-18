package com.example.latihan_api.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.latihan_api.adapter.AdapterSekolah
import com.example.latihan_api.app.ApiConfig
import com.example.latihan_api.R
import com.example.latihan_api.model.SekolahModel
import com.example.latihan_api.model.ResponseModel
import retrofit2.Call
import retrofit2.Response

class HomeFragment : Fragment() {

//
lateinit var rvSekolah: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        init(view)
        getSekolah()
        return view
    }

    private var listSekolah: ArrayList<SekolahModel> = ArrayList()

    fun getSekolah(){
        ApiConfig.instanceRetrofit.getSekolah().enqueue(object :
            retrofit2.Callback<ResponseModel> {

            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                val res = response.body()!!
                listSekolah = res.sekolah
                displaySekolah()
            }
            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Toast.makeText(requireActivity(), "Error :"+t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun displaySekolah() {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        rvSekolah.adapter = AdapterSekolah(requireActivity(), listSekolah)
        rvSekolah.layoutManager = layoutManager
    }

    fun init(view: View) {
        //rvSekolah = view.findViewById(R.id.recyler_view)
        rvSekolah=view.findViewById(R.id.recyler_view)
    }

}