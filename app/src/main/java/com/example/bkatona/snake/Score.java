package com.example.bkatona.snake;

public class Score
{
    @com.google.gson.annotations.SerializedName("id")
    private String mId;
    public String getId() { return mId; }
    public final void setId(String id) { mId = id; }

    @com.google.gson.annotations.SerializedName("Score")
    private int mScoreValue;
    public int getScore() { return mScoreValue; }
    public void setScore(int scoreValue) { mScoreValue = scoreValue; }

   public  Score(){}
   public Score(String id,Integer value)
   {
       this.setId(id);
       this.setScore(value);

   }
}