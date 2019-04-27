package com.example.fred.confiboostv5;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Challenges extends AppCompatActivity {
ArrayList<String> listTasks;
ArrayList<String> listTasks2;
ArrayList<String> listTasks3;
ArrayList<String> listTasks4;
ArrayList<String> listTasks5;
ArrayList<String> listTasks6;
ArrayList<String> listTasks7;
ArrayList<String> listTasks8;
ArrayList<String> listTasks9;
ArrayList<String> listTasks10;

//ArrayAdapter adapter;
DatabaseHelper db;
ListView listView;
ListView listView2;
ListView listView3;
ListView listView4;
ListView listView5;
ListView listView6;
ListView listView7;
ListView listView8;
ListView listView9;
ListView listView10;

//Textview
TextView day1;
TextView day2;
TextView day3;
TextView day4;
TextView day5;
TextView day6;
TextView day7;
TextView day8;
TextView day9;
TextView day10;

private Button set;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges);
        //txtviews
        day1 = findViewById(R.id.txtOne);
        day2 = findViewById(R.id.txtTwo);
        day3 = findViewById(R.id.txtThree);
        day4 = findViewById(R.id.txtFour);
        day5 = findViewById(R.id.txtFive);
        day6 = findViewById(R.id.txtSix);
        day7 = findViewById(R.id.txtSeven);
        day8 = findViewById(R.id.txtEight);
        day9 = findViewById(R.id.txtNine);
        day10 = findViewById(R.id.txtTen);

        set = findViewById(R.id.button3);



        listView = findViewById(R.id.ListView);
        listView2 = findViewById(R.id.listView2);
        listView3 = findViewById(R.id.listView3);
        listView4 = findViewById(R.id.listView4);
        listView5 = findViewById(R.id.listView5);
        listView6 = findViewById(R.id.listView6);
        listView7 = findViewById(R.id.listView7);
        listView8 = findViewById(R.id.listView8);
        listView9 = findViewById(R.id.listView9);
        listView10 = findViewById(R.id.listView10);

        db = new DatabaseHelper(this);
        listTasks = new ArrayList<>();
        listTasks2 = new ArrayList<>();
        listTasks3 = new ArrayList<>();
        listTasks4 = new ArrayList<>();
        listTasks5 = new ArrayList<>();
        listTasks6 = new ArrayList<>();
        listTasks7 = new ArrayList<>();
        listTasks8 = new ArrayList<>();
        listTasks9 = new ArrayList<>();
        listTasks10 = new ArrayList<>();



        /*
         Cursor theTasks = db.viewAllTasksNow();

         if (theTasks.getCount()==0) {
             Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
         }
         else {
             while (theTasks.moveToNext()) {
                 listTasks.add(theTasks.getString(1));
                 ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, listTasks);
                 listView.setAdapter(listAdapter);
             }
         }
         */

        //if(listView<0 )

       //newListTasks(db.theTasks());

       //testing for individual listviews
        newListTasks(db.viewAll());
        savelistviewspace(db.view2Task());
        three(db.view3Task());
        four(db.view4Task());
        five(db.view5Task());
        six(db.view6Task());
        seven(db.view7Task());
        eight(db.view8Task());
        nine(db.view9Task());
        ten(db.view10Task());




    }

    //for new arraylist

    //METHOD FOR DISPLAYING ITEMS ON BUTTON CLICK
    public void newListTasks(Cursor input){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if(input.getCount() ==0 ) {
            builder.setTitle("BADGE ONE ACHIEVED!!!!");
            builder.setMessage("Congratulations!!! You have completed Badge One!");
            builder.show();
            timedOut();


            Toast.makeText(this, "Badge One Already Completed!", Toast.LENGTH_LONG).show();
        }else{
            while (input.moveToNext())
                listTasks.add(input.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, listTasks);
                listView.setAdapter(listAdapter);
               // listView.setItemChecked(input.getPosition(),true);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               @Override
                public void onItemClick(AdapterView<?> adapterView, final View view, int i, long l) {
                   //Toast.makeText(Challenges.this, "Hello ", Toast.LENGTH_SHORT).show();
                   final String task1 = ((TextView)view).getText().toString();
                   //Toast.makeText(Challenges.this, "Task done!", Toast.LENGTH_SHORT).show();


                   builder.setTitle("Are you done with this Task?");
                   builder.setMessage("Task will be marked done!");
                   builder.setPositiveButton(R.string.Done, new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialogInterface, int i) {
                           db.isFinished(task1);
                          ((TextView) view).setTextColor(Color.GRAY);
                           Toast.makeText(Challenges.this, "Good job mate!", Toast.LENGTH_SHORT).show();
                           day1.setTextColor(Color.GRAY);
                           //db.isDelete(task1);
                       }
                   });
                   builder.setNegativeButton(R.string.Undone, new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialogInterface, int i) {
                           builder.setCancelable(true);
                           Toast.makeText(Challenges.this, "Do the Tasks", Toast.LENGTH_SHORT).show();
                       }
                   });
                   builder.show();



                }
            });




        }
        //return input;
       // return input;
    }
    //save me listview
    public void savelistviewspace(Cursor inputn){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if(inputn.getCount() ==0 ) {
            Toast.makeText(this, "Tasks Done Already!", Toast.LENGTH_SHORT).show();
        }else{
            while (inputn.moveToNext())
                listTasks2.add(inputn.getString(1));
            ListAdapter listAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, listTasks2);
            listView2.setAdapter(listAdapter2);
            listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, final View view, int i, long l) {
                   final String task2 = ((TextView)view).getText().toString();

                    builder.setTitle("Are you done with this Task?");
                    builder.setMessage("Task will be marked done!");
                    builder.setPositiveButton(R.string.Done, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            db.isFinished(task2);
                            ((TextView)view).setTextColor(Color.GRAY);
                            Toast.makeText(Challenges.this, "Great my friend!!", Toast.LENGTH_SHORT).show();
                            day2.setTextColor(Color.GRAY);
                            //db.isDelete(task1);
                        }
                    });
                    builder.setNegativeButton(R.string.Undone, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            builder.setCancelable(true);
                            Toast.makeText(Challenges.this, "Don't be a wuss!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();

                }
            });
        }
        //return input;
        // return input;
    }
    public void three(Cursor inputn){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if(inputn.getCount() ==0 ) {
            Toast.makeText(this, "Tasks Done Already!", Toast.LENGTH_SHORT).show();
        }else{
            while (inputn.moveToNext())
                listTasks3.add(inputn.getString(1));
            ListAdapter listAdapter3 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, listTasks3);
            listView3.setAdapter(listAdapter3);
            listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, final View view, int i, long l) {
                    final String task3 = ((TextView)view).getText().toString();

                    builder.setTitle("Are you done with this Task?");
                    builder.setMessage("Task will be marked done!");
                    builder.setPositiveButton(R.string.Done, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            db.isFinished(task3);
                            ((TextView)view).setTextColor(Color.GRAY);
                            Toast.makeText(Challenges.this, "Excellent work lad!!", Toast.LENGTH_SHORT).show();
                            day3.setTextColor(Color.GRAY);
                            //db.isDelete(task1);
                        }
                    });
                    builder.setNegativeButton(R.string.Undone, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            builder.setCancelable(true);
                            Toast.makeText(Challenges.this, "Don't be a donter!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
            });


        }
        //return input;
        // return input;
    }
    public void four(Cursor inputn){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);


        if(inputn.getCount() ==0 ) {
            Toast.makeText(this, "Tasks Done Already!", Toast.LENGTH_SHORT).show();
        }else{
            while (inputn.moveToNext())
                listTasks4.add(inputn.getString(1));
            ListAdapter listAdapter4 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, listTasks4);
            listView4.setAdapter(listAdapter4);
            listView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, final View view, int i, long l) {
                    final String task4 = ((TextView)view).getText().toString();

                    builder.setTitle("Are you done with this Task?");
                    builder.setMessage("Task will be marked done!");
                    builder.setPositiveButton(R.string.Done, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            db.isFinished(task4);
                            ((TextView)view).setTextColor(Color.GRAY);
                            Toast.makeText(Challenges.this, "Well played!", Toast.LENGTH_SHORT).show();
                            day4.setTextColor(Color.GRAY);
                            //db.isDelete(task1);
                        }
                    });
                    builder.setNegativeButton(R.string.Undone, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            builder.setCancelable(true);
                            Toast.makeText(Challenges.this, "Just go for it already!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
            });


        }
        //return input;
        // return input;
    }
    public void five(Cursor inputn){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);


        if(inputn.getCount() ==0 ) {
            Toast.makeText(this, "Tasks Done Already!", Toast.LENGTH_SHORT).show();
        }else{
            while (inputn.moveToNext())
                listTasks5.add(inputn.getString(1));
            ListAdapter listAdapter5 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, listTasks5);
            listView5.setAdapter(listAdapter5);
            listView5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, final View view, int i, long l) {
                    final String task5 = ((TextView)view).getText().toString();

                    builder.setTitle("Are you done with this Task?");
                    builder.setMessage("Task will be marked done!");
                    builder.setPositiveButton(R.string.Done, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            db.isFinished(task5);
                            ((TextView)view).setTextColor(Color.GRAY);
                            Toast.makeText(Challenges.this, "Perfect! Good lad!", Toast.LENGTH_SHORT).show();
                            day5.setTextColor(Color.GRAY);
                            //db.isDelete(task1);
                        }
                    });
                    builder.setNegativeButton(R.string.Undone, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            builder.setCancelable(true);
                            Toast.makeText(Challenges.this, "JUST DO ITTTT!!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();

                }
            });
        }
        //return input;
        // return input;
    }
    public void six(Cursor inputn){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if(inputn.getCount() ==0 ) {
            Toast.makeText(this, "Tasks Done Already!", Toast.LENGTH_SHORT).show();
        }else{
            while (inputn.moveToNext())
                listTasks6.add(inputn.getString(1));
            ListAdapter listAdapter6 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, listTasks6);
            listView6.setAdapter(listAdapter6);
            listView6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, final View view, int i, long l) {
                    final String task6 = ((TextView)view).getText().toString();

                    builder.setTitle("Are you done with this Task?");
                    builder.setMessage("Task will be marked done!");
                    builder.setPositiveButton(R.string.Done, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            db.isFinished(task6);
                            ((TextView)view).setTextColor(Color.GRAY);
                            Toast.makeText(Challenges.this, "Piece of cake eh?", Toast.LENGTH_SHORT).show();
                            day6.setTextColor(Color.GRAY);
                            //db.isDelete(task1);
                        }
                    });
                    builder.setNegativeButton(R.string.Undone, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            builder.setCancelable(true);
                            Toast.makeText(Challenges.this, "Don't be shy!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
            });
        }
        //return input;
        // return input;
    }
    public void seven(Cursor inputn){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);


        if(inputn.getCount() ==0 ) {
            Toast.makeText(this, "Tasks Done Already!", Toast.LENGTH_SHORT).show();
        }else{
            while (inputn.moveToNext())
                listTasks7.add(inputn.getString(1));
            ListAdapter listAdapter7 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, listTasks7);
            listView7.setAdapter(listAdapter7);
            listView7.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, final View view, int i, long l) {
                    final String task7 = ((TextView)view).getText().toString();

                    builder.setTitle("Are you done with this Task?");
                    builder.setMessage("Task will be marked done!");
                    builder.setPositiveButton(R.string.Done, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            db.isFinished(task7);
                            ((TextView)view).setTextColor(Color.GRAY);
                            Toast.makeText(Challenges.this, "Magnificent job there!", Toast.LENGTH_SHORT).show();
                            day7.setTextColor(Color.GRAY);
                            //db.isDelete(task1);
                        }
                    });
                    builder.setNegativeButton(R.string.Undone, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            builder.setCancelable(true);
                            Toast.makeText(Challenges.this, "You need to come out of your comfort zone!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();

                }
            });

        }
        //return input;
        // return input;
    }
    public void eight(Cursor inputn){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if(inputn.getCount() ==0 ) {
            Toast.makeText(this, "Tasks Done Already!", Toast.LENGTH_SHORT).show();
        }else{
            while (inputn.moveToNext())
                listTasks8.add(inputn.getString(1));
            ListAdapter listAdapter8 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, listTasks8);
            listView8.setAdapter(listAdapter8);
            listView8.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, final View view, int i, long l) {
                    final String task8 = ((TextView)view).getText().toString();

                    builder.setTitle("Are you done with this Task?");
                    builder.setMessage("Task will be marked done!");
                    builder.setPositiveButton(R.string.Done, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            db.isFinished(task8);
                            ((TextView)view).setTextColor(Color.GRAY);
                            Toast.makeText(Challenges.this, "Well done there!", Toast.LENGTH_SHORT).show();
                            day8.setTextColor(Color.GRAY);
                            //db.isDelete(task1);
                        }
                    });
                    builder.setNegativeButton(R.string.Undone, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            builder.setCancelable(true);
                            Toast.makeText(Challenges.this, "You got a 2nd chance!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();

                }
            });
        }
        //return input;
        // return input;
    }
    public void nine(Cursor inputn){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if(inputn.getCount() ==0 ) {
            Toast.makeText(this, "Tasks Done Already!", Toast.LENGTH_SHORT).show();
        }else{
            while (inputn.moveToNext())
                listTasks9.add(inputn.getString(1));
            ListAdapter listAdapter9 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, listTasks9);
            listView9.setAdapter(listAdapter9);
            listView9.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, final View view, int i, long l) {
                    final String task9 = ((TextView)view).getText().toString();


                    builder.setTitle("Are you done with this Task?");
                    builder.setMessage("Task will be marked done!");
                    builder.setPositiveButton(R.string.Done, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            db.isFinished(task9);
                            ((TextView)view).setTextColor(Color.GRAY);
                            Toast.makeText(Challenges.this, "Good job dearie!!", Toast.LENGTH_SHORT).show();
                            day9.setTextColor(Color.GRAY);
                            //db.isDelete(task1);
                        }
                    });
                    builder.setNegativeButton(R.string.Undone, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            builder.setCancelable(true);
                            Toast.makeText(Challenges.this, "Don't be a bitch about it!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
            });
        }
        //return input;
        // return input;
    }
    public void ten(Cursor inputn){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if(inputn.getCount() ==0 ) {
            Toast.makeText(this, "Tasks Done Already!", Toast.LENGTH_SHORT).show();
        }else{
            while (inputn.moveToNext())
                listTasks10.add(inputn.getString(1));
            ListAdapter listAdapter10 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, listTasks10);
            listView10.setAdapter(listAdapter10);
            listView10.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, final View view, int i, long l) {
                    final String task10 = ((TextView)view).getText().toString();


                    builder.setTitle("Are you done with this Task?");
                    builder.setMessage("Task will be marked done!");
                    builder.setPositiveButton(R.string.Done, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            db.isFinished(task10);
                            ((TextView)view).setTextColor(Color.GRAY);
                            Toast.makeText(Challenges.this, "Superb! Go and finish up Badge One!", Toast.LENGTH_SHORT).show();
                            day10.setTextColor(Color.GRAY);
                            timerout();

                            //db.isDelete(task1);
                        }
                    });
                    builder.setNegativeButton(R.string.Undone, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            builder.setCancelable(true);
                            Toast.makeText(Challenges.this, "Why don't you give it a try?!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                    db.deleteBadgeOne();
                }
            });
        }
        //return input;
        // return input;
    }
    //timed out
    public void timedOut(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Challenges.this,PlayUI.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
    public void openSettingsNow(View view){
        Intent intent = new Intent(this,Settings.class);
        startActivity(intent);
    }
    public void timerout(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("TERRIFIC! YOU'VE MADE IT THROUGH BADGE ONE!");
        builder.setMessage("You are now closer to being confident!");
        builder.show();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Challenges.this,PlayUI.class);
                startActivity(intent);
                finish();
            }
        }, 3500);
    }


}
