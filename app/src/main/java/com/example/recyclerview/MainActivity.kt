package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)




        val adapter = CustomRecyclerAdapter(this) // Инициализируем адаптер
        val recyclerView = binding.recyclerView // Инициализируем Recycler View
        recyclerView.layoutManager = LinearLayoutManager(this) // Делаем вид(строчный)
        recyclerView.adapter = adapter // Подключаем адаптер
        for(i in 0..20){
            val img = R.drawable.img
            val name = this.resources.getStringArray(R.array.cat_names)[i]
            val cat = Cats(img, name)
            adapter.add(cat)
        }









    } // Заканчивается onCreate



} // Заканчивается MainActivity