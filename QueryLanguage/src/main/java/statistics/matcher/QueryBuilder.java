/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import statistics.matcher.*;
import statistics.Player;

public class QueryBuilder {
    Matcher matcher;
 
    public QueryBuilder() {
        matcher = new All();
    }
    
    public Matcher build() {
        return matcher;
    }
    
    public QueryBuilder playsIn(String team) {
        this.matcher = new PlaysIn(team);
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.matcher = new And(matcher, new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.matcher = new And(matcher, new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher match1, Matcher match2) {
        this.matcher = new Or(match1, match2);
        return this;
    }
    
}
