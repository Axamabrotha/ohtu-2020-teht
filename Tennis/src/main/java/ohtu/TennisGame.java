package ohtu;

import java.util.HashMap;
import java.util.Map;

public class TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;
    private Map<Integer, String> alustaTulokset = new HashMap<>();
    
    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        alustaTulokset();
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            player1Score += 1;
        if (playerName == player2Name)
            player2Score += 1;
    }

    public String getScore() {
        if (player1Score==player2Score) 
            return tasaPeli();
        else if (player1Score>=4 || player2Score>=4) 
            return pisteEro();
        return ottelunTulos();
    }
    
    private String tasaPeli() {
        String tulos = alustaTulokset.get(player1Score);
        if (player1Score == 4) return "Deuce";
        else return String.format("%s-All", tulos);
    }
    
    private String pisteEro() {
        int ero = player1Score - player2Score;
        if (Math.abs(ero) == 1) {
            return kumpiJohtaa(ero);
        } else {
            return pelaajaVoitti(ero);
        }
    }
        
    private String pelaajaVoitti(int ero) {
        return String.format("Win for %s", tarkistaJohto(ero));
    }

    private String kumpiJohtaa(int ero) {
        return String.format("Advantage %s", tarkistaJohto(ero));
    }
        
    private String tarkistaJohto(int ero) {
        if (ero > 0) {
            return player1Name;
        } else {
            return player2Name;
        }
    }

    private String ottelunTulos() {
        return String.format("%s-%s", alustaTulokset.get(player1Score), alustaTulokset.get(player2Score));
    }
    
    private void alustaTulokset() {
        alustaTulokset.put(0, "Love");
        alustaTulokset.put(1, "Fifteen");
        alustaTulokset.put(2, "Thirty");
        alustaTulokset.put(3, "Forty");
    }
    
}