package com.easyapps.shareprefrencetoyapp1;

import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="flow" ;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);

        if (getColor() != ContextCompat.getColor(this, R.color.colorPrimary))
            toolbar.setBackgroundColor(getColor());
        getWindow().setStatusBarColor(getColor());

    }

    public void green(View view) {
        toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.Green));
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.Green));

        storeColor(ContextCompat.getColor(this, R.color.Green));
    }

    public void red(View view) {
        toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.Red));
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.Red));

        storeColor(ContextCompat.getColor(this, R.color.Red));
    }

    public void yellow(View view) {
        toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.Yellow));
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.Yellow));

        storeColor(ContextCompat.getColor(this, R.color.Yellow));
    }

    private void storeColor(int color) {
        SharedPreferences sharedPreferences = getSharedPreferences("ToolbarColor", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("color", color);
        editor.apply(); //this will save file
    }

    private int getColor() {

        Log.i(TAG, "getColor: ToolbarColor will be the name of file to which data will be stored");
        Log.i(TAG, "getColor: and since Mode is MODE_PRIVATE therefore that file can be assessed by " +
                "this app only.");

        SharedPreferences sharedPreferences = getSharedPreferences("ToolbarColor", MODE_PRIVATE);

        Log.i(TAG, "getColor: second parameter of this getInt() method is the default value " +
                "that will be returned if any key by name color was not found");

        int selectedColor = sharedPreferences.getInt("color",
                ContextCompat.getColor(this, R.color.colorPrimary)); // if no key with name color was found than
                                                                                // the default value in 2nd parameter will be returned
        return selectedColor;

    }


}
