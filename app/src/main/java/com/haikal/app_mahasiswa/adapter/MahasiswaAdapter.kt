package com.haikal.app_mahasiswa.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.haikal.app_mahasiswa.R
import com.haikal.app_mahasiswa.helper.MahasiswaDatabaseHelper
import com.haikal.app_mahasiswa.model.ModelMahasiswa

class MahasiswaAdapter(
    private var mahasiswa: List<ModelMahasiswa>,
    context: Context
): RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>() {

    private val db : MahasiswaDatabaseHelper = MahasiswaDatabaseHelper(context)

    class MahasiswaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val txtNama: TextView = itemView.findViewById(R.id.txtNama)
        val txtNIM: TextView = itemView.findViewById(R.id.txtNIM)
        val txtJurusan: TextView = itemView.findViewById(R.id.txtJurusan)
        val cardMahasiswa: CardView = itemView.findViewById(R.id.cardMahasiswa)
        val btnEdit: ImageView = itemView.findViewById(R.id.btnEdit)
        val btnDelete: ImageView = itemView.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mahasiswa, parent, false)

        return MahasiswaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mahasiswa.size
    }

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        val mahasiswaData = mahasiswa[position]
        holder.txtNama.text = mahasiswaData.nama
        holder.txtNIM.text = mahasiswaData.nim
        holder.txtJurusan.text = mahasiswaData.jurusan
    }

    fun refreshData(newNotes: List<ModelMahasiswa>) {
        mahasiswa = newNotes
        notifyDataSetChanged()
    }

}