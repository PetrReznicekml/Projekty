package hra;

import java.util.Scanner;

public class Menu {
    private static int odpoved;

    public static int getOdpoved() {
        return odpoved;
    }

    public static void konec() {
        System.out.println("Prohral jsi nulo");
        System.exit(0);
    }

    public static int zakladniMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (Postava.aktualniZivoty() < 20) {
                System.out.println("Doporučujeme si doplnit životy");
                System.out.println("Životy si můžeš doplnit ve výběru 2");
                Pomlcka.pomlcka();
            }

            System.out.println("Vyber si akci:");
            Pomlcka.pomlcka();
            System.out.println("(1) Pokračovat v příběhu");
            System.out.println("(2) Informace o postavě (Zde si můžeš doplnit životy)");
            System.out.println("(3) Konec hry");
            System.out.print("-> ");

            if (sc.hasNextInt()) {
                odpoved = sc.nextInt();
                if (odpoved >= 1 && odpoved <= 3) {
                    return odpoved; // Valid input is returned
                } else {
                    System.out.println("Zadej číslo mezi 1 a 3!");
                }
            } else {
                System.out.println("Neplatný vstup! Zadej číslo.");
                sc.next(); // Discard invalid input Smaze neplatny vstup od uzivatele
            }
        }
    }
}