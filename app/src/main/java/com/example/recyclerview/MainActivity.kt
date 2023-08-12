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

        val apiInterface = ApiInterface.create().getMovies() // Инициализируем Api интерфейс

        apiInterface.enqueue(object : Callback<User> {

            override fun onResponse(call: Call<User>, response: Response<User>) {
                val data = response.body()

                if (data != null) {
                    val adapter =
                        CustomRecyclerAdapter(baseContext, data) // Инициализируем адаптер
                    recyclerView.adapter = adapter // Подключаем адаптер
                } else {
                    Log.d("MyLog", "null")
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("MyLog", "ошибка")
            }
        })


    } // Заканчивается onCreate


} // Заканчивается MainActivity