package com.example.mypc.roobdatabase;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import java.util.List;

import androidx.room.Update;

public class InformatioRep
{
    private MyDao myDao;
    private LiveData<List<Information>> liveData;

    public InformatioRep(Application application)
    {
        MyDatabase myDatabase=MyDatabase.getinstance(application);
        myDao=myDatabase.myDao();
        liveData=myDao.getinformation();
    }
    public void insert(Information information)
    {
        new InsetInfromationAsyncTask(myDao).execute(information);

    }
    public void updata(Information information)
    {
        new UpdataeInfromationAsyncTask(myDao).execute(information);

    }
    public void delete(Information information)
    {
        new DeleteInfromationAsyncTask(myDao).execute(information);

    }

    public LiveData<List<Information>>getinformation()
    {
        return liveData;

    }
    private static class InsetInfromationAsyncTask extends AsyncTask<Information,Void,Void>
    {
        private MyDao myDao;
        private InsetInfromationAsyncTask(MyDao myDao)
        {
            this.myDao=myDao;
        }

        @Override
        protected Void doInBackground(Information... information) {
            myDao.insert(information[0]);
            return null;
        }
    }
    private static class UpdataeInfromationAsyncTask extends AsyncTask<Information,Void,Void>
    {
        private MyDao myDao;
        private UpdataeInfromationAsyncTask(MyDao myDao)
        {
            this.myDao=myDao;
        }

        @Override
        protected Void doInBackground(Information... information) {
            myDao.update(information[0]);
            return null;
        }
    }
    private static class DeleteInfromationAsyncTask extends AsyncTask<Information,Void,Void>
    {
        private MyDao myDao;
        private DeleteInfromationAsyncTask(MyDao myDao)
        {
            this.myDao=myDao;
        }

        @Override
        protected Void doInBackground(Information... information) {
            myDao.delete(information[0]);
            return null;
        }
    }


}
