package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var textResult: TextView //data member 可以慢點初始化內部的東西
    lateinit var diceImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        diceImage = findViewById(R.id.dice_image)
        textResult = findViewById(R.id.text_result)


        rollButton.setOnClickListener{rollDice()} //lambda expression
    }

    private fun rollDice(){

        //下方出現彈跳視窗（Toast） 又叫做 chaining call
        //Toast.makeText(this,"button clicked",Toast.LENGTH_SHORT) .show()

        val randomInt = (1..6).random()

        //type conversion
        textResult.text = randomInt.toString()

        val drawableResource = when(randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }

        //set image source to imageView
        diceImage.setImageResource(drawableResource)


    }
}