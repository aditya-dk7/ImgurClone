package dk7.aditya.libimgur

import dk7.aditya.libimgur.apis.ImgurAPIv3
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class ImgurClient {
    companion object {
        const val BASE_URL = "https://api.imgur.com/3/"
        const val API_KEY = ""
    }
    private val httpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val oldRequest = chain.request()
                val newRequest = oldRequest.newBuilder()
                    .addHeader("Authorization", "Client-ID $API_KEY")
                    .build()
                chain.proceed(newRequest)
            }
            .build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .client(httpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val api by lazy { retrofit.create(ImgurAPIv3::class.java) }
}