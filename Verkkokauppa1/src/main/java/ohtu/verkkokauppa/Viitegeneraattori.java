package ohtu.verkkokauppa;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Viitegeneraattori implements ViitegeneraattoriInterface {

//    private static Viitegeneraattori instanssi;
//
//    public static Viitegeneraattori getInstance() {
//        if (instanssi == null) {
//            instanssi = new Viitegeneraattori();
//        }
//
//        return instanssi;
//    }
    
    public int seuraava;
    
    @Autowired
    public Viitegeneraattori(){
        seuraava = 1;    
    }
    
    @Override
    public int uusi(){
        return seuraava++;
    }
}
