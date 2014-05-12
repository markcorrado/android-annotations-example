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
    TextView beerCountView;

    int beerCount;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadBeerCount();
    }

    @Click
    void addBeerButtonClicked() {
        beerCount++;
        saveBeerCount(beerCount);
        updateBeerViews();
    }

    @Background
    void saveBeerCount(final int beerCount) {
        getPreferences(MODE_PRIVATE)
                .edit()
                .putInt("beerCount", beerCount)
                .commit();
    }

    private void updateBeerViews() {
        if (beerCount == 0) {
            setTitle("Still Sober");
            beerCountView.setText("");
        } else {
            setTitle("Drinking");
            beerCountView.setText(Integer.toString(beerCount));
        }
    }

    @Background
    void loadBeerCount() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        int beerCount = preferences.getInt("beerCount", 0);
        beerCountLoaded(beerCount);
    }

    @UiThread
    void beerCountLoaded(int beerCount) {
        this.beerCount = beerCount;
        updateBeerViews();
    }


    @OptionsItem
    void emergencySelected() {
        beerCount = 0;
        saveBeerCount(beerCount);
        updateBeerViews();
    }
}
