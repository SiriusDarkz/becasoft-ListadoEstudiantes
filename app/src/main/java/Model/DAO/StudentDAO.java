package Model.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;
import java.util.List;

import Model.conections.ConnectionManager;
import Model.entities.Student;


public class StudentDAO {

    private SQLiteDatabase sqLiteDatabase;
    private List<Student> students;


    public StudentDAO(SQLiteDatabase sqLiteDatabase) {
        this.sqLiteDatabase = sqLiteDatabase;
    }



    public List<Student>  getStudents() {
       Cursor cursor =  sqLiteDatabase.rawQuery("SELECT * FROM Students",null);
       students = new ArrayList<>();
       while (cursor.moveToNext()) {
           students.add(new Student(cursor.getString(1),cursor.getString(2),cursor.getString(3),
                   cursor.getString(4),cursor.getString(5),cursor.getInt(6)));
       }
       cursor.close();
        return  students;
    }



    public void add(Student s) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("fullname", s.getFullName());
        contentValues.put("career",s.getCareer());
        contentValues.put("gender",s.getGender());
        contentValues.put("address",s.getAddress());
        contentValues.put("dateofbirth",s.getDateOfBirth());
        contentValues.put("image",s.getImg());
        sqLiteDatabase.insert("Students",null,contentValues);
    }

    public void close() {
        ConnectionManager.closeConnections();
    }






}
