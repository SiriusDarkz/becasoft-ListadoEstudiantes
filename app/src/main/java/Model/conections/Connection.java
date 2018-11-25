package Model.conections;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Connection extends SQLiteOpenHelper {



    private   Connection(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Students(id integer primary key autoincrement, fullname text, career text, gender text, address text," +
                "dateofbirth text, image integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        if (newVersion > oldVersion) {
//            db.execSQL("DROP TABLE IF EXISTS Students");
//            onCreate(db);
//        }
//
    }
    public static Connection open(Context context, String name, int version) {

        return new  Connection(context,name, null, version);
    }

    public static Connection open(Context context, String name) {
        return open(context,name,1);
    }







}
