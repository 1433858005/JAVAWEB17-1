package com.example.gfstudent.daomain;

public class Student {
    private int id;
    private String name;
    private  String gender;
    private  int age;
    private  int studentid;
    private  int phone;
    private  String email;
    private  String identitycard;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", studentid=" + studentid +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", identitycard='" + identitycard + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentitycard() {
        return identitycard;
    }

    public void setIdentitycard(String identitycard) {
        this.identitycard = identitycard;
    }

    public Student() {
    }

    public Student(int id, String name, String gender, int age, int studentid, int phone, String email, String identitycard) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.studentid = studentid;
        this.phone = phone;
        this.email = email;
        this.identitycard = identitycard;
    }
}
