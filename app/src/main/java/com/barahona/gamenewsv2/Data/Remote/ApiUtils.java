package com.barahona.gamenewsv2.Data.Remote;

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "http://gamenewsuca.herokuapp.com/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }

}
