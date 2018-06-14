package com.barahona.gamenewsv2;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insert(User user);

    @Query("SELECT * FROM User")
    LiveData<List<User>> getAll();

    @Query("SELECT * FROM User WHERE id_user IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    /*@Query("SELECT * FROM User WHERE username LIKE :username AND "
            + "pass LIKE :password LIMIT 8")*/

}
