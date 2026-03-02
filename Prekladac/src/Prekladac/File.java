package Prekladac;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class File {
    private String fileAnglicky;
    private String fileCesky;

    public File(String angSlovicko, String czSlovicko) {
        this.fileAnglicky = angSlovicko;
        this.fileCesky = czSlovicko;
    }

    public void nacist(Slovnik slovnik) {
        java.io.File enFile = new java.io.File(fileAnglicky);
        java.io.File czFile = new java.io.File(fileCesky);

        if (!enFile.exists() || !czFile.exists()) {
            System.out.println("Zadny soubor nebyl nalezeny");
            return;
        }

        try {
            Scanner scannerAng = new Scanner(enFile);
            Scanner scannerCZ = new Scanner(czFile);

            while (scannerAng.hasNextLine() && scannerCZ.hasNextLine()) {

                String anglickySlovicka = scannerAng.nextLine();
                String ceskaSlovicka = scannerCZ.nextLine();

                slovnik.pridatSlovicko(anglickySlovicka, ceskaSlovicka);
            }

            scannerAng.close();
            scannerCZ.close();

            System.out.println("Slovniky nacteny z obou textaku");

        } catch (IOException e) {
            System.out.println("Error: Neslo nacist ze souboru");
        }
    }

    public void ulozit(Slovnik slovnik) {
        try {
            FileWriter writerEN = new FileWriter(fileAnglicky);
            FileWriter writerCZ = new FileWriter(fileCesky);

            for (Map.Entry<String, String> parSlovicek : slovnik.getVsecnhySlovicka()) {

                String anglickySlovicko = parSlovicek.getKey();
                String ceskySlovicko = parSlovicek.getValue();

                writerEN.write(anglickySlovicko + "\n");

                writerCZ.write(ceskySlovicko + "\n");
            }

            writerEN.close();
            writerCZ.close();

        } catch (IOException e) {
            System.out.println("Error: Neslo ulozit do slovniku");
        }
    }

    public void vymazaniFile() {
        java.io.File enFile = new java.io.File(fileAnglicky);
        java.io.File czFile = new java.io.File(fileCesky);

        enFile.delete();
        czFile.delete();

        System.out.println("Slovniky byly vymazany");
    }

    public void vypsaniSlovZeSlovniku() {
        java.io.File enFile = new java.io.File(fileAnglicky);
        java.io.File czFile = new java.io.File(fileCesky);

        if (!enFile.exists() || !czFile.exists()) {
            System.out.println("Vytvor nejdriv slovniky");
            return;
        }

        try {
            Scanner sAng = new Scanner(enFile);
            Scanner sCZ = new Scanner(czFile);

            System.out.println("\n--- Databaze Slov ---");
            System.out.println("Anglicky : Cesky");

            while (sAng.hasNextLine() && sCZ.hasNextLine()) {
                String eng = sAng.nextLine();
                String cze = sCZ.nextLine();
                System.out.println(eng + " : " + cze);
            }
            sAng.close();
            sCZ.close();

        } catch (IOException e) {
            System.out.println("Error: Neslo vypsat slovniky");
        }
    }
}