
/**
 * Write a description of class Human here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Human extends Creature
{
    // instance variables - replace the example below with your own
    private static final int MIN_HP = 5;
    private static final int MAX_HP = 25;
    private static final int MIN_STR = 5;
    private static final int MAX_STR = 20;

    /**
     * Constructor for objects of class Human
     */
    public Human() {
        // initialise instance variables
        super(Randomizer.nextInt(MAX_HP - MIN_HP) + MIN_HP,
                Randomizer.nextInt(MAX_STR - MIN_STR) + MIN_STR);
    }
}
