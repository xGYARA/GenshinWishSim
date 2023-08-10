import java.util.ArrayList;
import java.util.Arrays;

public class Player {
    private ArrayList<Character> characters;
    private boolean guarantee;
    private int pity;

    private int fourStarPity;

    public Player() {
        this.characters = new ArrayList<Character>(Arrays.asList(
                new Character("Lisa","Electro","Catalyst",4),
                new Character("Kaeya","Cryo","Sword",4),
                new Character("Amber","Pyro","Bow",4))
        );
        this.guarantee = false;
        this.pity = 1;
        this.fourStarPity = 1;
    }

    public int getPity() {
        return pity;
    }

    public int getFourStarPity() {
        return fourStarPity;
    }

    public boolean isGuarantee() {
        return guarantee;
    }

    public void resetPity(){
        pity = 1;
    }

    public void resetFourStarPity(){
        fourStarPity = 1;
    }

    public void addCharacter(Character character){
        for (int i = 0; i < characters.size(); i++){
            if(characters.get(i).getName() == character.getName()){
                characters.get(i).duplicate();
                return;
            }
        }
        characters.add(character);
    }

    public void listCharacters(){
        for(int i = 0;i < characters.size(); i++){
            characters.get(i).printCharacterWithCon();
        }
    }

    public void increasePity(){
        pity += 1;
    }
    public void increaseFourStarPity(){
        fourStarPity += 1;
    }

    public void setGuarantee(){
        if(guarantee){
            guarantee = false;
        } else {
            guarantee = true;
        }
    }
}
