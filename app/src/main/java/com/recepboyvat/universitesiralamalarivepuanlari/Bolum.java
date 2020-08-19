package com.recepboyvat.universitesiralamalarivepuanlari;

public class Bolum {
    private String bolumAdi;
    private String bolumResmi;

    public Bolum(String bolumAdi, String bolumResmi) {
        this.bolumAdi = bolumAdi;
        this.bolumResmi = bolumResmi;
    }

    public String getBolumAdi() {
        return bolumAdi;
    }

    public void setBolumAdi(String bolumAdi) {
        this.bolumAdi = bolumAdi;
    }

    public String getBolumResmi() {
        return bolumResmi;
    }

    public void setBolumResmi(String bolumResmi) {
        this.bolumResmi = bolumResmi;
    }
}
