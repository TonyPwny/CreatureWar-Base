import java.util.ArrayList;

/**
 * Write a description of class WarSim here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WarSim
{
    // instance variables - replace the example below with your own
    private static int ARMY_HUM_ELF_NUM = 250;
    private static int ARMY_DEMON_NUM = 175;
    
    public static void main() {
        
        ArrayList<Creature> armyHumElf = new ArrayList<Creature>();
        ArrayList<Creature> armyDemon = new ArrayList<Creature>();
        
        for(int count = 0; count < ARMY_HUM_ELF_NUM; count++) {
            
            int humOrElf = Randomizer.nextInt(2);
            
            switch (humOrElf) {
                
                case 0:
                    armyHumElf.add(new Human());
                    break;
                case 1:
                    armyHumElf.add(new Elf());
                    break;
            }
        }
        
        for(int count = 0; count < ARMY_DEMON_NUM; count++) {
            
            int whatDemon = Randomizer.nextInt(100);
            
            if (whatDemon == 0) {
                
                armyDemon.add(new Balrog());
            }
            else if (whatDemon > 0 && whatDemon <= 10) {
                
                armyDemon.add(new CyberDemon());
            }
            else {
                
                armyDemon.add(new Demon());
            }
        }
        
        int coinToss = Randomizer.nextInt(2);
        
        if (coinToss == 0) {
            
            System.out.println("The human and elf alliance strikes the first blow!");
            while(armyHumElf.size() > 0 && armyDemon.size() > 0) {
                
                int randomDemon = Randomizer.nextInt(armyDemon.size());
                int randomHumElf = Randomizer.nextInt(armyHumElf.size());
                
                armyDemon.get(randomDemon).takeDamage(armyHumElf.get(randomHumElf).damage());
                System.out.println("A human/elf strikes a demon!");
                
                if (!armyDemon.get(randomDemon).isAlive()) {
                    
                    System.out.println("A demon has died!");
                    armyDemon.remove(randomDemon);
                }
                else {
                    
                    System.out.println("The demon counter-attacks!");
                    armyHumElf.get(randomHumElf).takeDamage(armyDemon.get(randomDemon).damage());
                    
                    if(!armyHumElf.get(randomHumElf).isAlive()) {
                        
                        System.out.println("A human/elf has died!");
                        armyHumElf.remove(randomHumElf);
                    }
                }
            }
        }
        else {
            
            System.out.println("The demon horde strikes the first blow!");
            while(armyHumElf.size() > 0 && armyDemon.size() > 0) {
                
                int randomDemon = Randomizer.nextInt(armyDemon.size());
                int randomHumElf = Randomizer.nextInt(armyHumElf.size());
                
                armyHumElf.get(randomHumElf).takeDamage(armyDemon.get(randomDemon).damage());
                System.out.println("A demon thrusts at a human/elf!");
                
                if (!armyHumElf.get(randomHumElf).isAlive()) {
                    
                    System.out.println("A human/elf has died!");
                    armyHumElf.remove(randomHumElf);
                }
                else {
                    
                    System.out.println("The human/elf counter-attacks!");
                    armyDemon.get(randomDemon).takeDamage(armyHumElf.get(randomHumElf).damage());
                    
                    if(!armyDemon.get(randomDemon).isAlive()) {
                        
                        System.out.println("A demon has died!");
                        armyDemon.remove(randomDemon);
                    }
                }
            }
        }
        
        if(armyDemon.size() == 0) {
            System.out.println("The human/elf alliance wins with a surviving army size of " +
                                armyHumElf.size() + ".");
        }
        else {
            System.out.println("The demon horde ravages the land with a surviving army size of " +
                                armyDemon.size() + ".");
        }
    }
}
