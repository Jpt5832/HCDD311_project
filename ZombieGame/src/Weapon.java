
public class Weapon {

	 //variables related to weapon
    public static String weaponName;
    public static double weaponDamage = 0;
	
    public static void weaponSelect(int x){
        //System.out.println("Select a weapon:");
        //Scanner scnr2 = new Scanner(System.in);
        //int weapon = scnr.nextInt();
        int weapon = x;
        switch (weapon){
            case 1:
                weapon = 1;
                weaponName = "pistol";
                weaponDamage = 70;
                System.out.println("Pistol selected...BANG BANG");
                break;
            case 2:
                weapon = 2;
                weaponName = "baseball bat";
                weaponDamage = 15.5;
                System.out.println("You found a baseball bat");
                break;
            case 3:
                weapon = 3;
                weaponName = "rubber chicken";
                weaponDamage = 30;
                System.out.println("You found a rubber chicken surprisingly lethal");
                break;
            case 4:
                weapon = 4;
                weaponName = "sword";
                weaponDamage = 50;
                System.out.println("A sword, it's dangerous to go alone");
                break;
            default:
                weapon = 0;
                weaponName = "fists";
                weaponDamage = 5;
                System.out.println("All you have is your fists, good luck!");
        }     
        
    } //closes weaponSelect function
	
	
}
