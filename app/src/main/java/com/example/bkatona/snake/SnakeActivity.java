package com.example.bkatona.snake;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;

import com.google.gson.JsonObject;
import com.microsoft.windowsazure.mobileservices.*;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceJsonTable;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

import org.json.JSONObject;

import java.net.MalformedURLException;

public class SnakeActivity extends Activity {

    // Declare an instance of SnakeView
    SnakeView snakeView;
    // We will initialize it in onCreate
    // once we have more details about the Player's device
    private MobileServiceClient mClient;
    private MobileServiceTable<Score> mScoreTable;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


        //find out the width and height of the screen
        Display display = getWindowManager().getDefaultDisplay();

        // Load the resolution into a Point object
        Point size = new Point();
        display.getSize(size);

        //Create a new View based on the SnakeView class
        snakeView = new SnakeView(this, size);

        // Make snakeView the default view of the Activity
        setContentView(snakeView);


    }

    // Start the thread in snakeView when this Activity
    // is shown to the player
    @Override
    protected void onResume() {
        super.onResume();
        snakeView.resume();
    }

    // Make sure the thread in snakeView is stopped
    // If this Activity is about to be closed
    @Override
    protected void onPause() {
        super.onPause();
        snakeView.pause();

    }

}
