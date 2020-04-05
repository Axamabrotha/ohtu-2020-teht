/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

/**
 *
 * @author isuite
 */
public class Ihminen extends Pelaaja {
    
    public Ihminen(IO io) {
        super(io);
    }
    
    public String annaSiirto() {
        return "";
    }
    
    public void asetaSiirto(String ekaSiirto) {
        
    }
    
    public void tulostaSiirot() {
        
    }
    
    public String tulostaSiirto(int nro) {
        if (nro == 1) {
            io.print("Ensimmäisen pelaajan siirto: ");
        } else {
            io.print("Toisen pelaajan siirto: ");
        }
        
        return io.nextLine();
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
