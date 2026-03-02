package hra;
import java.util.Scanner;

public class Postava {
    private static String jmenoUzivatele;
    private static String klass;
    private static int Z; // Zdravi
    private static int MaxZ;
    private static int S; // Sila
    private static int O; // Obratnost
    private static int L; // Level
    private static int  XP = 0; // Postava kolik ma zkusenotnich bodu
    private static final int XP_PER_LEVEL = 100; // Potreba zkusenosti na dalsi level
    private static int availablePoints = 0;
    private static int lektvar = 2;
    private static Mec mecVybaven;

    public Postava(int S, int O, int Z) {
        Postava.S = S;
        Postava.O = O;
        Postava.Z = Z;
    }

    static {
        Z = MaxZ; // Na zacatku se inicializuje aktualni pocet zivotu s maximalnim poctem
    }

    public static int getMaxZ() {
        return MaxZ;
    }

    public static String getJmenoUzivatele() { //Pro vypsani jmeno uzivatele
        return jmenoUzivatele;
    }

    public static void setJmenoUzivatele(String newJmenoUzivatele) { //Pro nastaveni jmeno uzivatele
        jmenoUzivatele = newJmenoUzivatele;
    }

    public static String getKlass() {
        return klass;
    }

    public static void setKlass(String newKlass) {
        klass = newKlass;
        switch (newKlass.toLowerCase()) {
            case "human":
                MaxZ = 100;
                O = 10;
                break;
            case "elf":
                MaxZ = 90;
                S = 10;
                O = 15;
                break;
            case "orc":
                MaxZ = 110;
                S = 15;
                O = 10;
                break;
            default: //zaklad se nastavi human
                MaxZ = 100;
                S = 10;
                O = 10;
                break;
        }
        Z = MaxZ; // Doplní aktuální životy do plna
    }
    public static boolean isKlass(String targetKlass) { //Jestli je vstup uzivatele rovny jednomu z vyberu z klass

        return klass != null && klass.equalsIgnoreCase(targetKlass);
    }

    public static int dovednostZivot() { //Maximalni pocet zivotu

        return MaxZ;
    }

    public static int aktualniZivoty(){ //Kolik ma postava zivotu

        return Z;
    }

    public static void setAktualniZivoty(int zivoty) { //Pro nastaveni zivotu v boji

        Z = Math.max(0, zivoty);
    }

    public static int dovednostSila() { //Vraci kolik ma dana klasa Silu

        return S;
    }

    public static int dovednostObratnost() {//Vraci kolik ma dana klasa Obratnost

        return O;
    }

    public static int dovednostLvl() { //Vraci kolik ma dany uzivatel level

        return L;
    }

    public static int getXP() { //Vraci kolik dostane uzivatelu zkusenosti za boj

        return XP;
    }

    public static int PocetLektvaru(){ //Vraci kolik ma uzivatel pocet lektvaru v inventari

        return lektvar;
    }

    public static int pouzitiLektvaru() { //Pro pouziti Lektvaru
        lektvar = Math.max(0, lektvar - 1); //Zajisti, aby pocet lektvaru nebyl negativni
        return lektvar;
    }

    public static void pridaniLektvaru() {

        lektvar++; // Prida 1 Lektvar
    }

    public static void addXP(int amount) { //Pridani pocet xp Uzivateli do statistik
        XP += amount;
        System.out.println(jmenoUzivatele + "Získal " + amount + " XP!");
        checkLevelUp(); //Kontrola, jestli uzivatel nema dostatecny pocet zkusenosti na level up
    }

    public static void setVybavMec(Mec mec) {
        mecVybaven = mec;
        System.out.println("Vybaveny mec: " + mec);
    }
    public static Mec getVybavMec() {
        return mecVybaven;
    }

    public static void levelUpDistribution() { //Pro dovednostni body Postavy
        Scanner scanner = new Scanner(System.in);
        availablePoints = 5; //Pocet kolik dovednostnich bodu dostane za level up

        while (availablePoints > 0) {

            int choice = -1; // Inicializace volbu (choice) s neplatnou hodnotou
            while (true) { //Cyklus se opakuje dokud uzivatel nerozdelil vsechny dovednosti body
                System.out.println("\nMáte k dispozici " + availablePoints + " bodů k rozdělení.");
                System.out.println("Kam chcete přidat bod?");
                System.out.print("Volba (1-3): \n");
                Pomlcka.pomlcka();
                System.out.println("1. Životy (Z): " + MaxZ);
                System.out.println("2. Síla (S): " + S);
                System.out.println("3. Obratnost (O): " + O);
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    if (choice >= 1 && choice <= 3) {   // Ověření, že volba je v rozsahu 1-3
                        break; // Platný vstup, ukonči cyklus
                    } else {
                        System.out.println("Zadej číslo mezi 1 a 3!"); //Chybová zpráva pro neplatný rozsah
                    }
                } else {
                    System.out.println("Neplatný vstup! Zadej číslo."); //Chybová zpráva pro nečíselný vstup
                    scanner.next(); //Odstranění neplatného vstupu ze scanneru
                }
            }
            switch (choice) {
                case 1:
                    MaxZ += 5;  // Zvyseni zdravi o 5
                    availablePoints--; //Odpocita 1 bod potom co si pridal 1 bod
                    break;
                case 2:
                    S += 1;  // Zvyseni sily o 1
                    availablePoints--; //Odpocita 1 bod potom co si pridal 1 bod
                    break;
                case 3:
                    O += 1;  // Zvyseni obratnosti o 1
                    availablePoints--; //Odpocita 1 bod potom co si pridal 1 bod
                    break;
                default:
                    System.out.println("Neplatná volba!"); // kdyz uzivatel bude chtit zadat neco jineho nez je volba
                    break;
            }
        }
        ClearConsole.clear();
        System.out.println("Aktuální statistiky:");
        System.out.println("Životy: " + Z + ", Síla: " + S + ", Obratnost: " + O);
        System.out.println("\nStiskněte Enter pro pokračování...");
        new Scanner(System.in).nextLine();
    }
    //Kontroluje jestli postava nema dost xpu na level up a prida level nahoru a vypise jaky level uzivatel dosahnul
    private static void checkLevelUp() {
        if (XP >= XP_PER_LEVEL) {
            XP -= XP_PER_LEVEL;
            L++;
            System.out.println("Gratulujeme! " + jmenoUzivatele + "postoupil na úroveň " + L + "!");
            levelUpDistribution(); //Zde se uzivatel dostane k 5 dovednostnim bodum za level up
        }
    }

    public static void vypisPostavy() { //Vypise udaje Postavy co zadal uzivatel
        ClearConsole.clear();
        System.out.println("\nULOŽENÉ NASTAVENÍ POSTAVY");
        Pomlcka.pomlcka();
        System.out.println("Jméno: " + getJmenoUzivatele());
        System.out.println("Classa: " + getKlass());
        System.out.println("Level: " + dovednostLvl() + ", XP: " + XP);
        System.out.println("Životy: " + dovednostZivot() + ", Síla: " + dovednostSila() + ", Obratnost: " + dovednostObratnost() + "\n");
    }
    public static int getCelkovyPoskozeni(){
        int celkovePoskozeni = dovednostSila() + mecVybaven.getPoskozeni();
        return celkovePoskozeni;
    }
}
