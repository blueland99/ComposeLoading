package com.blueland.composeloading.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    init {
        fetchData()
    }

    // 데이터를 불러오는 함수 (3초 딜레이 시뮬레이션)
    fun fetchData() {
        viewModelScope.launch {
            _isLoading.value = true // 로딩 시작

            delay(3000) // 3초 딜레이 (API 호출 대체)

            _isLoading.value = false // 로딩 완료
        }
    }
}
