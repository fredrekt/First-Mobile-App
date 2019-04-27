package com.example.fred.confiboostv5;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

public class Settings extends AppCompatActivity {
PlayUI p;
ImageButton home;
private Button about;
private Button contacts;
private Button reset;
private ProgressBar pbar;
private TextView txtR;
DatabaseHelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        home = findViewById(R.id.imgHome);
        about = findViewById(R.id.aboutButton);
        reset = findViewById(R.id.buttonReset);
        contacts = findViewById(R.id.buttonContact);
        pbar = findViewById(R.id.progressBar3);
        txtR = findViewById(R.id.txtReset);
        theAbout();
        theContacts();
        db = new DatabaseHelper(this);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainMenu();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //mydb.delete(+,null,null);
                //mydb.execSQL("delete from Tasks");
                //db.deleteAll();


                AreYouSure();
                //db.deleteAll();
                //Toast.makeText(Settings.this, "Tasks Cleared!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    //Alert dialog for *sure to delete?
    public void AreYouSure(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Are you sure you want reset?");
        builder.setMessage("Resetting will delete all your progress! ");
        builder.setPositiveButton(R.string.Yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                db.deleteAll();
                txtR.setText("Resetting progress...");
               // Toast.makeText(Settings.this, "Resetting Progress!", Toast.LENGTH_LONG).show();
                Toast.makeText(Settings.this, "Resetting All Progress!", Toast.LENGTH_LONG).show();
                pbar.setProgress(55);
              //  pbar.setProgress(30);
               // pbar.setProgress(75);
               // pbar.setMax(100);

                timedOut();
              //  pbar.setProgress(50);


            }
        });
        builder.setNegativeButton(R.string.No, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Settings.this, "Good choice lad! Don't quit on yourself!", Toast.LENGTH_LONG).show();
                cancelAndGoBack();

            }
        });
        builder.show();
    }
    //for yes or no to delete above you


    public void openMainMenu(){
        Intent intent = new Intent(this,NameOut.class);
        startActivity(intent);
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void theAbout(){
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer sb = new StringBuffer();
                sb.append("Developed by: Fredrick Garingo");
                sb.append("\nVersion: Api 16");
                sb.append("\nAndroid Version: 4.1 Jelly Bean ");
                sb.append("\nConfiBoost Version: 3.1.2");
                sb.append("\nCountry: Philippines");
                sb.append("\nReleased: 2018");
                showMessage("About us",""+sb.toString());
            }
        });

    }
    public void theContacts(){
        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Website: ConfiBoost-learn.com\n");
                stringBuffer.append("\nMessenger: facebook.com/messages/t/confiboostmsnger\n");
                stringBuffer.append("\nPhone Number: 091874700261\n");
                stringBuffer.append("\nSkype: confiboost.skype\n");
                stringBuffer.append("\nDiscord: discord.gg/8721gc12\n");
                showMessage("Contact us",""+stringBuffer.toString());
            }
        });
    }

    //timer to next activity
    public void timedOut() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Settings.this, MainActivity.class);
                startActivity(intent);
                //pbar.setProgress(75);
                //pbar.setProgress(100);
                finish();
                pbar.setProgress(100);
            }
        }, 2300);
    }

    public void cancelAndGoBack() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Settings.this, NameOut.class);
                startActivity(intent);
                finish();
            }
        }, 600);
    }



}
