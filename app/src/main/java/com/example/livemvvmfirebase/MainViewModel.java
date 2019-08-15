package com.example.livemvvmfirebase;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<MainModel> mMainModel;
    private Repository mRepository;

    public void init(){
        if (mMainModel!=null){
            return;
        }
        mRepository=Repository.getInstance();
        mMainModel=mRepository.getData();

    }
    public LiveData<MainModel> getProfile(){
        return mMainModel;
    }
}
