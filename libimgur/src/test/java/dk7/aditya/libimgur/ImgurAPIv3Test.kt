package dk7.aditya.libimgur

import org.junit.Assert.assertNotNull
import org.junit.Test

class ImgurAPIv3Test {
    private val api = ImgurClient.api
    @Test
    fun `get Gallery Tags Works`() {
        val response = api.getGalleryTags().execute()
        println(response.raw().toString())
        assertNotNull(response.body())
    }
    @Test
    fun `get Gallery Response HOT Works`() {
        val response = api.getGalleryResponse("hot").execute()
        println(response.raw().toString())
        assertNotNull(response.body())
    }
    @Test
    fun `get Gallery Response TOP Works`() {
        val response = api.getGalleryResponse("top").execute()
        println(response.raw().toString())
        assertNotNull(response.body())
    }
}