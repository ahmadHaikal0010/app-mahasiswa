package com.haikal.app_mahasiswa.screen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.haikal.app_mahasiswa.R
import com.haikal.app_mahasiswa.databinding.ActivityUpdateNoteBinding
import com.haikal.app_mahasiswa.helper.MahasiswaDatabaseHelper
import com.haikal.app_mahasiswa.model.ModelMahasiswa

class UpdateMahasiswaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateNoteBinding
    private lateinit var db: MahasiswaDatabaseHelper
    private var id: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUpdateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = MahasiswaDatabaseHelper(this)
        var noteId = intent.getIntExtra("note_id", -1)
        if (noteId == -1) {
            finish()
            return
        }

        val mahasiswa = db.getNoteById(noteId)
        binding.etEditNama.setText(mahasiswa.nama)
        binding.etEditNIM.setText(mahasiswa.nim)
        binding.etEditJurusan.setText(mahasiswa.jurusan)

        binding.btnUpdateNote.setOnClickListener() {
            val nama = binding.etEditNama.text.toString()
            val nim = binding.etEditNIM.text.toString()
            val jurusan = binding.etEditJurusan.text.toString()

            val updateMahasiswa = ModelMahasiswa(noteId, nama, nim, jurusan)
            db.updateNote(updateMahasiswa)
            finish()
        }
    }
}