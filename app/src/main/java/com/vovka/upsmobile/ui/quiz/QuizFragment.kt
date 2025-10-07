package com.vovka.upsmobile.ui.quiz


import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.vovka.upsmobile.R
import com.vovka.upsmobile.entity.TestData
import com.vovka.upsmobile.entity.TestItem
import com.vovka.upsmobile.ui.menu.MenuFragment
import com.vovka.upsmobile.ui.result.ResultFragment

class QuizFragment : Fragment() {

    companion object {
        private const val ARG_TEST_ID = "arg_test_id"
        fun newInstance(id: String): QuizFragment = QuizFragment().apply {
            arguments = Bundle().apply { putString(ARG_TEST_ID, id) }
        }
    }

    private var currentIndex = 0
    private var correctCount = 0
    private lateinit var test: TestItem

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_quiz, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = requireArguments().getString(ARG_TEST_ID)
        test = TestData.findTestById(id ?: "") ?: TestData.tests.first()
        view.findViewById<ImageView>(R.id.back).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, MenuFragment())
                .addToBackStack(null)
                .commit()
        }


        view.findViewById<Button>(R.id.buttonAnswer).setOnClickListener {
            val input = view.findViewById<TextInputEditText>(R.id.textinput).text.toString().trim()
            if (input.equals(test.questions[currentIndex].answer.trim(), ignoreCase = true)) {
                correctCount++
            }else{
                view.findViewById<TextView>(R.id.errorText).visibility = View.VISIBLE
                return@setOnClickListener
            }
            currentIndex++
            if (currentIndex >= test.questions.size) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, ResultFragment.newInstance(test.questions.size, correctCount))
                    .addToBackStack(null)
                    .commit()
            } else {
                showQuestion(view)
            }
        }

        showQuestion(view)
    }

    private fun showQuestion(root: View) {
        root.findViewById<TextView>(R.id.textTitleQuiz).text = test.title
        root.findViewById<TextView>(R.id.textQuestion).text = test.questions[currentIndex].text
        root.findViewById<TextInputEditText>(R.id.textinput).setText("")
        root.findViewById<TextView>(R.id.errorText).visibility = View.GONE
        renderProgress(root)
    }

    private fun renderProgress(root: View) {
        val container = root.findViewById<LinearLayout>(R.id.progressContainer)
        container.removeAllViews()
        container.orientation = LinearLayout.HORIZONTAL

        val total = test.questions.size
        val density = resources.displayMetrics.density //dp
        val height = (density * 8).toInt()
        val cornerRadiusDp = 28f
        val cornerRadiusPx = cornerRadiusDp * density
        val margin = (density * 6).toInt()

        for (i in 0 until total) {
            val view = View(requireContext())


            val params = LinearLayout.LayoutParams((density*54).toInt(), height)
            params.setMargins(margin, margin, margin, margin)
            view.layoutParams = params


            val drawable = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = cornerRadiusPx
                setColor(if (i < currentIndex) 0xFFB71C1C.toInt() else 0xFFBDBDBD.toInt())
            }
            view.background = drawable

            container.addView(view)
        }
    }
}



