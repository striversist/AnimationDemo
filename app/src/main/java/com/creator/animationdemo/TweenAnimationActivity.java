package com.creator.animationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class TweenAnimationActivity extends AppCompatActivity {

    private ImageView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);
        mView = (ImageView) findViewById(R.id.icon);
    }

    public void onAlpha(View view) {
        Animation animation = new AlphaAnimation(1.0f, 0);
        animation.setDuration(2000);
        animation.setRepeatCount(2);
        animation.setRepeatMode(Animation.REVERSE);
        mView.startAnimation(animation);
    }

    public void onScale(View view) {
        Animation animation = new ScaleAnimation(1f, 2f, 1f, 2f, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(2000);
        animation.setRepeatCount(2);
        animation.setRepeatMode(Animation.REVERSE);
        mView.startAnimation(animation);
    }

    public void onTranslate(View view) {
        Animation animation = new TranslateAnimation(0f, 200f, 0f, 200f);
        animation.setDuration(2000);
        animation.setRepeatCount(2);
        animation.setRepeatMode(Animation.REVERSE);
        mView.startAnimation(animation);
    }

    public void onRotate(View view) {
        Animation animation = new RotateAnimation(0, 180f, Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f);
        animation.setDuration(2000);
        animation.setRepeatCount(2);
        animation.setRepeatMode(Animation.REVERSE);
        mView.startAnimation(animation);
    }

    public void onSet(View view) {
        AnimationSet set = new AnimationSet(this, null);
        Animation animation1 = new TranslateAnimation(0f, 200f, 0f, 200f);
        animation1.setDuration(2000);
        animation1.setRepeatCount(2);
        animation1.setRepeatMode(Animation.REVERSE);
        set.addAnimation(animation1);

        Animation animation2 = new RotateAnimation(0, 180f, Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f);
        animation2.setDuration(2000);
        animation2.setRepeatCount(2);
        animation2.setRepeatMode(Animation.REVERSE);
        set.addAnimation(animation2);

        mView.startAnimation(set);
    }
}
