public class Character {
    private String name;
    private String element;
    private String weaponType;
    private int rarity;
    private int constellation;

    public Character(String name, String element, String weaponType, int rarity) {
        this.name = name;
        this.element = element;
        this.weaponType = weaponType;
        this.rarity = rarity;
        this.constellation = 0;
    }

    public String getName() {
        return name;
    }

    public void printCharacter(){
        System.out.println(name + " - " + rarity + "-star " + element + " " + weaponType + " user");
    }

    public void printCharacterWithCon(){
        printCharacter();
        System.out.println("Constellation level: " + printCon());
    }

    public String printCon(){
        if(constellation <=6){
            return Integer.toString(constellation);
        } else {
            return 6 + " (+" + Integer.toString(constellation-6) +")";
        }
    }

    public void duplicate(){
        constellation += 1;
    }
}
