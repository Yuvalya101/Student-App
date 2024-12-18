package com.example.studentlist

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddStudentActivity : AppCompatActivity() {
    var nameTextField: EditText? = null
    var idTextField: EditText? = null
    var saveButton: Button? = null
    var cancelButton: Button? = null
    var phoneTextField: EditText? = null
    var addressTextField: EditText? = null
    var checkedBox: CheckBox? = null




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
        nameTextField = findViewById(R.id.addName)
        idTextField = findViewById(R.id.addID)
        saveButton = findViewById(R.id.saveButton)
        cancelButton = findViewById(R.id.cancelButton)
        phoneTextField = findViewById(R.id.addPhone)
        addressTextField = findViewById(R.id.addAddress)
        checkedBox = findViewById(R.id.checkedBox)

        cancelButton?.setOnClickListener{
            finish()
        }

        saveButton?.setOnClickListener{
            val name = nameTextField?.text.toString()
            val id = idTextField?.text.toString()
            val phone = phoneTextField?.text.toString()
            val address = addressTextField?.text.toString()
            val checked = checkedBox?.isChecked ?: false
            val student = StudentModel(name, id, phone, address, checked)
            Log.d("AddStudentActivity", "Created student: $student")
            StudentListHolder.addStudent(student)
            finish()
        }

    }
}