import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player newPlayer = new Player();

        Character kazuha = new Character("Kazuha", "Anemo","Sword",5);
//        for(int i = 0; i <=7; i++){
//            kazuha.duplicate();
//        }
        Character yelan = new Character("Yelan","Hydro", "Bow",5);

//        newPlayer.addCharacter(kazuha);
//        newPlayer.addCharacter(yelan);

        LimitedBanner yelanBanner = new LimitedBanner(yelan);
        Banner standard =  new Banner();
        //newPlayer.listCharacters();
        //Gacha.tenPull(newPlayer,yelanBanner);
        Scanner scanner = new Scanner(System.in);
        boolean makingChoice = true;
        while(makingChoice){
            System.out.print("""
                    What would you like to do?
                    1. Check characters
                    2. Pull on standard banner (x1)
                    3. Pull on standard banner (x10)
                    4. Pull on event banner (x1)
                    5. Pull on event banner (x10)
                    6. Exit
                    """);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1 -> newPlayer.listCharacters();
                case 2 -> Gacha.singlePull(newPlayer, standard);
                case 3 -> Gacha.tenPull(newPlayer, standard);
                case 4 -> Gacha.singlePull(newPlayer, yelanBanner);
                case 5 -> Gacha.tenPull(newPlayer, yelanBanner);
                case 6 -> makingChoice = false;
                default -> System.out.println("Invalid choice");
            }
        }
    }
}