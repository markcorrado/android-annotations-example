package com.example.androidAnnotationsSample;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import org.androidannotations.annotations.*;

@EActivity(R.layout.main)
@OptionsMenu(R.menu.beer_menu)
public class MyActivity extends Activity {

    @ViewById
    TextView countView;

    int count;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadCount();
    }

    @Click
    void addBeerButtonClicked() {
        count++;
        saveCount(count);
        updateViews();
    }

    @Background
    void saveCount(final int beerCount) {
        getPreferences(MODE_PRIVATE)
                .edit()
                .putInt("beerCount", beerCount)
                .commit();
    }

    private void updateViews() {
        if (count == 0) {
            setTitle("Still Sober");
            countView.setText("");
        } else {
            setTitle("Drinking");
            countView.setText(Integer.toString(count));
        }
    }

    @Background
    void loadCount() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        int count = preferences.getInt("count", 0);
        countLoaded(count);
    }

    @UiThread
    void countLoaded(int count) {
        this.count = count;
        updateViews();
    }


    @OptionsItem
    void emergencySelected() {
        count = 0;
        saveCount(count);
        updateViews();
    }
}
