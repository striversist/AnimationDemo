package com.creator.animationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onTweenAnimation(View view) {
        startActivity(new Intent(this, TweenAnimationActivity.class));
    }

    public void onFrameAnimation(View view) {
        startActivity(new Intent(this, FrameAnimationActivity.class));
    }

    public void onCustomAnimation(View view) {
        startActivity(new Intent(this, CustomAnimationActivity.class));
    }
}
