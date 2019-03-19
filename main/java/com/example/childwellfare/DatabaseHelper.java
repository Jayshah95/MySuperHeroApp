package com.example.childwellfare;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG ="DataBaseHelper";
        private static final String TABLE_NAME ="Questions";
        private static final String COL1="ID";
        private static final String COL2="questions";

    public DatabaseHelper(Context context) {
        super(context,TABLE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
      String  createTable = "CREATE TABLE "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,"+COL2+"TEXT)";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public boolean addData(String item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,item);
        Log.d(TAG,"addData:Adding"+item+"to"+TABLE_NAME);
        long result = db.insert(TABLE_NAME,null  ,contentValues);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM "+ TABLE_NAME;
        Cursor data = db.rawQuery(query,null);
        return data;

    }
}
