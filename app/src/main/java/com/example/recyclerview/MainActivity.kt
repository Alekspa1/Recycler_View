package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
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

        apiInterface.enqueue( object : Callback<user> {

            override fun onResponse(call: Call<user>, response: Response<user>) {
                val data = response.body()
                Log.d("MyLog", data.toString())

                if(data != null){
                    val adapter = CustomRecyclerAdapter(baseContext, data) // Инициализируем адаптер
                    recyclerView.adapter = adapter // Подключаем адаптер
                    Log.d("MyLog", "а хз в чем тогда дело")

                } else{
                    Log.d("MyLog", "null")
                }
            }

            override fun onFailure(call: Call<user>, t: Throwable) {
                Log.d("MyLog", "ошибка")
            }
        })
        Log.d("MyLog", apiInterface.toString())







    } // Заканчивается onCreate



} // Заканчивается MainActivity