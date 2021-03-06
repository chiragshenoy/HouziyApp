package com.visualizedsort.chiragshenoy.visualizedsort;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Chirag Shenoy on 21-Dec-15.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<String> mDataset;
    Context context;


    public void remove(int a, int b) {
        mDataset.remove(a);
        mDataset.remove(b);
        notifyItemRemoved(a);
        notifyItemRemoved(b);

    }

    public void add(String texta, int positiona, String textb, int positionb) {
        mDataset.add(positiona, texta);
        mDataset.add(positionb, textb);
        notifyItemInserted(positiona);
    }

    public void swap(int a, int b) {
//        String tempA = mDataset.get(a);
//        String tempB = mDataset.get(b);
////
//        mDataset.remove(a);
//        notifyItemRemoved(a);
//
//        mDataset.remove(b);
//        notifyItemRemoved(b);
//
//        mDataset.add(b + 2, tempA);
//        notifyItemInserted(b);
//
//        mDataset.add(a, tempB);
//        notifyItemInserted(a);

//
//        mDataset.remove(b);
//        notifyItemRemoved(b);
//
//        mDataset.add(a, tempB);
//        notifyItemInserted(a);
//        mDataset.add(b-1, tempA);
//        notifyItemInserted(b);
//
        Collections.swap(mDataset, a, b);
//        Log.e("sorts ", mDataset.toString());
        notifyItemMoved(a, b);
        notifyItemMoved(b - 1, a);
//        notifyItemMoved(a, b);


    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;

        public ViewHolder(View v) {
            super(v);
            this.mTextView = (TextView) v.findViewById(R.id.text);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Context context, ArrayList<String> myDataset) {
        mDataset = myDataset;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset.get(position));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}