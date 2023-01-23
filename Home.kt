package com.example.weatherapp
import com.example.weatherapp.retrofit.APIStuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*
import android.view.View
import android.content.Intent
class home : AppCompatActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
setContentView(R.layout.activity_home)
jan.setOnClickListener{
val jsonObject = JsonObject()
jsonObject.addProperty("text", "around 20")
APIStuff.service.postTemp(jsonObject).enqueue(object : Callback<ResponseBody> {
override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
println("---TTTT :: POST Throwable EXCEPTION:: " + t.message)
}
override fun onResponse(call: Call<ResponseBody>, response:

Response<ResponseBody>) {

if (response.isSuccessful) {
val msg = response.body()?.string()
println("POST msg from server :: " + msg)
Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
}
}
})
}

feb.setOnClickListener{
val jsonObject = JsonObject()
jsonObject.addProperty("text", "around 26")
APIStuff.service.postTemp(jsonObject).enqueue(object : Callback<ResponseBody> {
override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
println("---TTTT :: POST Throwable EXCEPTION:: " + t.message)
}
override fun onResponse(call: Call<ResponseBody>, response:

Response<ResponseBody>) {

if (response.isSuccessful) {
val msg = response.body()?.string()
println("POST msg from server :: " + msg)
Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
}
}
})
}
mar.setOnClickListener{
val jsonObject = JsonObject()
jsonObject.addProperty("text", "around 28")
APIStuff.service.postTemp(jsonObject).enqueue(object : Callback<ResponseBody> {
override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
println("---TTTT :: POST Throwable EXCEPTION:: " + t.message)
}
override fun onResponse(call: Call<ResponseBody>, response:

Response<ResponseBody>) {

if (response.isSuccessful) {
val msg = response.body()?.string()
println("POST msg from server :: " + msg)
Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
}
}
})
}
