package com.recepboyvat.universitesiralamalarivepuanlari;

public class Universite {
    private String universiteAdi;
    private String universiteLogo;

    public Universite(String universiteAdi, String universiteLogo) {
        this.universiteAdi = universiteAdi;
        this.universiteLogo = universiteLogo;
    }

    public String getUniversiteAdi() {
        return universiteAdi;
    }

    public void setUniversiteAdi(String universiteAdi) {
        this.universiteAdi = universiteAdi;
    }

    public String getUniversiteLogo() {
        return universiteLogo;
    }

    public void setUniversiteLogo(String universiteLogo) {
        this.universiteLogo = universiteLogo;
    }
}
