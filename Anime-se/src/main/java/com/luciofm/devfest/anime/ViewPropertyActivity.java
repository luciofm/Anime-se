package com.luciofm.devfest.anime;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.Views;

public class ViewPropertyActivity extends Activity {

    @InjectView(R.id.imageView)
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_property);
        Views.inject(this);

/*        image.animate().alpha(1).scaleX(1).scaleY(1)
             .rotation(720).setInterpolator(new AccelerateInterpolator())
             .setDuration(1000);*/
    }

    @OnClick(R.id.button)
    public void onButtonClick(View v) {


        image.setVisibility(View.VISIBLE);

        ObjectAnimator alpha = ObjectAnimator.ofFloat(image, "alpha", 0f, 1f);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(image, "scaleX", 0f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(image, "scaleY", 0f, 1f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(image, "rotation", 0, 720);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(alpha, scaleX, scaleY, rotate);
        set.setDuration(1000).setInterpolator(new AccelerateInterpolator());
        set.start();


        image.animate().alpha(1f).scaleY(1f).scaleX(1f)
             .rotation(720).setInterpolator(new AccelerateInterpolator())
             .setDuration(1000);
    }
}
