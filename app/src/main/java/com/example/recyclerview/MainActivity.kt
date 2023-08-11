package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val recyclerView = binding.recyclerView // Инициализируем Recycler View
        recyclerView.layoutManager = GridLayoutManager(this, 2) // Делаем вид(строчный)
        val apiInterface = ApiInterface.create().getUser("1fyn4DSPCKyPvrJFXlqf32mxaXRjgh9GtV6Bj0hf") // Инициализируем Api интерфейс

        apiInterface.enqueue( object : Callback<Nasa> {

            override fun onResponse(call: Call<Nasa>, response: Response<Nasa>) { // Создаем функцию на поулчение результата API
                val data = response.body() // Создаем переменную результата
                if(data != null){ // Проверка на NULL
                    Log.d("MyLog", "Успешно")
                    Log.d("MyLog", data.title)
                    val adapter = CustomRecyclerAdapter(baseContext, data) // Инициализируем адаптер
                    recyclerView.adapter = adapter // Подключаем адаптер
                }
            }
            override fun onFailure(call: Call<Nasa>, t: Throwable) {
                Log.d("MyLog", "Не успешно")
            }
        })








    } // Заканчивается onCreate



} // Заканчивается MainActivity