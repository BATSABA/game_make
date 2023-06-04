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
        Character1 friend = new Character1(this, me);
        Character2 Classmate = new Character2(this, me); 
        Character3 Senior = new Character3(this, me);
        Character4 Badguy = new Character4(this, me);
        Character5 Sister = new Character5(this, me);
        while (this.gameStat && this.date < 7) {
            switch (this.date) {
                case 1:
                    break;
                case 2:
                    Badguy.Day2_0800();
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
            TimeUnit.MILLISECONDS.sleep(100);
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

    public void DAY1_atSchool() {
        // System.out.println("Day3--14:00");
        Printer.print_with_delay("女：對啊 真的是太剛好哈哈。");
        Printer.print_with_delay("男：以後也請多多指教囉！");
        Printer.print_with_delay("（在學校，" + this.name + "的成績一落千丈，而你的成績在班上名列前矛。)");
        Printer.print_with_delay("女：欸這次我有進步ㄛ 從倒數第一變倒數第二");
        Printer.print_with_delay("男：我問號。啊你以前不是成績很好嗎 怎麼上了高中反而不認真了");
        Printer.print_with_delay("女：哪有，我很認真啊 每天都認真打扮。");
        Printer.print_with_delay("男：你再這樣下去不行 你媽媽每天都來找我抱怨你的成績。");
        Printer.print_with_delay("女：不用理他啦，我媽她就喜歡到處講我。");
        Printer.print_with_delay("男：我們不是說好也要考同一所大學嗎 你這樣怎麼行。");
        Printer.print_with_delay("女：以前是以前啦 現在是現在。");
        Printer.print_with_delay("男：我看不下去了 我找時間幫你單獨補習，一定要讓你媽刮目相看。");
        Printer.print_with_delay("女：沒關係，不用麻煩你啦");
        Printer.print_with_delay("男：我不麻煩，反而是你，你再不認真我要去跟你媽媽說你偷把裙子改短了喔");
        Printer.print_with_delay("女：好啦好啦，其實我也過想考好只是我好像做不到");
        Printer.print_with_delay("男：那是你打開的方式不對 我下次給你單獨補習");
        Printer.print_with_delay("女：好啦好啦，我會抽時間出來的。");
        Printer.print_with_delay("男：這樣才對嘛。");
    }

    public void DAY2_afterSchool() {
        Printer.print_with_delay("女：下課了欸，我們一起走回家吧。");
        Printer.print_with_delay("1：好啊");
        Printer.print_with_delay("2：不好");
        int choice = scanner.nextInt();
        if (choice == 1) {
            Printer.print_with_delay("(你和" + this.name + "一起走回家，走啊走啊走……)");
            Printer.print_with_delay("女：有小孩在那邊盪鞦韆欸 看起來很開心");
            Printer.print_with_delay("1：那我們也去玩一下吧");
            Printer.print_with_delay("2：真的欸 看完我們該走了 明天還有考試呢");

            choice = scanner.nextInt();
            if(choice == 1) {
                this.likePoint += 3;
                Printer.print_with_delay("女：那我們走吧，有點累哈哈明天還有考試呢！");
            }
            if(choice == 2) {
                this.likePoint -= 3;
                Printer.print_with_delay("女：那我們走吧，有點累哈哈明天還有考試呢。");
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
            Printer.print_with_delay("女：謝謝 我自己會努力的 我今天有點累就先休息了");
        }
        if(choice == 2) {
            game.gameStat = false;
        }

    }

    public void DAY3_exam() {
        Printer.print_with_delay("男：這次考怎樣，有進步嗎");
        Printer.print_with_delay("女：欸欸我覺得這次感覺可以喔");
        Printer.print_with_delay("1：你確定？考不好的人好像都會這樣說");
        Printer.print_with_delay("2：就不要分數出來超低哈哈");
        int choice = scanner.nextInt();
        if (choice == 1) this.likePoint += 3;
        if (choice == 2) this.likePoint -= 5;
        Printer.print_with_delay("女：真的啦 我這次感覺一定會進步");
        Printer.print_with_delay("（發成績 )");

        Printer.print_with_delay("男：啊你考的怎麼樣");
        Printer.print_with_delay("女：你看你看 我就說嘛我這次進步了10分");
        Printer.print_with_delay("男：一定是幫你補習的原因哼哼😌");
        Printer.print_with_delay("女：才不是勒😝是我最近比較認真哈哈");
        Printer.print_with_delay("男：要不要一起去福利社 為了慶祝你進步我請你吃東西");
        Printer.print_with_delay("女：好啊好啊");
        Printer.print_with_delay("(來到了福利社，你拿了...)");
        Printer.print_with_delay("1：一瓶可樂作為獎勵");
        Printer.print_with_delay("2：一個巧克力作為獎勵");
        choice = scanner.nextInt();
        if (choice == 1) {
            this.likePoint -= 10;
            Printer.print_with_delay("女：我最近不能喝冰的餒");
            Printer.print_with_delay("男：那就巧克力吧 當作進步的獎勵");
        }
        if( choice == 2) {
            this.likePoint += 10;
            Printer.print_with_delay("女：這個巧克力剛好是我最喜歡的欸");
        }
        Printer.print_with_delay("女：謝謝！");
    }

    public void DAY4_afterSchool() {
        Printer.print_with_delay("（放學回家後，你準備回去趕報告，正好遇到" + this.name + "）");
        Printer.print_with_delay("男：放學了，我們一起走吧");
        Printer.print_with_delay("女：好啊，等我一下我整理一下馬上");

        Printer.print_with_delay("1：好，我等你");
        Printer.print_with_delay("2：好，快點");
        int choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 5;
        if(choice == 2) this.likePoint -= 5;
        Printer.print_with_delay("女：欸我還要去上一下廁所");

        Printer.print_with_delay("1：欸你拖拉機喔 很會拖欸");
        Printer.print_with_delay("2：好啦趕快");
        choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 5;
        if(choice == 2) this.likePoint -= 3;
        Printer.print_with_delay("女：好啦好啦哈哈我趕快");
        Printer.print_with_delay("（放學路上）");

        Printer.print_with_delay("1：路上車很多欸 小心一點");
        Printer.print_with_delay("2：（把她拖到內側）");
        choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 1;
        if(choice == 2) this.likePoint += 10;
        Printer.print_with_delay("女：(笑");
        Printer.print_with_delay("男：前面有兩隻貓咪欸");
        Printer.print_with_delay("女：欸真的欸 好可愛ㄚ");
        Printer.print_with_delay("女：喵喵你好可愛喔（摸貓貓 ");
        Printer.print_with_delay("男：我覺得還好欸");
        Printer.print_with_delay("女：蛤 他們很可愛啊為什麼");
        Printer.print_with_delay("1：再可愛哪有你可愛");
        Printer.print_with_delay("2：我比較喜歡狗狗🐶");
        choice = scanner.nextInt();
        if(choice == 1) {
            this.likePoint += 10;
            Printer.print_with_delay("女：死相啦");
        }
        if(choice == 2) {
            this.likePoint -= 5;
            Printer.print_with_delay("女：狗狗也很可愛");
        }
    }

    public void DAY5_Morning() {
        Printer.print_with_delay("男：欸那邊有飛機撞到計程車了 趕快蹲下");
        Printer.print_with_delay("1：把" + this.name + "撲倒");
        Printer.print_with_delay("2：不撲倒她");
        int choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 5;
        Printer.print_with_delay("女：哇 好痛喔 幸好只是擦到而已沒有撞到我 我還以為你是開玩笑的欸");
        Printer.print_with_delay("男：我這邊剛好有藥膏 你是哪裡擦傷");
        Printer.print_with_delay("女：我大腿這邊有點擦傷好痛 我的手也是好痛");
        Printer.print_with_delay("1：藥膏給你");
        Printer.print_with_delay("2：我來幫你擦吧");
        choice = scanner.nextInt();
        if(choice == 1) {
            Printer.print_with_delay("女：謝謝 真不好意思哈哈");
            this.likePoint -= 5;
        }
        if(choice == 2 && this.likePoint >= 50) {
            Printer.print_with_delay("女：謝謝 真不好意思哈哈");
            this.likePoint += 10;
        }
        if(choice == 2 && this.likePoint < 50) {
            Printer.print_with_delay("女：不用了謝謝，我自己來就好");
        }
    }

    public void DAY6_breakTime() {
        Printer.print_with_delay("男：欸剛剛看你上課都在睡覺 啊你這樣一定學不會的啦");
        Printer.print_with_delay("女：這是我新創的學習法喔 睡眠學習法");
        Printer.print_with_delay("1：笑死這樣聽的懂我就做你男朋友");
        Printer.print_with_delay("2：哈哈你真有才 認真問啦要不要我給你講一遍");
        int choice = scanner.nextInt();
        if(choice == 1) this.likePoint -= 20;
        if(choice == 2) this.likePoint += 20;
        Printer.print_with_delay("女：不用 謝謝啦 其實我昨天先預習了 只是忙到很晚很累");
        Printer.print_with_delay("男：哎呦 怎麼突然認真起來了");
        Printer.print_with_delay("女：不想辜負我媽媽跟你的期待嘛");
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
        this.name = "default";
        this.likePoint = random.nextInt(13) + 50;
        this.gender = "女";
    }

    public void DAY1_atSchool() {
        Printer.print_with_delay("同桌：早安，我們這次是同桌喔，請多多指教");
        Printer.print_with_delay("我：哦，請多多指教");
        Printer.print_with_delay("(如果是同桌的話，感覺相處時間會變得多起來，應該有機會讓攻略她吧，好，那就決定是她了。)");
    }
    
    public void DAY2_atSchool() {
        Printer.print_with_delay("(上課真無聊啊~~ 诶，" + this.name +"在打瞌睡?)");
        Printer.print_with_delay("1：拿出便條紙，在紙條寫到:「打瞌睡小心被老師抓到，無聊的話要不要用紙條聊天」偷偷把紙條塞給在打瞌睡的同桌。");
        Printer.print_with_delay("2：用鉛筆偷偷戳對方，然後笑著看著同桌跟她說這堂課很重要，小心不要睡著。順便把剛剛去合作社買的提神薄荷糖分給她。");
        int choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 10;
        if(choice == 2) this.likePoint += 6;
        Printer.print_with_delay("(下課後)");
        Printer.print_with_delay("同桌：剛剛真的謝謝你，作為回報，我下午請你喝飲料吧");
        Printer.print_with_delay("1：只是叫醒你就有飲料喝也太好了吧，不然這樣，我負責跑腿，你負責出錢，讓我當負責跑腿的同桌吧");
        Printer.print_with_delay("2：叫醒你只有飲料喝嗎，如果只有這樣，下次你再睡著我就不知道我自己會做甚麼囉");
        Printer.print_with_delay("3：不用啦，不用因為這種事情請我喝飲料啦，我會不好意思");
        choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 4;
        if(choice == 2) this.likePoint -= 8;
    }

    public void DAY3_evening() {
        Printer.print_with_delay("同桌：你是不是數學特別好啊，今天老師上的排列組合我不太懂，可以教我嗎？");
        Printer.print_with_delay("1：當然沒問題，剛好我這次的英文文法搞不太懂，作為交換，你可以教我英文嗎？");
        Printer.print_with_delay("2：你是小笨蛋嗎，我有整理好的數學筆記，偷偷跟你講，我只給你而已喔");
        int choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 2;
        if(choice == 2) this.likePoint += 8;
        Printer.print_with_delay("(" + this.name + "暫時複習完今天的內容，放下筆後用手撐起頭看著我)");
        Printer.print_with_delay("同桌：你好認真喔。這就是功課好的原因嗎？");
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
        Printer.print_with_delay("老師：好，這禮拜是學園祭，我們班的主題是女僕咖啡廳，大家一起分組吧。");
        Printer.print_with_delay("同桌：(跨過桌子的中線，把臉湊近說) 一起準備學園祭感覺會很有趣，我們一組吧，可是你好像有其他朋友…");
        Printer.print_with_delay("1：不用在意他們，跟他們一組感覺會很沒效率，而且我也想和你一組");
        Printer.print_with_delay("2：平常跟他們太常待在一起了，偶爾換換組員也不錯，我們一組吧，請多多指教");
        int choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 8;
        if(choice == 2) this.likePoint += 4;
        Printer.print_with_delay("老師：好的那這組負責準備女僕的衣服跟設計菜單喔");
        Printer.print_with_delay("同桌：幸好聽起來不是什麼太麻煩的工作，我們今天的目標是先把菜單設計完成，學園祭前一天再去租女僕衣吧。");
        Printer.print_with_delay("1：沒問題，你是不是喜歡喝珍珠奶茶，那我們就公器私用，把珍珠奶茶也列入菜單吧。");
        Printer.print_with_delay("2：菜單的部分我可以負責幫品項取名，但我的美術不好，美編的部分可能要交給你喔。");
        choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 6;
        Printer.print_with_delay("(今天的學園祭準備工作暫時告一段落。)");
    }

    public void DAY5_pickClothes() {
        Printer.print_with_delay("同桌：你提早到啦，我們趕快進去幫大家租明天要穿的女僕衣吧");
        Printer.print_with_delay("同桌：你提早到啦，我們趕快進去幫大家租明天要穿的女僕衣吧");
        Printer.print_with_delay("同桌：你提早到啦，我們趕快進去幫大家租明天要穿的女僕衣吧");
        Printer.print_with_delay("我：進去吧，ㄟ你也會扮成女僕嗎？");
        Printer.print_with_delay("同桌：會的喔，怎麼了嗎？");
        Printer.print_with_delay("1：感覺會很有趣，你穿起來肯定很好看吧，可是這樣就大家都看到的了…");
        Printer.print_with_delay("2：感覺會很有趣，你穿起來肯定很好看吧，我很期待喔");
        int choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 8;
        if(choice == 2) this.likePoint += 6;
        Printer.print_with_delay("(一段時間後...)");
        Printer.print_with_delay("同桌：大家的衣服都租好了，剩我自己還沒挑，你要不要幫我挑");
        Printer.print_with_delay("1：我看一下喔，你說過你不適合太緊身的衣服，啊！這件版型感覺很適合你，你穿起來一定很好看");
        Printer.print_with_delay("2：我不會挑衣服ㄟ，我怕挑到你不喜歡的，你自己選啦，反正你穿甚麼都好看。");
        choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 8;
        if(choice == 2) this.likePoint += 6;
        Printer.print_with_delay("(回到學校後)");
        Printer.print_with_delay("我：呼，這樣學園祭的是前準備終於告一段落了，後天一定要好好體驗學園祭");
        Printer.print_with_delay("同桌：好期待後天喔");
        Printer.print_with_delay("1：你是值班到１２點對吧，我之後剛好有空，要不要一起去逛學園祭");
        Printer.print_with_delay("2：你後天有空嗎？我不想錯過難得的機會，我明天想要跟你一起逛學園祭");
        Printer.print_with_delay("3：聽說明天３班會賣棉花糖，你不是喜歡吃棉花糖嗎？到時候要不要一起去？");
        choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 2;
        if(choice == 2) this.likePoint += 8;
        if(choice == 3) this.likePoint += 4;
        Printer.print_with_delay("同桌：(笑著點頭說) 可以啊，把一點時間分給你，好期待阿。");
    }

    public void DAY6_health() {
        Printer.print_with_delay("(你和" + this.name + "在為了學園祭做準備)");
        Printer.print_with_delay("我：你怎麼了?");
        Printer.print_with_delay("同桌：我剛剛裁紙條的時候不小心割到手了ＱＱ");
        Printer.print_with_delay("1：用手帕幫她做簡單的包紮，並馬上舉手跟老師說要帶同桌去保健室。");
        Printer.print_with_delay("2：用嘴巴吸住她的手指幫她止血，再帶她去保健室包紮。");
        int choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 7;
        if(choice == 2) this.likePoint -= 20;
        Printer.print_with_delay("到保健室包紮完回到教室後，回到座位，同桌打算繼續把沒裁完的紙割完");
        Printer.print_with_delay("同桌：謝謝你剛剛帶我去保健室");
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
        this.name = "default";
        this.likePoint = random.nextInt(21) + 50;
        this.gender = "男";
    }

    public void Day2_1300() {
        Printer.print_with_delay("Day2--13:00");
        Printer.print_with_delay("學長：今天我們要做的是手工餅乾，做好之後可以自己留著或是送給喜歡的人吃喔。");
        Printer.print_with_delay("主角：學長我不太會做，可以請你來協助我嗎？");
        Printer.print_with_delay("學長：當然可以啦，有什麼問題都可以問我。");
        Printer.print_with_delay("主角：那我們開始吧。");
        Printer.print_with_delay("主角：我要不要把餅乾送給學長呢...");
        Printer.print_with_delay("1：不要好了。");
        Printer.print_with_delay("2：當然要。");
        int choice = scanner.nextInt();
        if(choice == 1) {
            likePoint -= 5;
            Printer.print_with_delay("學長：小學弟，你的餅乾是要送人的嗎？");
            Printer.print_with_delay("主角：應該吧，或是我自己吃掉。學長怎麼了嗎？");
            Printer.print_with_delay("學長：喔沒事啦，那品嘗後再分享感想給我。");
            Printer.print_with_delay("主角：好的。");
        }
        else if(choice == 2) {
            likePoint += 5;
            Printer.print_with_delay("主角：學長，我做的餅乾送給你吃。");
            Printer.print_with_delay("學長：你要送給我吃嗎？");
            Printer.print_with_delay("主角：對呀，可是我不知道味道如何就是了。");
            Printer.print_with_delay("學長：沒事，有我在旁邊協助你，做出來的味道一定不會差。");
            Printer.print_with_delay("主角：說的也是，有學長的加持，餅乾味道一定很好。");
            Printer.print_with_delay("學長：我也沒幫什麼忙，有點不好意思呢，那我就收下囉。");
            Printer.print_with_delay("主角：當然，請一定要收下。");
        }  
    }

    public void Day3_1400() {
        Printer.print_with_delay("Day3--14:00");
        Printer.print_with_delay("(在社團活動中，學長注意到主角的圍裙後面破了一個洞，所以在社團課下課後...");
        Printer.print_with_delay("學長：我看到你圍裙後面破洞了，你有發現嗎？");
        Printer.print_with_delay("主角：欸？真的嗎？在哪裡？");
        Printer.print_with_delay("學長：在這裡，剛好是你看不到的地方。");
        Printer.print_with_delay("主角：那怎麼辦呢。");
        Printer.print_with_delay("學長：剛好我會縫補，需要我幫你縫嗎？");
        Printer.print_with_delay("主角:我要不要讓學長幫我縫補圍裙呢...");
        Printer.print_with_delay("1：拒絕，還是自己補好了");
        Printer.print_with_delay("2：好呀，讓學長幫忙補");
        int choice = scanner.nextInt();
        if(choice == 1) {
            likePoint -= 5;
            Printer.print_with_delay("主角：謝謝學長的好意，我還是自己來就行了。");
            Printer.print_with_delay("學長：你確定嗎？");
            Printer.print_with_delay("主角：雖然可能沒辦法縫得很完美，但沒關係。");
            Printer.print_with_delay("學長：那好吧，你拿針跟縫補的時候，一定要小心，不要扎到手了。");
            Printer.print_with_delay("主角：好的。");
        }
        if(choice == 2) {
            likePoint += 5;
            Printer.print_with_delay("主角：學長，我不太會補，那就麻煩你了。");
            Printer.print_with_delay("學長：不會麻煩的，剛好我平時衣服破洞或是其他東西破掉，我都是自己把它縫回去的。");
            Printer.print_with_delay("主角：哇！學長，你根本就是大暖男吧。除了會做吃的還有縫東西，還有什麼是你不會的。");
            Printer.print_with_delay("學長：你太誇張了啦，雖然這些是我的強項沒錯，但人不是十全十美的，我也是有不會的。");
            Printer.print_with_delay("主角：沒關係，我覺得學長已經很棒了，如果以後要找對象好想找跟學長一樣暖的。");
            Printer.print_with_delay("學長（害羞：縫好了，還給你吧。如果之後又破掉了，再拿來給我縫吧。");
            Printer.print_with_delay("主角：好的，謝謝學長。");
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
            Printer.print_with_delay("主角：不用啦，現在食堂都是人，會很擠也很悶。");
            Printer.print_with_delay("學長：沒關係阿，我剛好也可以順便看看有沒有我喜歡吃的東西。");
            Printer.print_with_delay("主角：可是學長你有自己帶便當，再買了就吃不完了。");
            Printer.print_with_delay("學長：吃不完了我們就一起分吧。");
            Printer.print_with_delay("主角：我的食量也不大，我還是回教室吃就好。");
            Printer.print_with_delay("學長：那好吧。");
        } else if (choice == 2) {
            likePoint += 10;
            Printer.print_with_delay("主角：好呀，可是學長，現在食堂很多人會很擠，你沒問題嗎。");
            Printer.print_with_delay("學長：沒關係的，剛好我也可以看看有沒有喜歡吃的。");
            Printer.print_with_delay("主角：那我們買完後，去我前幾天發現的小花園吧。");
            Printer.print_with_delay("學長：好呀。我們走吧。");
        }
    }

    public void Day5_1230() {
        Printer.print_with_delay("Day4--12:30");
        Printer.print_with_delay("(過2天後就是學園祭了，我想要邀請學長陪我一起逛，但是我應該怎麼告訴他呢...)");
        Printer.print_with_delay("1：自己當面交給學長才有誠意，而且還可以把自己親手做的餅乾一起打包送給學長。");
        Printer.print_with_delay("2：請他人轉交。");
        int choice = scanner.nextInt();
        if (choice == 1) {
            likePoint += 30;
            Printer.print_with_delay("（我還是親手交給學長好了）");
            Printer.print_with_delay("主角：學長，這個卡片跟餅乾給你。");
            Printer.print_with_delay("學長：嗯？這是什麼卡片阿，還有這個餅乾是你做的嗎？");
            Printer.print_with_delay("主角：卡片就是... 2天後就是學園祭了，我想邀請你一起逛。不知道你覺得怎麼樣...");
            Printer.print_with_delay("學長：當然可以啦，我也正好想要問你要不要一起呢。那這包餅乾呢？");
            Printer.print_with_delay("主角：餅乾是之前社團課教的手工餅乾，我回去後又在自己做了一些，想說送給學長，讓學長感受到我的誠意。");
            Printer.print_with_delay("學長：你的心意我收到了，謝謝你親手為我做餅乾。");
            Printer.print_with_delay("主角：不用客氣啦。");
            Printer.print_with_delay("學長：那我們學園祭就一起逛吧。");
            Printer.print_with_delay("主角：好的。");
        }
        else if (choice == 2) {
            likePoint = 0;
            game.gameStat = false;
            Printer.print_with_delay("主角：這個麻煩請你幫我轉交給烹飪社的學長。");
            Printer.print_with_delay("路人甲：直接拿給他就好嗎，沒問題。");
            Printer.print_with_delay("(突然間，我眼角餘光瞄到學長的身影漸漸靠近。我感覺到臉頰微微泛起紅暈，卻不知如何解釋。學長好像誤會了甚麼，隨即轉身離去，流露出一絲不悅之情。我急忙追上前去，想為自己的行為解釋清楚...)");
            Printer.print_with_delay("主角：學長，等一下，等等我。");
            Printer.print_with_delay("學長：我為什麼要等你，你不是在跟路人甲說話嗎，還送他東西，還臉紅，那你為什麼要來找我。");
            Printer.print_with_delay("主角：那是有原因的，你聽我解釋。");
            Printer.print_with_delay("學長：我不想聽你的藉口，不要再來找我了。");
        }
    }

    public void Day6_1300() {
        Printer.print_with_delay("Day6--13:00");
        Printer.print_with_delay("(明天就是學園祭了，班上決定要以女僕咖啡廳為主題，我跟學長都覺得可以做蛋糕來賣，於是...");
        Printer.print_with_delay("主角：學長，明天就是學園祭了，既然班上決定要開女僕咖啡廳，而且我們又是烹飪社的，不如我們來做蛋糕，覺得如何？");
        Printer.print_with_delay("學長：我覺得這個主意不錯，而且也很適合在女僕咖啡廳上賣。");
        Printer.print_with_delay("主角：那就這麼愉快的決定了，不過我還不太會做蛋糕，所以學長你要幫我唷。");
        Printer.print_with_delay("學長：當然沒問題啦。我們開始吧。");
        Printer.print_with_delay("(做完蛋糕之後...");
        Printer.print_with_delay("主角：學長，蛋糕做好了，我們來試試味道吧。");
        Printer.print_with_delay("學長：可以呀。");
        Printer.print_with_delay("主角：要品嘗蛋糕時，我決定...");
        Printer.print_with_delay("1:跟學長各切各的蛋糕，各吃各的蛋糕。");
        Printer.print_with_delay("2:幫學長切好後，餵到他嘴邊給他吃。");
        int choice = scanner.nextInt();
        if (choice == 1) {
            likePoint -= 5;
            Printer.print_with_delay("主角：那學長你先切好了，我等等再切。");
            Printer.print_with_delay("學長：我可以順便幫你切的。");
            Printer.print_with_delay("主角：不用麻煩啦，而且你也不知道我想吃多少，所以我自己來就好了。");
            Printer.print_with_delay("學長：那好吧，吃完再跟我說說味道如何。");
            Printer.print_with_delay("(兩人坐下來吃蛋糕，期間很少交流");
        }
        else if (choice == 2) {
            likePoint = 100;
            Printer.print_with_delay("主角：學長，我來幫你切蛋糕吧。你要多大塊呢？");
            Printer.print_with_delay("學長：你就照你想要切的大小就可以。");
            Printer.print_with_delay("主角：那我就隨便切囉。");
            Printer.print_with_delay("學長：好的。");
            Printer.print_with_delay("(切好蛋糕後，坐下來面對面吃)");
            Printer.print_with_delay("主角：學長你覺得我們做的蛋糕怎麼樣，味道如何？");
            Printer.print_with_delay("學長：味道還不錯，不會太甜也不會沒味道。明天可以拿去女僕咖啡廳賣了。");
            Printer.print_with_delay("主角：真的嗎，真是太好了，阿學長你嘴角好像沾到了奶油。");
            Printer.print_with_delay("學長：真的嗎？在哪裡？");
            Printer.print_with_delay("主角：我幫你");
            Printer.print_with_delay("(我用手抹掉了學長嘴邊的奶油)");
            Printer.print_with_delay("學長：給你衛生紙。");
            Printer.print_with_delay("主角：不用啦，這樣就好啦。");
            Printer.print_with_delay("(我邊說邊舔掉了手上的奶油，而學長看著害羞地別過了眼睛)");
            Printer.print_with_delay("學長：喔喔好。");
            Printer.print_with_delay("主角：那就明天賣蛋糕囉。");
        }
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
}

class Character5 extends SubCharacter {
    public Character5(Game game, MainCharacter mainCharacter) {
        super(game, mainCharacter);
        this.game = game;
        this.mainCharacter = mainCharacter;
        this.type = "姊姊";
        this.name = "山下漢城";
        this.likePoint = random.nextInt(21) + 60;
        this.gender = "女";
    }

    public void Day1_afterSchool() {
        Printer.print_with_delay("姊姊放學後回家吃飯之時，家裡突然發生大火，於此同時，正好你有同學約你放學去吃飯，你要選擇去關心姊姊還是跟同學吃飯？");
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
        Printer.print_with_delay("你跟姊姊在健身房相遇，但是一個重100公斤的啞鈴正要壓向她，你要怎麼做？");
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
        Printer.print_with_delay("你和姐姐剛好要一起去超商買午餐，但是你跟她都有健身，必須吃黑胡椒雞胸肉，但超商剛好剩最後一包雞胸肉，你會讓給他嗎？");
        Printer.print_with_delay("1：讓給他");
        Printer.print_with_delay("2：不讓給他");
        int choice = scanner.nextInt();
        if (choice == 1) {
            this.likePoint -= 7;
            Printer.print_with_delay("但她吃完後肌肉變多，她開始看不起你這個細狗，好感度減少。");
        };
        if(choice == 2) {
            this.likePoint += 7;
            Printer.print_with_delay("你吃完後變壯很多，你姊很欣賞你的體態，買給你五杯大冰拿以示鼓勵，好感度增加。");
        };
    }

    public void Day4_library() {
        Printer.print_with_delay("妳一個人躺在二樓漫畫區的沙發上穿著吊嘎，全身汗臭，翹著二郎腿赤著腳睡覺。你拍照到dcard公審他，事後發現居然就是你姊，你該怎麼辦？");
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
        Printer.print_with_delay("上課鐘響了，但是你姊在教室旁的樓梯口摔倒了，腿上流出大量紅色液體，你覺得那是血而幫他扶起來，還是覺得是番茄醬，他只不過想引人注意罷了？");
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
        Printer.print_with_delay("你決定要告白了，但是發現他卻跟別的男生有說有笑，還抱在一起，你還要告白嗎？");
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

        // A1要，但先等她跟那個男生聊完，再換你跟他告白，做個有禮貌的文明人。但告白後他卻說自己配不上你，你笑著含淚接受，頓時彷彿身處高譚市，還沒戴上小丑的面具就被現實狠狠拷打，最後被前女友所殺。（好感值低時選要的結局）

        // A2要，但先等她跟那個男生聊完，再換你跟他告白，做個有禮貌的文明人。聊完天後，你試探性的問了那位男生的身分，很幸運的，跟他抱在一起的人，是他哥。你隨後鼓起勇氣告白，成功。（好感值高時選要的結局）

        // B1不要，你根本沒表達心意，她怎麼會知道你喜歡她，當然不可能成功。（好感值低時選不要的結局）

        // B2不要，你覺得自己反正爛命一條，再找新的就好，不缺她一個。你懷著這股傲氣想瀟灑離開，但眼淚仍止不住的從眼角流下來，你恨自己的無能與軟弱，懷疑自己的自信是不是開了濾鏡，想到戶政事務所把自己身分證名字改成魯蛇。然而，就在你轉身那霎那，她叫住了你。你無所期待，轉過頭，顫抖的打了個招呼，想盡最大努力強顏歡笑，證明自己很堅強。
        // "謝謝你，我喜歡你"她小聲的說。你懷疑自己是不是聽錯，迅速拿出手機劃開，想確認今天是不是愚人節。你的眼神快速的掃過四周，確認沒有人拿iphone14pro max 1TB誘惑她玩真心話大冒險。
        // 總之，你是愣住了，沒接話。而她對於你的反應不是很滿意，不耐煩的說了句：“事不過三聽過嗎？” 你只點了點頭。“我、愛、你”這次，她靠的很近，距離你的耳朵咫尺之隔。她的輕聲細語，在你耳邊卻如此的震耳欲隆。
        // 你停滯了片刻，腦袋一片空白，你現在需要做點什麼......啊！我的告白詞呢？然而，此時，曾經練習過無數次、總把好兄弟當成告白對象、練習到兄弟都自願說yes I do 的告白詞，在這個緊要關頭卻怎麼也說不出來。而就在不知所措的同時，你突然想到，過去在課堂上，每當老師說舉手回答總成績加10分！你總是最積極的舉手，期待老師點到你，然後神色自若的回答像印度首陀羅下面是戰鬥陀螺這種幼稚屁話，而現在，你知道自己緊張到沒辦法主動講話，需要有人為這份告白詞開頭。
        // 你決定故技重施，放手一搏，就像在過去課堂上，奮力舉直右手過頭，用滿是意會的眼神與對方四目相交，希望對方能點你回答，只是這次舉手，沒有總成績加分、也沒有簽到性質，有的只是一份表達內心悸動的勇氣。
        // 終於，她的眼神從原本的錯愕不解，逐漸笑成了彎月，好像牛頓的地心引力只存在於她的眼尾。
        // “請說”她是這麼說的。

        // 當然，你成功了，不會被前女友殺掉。
        // （好感值高時選不要的結局）

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
