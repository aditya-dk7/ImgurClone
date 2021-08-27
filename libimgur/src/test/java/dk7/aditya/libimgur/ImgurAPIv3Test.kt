package dk7.aditya.libimgur

import dk7.aditya.libimgur.apis.ImgurAPIv3
import okhttp3.OkHttpClient
import org.junit.Assert.assertNotNull
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class ImgurAPIv3Test {
    private val client = OkHttpClient.Builder().addInterceptor {
        val request = it
            .request()
            .newBuilder()
            .addHeader("Authorization", "Client-ID")
            .build()
        it.proceed(request)
    }.build()
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .baseUrl("https://api.imgur.com/3/").build()
    private val api = retrofit.create(ImgurAPIv3::class.java)

    @Test
    fun `get Gallery Tags Works`() {
        val response = api.getGalleryTags().execute()
        println(response.raw().toString())
        assertNotNull(response.body())
    }
    @Test
    fun `get Gallery Response Works`() {
        val response = api.getGalleryResponse().execute()
        println(response.raw().toString())
        assertNotNull(response.body())
    }
}