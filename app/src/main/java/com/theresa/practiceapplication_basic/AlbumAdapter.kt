package com.theresa.practiceapplication_basic

import android.content.Context
import android.util.Log.d
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.theresa.practiceapplication_basic.databinding.PhotoLayoutBinding

class AlbumAdapter(): ListAdapter<Photo, AlbumAdapter.ViewHolder>(PhotoDiffCallback)  {
//class AlbumAdapter(private val photos: ArrayList<Photo>): RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = PhotoLayoutBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(val binding: PhotoLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: Photo) {
            binding.title.text = photo.title
            binding.photo.setImageResource(photo.image)
            itemView.setOnClickListener{
                d("clicked", "item clicked!")
                Toast.makeText( itemView.context, "${binding.title.text} clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }

    object PhotoDiffCallback: DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }
    }
}