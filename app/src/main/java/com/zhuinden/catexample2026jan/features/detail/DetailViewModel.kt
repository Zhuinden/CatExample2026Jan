package com.zhuinden.catexample2026jan.features.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zhuinden.flowcombinetuplekt.combineTuple
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    val state = combineTuple(
        savedStateHandle.getStateFlow("catId", ""),
        savedStateHandle.getStateFlow("catUrl", ""),
    ).map { (catId, catUrl) ->
        DetailState(
            text = catId,
            url = catUrl,
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000L),
        initialValue = DetailState.DEFAULT,
    )
}