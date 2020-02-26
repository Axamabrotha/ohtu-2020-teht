/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author isuite
 */
public class StatisticsTest {
    
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;

        }
    };
   
    Statistics stats;

    
    @Before
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    /**
     * Test of search method, of class Statistics.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        String name = "Yzerman";
        Statistics instance = stats;
        Player expResult = stats.search(name);
        Player result = stats.search(name);
//        System.out.println(stats.search(name));
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of team method, of class Statistics.
     */
    @Test
    public void testTeam() {
        System.out.println("team");
        String teamName = "EDM";
        Statistics instance = stats;
        List<Player> expResult = stats.team(teamName);
        List<Player> result = stats.team(teamName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of topScorers method, of class Statistics.
     */
    @Test
    public void testTopScorers() {
        System.out.println("topScorers");
        int howMany = 2;
        Statistics instance = stats;
        List<Player> expResult = stats.topScorers(howMany);
        List<Player> result = stats.topScorers(howMany);
        System.out.println(stats.topScorers(howMany));
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
