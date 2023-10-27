package com.theresa.practiceapplication_basic

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.theresa.practiceapplication_basic.databinding.PhotoLayoutBinding

class AlbumAdapter(private val photos: ArrayList<Photo>): RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = PhotoLayoutBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val currentPhoto = photos[position]
//        holder.photoImg.setImageResource(currentPhoto.image)
//        holder.photoTitle.text = currentPhoto.title
        holder.bind(photos[position])
        //setOnClickListener
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    class ViewHolder(private val binding: PhotoLayoutBinding): RecyclerView.ViewHolder(binding.root) {
//        val photoImg: ImageView = binding.photo
//        val photoTitle: TextView = binding.title
        fun bind(photo: Photo) {
            binding.title.text = photo.title
            binding.photo.setImageResource(photo.image)
        }
    }
}

// create arrays of photos and titles