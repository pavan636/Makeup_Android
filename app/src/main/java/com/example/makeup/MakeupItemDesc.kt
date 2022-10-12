package com.example.makeup

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.makeup.databinding.ItemlayoutBinding


class MakeupItemDesc : AppCompatActivity() {
    private lateinit var binding: ItemlayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ItemlayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras

        val makeup = bundle!!.getStringArrayList("makeups")

        binding.imageName.text = makeup!!.get(0)
        Glide.with(this)
            .load(makeup.get(1))
            .into(binding.itemImage)
        binding.descripiton!!.text = makeup!!.get(2)


    }

}