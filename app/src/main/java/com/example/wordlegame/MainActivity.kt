package com.example.wordlegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.wordlegame.FourLetterWordList.getRandomFourLetterWord

class MainActivity : AppCompatActivity() {
    var counter = 0;
    var wordToGuess = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)
        textView.visibility = View.INVISIBLE
        textView.text = getRandomFourLetterWord()
        wordToGuess = textView.text as String
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            if(counter < 3){ // if we have less than 3 guesses
                if(counter == 0){ // first guess
                    val guess = findViewById<EditText>(R.id.et_simple)
                    val guess1 = findViewById<TextView>(R.id.textView2)
                    var input = guess.text
                    guess1.text = "Guess #1             " + input
                    val check1 = findViewById<TextView>(R.id.textView3)
                    val simpleEditText = findViewById<View>(R.id.et_simple) as EditText
                    val strValue = simpleEditText.text.toString().uppercase()
                    check1.text = "Guess #1 Check " + checkGuess(strValue)
                    if(checkGuess(strValue) == "OOOO"){
                        Toast.makeText(this, "You have solved the Wordle! Congrats!", Toast.LENGTH_LONG).show()
                    }
                }
                if(counter == 1){ // second guess
                    val guess = findViewById<EditText>(R.id.et_simple)
                    val guess1 = findViewById<TextView>(R.id.textView4)
                    var input = guess.text
                    guess1.text = "Guess #2             " + input
                    val check1 = findViewById<TextView>(R.id.textView5)
                    val simpleEditText = findViewById<View>(R.id.et_simple) as EditText
                    val strValue = simpleEditText.text.toString().uppercase()
                    check1.text = "Guess #2 Check " + checkGuess(strValue)
                    if(checkGuess(strValue) == "OOOO"){
                        Toast.makeText(this, "You have solved the Wordle! Congrats!", Toast.LENGTH_LONG).show()
                    }
                }
                if(counter == 2){ // last guess
                    val guess = findViewById<EditText>(R.id.et_simple)
                    val guess1 = findViewById<TextView>(R.id.textView6)
                    var input = guess.text
                    guess1.text = "Guess #3             " + input
                    val check1 = findViewById<TextView>(R.id.textView7)
                    val simpleEditText = findViewById<View>(R.id.et_simple) as EditText
                    val strValue = simpleEditText.text.toString().uppercase()
                    check1.text = "Guess #3 Check " + checkGuess(strValue)
                    if(checkGuess(strValue) == "OOOO"){
                        Toast.makeText(this, "You have solved the Wordle! Congrats!", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "Sorry, but you have exceeded the number of guesses! The word was " + wordToGuess, Toast.LENGTH_LONG).show()
                        textView.visibility = View.VISIBLE
                        button.visibility = View.INVISIBLE
                    }
                }
            }
            counter++;
        }

    }

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
    private fun checkGuess(guess: String) : String {
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
}