package hra;

public class Mec {
    private String nazev;
    private int poskozeni;

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
