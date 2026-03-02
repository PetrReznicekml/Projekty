package hra;

public class Mec {
    public String nazev;
    public int poskozeni;

    public Mec(String nazev, int poskozeni) {
        this.nazev = nazev;
        this.poskozeni = poskozeni;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public int getPoskozeni() {
        return poskozeni;
    }
}
