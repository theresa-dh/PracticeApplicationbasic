package com.theresa.practiceapplication_basic

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.theresa.practiceapplication_basic.databinding.ActivityAlbumBinding

class AlbumActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlbumBinding

    private lateinit var photos: ArrayList<Photo>
    private lateinit var imageList: MutableList<Int>
    private lateinit var titleList: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAlbumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        photos = arrayListOf<Photo>()

        val recyclerView: RecyclerView = binding.albumView
        recyclerView.adapter = AlbumAdapter(photos)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.setHasFixedSize(true)

        imageList = mutableListOf(
            R.drawable.photo9,
            R.drawable.photo10
//            R.drawable.photo1,
//            R.drawable.photo2,
//            R.drawable.photo3,
//            R.drawable.photo4,
//            R.drawable.photo5,
//            R.drawable.photo6,
//            R.drawable.photo7,
//            R.drawable.photo8
        )
        titleList = mutableListOf(
            "Mount Vertigo",
            "Mount Splashmore",
            "Mount Moonlike",
            "Mount Hereandthere",
            "Mount Reinsberge",
            "Mount Highlow",
            "Mount Bagoo",
            "Mount Grey",
        )

        getPhotos()
    }

    override fun onResume() {
        super.onResume()
    }

    private fun getPhotos() {
        for (i in imageList.indices) {
            val photo = Photo(imageList[i], titleList[i])
            photos.add(photo)
        }
    }
}