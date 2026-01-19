package com.zhuinden.catexample2026jan.features.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.zhuinden.catexample2026jan.data.api.CatApi
import com.zhuinden.catexample2026jan.data.api.models.CatResponse
import com.zhuinden.flowcombinetuplekt.combineTuple
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URLEncoder
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val catApi: CatApi,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val catList = MutableStateFlow<List<CatResponse>?>(null)

    private val currentText = savedStateHandle.getStateFlow("text", MainState.DEFAULT_TEXT)

    private val navigationEventChannel: Channel<(NavController) -> Unit> = Channel(Channel.UNLIMITED)
    val navigationEvents: Flow<(NavController) -> Unit> = navigationEventChannel
        .receiveAsFlow()
        .shareIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            replay = 0,
        )

    val state = combineTuple(
        catList,
        currentText,
    ).map { (cats, text) ->
        MainState(
            text = text,
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000L),
        MainState.DEFAULT,
    )

    init {
        viewModelScope.launch {
            catList.value = withContext(Dispatchers.IO) {
                runCatching { catApi.getCatList() }
                    .fold(
                        onSuccess = { it },
                        onFailure = { emptyList() },
                    )
            }
        }
    }

    fun onButtonClicked() {
        val cat = (catList.value ?: emptyList()).firstOrNull() ?: return

        viewModelScope.launch {
            withContext(Dispatchers.Main.immediate) {
                navigationEventChannel.send(
                    { navController ->
                        navController.navigate("detail/${URLEncoder.encode(cat.id, "UTF-8")}/${URLEncoder.encode(cat.url, "UTF-8")}")
                    }
                )
            }
        }
    }
}