package com.example.fred.confiboostv5;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;
import java.util.jar.Attributes;

public class tringBNameOut extends AppCompatActivity {
    TextView textView;
    DatabaseHelper myDb;
    private Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_out);
        textView = findViewById(R.id.txtDisplay);
        play = findViewById(R.id.playName);
        myDb = new DatabaseHelper(this);

        Timer timer = new Timer();


        Cursor real = myDb.getTheName();
        if(real.getCount()==0) {
            textView.setTextColor(Color.RED);
            textView.setText("User Progress had been reset!");
            Toast.makeText(this, "You didn't enter your name!", Toast.LENGTH_LONG).show();
            //timer
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    gotoMainMenu();
                    finish();
                }
            },2000);



        }
        else
            while(real.moveToNext()){
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(real.getString(1));
                Toast.makeText(this, "Hi "+stringBuffer.toString()+", good day!", Toast.LENGTH_LONG).show();
                textView.setTextColor(Color.WHITE);
                textView.setText("Hi "+stringBuffer.toString()+", welcome back to ConfiBoost!");
            }

     //  newShowName();
      // myDb.fetchName();
        //viewEverything();
    //    displayName();
      //  theNameDisplay();
        //realNameDisplay();
      //  displayName();
       // myDb.getWritableDatabase();
        //dName();
       // viewEverything();
       // getName();
        /*

        Cursor nameDen = myDb.getTheName();
        StringBuffer sb = new StringBuffer();
        if(nameDen.getCount() !=0){
            Toast.makeText(this, "You haven't entered a name!", Toast.LENGTH_SHORT).show();
        }
        else{
            while(nameDen.moveToNext()){
                sb.append(nameDen.getString(0));
                sb.append(nameDen.getString(1));
                Toast.makeText(this, "Hello "+sb.toString()+"! Welcome back! Click on play to get started!", Toast.LENGTH_LONG).show();
            }
            textView.setText("Hi "+sb.toString()+ ", welcome to ConfiBoost!");
        }
       // StringBuffer sb = new StringBuffer();
      //  sb.append(nameDen.getString(1));
        //String name = nameDen.toString();
        //textView.setText(sb.toString());
        textView.setText("Hi "+sb.toString()+ ", welcome to ConfiBoost!");
        Toast.makeText(this, "Hello "+sb.toString()+"! Welcome back! Click on play to get started!", Toast.LENGTH_LONG).show();
       //myDb.getTheName();
        */
       // dName();

    }
    public void getName(){
        StringBuffer sb = new StringBuffer();
        Cursor curos = myDb.fetchName();
        String name = curos.getString(1);
        sb.append(name);
        textView.setText("Hi"+sb.toString());
    }
    public void dName(){
        Cursor n = myDb.NameInput();
        StringBuffer sb = new StringBuffer();
        if(n.getCount() ==1 ) {
            sb.append(n.getString(1));

            textView.setText(sb.toString());
        }
        else{
            textView.setText("Error");
            showMessage("No Name","Error please enter name before using app");
        }
    }



    public void displayName(){
        StringBuffer stringBuffer = new StringBuffer();

        Cursor data = myDb.NameInput();
        if(data.getCount()== 0){
            Toast.makeText(this, "Database empty", Toast.LENGTH_SHORT).show();
            // textView.setText(data.getString(1));
            textView.setText("No Data found");
            return;
        }
        while(data.moveToNext()) {
            //stringBuffer.append(data.getString(0));
            stringBuffer.append(data.getString(1));
            //stringBuffer.append(data.getString(1));
            //textView.setText(stringBuffer.toString());
        }
        textView.setText("Hi" +stringBuffer.toString()+ ", welcome to ConfiBoost");
    }
    /*
    public void displayName(){
        Cursor data = myDb.fetchName();
        //TextView textView = findViewById(R.id.txtDisplay);
        textView.setText(data.getString(1));
        }
*/

    /*
    public void viewEverything(){
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = myDb.viewAll();
                if(res.getCount()==0){
                    //show message
                    showMessage("Error","No data found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Id: "+ res.getString(0));
                    buffer.append("Name: "+ res.getString(1));
                }
                showMessage("Data",buffer.toString());
            }
        });
    }
    */
    public void gotoHome(View view){
        Intent intent = new Intent(this,PlayUI.class);
        startActivity(intent);
    }

    //ALERT DIALOG BUILDER
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }

    public void newShowName(){
        StringBuffer b = new StringBuffer();
        Cursor dData = myDb.viewTheNameData();
        b.append(dData.getString(1));
        textView.setText(b.toString());
        textView.setText(dData.getString(1));
    }
    public void viewEverything(){
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = myDb.fetchName();
                if(res.getCount()==0){
                    //show message
                    showMessage("Error","No name found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                   // buffer.append("Id: "+ res.getString(0));
                    buffer.append(res.getString(1));
                }
                textView.setText("Hi " +buffer.toString()+ ", welcome to ConfiBoost!");
            }
        });
    }
    public void theNameDisplay(){
        Cursor c = myDb.viewTheNameData();
        StringBuffer buffer = new StringBuffer();
        if(c.move(1))
        buffer.append(c.getString(1));
        textView.setText("Hi"+buffer.toString());
    }
    public void realNameDisplay(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(myDb.NameInput().getString(1));
        textView.setText(stringBuffer.toString());
    }
    public void gobackMainMenu() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(NameOut.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1000);
    }
    public void gotoMainMenu(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }

    }


