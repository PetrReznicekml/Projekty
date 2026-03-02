package hra;
import java.util.Random;
import java.util.Scanner;

public class Boj {
        public static void uvodUtok(Prisera prisera){
        Random random = new Random(); //Zaklad pro Nahodny cislo
        Scanner scanner = new Scanner(System.in);
        int postavaPoskozeni = Postava.getCelkovyPoskozeni(); //Poskozeni postavy se nastavy podle poctu Sily a poskozeni mece
        boolean PriseraStunned = false;
        boolean posledniUderAktivovan = false;

        System.out.println("Stojí před tebou příšera " + prisera.getJmeno() + " s " + prisera.getZivoty() + "/" + prisera.getMaxZivoty() + " životy.");
        System.out.println("Začíná souboj mezi " + Postava.getJmenoUzivatele() + " a " + prisera.getJmeno());

        while (Postava.aktualniZivoty() > 0 && prisera.getZivoty() > 0) { //Cyklus bezi dokud ma Postava a Prisera vice jak 0 zivotu
            System.out.println("\n-- Stav --"); // Vypis na konci kola
            System.out.println(Postava.getJmenoUzivatele() + ": " + Postava.aktualniZivoty() + "/" + Postava.dovednostZivot() + " životů");
            System.out.println(prisera.getJmeno() + ": " + prisera.getZivoty() + "/" + prisera.getMaxZivoty() + " životů");
            System.out.println("Mas pocet lektvaru: " + Postava.PocetLektvaru());

            if (prisera.getJmeno().contains("Eldarion") &&
                    Postava.aktualniZivoty() <= 20 &&
                    !posledniUderAktivovan) {

                Pribeh.printPosledniUder();
                posledniUderAktivovan = true;
            }

            //Akce pro zvoleni uzivatele
            System.out.println("\nZvol akci:");
            Pomlcka.pomlcka();
            System.out.println("(1) Útok");
            System.out.println("(2) Obrana");
            System.out.println("(3) Použití lektvaru");
            System.out.print("-> ");
            int volba = -1;
            while (volba < 1 || volba > 3) { //Kontrola vstupu
                if (scanner.hasNextInt()) {
                    volba = scanner.nextInt();
                    if (volba < 1 || volba > 3) {
                        System.out.println("Zadej číslo mezi 1 a 3!");
                    }
                }
                else { //Kdyz uzivatel zada spatny vstup
                    System.out.println("Neplatný vstup! Zadej číslo mezi 1 a 3!.");
                    System.out.println("(1) Útok");
                    System.out.println("(2) Obrana");
                    System.out.println("(3) Použití lektvaru");
                    scanner.next(); //Nacitani noveho inputu (Stary se smaze)
                }
            }

            // Uzivatel si zada co v boji chce udelat
            switch (volba) {
                case 1: //Utok
                    int damage = postavaPoskozeni + random.nextInt(5); //Poskozeni je podle Poskozeni (Sila) + radnom prida nahodne cislo od (0-4)
                    if (posledniUderAktivovan) {
                        damage *= 20; //20x větší poškození!
                        Postava.setAktualniZivoty(Postava.getMaxZ());
                        System.out.println("\nZ tvého meče vyšlehla oslepující záře!");
                        posledniUderAktivovan = false;
                    }
                    if (PriseraStunned) { //Kontrola, jestli Prisera neni omracena
                        //Kod kdyz je Prisera omracena (PriseraStunned == true)
                        PriseraStunned = false; //Nastavi se false, aby dalsi kolo nebyla uz omracena Prisera
                        System.out.println(Postava.getJmenoUzivatele() + " útočí a způsobí: " + damage + " poškození");
                        System.out.println(prisera.getJmeno() + " Je omráčena a nezpůsobí žádné poškození! + Příští kolo se efekt zruší");
                        prisera.setZivoty(prisera.getZivoty() - damage); //Pouze poskozeni postavy, protoze Prisera je omracena
                    }
                    else{ //Prisera, kdyz neni omracena
                        int priseraDmg = prisera.getPoskozeni() + random.nextInt(5); //Poskozeni je podle Poskozeni (Sila) + radnom prida nahodne cislo od (0-4)
                        if (prisera.getJmeno().contains("Eldarion")) {
                            priseraDmg = prisera.getPoskozeni();
                        }
                        prisera.setZivoty(prisera.getZivoty() - damage); //Odecteni zivotu podle toho kolik Postava dala poskozeni
                        Postava.setAktualniZivoty(Postava.aktualniZivoty() - priseraDmg); //Odecteni zivotu podle toho kolik Prisera dala poskozeni
                        System.out.println(Postava.getJmenoUzivatele() + " útočí a způsobí: " + damage + " poškození");
                        System.out.println(prisera.getJmeno() + " utoci a zpusobi: " + priseraDmg + " poskozeni");
                    }
                    break;
                case 2: //Obrana, kdyz Prisera neni omracena, tak da poskozeni Postave a Postava se brani plus ji da omraceni na pristi kolo. Kdyz je prisera omracena, tak Prisera neda zadny poskozeni a bude omracena pristi kolo
                    if (PriseraStunned) {
                        PriseraStunned = true;
                        System.out.println(prisera.getJmeno() + " je omráčena a nemůže zaútočit!");
                    }
                    else{
                        PriseraStunned = true;
                        int obrana = Postava.dovednostObratnost() - random.nextInt(3); //Obrana kolik zablokuje Postava utoku opici. Cislo bloku je obratnost Postavy + nahodne cislo (0-2)
                        int priserattack = prisera.getPoskozeni() + random.nextInt(5);
                        int reducedDamage = Math.max(0, priserattack - obrana);
                        Postava.setAktualniZivoty(Postava.aktualniZivoty() - reducedDamage);
                        System.out.println("Zabránil jsi " + obrana + " poškození.");
                        System.out.println(prisera.getJmeno() + " útočí a způsobí " + reducedDamage + " poškození.");
                    }
                    break;
                case 3: //Lektvar
                    if (Postava.aktualniZivoty() == Postava.dovednostZivot()) { // Podminka jestli nema uzivatel uz maximalni pocet zivotu
                        System.out.println("Máte maximální zdraví! Nelze použít lektvar. Zvolte jinou akci.");
                    }
                    else if (Postava.PocetLektvaru() > 0) {
                        int PocetVyleceni = 20; //Pocet kolik zivotu vyleci Lektvar
                        Postava.setAktualniZivoty(Math.min(Postava.aktualniZivoty() + PocetVyleceni, Postava.dovednostZivot())); //Propocteni Lektvaru k zivotum Postavy
                        Postava.pouzitiLektvaru(); //Odecteni lektvaru z inventare
                        System.out.println(Postava.getJmenoUzivatele() + " použil lektvar. Doplnil si " + PocetVyleceni + " životů.");
                    }
                    else {
                        System.out.println("Nemáš žádné lektvary!");
                    }
                    if (!PriseraStunned) { //Kontrola, jestli je Prisera omracena
                        //Prisera neni omracena utoci na Postavu
                        int priseraDmgL = prisera.getPoskozeni() + random.nextInt(5);
                        Postava.setAktualniZivoty(Postava.aktualniZivoty() - priseraDmgL);
                        System.out.println(prisera.getJmeno() + " útočí a způsobí: " + priseraDmgL + " poškození.");
                    } else { //Tady je omracena Prisera a zrusi se ji omraceni pristi kolo
                        PriseraStunned = false; // Stun wears off
                        System.out.println(prisera.getZivoty() + " Je omráčena a nezpůsobí žádné poškození! + Příští kolo se efekt zruší");
                    }
                    break;
                default:
                    System.out.println("Neplatná volba!");
            }
        }
        //Konec boje
            if (Postava.aktualniZivoty() > 0) {
                ClearConsole.clear();
                System.out.println("\n" + Postava.getJmenoUzivatele() + " Zvítězil jsi nad " + prisera.getJmeno() + "!");
                Postava.addXP(100);
                if (Postava.PocetLektvaru() < 3) {
                    Postava.pridaniLektvaru();
                    System.out.println("Za vítězství jsi získal jeden lektvar. Máš nyní: " + Postava.PocetLektvaru() + " lektvarů.");
                } else {
                    System.out.println("Nemůžeš nést více lektvarů! Máš maximální počet (3) v inventáři.");
                }
            } else {
                ClearConsole.clear();
                if (prisera.getJmeno().equals("opice")) {
                    System.out.println("\n" + prisera.getJmeno() + " Zvítězila!");
                }
                else {
                    System.out.println("\n" + prisera.getJmeno() + " Zvítězil!");
                }
                System.out.println("""
                        ----------------------------------------------------
                        KONEC HRY
                        ----------------------------------------------------""");
                Menu.konec();
            }

            System.out.println("\nStiskněte Enter pro pokračování...");
            new Scanner(System.in).nextLine();
        }
}