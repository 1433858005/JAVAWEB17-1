package com.example.springboot004;

public class english {
    private int id;
    private String name;
    private String fanyi;

    @Override
    public String toString() {
        return "english{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fanyi='" + fanyi + '\'' +
                '}';
    }

    public english(int id, String name, String fanyi) {
        this.id = id;
        this.name = name;
        this.fanyi = fanyi;
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

    public String getFanyi() {
        return fanyi;
    }

    public void setFanyi(String fanyi) {
        this.fanyi = fanyi;
    }
}
