/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author isuite
 */
public abstract class Pelaaja implements IO {
    protected IO io;
    
    public Pelaaja(IO io) {
        this.io = io;
    }
    
    public abstract String annaSiirto();

    public abstract void asetaSiirto(String ekanSiirto);
    
    public abstract String tulostaSiirto(int nro);
    
}
