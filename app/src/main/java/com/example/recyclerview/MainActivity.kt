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
    val Spisok = ArrayList<DataX>()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val recyclerView = binding.recyclerView // Инициализируем Recycler View
        recyclerView.layoutManager = GridLayoutManager(this, 2) // Делаем вид(строчный)


        for (i in 0..5) {
            Log.d("MyLog", "Почему 2 рза")
        }

        val apiInterface = ApiInterface.create().getMovies() // Инициализируем Api интерфейс

        apiInterface.enqueue(object : Callback<Data> {

            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                val data = response.body()?.data
                val name = DataX("123", "123", "123", 123, "123")
                Spisok.add(name)
                if (data != null) {
//                    Log.d("MyLog", data.avatar)
//                    Log.d("MyLog", Spisok[i].avatar)
                    // Spisok.add(data)

                    // Log.d("MyLog", "а хз в чем тогда дело")
                } else {
                    Log.d("MyLog", "null")
                }
            }
            override fun onFailure(call: Call<Data>, t: Throwable) {
                Log.d("MyLog", "ошибка")
            }
        })

        val adapter = CustomRecyclerAdapter(baseContext, Spisok) // Инициализируем адаптер
        recyclerView.adapter = adapter // Подключаем адаптер


    } // Заканчивается onCreate


} // Заканчивается MainActivity