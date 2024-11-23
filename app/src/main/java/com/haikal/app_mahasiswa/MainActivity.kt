package com.haikal.app_mahasiswa

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.haikal.app_mahasiswa.adapter.MahasiswaAdapter
import com.haikal.app_mahasiswa.databinding.ActivityMainBinding
import com.haikal.app_mahasiswa.helper.MahasiswaDatabaseHelper
import com.haikal.app_mahasiswa.screen.AddMahasiswaActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mahasiswaAdapter: MahasiswaAdapter
    private lateinit var db: MahasiswaDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addButton.setOnClickListener {
            val intent = Intent(this, AddMahasiswaActivity::class.java)
            startActivity(intent)
        }

        db = MahasiswaDatabaseHelper(this)
        mahasiswaAdapter = MahasiswaAdapter(db.getAllNotes(), this)

        binding.mahasiswaRecycleview.layoutManager = LinearLayoutManager(this)
        binding.mahasiswaRecycleview.adapter = mahasiswaAdapter
    }

    override fun onResume() {
        super.onResume()
        val mahasiswa = db.getAllNotes()
        mahasiswaAdapter.refreshData(mahasiswa)
    }
}