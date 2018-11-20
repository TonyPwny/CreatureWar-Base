
/**
 * Write a description of class Demon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Demon extends Creature {
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Demon
     */
    public Demon() {
        // initialise instance variables
        super();
    }
    
    public Demon(int hp, int str) {
        // initialise instance variables
        super(hp, str);
    }
    
    public int damage() {
        
        int critical = Randomizer.nextInt(20);
        
        if (critical == 0) {
            return super.damage() + 50;
        }
        else {
            return super.damage();
        }
    }
}
