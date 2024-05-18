package com.rainforest.app.repository

import com.rainforest.app.network.ApiService
import javax.inject.Inject

class ItemRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getItems() = apiService.getItems()
}