package com.nyc.android_44_unit_04_mid_unit_assessment.fragments.innerFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nyc.android_44_unit_04_mid_unit_assessment.R;
import com.nyc.android_44_unit_04_mid_unit_assessment.controller.BooksAdapter;
import com.nyc.android_44_unit_04_mid_unit_assessment.models.BookModel;
import com.nyc.android_44_unit_04_mid_unit_assessment.models.Books;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BottomFragment extends Fragment {
    private BookModel bookModel;
    private final String TAG = "BottomFragment";
    private RecyclerView recyclerView;

    private String jsonString = "{\n" +
            "  \"books\": [\n" +
            "    {\n" +
            "      \"title\": \"Northanger Abbey\",\n" +
            "      \"author\": \"Austen, Jane\",\n" +
            "      \"year\": 1814\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"War and Peace\",\n" +
            "      \"author\": \"Tolstoy, Leo\",\n" +
            "      \"year\": 1865\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Anna Karenina\",\n" +
            "      \"author\": \"Tolstoy, Leo\",\n" +
            "      \"year\": 1875\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Mrs. Dalloway\",\n" +
            "      \"author\": \"Woolf, Virginia\",\n" +
            "      \"year\": 1925\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"The Hours\",\n" +
            "      \"author\": \"Cunnningham, Michael\",\n" +
            "      \"year\": 1999\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Huckleberry Finn\",\n" +
            "      \"author\": \"Twain, Mark\",\n" +
            "      \"year\": 1865\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Bleak House\",\n" +
            "      \"author\": \"Dickens, Charles\",\n" +
            "      \"year\": 1870\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Tom Sawyer\",\n" +
            "      \"author\": \"Twain, Mark\",\n" +
            "      \"year\": 1862\n" +
            "    }\n" +
            "  ]\n" +
            "}\n";


    public BottomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_bottom, container, false);
        recyclerView = rootview.findViewById(R.id.recyclerview);
        List<Books> books = new ArrayList<>();


        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            String title = jsonObject.getJSONArray("books").getJSONObject(0).get("title").toString();
            Log.d("BottomFragment", "the title of the array " + title);
            bookModel = new BookModel();
            JSONArray jsonArray = jsonObject.getJSONArray("books");
            for (int i = 0; i < jsonArray.length(); i++) {
                Books book = new Books();
                JSONObject bookJson = new JSONObject(jsonArray.get(i).toString());
                String author = bookJson.getString("author");
                String titles = bookJson.getString("title");
                int year = bookJson.getInt("year");
                book.setAuthor(author);
                book.setTitle(titles);
                book.setYear(year);
                books.add(book);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < books.size(); i++) {
            Log.d(TAG,"Book: " + books.get(i).getTitle());
            Log.d(TAG,"Book: " + books.get(i).getAuthor());
            Log.d(TAG,"Book: " + books.get(i).getYear());
        }
        BooksAdapter booksAdapter = new BooksAdapter(books,getActivity().getSupportFragmentManager());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext().getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setAdapter(booksAdapter);
        recyclerView.setLayoutManager(layoutManager);

        return rootview;

    }

}
