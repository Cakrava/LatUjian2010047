package com.example.latihan_api.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.latihan_api.adapter.AdapterBarang
import com.example.latihan_api.app.ApiConfig
import com.example.latihan_api.R
import com.example.latihan_api.model.BarangModel
import com.example.latihan_api.model.ResponseModel
import retrofit2.Call
import retrofit2.Response

class HomeFragment : Fragment() {

//
lateinit var rvBarang: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        init(view)
        getBarang()
        return view
    }

    private var listBarang: ArrayList<BarangModel> = ArrayList()

    fun getBarang(){
        ApiConfig.instanceRetrofit.getBarang().enqueue(object :
            retrofit2.Callback<ResponseModel> {

            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                val res = response.body()!!
                listBarang = res.barang
                displayBarang()
            }
            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Toast.makeText(requireActivity(), "Error :"+t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun displayBarang() {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        rvBarang.adapter = AdapterBarang(requireActivity(), listBarang)
        rvBarang.layoutManager = layoutManager
    }

    fun init(view: View) {
        //rvBarang = view.findViewById(R.id.recyler_view)
        rvBarang=view.findViewById(R.id.recyler_view)
    }

}