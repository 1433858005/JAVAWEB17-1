package com.example.daomain;

public class DanCi {
    private Integer id;
    private String name;
    private String fanyi;

    public DanCi() {
    }

    public DanCi(Integer id, String name, String fanyi) {
        this.id = id;
        this.name = name;
        this.fanyi = fanyi;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fanyi='" + fanyi + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFanyi() {
        return fanyi;
    }

    public void setFanyi(String fanyi) {
        this.fanyi = fanyi;
    }
}
