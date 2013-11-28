package com.luciofm.devfest.anime;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.Views;

public class LayoutTransitionsActivity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_transitions_activity2);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.layout_transitions_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        @InjectView(R.id.container)
        LinearLayout container;
        @InjectView(R.id.editText)
        EditText edit;
        @InjectView(R.id.button)
        Button button;
        @InjectView(R.id.button2)
        Button button2;

        private boolean showing = true;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_layout_transitions_activity2, container, false);
            Views.inject(this, rootView);
            return rootView;
        }

        @OnClick(R.id.button)
        public void onClick(View v) {
            container.setLayoutTransition(new LayoutTransition());
            if (showing) {
                button.setText("Mostrar - anim");
                edit.setVisibility(View.GONE);
            } else {
                button.setText("Esconder - anim");
                edit.setVisibility(View.VISIBLE);
            }
            showing = !showing;
        }

        @OnClick(R.id.button2)
        public void onClick2(View v) {
            container.setLayoutTransition(null);
            if (showing) {
                button2.setText("Mostrar");
                edit.setVisibility(View.GONE);
            } else {
                button2.setText("Esconder");
                edit.setVisibility(View.VISIBLE);
            }
            showing = !showing;
        }
    }

}
