
/**
 * Write a description of class Elf here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Elf extends Creature
{
    // instance variables - replace the example below with your own
    private static final int MIN_HP = 8;
    private static final int MAX_HP = 25;
    private static final int MIN_STR = 5;
    private static final int MAX_STR = 18;

    /**
     * Constructor for objects of class Elf
     */
    public Elf() {
        // initialise instance variables
        super(Randomizer.nextInt(MAX_HP - MIN_HP) + MIN_HP,
                Randomizer.nextInt(MAX_STR - MIN_STR) + MIN_STR);
    }
    
    public int damage() {
        
        int critical = Randomizer.nextInt(10);
        
        if (critical == 0) {
            return super.damage() * 2;
        }
        else {
            return super.damage();
        }
    }
}
