package hra;

import java.util.Scanner;

public class Pribeh {

    public static void printIntro1(){
        ClearConsole.clear();
        System.out.println("Kapitola 1: PROBUZENÍ");
        Pomlcka.pomlcka();
        System.out.println("Procitáš uprostřed spálených ruin své vesnice. Obloha je rudá a vzduch těžký dýmem.");
        System.out.println("Legenda praví, že svět umírá pod křídly Prastarého Draka, jehož šupiny neprosekne žádná ocel. ");
        System.out.println("Mezi ohořelými trámy tvého domu spatříš svou jedinou naději – starý cvičný DŘEVĚNÝ MEČ.");
        System.out.println("Není to moc, ale v rukou hrdiny může i dřevo změnit osud. První zkouška na tebe čeká v křoví...");
        System.out.println("První, co vidíš, je zmutovaná opice s planoucíma očima. Je to jen posel zkázy.");
        Pomlcka.pomlcka();
    }
    public static void printOutro1(){
        System.out.println("Kapitola 1: PRVNÍ KOV");
        Pomlcka.pomlcka();
        System.out.println("Cesta tě vede do hlubokých hor. Mlha je tak hustá, že nevidíš na krok.");
        System.out.println("Železný meč ti v dlaních ledově studí, ale tvé srdce hoří odhodláním.");
        System.out.println("Náhle se ozve zavytí a obrovský vlk, větší než kůň, ti zastoupí cestu.");
        System.out.println("Je to strážce prahu, který nepustí nikoho k dračí sluji.");
        Pomlcka.pomlcka();
        System.out.println("\nStiskněte Enter pro pokračování...");
        new Scanner(System.in).nextLine();
    }
    public static void printIntro2(){
        ClearConsole.clear();
        System.out.println("Kapitola 2: HORSKÝ PRŮSMYK");
        Pomlcka.pomlcka();
        System.out.println("Vlk zmizel v mlze a cesta k dračí sluji je volná. Na zemi nacházíš starobylý amulet.");
        System.out.println("Jakmile se dotkne střepu, který už máš, spojí se v jedno a tvá hruď se rozzáří.");
        System.out.println("Z jeskyně se ozve dunění a před tebou se ve skále zjeví ZLATÝ MEČ – čepel ukovaná bohy.");
        System.out.println("V hlavě slyšíš šepot: Pouze ten, kdo udeří jako poslední, může změnit osud.");
        Pomlcka.pomlcka();
    }
    public static void printOutro2(){
        System.out.println("Kapitola 2: ZÁŘE LEGENDY");
        Pomlcka.pomlcka();
        System.out.println("Vlk zmizel v mlze. Na zemi leží starobylý amulet. Jakmile se dotkne střepu, který už máš, spojí se v jedno.");
        System.out.println("V hlavě slyšíš šepot bohů: ‚Pouze ten, kdo udeří jako poslední, může změnit osud.");
        Pomlcka.pomlcka();
        System.out.println("\nStiskněte Enter pro pokračování...");
        new Scanner(System.in).nextLine();

    }
    public static void printIntro3(){
        ClearConsole.clear();
        System.out.println("Kapitola 3: Poslední Úder (Drak)");
        Pomlcka.pomlcka();
        System.out.println("Stojíš na vrcholu světa. Před tebou se tyčí Eldarion – Prastarý Drak.");
        System.out.println(" Jeho dech spaluje skály na prach. Tvůj zlatý meč se v porovnání s ním zdá jako párátko.");
        System.out.println("Drak se ti směje: Smrtelníku, tisíc hrdinů přede mnou padlo. Proč bys ty měl být jiný?");
        Pomlcka.pomlcka();

    }

    public static void printPosledniUder(){
        ClearConsole.clear();
        Pomlcka.pomlcka();
        System.out.println("!!! BOŽÍ DAR AKTIVOVÁN !!!");
        System.out.println("Když už ti docházejí síly, amulet na tvé hrudi vybuchne oslnivým světlem. Čas se zastaví.");
        System.out.println("Cítíš v sobě dar bohů – Schopnost: Poslední Úder.");
        System.out.println("Tvé paže vedou síly samotného stvoření. Nyní drak poprvé cítí strach.");
        Pomlcka.pomlcka();
        System.out.println("\nStiskněte Enter pro pokračování...");
        new Scanner(System.in).nextLine();

    }

    public static void printOutro3(){
        System.out.println("KONEC PŘÍBĚHU");
        Pomlcka.pomlcka();
        System.out.println("Drak se hroutí k zemi a mění se v prach. Obloha se čistí a poprvé po sto letech vychází slunce.");
        System.out.println("Svět je zachráněn. Tvé jméno bude navždy zapsáno v hvězdách jako jméno hrdiny,");
        System.out.println("který v pravý čas zasadil ten nejdůležitější úder.");
        Pomlcka.pomlcka();
        System.out.println("\nStiskněte Enter pro pokračování...");
        new Scanner(System.in).nextLine();
    }
}
