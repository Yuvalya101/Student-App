package com.example.studentlist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StudentDetails : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_student_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var nameStudent: TextView = findViewById(R.id.nameViewDetail)
        var idStudent: TextView = findViewById(R.id.idViewDetail)
        var phoneStudent: TextView = findViewById(R.id.phoneViewDetail)
        var addressStudent: TextView = findViewById(R.id.addressViewDetail)
        var checkedBoxStudent: CheckBox = findViewById(R.id.checkBoxViewDetails)

        val studentIndex = intent.getIntExtra("studentPosition",-1)
        val student = StudentListHolder.getStudentByPosition(studentIndex)


        nameStudent.text = student.name
        idStudent.text = student.id
        phoneStudent.text = student.phone
        addressStudent.text = student.address
        checkedBoxStudent.isChecked = student.checked


        findViewById<Button>(R.id.backButton).setOnClickListener{
            finish()
        }



        findViewById<Button>(R.id.editButton).setOnClickListener{
            val intent = Intent(this, EditStudentAvtivity::class.java)
            intent.putExtra("studentPosition",studentIndex)
            startActivity(intent)
            finish()

        }

    }
}