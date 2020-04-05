package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        IO io = new Interface();
        while (true) {
            io.print("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");
            
            String vastaus = io.nextLine();
            if (vastaus.endsWith("a")) {
                io.print("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                KPS kaksinpeli = KPS.pelaajaVsPelaaja(io);
                kaksinpeli.pelaa();
            } else if (vastaus.endsWith("b")) {
                io.print("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                KPS yksinpeli = KPS.pelaajaVsTekoaly(io);
                yksinpeli.pelaa();
            } else if (vastaus.endsWith("b")) {
                io.print("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                KPS yksinpeli = KPS.pelaajaVsTekoaly(io);
                yksinpeli.pelaa();
            } else {
                break;
            }
        }
    }
}