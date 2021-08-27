package dk7.aditya.libimgur.apis

import dk7.aditya.libimgur.models.GalleryResponse
import dk7.aditya.libimgur.models.GalleryTagsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImgurAPIv3 {
    @GET("gallery/{section}")
    fun getGalleryResponse(
        @Path("section") section: String? = "hot",
        @Query("album_previews") albumPreviews: Boolean? = true
    ): Call<GalleryResponse>

    @GET("tags")
    fun getGalleryTags() : Call <GalleryTagsResponse>

}