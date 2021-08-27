package dk7.aditya.libimgur.apis

import dk7.aditya.libimgur.models.GalleryResponse
import dk7.aditya.libimgur.models.GalleryTagsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ImgurAPIv3 {
    @GET("gallery/hot?album_previews=true")
    fun getGalleryResponse(): Call<GalleryResponse>

    @GET("tags")
    fun getGalleryTags() : Call <GalleryTagsResponse>

}