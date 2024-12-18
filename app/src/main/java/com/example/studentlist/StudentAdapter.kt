package com.example.studentlist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(val studentList: List<StudentModel>):
    RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameStudentView: TextView = itemView.findViewById(R.id.nameStudentView)
        val idStudentView: TextView = itemView.findViewById(R.id.idStudentview)
        val checkedBoxView: CheckBox = itemView.findViewById(R.id.checkedBoxView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.student_list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = studentList[position]
        holder.nameStudentView.text = currentItem.name
        holder.idStudentView.text = currentItem.id
        holder.checkedBoxView.isChecked = currentItem.checked
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context,StudentDetails::class.java)
            intent.putExtra("studentPosition",position)
            holder.itemView.context.startActivity(intent)
        }
        holder.checkedBoxView.setOnClickListener{
            StudentListHolder.editStudent(currentItem.copy(checked = holder.checkedBoxView.isChecked), position)
            notifyItemChanged(position)
        }
    }

}