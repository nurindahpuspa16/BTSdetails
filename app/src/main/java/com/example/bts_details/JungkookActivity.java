package com.example.bts_details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class JungkookActivity extends AppCompatActivity {
    private static final String TAG = "JungkookActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jungkook_details_layout);
        //Log.d(TAG, "onCreate: started.");
    }
}
