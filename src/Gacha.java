import java.util.ArrayList;
import java.util.Arrays;

public class Gacha {
    private static final ArrayList<Character> fourStarChars = new ArrayList<>(Arrays.asList(
            new Character("Yanfei","Pyro","Catalyst",4),
            new Character("Lisa","Electro","Catalyst",4),
            new Character("Kaeya","Cryo","Sword",4),
            new Character("Amber","Pyro","Bow",4),
            new Character("Layla","Cryo","Sword",4),
            new Character("Faruzan","Anemo","Bow",4),
            new Character("Kaveh","Dendro","Claymore",4),
            new Character("Xiangling","Pyro","Polearm",4),
            new Character("Yun Jin","Geo","Polearm",4),
            new Character("Thoma","Pyro","Polearm",4),
            new Character("Kirara","Dendro","Sword",4)
    ));


    public static void singlePull(Player player, Banner banner){

        Character pulledChar;
        if(player.getPity() == 90){
            pulledChar = fiveStarPull(player, banner);
            player.resetPity();
            player.addCharacter(pulledChar);
        } else if (player.getFourStarPity() == 10) {
            pulledChar = fourStarPull();
            player.addCharacter(pulledChar);
            player.resetFourStarPity();
        } else if (player.getPity() > 75) {
            double roll = (double) Math.floor(Math.random() *(100 - 0 + 1) + 0);
            System.out.println("Soft pity, rates increased");
            System.out.println("Generated number:" + roll);
            if(roll < 15.0){
                pulledChar = fiveStarPull(player, banner);
                player.addCharacter(pulledChar);
                player.resetPity();
                player.resetFourStarPity();
            } else if (roll >= 15.0 && roll < 45.0) {
                pulledChar = fourStarPull();
                player.addCharacter(pulledChar);
                player.resetFourStarPity();
            } else {
                System.out.println("You got a 3* (weapon)...");
            }
        } else {
            double roll = (double) Math.floor(Math.random() *(100 - 0 + 1) + 0);
            System.out.println("Generated number:" + roll);
            if(roll < 0.6){
                pulledChar = fiveStarPull(player, banner);
                player.addCharacter(pulledChar);
                player.resetPity();
                player.resetFourStarPity();
            } else if (roll >= 0.6 && roll < 5.7) {
                pulledChar = fourStarPull();
                player.addCharacter(pulledChar);
                player.resetFourStarPity();
            } else {
                System.out.println("You got a 3* (weapon)...");
            }
        }
        System.out.println("Current pity: " + player.getPity() + " ,  Guarantee: " + (player.isGuarantee() ? "Yes" : "No"));
        player.increasePity();
        player.increaseFourStarPity();
    }

    public static void tenPull(Player player, Banner banner){
        for(int i = 1; i<=10; i++){
            singlePull(player, banner);
        }
    }

    public static Character fiveStarPull(Player player, Banner banner){
        Character pulledChar;
        if(player.isGuarantee() && banner instanceof LimitedBanner){
            System.out.println("You got a limited 5*: ");
            pulledChar = ((LimitedBanner) banner).getLimitedCharacter();
            player.setGuarantee();
        } else if(banner instanceof LimitedBanner) {
            int fiftyfifty = (int)Math.floor(Math.random() *(100 - 0 + 1) + 0);
            if(fiftyfifty > 50){
                pulledChar = ((LimitedBanner) banner).getLimitedCharacter();
            } else {
                pulledChar = standardFiveStar();
                player.setGuarantee();
            }
        } else {
            pulledChar = standardFiveStar();
        }
        pulledChar.printCharacter();
        return pulledChar;
    }

    public static Character fourStarPull(){
        int max = fourStarChars.size() - 1;
        int selected = (int)Math.floor(Math.random() *(max - 0 + 1) + 0);
        Character pickedChar = fourStarChars.get(selected);
        System.out.println("You got a 4*:");
        pickedChar.printCharacter();
        return pickedChar;
    }

    public static Character standardFiveStar(){
        Character pulledChar;
        System.out.println("You got a standard 5*:");
        int standard = (int)Math.floor(Math.random() *(6 - 1 + 1) + 1);
        pulledChar = switch (standard){
            case 1 -> new Character("Mona","Hydro","Catalyst",5);
            case 2 -> new Character("Qiqi","Cryo","Sword",5);
            case 3 -> new Character("Keqing","Electro","Sword",5);
            case 4 -> new Character("Diluc","Pyro","Claymore",5);
            case 5 -> new Character("Tighnari","Dendro","Bow",5);
            case 6 -> new Character("Dehya","Pyro","Claymore",5);
            default -> throw new IllegalStateException("Unexpected value: " + standard);
        };
        return pulledChar;
    }




}
