//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations 3.0.1.
//


package com.example.androidAnnotationsSample;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.example.androidAnnotationsSample.R.id;
import com.example.androidAnnotationsSample.R.layout;
import org.androidannotations.api.BackgroundExecutor;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class MyActivity_
    extends MyActivity
    implements HasViews, OnViewChangedListener
{

    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();
    private Handler handler_ = new Handler(Looper.getMainLooper());

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
        setContentView(layout.main);
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static MyActivity_.IntentBuilder_ intent(Context context) {
        return new MyActivity_.IntentBuilder_(context);
    }

    public static MyActivity_.IntentBuilder_ intent(Fragment fragment) {
        return new MyActivity_.IntentBuilder_(fragment);
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        beerCountView = ((TextView) hasViews.findViewById(id.beerCountView));
        {
            View view = hasViews.findViewById(id.addBeerButton);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        MyActivity_.this.addBeerButtonClicked();
                    }

                }
                );
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(com.example.androidAnnotationsSample.R.menu.beer_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean handled = super.onOptionsItemSelected(item);
        if (handled) {
            return true;
        }
        int itemId_ = item.getItemId();
        if (itemId_ == id.emergency) {
            emergencySelected();
            return true;
        }
        return false;
    }

    @Override
    public void beerCountLoaded(final int beerCount) {
        handler_.post(new Runnable() {


            @Override
            public void run() {
                MyActivity_.super.beerCountLoaded(beerCount);
            }

        }
        );
    }

    @Override
    public void saveBeerCount(final int beerCount) {
        BackgroundExecutor.execute(new BackgroundExecutor.Task("", 0, "") {


            @Override
            public void execute() {
                try {
                    MyActivity_.super.saveBeerCount(beerCount);
                } catch (Throwable e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }

        }
        );
    }

    @Override
    public void loadBeerCount() {
        BackgroundExecutor.execute(new BackgroundExecutor.Task("", 0, "") {


            @Override
            public void execute() {
                try {
                    MyActivity_.super.loadBeerCount();
                } catch (Throwable e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }

        }
        );
    }

    public static class IntentBuilder_ {

        private Context context_;
        private final Intent intent_;
        private Fragment fragment_;

        public IntentBuilder_(Context context) {
            context_ = context;
            intent_ = new Intent(context, MyActivity_.class);
        }

        public IntentBuilder_(Fragment fragment) {
            fragment_ = fragment;
            context_ = fragment.getActivity();
            intent_ = new Intent(context_, MyActivity_.class);
        }

        public Intent get() {
            return intent_;
        }

        public MyActivity_.IntentBuilder_ flags(int flags) {
            intent_.setFlags(flags);
            return this;
        }

        public void start() {
            context_.startActivity(intent_);
        }

        public void startForResult(int requestCode) {
            if (fragment_!= null) {
                fragment_.startActivityForResult(intent_, requestCode);
            } else {
                if (context_ instanceof Activity) {
                    ((Activity) context_).startActivityForResult(intent_, requestCode);
                } else {
                    context_.startActivity(intent_);
                }
            }
        }

    }

}