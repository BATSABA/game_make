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
        Character1 friend = new Character1(this, me);
        Character2 Classmate = new Character2(this, me); 
        Character3 Senior = new Character3(this, me);
        Character4 Sister = new Character4(this, me);
        Character5 boy1 = new Character5(this, me);
        while (this.gameStat && this.date < 7) {
            switch (this.date) {
                case 1:
                    break;
                case 2:
                    Senior.Day2_1300();
                    break;
                case 3:
                    Senior.Day3_1400();
                    break;
                case 4:
                    Senior.Day4_1200();
                    break;
                case 5:
                    Senior.Day5_1230();
                    break;
                case 6:
                    Senior.Day6_1300();
                    break;
                case 7:
                    // Date 7 events
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

class Character3 extends SubCharacter {
    public Character3(Game game, MainCharacter mainCharacter) {
        super(game, mainCharacter);
        this.game = game;
        this.mainCharacter = mainCharacter;
        this.type = "學長";
        this.name = "default";
        this.likePoint = random.nextInt(21) + 50;
        this.gender = "男";
    }

    public void Day2_1300() {
        System.out.println("Day2--13:00");
        System.out.println("學長：今天我們要做的是手工餅乾，做好之後可以自己留著或是送給喜歡的人吃喔。");
        System.out.println("主角：學長我不太會做，可以請你來協助我嗎？");
        System.out.println("學長：當然可以啦，有什麼問題都可以問我。");
        System.out.println("主角：那我們開始吧。");
        System.out.println("主角：我要不要把餅乾送給學長呢...");
        System.out.println("1：不要好了。");
        System.out.println("2：當然要。");
        int choice = scanner.nextInt();
        if(choice == 1) {
            likePoint -= 5;
            System.out.println("學長：小學弟，你的餅乾是要送人的嗎？");
            System.out.println("主角：應該吧，或是我自己吃掉。學長怎麼了嗎？");
            System.out.println("學長：喔沒事啦，那品嘗後再分享感想給我。");
            System.out.println("主角：好的。");
        }
        else if(choice == 2) {
            likePoint += 5;
            System.out.println("主角：學長，我做的餅乾送給你吃。");
            System.out.println("學長：你要送給我吃嗎？");
            System.out.println("主角：對呀，可是我不知道味道如何就是了。");
            System.out.println("學長：沒事，有我在旁邊協助你，做出來的味道一定不會差。");
            System.out.println("主角：說的也是，有學長的加持，餅乾味道一定很好。");
            System.out.println("學長：我也沒幫什麼忙，有點不好意思呢，那我就收下囉。");
            System.out.println("主角：當然，請一定要收下。");
        }  
    }

    public void Day3_1400() {
        System.out.println("Day3--14:00");
        System.out.println("(在社團活動中，學長注意到主角的圍裙後面破了一個洞，所以在社團課下課後...");
        System.out.println("學長：我看到你圍裙後面破洞了，你有發現嗎？");
        System.out.println("主角：欸？真的嗎？在哪裡？");
        System.out.println("學長：在這裡，剛好是你看不到的地方。");
        System.out.println("主角：那怎麼辦呢。");
        System.out.println("學長：剛好我會縫補，需要我幫你縫嗎？");
        System.out.println("主角:我要不要讓學長幫我縫補圍裙呢...");
        System.out.println("1：拒絕，還是自己補好了");
        System.out.println("2：好呀，讓學長幫忙補");
        int choice = scanner.nextInt();
        if(choice == 1) {
            likePoint -= 5;
            System.out.println("主角：謝謝學長的好意，我還是自己來就行了。");
            System.out.println("學長：你確定嗎？");
            System.out.println("主角：雖然可能沒辦法縫得很完美，但沒關係。");
            System.out.println("學長：那好吧，你拿針跟縫補的時候，一定要小心，不要扎到手了。");
            System.out.println("主角：好的。");
        }
        if(choice == 2) {
            likePoint += 5;
            System.out.println("主角：學長，我不太會補，那就麻煩你了。");
            System.out.println("學長：不會麻煩的，剛好我平時衣服破洞或是其他東西破掉，我都是自己把它縫回去的。");
            System.out.println("主角：哇！學長，你根本就是大暖男吧。除了會做吃的還有縫東西，還有什麼是你不會的。");
            System.out.println("學長：你太誇張了啦，雖然這些是我的強項沒錯，但人不是十全十美的，我也是有不會的。");
            System.out.println("主角：沒關係，我覺得學長已經很棒了，如果以後要找對象好想找跟學長一樣暖的。");
            System.out.println("學長（害羞：縫好了，還給你吧。如果之後又破掉了，再拿來給我縫吧。");
            System.out.println("主角：好的，謝謝學長。");
        }
    }

    public void Day4_1200() {
        System.out.println("Day4--12:00");
        System.out.println("主角:學長，快到午餐時間了，你有要吃什麼嗎？");
        System.out.println("學長:我應該不需要買，因為我會自己帶便當來。");
        System.out.println("主角:好羨慕喔，我等等還要衝去食堂搶食。");
        System.out.println("學長:那不然我陪你去買，然後我們一起去找地方吃，你覺得怎麼樣？");
        System.out.println("主角:學長約我去吃午餐，我要答應嗎...");
        System.out.println("1：拒絕他，我自己回教室吃就好。");
        System.out.println("2：答應他，順便帶他去之前發現的漂亮小花園吃。");
        int choice = scanner.nextInt();
        if (choice == 1) {
            likePoint -= 5;
            System.out.println("主角：不用啦，現在食堂都是人，會很擠也很悶。");
            System.out.println("學長：沒關係阿，我剛好也可以順便看看有沒有我喜歡吃的東西。");
            System.out.println("主角：可是學長你有自己帶便當，再買了就吃不完了。");
            System.out.println("學長：吃不完了我們就一起分吧。");
            System.out.println("主角：我的食量也不大，我還是回教室吃就好。");
            System.out.println("學長：那好吧。");
        } else if (choice == 2) {
            likePoint += 10;
            System.out.println("主角：好呀，可是學長，現在食堂很多人會很擠，你沒問題嗎。");
            System.out.println("學長：沒關係的，剛好我也可以看看有沒有喜歡吃的。");
            System.out.println("主角：那我們買完後，去我前幾天發現的小花園吧。");
            System.out.println("學長：好呀。我們走吧。");
        }
    }

    public void Day5_1230() {
        System.out.println("Day4--12:30");
        System.out.println("(過2天後就是學園祭了，我想要邀請學長陪我一起逛，但是我應該怎麼告訴他呢...)");
        System.out.println("1：自己當面交給學長才有誠意，而且還可以把自己親手做的餅乾一起打包送給學長。");
        System.out.println("2：請他人轉交。");
        int choice = scanner.nextInt();
        if (choice == 1) {
            likePoint += 30;
            System.out.println("（我還是親手交給學長好了）");
            System.out.println("主角：學長，這個卡片跟餅乾給你。");
            System.out.println("學長：嗯？這是什麼卡片阿，還有這個餅乾是你做的嗎？");
            System.out.println("主角：卡片就是... 2天後就是學園祭了，我想邀請你一起逛。不知道你覺得怎麼樣...");
            System.out.println("學長：當然可以啦，我也正好想要問你要不要一起呢。那這包餅乾呢？");
            System.out.println("主角：餅乾是之前社團課教的手工餅乾，我回去後又在自己做了一些，想說送給學長，讓學長感受到我的誠意。");
            System.out.println("學長：你的心意我收到了，謝謝你親手為我做餅乾。");
            System.out.println("主角：不用客氣啦。");
            System.out.println("學長：那我們學園祭就一起逛吧。");
            System.out.println("主角：好的。");
        }
        else if (choice == 2) {
            likePoint = 0;
            game.gameStat = false;
            System.out.println("主角：這個麻煩請你幫我轉交給烹飪社的學長。");
            System.out.println("路人甲：直接拿給他就好嗎，沒問題。");
            System.out.println("(突然間，我眼角餘光瞄到學長的身影漸漸靠近。我感覺到臉頰微微泛起紅暈，卻不知如何解釋。學長好像誤會了甚麼，隨即轉身離去，流露出一絲不悅之情。我急忙追上前去，想為自己的行為解釋清楚...)");
            System.out.println("主角：學長，等一下，等等我。");
            System.out.println("學長：我為什麼要等你，你不是在跟路人甲說話嗎，還送他東西，還臉紅，那你為什麼要來找我。");
            System.out.println("主角：那是有原因的，你聽我解釋。");
            System.out.println("學長：我不想聽你的藉口，不要再來找我了。");
        }
    }

    public void Day6_1300() {
        System.out.println("Day6--13:00");
        System.out.println("(明天就是學園祭了，班上決定要以女僕咖啡廳為主題，我跟學長都覺得可以做蛋糕來賣，於是...");
        System.out.println("主角：學長，明天就是學園祭了，既然班上決定要開女僕咖啡廳，而且我們又是烹飪社的，不如我們來做蛋糕，覺得如何？");
        System.out.println("學長：我覺得這個主意不錯，而且也很適合在女僕咖啡廳上賣。");
        System.out.println("主角：那就這麼愉快的決定了，不過我還不太會做蛋糕，所以學長你要幫我唷。");
        System.out.println("學長：當然沒問題啦。我們開始吧。");
        System.out.println("(做完蛋糕之後...");
        System.out.println("主角：學長，蛋糕做好了，我們來試試味道吧。");
        System.out.println("學長：可以呀。");
        System.out.println("主角：要品嘗蛋糕時，我決定...");
        System.out.println("1:跟學長各切各的蛋糕，各吃各的蛋糕。");
        System.out.println("2:幫學長切好後，餵到他嘴邊給他吃。");
        int choice = scanner.nextInt();
        if (choice == 1) {
            likePoint -= 5;
            System.out.println("主角：那學長你先切好了，我等等再切。");
            System.out.println("學長：我可以順便幫你切的。");
            System.out.println("主角：不用麻煩啦，而且你也不知道我想吃多少，所以我自己來就好了。");
            System.out.println("學長：那好吧，吃完再跟我說說味道如何。");
            System.out.println("(兩人坐下來吃蛋糕，期間很少交流");
        }
        else if (choice == 2) {
            likePoint = 100;
            System.out.println("主角：學長，我來幫你切蛋糕吧。你要多大塊呢？");
            System.out.println("學長：你就照你想要切的大小就可以。");
            System.out.println("主角：那我就隨便切囉。");
            System.out.println("學長：好的。");
            System.out.println("(切好蛋糕後，坐下來面對面吃)");
            System.out.println("主角：學長你覺得我們做的蛋糕怎麼樣，味道如何？");
            System.out.println("學長：味道還不錯，不會太甜也不會沒味道。明天可以拿去女僕咖啡廳賣了。");
            System.out.println("主角：真的嗎，真是太好了，阿學長你嘴角好像沾到了奶油。");
            System.out.println("學長：真的嗎？在哪裡？");
            System.out.println("主角：我幫你");
            System.out.println("(我用手抹掉了學長嘴邊的奶油)");
            System.out.println("學長：給你衛生紙。");
            System.out.println("主角：不用啦，這樣就好啦。");
            System.out.println("(我邊說邊舔掉了手上的奶油，而學長看著害羞地別過了眼睛)");
            System.out.println("學長：喔喔好。");
            System.out.println("主角：那就明天賣蛋糕囉。");
        }
    }
}

class Character4 extends SubCharacter {
    public Character4(Game game, MainCharacter mainCharacter) {
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

class Character5 extends SubCharacter {
    public Character5(Game game, MainCharacter mainCharacter) {
        super(game, mainCharacter);
        this.game = game;
        this.mainCharacter = mainCharacter;
        this.type = "同桌";
        this.name = "default";
        this.likePoint = random.nextInt(21) + 50;
        this.gender = "男";
    }

    public void Day() {
        int choice = scanner.nextInt();
        if(choice == 1) {

        }
        if(choice == 2) {
            
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
