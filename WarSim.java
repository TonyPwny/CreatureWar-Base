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
        int humCount = 0;
        int elfCount = 0;
        int balCount = 0;
        int cybDemCount = 0;
        int demCount = 0;
        
        for(int count = 0; count < ARMY_HUM_ELF_NUM; count++) {
            
            int humOrElf = Randomizer.nextInt(2);
            
            switch (humOrElf) {
                
                case 0:
                    armyHumElf.add(new Human());
                    humCount++;
                    break;
                case 1:
                    armyHumElf.add(new Elf());
                    elfCount++;
                    break;
            }
        }
        
        System.out.println("The Human and Elf Alliance is " +
                            armyHumElf.size() + " soldiers strong, with:\n\t" +
                            humCount + " Humans\n\t" +
                            elfCount + " Elves");
                                
        for(int count = 0; count < ARMY_DEMON_NUM; count++) {
            
            int whatDemon = Randomizer.nextInt(100);
            
            if (whatDemon == 0) {
                
                armyDemon.add(new Balrog());
                balCount++;
            }
            else if (whatDemon > 0 && whatDemon <= 10) {
                
                armyDemon.add(new CyberDemon());
                cybDemCount++;
            }
            else {
                
                armyDemon.add(new Demon());
                demCount++;
            }
        }
        
        System.out.println("The Demon Horde is " +
                            armyDemon.size() + " beasts strong, with:\n\t" +
                            balCount + " Balrogs\n\t" +
                            cybDemCount + " CyberDemons\n\t" +
                            demCount + " Demons");
                                
        int coinToss = Randomizer.nextInt(2);
        int damage;
        
        if (coinToss == 0) {
            
            System.out.println("The Human and Elf Alliance strikes the first blow!");
            while(armyHumElf.size() > 0 && armyDemon.size() > 0) {
                
                int randomDemon = Randomizer.nextInt(armyDemon.size());
                int randomHumElf = Randomizer.nextInt(armyHumElf.size());
                damage = armyHumElf.get(randomHumElf).damage();
                
                if(armyHumElf.get(randomHumElf) instanceof Elf) {
                    System.out.println("An " + armyHumElf.get(randomHumElf).info() +
                                        " strikes\n\ta " + armyDemon.get(randomDemon).info() +
                                        "\n\tdealing " + damage + " damage!");
                }
                else {
                    System.out.println("A " + armyHumElf.get(randomHumElf).info() +
                                        " strikes\n\ta " + armyDemon.get(randomDemon).info() +
                                        "\n\tdealing " + damage + " damage!");
                }
                
                armyDemon.get(randomDemon).takeDamage(damage); 
                
                if (!armyDemon.get(randomDemon).isAlive()) {
                    
                    System.out.println("\tThe " + armyDemon.get(randomDemon).kind() + " has died!");
                    armyDemon.remove(randomDemon);
                }
                else {
                    
                    damage = armyDemon.get(randomDemon).damage();
                    System.out.println("\tThe " + armyDemon.get(randomDemon).kind() +
                                        " counter-attacks with " + damage + " damage!");
                    armyHumElf.get(randomHumElf).takeDamage(damage);
                    
                    if(!armyHumElf.get(randomHumElf).isAlive()) {
                        
                        if(armyHumElf.get(randomHumElf) instanceof Elf) {
                            System.out.println("\tAn " + armyHumElf.get(randomHumElf).kind() + " has died!");
                        }
                        else {
                            System.out.println("\tA " + armyHumElf.get(randomHumElf).kind() + " has died!");
                        }
                        armyHumElf.remove(randomHumElf);
                    }
                }
            }
        }
        else {
            
            System.out.println("The Demon Horde strikes the first blow!");
            while(armyHumElf.size() > 0 && armyDemon.size() > 0) {
                
                int randomDemon = Randomizer.nextInt(armyDemon.size());
                int randomHumElf = Randomizer.nextInt(armyHumElf.size());
                damage = armyDemon.get(randomDemon).damage();
                
                if(armyHumElf.get(randomHumElf) instanceof Elf) {
                    System.out.println("A " + armyDemon.get(randomDemon).info() +
                                        " thrusts at\n\tan " + armyHumElf.get(randomHumElf).info() +
                                        "\n\tdealing " + damage + " damage!");      
                }
                else {
                    System.out.println("A " + armyDemon.get(randomDemon).info() +
                                        " thrusts at\n\ta " + armyHumElf.get(randomHumElf).info() +
                                        "\n\tdealing " + damage + " damage!");
                }
                armyHumElf.get(randomHumElf).takeDamage(damage);
                
                if (!armyHumElf.get(randomHumElf).isAlive()) {
                    
                    if(armyHumElf.get(randomHumElf) instanceof Elf) {
                        System.out.println("\tAn " + armyHumElf.get(randomHumElf).kind() + " has died!");
                    }
                    else {
                        System.out.println("\tA " + armyHumElf.get(randomHumElf).kind() + " has died!");
                    }
                    armyHumElf.remove(randomHumElf);
                }
                else {
                    
                    System.out.println("\tThe " + armyHumElf.get(randomHumElf).kind() +
                                        " counter-attacks with " + damage + " damage!");
                    armyDemon.get(randomDemon).takeDamage(armyHumElf.get(randomHumElf).damage());
                    
                    if(!armyDemon.get(randomDemon).isAlive()) {
                        
                        System.out.println("\tThe " + armyDemon.get(randomDemon).kind() + " has died!");
                        armyDemon.remove(randomDemon);
                    }
                }
            }
        }
        
        if(armyDemon.size() == 0) {
            System.out.println("The Human and Elf Alliance are victorious with a\n\t" +
                                "surviving army size of " + armyHumElf.size() + " honorable soldiers.");
        }
        else {
            System.out.println("The Demon Horde ravages the land with a surviving\n\t" +
                                "army size of " + armyDemon.size() + " berzerk beasts.");
        }
    }
}
