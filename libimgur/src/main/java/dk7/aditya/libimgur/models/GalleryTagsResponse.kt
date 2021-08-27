package dk7.aditya.libimgur.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GalleryTagsResponse(
    @Json(name = "data")
    val `data`: DataX,
    @Json(name = "status")
    val status: Int,
    @Json(name = "success")
    val success: Boolean
)