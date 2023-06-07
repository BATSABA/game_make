import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    Boolean gameStat;
    int date;
    Scanner scanner = new Scanner(System.in);

    public Game() {
        this.gameStat = true;
        this.date = 0;
        MainCharacter me = new MainCharacter();
        Character0 exFriend = new Character0(this, me);
        Character1 friend = new Character1(this, me);
        Character2 Classmate = new Character2(this, me); 
        Character3 Senior = new Character3(this, me);
        Character4 Badguy = new Character4(this, me);
        Character5 Sister = new Character5(this, me);
        System.out.println();

        while (this.gameStat && this.date < 7) {
            switch (this.date) {
                case 0:
                    exFriend.Day0_intro();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    break;
                case 1:
                    Classmate.DAY1_atSchool();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    Sister.DAY1_atSchool();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    friend.DAY1_atSchool();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    Sister.Day1_afterSchool();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    break;
                case 2:
                    Badguy.Day2_0800();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    Classmate.DAY2_atSchool();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    Senior.Day2_1300();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    friend.DAY2_afterSchool();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    break;
                case 3:
                    friend.DAY3_exam();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    Badguy.Day3_1200();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    Senior.Day3_1400();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    Sister.Day3_store();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    Classmate.DAY3_evening();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    break;
                case 4:
                    Classmate.DAY4_atSchool();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    Badguy.Day4_1100();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    Senior.Day4_1200();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    Sister.Day4_library();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    friend.DAY4_afterSchool();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    break;
                case 5:
                    Sister.Day5_busStop();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    Badguy.Day5_0810();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    friend.DAY5_Morning();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    Senior.Day5_1230();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    Classmate.DAY5_pickClothes();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    break;
                case 6:
                    friend.DAY6_breakTime();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    Classmate.DAY6_injury();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    Senior.Day6_1300();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    Badguy.Day6_1500();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    Sister.Day6_stair();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    break;
                case 7:
                    Sister.Day7();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    Senior.Day7();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    Badguy.Day7();
                    System.out.println("[press any Key to continue]");
                    scanner.nextLine();
                    break;
                default:
                    break;
            }

            if(this.gameStat == false) {
                System.out.println("DEFEAT!!");
                break;
            } else if (this.date >= 1) {
                System.out.println("Summary of DAY " + this.date);
                friend.print();
                Classmate.print();
                Senior.print();
                Badguy.print();
                Sister.print();
                System.out.println("[press any Key to continue]");
                scanner.nextLine();
            }

            this.date++;
        }

    }

    public static void main(String[] args) {
        Game newGame = new Game();
    }

}

