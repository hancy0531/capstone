package com.example.plant

import RecyclerViewPlantAdapter
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Fragment_Home : Fragment() {
    @SuppressLint("MissingInflatedId")
    private lateinit var recyclerView: RecyclerView
    private lateinit var enrollBtn: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment__home, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        enrollBtn = view.findViewById(R.id.button)

        recyclerView.adapter = RecyclerViewPlantAdapter(Fragment_Garden.getPlantList())
        recyclerView.setLayoutManager(LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false))
        recyclerView.addItemDecoration(RecyclerViewDecoration(20))
        val intent = Intent(requireContext(), PlantEnrollActivity::class.java)
        enrollBtn.setOnClickListener {
            startActivity(intent)
        }


        return view
    }
}
