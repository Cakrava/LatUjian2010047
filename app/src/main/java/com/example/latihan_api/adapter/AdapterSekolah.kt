package com.example.latihan_api.adapter
import android.annotation. SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.latihan_api.R
import com.example.latihan_api.model.SekolahModel
import com.squareup.picasso.Picasso import kotlin.collections.ArrayList

class AdapterSekolah (var activity: Activity, var data: ArrayList<SekolahModel>): RecyclerView.Adapter<AdapterSekolah.Holder>() {
    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val tvkode = view.findViewById<TextView>(R.id.tvkode)
        val tvnama = view.findViewById<TextView>(R.id.tvnama)
        val tvalamat = view.findViewById<TextView> (R.id.tvalamat)
      val tvuangmasuk = view.findViewById<TextView> (R.id.tvuangmasuk)
        val foto = view.findViewById<ImageView> (R.id.foto)
    }

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.sekolah, parent,false)
        return Holder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val a = data[position]
        holder.tvkode.text = a.kdsekolah
        holder.tvnama.text = a.nmsekolah
        holder.tvalamat.text=a.alamat
        holder.tvuangmasuk.text=a.uangmasuk

        val image = "http://192.168.17.245/laravel_1/storage/app/public/" + a.foto

        Picasso.get()
            .load(image)
            .into(holder.foto)

    }

    override fun getItemCount(): Int {
        return data.size
    }
}