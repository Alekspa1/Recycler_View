package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        val apiInterface = ApiInterface.create().getUser() // Инициализируем Api интерфейс

        apiInterface.enqueue( object : Callback<User> {

            override fun onResponse(call: Call<User>, response: Response<User>) { // Создаем функцию на поулчение результата API
                val data = response.body() // Создаем переменную результата
                if(data != null){ // Проверка на NULL
                    val adapter = CustomRecyclerAdapter(baseContext, data) // Инициализируем адаптер
                    recyclerView.adapter = adapter // Подключаем адаптер
                }
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
            }
        })








    } // Заканчивается onCreate



} // Заканчивается MainActivity