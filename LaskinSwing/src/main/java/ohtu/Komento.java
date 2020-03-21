/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;
import javax.swing.JTextField;
/**
 *
 * @author isuite
 */
public abstract class Komento {
    JTextField tuloskentta;
    JTextField syotekentta;
    Sovelluslogiikka sovellus;
    int syote;
    int edellinenTulos;    
    
    public Komento(JTextField tuloskentta, JTextField syotekentta, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.sovellus = sovellus;
    }
    
    protected void suorita() {
        getEdellinenTulos();
        getSyote();
        operate();
        setResult();
    };
    
    public void peru() {
        sovellus.aseta(edellinenTulos);
        setResult();
    };
    
    protected abstract void operate();
    
    protected void getSyote() {
        syote = Integer.parseInt(syotekentta.getText());
    }
    
    protected void getEdellinenTulos() {
        edellinenTulos = sovellus.tulos();
    }
    
    protected void setResult() {
        tuloskentta.setText(Integer.toString(sovellus.tulos()));
    }
}
