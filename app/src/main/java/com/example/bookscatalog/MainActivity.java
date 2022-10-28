package com.example.bookscatalog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bookscatalog.repositoryAPI.book;
import com.example.bookscatalog.repositoryAPI.bookList;
import com.example.bookscatalog.repositoryAPI.bookParser;
import com.example.bookscatalog.repositoryAPI.interfaceSearch;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    bookParser bookParser;

    EditText searchMain;
    EditText searchAdditional;
    ChipGroup chipGroup;
    Chip chipTitle;
    Chip chipAuthor;
    Chip chipSubject;
    ListView listView;
    Button button;

    int state = 0;

    Callback<bookList> bookListCallback;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchMain = findViewById(R.id.editTextMain);
        searchAdditional = findViewById(R.id.editTextAdditional);
        chipGroup = findViewById(R.id.chipGroup);
        chipTitle = findViewById(R.id.chipTitle);
        chipAuthor = findViewById(R.id.chipAuthor);
        chipSubject = findViewById(R.id.chipSubject);
        listView = findViewById(R.id.listViewMain);
        button = findViewById(R.id.button);

        bookParser = new bookParser();

        bookListCallback = new Callback<bookList>() {
            @Override
            public void onResponse(Call<bookList> call, Response<bookList> response) {
                if (response.isSuccessful()) {
                    populateListView(response.body().getDocs());
                } else {
                    Toast.makeText(MainActivity.this, "Something go wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<bookList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "RequestError", Toast.LENGTH_SHORT).show();
            }
        };

        chipGroup.setOnCheckedStateChangeListener(new ChipGroup.OnCheckedStateChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(@NonNull ChipGroup
                                                 group, @NonNull List<Integer> checkedIds) {
                Map<String, Integer> map = new HashMap<>();
                map.put("000", 0);
                map.put("100", 1);
                map.put("110", 2);
                map.put("010", 3);
                map.put("011", 4);
                map.put("001", 5);
                map.put("111", -1);
                map.put("101", -1);

                char[] current = new String("000").toCharArray();

                if (checkedIds.contains(R.id.chipTitle)) {
                    current[0] = '1';
                }
                if (checkedIds.contains(R.id.chipAuthor)) {
                    current[1] = '1';
                }
                if (checkedIds.contains(R.id.chipSubject)) {
                    current[2] = '1';
                }

                state = map.get(String.valueOf(current));

                updateInterface();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interfaceSearch searchAPI = bookParser.getSearchAPI();
                switch (state) {
                    case 1:
                        searchAPI.getByTitle(searchMain.getText().toString())
                                .enqueue(bookListCallback);
                        break;
                    case 2:
                        searchAPI.getByTitleAuthor(searchMain.getText().toString(),
                                searchAdditional.getText().toString())
                                .enqueue(bookListCallback);
                        break;
                    case 3:
                        searchAPI.getByAuthor(searchMain.getText().toString())
                                .enqueue(bookListCallback);
                        break;
                    case 4:
                        searchAPI.getByAuthorSubject(searchMain.getText().toString(),
                                searchAdditional.getText().toString())
                                .enqueue(bookListCallback);
                        break;
                    case 5:
                        searchAPI.getBySubject(searchMain.getText().toString())
                                .enqueue(bookListCallback);
                        break;
                }
            }
        });
    }

    private void updateInterface() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 1);
        map.put(4, 2);
        map.put(5, 1);
        map.put(-1, 0);

        chipSubject.setCheckable(true);
        chipTitle.setCheckable(true);

        switch (state) {
            case 1:
            case 2:
                chipSubject.setCheckable(false);
                break;
            case 4:
            case 5:
                chipTitle.setCheckable(false);
                break;
        }

        switch (map.get(state)) {
            case 0:
                searchMain.setVisibility(View.GONE);
                searchAdditional.setVisibility(View.GONE);
                button.setVisibility(View.GONE);

                break;
            case 1:
                searchMain.setVisibility(View.VISIBLE);
                searchAdditional.setVisibility(View.GONE);
                button.setVisibility(View.VISIBLE);
                break;
            case 2:
                searchMain.setVisibility(View.VISIBLE);
                searchAdditional.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);
                break;
        }

    }


    void populateListView(List<book> bookList) {

        Adapter adapter = new Adapter(getApplicationContext(), R.layout.item_list, bookList);
        listView.setAdapter(adapter);
    }


}