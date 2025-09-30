package com.vovka.upsmobile.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vovka.upsmobile.R

import com.vovka.upsmobile.entity.TestData
import com.vovka.upsmobile.ui.map.MapFragment
import com.vovka.upsmobile.ui.quiz.QuizFragment
class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(requireContext())


                recycler.adapter = TestListAdapter(TestData.tests, context = requireActivity()!!) { test ->
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, QuizFragment.newInstance(test.id))
                        .addToBackStack(null)
                        .commit()
                }

        view.findViewById<Button>(R.id.mapButton).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer,MapFragment())
                .commit()
        }
    }
}





