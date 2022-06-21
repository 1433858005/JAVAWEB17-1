package com.example.english4;

public class english {
    private int id;
    private String name;
    private String fanyi;
    private String mp3;
    private String time;

    public int getId() {
        return id;
    }

    public english(int id, String name, String fanyi, String mp3, String time) {
        this.id = id;
        this.name = name;
        this.fanyi = fanyi;
        this.mp3 = mp3;
        this.time = time;
    }

    public english() {
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

    public String getMp3() {
        return mp3;
    }

    public void setMp3(String mp3) {
        this.mp3 = mp3;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


//    private int id;
//    private String name;
//    private String fanyi;
//
//    public english() {
//    }
//
//    @Override
//    public String toString() {
//        return "english{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", fanyi='" + fanyi + '\'' +
//                '}';
//    }
//
//    public english(int id, String name, String fanyi) {
//        this.id = id;
//        this.name = name;
//        this.fanyi = fanyi;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getFanyi() {
//        return fanyi;
//    }
//
//    public void setFanyi(String fanyi) {
//        this.fanyi = fanyi;
//    }
}
