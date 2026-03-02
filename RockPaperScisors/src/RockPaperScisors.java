import java.util.Random;
import java.util.Scanner;

public class RockPaperScisors {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] a = {"Kamen", "Nuzky", "Papir"};
        Random number = new Random();
        boolean win = false;
        int r = number.nextInt(3);
        while (win == false){
            System.out.println("Vyber mezi 1-3 {\"Kamen\", \"Nuzky\", \"Papir\"}.");
            System.out.println("Pro opusteni zadej cislo mimo 1-3");
            int userInput = sc.nextInt()-1;
            switch (userInput){
                case 0:
                    if (userInput == r){
                        System.out.println("Remiza!");
                        System.out.println("Vybral jsi: " + a[userInput]);
                        System.out.println("Pocitac vybral: " + a[r]);
                    }
                    if(userInput == 0 && r == 1){
                        System.out.println("Vyhral jsi");
                        System.out.println("Vybral jsi: " + a[userInput]);
                        System.out.println("Pocitac vybral: " + a[r]);
                        System.out.println("Chces hrat znovu? 1 - ANO, 2 - NE");
                        if (sc.nextInt() == 2){
                            win = true;
                        }
                }
                    if(userInput == 0 && r == 2){
                        System.out.println("Prohral jsi");
                        System.out.println("Vybral jsi: " + a[userInput]);
                        System.out.println("Pocitac vybral: " + a[r]);
                        System.out.println("Chces hrat znovu? 1 - ANO, 2 - NE");
                        if (sc.nextInt() == 2){
                            win = true;
                        }
                    }
                    break;
                case 1:
                    if (userInput == r){
                        System.out.println("Remiza!");
                        System.out.println("Vybral jsi: " + a[userInput]);
                        System.out.println("Pocitac vybral: " + a[r]);
                    }
                    if(userInput == 1 && r == 2){
                        System.out.println("Vyhral jsi");
                        System.out.println("Vybral jsi: " + a[userInput]);
                        System.out.println("Pocitac vybral: " + a[r]);
                        System.out.println("Chces hrat znovu? 1 - ANO, 2 - NE");
                        if (sc.nextInt() == 2){
                            win = true;
                        }
                    }
                    if(userInput == 1 && r == 0){
                        System.out.println("Prohral jsi");
                        System.out.println("Vybral jsi: " + a[userInput]);
                        System.out.println("Pocitac vybral: " + a[r]);
                        System.out.println("Chces hrat znovu? 1 - ANO, 2 - NE");
                        if (sc.nextInt() == 2){
                            win = true;
                        }
                    }
                    break;
                case 2:
                    if (userInput == r){
                        System.out.println("Remiza!");
                        System.out.println("Vybral jsi: " + a[userInput]);
                        System.out.println("Pocitac vybral: " + a[r]);
                    }
                    if(userInput == 2 && r == 0){
                        System.out.println("Vyhral jsi");
                        System.out.println("Vybral jsi: " + a[userInput]);
                        System.out.println("Pocitac vybral: " + a[r]);
                        System.out.println("Chces hrat znovu? 1 - ANO, 2 - NE");
                        if (sc.nextInt() == 2){
                            win = true;
                        }
                    }
                    if(userInput == 2 && r == 1){
                        System.out.println("Prohral jsi");
                        System.out.println("Vybral jsi: " + a[userInput]);
                        System.out.println("Pocitac vybral: " + a[r]);
                        System.out.println("Chces hrat znovu? 1 - ANO, 2 - NE");
                        if (sc.nextInt() == 2){
                            win = true;
                        }
                    }
                    break;
                default:
                    win = true;
            }
        }
        sc.close();
        System.out.println("Diky za hrani :)");
    }
}
