
/**
 * Write a description of class Balrog here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Balrog extends Demon {
    // instance variables - replace the example below with your own
    private static final int MIN_HP = 80;
    private static final int MAX_HP = 200;
    private static final int MIN_STR = 50;
    private static final int MAX_STR = 100;

    /**
     * Constructor for objects of class Balrog
     */
    public Balrog() {
        // initialise instance variables
        super(Randomizer.nextInt(MAX_HP - MIN_HP) + MIN_HP,
                Randomizer.nextInt(MAX_STR - MIN_STR) + MIN_STR);
    }
    
    public int damage() {
        
        int attack1 = super.damage();
        int attack2 = super.damage();
        return attack1 + attack2;
    }
}
