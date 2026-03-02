package hra;

public class Prisera {
    private String jmeno;
    private int zivoty;
    private int maxZivoty;
    private int poskozeni;

    public Prisera(String jmeno, int zivoty, int maxZivoty, int poskozeni) {
        this.jmeno = jmeno;
        this.zivoty = zivoty;
        this.maxZivoty = maxZivoty;
        this.poskozeni = poskozeni;

    }

    public String getJmeno() {
        return jmeno;
    }

    public int getZivoty() {
        return zivoty;
    }

    public int getMaxZivoty() {
        return maxZivoty;
    }

    public void setZivoty(int zivoty) {
        this.zivoty = Math.max(0, zivoty);
    }

    public int getPoskozeni() {
        return poskozeni;
    }

}
