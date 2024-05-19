package com.rainforest.app.viewmodel



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rainforest.app.models.Item
import com.rainforest.app.repository.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ItemRepository) : ViewModel() {
    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items: StateFlow<List<Item>> get() = _items

    init {
        fetchItems()
    }

    private fun fetchItems() {
        viewModelScope.launch {
            try {
                _items.value = repository.getItems()
            } catch (e: HttpException) {
                // Handle HTTP exceptions here (e.g., HTTP 404 not found)
                // Log error or update UI state as needed
                if (e.code() == 404) {
                    // Handle 404 error specifically
                    // For example, log the error or show a message to the user
                }
            } catch (e: Exception) {
                // Handle other exceptions here
                // Log error or update UI state as needed
            }
        }
    }
}