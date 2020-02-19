/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
//import org.junit.Before;
import ohtuesimerkki.Statistics;
import org.junit.*;
import static org.junit.Assert.*;

//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;

/**
 *
 * @author isuite
 */
public class StatisticsTest_2 {
    Reader readerStub = new Reader() {
            public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
    
    Statistics stats;
    
    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }    

    public void haePelaaja() {
        assertEquals("Semenko", stats.search("Semenko"));
        System.out.println(stats.search("Semenko"));
        
}
    
    public void joukkueenPelaajat() {
        assertEquals("EDM", stats.team("EDM"));
}

    public void pistePorssi() {
        stats.topScorers(5);
}
    
  
}
