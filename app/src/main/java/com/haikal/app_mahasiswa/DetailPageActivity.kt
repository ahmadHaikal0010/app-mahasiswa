package com.haikal.app_mahasiswa

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailPageActivity : AppCompatActivity() {

    private lateinit var txtDetailNama: TextView
    private lateinit var txtDetailNIM: TextView
    private lateinit var txtDetailJurusan: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_page)

        txtDetailNama = findViewById(R.id.txtDetailNama)
        txtDetailNIM = findViewById(R.id.txtDetailNIM)
        txtDetailJurusan = findViewById(R.id.txtDetailJurusan)

        val nama = intent.getStringExtra("nama")
        val nim = intent.getStringExtra("nim")
        val jurusan = intent.getStringExtra("jurusan")

        txtDetailNama.text = nama
        txtDetailNIM.text = nim
        txtDetailJurusan.text = jurusan

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}