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

class EditStudentAvtivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_student_avtivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var nameStudent: EditText = findViewById(R.id.editName)
        var idStudent: EditText = findViewById(R.id.editID)
        var phoneStudent: EditText = findViewById(R.id.editPhone)
        var addressStudent: EditText = findViewById(R.id.editAddress)
        var checkedBoxStudent: CheckBox = findViewById(R.id.checkBoxEdit)

        val studentIndex = intent.getIntExtra("studentPosition",-1)
        val student = StudentListHolder.getStudentByPosition(intent.getIntExtra("studentPosition",-1))

        nameStudent.setText(student.name)
        idStudent.setText(student.id)
        phoneStudent.setText(student.phone)
        addressStudent.setText(student.address)
        checkedBoxStudent.isChecked = student.checked

        findViewById<Button>(R.id.saveButtonEdit)?.setOnClickListener{
            val name = nameStudent?.text.toString()
            val id = idStudent?.text.toString()
            val phone = phoneStudent?.text.toString()
            val address = addressStudent?.text.toString()
            val checked = checkedBoxStudent?.isChecked ?: false
            val student = StudentModel(name, id, phone, address, checked)
            Log.d("AddStudentActivity", "Created student: $student")
            StudentListHolder.editStudent(student,studentIndex)
            finish()
        }

        findViewById<Button>(R.id.deleteButtonEdit).setOnClickListener{
            StudentListHolder.deleteStudent(studentIndex)
            finish()
        }


        findViewById<Button>(R.id.cancelButtonEdit).setOnClickListener{
            finish()
        }
    }
}