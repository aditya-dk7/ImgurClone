package dk7.aditya.imgurclone.ui.feed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dk7.aditya.imgurclone.data.ImgurRepository
import dk7.aditya.libimgur.models.Image
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {
    private val _feed = MutableLiveData<List<Image>>()
    val feed: LiveData<List<Image>> = _feed
    fun updateFeed(feedType: String){
        viewModelScope.launch(Dispatchers.IO){
            when(feedType){
                "hot"-> _feed.postValue(ImgurRepository().getHotGallery())
                "top"-> _feed.postValue(ImgurRepository().getTopGallery())
                else -> Log.d("ERROR", "Feed has to be hot or top")
            }
        }
    }
}