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
                    // Date 1 events
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

    public void printAll(SubCharacter[] characters) {
        for (int i = 0; i < characters.length; i++) {
            characters[i].print();
        }
    }
}

class SubCharacter {
    String gender;
    int likePoint;
    String name;
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    Game game;
    MainCharacter mainCharacter;

    public SubCharacter(Game game, MainCharacter mainCharacter) {
        this.game = game;
        this.mainCharacter = mainCharacter;
    }

    public void print() {
        System.out.println("++++++++++++++++++++++++++");
        System.out.println("Name: " + this.name);
        System.out.println("Gender: " + this.gender);
        System.out.print("Like Point: ");
        for (int i = 0; i < 10; i++) {
            if (i < this.likePoint / 10) System.out.print("#");
            else System.out.print("-");
        }
        System.out.println(this.likePoint + "%");
        System.out.println("++++++++++++++++++++++++++");
    }
}

class Character1 extends SubCharacter {
    public Character1(Game game, MainCharacter mainCharacter) {
        super(game, mainCharacter);
        this.mainCharacter = mainCharacter;
        this.name = "青梅竹馬";
        this.likePoint = random.nextInt(16) + 70;
        this.gender = "女";
    }

    public void DAY1_goSchool() {
        System.out.println("好久不見，" + mainCharacter.name + "!");
    }

    public void surveillance() {
        if (random.nextInt(101 - likePoint) == 0) {
            System.out.println("你怎麼可以這樣?");
            game.gameStat = false;
        }
    }
}

class Character2 extends SubCharacter {
    public Character2(Game game, MainCharacter mainCharacter) {
        super(game, mainCharacter);
        this.mainCharacter = mainCharacter;
        this.name = "同桌";
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
