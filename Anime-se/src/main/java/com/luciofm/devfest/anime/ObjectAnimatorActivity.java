package com.luciofm.devfest.anime;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;

import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.Views;

/**
 * Created by luciofm on 11/22/13.
 */
public class ObjectAnimatorActivity extends Activity {

    @InjectView(R.id.imageView)
    ImageView image;

    private static final BounceInterpolator sBounce = new BounceInterpolator();
    private static final AccelerateInterpolator sAccelerate = new AccelerateInterpolator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.heart_beat);
        Views.inject(this);
    }

    @OnClick(R.id.button)
    public void onClick(View v) {
        image.setImageResource(R.drawable.heart_checked);

        ObjectAnimator scaleX = ObjectAnimator.ofFloat(image, "scaleX", 1f, 1.3f);
        scaleX.setInterpolator(sAccelerate);
        scaleX.setRepeatCount(1);
        scaleX.setRepeatMode(ValueAnimator.REVERSE);
        scaleX.setDuration((long) (180));
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(image, "scaleY", 1f, 1.3f);
        scaleY.setInterpolator(sAccelerate);
        scaleY.setRepeatCount(1);
        scaleY.setRepeatMode(ValueAnimator.REVERSE);
        scaleY.setDuration((long) (180));

        AnimatorSet set1 = new AnimatorSet();
        set1.playTogether(scaleX, scaleY);

        AnimatorSet set2 = new AnimatorSet();
        set2.playTogether(scaleX, scaleY);

        AnimatorSet set = new AnimatorSet();
        set.playSequentially(set1, set2);
        set.start();
    }
}
