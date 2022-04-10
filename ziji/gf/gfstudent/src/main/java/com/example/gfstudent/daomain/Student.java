package com.example.gfstudent.daomain;

public class Student {
    private int id;
    private String name;
    private  String gender;
    private  int age;
    private  int studentid;
    private  String phone;
    private  String email;
    private  String identitycard;
    private String img;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", studentid=" + studentid +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", identitycard='" + identitycard + '\'' +
                ", img='" + img + '\'' +
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Student() {
    }

    public Student(int id, String name, String gender, int age, int studentid, String phone, String email, String identitycard, String img) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.studentid = studentid;
        this.phone = phone;
        this.email = email;
        this.identitycard = identitycard;
        this.img = img;
    }
}
