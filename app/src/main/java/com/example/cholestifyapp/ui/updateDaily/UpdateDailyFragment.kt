package com.example.cholestifyapp.ui.updateDaily

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cholestifyapp.R
import com.example.cholestifyapp.adapter.FoodAdapter
import com.example.cholestifyapp.data.retrofit.ApiService
import com.example.cholestifyapp.databinding.FragmentUpdateDailyBinding
import kotlinx.coroutines.launch

class UpdateDailyFragment : Fragment() {

    private var _binding: FragmentUpdateDailyBinding? = null
    private val binding get() = _binding!!

    private lateinit var foodAdapter: FoodAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUpdateDailyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi RecyclerView
        foodAdapter = FoodAdapter(emptyList())
        binding.rvFood.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = foodAdapter
        }

        // Ambil data makanan
        fetchFoods()

        // Tombol kembali
        binding.toolbar.findViewById<View>(R.id.Back).setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun fetchFoods() {
        val apiService = ApiService.create() // Inisialisasi instance ApiService

        // Menggunakan Coroutine untuk memanggil API
        lifecycleScope.launch {
            try {
                val response = apiService.getFoods()
                if (response.isSuccessful) {
                    val foodResponse = response.body()
                    val foodList = foodResponse?.data ?: emptyList()
                    foodAdapter.updateData(foodList) // Update RecyclerView dengan data baru
                } else {
                    Toast.makeText(requireContext(), "Failed to fetch data", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}