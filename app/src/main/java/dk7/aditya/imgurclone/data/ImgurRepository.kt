package dk7.aditya.imgurclone.data

import android.util.Log
import dk7.aditya.libimgur.ImgurClient
import dk7.aditya.libimgur.models.Image

class ImgurRepository {
    private val api by lazy { ImgurClient().api }

    suspend fun getTopGallery(): List<Image>?  {
        return try {
            val response = api.getGallery("top")
            response.data ?: throw IllegalStateException("No data received")
        } catch (e: Exception) {
            Log.e("API", "error fetching top gallery")
            null
        }
    }

    suspend fun getHotGallery(): List<Image>?  {
        return try {
            val response = api.getGallery("hot")
            response.data ?: throw IllegalStateException("No data received")
        } catch (e: Exception) {
            Log.e("API", "error fetching hot gallery")
            null
        }
    }
}
