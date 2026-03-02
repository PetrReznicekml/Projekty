package hra;

import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClearConsole.clear();
        System.out.println("======================================");
        System.out.println("            VÝTEJ VE HŘE ");

        System.out.println("            POSLEDNÍ ÚDER");
        System.out.println("======================================");

        System.out.println("pro pokračování stiskni enter...");

        scanner.nextLine();
        ClearConsole.clear();



        // Vytvoření postavy
        System.out.print("Zadej jméno uživatele: ");
        Postava.setJmenoUzivatele(scanner.nextLine());
        if (Postava.getJmenoUzivatele().isEmpty()){
            Postava.setJmenoUzivatele(scanner.nextLine());
        }
        System.out.print("Zadejte classu postavy (human, elf, orc): ");
        Postava.setKlass(scanner.nextLine().toLowerCase(Locale.ROOT));
        Postava.vypisPostavy();

        // Úprava postavy
        while (true) {
            System.out.println("Chcete něco upravit (j=jméno, r=rasa, p=pohlaví, c=classa, n=dál už nechci nic upravovat)?");
            char zmenaPostavy = scanner.next().toLowerCase(Locale.ROOT).charAt(0);
            scanner.nextLine();

            if (zmenaPostavy == 'j') {
                System.out.print("Zadej jméno uživatele: ");
                Postava.setJmenoUzivatele(scanner.nextLine());
            } else if (zmenaPostavy == 'c') {
                System.out.print("Zadejte classu postavy: ");
                Postava.setKlass(scanner.nextLine());
            } else if (zmenaPostavy == 'n') {
                System.out.println("Postava se ukládá.\n");
                break;
            }
            Postava.vypisPostavy();
        }

        boolean running = true; //True dokud chceme hrat
        int kapitola = 1;
        while (running) {
            ClearConsole.clear();
            int menuChoice = Menu.zakladniMenu(); //Pro vyber uzivatele co chce zobrazit

            switch (menuChoice) {
                case 1: // Pokracovani pribehu
                    ClearConsole.clear();
                    if (kapitola == 1) {
                        Mec drevenyMec = new Mec("Dřevěný Meč", 5);
                        Postava.setVybavMec(drevenyMec);
                        Pribeh.printIntro1();
                        System.out.println("\nStiskněte Enter pro boj s Opicí...");
                        new Scanner(System.in).nextLine();
                        ClearConsole.clear();

                        // Vytvoreni opice
                        Prisera opice = new Prisera("Opice", 50, 50, 10);
                        Boj.uvodUtok(opice);

                        // Pokud postava prezila, posouvame ji na kapitolu 2
                        if (Postava.aktualniZivoty() > 0) {
                            Pribeh.printOutro1();
                            Mec ocelovyMec = new Mec("Ocelový Meč", 10);
                            kapitola = 2;
                        }
                    }
                    else if (kapitola == 2) {
                        Pribeh.printIntro2();
                        System.out.println("\nStiskněte Enter pro boj s Vlkem...");
                        new Scanner(System.in).nextLine();
                        ClearConsole.clear();

                        // Vytvorim vlka s jinymi staty
                        Prisera vlk = new Prisera("Vlk", 60, 60, 15);
                        Boj.uvodUtok(vlk);

                        if (Postava.aktualniZivoty() > 0) {
                            Pribeh.printOutro2();
                            Mec zlatyMec = new Mec("Zlatý Meč", 15);
                            kapitola = 3;
                        }
                    }
                    else if (kapitola == 3) {
                        Pribeh.printIntro3();
                        System.out.println("\nStiskněte Enter pro boj s Drakem...");
                        new Scanner(System.in).nextLine();
                        ClearConsole.clear();
                        // Vytvoreni draka
                        Prisera drak = new Prisera("Eldarion", 500, 500, 20);
                        Boj.uvodUtok(drak);
                        if (Postava.aktualniZivoty() > 0) {
                            Pribeh.printOutro3();
                            new Scanner(System.in).nextLine();
                            ClearConsole.clear();
                            System.out.println("Došel jsi na konec aktuálního příběhu! Gratuluji!");
                            System.out.println("\nStiskněte Enter pro návrat...");
                            new Scanner(System.in).nextLine();
                            running = false;
                            }
                }
                    break;
                case 2: // Informace o postave
                    InfoPostava.infoPostava();
                    break;
                case 3: // konceni hry
                    ClearConsole.clear();
                    System.out.println("--------------------------------------");
                    System.out.println("              KONEC HRY                ");
                    System.out.println("--------------------------------------");
                    System.out.println(" ");
                    System.out.println("Hru vytvořil: Legenda Vývojářů ");
                    System.out.println("--------------------------------------");
                    running = false; // boolean se nastavi false, to znamena ze se zastavi hra
                    break;
            }
        }
        scanner.close();
    }
}
