package com.example.bts_details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class JHopeActivity extends AppCompatActivity {
    private static final String TAG = "JHopeActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jhope_details_layout);
        //Log.d(TAG, "onCreate: started.");
    }
}