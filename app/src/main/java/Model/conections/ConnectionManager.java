package Model.conections;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ConnectionManager  {

    private static Connection connection;
    private static SQLiteDatabase sqLiteDatabase;


    private ConnectionManager() {

    }

    public static SQLiteDatabase getConnection(Context context, String name, int version) {
        if(connection == null) {
            connection = Connection.open(context, name, version);
            sqLiteDatabase = connection.getWritableDatabase();
        }
        else
           if(!sqLiteDatabase.isOpen())
               sqLiteDatabase = connection.getWritableDatabase();

        return sqLiteDatabase;


    }
    public static SQLiteDatabase getConnection(Context context, String name) {
        return getConnection(context,name,1);
    }


    public static void closeConnections() {
        if(connection != null)
            connection.close();

        if(sqLiteDatabase.isOpen())
            sqLiteDatabase.close();
    }


}
