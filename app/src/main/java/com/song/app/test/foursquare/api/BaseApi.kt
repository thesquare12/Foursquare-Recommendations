package com.song.app.test.foursquare.api

import android.util.Log
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.google.gson.JsonSyntaxException
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.*

abstract class BaseApi {

    companion object {

        fun date(): String = SimpleDateFormat("yyyyMMdd", Locale.KOREA).format(Date())
    }

    protected fun <T> createService(service: Class<T>): T {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.foursquare.com/v2/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(createClient())
                .build()
        return retrofit.create(service)
    }

    private fun createClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
        val interceptor = HttpLoggingInterceptor(PrettyPrintHttpLoggingInterceptor())
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        client.addInterceptor(interceptor)
        return client.build()
    }

    class PrettyPrintHttpLoggingInterceptor : HttpLoggingInterceptor.Logger {

        private val TAG = "OkHttp"

        override fun log(message: String) {
            if (message.startsWith("{") || message.startsWith("[")) {
                try {
                    val prettyPrintJson = GsonBuilder().setPrettyPrinting().create().toJson(
                            JsonParser().parse(message))
                    Log.d(TAG, prettyPrintJson)
                } catch (e: JsonSyntaxException) {
                }
            } else {
                Log.d(TAG, message)
            }
        }
    }
}