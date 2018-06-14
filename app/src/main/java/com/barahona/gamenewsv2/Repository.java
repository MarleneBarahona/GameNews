package com.barahona.gamenewsv2;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.view.View;

import java.util.List;

public class Repository {

    private UserDao mUserDao;
    private LiveData<List<User>> mAllUsers;

    Repository(Application application){
        GameNewsRoomDatabase db = GameNewsRoomDatabase.getDatabase(application);
        mUserDao = db.userDao();
        //VERIFICAR SI AFECTA QUE SEA GETALL Y NO GETALLUSERS COMO EL TUTO
        mAllUsers = mUserDao.getAll();
    }

    //VERIFICAR SI AFECTA QUE SEA GETALL Y NO GETALLUSERS COMO EL TUTO
    LiveData<List<User>> getAll(){
        return mAllUsers;
    }

    public void insert(User user){
        new insertAsyncTask(mUserDao).execute(user);
    }

    private static class insertAsyncTask extends AsyncTask<User, Void, Void>{

        private UserDao mAsyncTaskDao;

        insertAsyncTask(UserDao dao){
            mAsyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(final User... params){
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

}
