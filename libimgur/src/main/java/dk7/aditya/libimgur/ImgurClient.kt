package dk7.aditya.libimgur

import dk7.aditya.libimgur.apis.ImgurAPIv3
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ImgurClient {
    private val httpClient: OkHttpClient by lazy {
        OkHttpClient.Builder().addInterceptor {
        val request = it
            .request()
            .newBuilder()
            .addHeader("Authorization", "Client-ID")
            .build()
        it.proceed(request)
    }.build()
    }
    private val retrofit :Retrofit by lazy {
        Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .client(httpClient)
        .baseUrl("https://api.imgur.com/3/").build()
    }
    val api: ImgurAPIv3 by lazy{
        retrofit.create(ImgurAPIv3::class.java)
    }
}