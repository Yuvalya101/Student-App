package com.example.studentlist

object StudentListHolder {
    private val studentList = mutableListOf(StudentModel("John Doe", "123456", "1234567890", "123 Main St", false))

    fun addStudent(student: StudentModel) {
        studentList.add(student)
    }

    fun removeStudent(student: StudentModel) {
        studentList.remove(student)
    }

    fun getStudentList(): List<StudentModel> {
        return studentList
    }

    fun editStudent(newStudent: StudentModel, index: Int) {
        studentList[index] = newStudent
    }
}