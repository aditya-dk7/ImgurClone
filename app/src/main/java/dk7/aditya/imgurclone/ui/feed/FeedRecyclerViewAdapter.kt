package dk7.aditya.imgurclone.ui.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import dk7.aditya.imgurclone.R
import dk7.aditya.imgurclone.databinding.FeedRecyclerViewListBinding
import dk7.aditya.libimgur.models.Image
import java.sql.Date
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class FeedRecyclerViewAdapter:
    ListAdapter<Image, FeedRecyclerViewAdapter.FeedViewHolder>(FeedDiffCallBack()) {

    class FeedViewHolder(val binding: FeedRecyclerViewListBinding): RecyclerView.ViewHolder(binding.root)

    private class FeedDiffCallBack: DiffUtil.ItemCallback<Image>(){
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.toString() == newItem.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding =  FeedRecyclerViewListBinding.inflate(inflater, parent, false)
        return FeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val image = getItem(position)
        holder.binding.imageDescription.text = image.title
        holder.binding.imageToView.load("https://i.imgur.com/${image.cover}.jpg"){
            placeholder(R.drawable.noimageavailable)
            error(R.drawable.noimageavailable)
        }
        val favouriteCount = "Favourites: ${image.favoriteCount}"
        holder.binding.imageDescriptionUps.text = favouriteCount
        val pointsCount = "Points: ${image.points}"
        holder.binding.imageDescriptionPoints.text= pointsCount

    }
}