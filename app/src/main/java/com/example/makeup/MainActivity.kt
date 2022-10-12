package com.example.makeup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.makeup.adapter.Adapter
import com.example.makeup.databinding.ActivityMainBinding
import com.example.makeup.model.Makeup
import com.example.makeup.util.OnItemClick
import com.example.makeup.viewmodel.MakeupViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), OnItemClick {

    private val makeupViewModel: MakeupViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: Adapter
    private lateinit var makeupItem: Makeup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//      setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        makeupViewModel.items.observe(this) {
            makeupItem = it
            adapter = Adapter(it, this, this)
            recyclerView.adapter = adapter
            it.iterator().forEach { item ->
                // logs the name of the items and image url in the terminal
                Log.d("PAV", "name:${item.name}\n image:${item.image_link}")
            }
        }
    }

    // gets the position of the item that was clicked
    override fun onClick(position: Int) {
        val bundle = Bundle()
        bundle.putStringArrayList(
            "makeups",
            arrayListOf(
                makeupItem[position].name,
                makeupItem[position].image_link,
                makeupItem[position].description
            )
        )
         val intent = Intent(this, MakeupItemDesc::class.java)
        intent.putExtras(bundle)
        startActivity(intent)

    }
}