void main() {
    boolean close = false;
    boolean first = false;
    int year = 0;
    int month = 0;
    int deposit = 0;
    boolean input;
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> depositHistory = new ArrayList<>();
    while (!close) {
        input = false;
        int choose = 0;
            do {
                try {
                    IO.println("Vyber mezi moznosti 1-3");
                    IO.println("1 - Kalkulacka uspor");
                    IO.println("2 - Zjistit kolik si usetril/a");
                    IO.println("3 - Exit");
                    choose = sc.nextInt();
                    if (choose >= 1 && choose <= 3) {
                        input = true;
                    } else {
                        IO.println("Chyba: Musis zadat cislo 1, 2, nebo 3.");
                    }
                } catch (InputMismatchException e) {
                    IO.println("Tohle neni ciso, zkus to znovu");
                    sc.nextLine();
                }
            }
            while (!input);
        if (!first) {
            if (choose == 2) {
                IO.println("Nejdriv musis zadat data");
                continue;
            }
            first = true;
        }
        switch (choose) {
            case 1:
                depositHistory.clear();
                int savings = 0;
                input = false;
                while (!input) {
                    try {
                        IO.println("Kolik let chces sporit?");
                        year = sc.nextInt();
                        input = true;
                    } catch (InputMismatchException e) {
                        IO.println("Tohle neni ciso, zkus to znovu");
                        sc.nextLine();
                    }
                }
                input = false;
                IO.println("Mas presny mesic v roce kdy prestanes sporit? Ano - 1, Ne - 0");
                int option = 0;
                while (!input) {
                    try {
                        option = sc.nextInt();
                        input = true;
                    } catch (InputMismatchException e) {
                        IO.println("Tohle neni ciso, zkus to znovu");
                        sc.nextLine();
                    }
                }
                input = false;
                if (option == 1) {
                    while (!input) {
                        IO.println("Zadej mesic(1-12): ");
                        try {
                            month = sc.nextInt();
                            input = true;
                        } catch (InputMismatchException e) {
                            IO.println("Tohle neni ciso, zkus to znovu");
                            sc.nextLine();
                        }
                    }
                }
                else {
                    month = 12;
                }
                input = false;
                while (!input) {
                    try {
                        IO.println("Kolik je tvoje zacatecinky vklad na sporeni? (CZK)");
                        savings = sc.nextInt();
                        input = true;
                    } catch (InputMismatchException e) {
                        IO.println("Tohle neni ciso, zkus to znovu");
                        sc.nextLine();
                    }
                }
                input = false;
                while (!input) {
                    try {
                        IO.println("Kolik budes vkladat mesicne na sporeni svuj prvni rok?");
                        deposit = sc.nextInt();
                        input = true;
                    } catch (InputMismatchException e) {
                        IO.println("Tohle neni ciso, zkus to znovu");
                        sc.nextLine();
                    }
                }
                boolean ask = false;
                int number = 0;
                for (int i = 0; i < year; i++) {
                    if (i > 0){
                        if (!ask) {
                            input = false;
                                do {
                                    try {
                                        IO.println("Budes chtit zvysit svuj puvodni mesicni vklad pro rok: " + (i + 1) + "?\n"
                                                + "1 - Ano\n"
                                                + "2 - Ne (ale zeptej se pristi rok)\n"
                                                + "3 - Ne (a uz se nikdy neptej)\n"
                                                + "Tvuj aktualni vklad je: " + deposit);
                                        System.out.print("Zadej cislo: ");
                                        number = sc.nextInt();
                                        if (number >= 1 && number <= 3) {
                                            {
                                                input = true;
                                            }
                                        } else {
                                            IO.println("Chyba: Musis zadat cislo 1, 2, nebo 3.");
                                        }
                                    } catch (InputMismatchException e) {
                                        IO.println("Tohle neni ciso, zkus to znovu");
                                        sc.nextLine();
                                    }
                                }
                                while (!input);
                            if (number == 1) {
                                input = false;
                                while (!input) {
                                    try {
                                        IO.println("Kolik budes vkladat mesicne na sporeni?");
                                        deposit = sc.nextInt();
                                        number = 0;
                                        input = true;
                                    } catch (InputMismatchException e) {
                                        IO.println("Tohle neni ciso, zkus to znovu");
                                        sc.nextLine();
                                    }
                                }
                            }
                            else if (number == 3) {
                                ask = true;
                            }
                        }
                    }
                    if (i + 1 == year) {
                        for (int j = 0; j < month; j++) {
                            savings += deposit;
                            depositHistory.add(savings);
                        }
                    } else {
                        for (int j = 0; j < 12; j++) {
                            savings += deposit;
                            depositHistory.add(savings);
                        }
                    }
                }
                IO.println("Kalulace hotova");
                break;
            case 2:
                input = false;
                int whatYear = 0;
                int whatMonth = 0;
                while (!input) {
                    try {
                        IO.println("V jakem roce chces vedet kolik jsi usetril? Setril jsi:" + year + " let");
                        whatYear = sc.nextInt();
                        if (whatYear > 0 && whatYear <= year) {
                            input = true;
                        }
                        else {
                            System.out.println("Chyba: Rok musi byt mezi 1 a " + year);
                        }
                    }
                    catch (InputMismatchException e) {
                        IO.println("Tohle neni ciso, zkus to znovu");
                        sc.nextLine();
                    }
                }
                input = false;
                while (!input) {
                    try {
                        IO.println("V jakem mesici chces vedet kolik jsi usetril/a?");
                        whatMonth = sc.nextInt();
                        int maxMonth;
                        if (whatYear == year) {
                            maxMonth = month;
                        } else {
                            maxMonth = 12;
                        }
                        if (whatMonth > 0 && whatMonth <= maxMonth) {
                            input = true;
                        } else {
                            System.out.println("Chyba: Pro rok " + whatYear + " musis zadat mesic mezi 1 a " + maxMonth + ".");
                        }
                    } catch (InputMismatchException e) {
                        IO.println("Tohle neni ciso, zkus to znovu");
                        sc.nextLine();
                    }
                }
                IO.println("Year: " + whatYear + " Month: " + whatMonth + "; $" + depositHistory.get((whatMonth + 12 * (whatYear - 1)) - 1) + " saved");
                break;
            case 3:
                close = true;
                IO.println("Diky za pouziti :)");
                break;
            default:
                break;
        }
    }
}