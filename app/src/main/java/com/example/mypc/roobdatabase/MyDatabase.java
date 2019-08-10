package com.example.mypc.roobdatabase;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Information.class},version = 6)
public abstract class MyDatabase extends RoomDatabase
{
    private static MyDatabase instance;
    public abstract MyDao myDao();

    public static synchronized MyDatabase getinstance(Context context)
    {
        if(instance==null)
        {
            instance= Room.databaseBuilder(context.getApplicationContext(),MyDatabase.class,"my_database")
                    .fallbackToDestructiveMigration().addCallback(roomcallback).build();
        }
        return instance;

    }
   private static RoomDatabase.Callback roomcallback=new RoomDatabase.Callback()
   {
       @Override
       public void onCreate(SupportSQLiteDatabase db) {
           super.onCreate(db);
           new populateAsynTask(instance).execute();
       }
   };
    private static class populateAsynTask extends AsyncTask<Void,Void,Void>
    {
        private MyDao myDao;
        private populateAsynTask(MyDatabase db)
        {
            myDao=db.myDao();
        }

        @Override
        protected Void doInBackground(Void... voids)
        {
            myDao.insert(new Information("ali","abd","223"));
            return null;
        }
    }


}
