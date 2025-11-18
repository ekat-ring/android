package com.example.newosnewproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ExamItem {
    var examName: String? = null
    var examDate: String? = null
    var examMessage: String? = null

    constructor(examName:String, examDate:String, examMessage:String){
        this.examName = examName
        this.examDate = examDate
        this.examMessage = examMessage
    }

}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Sample data
        val examList: MutableList<ExamItem> = ArrayList()


        examList.add(
            ExamItem(
                "Microcontrollers",
                "??/12/2025",
                "You can do it. I think."
            )
        )

        examList.add(
            ExamItem(
                "Robotics",
                "??/12/2025",
                "No idea what can happen."
            )
        )

        examList.add(
            ExamItem(
                "English",
                "??/12/2025",
                "Pfffft, easy!"
            )
        )

        examList.add(
            ExamItem(
                "Statistics",
                "??/12/2025",
                "You can do it!"
            )
        )

        examList.add(
            ExamItem(
                "ODE",
                "09/01/2026",
                "It's worse than you think"
            )
        )
        examList.add(
            ExamItem(
                "QM",
                "17/01/2026",
                "Morituri te salutant"
            )
        )

        recyclerView.layoutManager = LinearLayoutManager(this)

        // Set Adapter
        val adapter = MyAdapter(examList)
        recyclerView.adapter = adapter
    }
}

class MyAdapter(private val examList: List<ExamItem>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.text_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val examItem = examList[position]

        holder.examName.text = examItem.examName
        holder.examDate.text = examItem.examDate
        holder.examMessage.text = examItem.examMessage

       // if(examItem.examPic != null)
       //     holder.examPic.setImageResource(examItem.examPic!!)

    }

    override fun getItemCount(): Int {
        return examList.size
    }

    // ViewHolder class
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val examName: TextView = itemView.findViewById(R.id.examName)
        val examDate: TextView = itemView.findViewById(R.id.examDate)
        val examMessage: TextView = itemView.findViewById(R.id.examMessage)
      //  val examPic: ImageView = itemView.findViewById(R.id.examPic)

    }
}