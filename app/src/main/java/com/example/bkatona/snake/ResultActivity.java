package com.example.bkatona.snake;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

import java.net.MalformedURLException;

public class ResultActivity extends AppCompatActivity {
    private MobileServiceClient mClient;
    private MobileServiceTable<Score> mScoreTable;
    private int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView scoreLabel = (TextView) findViewById(R.id.ScoreLabel);

        score = getIntent().getIntExtra("SCORE",0);
        scoreLabel.setText("Score: " + score);


        //load azure
        try {
            // Mobile Service URL and key
            mClient = new MobileServiceClient(
                    "https://snakeg.azurewebsites.net",
                    this);

            mScoreTable = mClient.getTable("SnakeScore",Score.class);
            
        }catch (MalformedURLException e)
        {
            Log.e("MalformedEx",e.getLocalizedMessage());
        }
        catch (Exception e)
        {
            Log.e("ex",e.getLocalizedMessage());
        }


    }
    public void tryAgain(View view)
    {
        startActivity(new Intent(getApplicationContext(),SnakeActivity.class));
    }
    public void SaveScore(View view)
    {
        startActivity(new Intent(getApplicationContext(),SnakeActivity.class));
        Score item = new Score();
        item.setScore(score);
        mScoreTable.insert(item);

    }

}
