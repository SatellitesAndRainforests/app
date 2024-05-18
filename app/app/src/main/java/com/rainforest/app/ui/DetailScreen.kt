package com.rainforest.app.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding

@Composable
fun DetailScreen(itemId: Int) {
    // Fetch the item details based on itemId, for simplicity here, we'll just display the ID.
    Text(text = "Detail of item ID: $itemId", modifier = Modifier.padding(16.dp))
}