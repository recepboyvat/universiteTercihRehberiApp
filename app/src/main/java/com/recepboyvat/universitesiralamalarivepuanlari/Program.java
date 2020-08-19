package com.recepboyvat.universitesiralamalarivepuanlari;

public class Program {
        private int programKodu;
        private String bolumAdi;
        private int bursTuru;
        private int devletOrOzel;
        private String docantSayisi;
        private String doktorSayisi;
        private int genelKontenjan;
        private String ilkYerlesmeOrani;
        private String okulBirincisiKontenjani;
        private double okulBirincisiTabanPuani;
        private int okulBirincisiTabanSiralama;
        private String profSayisi;
        private String programAdi;
        private int puanTuru;
        private double tabanPuandokuz;
        private double tabanPuansekiz;
        private double tabanPuanyedi;
        private int tabanSiralamadokuz;
        private int tabanSiralamasekiz;
        private int tabanSiralamayedi;
        private double tavanPuandokuz;
        private double tavanPuansekiz;
        private double tavanPuanyedi;
        private int tavanSiralamadokuz;
        private int tavanSiralamasekiz;
        private int tavanSiralamayedi;
        private int toplamKontenjan;
        private String universiteAdi;
        private int lisansOrOnlisans;


        public Program(int programKodu, String bolumAdi, int bursTuru, int devletOrOzel, String docantSayisi, String doktorSayisi, int genelKontenjan, String ilkYerlesmeOrani, String okulBirincisiKontenjani, double okulBirincisiTabanPuani, int okulBirincisiTabanSiralama, String profSayisi, String programAdi, int puanTuru, double tabanPuandokuz, double tabanPuansekiz, double tabanPuanyedi, int tabanSiralamadokuz, int tabanSiralamasekiz, int tabanSiralamayedi, double tavanPuandokuz, double tavanPuansekiz, double tavanPuanyedi, int tavanSiralamadokuz, int tavanSiralamasekiz, int tavanSiralamayedi, int toplamKontenjan, String universiteAdi,int lisansOrOnlisans) {
            this.programKodu = programKodu;
            this.bolumAdi = bolumAdi;
            this.bursTuru = bursTuru;
            this.devletOrOzel = devletOrOzel;
            this.docantSayisi = docantSayisi;
            this.doktorSayisi = doktorSayisi;
            this.genelKontenjan = genelKontenjan;
            this.ilkYerlesmeOrani = ilkYerlesmeOrani;
            this.okulBirincisiKontenjani = okulBirincisiKontenjani;
            this.okulBirincisiTabanPuani = okulBirincisiTabanPuani;
            this.okulBirincisiTabanSiralama = okulBirincisiTabanSiralama;
            this.profSayisi = profSayisi;
            this.programAdi = programAdi;
            this.puanTuru = puanTuru;
            this.tabanPuandokuz = tabanPuandokuz;
            this.tabanPuansekiz = tabanPuansekiz;
            this.tabanPuanyedi = tabanPuanyedi;
            this.tabanSiralamadokuz = tabanSiralamadokuz;
            this.tabanSiralamasekiz = tabanSiralamasekiz;
            this.tabanSiralamayedi = tabanSiralamayedi;
            this.tavanPuandokuz = tavanPuandokuz;
            this.tavanPuansekiz = tavanPuansekiz;
            this.tavanPuanyedi = tavanPuanyedi;
            this.tavanSiralamadokuz = tavanSiralamadokuz;
            this.tavanSiralamasekiz = tavanSiralamasekiz;
            this.tavanSiralamayedi = tavanSiralamayedi;
            this.toplamKontenjan = toplamKontenjan;
            this.universiteAdi = universiteAdi;
            this.lisansOrOnlisans=lisansOrOnlisans;
        }

        public int getProgramKodu() {
            return programKodu;
        }

        public void setProgramKodu(int programKodu) {
            this.programKodu = programKodu;
        }

        public String getBolumAdi() {
            return bolumAdi;
        }

        public void setBolumAdi(String bolumAdi) {
            this.bolumAdi = bolumAdi;
        }

        public int getBursTuru() {
            return bursTuru;
        }

        public void setBursTuru(int bursTuru) {
            this.bursTuru = bursTuru;
        }

        public int getDevletOrOzel() {
            return devletOrOzel;
        }

        public void setDevletOrOzel(int devletOrOzel) {
            this.devletOrOzel = devletOrOzel;
        }

        public String getDocantSayisi() {
            return docantSayisi;
        }

        public void setDocantSayisi(String docantSayisi) {
            this.docantSayisi = docantSayisi;
        }

        public String getDoktorSayisi() {
            return doktorSayisi;
        }

        public void setDoktorSayisi(String doktorSayisi) {
            this.doktorSayisi = doktorSayisi;
        }

        public int getGenelKontenjan() {
            return genelKontenjan;
        }

        public void setGenelKontenjan(int genelKontenjan) {
            this.genelKontenjan = genelKontenjan;
        }

