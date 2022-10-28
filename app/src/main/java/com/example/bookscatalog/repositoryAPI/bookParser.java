package com.example.bookscatalog.repositoryAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class bookParser {
    Retrofit retrofit;
    private interfaceSearch searchAPI;

    public bookParser(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://openlibrary.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        searchAPI = retrofit.create(interfaceSearch.class);
    }

    public interfaceSearch getSearchAPI(){
        return searchAPI;
    }
}
