package com.example.fred.confiboostv5;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class PlayUI extends AppCompatActivity {
private Button badgeOne;
private ImageButton home;
private Button settings;
private ProgressBar pbar;
private Button badgeTwo;
DatabaseHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_ui);
        badgeOne = findViewById(R.id.buttonOne);
        settings = findViewById(R.id.button10);
        home = findViewById(R.id.ImageHome);
        pbar = findViewById(R.id.progressBar);
        //badgeTwo = findViewById(R.id.badgeTwo);
        //showallTheTasks();


        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSettingsOne();
            }
        });


        badgeOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBadgeOne();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainMenu();
            }
        });
    }
    public void openMainMenu(){
        Intent intent = new Intent(this,NameOut.class);
        startActivity(intent);
    }
    public void openBadgeOne(){
        //Intent intent = new Intent(this,BadgeOne.class);
        Intent intent = new Intent(this,Challenges.class);
        pbar.setProgress(35);
        startActivity(intent);
    }
    public void openSettingsOne(){
        Intent intent = new Intent(this,Settings.class);
        startActivity(intent);
    }
    /*
    public void showallTheTasks(){
        badgeTwo.setOnClickListener(new View.OnClickListener() {
            BadgeOne badone = new BadgeOne();
            @Override
            public void onClick(View view) {
                Cursor res = mydb.viewAllTasksNow();
                if(res.getCount()!=0){

                    badone.showMessage("No Data ","Missing data");
                }
                StringBuffer sb = new StringBuffer();
                while(res.moveToNext()){
                    sb.append("TaskID: "+res.getString(0)+"\n");
                    sb.append("Task: "+res.getString(1)+"\n");

                }
               // BadgeOne badtwo = new BadgeOne();
                badone.showMessage("Tasks: ",sb.toString());

            }
        });
    }
    */
    public void gotoChallenges(View view){
        Intent intent = new Intent(this,Challenges.class);
        startActivity(intent);

    }


}
