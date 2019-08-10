package com.example.mypc.roobdatabase;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

public class MyViewModel extends AndroidViewModel
{
    private InformatioRep informatioRep;
    private LiveData<List<Information>> information;

    public MyViewModel(@NonNull Application application) {
        super(application);
        informatioRep=new InformatioRep(application);
        information=informatioRep.getinformation();

    }
    public void insert(Information information)
    {
        informatioRep.insert(information);
    }
    public void updata(Information information)
    {
        informatioRep.updata(information);
    }
    public void delete(Information information)
    {
        informatioRep.delete(information);
    }
    public LiveData<List<Information>> getinformation()
    {
        return information;

    }

}
