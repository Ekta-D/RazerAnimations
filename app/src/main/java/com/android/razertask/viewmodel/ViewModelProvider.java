package com.android.razertask.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelProvider extends ViewModel {

    private MutableLiveData<Boolean> isSerchingCompleted = new MutableLiveData<>();

    public LiveData<Boolean> isDone() {
        return isSerchingCompleted;
    }

    public void setProgress(Boolean isWorking)
    {
        isSerchingCompleted.setValue(isWorking);
    }
}
