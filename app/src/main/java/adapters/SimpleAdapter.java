package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eugen.loginapp.R;

import java.util.List;

import Model.entities.Student;

public class SimpleAdapter  extends BaseAdapter {

    private static LayoutInflater inflater = null;
    private List<Student> students;
    private Context context;
    private boolean asistencia;


    public SimpleAdapter(Context context, List<Student> data ) {
        this.context = context;
        this.students = data;

        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public int getCount() {
        return getStudents().size();
    }

    @Override
    public Object getItem(int position) {
        return getStudents().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View vista = inflater.inflate(R.layout.item_list, null);

        TextView fullName = vista.findViewById(R.id.fullName);
        ImageView photo  = vista.findViewById(R.id.img);

        fullName.setText(students.get(position).getFullName());
        photo.setImageResource(students.get(position).getImg());

        CheckBox checkBox = vista.findViewById(R.id.asistencia);
        checkBox.setOnClickListener( v -> asistencia = checkBox.isChecked());

        return vista;
    }

    public boolean isPresent() {
        return asistencia;
    }
}
