package com.nyc.android_44_unit_04_mid_unit_assessment.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nyc.android_44_unit_04_mid_unit_assessment.R;
import com.nyc.android_44_unit_04_mid_unit_assessment.models.Books;

import java.util.List;

/**
 * Created by Wayne Kellman on 12/20/17.
 */

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder>{
    private List<Books> booksArray;

    public BooksAdapter(List<Books> booksArray) {
        this.booksArray = booksArray;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.onBind(booksArray.get(position));
    }

    @Override
    public int getItemCount() {
        return booksArray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView bottom_text;
        public ViewHolder(View itemView) {
            super(itemView);
            bottom_text = itemView.findViewById(R.id.bottom_text);
        }
        public void onBind(Books book){
            bottom_text.setText(book.getTitle());
        }
    }
}
