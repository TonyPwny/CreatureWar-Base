
/**
 * Write a description of class Human here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Human extends Creature
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Human
     */
    public Human() {
        // initialise instance variables
        setHP(10);
        setStr(5);
    }
    
    public Human(int hp, int str) {
        
        setHP(hp);
        setStr(str);
    }
    
    protected void setHP(int hp) {
        
        if (hp < 10) {
            super.setHP(10);
        }
        else if (hp > 30) {
            super.setHP(30);
        }
        else {
            super.setHP(hp);
        }
    }
    
    protected void setStr(int str) {
        
        if (str < 5) {
            super.setStr(5);
        }
        else if (str > 18) {
            super.setStr(18);
        }
        else {
            super.setStr(str);
        }
    }
}
