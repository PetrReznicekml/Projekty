package hra;


import java.util.Scanner;

public class InfoPostava {


    public static void infoPostava(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            ClearConsole.clear();
        System.out.println("--------------------------------------");
        System.out.println("INFORMACE O TVÉ POSTAVĚ");
        System.out.println("--------------------------------------");
        System.out.println(Postava.getJmenoUzivatele()+"    " + "LVL: " + Postava.dovednostLvl() +"    "+"HP: " + Postava.aktualniZivoty() + "/" + Postava.dovednostZivot());
        System.out.println("--------------------------------------");
        System.out.println( "Obratnost: "+ Postava.dovednostObratnost() + "    "+ "Síla : "+ Postava.dovednostSila());
        if (Postava.getVybavMec() == null){
            System.out.println("Mas vybaveny: Ruce, poskozeni 0");
        }
        if (Postava.getVybavMec() != null) {
            System.out.println("--------------------------------------");
            System.out.println("Mas vybaveny mec: " + Postava.getVybavMec().getNazev() + ", poskoznei: " + Postava.getVybavMec().getPoskozeni());
        }
            System.out.println("Zvol akci:");
            System.out.println("(1) Vypít lektvar (+20 HP)");
            System.out.println("(0) Návrat do hlavního menu");
            String volba = sc.nextLine().trim();
            if (volba.isEmpty()) {
                continue;
            }
            if (volba.equals("1")) {
                // Hráč chce pít lektvar
                if (Postava.PocetLektvaru() <= 0) {
                    System.out.println("\nNemáš žádné lektvary!");
                    System.out.println("Stiskněte Enter pro pokračování...");
                    sc.nextLine();
                }
                else if (Postava.aktualniZivoty() >= Postava.getMaxZ()) {
                    System.out.println("\nUž máš maximální počet životů!");
                    System.out.println("Stiskněte Enter pro pokračování...");
                    sc.nextLine();
                }
                else {
                    int PocetVyleceni = 20;
                    Postava.setAktualniZivoty(Math.min(Postava.aktualniZivoty() + PocetVyleceni, Postava.getMaxZ()));
                    Postava.pouzitiLektvaru(); // Odečte lektvar

                    System.out.println("\nVypil jsi lektvar a doplnil si 20 HP!");
                    System.out.println("Stiskněte Enter pro pokračování...");
                    sc.nextLine();
                }
            }
            else if (volba.equals("0")) {
                break;
            }
            else {
                System.out.println("\nNeplatná volba! Zadej 1 nebo 0.");
                System.out.println("Stiskněte Enter pro pokračování...");
                sc.nextLine();
            }
        }
        ClearConsole.clear();
    }
}
