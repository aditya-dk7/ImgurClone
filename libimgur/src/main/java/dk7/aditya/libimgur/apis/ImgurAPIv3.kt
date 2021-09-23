package dk7.aditya.libimgur.apis

import dk7.aditya.libimgur.models.GalleryResponse
import dk7.aditya.libimgur.models.TagGalleryResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImgurAPIv3 {
    @GET("gallery/{section}")
    suspend fun getGallery(
        @Path("section") section: String? = "hot",
        @Query("album_previews") albumPreviews: Boolean? = true
    ): GalleryResponse

    @GET("tags")
    suspend fun getTags() : TagGalleryResponse
}