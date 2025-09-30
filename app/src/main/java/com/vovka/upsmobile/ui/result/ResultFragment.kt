package com.vovka.upsmobile.ui.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.vovka.upsmobile.R
import com.vovka.upsmobile.ui.menu.MenuFragment

class ResultFragment : Fragment() {

    companion object {
        private const val ARG_TOTAL = "arg_total"
        private const val ARG_CORRECT = "arg_correct"
        fun newInstance(total: Int, correct: Int): ResultFragment = ResultFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_TOTAL, total)
                putInt(ARG_CORRECT, correct)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_result, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val total = requireArguments().getInt(ARG_TOTAL)
        val correct = requireArguments().getInt(ARG_CORRECT)
        val success = correct == total && total > 0

        view.findViewById<Button>(R.id.buttonToBackList).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, MenuFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}
