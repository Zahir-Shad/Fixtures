package com.example.fixturepractice.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fixturepractice.Api.Repo
import com.example.fixturepractice.model.MyFixtures
import com.example.fixturepractice.util.Resource
import com.example.fixturepractice.util.successWithData
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel: ViewModel() {

    private val _fixtures = MutableLiveData<Resource<List<MyFixtures>>>()
    val fixturesObservable: LiveData<Resource<List<MyFixtures>>>
        get() = _fixtures


    init {
        getFixtures()
    }

    private fun getFixtures() {
        toggleLoading(_fixtures)
        viewModelScope.launch {
            val response = Repo.getInstance().getFixtures()
            handleResponse(_fixtures ,response)
        }
    }

    private fun <T> toggleLoading(mutableLiveData: MutableLiveData<Resource<T>>) {
        mutableLiveData.value = Resource.loading()
    }

    private fun<T> handleResponse(
        mutableLiveData: MutableLiveData<Resource<List<T>>>,
        response: Response<List<T>>
    ) {
        val resource = when {
            response.successWithData() -> Resource.success(response.body())
            else -> Resource.error("Something went wrong: ${response.message()}")
        }
        mutableLiveData.postValue(resource)
    }
}