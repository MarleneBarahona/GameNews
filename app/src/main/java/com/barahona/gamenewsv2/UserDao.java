package com.barahona.gamenewsv2;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
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

    public class Converters {
        @TypeConverter
        public static ArrayList<String> fromString(String value) {
            Type listType = new TypeToken<ArrayList<String>>() {}.getType();
            return new Gson().fromJson(value, listType);
        }

        @TypeConverter
        public static String fromArrayLisr(ArrayList<String> list) {
            Gson gson = new Gson();
            String json = gson.toJson(list);
            return json;
        }
    }

}
