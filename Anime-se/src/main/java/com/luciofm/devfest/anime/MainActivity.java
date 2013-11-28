package com.luciofm.devfest.anime;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    static ArrayList<ExampleButton> examples;
    static {
        examples = new ArrayList<ExampleButton>();
        examples.add(new ExampleButton("Touch Feedback", TouchFeedbackActivity.class));
        examples.add(new ExampleButton("Layout transitions", LayoutTransitionActivity.class));
        examples.add(new ExampleButton("Layout transitions 2", LayoutTransitionsActivity2.class));
        examples.add(new ExampleButton("ViewPropertyAnimation", ViewPropertyActivity.class));
        examples.add(new ExampleButton("Object Animator", ObjectAnimatorActivity.class));
        examples.add(new ExampleButton("Transitions Activity", TransitionsActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<ExampleButton>(this, android.R.layout.simple_list_item_1,
                                                       examples));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        ExampleButton example = (ExampleButton) l.getAdapter().getItem(position);
        Intent intent = new Intent(this, example.clazz);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeScaleUpAnimation(v, 0, 0,
                                                                                   v.getWidth(),
                                                                                   v.getHeight());
        ActivityCompat.startActivity(this, intent, options.toBundle());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    public static class ExampleButton {
        String name;
        Class<?> clazz;

        public ExampleButton(String name, Class<?> clazz) {
            this.name = name;
            this.clazz = clazz;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
