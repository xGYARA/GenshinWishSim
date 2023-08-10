import java.util.ArrayList;

public class Banner {
    private ArrayList<Character> availableChars;
}

class LimitedBanner extends Banner{
    private Character limitedCharacter;

    public LimitedBanner(Character limitedCharacter) {
        this.limitedCharacter = limitedCharacter;
    }

    public Character getLimitedCharacter(){
        return limitedCharacter;
    }
}
