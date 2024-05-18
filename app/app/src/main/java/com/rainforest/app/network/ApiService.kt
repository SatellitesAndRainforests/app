package com.rainforest.app.network

import com.rainforest.app.models.Item
import retrofit2.http.GET

interface ApiService {
    @GET("items")
    suspend fun getItems(): List<Item>
}
