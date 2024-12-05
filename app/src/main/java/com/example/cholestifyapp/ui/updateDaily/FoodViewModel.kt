package com.example.cholestifyapp.ui.updateDaily

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cholestifyapp.data.response.DataItem
import com.example.cholestifyapp.data.retrofit.ApiService
import kotlinx.coroutines.launch

class FoodViewModel : ViewModel() {

    private val apiService = ApiService.create() // Inisialisasi ApiService
    private val _foodList = MutableLiveData<List<DataItem>>() // Menyimpan daftar makanan
    val foodList: LiveData<List<DataItem>> = _foodList // Membuat LiveData untuk diobserve di Fragment

    // Fungsi untuk mengambil data makanan dari API
    fun getFoodData() {
        viewModelScope.launch {
            try {
                // Memanggil API untuk mendapatkan data makanan
                val response = apiService.getFoods()

                if (response.isSuccessful) {
                    val foodResponse = response.body()
                    // Mengecek apakah data ada dan tidak kosong
                    if (foodResponse?.data.isNullOrEmpty()) {
                        Log.e("FoodViewModel", "No data available")
                        _foodList.value = emptyList() // Jika data kosong, set list kosong
                    } else {
                        Log.d("FoodViewModel", "Data received: ${foodResponse?.data}")
                        _foodList.value = foodResponse?.data?.filterNotNull() ?: emptyList()
                    }
                } else {
                    // Menangani error jika API tidak berhasil
                    Log.e("FoodViewModel", "API error: ${response.message()}")
                    _foodList.value = emptyList() // Set data kosong jika API gagal
                }
            } catch (e: Exception) {
                // Menangani error jika ada exception saat memanggil API
                Log.e("FoodViewModel", "Exception: ${e.message}")
                _foodList.value = emptyList() // Menangani error dengan data kosong
            }
        }
    }
}