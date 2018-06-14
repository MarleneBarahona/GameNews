package com.barahona.gamenewsv2;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class ViewModel extends AndroidViewModel{

    private Repository mRepository;
    private LiveData<List<User>> mAllWords;

    public ViewModel(@NonNull Application application) {
        super(application);
        mRepository = new Repository(application);
        mAllWords = mRepository.getAll();
    }

    LiveData<List<User>> getmAllWords(){
        return mAllWords;
    }

    public void insert(User user){
        mRepository.insert(user);
    }
}
