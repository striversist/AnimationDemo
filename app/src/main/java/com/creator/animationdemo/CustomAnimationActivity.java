package com.creator.animationdemo;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
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
        CustomAlphaAnimation animation = new CustomAlphaAnimation(0.5f, 1.0f);
        animation.setDuration(2000);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        mView.startAnimation(animation);
    }

    public void onRotate3D(View view) {
        mView.setImageResource(R.drawable.heart01);
        Custom3DAnimation animation = new Custom3DAnimation(mView.getWidth() / 2, mView.getHeight() / 2,
                0, 90, 100, Custom3DAnimation.AXIS_Y);
        animation.setDuration(1000);
        animation.setInterpolator(new AccelerateInterpolator());
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mView.setImageResource(R.drawable.heart05);
                Custom3DAnimation anim1 = new Custom3DAnimation(
                        mView.getWidth() / 2,
                        mView.getHeight() / 2,
                        -90,
                        0,
                        0,
                        Custom3DAnimation.AXIS_Y);
                anim1.setDuration(500);
                anim1.setInterpolator(new AccelerateInterpolator());
                mView.startAnimation(anim1);
            }
        });
        mView.startAnimation(animation);
    }

    private class CustomAlphaAnimation extends Animation {
        float mFromAlpha, mToAlpha;

        public CustomAlphaAnimation(float fromAlpha, float toAlapha) {
            mFromAlpha = fromAlpha;
            mToAlpha = toAlapha;
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            t.setAlpha(mFromAlpha + (mToAlpha - mFromAlpha) * interpolatedTime);
            super.applyTransformation(interpolatedTime, t);
        }
    }

    private class Custom3DAnimation extends Animation {
        public static final int AXIS_X = 0;
        public static final int AXIS_Y = 1;

        float mCenterX, mCenterY;
        float mFromDegree, mToDegree, mDistanceZ;
        int mAxis = AXIS_Y;

        public Custom3DAnimation(float centerX, float centerY, float fromDegree,
                                 float toDegree, float distanceZ, int axis) {
            mCenterX = centerX;
            mCenterY = centerY;
            mFromDegree = fromDegree;
            mToDegree = toDegree;
            mDistanceZ = distanceZ;
            mAxis = axis;
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            float degree = mFromDegree + (mToDegree - mFromDegree) * interpolatedTime;
            float distanceZ = mDistanceZ * interpolatedTime;

            Matrix matrix = t.getMatrix();
            Camera camera = new Camera();
            camera.save();
            if (mDistanceZ != 0) {
                camera.setLocation(0, 0, distanceZ);
            }
            if (mAxis == AXIS_X) {
                camera.rotateX(degree);
            } else if (mAxis == AXIS_Y) {
                camera.rotateY(degree);
            }
            camera.getMatrix(matrix);
            camera.restore();

            // 设置旋转中心
            matrix.preTranslate(-mCenterX, -mCenterY);
            matrix.postTranslate(mCenterX, mCenterY);

            super.applyTransformation(interpolatedTime, t);
        }
    }
}
