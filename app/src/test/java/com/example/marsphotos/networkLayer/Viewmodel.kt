package com.example.marsphotos.networkLayer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsphotos.MarsAPi
import kotlinx.coroutines.launch

class Viewmodel : ViewModel()

{
    //  MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status
    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getMarsPhotos()
    }
    fun getMarsPhotos()
    {
        viewModelScope.launch {
            try {

                val thephotos=MarsAPi.retrofitService.getPhotos()
                _status.value=thephotos
            }
            catch (e :Exception)
            {
                _status.value="Failed: ${e.message}"
            }
        }

    }
}
