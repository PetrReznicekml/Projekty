package Prekladac;

import java.util.Scanner;

public class JazykovyPrekladac {
    private final Slovnik slovnik;
    private final File fileSlovnik;
    private final Scanner scanner;

    public JazykovyPrekladac() {
        this.slovnik = new Slovnik();
        this.fileSlovnik = new File("prekladacEN.txt", "prekladacCZ.txt");
        this.scanner = new Scanner(System.in);
    }

    public void spustit() {
        fileSlovnik.nacist(slovnik);
        int choice;

        do {
            vypastMenu();
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                choice = -1;
                scanner.nextLine();
            }

            switch (choice) {
                case 1:
                    pridatSlovicko();
                    break;
                case 2:
                    prelozitSlovicko();
                    break;
                case 3:
                    aktualizaceSlovicka();
                    break;
                case 4:
                    fileSlovnik.vymazaniFile();
                    slovnik.vymazat();
                    break;
                case 5:
                    fileSlovnik.vypsaniSlovZeSlovniku();
                    break;
                case 6:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }

    private void vypastMenu() {
        System.out.println("\nJazykovy Prekladac");
        System.out.println("1. Pridej nove slovo");
        System.out.println("2. Preloz slovo");
        System.out.println("3. Uprav slovicko ze slovniku");
        System.out.println("4. Vymaz textaky");
        System.out.println("5. Vypis slova z textaku");
        System.out.println("6. Exit");
        System.out.print("Zadej vyber: ");
    }

    private void pridatSlovicko() {
        System.out.print("Zadej Anglicke slovo: ");
        String anglicky = osetreniVstupu(scanner.nextLine());
        if (anglicky.isEmpty()) return;

        System.out.print("Zadej Ceske slovo: ");
        String czech = osetreniVstupu(scanner.nextLine());
        if (czech.isEmpty()) return;

        slovnik.pridatSlovicko(anglicky, czech);
        fileSlovnik.ulozit(slovnik);
        System.out.println("Slova pridana do slovniku");
    }

    private void prelozitSlovicko() {
        System.out.print("Vyber jazyk (1=Anglicky slovicko, 2=Ceske slovicko): ");
        int langChoice = -1;
        if (scanner.hasNextInt()) {
            langChoice = scanner.nextInt();
            scanner.nextLine();
        }

        if (langChoice == 1) {
            System.out.print("Zadej Anglicke slovicko: ");
            String vstup = osetreniVstupu(scanner.nextLine());
            String preklad = slovnik.prekladDoCestiny(vstup);
            vysledekPrekladu(vstup, preklad, 1);
        } else if (langChoice == 2) {
            System.out.print("Zadej Ceske slovicko: ");
            String vstup = osetreniVstupu(scanner.nextLine());
            String preklad = slovnik.prekladDoAnglictiny(vstup);
            vysledekPrekladu(vstup, preklad, 2);
        } else {
            System.out.println("Neplatny vyber jazyka");
        }
    }

    private void aktualizaceSlovicka() {
        System.out.print("Jaky jazyk slovicka chces aktulizovat? (1=Anglicky, 2=Ceske): ");
        int langChoice = -1;
        if (scanner.hasNextInt()) {
            langChoice = scanner.nextInt();
            scanner.nextLine();
        }

        if (langChoice == 1) {
            System.out.print("Zadej Anglicke slovicko na aktulizaci: ");
            String anglictina = osetreniVstupu(scanner.nextLine());

            if (slovnik.prekladDoCestiny(anglictina) == null) {
                System.out.println("Slovicko jsme nenasli v slovniku");
                return;
            }

            System.out.print("Zadej novy Cesky preklad: ");
            String novyCesky = osetreniVstupu(scanner.nextLine());
            slovnik.aktualizaceAnglickehoPrekladu(anglictina, novyCesky);

        } else if (langChoice == 2) {
            System.out.print("Zadej Ceske slovicko na aktulizaci: ");
            String cestina = osetreniVstupu(scanner.nextLine());

            if (slovnik.prekladDoAnglictiny(cestina) == null) {
                System.out.println("Slovicko jsme nenasli v slovniku");
                return;
            }

            System.out.print("Zadej novy Anglicky preklad: ");
            String novyAnglicky = osetreniVstupu(scanner.nextLine());
            slovnik.aktualizaceAnglickehoPrekladu(cestina, novyAnglicky);

        } else {
            System.out.println("Spatny vyber");
            return;
        }

        fileSlovnik.ulozit(slovnik);
        System.out.println("Slovicko aktulizovano a zapsano");
    }

    private void vysledekPrekladu(String vstup, String preklad, int smerPrekladu) {
        if (preklad != null) {
            System.out.println("Preklad: " + preklad);
        } else {
            chybejiciSlovicko(vstup, smerPrekladu);
        }
    }

    private void chybejiciSlovicko(String vstup, int smerPrekladu) {
        System.out.println("K tomuhle slovicku jeste neexistuje preklad");
        System.out.print("Zadej 1 pro pridani prekladu, 2 pro preskoceni: ");

        int choice = -1;
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            scanner.nextLine();
        }

        if (choice == 1) {
            System.out.print("Zadej preklad: ");
            String novyPreklad = osetreniVstupu(scanner.nextLine());

            if (smerPrekladu == 1) {
                slovnik.pridatSlovicko(vstup, novyPreklad);
            } else {
                slovnik.pridatSlovicko(novyPreklad, vstup);
            }
            fileSlovnik.ulozit(slovnik);
            System.out.println("Slovicko pridano");
        }
    }

    private String osetreniVstupu(String vstup) {
        return vstup.replaceAll("[^a-zA-Z]", "").toLowerCase().trim();
    }
}