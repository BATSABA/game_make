import java.util.Random;
import java.util.Scanner;

public class Game {
    Boolean gameStat;
    int date;
    Scanner scanner = new Scanner(System.in);

    public Game() {
        this.gameStat = true;
        this.date = 0;
        MainCharacter me = new MainCharacter();
        Character1 girl1 = new Character1(this, me);
        Character2 boy1 = new Character2(this, me); 
        while (this.gameStat && this.date < 10) {
            switch (this.date) {
                case 1:
                    girl1.DAY1_goSchool();
                    break;
                case 2:
                    // Date 2 events
                    break;
                case 3:
                    // Date 3 events
                    break;
                case 4:
                    // Date 4 events
                    break;
                case 5:
                    // Date 5 events
                    break;
                case 6:
                    // Date 6 events
                    break;
                case 7:
                    // Date 7 events
                    break;
                case 8:
                    // Date 8 events
                    break;
                case 9:
                    // Date 9 events
                    break;
                case 10:
                    // Date 10 events
                    break;
                default:
                    break;
            }
            this.date++;
        }
        if(this.gameStat == false) System.out.println("DEFEAT!!");
        else;
    }

    public static void main(String[] args) {
        Game newGame = new Game();
    }

    
}

class SubCharacter {
    String gender;
    int likePoint;
    String name;
    String type;
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    Game game;
    MainCharacter mainCharacter;

    public SubCharacter(Game game, MainCharacter mainCharacter) {
        this.game = game;
        this.mainCharacter = mainCharacter;
    }

    public void print() {
        System.out.println("Name: " + this.name);
        System.out.println("Gender: " + this.gender);
        System.out.print("Like Point: ");
        for (int i = 0; i < 10; i++) {
            if (i < this.likePoint / 10) System.out.print("#");
            else System.out.print("-");
        }
        System.out.println(this.likePoint + "%");
    }
}

class Character1 extends SubCharacter {
    public Character1(Game game, MainCharacter mainCharacter) {
        super(game, mainCharacter);
        this.game = game;
        this.mainCharacter = mainCharacter;
        this.type = "青梅竹馬";
        this.name = "default";
        this.likePoint = random.nextInt(16) + 70;
        this.gender = "女";
    }

    public void DAY1_goSchool() {
        System.out.println("好久不見，" + mainCharacter.name + "!");
    }
    publuc void DAY2() {
        
    }
}

class Character2 extends SubCharacter {
    public Character2(Game game, MainCharacter mainCharacter) {
        super(game, mainCharacter);
        this.game = game;
        this.mainCharacter = mainCharacter;
        this.type = "同桌";
        this.name = "default";
        this.likePoint = random.nextInt(21) + 50;
        this.gender = "男";
    }

    public void someEvent() {

    }
}

class MainCharacter {
    String name;
    Scanner scanner = new Scanner(System.in);

    public MainCharacter() {
        System.out.print("請輸入你的名字: ");
        this.name = scanner.nextLine();
    }
}
