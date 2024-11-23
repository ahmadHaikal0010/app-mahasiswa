package com.haikal.app_mahasiswa.screen

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.haikal.app_mahasiswa.R
import com.haikal.app_mahasiswa.databinding.ActivityAddMahasiswaBinding
import com.haikal.app_mahasiswa.helper.MahasiswaDatabaseHelper
import com.haikal.app_mahasiswa.model.ModelMahasiswa

class AddMahasiswaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddMahasiswaBinding
    private lateinit var db: MahasiswaDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMahasiswaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = MahasiswaDatabaseHelper(this)

        binding.saveButton.setOnClickListener() {
            val nama = binding.nameEditText.text.toString()
            val nim = binding.nimEditText.text.toString()
            val jurusan = binding.jurusanEditText.text.toString()
            val note = ModelMahasiswa(0, nama, nim, jurusan)
            db.insertNote(note)
            finish()
            Toast.makeText(this, "Data disimpan", Toast.LENGTH_SHORT).show()
        }
    }
}