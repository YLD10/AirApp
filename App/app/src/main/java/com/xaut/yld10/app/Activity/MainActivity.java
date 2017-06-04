package com.xaut.yld10.app.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xaut.yld10.app.OnClick.MainClick;
import com.xaut.yld10.app.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new MainClick(savedInstanceState,this);
    }
}
