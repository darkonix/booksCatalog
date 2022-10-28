package com.example.bookscatalog.repositoryAPI;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface interfaceSearch {

    @GET("search.json")
    Call<bookList> getByTitle(@Query("title") String title);

    @GET("search.json")
    Call<bookList> getByAuthor(@Query("author") String author);

    @GET("search.json")
    Call<bookList> getBySubject(@Query("subject") String subject);

    @GET("search.json")
    Call<bookList> getByAuthorSubject(@Query("author") String author, @Query("subject") String subject);

    @GET("search.json")
    Call<bookList> getByTitleAuthor(@Query("title") String title, @Query("author") String author);
}
