package com.nyc.android_44_unit_04_mid_unit_assessment.controller;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nyc.android_44_unit_04_mid_unit_assessment.MainActivity;
import com.nyc.android_44_unit_04_mid_unit_assessment.R;
import com.nyc.android_44_unit_04_mid_unit_assessment.fragments.innerFragments.TopFragment;
import com.nyc.android_44_unit_04_mid_unit_assessment.models.Books;

import java.util.List;

/**
 * Created by Wayne Kellman on 12/20/17.
 */

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder>{
    private List<Books> booksArray;
    private FragmentManager fragmentManager;


    public BooksAdapter(List<Books> books, FragmentManager supportFragmentManager) {
        this.booksArray = books;
        this.fragmentManager = supportFragmentManager;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        booksArray.get(position).setPosition(position);
        holder.onBind(booksArray.get(position));
    }

    @Override
    public int getItemCount() {
        return booksArray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView bottom_text;
        private Books books;
        public ViewHolder(View itemView) {
            super(itemView);
            bottom_text = itemView.findViewById(R.id.bottom_text);
            bottom_text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TopFragment topFragment = new TopFragment();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    Bundle bundle = new Bundle();
                    bundle.putString("author",books.getAuthor());
                    bundle.putString("title",books.getTitle());
                    bundle.putInt("year", books.getYear());
                    topFragment.setArguments(bundle);
                    fragmentTransaction.replace(R.id.top_container, topFragment);
                    fragmentTransaction.commit();


                }
            });
        }
        public void onBind(Books book){
            this.books = book;
            bottom_text.setText(book.getTitle());
        }
    }
}
