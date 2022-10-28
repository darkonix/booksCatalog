package com.example.bookscatalog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bookscatalog.repositoryAPI.book;

import java.util.List;

public class Adapter extends ArrayAdapter<book> {

    private Context mContext;
    private final LayoutInflater layoutInflater;

    int mResource;

    public Adapter(@NonNull Context context, int resource, @NonNull List<book> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = layoutInflater.inflate(mResource, parent, false);

        TextView textViewTitleTV = convertView.findViewById(R.id.textViewTitle);
        TextView textViewAuthorTV = convertView.findViewById(R.id.textViewAuthor);
        TextView textViewYearTV = convertView.findViewById(R.id.textViewYear);

        book book = getItem(position);


        if (book.getTitle() == null)
            textViewTitleTV.setText("Нет данных");
        else
            textViewTitleTV.setText(book.getTitle());
        if (book.getAuthorName() == null)
            textViewAuthorTV.setText("Нет данных");
        else
            textViewAuthorTV.setText(book.getAuthorName().get(0));
        if (book.getFirstPublishYear() == null)
            textViewYearTV.setText("Нет данных");
        else
            textViewYearTV.setText(String.valueOf(book.getFirstPublishYear()));

        return convertView;
    }
}
