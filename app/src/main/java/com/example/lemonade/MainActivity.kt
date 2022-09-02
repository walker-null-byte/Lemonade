package com.example.lemonade

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainImage: ImageView = findViewById(R.id.mainImage)
        var state = "Tree"

        val imageDescription: TextView = findViewById(R.id.imageDescription)
        var text = "Shake the tree!"
        imageDescription.setText(text)

        val squeezes : TextView = findViewById(R.id.squeezes)

        mainImage.setImageResource(R.drawable.lemoontree)
        var randomNumber = 0
        fun random(){
            randomNumber = (1..5).random()
            squeezes.setText((randomNumber+1).toString())
        }
            mainImage.setOnClickListener {
                if (state == "Tree") {
                    mainImage.setImageResource(R.drawable.lemon)
                    state = "Lemon"
                    text = "Squeeze the lemon!"
                    imageDescription.setText(text)
                    random()

                } else if (state == "Lemon") {
                    if (randomNumber == 0 ){
                        mainImage.setImageResource(R.drawable.lemonade)
                        state = "Lemonade"
                        text = "Drink the lemonade!"
                        imageDescription.setText(text)
                        squeezes.setText("")
                    }
                    else{
                        randomNumber--
                        squeezes.setText((randomNumber+1).toString())
                    }

                } else if (state == "Lemonade") {

                    mainImage.setImageResource(R.drawable.emptyglass)
                    state = "Empty"
                    text = "Empty Glass!"
                    imageDescription.setText(text)

                } else {
                    mainImage.setImageResource(R.drawable.lemoontree)
                    state = "Tree"
                    text = "Shake the tree!"
                    imageDescription.setText(text)
                }
            }

    }
}