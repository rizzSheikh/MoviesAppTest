package com.droid.movieapprizwansheikh.network

import com.droid.movieapprizwansheikh.utils.Constants.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by RIZWAN on 12-Mar-22.
 */
object AppRetrofitAdapter {
    @Volatile
    var retrofit: Retrofit? = null
        get() {
            if (field == null) {
                synchronized(AppRetrofitAdapter::class.java) {
                    return Retrofit.Builder().client(client)
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(BASE_URL)
                        .build().also { field = it }
                }
            }
            return field
        }
    private val client: OkHttpClient
        get() {
            val logging = RetrofitNetworkLogger()
            logging.level = RetrofitNetworkLogger.Level.BODY
            val builder: OkHttpClient.Builder = OkHttpClient.Builder()
            builder.addInterceptor(logging)
                .connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .build()
            return builder.build()
        }
}