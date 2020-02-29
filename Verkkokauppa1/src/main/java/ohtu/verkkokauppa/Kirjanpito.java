
package ohtu.verkkokauppa;

import java.util.ArrayList;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Kirjanpito implements KirjanpitoInterface {
//    private static Kirjanpito instance;
//    
//    public static Kirjanpito getInstance() {
//        if ( instance==null) {
//            instance = new Kirjanpito();
//        }
//        
//        return instance;
//    }
    
    public ArrayList<String> tapahtumat;

    @Autowired
    public Kirjanpito() {
        tapahtumat = new ArrayList<String>();
    }
    
    @Override
    public void lisaaTapahtuma(String tapahtuma) {
        tapahtumat.add(tapahtuma);
    }

    @Override
    public ArrayList<String> getTapahtumat() {
        return tapahtumat;
    }       
}
