package utilities;

import com.example.eugen.loginapp.R;

import java.util.Arrays;
import java.util.List;

import Model.entities.Student;

public class Util {

    public static List<Student> populateStudents() {

        return Arrays.asList(new Student[]{
        new Student("Jose Eugenio Duran", "Software Engineering","Male",
                "Santo Domingo, Dominican Republic","16/09/1993",R.drawable.joseduran ),
                new Student("Elizabeth Concepcion","Software Engineering","Female",
                        "Santo Domingo, Dominican Republic","24/01/1990",R.drawable.elizabethconcepcion ),
                new Student("Jesus Sanchez","Software Engineering","Male",
                        "Santo Domingo, Dominican Republic","24/10/1992",R.drawable.jesussanchez)
        });
    }




}
