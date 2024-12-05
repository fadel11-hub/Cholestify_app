package com.example.cholestifyapp.ui.updateDaily

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cholestifyapp.R
import com.example.cholestifyapp.adapter.FoodAdapter
import com.example.cholestifyapp.databinding.FragmentUpdateDailyBinding

class UpdateDailyFragment : Fragment() {

    private var _binding: FragmentUpdateDailyBinding? = null
    private val binding get() = _binding!!

    private lateinit var foodAdapter: FoodAdapter
    private lateinit var foodViewModel: FoodViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUpdateDailyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi FoodViewModel
        foodViewModel = ViewModelProvider(this).get(FoodViewModel::class.java)

        // Inisialisasi Adapter dan RecyclerView
        foodAdapter = FoodAdapter(emptyList()) { food ->
            // Tangani klik item jika diperlukan
        }
        binding.rvFood.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFood.adapter = foodAdapter

        // Ambil data makanan dari FoodViewModel
        foodViewModel.foodList.observe(viewLifecycleOwner) { foodList ->
            if (foodList.isNullOrEmpty()) {
                Toast.makeText(requireContext(), "No data available", Toast.LENGTH_SHORT).show()
            } else {
                foodAdapter.updateData(foodList)
            }
        }

        // Ambil data makanan dari API
        foodViewModel.getFoodData()

        // Tombol kembali
        binding.toolbar.findViewById<View>(R.id.Back).setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}