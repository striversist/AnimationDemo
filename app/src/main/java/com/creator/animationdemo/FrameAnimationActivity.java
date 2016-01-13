package com.creator.animationdemo;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FrameAnimationActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);
        mImageView = (ImageView) findViewById(R.id.image_view);
    }

    public void onStart(View view) {
        mImageView.setBackgroundResource(R.drawable.frame_anim);
        AnimationDrawable frameAnimation = (AnimationDrawable) mImageView.getBackground();
        frameAnimation.start();
    }
}
