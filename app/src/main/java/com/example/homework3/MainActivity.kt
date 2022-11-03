package com.example.homework3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvRiddle =findViewById<TextView>(R.id.riddle)
        val edAnswer = findViewById<TextView>(R.id.yourguess)
        val tvResult = findViewById<TextView>(R.id.result)
        val btnQuestion = findViewById<Button>(R.id.go_q)
        val btnAnswer = findViewById<Button>(R.id.ans_q)
        val btnReAnswer = findViewById<Button>(R.id.reans)
        val btnShowAnswer = findViewById<Button>(R.id.answer)

        var index = 0
        val riddleList = mutableListOf("72小時，猜一個字。:晶","守門員，猜一個字。:閃","夜半鐘聲，猜一個成語。:一鳴驚人","油漆工人，猜一個成語。:好色之徒","How to make a witch itch?:take away her W","What you call a blind deer?:no-eye deer")
        edAnswer.text = null
        tvResult.text = null
        btnQuestion.setOnClickListener {
            val countRiddle = riddleList.count()
            val (riddle,answer) = riddleList[(Math.random()*6).toInt()].split(":")
            tvRiddle.text = "謎題:"+riddle
            //index++
            //if (index>=countRiddle)index = 0

            btnAnswer.setOnClickListener {
                val ans = edAnswer.text
                if (ans.toString()==answer){
                    tvResult.text = "好棒!你答對了!"
                    Toast.makeText(this,edAnswer.text,Toast.LENGTH_SHORT).show()
                }
                else{
                    tvResult.text = "沒猜對，在試一次吧!"
                    //Toast.makeText(this,edAnswer.text,Toast.LENGTH_SHORT).show()
                }
            }
            btnReAnswer.setOnClickListener {
                edAnswer.text = null
                tvResult.text = null
            }
            btnShowAnswer.setOnClickListener {
                tvResult.text = "謎底是: "+answer
            }
        }
    }
}
