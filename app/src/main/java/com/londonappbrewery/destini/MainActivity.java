package com.londonappbrewery.destini;

import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mTextView;
    Button mButton1;
    Button mButton2;
    int mIndex=0;

    private Story[] mStory = new Story[]{
            new Story(R.string.T1_Story,R.string.T1_Ans1,R.string.T1_Ans2),
            new Story(R.string.T2_Story,R.string.T2_Ans1,R.string.T2_Ans2),
            new Story(R.string.T3_Story,R.string.T3_Ans1,R.string.T3_Ans2),
            new Story(R.string.T4_End,0,0),
            new Story(R.string.T5_End,0,0),
            new Story(R.string.T6_End,0,0)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            mIndex = savedInstanceState.getInt("IndexKey");
        } else{
            mIndex=0;
        }

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mButton1 = (Button) findViewById(R.id.buttonTop);
        mButton2 = (Button) findViewById(R.id.buttonBottom);
        update();

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            switch(mIndex){
                case 0: mIndex=2;break;
                case 1: mIndex=2;break;
                case 2: mIndex=5;break;
            }
            update();
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            switch(mIndex){
                case 0: mIndex=1;break;
                case 1: mIndex=3;break;
                case 2: mIndex=4;break;
            }
            update();
            }
        });

    }

    public void update(){
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Story End!");
        alert.setPositiveButton("close application", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        if(mIndex !=4 && mIndex !=5 && mIndex != 3) {
            mTextView.setText(mStory[mIndex].getStory());
            mButton1.setText(mStory[mIndex].getAns1());
            mButton2.setText(mStory[mIndex].getAns2());
        } else if(mIndex==3){
            mTextView.setText(mStory[mIndex].getStory());
            mButton1.setVisibility(View.GONE);
            mButton2.setVisibility(View.GONE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    alert.setMessage("He was not a Murderer.... may be...");
                    alert.show();
                }
            },1000);
        } else if(mIndex==4){
            mTextView.setText(mStory[mIndex].getStory());
            mButton1.setVisibility(View.GONE);
            mButton2.setVisibility(View.GONE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    alert.setMessage("Who is crazy enough to kill his driver??? YOU!!!");
                    alert.show();
                }
            },1000);
        } else if(mIndex==5){
            mTextView.setText(mStory[mIndex].getStory());
            mButton1.setVisibility(View.GONE);
            mButton2.setVisibility(View.GONE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    alert.setMessage("Nice making friends on the way but beware....");
                    alert.show();
                }
            },1000);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("IndexKey",mIndex);
    }
}
