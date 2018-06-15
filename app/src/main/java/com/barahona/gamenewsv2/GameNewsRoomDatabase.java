package com.barahona.gamenewsv2;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

@Database(entities = {User.class}, version = 1)
@TypeConverters({UserDao.Converters.class})
public abstract class GameNewsRoomDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    private static GameNewsRoomDatabase INSTANCE;

    static GameNewsRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (GameNewsRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), GameNewsRoomDatabase.class, "gamesnew_database").build();
                }
            }
        }
        return INSTANCE;
    }


}
