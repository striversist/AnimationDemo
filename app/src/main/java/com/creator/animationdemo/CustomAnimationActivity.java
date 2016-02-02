package com.creator.animationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;

public class CustomAnimationActivity extends AppCompatActivity {

    private ImageView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        mView = (ImageView) findViewById(R.id.icon);
    }

    public void onAlpha(View view) {
        CustomAnimation animation = new CustomAnimation(0.5f, 1.0f);
        animation.setDuration(2000);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        mView.startAnimation(animation);
    }

    private class CustomAnimation extends Animation {
        float mFromAlpha, mToAlpha;

        public CustomAnimation(float fromAlpha, float toAlapha) {
            mFromAlpha = fromAlpha;
            mToAlpha = toAlapha;
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            t.setAlpha(mFromAlpha + (mToAlpha - mFromAlpha) * interpolatedTime);
            super.applyTransformation(interpolatedTime, t);
        }
    }
}
