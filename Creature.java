import java.util.Random;

/**
 * Write a description of class Creature here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creature
{
    private int hp;
    private int str;
   
    public Creature() {
        
        hp = 10;
        str = 10;
    }
    
    public Creature(int hp, int str) {
        
        setHP(hp);
        setStr(str);
    }
        
    public int damage() {
        
        Random rand = new Random();
        return rand.nextInt(str) + 1;
    }
    
    protected void setHP(int hp) {
        
        if (hp < 5) {
            this.hp = 5;
        }
        else {
            this.hp = hp;
        }
    }
    
    protected void setStr(int str) {
        
        if (str < 5) {
            this.str = 5;
        }
        else {
            this.str = str;
        }
    }
    
    public boolean isAlive() {
        
        if (hp > 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
