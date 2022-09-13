package com.example.firstwordleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.firstwordleapp.FourLetterWordList.FourLetterWordList.getRandomFourLetterWord

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.enterbutton)
        val guess = findViewById<EditText>(R.id.guess)
        var answer = findViewById<TextView>(R.id.wordview)
        var guessone = findViewById<TextView>(R.id.guessoneanswer)
        var guessonecheck = findViewById<TextView>(R.id.guessonecheckanswer)
        var guesstwo = findViewById<TextView>(R.id.guesstwoanswer)
        var guesstwocheck = findViewById<TextView>(R.id.guesstwocheckanswer)
        var guessthree = findViewById<TextView>(R.id.guessthreeanswer)
        var guessthreecheck = findViewById<TextView>(R.id.guessthreecheckanswer)
        var wordToGuess = getRandomFourLetterWord()


        Toast.makeText(this, wordToGuess, Toast.LENGTH_SHORT).show()

        /**
         * Parameters / Fields:
         *   wordToGuess : String - the target word the user is trying to guess
         *   guess : String - what the user entered as their guess
         *
         * Returns a String of 'O', '+', and 'X', where:
         *   'O' represents the right letter in the right place
         *   '+' represents the right letter in the wrong place
         *   'X' represents a letter not in the target word
         */
        fun checkGuess(guess: String) : String {
            var result = ""
            for (i in 0..3) {
                if (guess[i] == wordToGuess[i]) {
                    result += "O"
                }
                else if (guess[i] in wordToGuess) {
                    result += "+"
                }
                else {
                    result += "X"
                }
            }
            return result

        }

        val text = guess.text
        //while (checkGuess(text.toString().uppercase()) != "OOOO"){

            var yes = guessonecheck.text; guesstwocheck.text; guessthreecheck.text
            var times = 0

            button.setOnClickListener {
                times = 1
                guessone.text = text
                guessonecheck.text = checkGuess(text.toString().uppercase())

                if (times == 1) {
                    button.setOnClickListener {
                        times += 1
                        guesstwo.text = text
                        guesstwocheck.text = checkGuess(text.toString().uppercase())
                    }
                }

                else if (times == 2) {
                    button.setOnClickListener {
                        guessthree.text = text
                        guessthreecheck.text = checkGuess(text.toString().uppercase())
                        times += 1
                    }
                }

                else if (checkGuess(text.toString().uppercase()) == "OOOO") {
                    Toast.makeText(this, "Good Job!", Toast.LENGTH_SHORT).show()
                    answer.text = "Answer- " + wordToGuess
                    times = 0
                }

                else if (times == 3){
                    answer.text = "Answer- " + wordToGuess
                    Toast.makeText(this, "No more guesses", Toast.LENGTH_LONG).show()
                    button.visibility = View.INVISIBLE

                }
                else{
                    times += 1
                }
            }






       // }





















    }
}