package com.example.fred.confiboostv5;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText input;
    Button enter;
    Button play;
    TextView displayname;
    EditText password;
    SQLiteDatabase db;
    Button register;

  //  DatabaseAccess dbA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // DatabaseAccess databaseAccess = new DatabaseAccess();
        myDb = new DatabaseHelper(this);
        input = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        enter = findViewById(R.id.button);
       displayname = findViewById(R.id.textView2);
       //play = findViewById(R.id.)
        myDb.insertName("test");


        //viewAll();
        storeName();

        //play name verification
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyData();
            }
        });


        //add tasks
        myDb.addTasks("Acknowledge the fact that you are shy and hard on yourself");
        myDb.addTasks("Think long and hard about the way you approach people");
        myDb.addTasks("Do a self evaluation");
        myDb.addTasks("Identify your problem with self-confidence");
        myDb.addTasks("In what areas do you need to work, that'll help you with self-confidence");
        myDb.addTasks("Introduce yourself to someone you don't know");
        myDb.addTasks("Greet a stranger");
        myDb.addTasks("Feel liberated!");
        myDb.addTasks("Identify your strong and weak points on self-confidence");
        myDb.addTasks("Ask for a friends opinion about self-confidence");
        myDb.addTasks("Ask a friend where he/she got his/her self-confidence");
        myDb.addTasks("Read an article about self-confidence");
        myDb.addTasks("What have you learned?");
        myDb.addTasks("Consult to your parents about self-confidence");
        myDb.addTasks("Read an article about parent to children motivation");
        //5 days
        myDb.addTasks("Try to apply S.W.O.T (Strength, Weakness, Opportunities,and Threat)");
        myDb.addTasks("Participate on some Debates");
        myDb.addTasks("Try public speaking with your peers");
        myDb.addTasks("Try to have a friendly competition with your friends");
        myDb.addTasks("Try speaking on different languages");
        myDb.addTasks("Attend some poetry class");
        myDb.addTasks("Try to improve your good grooming and be presentable");
        myDb.addTasks("Try reciting a poem on public");
        myDb.addTasks("Try to make your voice loud");
        myDb.addTasks("Talk to someone and Look directly onto the eyes");
        myDb.addTasks("Maintain proper posture when when you're talking");
        myDb.addTasks("Make a letter to someone and give it personally");
        myDb.addTasks("Lead the prayer before you eat");
        myDb.addTasks("Wear your favorite clothes");
        myDb.addTasks("Use humor when you're talking to someone else");
        //10 days
        myDb.close();






    }

    public void storeName() {
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.getText().toString().length()!=0){
                    myDb.insertName(input.getText().toString());
                    displayname.setTextColor(Color.BLACK);
                    Toast.makeText(MainActivity.this, "Hi " + input.getText().toString() + ", Welcome to ConfiBoost!", Toast.LENGTH_SHORT).show();
                    displayname.setText("Hi " + input.getText().toString() + ", Good Day!");
                    input.setText("Click on play!");
                }
                /*
                boolean isInserted = myDb.insertName(input.getText().toString());
                if (isInserted = true && input.length()!=0) {
                    displayname.setTextColor(Color.BLACK);
                    Toast.makeText(MainActivity.this, "Hi " + input.getText().toString() + ", Welcome to ConfiBoost!", Toast.LENGTH_SHORT).show();
                    displayname.setText("Hi " + input.getText().toString() + ", Good Day!");
                    input.setText("Click on play!");

                }

                */
                else {
                    displayname.setTextColor(Color.RED);
                    displayname.setText("Please enter your name");
                    Toast.makeText(MainActivity.this, "Input name please", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void verifyData(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Cursor c = myDb.getTheName();
        if(c.getCount()==0){
            builder.setTitle("Error!!!");
            builder.setMessage("Please enter name");
            builder.setCancelable(true);
            builder.show();
            Toast.makeText(this, "You haven't entered your name yet!", Toast.LENGTH_LONG).show();
        }
        else {
            Intent intent = new Intent(this,PlayUI.class);
            startActivity(intent);
        }
    }


     public void Next(View view){
        Intent intent = new Intent(this,PlayUI.class);
        startActivity(intent);
    }

    }

