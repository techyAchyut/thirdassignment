package achyut.achyut.esoftwarica.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import achyut.achyut.esoftwarica.R;
import achyut.achyut.esoftwarica.ui.notifications.Student;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentAdaptor extends RecyclerView.Adapter<StudentAdaptor.MyHolder>{

    List<Student> student;


    public StudentAdaptor(List<Student> student) {
        this.student = student;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.students,parent,false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        final Student students = student.get(position);
        holder.name.setText(students.getName());
        holder.gender.setText(students.getGender());
        holder.age.setText(students.getAge());
        holder.address.setText(students.getAddress());
        String m = students.getGender();

        if(m == "Male"){
            holder.image.setImageResource(R.drawable.male);
        }
        else {
            holder.image.setImageResource(R.drawable.female);
        }
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                student.remove(students);
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return student.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        TextView name,age,gender,address;
        ImageView image;
        Button delete;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.textView2);
            age = itemView.findViewById(R.id.textView3);
            gender = itemView.findViewById(R.id.textView4);
            image = itemView.findViewById(R.id.imageView2);
            delete = itemView.findViewById(R.id.delete);
            address = itemView.findViewById(R.id.address);


        }
    }
}
