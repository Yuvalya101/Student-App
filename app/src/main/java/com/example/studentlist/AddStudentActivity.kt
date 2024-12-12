package com.example.studentlist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddStudentActivity : AppCompatActivity() {
    var nameTextField: EditText? = null
    var idTextField: EditText? = null
    var massegeTextView: TextView? = null
    var saveButton: Button? = null
    var cancelButton: Button? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupUI()
    }
    private fun setupUI(){
        nameTextField = findViewById(R.id.editName)
        idTextField = findViewById(R.id.editID)
        massegeTextView = findViewById(R.id.massageSave)
        saveButton = findViewById(R.id.saveButton)
        cancelButton = findViewById(R.id.cancelButton)

        cancelButton?.setOnClickListener{
            finish()
        }

        saveButton?.setOnClickListener{
            val name = nameTextField?.text.toString()
            massegeTextView?.text = name + " saved"
        }

    }
}