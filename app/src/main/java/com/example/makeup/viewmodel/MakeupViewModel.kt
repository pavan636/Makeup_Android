package com.example.makeup.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.makeup.model.Makeup
import com.example.makeup.repository.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MakeupViewModel @Inject constructor(private val itemRepository: ItemRepository) :
    ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            itemRepository.getMakeupItem()
        }
    }

    val items: LiveData<Makeup>
        get() = itemRepository.items

}