        public String getIlkYerlesmeOrani() {
            return ilkYerlesmeOrani;
        }

        public void setIlkYerlesmeOrani(String ilkYerlesmeOrani) {
            this.ilkYerlesmeOrani = ilkYerlesmeOrani;
        }

        public String getOkulBirincisiKontenjani() {
            return okulBirincisiKontenjani;
        }

        public void setOkulBirincisiKontenjani(String okulBirincisiKontenjani) {
            this.okulBirincisiKontenjani = okulBirincisiKontenjani;
        }

        public double getOkulBirincisiTabanPuani() {
            return okulBirincisiTabanPuani;
        }

        public void setOkulBirincisiTabanPuani(double okulBirincisiTabanPuani) {
            this.okulBirincisiTabanPuani = okulBirincisiTabanPuani;
        }

        public int getOkulBirincisiTabanSiralama() {
            return okulBirincisiTabanSiralama;
        }

        public void setOkulBirincisiTabanSiralama(int okulBirincisiTabanSiralama) {
            this.okulBirincisiTabanSiralama = okulBirincisiTabanSiralama;
        }

        public String getProfSayisi() {
            return profSayisi;
        }

        public void setProfSayisi(String profSayisi) {
            this.profSayisi = profSayisi;
        }

        public String getProgramAdi() {
            return programAdi;
        }

        public void setProgramAdi(String programAdi) {
            this.programAdi = programAdi;
        }

        public int getPuanTuru() {
            return puanTuru;
        }

        public void setPuanTuru(int puanTuru) {
            this.puanTuru = puanTuru;
        }

        public double getTabanPuandokuz() {
            return tabanPuandokuz;
        }

        public void setTabanPuandokuz(double tabanPuandokuz) {
            this.tabanPuandokuz = tabanPuandokuz;
        }

        public double getTabanPuansekiz() {
            return tabanPuansekiz;
        }

        public void setTabanPuansekiz(double tabanPuansekiz) {
            this.tabanPuansekiz = tabanPuansekiz;
        }

        public double getTabanPuanyedi() {
            return tabanPuanyedi;
        }

        public void setTabanPuanyedi(double tabanPuanyedi) {
            this.tabanPuanyedi = tabanPuanyedi;
        }

        public int getTabanSiralamadokuz() {
            return tabanSiralamadokuz;
        }

        public void setTabanSiralamadokuz(int tabanSiralamadokuz) {
            this.tabanSiralamadokuz = tabanSiralamadokuz;
        }

        public int getTabanSiralamasekiz() {
            return tabanSiralamasekiz;
        }

        public void setTabanSiralamasekiz(int tabanSiralamasekiz) {
            this.tabanSiralamasekiz = tabanSiralamasekiz;
        }

        public int getTabanSiralamayedi() {
            return tabanSiralamayedi;
        }

        public void setTabanSiralamayedi(int tabanSiralamayedi) {
            this.tabanSiralamayedi = tabanSiralamayedi;
        }

        public double getTavanPuandokuz() {
            return tavanPuandokuz;
        }

        public void setTavanPuandokuz(double tavanPuandokuz) {
            this.tavanPuandokuz = tavanPuandokuz;
        }

        public double getTavanPuansekiz() {
            return tavanPuansekiz;
        }

        public void setTavanPuansekiz(double tavanPuansekiz) {
            this.tavanPuansekiz = tavanPuansekiz;
        }

        public double getTavanPuanyedi() {
            return tavanPuanyedi;
        }

        public void setTavanPuanyedi(double tavanPuanyedi) {
            this.tavanPuanyedi = tavanPuanyedi;
        }

        public int getTavanSiralamadokuz() {
            return tavanSiralamadokuz;
        }

        public void setTavanSiralamadokuz(int tavanSiralamadokuz) {
            this.tavanSiralamadokuz = tavanSiralamadokuz;
        }

        public int getTavanSiralamasekiz() {
            return tavanSiralamasekiz;
        }

        public void setTavanSiralamasekiz(int tavanSiralamasekiz) {
            this.tavanSiralamasekiz = tavanSiralamasekiz;
        }

        public int getTavanSiralamayedi() {
            return tavanSiralamayedi;
        }

        public void setTavanSiralamayedi(int tavanSiralamayedi) {
            this.tavanSiralamayedi = tavanSiralamayedi;
        }

        public int getToplamKontenjan() {
            return toplamKontenjan;
        }

        public void setToplamKontenjan(int toplamKontenjan) {
            this.toplamKontenjan = toplamKontenjan;
        }

        public String getUniversiteAdi() {
            return universiteAdi;
        }

        public void setUniversiteAdi(String universiteAdi) {
            this.universiteAdi = universiteAdi;
        }

    public int getLisansOrOnlisans() {
        return lisansOrOnlisans;
    }

    public void setLisansOrOnlisans(int lisansOrOnlisans) {
        this.lisansOrOnlisans = lisansOrOnlisans;
    }

}
