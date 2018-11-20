
/**
 * Write a description of class CyberDemon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CyberDemon extends Demon {
    // instance variables - replace the example below with your own
    private static final int MIN_HP = 25;
    private static final int MAX_HP = 100;
    private static final int MIN_STR = 20;
    private static final int MAX_STR = 40;

    /**
     * Constructor for objects of class CyberDemon
     */
    public CyberDemon() {
        // initialise instance variables
        super(Randomizer.nextInt(MAX_HP - MIN_HP) + MIN_HP,
                Randomizer.nextInt(MAX_STR - MIN_STR) + MIN_STR);
    }
}