class Printer {
    public static void print_with_delay(String sentences) {
        for (char c : sentences.toCharArray()) {
            System.out.print(c);
            System.out.flush();
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println();
        try {
            TimeUnit.MILLISECONDS.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SubCharacter {
    String gender;
    int likePoint;
    String name;
    String type;
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    Printer printer;
    Game game;
    MainCharacter mainCharacter;

    public SubCharacter(Game game, MainCharacter mainCharacter) {
        this.game = game;
        this.mainCharacter = mainCharacter;
    }

    public void print() {
        System.out.println("----------------------------");
        System.out.println("Name: " + this.name);
        System.out.println("Relationship: " + this.type);
        System.out.println("Gender: " + this.gender);
        System.out.print("Like Point: ");
        for (int i = 0; i < 10; i++) {
            if (i < this.likePoint / 10) System.out.print("#");
            else System.out.print("-");
        }
        System.out.println(this.likePoint + "%");
    }
}

class Character0 extends SubCharacter {
    public Character0(Game game, MainCharacter mainCharacter) {
        super(game, mainCharacter);
        this.game = game;
        this.mainCharacter = mainCharacter;
        this.type = "前男/女友";
        this.name = "??";
    }

    public void Day0_intro() {
        Printer.print_with_delay("??：你要跟我分手？為什麼？");
        Printer.print_with_delay("我：你還敢問我為什麼？因為你這人真的太恐怖了！在我的手機偷偷安裝定位，被我發現之後你說是怕我會有危險，這也就算了！");
        Printer.print_with_delay("我：我只不過跟其他人講話而已，你就跟大家說我把你這另一半丟在旁邊而我在誘惑別人？");
        Printer.print_with_delay("??：你就是在誘惑他啊？不然你們怎麼會笑得這麼開心？");
        Printer.print_with_delay("我：我們那只是朋友在聊天...算了！我不想跟你再解釋什麼了！就這樣和平分手吧！");
        Printer.print_with_delay("??：既然你執意如此，我不會讓你就這麼離開的喔？（默默的從他的書包內拿出一把刀）");
        Printer.print_with_delay("我：你...你想幹什麼？還有你在書包裡放刀？");

        Printer.print_with_delay("??：這把刀啊～原本是用來保護你的呦～");
        Printer.print_with_delay("??：然後我想幹嘛？當然是想一個你跟我可以永遠在一起的方法啊！");
        Printer.print_with_delay("??：只要你死了，你的心就會永遠的屬於我了～嘻嘻");
        Printer.print_with_delay("我：你...你玩笑開過頭了喔！不要過來！！！");
        Printer.print_with_delay("??：啊！不然這樣好了！我們來玩個遊戲，怎麼樣？");
        Printer.print_with_delay("（他一臉戲謔的慢慢走了過來並用拿著刀子的那隻手環扣在我脖子上）");
        Printer.print_with_delay("我：這樣我就能活命？");
        Printer.print_with_delay("??：沒錯！你會活命～我向來說話算話");
        Printer.print_with_delay("??：你經常用你這張臉去誘惑人呢～不如......");
        Printer.print_with_delay("??：在一週之內找到新的戀人這個遊戲怎麼樣？啊～我已經興奮起來了～");

        Printer.print_with_delay("我：一週？這不可能！你這是在強人所難");
        Printer.print_with_delay("??：強人所難又如何？你能錯過這唯一一個能讓你活命的機會？");
        Printer.print_with_delay("??：很。好。玩。對吧～");
        Printer.print_with_delay("??：對了對了！告訴你一件好消息～今天算第一天～所以你只剩六天可以攻略喔～");
        Printer.print_with_delay("??：我會好好期待的！期待你跟我『融合』的那一天～哈哈哈哈哈哈哈");
        Printer.print_with_delay("我：看來我只能真的照做了，以他的個性，我如果真的沒做到恐怕下場會很慘吧！");
        Printer.print_with_delay("我：不想了！趕快去學校吧！畢竟我時間不多了，我一定要找到我的戀人，希望個性不要再這樣了 呵呵");
    }
}

class Character1 extends SubCharacter {
    public Character1(Game game, MainCharacter mainCharacter) {
        super(game, mainCharacter);
        this.game = game;
        this.mainCharacter = mainCharacter;
        this.type = "青梅竹馬";
        this.name = "由美";
        this.likePoint = random.nextInt(16) + 65;
        this.gender = "女";
    }

    public void DAY1_atSchool() {
        Printer.print_with_delay("Day1--10:00");
        Printer.print_with_delay("（你跟" + this.name + "的家很近，只住在對面，在小時候常常在一起玩，會考考上了同一所高中又被分到了同班。）");
        Printer.print_with_delay("我：欸" + this.name + "我們怎麼那麼有緣 又被分到同班。");
        Printer.print_with_delay(this.type + "：對啊 真的是太剛好哈哈。");
        Printer.print_with_delay("我：以後也請多多指教囉！");
        Printer.print_with_delay("（在學校，" + this.name + "的成績一落千丈，而你的成績在班上名列前矛。)");
        Printer.print_with_delay(this.type + "：欸這次我有進步ㄛ 從倒數第一變倒數第二");
        Printer.print_with_delay("我：我問號。啊你以前不是成績很好嗎 怎麼上了高中反而不認真了");
        Printer.print_with_delay(this.type + "：哪有，我很認真啊 每天都認真打扮。");
        Printer.print_with_delay("我：你再這樣下去不行 你媽媽每天都來找我抱怨你的成績。");
        Printer.print_with_delay(this.type + "：不用理他啦，我媽她就喜歡到處講我。");
        Printer.print_with_delay("我：我們不是說好也要考同一所大學嗎 你這樣怎麼行。");
        Printer.print_with_delay(this.type + "：以前是以前啦 現在是現在。");
        Printer.print_with_delay("我：我看不下去了 我找時間幫你單獨補習，一定要讓你媽刮目相看。");
        Printer.print_with_delay(this.type + "：沒關係，不用麻煩你啦");
        Printer.print_with_delay("我：我不麻煩，反而是你，你再不認真我要去跟你媽媽說你偷把裙子改短了喔");
        Printer.print_with_delay(this.type + "：好啦好啦，其實我也過想考好只是我好像做不到");
        Printer.print_with_delay("我：那是你打開的方式不對 我下次給你單獨補習");
        Printer.print_with_delay(this.type + "：好啦好啦，我會抽時間出來的。");
        Printer.print_with_delay("我：這樣才對嘛。");
    }

    public void DAY2_afterSchool() {
        Printer.print_with_delay("Day2--16:00");
        Printer.print_with_delay(this.type + "：下課了欸，我們一起走回家吧。");
        Printer.print_with_delay("1：好啊");
        Printer.print_with_delay("2：不好");
        int choice = scanner.nextInt();
        if (choice == 1) {
            Printer.print_with_delay("(你和" + this.name + "一起走回家，走啊走啊走……)");
            Printer.print_with_delay(this.type + "：有小孩在那邊盪鞦韆欸 看起來很開心");
            Printer.print_with_delay("1：那我們也去玩一下吧");
            Printer.print_with_delay("2：真的欸 看完我們該走了 明天還有考試呢");

            choice = scanner.nextInt();
            if(choice == 1) {
                this.likePoint += 3;
                Printer.print_with_delay(this.type + "：那我們走吧，有點累哈哈明天還有考試呢！");
            }
            if(choice == 2) {
                this.likePoint -= 3;
                Printer.print_with_delay(this.type + "：那我們走吧，有點累哈哈明天還有考試呢。");
            }
            Printer.print_with_delay("1：這個夕陽好好看 可惜明天要考試 那我們等到太陽下山再走吧");
            Printer.print_with_delay("2：要趕快回家看書了");

            choice = scanner.nextInt();
            if (choice == 1) this.likePoint += 5;
            if (choice == 2) this.likePoint -= 3;
            Printer.print_with_delay("1：明天考試加油喔");
            Printer.print_with_delay("2：我們等等電話討論功課 加油");

            choice = scanner.nextInt();
            if (choice == 1) this.likePoint += 5;
            if (choice == 2) this.likePoint -= 5;
            Printer.print_with_delay(this.type + "：謝謝 我自己會努力的 我今天有點累就先休息了");
        }
        if(choice == 2) {
            game.gameStat = false;
        }

    }

    public void DAY3_exam() {
        Printer.print_with_delay("Day3--09:00");
        Printer.print_with_delay("我：這次考怎樣，有進步嗎");
        Printer.print_with_delay(this.type + "：欸欸我覺得這次感覺可以喔");
        Printer.print_with_delay("1：你確定？考不好的人好像都會這樣說");
        Printer.print_with_delay("2：就不要分數出來超低哈哈");
        int choice = scanner.nextInt();
        if (choice == 1) this.likePoint += 3;
        if (choice == 2) this.likePoint -= 5;
        Printer.print_with_delay(this.type + "：真的啦 我這次感覺一定會進步");
        Printer.print_with_delay("（發成績 )");

        Printer.print_with_delay("我：啊你考的怎麼樣");
        Printer.print_with_delay(this.type + "：你看你看 我就說嘛我這次進步了10分");
        Printer.print_with_delay("我：一定是幫你補習的原因哼哼😌");
        Printer.print_with_delay(this.type + "：才不是勒😝是我最近比較認真哈哈");
        Printer.print_with_delay("我：要不要一起去福利社 為了慶祝你進步我請你吃東西");
        Printer.print_with_delay(this.type + "：好啊好啊");
        Printer.print_with_delay("(來到了福利社，你拿了...)");
        Printer.print_with_delay("1：一瓶可樂作為獎勵");
        Printer.print_with_delay("2：一個巧克力作為獎勵");
        choice = scanner.nextInt();
        if (choice == 1) {
            this.likePoint -= 10;
            Printer.print_with_delay(this.type + "：我最近不能喝冰的餒");
            Printer.print_with_delay("我：那就巧克力吧 當作進步的獎勵");
        }
        if( choice == 2) {
            this.likePoint += 10;
            Printer.print_with_delay(this.type + "：這個巧克力剛好是我最喜歡的欸");
        }
        Printer.print_with_delay(this.type + "：謝謝！");
    }

    public void DAY4_afterSchool() {
        Printer.print_with_delay("Day4--16:00");
        Printer.print_with_delay("（放學了，你準備回去趕報告，正好遇到" + this.name + "）");
        Printer.print_with_delay("我：放學了，我們一起走吧");
        Printer.print_with_delay(this.type + "：好啊，等我一下我整理一下馬上");

        Printer.print_with_delay("1：好，我等你");
        Printer.print_with_delay("2：好，快點");
        int choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 5;
        if(choice == 2) this.likePoint -= 5;
        Printer.print_with_delay(this.type + "：欸我還要去上一下廁所");

        Printer.print_with_delay("1：欸你拖拉機喔 很會拖欸");
        Printer.print_with_delay("2：好啦趕快");
        choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 5;
        if(choice == 2) this.likePoint -= 3;
        Printer.print_with_delay(this.type + "：好啦好啦哈哈我趕快");
        Printer.print_with_delay("（放學路上）");

        Printer.print_with_delay("1：路上車很多欸 小心一點");
        Printer.print_with_delay("2：（把她拖到內側）");
        choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 1;
        if(choice == 2) this.likePoint += 10;
        Printer.print_with_delay(this.type + "：(笑");
        Printer.print_with_delay("我：前面有兩隻貓咪欸");
        Printer.print_with_delay(this.type + "：欸真的欸 好可愛ㄚ");
        Printer.print_with_delay(this.type + "：喵喵你好可愛喔（摸貓貓 ");
        Printer.print_with_delay("我：我覺得還好欸");
        Printer.print_with_delay(this.type + "：蛤 他們很可愛啊為什麼");
        Printer.print_with_delay("1：再可愛哪有你可愛");
        Printer.print_with_delay("2：我比較喜歡狗狗🐶");
        choice = scanner.nextInt();
        if(choice == 1) {
            this.likePoint += 10;
            Printer.print_with_delay(this.type + "：死相啦");
        }
        if(choice == 2) {
            this.likePoint -= 5;
            Printer.print_with_delay(this.type + "：狗狗也很可愛");
        }
    }

    public void DAY5_Morning() {
        Printer.print_with_delay("Day5--07:30");
        Printer.print_with_delay("我：欸那邊有飛機撞到計程車了 趕快蹲下");
        Printer.print_with_delay("1：把" + this.name + "撲倒");
        Printer.print_with_delay("2：不撲倒她");
        int choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 5;
        Printer.print_with_delay(this.type + "：哇 好痛喔 幸好只是擦到而已沒有撞到我 我還以為你是開玩笑的欸");
        Printer.print_with_delay("我：我這邊剛好有藥膏 你是哪裡擦傷");
        Printer.print_with_delay(this.type + "：我大腿這邊有點擦傷好痛 我的手也是好痛");
        Printer.print_with_delay("1：藥膏給你");
        Printer.print_with_delay("2：我來幫你擦吧");
        choice = scanner.nextInt();
        if(choice == 1) {
            Printer.print_with_delay(this.type + "：謝謝 真不好意思哈哈");
            this.likePoint -= 5;
        }
        if(choice == 2 && this.likePoint >= 50) {
            Printer.print_with_delay(this.type + "：謝謝 真不好意思哈哈");
            this.likePoint += 10;
        }
        if(choice == 2 && this.likePoint < 50) {
            Printer.print_with_delay(this.type + "：不用了謝謝，我自己來就好");
        }
    }

    public void DAY6_breakTime() {
        Printer.print_with_delay("Day6--09:00");
        Printer.print_with_delay("我：欸剛剛看你上課都在睡覺 啊你這樣一定學不會的啦");
        Printer.print_with_delay(this.type + "：這是我新創的學習法喔 睡眠學習法");
        Printer.print_with_delay("1：笑死這樣聽的懂我就做你男朋友");
        Printer.print_with_delay("2：哈哈你真有才 認真問啦要不要我給你講一遍");
        int choice = scanner.nextInt();
        if(choice == 1) this.likePoint -= 20;
        if(choice == 2) this.likePoint += 20;
        Printer.print_with_delay(this.type + "：不用 謝謝啦 其實我昨天先預習了 只是忙到很晚很累");
        Printer.print_with_delay("我：哎呦 怎麼突然認真起來了");
        Printer.print_with_delay(this.type + "：不想辜負我媽媽跟你的期待嘛");
    }

    public void surveillance() {
        if (random.nextInt(101 - likePoint) == 0) {
            Printer.print_with_delay("你怎麼可以這樣?");
            game.gameStat = false;
        }
    }
}


class Character2 extends SubCharacter {
    public Character2(Game game, MainCharacter mainCharacter) {
        super(game, mainCharacter);
        this.game = game;
        this.mainCharacter = mainCharacter;
        this.type = "同桌";
        this.name = "日向葵";
        this.likePoint = random.nextInt(13) + 45;
        this.gender = "女";
    }

    public void DAY1_atSchool() {
        Printer.print_with_delay("Day1--08:00");
        Printer.print_with_delay("(上課鐘聲響起，進到教室中，發現黑板已經有新的座位表)");
        Printer.print_with_delay("(依照座位表早到就坐位置後:)");
        Printer.print_with_delay(this.type + "：早安，我的名字是" + this.name + "，我們這次是同桌喔，請多多指教");
        Printer.print_with_delay("同桌帶著向陽光一半的笑容跟我打招呼。");
        Printer.print_with_delay("我：哦，請多多指教");
        Printer.print_with_delay("(如果是同桌的話，感覺相處時間會變得多起來，應該有機會讓攻略她吧，好，那就決定是她了。)");
    }
    
    public void DAY2_atSchool() {
        Printer.print_with_delay("Day2--10:00");
        Printer.print_with_delay("(上課真無聊啊~~ 诶，" + this.name +"在打瞌睡?)");
        Printer.print_with_delay("1：拿出便條紙，在紙條寫到:「打瞌睡小心被老師抓到，無聊的話要不要用紙條聊天」偷偷把紙條塞給在打瞌睡的同桌。");
        Printer.print_with_delay("2：用鉛筆偷偷戳對方，然後笑著看著同桌跟她說這堂課很重要，小心不要睡著。順便把剛剛去合作社買的提神薄荷糖分給她。");
        int choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 10;
        if(choice == 2) this.likePoint += 6;
        Printer.print_with_delay("(下課後)");
        Printer.print_with_delay(this.type + "：剛剛真的謝謝你，作為回報，我下午請你喝飲料吧");
        Printer.print_with_delay("1：只是叫醒你就有飲料喝也太好了吧，不然這樣，我負責跑腿，你負責出錢，讓我當負責跑腿的同桌吧");
        Printer.print_with_delay("2：叫醒你只有飲料喝嗎，如果只有這樣，下次你再睡著我就不知道我自己會做甚麼囉");
        Printer.print_with_delay("3：不用啦，不用因為這種事情請我喝飲料啦，我會不好意思");
        choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 4;
        if(choice == 2) this.likePoint -= 8;
    }

    public void DAY3_evening() {
        Printer.print_with_delay("Day3--19:00");
        Printer.print_with_delay(this.type + "：你是不是數學特別好啊，今天老師上的排列組合我不太懂，可以教我嗎？");
        Printer.print_with_delay("1：當然沒問題，剛好我這次的英文文法搞不太懂，作為交換，你可以教我英文嗎？");
        Printer.print_with_delay("2：你是小笨蛋嗎，我有整理好的數學筆記，偷偷跟你講，我只給你而已喔");
        int choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 2;
        if(choice == 2) this.likePoint += 8;
        Printer.print_with_delay("(" + this.name + "暫時複習完今天的內容，放下筆後用手撐起頭看著我)");
        Printer.print_with_delay(this.type + "：你好認真喔。這就是功課好的原因嗎？");
        Printer.print_with_delay("1：用手把她的頭轉回去並說道：這位同學，晚自習請認真讀書。");
        Printer.print_with_delay("2：學她用手把頭撐起來看著她並說道：這位同學，用這種眼神打擾晚自習的同學犯規喔，我也要打擾回去。");
        choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 2;
        if(choice == 2) this.likePoint += 8;
        Printer.print_with_delay("(" + this.name + "要出去裝水，且問說要不要幫忙盛水)");
        Printer.print_with_delay("1：真的嗎，我剛好水壺也沒有水，那就麻煩你了");
        Printer.print_with_delay("2：把自己的水壺藏起來，並跟她說：「我今天忘記帶水壺了，我能跟我最好的同桌借水壺喝水嗎？」");
        Printer.print_with_delay("3：現在四處都暗暗的ㄟ，我跟你一起去盛水好了");
        choice = scanner.nextInt();
        if(choice == 2) this.likePoint -= 10;
        if(choice == 3) this.likePoint += 8;
        Printer.print_with_delay("(晚自習結束。)");
        Printer.print_with_delay("1：已經很晚了，自己回家不安全，我可以陪你搭公車，要一起回家嗎？");
        Printer.print_with_delay("2：已經很晚了，回家注意安全喔，到家傳訊息跟我說一下，掰掰");
        choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 8;
        if(choice == 2) this.likePoint += 2;
    }

    public void DAY4_atSchool() {
        Printer.print_with_delay("Day4--09:00");
        Printer.print_with_delay("老師：好，這禮拜是學園祭，我們班的主題是女僕咖啡廳，大家一起分組吧。");
        Printer.print_with_delay(this.type + "：(跨過桌子的中線，把臉湊近說) 一起準備學園祭感覺會很有趣，我們一組吧，可是你好像有其他朋友…");
        Printer.print_with_delay("1：不用在意他們，跟他們一組感覺會很沒效率，而且我也想和你一組");
        Printer.print_with_delay("2：平常跟他們太常待在一起了，偶爾換換組員也不錯，我們一組吧，請多多指教");
        int choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 8;
        if(choice == 2) this.likePoint += 4;
        Printer.print_with_delay("老師：好的那這組負責準備女僕的衣服跟設計菜單喔");
        Printer.print_with_delay(this.type + "：幸好聽起來不是什麼太麻煩的工作，我們今天的目標是先把菜單設計完成，學園祭前一天再去租女僕衣吧。");
        Printer.print_with_delay("1：沒問題，你是不是喜歡喝珍珠奶茶，那我們就公器私用，把珍珠奶茶也列入菜單吧。");
        Printer.print_with_delay("2：菜單的部分我可以負責幫品項取名，但我的美術不好，美編的部分可能要交給你喔。");
        choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 6;
        Printer.print_with_delay("(今天的學園祭準備工作暫時告一段落。)");
    }

    public void DAY5_pickClothes() {
        Printer.print_with_delay("Day5--16:30");
        Printer.print_with_delay(this.type + "：你提早到啦，我們趕快進去幫大家租明天要穿的女僕衣吧");
        Printer.print_with_delay("我：進去吧，ㄟ你也會扮成女僕嗎？");
        Printer.print_with_delay(this.type + "：會的喔，怎麼了嗎？");
        Printer.print_with_delay("1：感覺會很有趣，你穿起來肯定很好看吧，可是這樣就大家都看到的了…");
        Printer.print_with_delay("2：感覺會很有趣，你穿起來肯定很好看吧，我很期待喔");
        int choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 8;
        if(choice == 2) this.likePoint += 6;
        Printer.print_with_delay("(一段時間後...)");
        Printer.print_with_delay(this.type + "：大家的衣服都租好了，剩我自己還沒挑，你要不要幫我挑");
        Printer.print_with_delay("1：我看一下喔，你說過你不適合太緊身的衣服，啊！這件版型感覺很適合你，你穿起來一定很好看");
        Printer.print_with_delay("2：我不會挑衣服ㄟ，我怕挑到你不喜歡的，你自己選啦，反正你穿甚麼都好看。");
        choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 8;
        if(choice == 2) this.likePoint += 6;
        Printer.print_with_delay("(回到學校後)");
        Printer.print_with_delay("我：呼，這樣學園祭的是前準備終於告一段落了，後天一定要好好體驗學園祭");
        Printer.print_with_delay(this.type + "：好期待後天喔");
        Printer.print_with_delay("1：你是值班到１２點對吧，我之後剛好有空，要不要一起去逛學園祭");
        Printer.print_with_delay("2：你後天有空嗎？我不想錯過難得的機會，我明天想要跟你一起逛學園祭");
        Printer.print_with_delay("3：聽說明天３班會賣棉花糖，你不是喜歡吃棉花糖嗎？到時候要不要一起去？");
        choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 2;
        if(choice == 2) this.likePoint += 8;
        if(choice == 3) this.likePoint += 4;
        Printer.print_with_delay(this.type + "：(笑著點頭說) 可以啊，把一點時間分給你，好期待阿。");
    }

    public void DAY6_injury() {
        Printer.print_with_delay("Day6--10:00");
        Printer.print_with_delay("(你和" + this.name + "在為了學園祭做準備)");
        Printer.print_with_delay("我：你怎麼了?");
        Printer.print_with_delay(this.type + "：我剛剛裁紙條的時候不小心割到手了ＱＱ");
        Printer.print_with_delay("1：用手帕幫她做簡單的包紮，並馬上舉手跟老師說要帶同桌去保健室。");
        Printer.print_with_delay("2：用嘴巴吸住她的手指幫她止血，再帶她去保健室包紮。");
        int choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 7;
        if(choice == 2) this.likePoint -= 20;
        Printer.print_with_delay("到保健室包紮完回到教室後，回到座位，同桌打算繼續把沒裁完的紙割完");
        Printer.print_with_delay(this.type + "：謝謝你剛剛帶我去保健室");
        Printer.print_with_delay("1：為甚麼裁紙條不找我幫忙。");
        Printer.print_with_delay("2：下次請小心，為了準備學園祭割到手好不值得，而且我會有點心疼。並且將所有的紙條搶過來自己裁");
        choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 3;
        if(choice == 2) this.likePoint += 10;
    }

}

class Character3 extends SubCharacter {
    public Character3(Game game, MainCharacter mainCharacter) {
        super(game, mainCharacter);
        this.game = game;
        this.mainCharacter = mainCharacter;
        this.type = "學長";
        this.name = "坊西透";
        this.likePoint = random.nextInt(21) + 50;
        this.gender = "男";
    }

    public void Day2_1300() {
        Printer.print_with_delay("Day2--13:00");
        Printer.print_with_delay(this.type + "：今天我們要做的是手工餅乾，做好之後可以自己留著或是送給喜歡的人吃喔。");
        Printer.print_with_delay("我：學長我不太會做，可以請你來協助我嗎？");
        Printer.print_with_delay(this.type + "：當然可以啦，有什麼問題都可以問我。");
        Printer.print_with_delay("我：那我們開始吧。");
        Printer.print_with_delay("我：我要不要把餅乾送給學長呢...");
        Printer.print_with_delay("1：不要好了。");
        Printer.print_with_delay("2：當然要。");
        int choice = scanner.nextInt();
        if(choice == 1) {
            likePoint -= 5;
            if (this.gender == "男") {
                Printer.print_with_delay(this.type + "：小學弟，你的餅乾是要送人的嗎？");
            }else {
                Printer.print_with_delay(this.type + "：小學妹，你的餅乾是要送人的嗎？");
            }
            
            Printer.print_with_delay("我：應該吧，或是我自己吃掉。學長怎麼了嗎？");
            Printer.print_with_delay(this.type + "：喔沒事啦，那品嘗後再分享感想給我。");
            Printer.print_with_delay("我：好的。");
        }
        else if(choice == 2) {
            likePoint += 5;
            Printer.print_with_delay("我：學長，我做的餅乾送給你吃。");
            Printer.print_with_delay(this.type + "：你要送給我吃嗎？");
            Printer.print_with_delay("我：對呀，可是我不知道味道如何就是了。");
            Printer.print_with_delay(this.type + "：沒事，有我在旁邊協助你，做出來的味道一定不會差。");
            Printer.print_with_delay("我：說的也是，有學長的加持，餅乾味道一定很好。");
            Printer.print_with_delay(this.type + "：我也沒幫什麼忙，有點不好意思呢，那我就收下囉。");
            Printer.print_with_delay("我：當然，請一定要收下。");
        }  
    }

    public void Day3_1400() {
        Printer.print_with_delay("Day3--14:00");
        Printer.print_with_delay("(在社團活動中，學長注意到你的圍裙後面破了一個洞，所以在社團課下課後...");
        Printer.print_with_delay(this.type + "：我看到你圍裙後面破洞了，你有發現嗎？");
        Printer.print_with_delay("我：欸？真的嗎？在哪裡？");
        Printer.print_with_delay(this.type + "：在這裡，剛好是你看不到的地方。");
        Printer.print_with_delay("我：那怎麼辦呢。");
        Printer.print_with_delay(this.type + "：剛好我會縫補，需要我幫你縫嗎？");
        Printer.print_with_delay("主角:我要不要讓學長幫我縫補圍裙呢...");
        Printer.print_with_delay("1：拒絕，還是自己補好了");
        Printer.print_with_delay("2：好呀，讓學長幫忙補");
        int choice = scanner.nextInt();
        if(choice == 1) {
            likePoint -= 5;
            Printer.print_with_delay("我：謝謝學長的好意，我還是自己來就行了。");
            Printer.print_with_delay(this.type + "：你確定嗎？");
            Printer.print_with_delay("我：雖然可能沒辦法縫得很完美，但沒關係。");
            Printer.print_with_delay(this.type + "：那好吧，你拿針跟縫補的時候，一定要小心，不要扎到手了。");
            Printer.print_with_delay("我：好的。");
        }
        if(choice == 2) {
            likePoint += 5;
            Printer.print_with_delay("我：學長，我不太會補，那就麻煩你了。");
            Printer.print_with_delay(this.type + "：不會麻煩的，剛好我平時衣服破洞或是其他東西破掉，我都是自己把它縫回去的。");
            Printer.print_with_delay("我：哇！學長，你根本就是大暖男吧。除了會做吃的還有縫東西，還有什麼是你不會的。");
            Printer.print_with_delay(this.type + "：你太誇張了啦，雖然這些是我的強項沒錯，但人不是十全十美的，我也是有不會的。");
            Printer.print_with_delay("我：沒關係，我覺得學長已經很棒了，如果以後要找對象好想找跟學長一樣暖的。");
            Printer.print_with_delay("學長（害羞：縫好了，還給你吧。如果之後又破掉了，再拿來給我縫吧。");
            Printer.print_with_delay("我：好的，謝謝學長。");
        }
    }

    public void Day4_1200() {
        Printer.print_with_delay("Day4--12:00");
        Printer.print_with_delay("主角:學長，快到午餐時間了，你有要吃什麼嗎？");
        Printer.print_with_delay("學長:我應該不需要買，因為我會自己帶便當來。");
        Printer.print_with_delay("主角:好羨慕喔，我等等還要衝去食堂搶食。");
        Printer.print_with_delay("學長:那不然我陪你去買，然後我們一起去找地方吃，你覺得怎麼樣？");
        Printer.print_with_delay("主角:學長約我去吃午餐，我要答應嗎...");
        Printer.print_with_delay("1：拒絕他，我自己回教室吃就好。");
        Printer.print_with_delay("2：答應他，順便帶他去之前發現的漂亮小花園吃。");
        int choice = scanner.nextInt();
        if (choice == 1) {
            likePoint -= 5;
            Printer.print_with_delay("我：不用啦，現在食堂都是人，會很擠也很悶。");
            Printer.print_with_delay(this.type + "：沒關係阿，我剛好也可以順便看看有沒有我喜歡吃的東西。");
            Printer.print_with_delay("我：可是學長你有自己帶便當，再買了就吃不完了。");
            Printer.print_with_delay(this.type + "：吃不完了我們就一起分吧。");
            Printer.print_with_delay("我：我的食量也不大，我還是回教室吃就好。");
            Printer.print_with_delay(this.type + "：那好吧。");
        } else if (choice == 2) {
            likePoint += 10;
            Printer.print_with_delay("我：好呀，可是學長，現在食堂很多人會很擠，你沒問題嗎。");
            Printer.print_with_delay(this.type + "：沒關係的，剛好我也可以看看有沒有喜歡吃的。");
            Printer.print_with_delay("我：那我們買完後，去我前幾天發現的小花園吧。");
            Printer.print_with_delay(this.type + "：好呀。我們走吧。");
        }
    }

    public void Day5_1230() {
        Printer.print_with_delay("Day5--12:30");
        Printer.print_with_delay("(過2天後就是學園祭了，我想要邀請學長陪我一起逛，但是我應該怎麼告訴他呢...)");
        Printer.print_with_delay("1：自己當面交給學長才有誠意，而且還可以把自己親手做的餅乾一起打包送給學長。");
        Printer.print_with_delay("2：請他人轉交。");
        int choice = scanner.nextInt();
        if (choice == 1) {
            likePoint += 30;
            Printer.print_with_delay("（我還是親手交給學長好了）");
            Printer.print_with_delay("我：學長，這個卡片跟餅乾給你。");
            Printer.print_with_delay(this.type + "：嗯？這是什麼卡片阿，還有這個餅乾是你做的嗎？");
            Printer.print_with_delay("我：卡片就是... 2天後就是學園祭了，我想邀請你一起逛。不知道你覺得怎麼樣...");
            Printer.print_with_delay(this.type + "：當然可以啦，我也正好想要問你要不要一起呢。那這包餅乾呢？");
            Printer.print_with_delay("我：餅乾是之前社團課教的手工餅乾，我回去後又在自己做了一些，想說送給學長，讓學長感受到我的誠意。");
            Printer.print_with_delay(this.type + "：你的心意我收到了，謝謝你親手為我做餅乾。");
            Printer.print_with_delay("我：不用客氣啦。");
            Printer.print_with_delay(this.type + "：那我們學園祭就一起逛吧。");
            Printer.print_with_delay("我：好的。");
        }
        else if (choice == 2) {
            likePoint = 0;
            game.gameStat = false;
            Printer.print_with_delay("我：這個麻煩請你幫我轉交給烹飪社的學長。");
            Printer.print_with_delay("路人甲：直接拿給他就好嗎，沒問題。");
            Printer.print_with_delay("(突然間，我眼角餘光瞄到學長的身影漸漸靠近。我感覺到臉頰微微泛起紅暈，卻不知如何解釋。學長好像誤會了甚麼，隨即轉身離去，流露出一絲不悅之情。我急忙追上前去，想為自己的行為解釋清楚...)");
            Printer.print_with_delay("我：學長，等一下，等等我。");
            Printer.print_with_delay(this.type + "：我為什麼要等你，你不是在跟路人甲說話嗎，還送他東西，還臉紅，那你為什麼要來找我。");
            Printer.print_with_delay("我：那是有原因的，你聽我解釋。");
            Printer.print_with_delay(this.type + "：我不想聽你的藉口，不要再來找我了。");
        }
    }

    public void Day6_1300() {
        Printer.print_with_delay("Day6--13:00");
        Printer.print_with_delay("(明天就是學園祭了，班上決定要以女僕咖啡廳為主題，我跟學長都覺得可以做蛋糕來賣，於是...");
        Printer.print_with_delay("我：學長，明天就是學園祭了，既然班上決定要開女僕咖啡廳，而且我們又是烹飪社的，不如我們來做蛋糕，覺得如何？");
        Printer.print_with_delay(this.type + "：我覺得這個主意不錯，而且也很適合在女僕咖啡廳上賣。");
        Printer.print_with_delay("我：那就這麼愉快的決定了，不過我還不太會做蛋糕，所以學長你要幫我唷。");
        Printer.print_with_delay(this.type + "：當然沒問題啦。我們開始吧。");
        Printer.print_with_delay("(做完蛋糕之後...");
        Printer.print_with_delay("我：學長，蛋糕做好了，我們來試試味道吧。");
        Printer.print_with_delay(this.type + "：可以呀。");
        Printer.print_with_delay("我：要品嘗蛋糕時，我決定...");
        Printer.print_with_delay("1:跟學長各切各的蛋糕，各吃各的蛋糕。");
        Printer.print_with_delay("2:幫學長切好後，餵到他嘴邊給他吃。");
        int choice = scanner.nextInt();
        if (choice == 1) {
            likePoint -= 5;
            Printer.print_with_delay("我：那學長你先切好了，我等等再切。");
            Printer.print_with_delay(this.type + "：我可以順便幫你切的。");
            Printer.print_with_delay("我：不用麻煩啦，而且你也不知道我想吃多少，所以我自己來就好了。");
            Printer.print_with_delay(this.type + "：那好吧，吃完再跟我說說味道如何。");
            Printer.print_with_delay("(兩人坐下來吃蛋糕，期間很少交流");
        }
        else if (choice == 2) {
            likePoint = 100;
            Printer.print_with_delay("我：學長，我來幫你切蛋糕吧。你要多大塊呢？");
            Printer.print_with_delay(this.type + "：你就照你想要切的大小就可以。");
            Printer.print_with_delay("我：那我就隨便切囉。");
            Printer.print_with_delay(this.type + "：好的。");
            Printer.print_with_delay("(切好蛋糕後，坐下來面對面吃)");
            Printer.print_with_delay("我：學長你覺得我們做的蛋糕怎麼樣，味道如何？");
            Printer.print_with_delay(this.type + "：味道還不錯，不會太甜也不會沒味道。明天可以拿去女僕咖啡廳賣了。");
            Printer.print_with_delay("我：真的嗎，真是太好了，阿學長你嘴角好像沾到了奶油。");
            Printer.print_with_delay(this.type + "：真的嗎？在哪裡？");
            Printer.print_with_delay("我：我幫你");
            Printer.print_with_delay("(我用手抹掉了學長嘴邊的奶油)");
            Printer.print_with_delay(this.type + "：給你衛生紙。");
            Printer.print_with_delay("我：不用啦，這樣就好啦。");
            Printer.print_with_delay("(我邊說邊舔掉了手上的奶油，而學長看著害羞地別過了眼睛)");
            Printer.print_with_delay(this.type + "：喔喔好。");
            Printer.print_with_delay("我：那就明天賣蛋糕囉。");
        }
    }

    public void Day7() {
        if (this.likePoint <= 50) return;
        Printer.print_with_delay("Se");
        Printer.print_with_delay("（主角與學長忙完女僕咖啡廳的事情後，決定一起逛學園祭…");
        Printer.print_with_delay("我：學長，你有想要逛什麼嗎？");
        Printer.print_with_delay(this.type + "：看你呀，我都行。");
        Printer.print_with_delay("我：我有點餓了，不然我們邊逛邊看看吃什麼好了。");
        Printer.print_with_delay(this.type + "：好呀。");
        Printer.print_with_delay("我：突然想吃章魚燒，學長，我們去找有賣章魚燒的地方吧。");
        Printer.print_with_delay(this.type + "：那就走吧。");
        Printer.print_with_delay("（買到章魚燒後…");
        Printer.print_with_delay("學長OS（臉鼓起來好像倉鼠，好可愛）");
        Printer.print_with_delay("我：學長要吃嗎？");
        Printer.print_with_delay(this.type + "：不用，你吃就好");
        Printer.print_with_delay("我：那學長你有想吃的再跟我說。");
        Printer.print_with_delay(this.type + "：嗯。");
        Printer.print_with_delay("（學園祭後的營火晚會…");
        Printer.print_with_delay("我：學長，今天過得開心嗎？");
        Printer.print_with_delay(this.type + "：還不錯，你呢。");
        Printer.print_with_delay("我：我覺得非常開心喔。話說，我可以問你一個問題嗎？");
        Printer.print_with_delay(this.type + "：是什麼問題呢？");
        Printer.print_with_delay("我：就是…學長，我喜歡你，你呢。");
        Printer.print_with_delay("學長（臉紅）：我嗎…其實我也喜歡你。");
        Printer.print_with_delay("我：那學長我可以再問一個問題嗎。");
        Printer.print_with_delay("學長（笑著說）：好阿。");
        Printer.print_with_delay("我：那你願意當我的男朋友嗎？");
        Printer.print_with_delay(this.type + "：當然，這不需要問的，畢竟我喜歡你嘛。");
    }
}

class Character4 extends SubCharacter {
    public Character4(Game game, MainCharacter mainCharacter) {
        super(game, mainCharacter);
        this.game = game;
        this.mainCharacter = mainCharacter;
        this.type = "混混";
        this.name = "湊";
        this.likePoint = random.nextInt(11) + 50;
        this.gender = "男";
    }

    public void Day2_0800() {
        System.out.println();
        Printer.print_with_delay("Day2--08:00");
        Printer.print_with_delay("我：完蛋要遲到了！啊啊啊啊啊！");
        Printer.print_with_delay("我：我的鬧鐘呢？怎麼沒叫？靠，我沒設到鬧鐘？！");
        Printer.print_with_delay("（三分鐘之內解決刷牙洗臉換衣服）");
        Printer.print_with_delay("我：我出門囉！衝啊啊啊啊啊！！！");
        Printer.print_with_delay("（跑到一半，別在書包上的別針掉了下來，滾落到巷子內）");
        Printer.print_with_delay("我：今天到底怎麼回事啊！水逆嗎？");
        Printer.print_with_delay("我：（跑到小巷子內）怎麼回事？有人在打架？");
        Printer.print_with_delay("?????：走著瞧！我們走，小弟們");
        Printer.print_with_delay("???:弱者才會說這種話啦！走著瞧？哈哈！你們來幾次我打幾次");
        Printer.print_with_delay("（一群被打的十分狼狽的人從我身旁跑過）");
        Printer.print_with_delay("我：我是不是也該閃了！別針嘛！之後再找就好了！嗯對！就這麼決定");
        Printer.print_with_delay("我：可是那個人沒事嗎？他只有一個人而已欸？");
        Printer.print_with_delay("我：啊啊！不想了！直接走我一定會後悔！");
        Printer.print_with_delay("（小心翼翼的走過去）");
        Printer.print_with_delay("我：那個...你沒事吧！ 欸？你不是我們班的嗎？你怎麼會在這裡打架？快遲到了欸！");
        Printer.print_with_delay("湊：怕遲到你倒是走啊！");
        Printer.print_with_delay("1：不行，我不能把你丟在這裡");
        Printer.print_with_delay("2：哦好！那我走了！");
        int choice = scanner.nextInt();
        if(choice == 1) {
            likePoint += 10;
            Printer.print_with_delay("我：蛤？你以為你誰啊？我應該沒跟你好到這種程度吧？");
            Printer.print_with_delay("我：話不能這樣講啊！今天被我看到了！我就是要管，不然我會良心不安的，況且你是我同學");
            Printer.print_with_delay("湊：好笑，那你就良心不安吧！我的事你別管了，小心引火上身");
            Printer.print_with_delay("我：都什麼時候了還關心我");
            Printer.print_with_delay("湊：誰他媽關心你！呃......");
        }
        else if(choice == 2) {
            likePoint -= 10;
            Printer.print_with_delay("我：慢走不送");
            Printer.print_with_delay("湊：你真的沒事吧？");
            Printer.print_with_delay("我：你吵死了！");
            Printer.print_with_delay("湊：噢！我閉嘴");
        }
        Printer.print_with_delay("（只見他沿著牆壁緩緩的跌坐）");
        Printer.print_with_delay("我：你果然受傷了吧！我扶你，你起得來嗎？");
        Printer.print_with_delay("湊：別碰我！不想被我打的話就走開");
        Printer.print_with_delay("我：哎呀！這種時候就別倔了啦！不然我陪你坐在這，等你好一點我們再走");
        Printer.print_with_delay("湊：不是怕遲到？遲到就不要怪在我身上！");
        Printer.print_with_delay("我：不會啦！我又不是那種人！我就不能是因為擔心你才留下來的嗎？");
        Printer.print_with_delay("湊：用不著你來擔心");
        Printer.print_with_delay("我：決定了！你這樣也沒辦法去學校對吧！那我送你回家！");
        Printer.print_with_delay("湊：蛤？我才不需要你陪，我自己能走");
        Printer.print_with_delay("（他突然站了起來）");
        Printer.print_with_delay("我：欸！不要勉強啦！讓我扶你");
        Printer.print_with_delay("湊：就叫你別他媽碰我");
        Printer.print_with_delay("我：好好好～我不碰 我不碰");
        Printer.print_with_delay("湊：那還不快走，去你的學校");
        Printer.print_with_delay("我：我偏不！我一定要送你到家才走！這是我的堅持！！");
        Printer.print_with_delay("湊：隨便吧！煩死了！");
        Printer.print_with_delay("（跟著他走到他家）");
        Printer.print_with_delay("湊的母親：啊嘞！小湊湊怎麼今天這麼早就回來？");
        Printer.print_with_delay("湊的母親：欸！你還帶朋友回來喔！媽媽我好感動～嗚嗚嗚 我家小湊湊終於有朋友了！");
        Printer.print_with_delay("湊：講過多少次了別在別人面前這樣叫我！還有他不是我朋友");
        Printer.print_with_delay("我：（小湊湊～噗）那個，阿姨您好！我只是負責送他回來的同學而已啦！");
        Printer.print_with_delay("湊的母親：啊！別在外面說了！進來喝杯茶嗎？");
        Printer.print_with_delay("我：那就麻煩您了！");
        Printer.print_with_delay("湊：我什麼時候同意你進我家了？");
        Printer.print_with_delay("湊的母親：小湊湊不可以這樣喔！人家專程你回來欸");
        Printer.print_with_delay("湊：媽的！我要回房間了！");
        Printer.print_with_delay("我：那我還是不要打擾你們好了");
        Printer.print_with_delay("湊的母親：不好意思啊！他的本性不壞的，唉…都是因為我");
        Printer.print_with_delay("湊的母親：那個...我能拜託你一件事嗎？希望你可以接受");
        Printer.print_with_delay("我：？");
        Printer.print_with_delay("湊的母親：你能跟他做朋友嗎？這孩子從小就沒什麼朋友");
        Printer.print_with_delay("湊的母親：我只希望那一天我不在了能有個人陪著他");
        Printer.print_with_delay("湊的母親：啊！好像有點太沉重了！對不起啊");
        Printer.print_with_delay("我：我答應您～");
        Printer.print_with_delay("湊的母親：欸！真的嗎？謝謝你啊！那他就拜託你了！");
        Printer.print_with_delay("我：前提是他想跟我做朋友啦！不然我會很尷尬的");
        Printer.print_with_delay("湊的母親：他應該是想的喔！這可是他第一次帶同學回家呢！呵呵");
        Printer.print_with_delay("湊的母親：那就麻煩你囉！再見");
        Printer.print_with_delay("我：嗯，阿姨再見");
        Printer.print_with_delay("（原來我是第一個啊！莫名的很開心呢～ 不對！我為什麼會有這種想法出現？我到底怎麼了？）");
    }
    
    public void Day3_1200() {
        Printer.print_with_delay("Day3--12:00");
        Printer.print_with_delay("（下課鐘響）");
        Printer.print_with_delay("同學A：欸欸！今天食堂好像有限量的炒麵麵包欸");
        Printer.print_with_delay("同學B：真假！那還不衝？等一下全沒了......欸不是，等等我啊！");
        Printer.print_with_delay("我：跑的真快，真不愧是限量的產品......");
        Printer.print_with_delay("我：不過我今天有帶便當了，等一下找個安靜的地方吃吧！要去哪好呢？嗯......");
        Printer.print_with_delay("我：決定了！去頂樓吧！畢竟那里不准學生進入！不過我有鑰匙！嘿嘿");
        Printer.print_with_delay("我：上次幫老師鎖門之後，他就忘記要回去了，不過老師應該有很多備份鑰匙所以沒差啦！");
        Printer.print_with_delay("（前往頂樓）");
        Printer.print_with_delay("我：嗯？門沒有鎖？怎麼會？");
        Printer.print_with_delay("我：難道有狙擊手要狙擊校長？哇！那我是不是就可以看到那瞬間，想想就挺刺激");
        Printer.print_with_delay("我：不對！快住腦！別亂想了！直接進去看看吧！");
        Printer.print_with_delay("我：喔？完了！怎麼是他......現在走來得及嗎？");
        Printer.print_with_delay("1：直接離開");
        Printer.print_with_delay("2：進去隨便找個地方坐");
        int choice = scanner.nextInt();
        if (choice == 1) {
            likePoint -= 10;
            Printer.print_with_delay("湊：喂！那邊那個！你人走可以，便當留下");
            Printer.print_with_delay("我：我...我不要！這樣我要吃什麼");
            Printer.print_with_delay("湊：誰管你啊！我可沒有要給你選擇的意思");
            Printer.print_with_delay("我：知...知道了！給你吧！不過你可以分我幾口嗎？這時候去食堂應該沒東西了");
            Printer.print_with_delay("湊：這可不是求人的");
            Printer.print_with_delay("我：湊：這可不是求人的態度，不過算了！我會分的");
        }
        if (choice == 2) {
            likePoint += 10;
            Printer.print_with_delay("湊：喂！你這傢伙！既然來了就去幫我跑個腿！我要吃那個炒麵麵包，你去買給我");
            Printer.print_with_delay("我：欸欸欸～但...但是那個...現...現在應該買不到了");
            Printer.print_with_delay("我：不然我幫你買其他的？嗯？還...還是你要跟我一起吃我帶的便當");
            Printer.print_with_delay("湊：蛤？為什麼我要跟你這種傢伙......");
            Printer.print_with_delay("（咕嚕嚕～）");
            Printer.print_with_delay("湊：隨便啦！一起吃就一起吃");
        }
        Printer.print_with_delay("我：真的可以嗎？嗚嗚嗚～我還有能吃的份欸！你人其實也不壞嘛！");
        Printer.print_with_delay("湊：你他媽要吃就給我閉嘴！吵死了");
        Printer.print_with_delay("我：嘿嘿！知道了！對了對了！這個我很推薦喔！這個小章魚可是我的自信之作");
        Printer.print_with_delay("湊：這不就只是把小熱狗切一切而已嗎？這就自信了？");
        Printer.print_with_delay("我：不要這樣啦！我的料理造詣就到這裡而已嘛！啊！對了！還有這個...");
        Printer.print_with_delay("湊：閉嘴！");
        Printer.print_with_delay("我：（做拉起嘴巴拉鍊的姿勢，手比OK）");
        Printer.print_with_delay("---之後過著安靜但開心的吃飯時間，雖然沒吃飽");
        Printer.print_with_delay("---當我再次想到為什麼他會開頂樓的門的時候，已經是放學時間了");
    }
    
    public void Day4_1100() {
        Printer.print_with_delay("");
        Printer.print_with_delay("Day4--11:00");
        Printer.print_with_delay("(辦公室內)");
        Printer.print_with_delay("老師：那個，你來的正好，你去教室幫我把他叫過來！");
        Printer.print_with_delay("我：誰？");
        Printer.print_with_delay("老師：還有誰？當然是那個染金髮的辦公室常客啊！");
        Printer.print_with_delay("我：他這次怎麼了嗎？");
        Printer.print_with_delay("老師：哎呀，反正你把他叫過來就對了！別管這麼多！");
        Printer.print_with_delay("我：喔！知道了");
        Printer.print_with_delay("（走到教室）");
        Printer.print_with_delay("我：湊，那個...老師要你過去一下，他說有事找你");
        Printer.print_with_delay("湊：麻煩死了");
        Printer.print_with_delay("（他離開了教室）");
        Printer.print_with_delay("同學A：欸！你聽說了嗎？我們班花的直笛好像在昨天被人偷走了");
        Printer.print_with_delay("同學B：好噁！誰啊？怎麼偷那種東西？是為了上面的口水嗎～");
        Printer.print_with_delay("同學A：什麼啊～不要說了啦！真的很噁欸～");
        Printer.print_with_delay("同學B：所以他被叫去是因為他就是那個噁男嗎？");
        Printer.print_with_delay("同學A：有可能欸！哈哈哈哈哈！");
        Printer.print_with_delay("我：喂！你們兩個說夠了沒，在別人後面嚼耳根子好玩嗎？");
        Printer.print_with_delay("我：（該不會他真的是因為這件事被叫過去的吧！）");
        Printer.print_with_delay("我：（還是趕快跟著過去吧）");
        Printer.print_with_delay("（辦公室門口）");
        Printer.print_with_delay("老師：你就跟我說你昨天中午吃飯的時候在哪裡有這麼困難");
        Printer.print_with_delay("湊：為什麼我一定要說出來才行？");
        Printer.print_with_delay("老師：咳，注意你的口氣，我是你的導師");
        Printer.print_with_delay("老師：昨天中午班上有女生的東西被偷了");
        Printer.print_with_delay("湊：所以呢？關我什麼事？");
        Printer.print_with_delay("老師：我也很想相信不關你的事，但你也要給我相信你的機會啊");
        Printer.print_with_delay("湊：切，你如果相信我就不會把我叫來這里了，就像班上其他人那樣");
        Printer.print_with_delay("湊：你不就是第一個懷疑我的人嗎？還說相信？我呸");
        Printer.print_with_delay("我：（昨天中午？我們不是跑去頂樓吃飯了嗎？該不會他是為了不拖我下水才不說的？畢竟頂樓學生可不能上去）");
        Printer.print_with_delay("我：（怎麼辦？要衝出去跟老師講我們昨天在一起還是繼續在這裡聽？）");
        Printer.print_with_delay("1:衝出去啦！拼了！被罵就被罵！");
        Printer.print_with_delay("2:還是待著吧！他應該自己能解決好");

        int choice = scanner.nextInt();
        if (choice == 1) {
            likePoint += 20;
            Printer.print_with_delay("我：報告！老師！我有事情要說！");
            Printer.print_with_delay("老師：你來這裡做什麼？我只讓你去叫他吧！");
            Printer.print_with_delay("我：是的，但我不想讓我朋友一個人被懷疑");
            Printer.print_with_delay("湊：（臉紅）誰是你朋友！我可沒你這種吵死人的朋友");
            Printer.print_with_delay("我：知道知道，是我自己認為的");
        }
        if (choice == 2) {
            likePoint -= 20;
            Printer.print_with_delay("湊：媽的！你到底想怎樣！");
            Printer.print_with_delay("湊：有真兇不去抓，在這邊隨便懷疑人，你是哪一隻眼睛覺得我會對那種女人感興趣的。");
            Printer.print_with_delay("湊：看上她的人多的是吧！然後你偏偏來找我？哼，相信？");
            Printer.print_with_delay("我：（我還是講出來吧！這樣下去絕對沒有進展）");
        }
        Printer.print_with_delay("我：老師，我知道他昨天中午在哪？因為我跟他在一起");
        Printer.print_with_delay("老師：哦？是在哪？你不會只是為了讓他不被懷疑才跳出來隨便說說的吧！");
        Printer.print_with_delay("我：老師，你這個樣子還認為你是真的相信他不是犯人的嗎？");
        Printer.print_with_delay("老師：（愣住）咳！抱歉……是我狹隘了");
        Printer.print_with_delay("我：我們在頂樓吃飯！");
        Printer.print_with_delay("湊：喂！你！");
        Printer.print_with_delay("我：是我邀他上去的");
        Printer.print_with_delay("我：最近大家因為學園祭太過亢奮了，我只是想找個安靜的地方吃飯，在路上遇到他就半強迫拉他上去了");
        Printer.print_with_delay("我：是我的問題，要懲罰請懲罰我吧");
        Printer.print_with_delay("老師：……");
        Printer.print_with_delay("老師：算了！這次是我不好，如果我沒懷疑他的話你們上去這件事是不會被發現的吧！");
        Printer.print_with_delay("老師：念在你是初犯，這次就不懲罰你們，不過別再上去了");
        Printer.print_with_delay("我：知道了！那我們可以走了嗎？");
        Printer.print_with_delay("老師：（擺手）行吧！");
        Printer.print_with_delay("我：（推著他離開辦公室）走囉走囉～");
        Printer.print_with_delay("湊：你他媽別碰我！");
        Printer.print_with_delay("我：抱歉抱歉！下次還碰！");
        Printer.print_with_delay("湊：你！！！");
        Printer.print_with_delay("老師：唉！年輕真好啊～");
    }
    
    public void Day5_0810() {
        Printer.print_with_delay("");
        Printer.print_with_delay("Day5--08:10");
        Printer.print_with_delay("(保健室內)");
        Printer.print_with_delay("呵呵…真沒想到這麼蠢的事會發生在我身上");
        Printer.print_with_delay("我：平地摔是怎樣啦！而且是在校門口");
        Printer.print_with_delay("我：不過到這裡還可以，重點是！我還是臉朝下");
        Printer.print_with_delay("我：啊啊啊啊啊啊啊！我已經可以去死了吧！這個社會已經容不下我了，各位再見了");
        Printer.print_with_delay("???：要去死就趕快去死！不要在這裡大吼大叫，吵死了！");
        Printer.print_with_delay("我：（完了！原來有人嗎？）真的很對不起！");
        Printer.print_with_delay("（隔著床的窗簾被拉開）");
        Printer.print_with_delay("湊：怎麼又是你？真是晦氣");
        Printer.print_with_delay("我：什麼？怎麼這樣說我！");
        Printer.print_with_delay("我：你以為我想來這裡嗎？看到了嗎！這些血！");
        Printer.print_with_delay("湊：看到了，然後呢？這不影響你很晦氣的事實");
        Printer.print_with_delay("我：你...！算了！我只是來找保健室老師的！他在嗎？");
        Printer.print_with_delay("湊：不在");
        Printer.print_with_delay("我：那好吧！我只能自己包紮了！");
        Printer.print_with_delay("湊：那你小聲點，你真的很吵");
        Printer.print_with_delay("我：知道知道，你就繼續睡你的吧～");
        Printer.print_with_delay("（他把窗簾闔上）");
        Printer.print_with_delay("1:自己嘗試包紮");
        Printer.print_with_delay("2:拜託他幫你包紮");
        int choice = scanner.nextInt();
        if (choice == 1) {
            likePoint += 20;
            Printer.print_with_delay("我：（窸窸窣窣 窸窸窣窣）");
            Printer.print_with_delay("湊：（再次拉開窗簾）唉～吵死了，叫你小聲聽不懂嗎？");
            Printer.print_with_delay("我：我...我有什麼辦法嘛！我就包不到我的手肘啊");
            Printer.print_with_delay("湊：算了，我來幫你");
            Printer.print_with_delay("我：可以嗎？");
        }

        if (choice == 2) {
            likePoint -= 20;
            Printer.print_with_delay("我：那個...");
            Printer.print_with_delay("湊：幹嘛");
            Printer.print_with_delay("我：你能幫我包紮一下嗎？我沒辦法包到我的手肘");
            Printer.print_with_delay("我：啊！當然，不行的話就算了");
            Printer.print_with_delay("湊：喔，那不行");
            Printer.print_with_delay("我：（欸？這麼快就拒絕我，也是，他沒必要幫我包，可是我自己也包不到）");
            Printer.print_with_delay("我：那個...算我求你了，就幫我這一次吧！我馬上就消失");
        }
        Printer.print_with_delay("湊：你這人怎麼這麼麻煩");
        Printer.print_with_delay("---他熟練的把繃帶拿起，細細的纏繞在你受傷的地方，他的動作十分的溫和，完全沒有讓你感到一絲疼痛");
        Printer.print_with_delay("湊：（輕輕的拍在你受傷的地方）好了，麻煩精");
        Printer.print_with_delay("我：噢！好痛！為什麼要多這一下啦！");
        Printer.print_with_delay("湊：還嫌？再嫌我把它拆了");
        Printer.print_with_delay("我：啊不不不，感謝大人您幫小的我包紮了！");
        Printer.print_with_delay("我：欸？好可愛！有一個蝴蝶結欸！！！好喜歡！謝謝你！");
        Printer.print_with_delay("我：謝謝你這麼細心的幫我包紮，你對我真好");
        Printer.print_with_delay("湊：別自以為是了！我可不是怕你痛才包這麼輕的");
        Printer.print_with_delay("我：是是是，不是怕我會痛，是因為你本來就很溫柔嘛！");
        Printer.print_with_delay("湊：（臉紅）你他媽說誰溫柔");
        Printer.print_with_delay("我：好好好，我不說了！ 其實啊！我本來都已經做好會痛死的準備了，嘿嘿～");
        Printer.print_with_delay("湊：還是你比較想要那種？我可以幫你重包");
        Printer.print_with_delay("我：不用了！我覺得這樣挺好");
        Printer.print_with_delay("我：最後真的很感謝你啊！我先走了喔！小湊湊～");
        Printer.print_with_delay("湊：（整張臉漲紅）喂！誰叫你用那個名字叫我的？ 喂！");
    }
    
    public void Day6_1500() {
        Printer.print_with_delay("");
        Printer.print_with_delay("Day6--15:00");
        Printer.print_with_delay("我：大家都留下來準備明天要用的東西，不過我沒有必須負責的任務，所以不用留下來");
        Printer.print_with_delay("我：嘿嘿！真爽");
        Printer.print_with_delay("我：不過期限就快要到了，我可能真的完蛋了，呵呵");
        Printer.print_with_delay("我：遺書要寫些什麼好呢？嗯...要不順便寫封情書？");
        Printer.print_with_delay("我：啊啊啊啊啊，但我到底是要告訴他我的心意還是單戀到死啊？");
        Printer.print_with_delay("我：可是如果他討厭我怎麼辦（內心已經開始100種胡思亂想）");
        Printer.print_with_delay("我：啊啊啊啊啊啊啊啊啊！！！！！");
        Printer.print_with_delay("（聽見爭執的聲音）");
        Printer.print_with_delay("我：嗯？這聲音...有點耳熟");
        Printer.print_with_delay("???：我他媽叫你放開我");
        Printer.print_with_delay("?????：你叫我放就放，那我把你抓起來幹嘛？");
        Printer.print_with_delay("（循著聲音走過去）");
        Printer.print_with_delay("我： ？！那不是湊嗎？");
        Printer.print_with_delay("我：喂！你們在做什麼？快放開他");
        Printer.print_with_delay("?????：哇！竟然有勇者來救你欸！小公主");
        Printer.print_with_delay("湊：你他媽給我閉嘴，去你的小公主");
        Printer.print_with_delay("（那群人的頭頭一臉壞笑的向我走了過來）");
        Printer.print_with_delay("?????：哎呀！我都忘記自我介紹了呢～");
        Printer.print_with_delay("?????：初次見面～不，應該不是初次見面，哎呀！上次有點狼狽呢～");
        Printer.print_with_delay("?????：不過你可以叫我爸爸～");
        Printer.print_with_delay("?????：我是他的朋友，名字的話？嗯...你好像不需要知道呢！");
        Printer.print_with_delay("我：（扯著他的衣領）你別得寸進尺");
        Printer.print_with_delay("?????：哎呀哎呀～一點玩笑都不能開呢～勇者醬");
        Printer.print_with_delay("我：我不管你們有什麼恩怨情仇要解決，不過這裡還是我們學校，你就不怕我去找老師來嗎？");
        Printer.print_with_delay("?????：你要去搬救兵？哈哈哈哈哈～ 你覺得我會給你這個機會嗎？");
        Printer.print_with_delay("我：不用你給（拿起手機輸入電話號碼）");
        Printer.print_with_delay("?????：好啦好啦～不逗你了～");
        Printer.print_with_delay("?????：不過我來告訴你一個有趣的故事吧！勇者醬～關於湊他小時候的故事喔！很有興趣吧？");
        Printer.print_with_delay("1:抱歉我沒興趣");
        Printer.print_with_delay("2:喔～怎麼個有趣法？");
        int choice = scanner.nextInt();
        if (choice == 1) {
            likePoint = 0;
            game.gameStat = false;
            Printer.print_with_delay("?????：誒？我以為你很中意他呢？原來沒有啊？");
            Printer.print_with_delay("?????：你看他好像很失望呢？");
            Printer.print_with_delay("我：少囉唆，還不快放開他");
            Printer.print_with_delay("?????：好好好，喂～把他放開");
            Printer.print_with_delay("?????：真是無趣，走囉～小弟們 我們回去");
            Printer.print_with_delay("（走到他的身邊）");
            Printer.print_with_delay("我：（伸手想扶他）那個......你沒事吧？");
            Printer.print_with_delay("湊：（把我的手拍掉）沒事 ");
            Printer.print_with_delay("湊：你別碰我");
            Printer.print_with_delay("湊：好了 你可以走了");
            Printer.print_with_delay("我：（我只是希望他可以盡快被放開而已，難道我選錯了嗎？）");
            Printer.print_with_delay("我：還不行，那個...你明天有時間嗎？我想要你陪我一起逛學園祭，就當我救了你的獎勵吧？");
            Printer.print_with_delay("湊：跟我要獎勵？我應該沒有請你來救我吧？還有逛學園祭？跟你？");
            Printer.print_with_delay("湊：抱歉我沒興趣");
        }

        if (choice == 2) {
            likePoint += 20;
            Printer.print_with_delay("?????：哎呀！你果然很有興趣呢~");
            Printer.print_with_delay("?????：那我開始囉～咳咳");
            Printer.print_with_delay("湊：喂！你他媽給我閉嘴，不准講！喂");
            Printer.print_with_delay("?????：不用在意他 我們繼續，從前從前，有個小朋友被整個班級霸凌呢！為什麼呢？");
            Printer.print_with_delay("?????：因為他媽媽是妓女喔～他可是連他爸爸是誰都不知道呢？");
            Printer.print_with_delay("?????：真是骯髒對吧？雜種就是指這種人吧～哈哈哈哈哈哈哈！");
            Printer.print_with_delay("我：所以呢？就這樣？");
            Printer.print_with_delay("?????：什麼就這樣？你也這麼認為吧！他是個小雜種～");
            Printer.print_with_delay("我：真是沒眼看，就因為這種原因欺負他？");
            Printer.print_with_delay("?????：喂喂喂～你該不會在同情他吧？不會吧？");
            Printer.print_with_delay("我：同情？不，他應該不希望有人同情他吧？");
            Printer.print_with_delay("我：我只是替他感到不值，怎麼會遇到你們這種人");
            Printer.print_with_delay("?????：你他媽！ 唉～算了 真是無趣");
            Printer.print_with_delay("?????：走吧！小弟們");
            Printer.print_with_delay("（走到他的身邊）");
            Printer.print_with_delay("我：（伸手想扶他）那個......你沒事吧？");
            Printer.print_with_delay("湊：嗯......");
            Printer.print_with_delay("我：怎麼了？不會受傷了吧？在哪？有需要去保健室嗎？我應該早一點到的啊啊啊啊啊！");
            Printer.print_with_delay("湊：我沒事");
            Printer.print_with_delay("我：那就好 嘻嘻～");
            Printer.print_with_delay("我：欸欸，我救了你，你有要給我什麼獎勵嗎？");
            Printer.print_with_delay("湊：我可沒有讓你來救");
            Printer.print_with_delay("我：我不管，反正你要給我獎勵");
            Printer.print_with_delay("湊：麻煩死了，要多少？");
            Printer.print_with_delay("我：什麼？");
            Printer.print_with_delay("湊：我問你要多少？");
            Printer.print_with_delay("我：？？？我看起來像在勒索你嗎？");
            Printer.print_with_delay("湊：不像嗎？不然你要什麼？");
            Printer.print_with_delay("我：嗯…...給我你的時間吧！");
            Printer.print_with_delay("湊：？？？");
            Printer.print_with_delay("我：把你明天的時間借給我好不好，我想跟你一起逛學園祭～");
            Printer.print_with_delay("湊：你不覺得我噁心？");
            Printer.print_with_delay("我：是因為他剛剛講的故事嗎？ 我完全不覺得喔！");
            Printer.print_with_delay("我：我聽完甚至很後悔沒有早一點遇到你呢～這樣你就有我陪了！！不錯吧～（驕傲）");
            Printer.print_with_delay("湊：（耳根泛紅）嗯......");
            Printer.print_with_delay("湊：我可不想這麼早遇見你？你很煩人");
            Printer.print_with_delay("我：欸欸欸欸欸，原來你是這樣看我的嗎？（哭）");
            Printer.print_with_delay("湊：咳咳......我沒有真的那麼想");
            Printer.print_with_delay("我：我不管，我傷心了，哄不好的那種");
            Printer.print_with_delay("湊：我答應你就是了！不...不要傷心了");
            Printer.print_with_delay("我：真的嗎！！！好耶！ 那我們明天早上校門口見！！！我先走囉～");
            Printer.print_with_delay("湊：喂！");
            Printer.print_with_delay("我：？");
            Printer.print_with_delay("湊：今天......（超小聲）謝謝你");
            Printer.print_with_delay("我：你說什麼？");
            Printer.print_with_delay("湊：沒事，明天不要給我遲到 我不喜歡等人");
            Printer.print_with_delay("我：遵命！！！");
            Printer.print_with_delay("（帶著愉悅的步伐期待明天的到來～）");
        }
    }
    
    public void Day7() {
        Printer.print_with_delay("---為了遵守與他的約定，我提早了整整半個小時出門");
        Printer.print_with_delay("我：頭髮應該沒亂吧！這身香水味會不會很奇怪，畢竟我平時沒在噴的");
        Printer.print_with_delay("我：距離約定的時間還有十分鐘，好期待～嘿嘿");
        Printer.print_with_delay("（十分鐘後）");
        Printer.print_with_delay("我：啊啊啊啊啊，但我到底是要告訴他我的心意還是單戀到死啊？");
        Printer.print_with_delay("我：不，不可能！他不是那種人。還是他出事了？怎麼辦？要去找他嗎？");
        Printer.print_with_delay("1:決定了！去找他吧！");
        Printer.print_with_delay("2:待在原地等待");
        int choice = scanner.nextInt();
        if(choice == 1) {
            likePoint += 20;
            Printer.print_with_delay("我：但要去哪找他呢？先去教室看看好了");
            Printer.print_with_delay("（到教室後）");
            Printer.print_with_delay("我：不對！他也沒在這");
            Printer.print_with_delay("同學C：那個...你是要找小野同學吧？");
            Printer.print_with_delay("我：（臉紅）很...很明顯嗎？");
            Printer.print_with_delay("同學C：你最近都跟他混在一起，很難不知道吧！");
            Printer.print_with_delay("同學C：好啦！我今天因為要先來準備東西就很早到學校，但在那時候我就已經看到他站在校門口好像在等人？然後就有一群人來找他，他現在應該跟他們在一起？看起來都很兇，果然是朋友吧？");
            Printer.print_with_delay("我：一群人？完了！！！");
            Printer.print_with_delay("我：謝謝你的情報，我先走了");
            Printer.print_with_delay("我：（不出意外的話是真的出意外了！去昨天遇到他們的地方看看吧！）");
            Printer.print_with_delay("（教學樓後面）");
            Printer.print_with_delay("我：真的是他們！怎麼這麼陰魂不散啊！");
            Printer.print_with_delay("我：（大聲）喂！你們昨天還沒鬧夠嗎！幹嘛一直找他麻煩？");
            Printer.print_with_delay("?????：喔～嗨！又是你啊？要一起參與這場盛宴嗎？");
            Printer.print_with_delay("我：湊！你沒事吧？");
            Printer.print_with_delay("湊：滾！我自己可以解決");
            Printer.print_with_delay("我：（謊言）不是啊！我剛剛先去跟老師講你有危險了！班導等一下就來了！可不能讓他看到你打架啊！");
            Printer.print_with_delay("?????：你又打小報告？看來你真的不怕我們呢～");
            Printer.print_with_delay("我：要打架來啊？小看我是不是");
            Printer.print_with_delay("?????：哼，那我就恭敬不如從命了 兄弟們！先解決這邊只會大聲的小雜魚");
            Printer.print_with_delay("我：來啊！！！");
            Printer.print_with_delay("老師：你們在幹什麼？打架嗎？");
            Printer.print_with_delay("我：（欸不是！他怎麼真的來了！我沒去告狀啊？）");
            Printer.print_with_delay("我：哈哈哈...沒有啦！我們在玩一種很新的遊戲，叫做『小雞抓老鷹』，沒在打架啦！");
            Printer.print_with_delay("老師：（最好是，你們這種小孩我看多了）算了！別玩了，散了吧！");
            Printer.print_with_delay("我：知道了！各位 今天就玩到這裡怎麼樣？（瘋狂暗示）");
            Printer.print_with_delay("?????：唉～看來我們只能再約下次了呢！湊");
            Printer.print_with_delay("湊：我跟你這種弱雞沒什麼好約的");
            Printer.print_with_delay("?????：你也只有現在可以得瑟了 唉～可憐了我的拳頭啊！兩天都沒有揍到人");
            Printer.print_with_delay("湊：？你上次也沒揍到我啊？還是你忘了你上次多狼狽了？");
            Printer.print_with_delay("?????：我們走著瞧！");
            Printer.print_with_delay("（等那群人走後）");
            Printer.print_with_delay("老師：你們倆也走吧！別再惹事了！");
            Printer.print_with_delay("我：（小聲）明明不是我們在惹事的");
            Printer.print_with_delay("老師：嗯？");
            Printer.print_with_delay("我：沒沒沒！知道了 我們走吧！湊 ");
            Printer.print_with_delay("我：學園祭已經開始了！我們去逛逛吧？");
            Printer.print_with_delay("湊：你真的跑去跟老師打小報告啊？");
            Printer.print_with_delay("我：我才沒那個時間嘞！我第一時間就衝來了！誰知道他為什麼會出現？最懵的應該是我了吧！");
            Printer.print_with_delay("湊：（臉紅）第一時間...");
            Printer.print_with_delay("我：（一臉壞笑）對了！嘿嘿～你是不是很期待今天啊？我聽同學說你今天很早就到門口等我了！");
            Printer.print_with_delay("湊：我...我才沒，我只是因為起早了...對！我起早了睡不著才來的，才不是因為期待跟你一起逛街什麼的才睡不著...");
            Printer.print_with_delay("湊：（臉部漲紅）不對！你剛剛什麼都沒聽到！快走了！！！");
            Printer.print_with_delay("我：（天啊！真的好可愛）");
        }
        if(choice == 2) {
            Printer.print_with_delay("我：他應該沒事啦！可能睡過頭了吧！我再等一下好了");
            Printer.print_with_delay("（過了二十分鐘）");
            Printer.print_with_delay("我：不對勁，我去找找他好了");
            Printer.print_with_delay("（到了教學樓後方）");
            Printer.print_with_delay("我：湊！你怎麼在這裡！欸？你受傷了嗎？怎麼臉上有血？在哪裡我幫你看看");
            Printer.print_with_delay("湊：不用看，這血是他們的 我沒受傷");
            Printer.print_with_delay("我：他們？這不是昨天那群人嘛？他們又來找你麻煩？也太不死心了吧！我是不是該稱讚他們很有毅力啊？");
            Printer.print_with_delay("湊：走吧！去逛");
            Printer.print_with_delay("我：喔～走吧");
        }
        Printer.print_with_delay("---我拉著他的手在學生們穿梭，一邊享受著一年一度的慶典");
        Printer.print_with_delay("我：逛得差不多了，好累");
        Printer.print_with_delay("我：對了！我剛剛一直很想問你手上那個包袱是什麼啊");
        Printer.print_with_delay("湊：中餐，補償你的");
        Printer.print_with_delay("我：你自己做的嗎！我要吃！");
        Printer.print_with_delay("我：趁這個機會要不要再去頂樓一次");
        Printer.print_with_delay("湊：你不怕被老師罵？");
        Printer.print_with_delay("我：不會啦！老師今天要巡邏，應該很忙沒空管我們");
        Printer.print_with_delay("湊：現在到底誰才是壞學生啊？");
        Printer.print_with_delay("我：嘿嘿！我們～");
        Printer.print_with_delay("（頂樓）");
        Printer.print_with_delay("（十分鐘後）");
        Printer.print_with_delay("我：果然還是這裡適合我，快打開吧！我超期待的");
        Printer.print_with_delay("（他打開便當）");
        Printer.print_with_delay("我：這...這也太豐盛了吧！我真的可以吃這種聖品嗎");
        Printer.print_with_delay("湊：你不想吃我自己吃");
        Printer.print_with_delay("我：不不不，我要吃！我絕對要吃！");
        Printer.print_with_delay("（將他做的玉子燒放進嘴裡）");
        Printer.print_with_delay("我：這也太好吃了吧！");
        Printer.print_with_delay("我：（難怪他敢嘲諷我！他確實有那個資格））");
        Printer.print_with_delay("我：真的好喜歡...");
        Printer.print_with_delay("湊：你在說什麼？");
        Printer.print_with_delay("我：（完蛋！一不小心說出口了）我的意思是我喜歡...你的便當！");
        Printer.print_with_delay("湊：看得出來");
        Printer.print_with_delay("我：（怎麼辦，好想跟他告白）");
        if(likePoint < 100) {
            Printer.print_with_delay("我：那個...湊！我有一些話想跟你說");
            Printer.print_with_delay("湊：噢，你說啊");
            Printer.print_with_delay("我：這個...那個...我喜歡你，你可以跟我在一起嗎？");
            Printer.print_with_delay("湊：（驚訝）你對我是那種感情？");
            Printer.print_with_delay("湊：我頂多只把你當朋友，還沒想過那方面的");
            Printer.print_with_delay("我：是...這樣嗎");
            Printer.print_with_delay("??：打擾你們真的非常抱歉呢？");
            Printer.print_with_delay("我：你...為什麼你會在這裡？");
            Printer.print_with_delay("??：欸～你是真不知道還假不知道啊？我來拿回你承諾過我的東西～你的靈魂～");
            Printer.print_with_delay("??：你不是答應過我，如果沒有在一個禮拜內找到自己心屬的另一半，你就會變成我的玩具嗎？");
            Printer.print_with_delay("湊：搞了半天原來是怕死嗎？我還想說最近你怎麼會靠近我這種人？原來只是因為我看起來最好騙吧？");
            Printer.print_with_delay("我：不是！你誤會了！我是真的喜歡你啊！湊！");
            Printer.print_with_delay("湊：別叫我的名字，我剛剛說錯了！你根本連朋友都不是");
            Printer.print_with_delay("湊：（起身）喂！這傢伙就交給你！我先走了");
            Printer.print_with_delay("我：湊！你別......");
            Printer.print_with_delay("(噗滋)");
            Printer.print_with_delay("我：欸～這是什麼？為什麼有血？這些是我的血嗎？");
            Printer.print_with_delay("我：難道我真的是因為怕死才跟他告白的嗎？不過現在想這些也沒用了");
            Printer.print_with_delay("我：（好...好冷）我真的要死了啊？哈哈");
            Printer.print_with_delay("??：啊哈哈哈哈哈哈～這下你就是永遠屬於我一個人的了！");
            Printer.print_with_delay("??：多美啊！這身紅色，這是喜服吧！連天都希望我們在一起呢～");
            Printer.print_with_delay("??：我會慢慢的把你吃了！這樣你就可以永遠的跟我融合一體啦～是不是很開心！");
            Printer.print_with_delay("??：現在，你是時候該閉上眼睛了！晚安");
        }
        else {
            Printer.print_with_delay("我：湊！");
            Printer.print_with_delay("湊：幹嘛突然叫這麼大聲，你終於瘋了是嗎？");
            Printer.print_with_delay("我：那個...我剛剛說的喜歡不只是你的便當！我更喜歡你！所以你...可以跟我交往嗎？");
            Printer.print_with_delay("湊：（驚訝）你對我是那種感情？");
            Printer.print_with_delay("湊：（臉超紅）你...你知道你現在在說什麼東西嗎？我才不喜歡你");
            Printer.print_with_delay("我：（失望）啊！對不起... ");
            Printer.print_with_delay("我：（欸，眼淚怎麼流出來了？ 不行！不能哭！至少在他面前不能哭）");
            Printer.print_with_delay("我：我知道了！真的對不起啊！那我先走了");
            Printer.print_with_delay("湊：等一下");
            Printer.print_with_delay("我：嗯？怎麼了嗎？");
            Printer.print_with_delay("湊：抱歉，我剛剛一時嘴快，你...能再問一次嗎？");
            Printer.print_with_delay("我：你是想看我被拒絕第二次嗎？我真的會哭的");
            Printer.print_with_delay("湊：你再問一次就對了");
            Printer.print_with_delay("我：好吧！湊，你能跟我在一起嗎？我真的很喜歡你");
            Printer.print_with_delay("湊：（頭歪向一邊，耳根卻很明顯的紅透了）嗯......");
            Printer.print_with_delay("我：你...答應了？！ 真的嗎？我不是在做夢吧！！！如果是夢請不要讓我醒來！");
            Printer.print_with_delay("湊：哈哈～你太誇張了吧！");
            Printer.print_with_delay("我：你笑了！這是你第一次對著我笑");
            Printer.print_with_delay("我：小湊湊你笑起來真好看");
            Printer.print_with_delay("湊：你他媽欠揍是不是！！");
            Printer.print_with_delay("我：如果是被你揍的話可以～");
            Printer.print_with_delay("湊：那現在就先來幾拳好了！喂！不是說我要給我揍，你跑什麼！給我回來！");
            Printer.print_with_delay("我：哈哈哈！果然我真的很喜歡你呢湊！");
        }
    }
    
}

class Character5 extends SubCharacter {
    public Character5(Game game, MainCharacter mainCharacter) {
        super(game, mainCharacter);
        this.game = game;
        this.mainCharacter = mainCharacter;
        this.type = "同學他姊";
        this.name = "漢橙一郎";
        this.likePoint = random.nextInt(21) + 60;
        this.gender = "女";
    }

    public void DAY1_atSchool() {
        Printer.print_with_delay("Day1--09:00");
        Printer.print_with_delay("（與很要好的同學上同一堂課）");
        Printer.print_with_delay("我：你怎麼一直滑手機，是在看什麼？");
        Printer.print_with_delay("好同學：喔沒有啦，最近我姐在fb開了自己的粉絲團，我在幫他的貼文留言刷流量");
        Printer.print_with_delay("主角：啊？你姊叫什麼名字啊？");
        Printer.print_with_delay("好同學：" + this.name);
        Printer.print_with_delay("（拿了他姊的相片給我看）");
        Printer.print_with_delay("我：（感謝阿爸父，終於看到一個比較好攻略的目標了）");
    }

    public void Day1_afterSchool() {
        Printer.print_with_delay("Day1--17:00");
        Printer.print_with_delay("同學他姊放學後回家吃飯之時，家裡突然發生大火，於此同時，正好你有同學約你放學去吃飯，你要選擇去關心姊姊還是跟同學吃飯？");
        Printer.print_with_delay("1：關心他");
        Printer.print_with_delay("2：跟同學吃飯");
        int choice = scanner.nextInt();
        if (choice == 1) {
            this.likePoint -= 7;
            Printer.print_with_delay("你去關心他，但可惜你的開頭對話是“嘿，what's up”。這下子完蛋，他覺得你落井下石，好感度減少。");
        };
        if(choice == 2) {
            this.likePoint += 7;
            Printer.print_with_delay("因為你深知他姊是班上的邊緣人，因此就算發生火災，她也邊緣到火都忘了燒她，所以他不會有事的。而因為她很感動你了解他很邊緣，所以好感度增加。");
        };
    }

    public void Day2_gym() {
        Printer.print_with_delay("Day2--18:00");
        Printer.print_with_delay("你跟同學姐姐在健身房相遇，但是一個重100公斤的啞鈴正要壓向她，你要怎麼做？");
        Printer.print_with_delay("1：幫她扛起啞鈴");
        Printer.print_with_delay("2：不幫他拿啞鈴");
        int choice = scanner.nextInt();
        if (choice == 1) {
            this.likePoint -= 7;
            Printer.print_with_delay("你幫她扛起啞鈴，但你實在是太細了，反而幫倒忙，連自身重量一起壓在她身上，好感度減少");
        };
        if(choice == 2) {
            Printer.print_with_delay("你不幫他拿啞鈴，她靠自己強大的力量擋下啞鈴，她對自己的好感度增加。");
        };
    }

    public void Day3_store() {
        Printer.print_with_delay("Day3--17:00");
        Printer.print_with_delay("你和" + this.name + "剛好要一起去超商買晚餐，但是你跟她都有健身，必須吃黑胡椒雞胸肉，但超商剛好剩最後一包雞胸肉，你會讓給他嗎？");
        Printer.print_with_delay("1：讓給他");
        Printer.print_with_delay("2：不讓給他");
        int choice = scanner.nextInt();
        if (choice == 1) {
            this.likePoint -= 7;
            Printer.print_with_delay("但她吃完後肌肉變多，她開始看不起你這個細狗，好感度減少。");
        };
        if(choice == 2) {
            this.likePoint += 7;
            Printer.print_with_delay("你吃完後變壯很多，同學姊姊很欣賞你的體態，買給你五杯大冰拿以示鼓勵，好感度增加。");
        };
    }

    public void Day4_library() {
        Printer.print_with_delay("Day4--15:00");
        Printer.print_with_delay("妳一個人躺在二樓漫畫區的沙發上穿著吊嘎，全身汗臭，翹著二郎腿赤著腳睡覺。你拍照到dcard公審他，事後發現居然就是" + this.name + "，你該怎麼辦？");
        Printer.print_with_delay("1：跟她道歉");
        Printer.print_with_delay("2：不跟她道歉");
        int choice = scanner.nextInt();
        if (choice == 1) {
            this.likePoint -= 7;
            Printer.print_with_delay("她覺得你是一個懂的知錯能改的人，好感度增加。");
        };
        if(choice == 2) {
            this.likePoint += 7;
            Printer.print_with_delay("你假裝自己不知道，她覺得你很垃圾，好感度減少。");
        };
    }

    public void Day5_busStop() {
        Printer.print_with_delay("Day5--07:00");
        Printer.print_with_delay("偶然發現她跟我在同一個公車站下車，準備去上學，但公車站距離學校有很長一段距離，這天剛好下大雨，可是她沒帶雨傘，你會怎麼做？");
        Printer.print_with_delay("1：幫她撐雨傘");
        Printer.print_with_delay("2：不幫她撐傘");
        int choice = scanner.nextInt();
        if (choice == 1) {
            this.likePoint -= 7;
            Printer.print_with_delay("幫她撐雨傘，殊不知你撐的那把雨傘是之前偷她的，你拿她的雨傘幫她撐傘，被她發現很生氣，好感度減低。");
        };
        if(choice == 2) {
            this.likePoint += 7;
            Printer.print_with_delay("不幫她撐傘，你偷她傘的事情沒被發現，好感度不變。");
        };
    }

    public void Day6_stair() {
        Printer.print_with_delay("Day6--15:30");
        Printer.print_with_delay("上課鐘響了，但是" + this.name + "在教室旁的樓梯口摔倒了，腿上流出大量紅色液體，你覺得那是血而幫他扶起來，還是覺得是番茄醬，他只不過想引人注意罷了？");
        Printer.print_with_delay("1：是血");
        Printer.print_with_delay("2：是番茄醬");
        int choice = scanner.nextInt();
        if (choice == 1) {
            this.likePoint -= 7;
            Printer.print_with_delay("你覺得那是血而幫他扶起來，但他覺得自己還可以走路你還幫他，是看他軟弱，好感度減低。");
        };
        if(choice == 2) {
            this.likePoint += 7;
            Printer.print_with_delay("你覺得是番茄醬，她覺得你很有幽默感，爬起來跟你說很好笑後又躺回去，好感度增加。");
        };
    }

    public void Day7() {
        Printer.print_with_delay("Day7");
        Printer.print_with_delay("你決定要向" + this.name + "告白了，但是發現他卻跟別的男生有說有笑，還抱在一起，你還要告白嗎？");
        if (this.likePoint <= 60) {
            Printer.print_with_delay("1：要，但先等她跟那個男生聊完，再換你跟他告白，做個有禮貌的文明人。");
            Printer.print_with_delay("2：不要，你根本沒表達心意，她怎麼會知道你喜歡她，當然不可能成功。");
            int choice = scanner.nextInt();
            if (choice == 1) {
                Printer.print_with_delay("你向他告白，但告白後他卻說自己配不上你，你笑著含淚接受，頓時彷彿身處高譚市，還沒戴上小丑的面具就被現實狠狠拷打，最後被前女友所殺。");
            }
            if (choice == 2) {
                game.gameStat = false;
            }
        } else {
            Printer.print_with_delay("1：要，但先等她跟那個男生聊完，再換你跟他告白，做個有禮貌的文明人。");
            Printer.print_with_delay("2：不要，你覺得自己反正爛命一條，再找新的就好，不缺她一個。");
            int choice = scanner.nextInt();
            if (choice == 1) {
                Printer.print_with_delay("聊完天後，你試探性的問了那位男生的身分，很幸運的，跟他抱在一起的人，是他哥。你隨後鼓起勇氣告白，成功。");
            }
            if (choice == 2) {
                Printer.print_with_delay("你懷著這股傲氣想瀟灑離開，但眼淚仍止不住的從眼角流下來，你恨自己的無能與軟弱，懷疑自己的自信是不是開了濾鏡，想到戶政事務所把自己身分證名字改成魯蛇。");
                Printer.print_with_delay("然而，就在你轉身那霎那，她叫住了你。你無所期待，轉過頭，顫抖的打了個招呼，想盡最大努力強顏歡笑，證明自己很堅強。");
                Printer.print_with_delay("\"謝謝你，我喜歡你\"她小聲的說。你懷疑自己是不是聽錯，迅速拿出手機劃開，想確認今天是不是愚人節。你的眼神快速的掃過四周，確認沒有人拿iphone14pro max 1TB誘惑她玩真心話大冒險。");
                Printer.print_with_delay("然而，就在你轉身那霎那，她叫住了你。你無所期待，轉過頭，顫抖的打了個招呼，想盡最大努力強顏歡笑，證明自己很堅強。");

                Printer.print_with_delay("總之，你是愣住了，沒接話。而她對於你的反應不是很滿意，不耐煩的說了句：“事不過三聽過嗎？” 你只點了點頭。“我、愛、你”這次，她靠的很近，距離你的耳朵咫尺之隔。她的輕聲細語，在你耳邊卻如此的震耳欲隆。");
                Printer.print_with_delay("你停滯了片刻，腦袋一片空白，你現在需要做點什麼......啊！我的告白詞呢？然而，此時，曾經練習過無數次、總把好兄弟當成告白對象、練習到兄弟都自願說yes I do 的告白詞，在這個緊要關頭卻怎麼也說不出來。");
                Printer.print_with_delay("而就在不知所措的同時，你突然想到，過去在課堂上，每當老師說舉手回答總成績加10分！你總是最積極的舉手，期待老師點到你，然後神色自若的回答像印度首陀羅下面是戰鬥陀螺這種幼稚屁話，而現在，你知道自己緊張到沒辦法主動講話，需要有人為這份告白詞開頭。");
                Printer.print_with_delay("你決定故技重施，放手一搏，就像在過去課堂上，奮力舉直右手過頭，用滿是意會的眼神與對方四目相交，希望對方能點你回答，只是這次舉手，沒有總成績加分、也沒有簽到性質，有的只是一份表達內心悸動的勇氣。");
                Printer.print_with_delay("終於，她的眼神從原本的錯愕不解，逐漸笑成了彎月，好像牛頓的地心引力只存在於她的眼尾。");
                Printer.print_with_delay("“請說”她是這麼說的。");
                Printer.print_with_delay("\n");
                Printer.print_with_delay("當然，你成功了，不會被前女友殺掉。");
            }
        }

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
