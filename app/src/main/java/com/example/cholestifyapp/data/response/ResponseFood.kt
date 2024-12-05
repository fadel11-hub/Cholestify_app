package com.example.cholestifyapp.data.response

import com.google.gson.annotations.SerializedName
import java.util.Date

data class ResponseFood(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("error")
	val error: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class DataItem(

	@field:SerializedName("potassium")
	val potassium: Double? = null,

	@field:SerializedName("manganese")
	val manganese: Int? = null,

	@field:SerializedName("vitaminB1")
	val vitaminB1: Double? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,  // Format tanggal bisa dikendalikan lebih lanjut jika diperlukan

	@field:SerializedName("vitaminB2")
	val vitaminB2: Double? = null,

	@field:SerializedName("vitaminB3")
	val vitaminB3: Double? = null,

	@field:SerializedName("dietaryFiber")
	val dietaryFiber: Int? = null,

	@field:SerializedName("selenium")
	val selenium: Int? = null,

	@field:SerializedName("vitaminB5")
	val vitaminB5: Int? = null,

	@field:SerializedName("vitaminB6")
	val vitaminB6: Double? = null,

	@field:SerializedName("protein")
	val protein: Double? = null,

	@field:SerializedName("fat")
	val fat: Double? = null,

	@field:SerializedName("saturatedFats")
	val saturatedFats: Double? = null,

	@field:SerializedName("polyunsaturatedFats")
	val polyunsaturatedFats: Double? = null,

	@field:SerializedName("cholesterol")
	val cholesterol: Int? = null,

	@field:SerializedName("copper")
	val copper: Double? = null,

	@field:SerializedName("vitaminB12")
	val vitaminB12: Double? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("vitaminB11")
	val vitaminB11: Double? = null,

	@field:SerializedName("zinc")
	val zinc: Double? = null,

	@field:SerializedName("phosphorus")
	val phosphorus: Double? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null,  // Format tanggal bisa dikendalikan lebih lanjut jika diperlukan

	@field:SerializedName("carbohydrates")
	val carbohydrates: Double? = null,

	@field:SerializedName("sugars")
	val sugars: Int? = null,

	@field:SerializedName("calcium")
	val calcium: Double? = null,

	@field:SerializedName("vitaminC")
	val vitaminC: Double? = null,

	@field:SerializedName("vitaminE")
	val vitaminE: Double? = null,

	@field:SerializedName("monounsaturatedFats")
	val monounsaturatedFats: Double? = null,

	@field:SerializedName("vitaminD")
	val vitaminD: Int? = null,

	@field:SerializedName("magnesium")
	val magnesium: Double? = null,

	@field:SerializedName("vitaminK")
	val vitaminK: Double? = null,

	@field:SerializedName("nutritionDensity")
	val nutritionDensity: Double? = null,

	@field:SerializedName("water")
	val water: Double? = null,

	@field:SerializedName("food")
	val food: String? = null,

	@field:SerializedName("sodium")
	val sodium: Double? = null,

	@field:SerializedName("caloricValue")
	val caloricValue: Int? = null,

	@field:SerializedName("iron")
	val iron: Double? = null,

	@field:SerializedName("vitaminA")
	val vitaminA: Double? = null
)