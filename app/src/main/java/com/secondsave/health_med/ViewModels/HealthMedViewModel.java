package com.secondsave.health_med.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;


import com.secondsave.health_med.Entities.User;
import com.secondsave.health_med.Repository.HealthMedRepository;

import java.util.List;

public class HealthMedViewModel extends AndroidViewModel {
    private HealthMedRepository mRepository;

    private LiveData<List<User>> mAllUsers;

    public HealthMedViewModel(Application application) {
        super(application);
        mRepository = new HealthMedRepository(application);
        mAllUsers = mRepository.getAllUsers();
    }

    LiveData<List<User>> getAllUsers() {
        return mAllUsers;
    }

    public void insert(User user) {
        mRepository.insert(user);
    }
}
