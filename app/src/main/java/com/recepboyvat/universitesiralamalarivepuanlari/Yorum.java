package com.recepboyvat.universitesiralamalarivepuanlari;


import com.google.firebase.Timestamp;

public class Yorum {
    private int programKodu;
    private String userName;
    private String userEmail;
    private Timestamp date;
    private String mesaj;
    private int gender;

    public Yorum(int programKodu, String userName, Timestamp date, String mesaj, int gender) {
        this.programKodu = programKodu;
        this.userName = userName;
        this.date = date;
        this.mesaj = mesaj;
        this.gender = gender;
    }


    public int getProgramKodu() {
        return programKodu;
    }

    public void setProgramKodu(int programKodu) {
        this.programKodu = programKodu;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Timestamp getDate(String yorumTarihi) {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
