package com.example.bookscatalog.repositoryAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class bookList {
    @SerializedName("start")
    @Expose
    private int start;

    @SerializedName("num_found")
    @Expose
    private int num_found;

    @SerializedName("docs")
    @Expose
    private List<book> docs;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getNum_found() {
        return num_found;
    }

    public void setNum_found(int num_found) {
        this.num_found = num_found;
    }

    public List<book> getDocs() {
        return docs;
    }

    public void setDocs(List<book> docs) {
        this.docs = docs;
    }

    @Override
    public String toString() {
        return "bookList{" +
                "start=" + start +
                ", num_found=" + num_found +
                ", docs=" + docs +
                '}';
    }
}
