package achyut.achyut.esoftwarica.ui.notifications;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String age;
    private String gender;
    private String address;
    public Student(String name, String age, String gender, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
    public String getAddress() {
        return address;
    }
}
