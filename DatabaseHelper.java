package com.example.fred.confiboostv5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "ConfiBoost.db";
    private static final int DATABASE_VERSION = 1;
    // for name table login
    private static final String TABLE_NAME = "Names";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "Name";

    //for tasks
    private static final String TABLE_NAME2 = "Tasks";
    private static final String COLUMN_1 = "taskID";
    private static final String COLUMN_2 = "DTasks";
    //for Tasks finished
    private static final String TABLE_FINISHED = "TFinished";
    private static final String COLUMN_ONE = "FinID";
    private static final String COLUMN_TWO = "TaskFin";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
       //SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + "("
                + COL_1 + " INTEGER PRIMARY KEY," + COL_2
                + " TEXT" +" )";
        String CREATE_TABLETWO = "CREATE TABLE " +
                TABLE_NAME2 + "("
                + COLUMN_1 + " INTEGER PRIMARY KEY," + COLUMN_2
                + " TEXT" +" )";
        String CREATE_TABLETHREE = "CREATE TABLE " +
                TABLE_FINISHED + "("
                + COLUMN_ONE + " INTEGER PRIMARY KEY," + COLUMN_TWO
                + " TEXT" +" )";

        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLETWO);
        db.execSQL(CREATE_TABLETHREE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FINISHED);
        onCreate(db);
    }
    public boolean insertName(String name){
         ContentValues contentValues = new ContentValues();
         SQLiteDatabase db = this.getWritableDatabase();
         contentValues.put(COL_2,name);

         long result = db.insert(TABLE_NAME,null,contentValues);
            if(result == -1)
               return false;
            else
                return true;

        }
    public Cursor fetchName(){
        SQLiteDatabase db = this.getWritableDatabase();
        String fetchit = "select Name from Names where ID is 1 ";
        //Cursor cu = db.rawQuery("select * from " + TABLE_NAME + " where ID is 1 ",null);
        Cursor cu = db.rawQuery(fetchit,null);
        StringBuffer b = new StringBuffer();
        return cu;
    }
    public Cursor getTheName(){
        SQLiteDatabase db = this.getReadableDatabase();
       // String getName = "select * from Name";
        //Cursor nameData = db.rawQuery(getName,null);
        Cursor nameData = db.rawQuery("select * from "+ TABLE_NAME,null);
       // nameData.close();
        //StringBuffer sb = new StringBuffer();
       // sb.append(nameData.getString(1));
       // sb.append(nameData.toString());
       // textView.setText(sb.toString());
        return nameData;
    }
    public Cursor getTasks(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+ TABLE_NAME2,null);

        return cursor;
    }
    public Cursor viewAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c2 = db.rawQuery("select * from " +TABLE_NAME2+ " where taskID between 1 AND 3",null);
        return c2;

    }
    public void addTasks(String tasks){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cvalues = new ContentValues();
        cvalues.put(COLUMN_2,tasks);
        db.insert(TABLE_NAME2,null,cvalues);

    }
    public Cursor view2Task(){
        SQLiteDatabase db = this.getWritableDatabase();
        //Cursor cursor2 = db.rawQuery("select DTasks from Tasks where taskID between 1 AND 3 ",null);
        Cursor cursor2 = db.rawQuery("select * from "+ TABLE_NAME2 + " where taskID between 4 AND 6 ",null);
        return cursor2;
    }
    public Cursor view3Task(){
        SQLiteDatabase db = this.getWritableDatabase();
        //Cursor cursor2 = db.rawQuery("select DTasks from Tasks where taskID between 1 AND 3 ",null);
        Cursor cursor3 = db.rawQuery("select * from "+ TABLE_NAME2 + " where taskID between 7 AND 9",null);
        return cursor3;
    }
    public Cursor view4Task(){
        SQLiteDatabase db = this.getWritableDatabase();
        //Cursor cursor2 = db.rawQuery("select DTasks from Tasks where taskID between 1 AND 3 ",null);
        Cursor cursor4 = db.rawQuery("select * from "+ TABLE_NAME2 + " where taskID between 10 AND 12",null);
        return cursor4;
    }
    public Cursor view5Task(){
        SQLiteDatabase db = this.getWritableDatabase();
        //Cursor cursor2 = db.rawQuery("select DTasks from Tasks where taskID between 1 AND 3 ",null);
        Cursor cursor5 = db.rawQuery("select * from "+ TABLE_NAME2 + " where taskID between 13 AND 15",null);
        return cursor5;
    }
    public Cursor view6Task(){
        SQLiteDatabase db = this.getWritableDatabase();
        //Cursor cursor2 = db.rawQuery("select DTasks from Tasks where taskID between 1 AND 3 ",null);
        Cursor cursor6 = db.rawQuery("select * from "+ TABLE_NAME2 + " where taskID between 16 AND 18",null);
        return cursor6;
    }
    public Cursor view7Task(){
        SQLiteDatabase db = this.getWritableDatabase();
        //Cursor cursor2 = db.rawQuery("select DTasks from Tasks where taskID between 1 AND 3 ",null);
        Cursor cursor7 = db.rawQuery("select * from "+ TABLE_NAME2 + " where taskID between 19 AND 21",null);
        return cursor7;
    }
    public Cursor view8Task(){
        SQLiteDatabase db = this.getWritableDatabase();
        //Cursor cursor2 = db.rawQuery("select DTasks from Tasks where taskID between 1 AND 3 ",null);
        Cursor cursor8 = db.rawQuery("select * from "+ TABLE_NAME2 + " where taskID between 22 AND 24",null);
        return cursor8;
    }
    public Cursor view9Task(){
        SQLiteDatabase db = this.getWritableDatabase();
        //Cursor cursor2 = db.rawQuery("select DTasks from Tasks where taskID between 1 AND 3 ",null);
        Cursor cursor9 = db.rawQuery("select * from "+ TABLE_NAME2 + " where taskID between 25 AND 27",null);
        return cursor9;
    }
    public Cursor view10Task(){
        SQLiteDatabase db = this.getWritableDatabase();
        //Cursor cursor2 = db.rawQuery("select DTasks from Tasks where taskID between 1 AND 3 ",null);
        Cursor cursor10 = db.rawQuery("select * from "+ TABLE_NAME2 + " where taskID between 28 AND 30",null);
        return cursor10;
    }
    public Cursor viewAllTasksNow(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from "+TABLE_NAME2,null );
        return c;
    }
    public Cursor viewTheNameData(){
        SQLiteDatabase db = this.getWritableDatabase();
        //String query = "select Name from Names where ID = 1 ";
        //Cursor csor = db.rawQuery("select Name from " +TABLE_NAME+ " where ID = 1 ",null);
        Cursor csor = db.rawQuery("select "+COL_2+ " from " +TABLE_NAME+ " where " +COL_1+ " = 1 ",null);
        //Cursor csor = db.rawQuery("select Name from " +TABLE_NAME+ " where ID = 1 ",null);
       // Cursor cursor = db.rawQuery("select * from "+TABLE_NAME,null    );

        return csor;
    }
    public Cursor NameInput(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor hehe = db.rawQuery("select Name from "+ TABLE_NAME + " where ID ==1 ",null);
        return  hehe;
    }

    public Cursor theTasks(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor curse = db.rawQuery("select * from " +TABLE_NAME2 + " where taskID between 1 AND 30",null);
        return curse;
    }
    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
       // Cursor del = db.rawQuery("delete from "+TABLE_NAME2,null);
       //db.execSQL("delete from "+TABLE_NAME2);
        db.delete(TABLE_NAME2,null,null);
        db.delete(TABLE_NAME,null,null);
        db.delete(TABLE_FINISHED,null,null);
        db.execSQL("delete from "+TABLE_NAME);
        db.execSQL("delete from "+TABLE_NAME2);
        db.execSQL("delete from "+TABLE_FINISHED);

        //db.close();
        //return del;
    }
    //deletes badge one
    public void deleteBadgeOne(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME2,null,null);
        db.execSQL("delete from "+TABLE_NAME2);
    }


    //to insert into finished table
    public boolean isFinished(String pos){
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase db = this.getWritableDatabase();
        contentValues.put(COLUMN_TWO,pos);
        long insrt = db.insert(TABLE_FINISHED,null,contentValues);
        if(insrt == -1)
            return false;
        else
            return true;
    }
    //to delete finished task


    public void isDelete(String pos){
        //ContentValues contentValues = new ContentValues();
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+TABLE_NAME2+ " where "+pos);
        //db.delete(TABLE_FINISHED,pos,null);
        db.close();
    }



    //}


}
