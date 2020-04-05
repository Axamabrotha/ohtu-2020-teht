package ohtu.kivipaperisakset;

public class KPS {

    private IO io;
    private Tuomari tuomari;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;

    public KPS(IO io, Tuomari tuomari, Pelaaja pelaaja1, Pelaaja pelaaja2) {
        this.io = io;
        this.tuomari = tuomari;
        this.pelaaja1 = pelaaja1;
        this.pelaaja2 = pelaaja2;
    }
    

    public static KPS pelaajaVsPelaaja(IO io) {
        return new KPS(io, new Tuomari(io), new Ihminen(io), new Ihminen(io));
    }

    public static KPS pelaajaVsTekoaly(IO io) {
        return new KPS(io, new Tuomari(io), new Ihminen(io), new Tekoaly(io));
    }
    
    public static KPS pelaajaVsParempiTekoaly(IO io) {
        return new KPS(io, new Tuomari(io), new Ihminen(io), new TekoalyParannettu(io, 20));
    }
    
    public void pelaa() {

        String ekanSiirto = this.pelaaja1.tulostaSiirto(1);
        String tokanSiirto = this.pelaaja2.tulostaSiirto(2);

        while (onkoOkSiirrot(ekanSiirto, tokanSiirto)) {
            this.tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            this.tuomari.tulosta();
            
            ekanSiirto = this.pelaaja1.tulostaSiirto(1);
            tokanSiirto = this.pelaaja2.tulostaSiirto(2);
            this.pelaaja2.asetaSiirto(ekanSiirto);
        }
        
        io.print("");
        io.print("Kiitos!");
        this.tuomari.tulosta();
    }
    
    public boolean onkoOkSiirrot(String siirto1, String siirto2) {
        return onkoOkSiirto(siirto1) && onkoOkSiirto(siirto2);
    }

    public boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}

