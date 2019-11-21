package achyut.achyut.esoftwarica.ui.notifications;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import achyut.achyut.esoftwarica.R;

import java.util.ArrayList;
import java.util.List;

public class studentform extends Fragment implements View.OnClickListener,RadioGroup.OnCheckedChangeListener{

    Button submit;
    RadioGroup gender;
    RadioButton male,female;
    EditText name, age,address;
    public static List<Student> details = new ArrayList<>();


    String uname,uage,ugender,uaddress;
    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.studentform, container, false);

        submit = root.findViewById(R.id.submit);
        gender = root.findViewById(R.id.gender);
        male =root.findViewById(R.id.male);
        female = root.findViewById(R.id.female);
        name = root.findViewById(R.id.name);
        age =root.findViewById(R.id.age);
        address=root.findViewById(R.id.address);
        submit.setOnClickListener(this);
        gender.setOnCheckedChangeListener(this);


        notificationsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        if (i == R.id.male) {
                            ugender = "Male";
                            Toast.makeText(getContext(), "Male", Toast.LENGTH_SHORT).show();
                        }
                        if (i == R.id.female) {
                            ugender = "Female";
                            Toast.makeText(getContext(), "Female", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                         uage = age.getText().toString();
                         uname = name.getText().toString();
                         uaddress = address.getText().toString();
                         if(validate()) {
                             details.add(new Student(uname, uage, ugender, uaddress));
                             Toast.makeText(getContext(), "Student has been added", Toast.LENGTH_LONG).show();
                             age.setText(null);
                             name.setText(null);
                             address.setText(null);
                         }

                    }
                });
            }
        });
        return root;
    }

    private boolean validate() {
        if (TextUtils.isEmpty(uname)) {
            name.setError("Enter Name");
            return false;

        }
        if (TextUtils.isEmpty(uaddress)) {
            address.setError("Enter Address");
            return false;

        }

        if (TextUtils.isEmpty(uage)) {
            age.setError("Enter Age");
            return false;

        }


        if(TextUtils.isEmpty(ugender)) {
            Toast.makeText(getContext(), "Select Gender", Toast.LENGTH_SHORT).show();
            return false;

        }

        return true;


    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

    }
}