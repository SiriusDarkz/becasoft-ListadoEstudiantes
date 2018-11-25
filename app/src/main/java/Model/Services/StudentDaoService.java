package Model.Services;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.eugen.loginapp.R;

import java.util.List;

import Model.DAO.StudentDAO;
import Model.entities.Student;

public class StudentDaoService {

    private StudentDAO studentDAO;

    public StudentDaoService(SQLiteDatabase sqLiteDatabase) {

        studentDAO = new StudentDAO(sqLiteDatabase);
    }

    public List<Student> getStudents() {

        return studentDAO.getStudents();
    }

    public void testDB() {

        studentDAO.add(new Student("Jose Eugenio Duran", "Software Engineering","Male",
                "Santo Domingo, Dominican Republic","16/09/1993",R.drawable.joseduran ));
        studentDAO.add(new Student("Elizabeth Concepcion","Software Engineering","Female",
                "Santo Domingo, Dominican Republic","24/01/1990",R.drawable.elizabethconcepcion ));
        studentDAO.add(new Student("Jesus Sanchez","Software Engineering","Male",
                "Santo Domingo, Dominican Republic","24/10/1992",R.drawable.jesussanchez));



    }

    public void close() {
        studentDAO.close();
    }
}
