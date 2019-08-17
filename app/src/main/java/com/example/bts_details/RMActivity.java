package com.example.bts_details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class RMActivity extends AppCompatActivity {
    private static final String TAG = "RMActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rm_details_layout);
        //Log.d(TAG, "onCreate: started.");
    }
}
