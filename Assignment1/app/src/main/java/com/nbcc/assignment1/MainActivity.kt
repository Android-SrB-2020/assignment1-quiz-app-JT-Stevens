package com.nbcc.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.databinding.DataBindingUtil
import com.nbcc.assignment1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var questionIndex = 0
    private lateinit var question : Question

    private lateinit var questionBank: List<Question>

    private lateinit var questionView: TextView
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

         questionBank = listOf(
            Question(getString(R.string.question_1), false),
            Question(getString(R.string.question_2), true),
            Question(getString(R.string.question_3), true),
            Question(getString(R.string.question_4), false),
            Question(getString(R.string.question_5), false),
            Question(getString(R.string.question_6), true),
            Question(getString(R.string.question_7), false),
            Question(getString(R.string.question_8), true),
            Question(getString(R.string.question_9), false),
            Question(getString(R.string.question_10), false),
            Question(getString(R.string.question_11), false),
            Question(getString(R.string.question_12), true),
            Question(getString(R.string.question_13), false),
            Question(getString(R.string.question_14), true),
            Question(getString(R.string.question_15), false),
            Question(getString(R.string.question_16), false),
            Question(getString(R.string.question_17), true),
            Question(getString(R.string.question_18), false),
            Question(getString(R.string.question_19), false),
            Question(getString(R.string.question_20), true)
        )

        question = questionBank[questionIndex]

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.question = question

        binding.nextButton.setOnClickListener{
            nextQuestion()
        }

        binding.previousButton.setOnClickListener{
            previousQuestion()
        }

        binding.trueButton.setOnClickListener{
            isTrue()
        }

        binding.falseButton.setOnClickListener{
            isFalse()
        }
    }

    /**
     * Changes the text view to the next question.
     */
    private fun nextQuestion(){
        binding.apply {
            questionIndex++
            question = questionBank[questionIndex % questionBank.count()]
        }
    }

    /**
     * Changes the tet view to the previous question
     */
    private fun previousQuestion(){
        binding.apply {
            questionIndex += 19
            question = questionBank[questionIndex % questionBank.count()]
        }
    }

    /**
     * Shows a Correct or Wrong toast if the answer to the current question is true.
     */
    private fun isTrue(){
        if (question.answer){
            Toast.makeText(this, "Correct!", LENGTH_SHORT).show()
        } else{
            Toast.makeText(this, "Wrong!", LENGTH_SHORT).show()
        }
    }

    /**
     * Shows a Correct or Wrong toast if the answer to the current question is false.
     */
    private fun isFalse(){
        if (!question.answer){
            Toast.makeText(this, "Correct!", LENGTH_SHORT).show()

        } else{
            Toast.makeText(this, "Wrong!", LENGTH_SHORT).show()
        }
    }
}
