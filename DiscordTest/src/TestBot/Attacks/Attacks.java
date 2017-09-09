/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestBot.Attacks;

/**
 *
 * @author Matthew Stanley {@literal <mastanley3@zagmail.gonzaga.edu>}
 */
public abstract class Attacks {
    private String name;
    
    private String hitType;
    
    private String[] damageType;
    
    public abstract int damage();
}
