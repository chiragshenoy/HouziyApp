package com.visualizedsort.chiragshenoy.visualizedsort;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;

public class MainActivity extends AppCompatActivity {

    Button sort;
    EditText etNumber;
    int numberofnumbers = 0;
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<String> dataset;
    Button animate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animate = (Button) findViewById(R.id.animate);
        sort = (Button) findViewById(R.id.sort);
        etNumber = (EditText) findViewById(R.id.etNumber);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setItemAnimator(new SlideInLeftAnimator());

        animate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.add("1000", 2);
            }
        });

        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    numberofnumbers = Integer.parseInt(etNumber.getText().toString());
                    NumberList n = new NumberList(numberofnumbers);

                    int[] randomArray = n.getAnArray();

                    dataset = new ArrayList<String>(numberofnumbers);

                    for (int i = 0; i < randomArray.length; i++)
                        dataset.add(i, String.valueOf(randomArray[i]));

                    mAdapter = new MyAdapter(getApplicationContext(), dataset);
                    mRecyclerView.setAdapter(mAdapter);
                } catch (Exception e) {

                }

            }
        });
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


    }
}
