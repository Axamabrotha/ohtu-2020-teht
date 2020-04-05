package ohtu.kivipaperisakset;

public class Tekoaly extends Pelaaja {

    int siirto;

    public Tekoaly() {
        super(new Interface());
        siirto = 0;
    }
    
    public Tekoaly(IO io) {
        super(io);
        siirto = 0;
    }

    public String annaSiirto() {
        siirto++;
        siirto = siirto % 3;

        if (siirto == 0) {
            return "k";
        } else if (siirto == 1) {
            return "p";
        } else {
            return "s";
        }
    }

    public void asetaSiirto(String ekanSiirto) {
        // ei tehdä mitään 
    }
    
    public String tulostaSiirto(int nro) {
        String siirto = this.annaSiirto();
        io.print("Tietokone valitsi: " + siirto);
        return siirto;
    }

    @Override
    public String nextLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void print(String m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
