package adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eugen.loginapp.R;

import java.io.Serializable;
import java.util.List;

import Model.entities.Student;

public class SimpleAdapter  extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {

    private List<Student> students;
    private LayoutInflater inflater;
    private View studentView;
    private ViewHolder viewHolder;
    private TextView fullName;
    private ImageView photo;
    private CheckBox checkBox;
    private OnItemClickListener clickListener;
    private boolean asistencia;


    public SimpleAdapter(List<Student> students) {

        this.students = students;
        this.clickListener = clickListener;
    }

    public void setOnItemClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    public boolean isPresent() {
        return asistencia;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        inflater = LayoutInflater.from(viewGroup.getContext());
        studentView = inflater.inflate(R.layout.item_list,viewGroup,false);
        viewHolder = new ViewHolder(studentView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        fullName = viewHolder.fullName;
        photo  = viewHolder.photo;


        fullName.setText(students.get(i).getFullName());
        photo.setImageResource(students.get(i).getImg());

        checkBox = viewHolder.checkBox;
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            this.asistencia = isChecked;
        });

    }

    @Override
    public int getItemCount() {
        return students.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

       private TextView fullName;
       private ImageView photo;
       private CheckBox checkBox;



        public ViewHolder(View itemView) {
            super(itemView);

            fullName = itemView.findViewById(R.id.fullName);
            photo = itemView.findViewById(R.id.img);
            checkBox = itemView.findViewById(R.id.asistencia);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            clickListener.onItemClick(v,getAdapterPosition());

        }

    }
}
