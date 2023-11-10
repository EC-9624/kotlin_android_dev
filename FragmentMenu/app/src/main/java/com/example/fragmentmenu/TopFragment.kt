package com.example.fragmentmenu

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TopFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TopFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        Log.d("TopFragment","onCreate() Called")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("TopFragment","onCreateView() Called")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("TopFragment","onActivityCreated() Called")

    }

    override fun onStart() {
        super.onStart()
        Log.d("TopFragment","onStart() Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TopFragment","onResume() Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TopFragment","onPause() Called")

    }

    override fun onStop() {
        super.onStop()
        Log.d("TopFragment","onStop() Called")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("TopFragment","onDestroyView() Called")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TopFragment","onDestroy() Called")

    }

    override fun onDetach() {
        super.onDetach()
        Log.d("TopFragment","onDetach() Called")

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("TopFragment","onAttach() Called")

    }

    companion object {

        @JvmStatic
        fun newInstance() = TopFragment()
    }
}

