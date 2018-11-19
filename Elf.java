import java.util.Random;

/**
 * Write a description of class Elf here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Elf extends Creature
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Elf
     */
    public Elf() {
        // initialise instance variables
        setHP(8);
        setStr(5);
    }

    public Elf(int hp, int str) {

        setHP(hp);
        setStr(str);
    }
    
    protected void setHP(int hp) {
        
        if (hp < 8) {
            super.setHP(8);
        }
        else if (hp > 25) {
            super.setHP(25);
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
    
    public int damage() {
        
        Random rand = new Random();
        int critical = rand.nextInt(10);
        
        if (critical != 0) {
            return super.damage();
        }
        else {
            return super.damage() * 2;
        }
    }
}
