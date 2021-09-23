package dk7.aditya.libimgur

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class ImgurAPIv3Test {

    @Test
    fun sampleTest() {
        assertEquals(true, true)
    }

    @Test
    fun `GET gallery top works`() = runBlocking {
        val client = ImgurClient()
        val response = client.api.getGallery("top")
        println(response.toString())
        assertEquals(200, response.status)
    }

    @Test
    fun `GET gallery hot works`() = runBlocking {
        val client = ImgurClient()
        val response = client.api.getGallery("hot")
        assertEquals(200, response.status)
    }

    @Test
    fun `GET tags works`() = runBlocking {
        val client = ImgurClient()
        val response = client.api.getTags()
        assertEquals(200, response.status)
    }
}

/*
private val api = ImgurClient.api
    @Test
    fun `get Gallery Tags Works`() =
        runBlocking {
            val response = api.getGalleryTags()
            println(response.raw().toString())
            assertNotNull(response.body())
        }


    @Test
    fun `get Gallery Response HOT Works`() =
        runBlocking {
            val response = api.getGalleryResponse("hot")
            println(response.raw().toString())
            assertNotNull(response.body())
        }


    @Test
    fun `get Gallery Response TOP Works`() = runBlocking {
        val response = api.getGalleryResponse("top")
        println(response.raw().toString())
        assertNotNull(response.body())
    }
 */