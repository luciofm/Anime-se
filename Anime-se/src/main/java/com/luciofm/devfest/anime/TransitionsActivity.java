package com.luciofm.devfest.anime;

import android.app.Activity;
import android.os.Bundle;

public class TransitionsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transitions);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new SceneTransitions())
                    .commit();
        }
    }
}
