package com.smithshodunke.cryptoapp

import com.smithshodunke.cryptoapp.data.remote.CoinpaprikaApi
import com.smithshodunke.cryptoapp.data.repository.CoinRepositoryImpl
import com.smithshodunke.cryptoapp.domain.repository.CoinRepository
import com.smithshodunke.cryptoapp.util.MockResponseFileReader
import com.smithshodunke.cryptoapp.util.Resource
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitTest {

    private val mockWebServer = MockWebServer()
    private lateinit var coinRepository: CoinRepository

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Before
    fun setup() {
        mockWebServer.start(8000)

        val client = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .writeTimeout(1, TimeUnit.SECONDS)
            .build()

        val coinApi = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinpaprikaApi::class.java)

        coinRepository = CoinRepositoryImpl(coinApi)
    }

    @Test
    fun testApiSuccess() {
        val mockedResponse = MockResponseFileReader("success.json").content
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(mockedResponse)
        )

        val response = runBlocking {
            coinRepository.getAllCoins().toList()
        }

        assert(response.last() is Resource.Success)
    }

    @Test
    fun testApiFailure() {
        mockWebServer.enqueue(
            MockResponse(
            ).setResponseCode(400)
        )

        val response = runBlocking {
            coinRepository.getAllCoins().toList()
        }

        assert(response.last() is Resource.Error)
    }

}