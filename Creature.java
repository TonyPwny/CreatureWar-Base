
/**
 * Write a description of class Creature here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Creature {
    private int hp, str;
    private static final int MIN_HP = 5;
    private static final int MIN_STR = 5;
    private static final int DEFAULT_HP = 10;
    private static final int DEFAULT_STR = 10;
    
   
    public Creature() {
        
        hp = DEFAULT_HP;
        str = DEFAULT_STR;
    }
    
    public Creature(int hp, int str) {
        
        if (hp < MIN_HP) {
            this.hp = MIN_HP;
        }
        else {
            this.hp = hp;
        }
        if (str < MIN_STR) {
            this.str = MIN_STR;
        }
        else {
            this.str = str;
        }
    }
        
    public int damage() {
        
        return Randomizer.nextInt(str) + 1;
    }
    
    public void takeDamage(int damage) {
        
        hp -= damage;
    }
    
    public boolean isAlive() {
        
        if (hp > 0) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public String info() {

        Class cls = getClass();
        return cls.getName() + " with " + hp + " HP and " + str + " STR";
    }
    
    public String kind() {
        
        Class cls = getClass();
        return cls.getName();
    }
}
