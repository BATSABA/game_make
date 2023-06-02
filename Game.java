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

    public void DAY1_atSchool() {
        // System.out.println("Day3--14:00");
        System.out.println("女：對啊 真的是太剛好哈哈。");
        System.out.println("男：以後也請多多指教囉！");
        System.out.println("（在學校，" + this.name + "的成績一落千丈，而你的成績在班上名列前矛。)");
        System.out.println("女：欸這次我有進步ㄛ 從倒數第一變倒數第二");
        System.out.println("男：我問號。啊你以前不是成績很好嗎 怎麼上了高中反而不認真了");
        System.out.println("女：哪有，我很認真啊 每天都認真打扮。");
        System.out.println("男：你再這樣下去不行 你媽媽每天都來找我抱怨你的成績。");
        System.out.println("女：不用理他啦，我媽她就喜歡到處講我。");
        System.out.println("男：我們不是說好也要考同一所大學嗎 你這樣怎麼行。");
        System.out.println("女：以前是以前啦 現在是現在。");
        System.out.println("男：我看不下去了 我找時間幫你單獨補習，一定要讓你媽刮目相看。");
        System.out.println("女：沒關係，不用麻煩你啦");
        System.out.println("男：我不麻煩，反而是你，你再不認真我要去跟你媽媽說你偷把裙子改短了喔");
        System.out.println("女：好啦好啦，其實我也過想考好只是我好像做不到");
        System.out.println("男：那是你打開的方式不對 我下次給你單獨補習");
        System.out.println("女：好啦好啦，我會抽時間出來的。");
        System.out.println("男：這樣才對嘛。");
    }

    public void DAY2_afterSchool() {
        System.out.println("女：下課了欸，我們一起走回家吧。");
        System.out.println("1：好啊");
        System.out.println("2：不好");
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("(你和" + this.name + "一起走回家，走啊走啊走……)");
            System.out.println("女：有小孩在那邊盪鞦韆欸 看起來很開心");
            System.out.println("1：那我們也去玩一下吧");
            System.out.println("2：真的欸 看完我們該走了 明天還有考試呢");

            choice = scanner.nextInt();
            if(choice == 1) {
                this.likePoint += 3;
                System.out.println("女：那我們走吧，有點累哈哈明天還有考試呢！");
            }
            if(choice == 2) {
                this.likePoint -= 3;
                System.out.println("女：那我們走吧，有點累哈哈明天還有考試呢。");
            }
            System.out.println("1：這個夕陽好好看 可惜明天要考試 那我們等到太陽下山再走吧");
            System.out.println("2：要趕快回家看書了");

            choice = scanner.nextInt();
            if (choice == 1) this.likePoint += 5;
            if (choice == 2) this.likePoint -= 3;
            System.out.println("1：明天考試加油喔");
            System.out.println("2：我們等等電話討論功課 加油");

            choice = scanner.nextInt();
            if (choice == 1) this.likePoint += 5;
            if (choice == 2) this.likePoint -= 5;
            System.out.println("女：謝謝 我自己會努力的 我今天有點累就先休息了");
        }
        if(choice == 2) {
            game.gameStat = false;
        }

    }

    public void DAY3_exam() {
        System.out.println("男：這次考怎樣，有進步嗎");
        System.out.println("女：欸欸我覺得這次感覺可以喔");
        System.out.println("1：你確定？考不好的人好像都會這樣說");
        System.out.println("2：就不要分數出來超低哈哈");
        int choice = scanner.nextInt();
        if (choice == 1) this.likePoint += 3;
        if (choice == 2) this.likePoint -= 5;
        System.out.println("女：真的啦 我這次感覺一定會進步");
        System.out.println("（發成績 )");

        System.out.println("男：啊你考的怎麼樣");
        System.out.println("女：你看你看 我就說嘛我這次進步了10分");
        System.out.println("男：一定是幫你補習的原因哼哼😌");
        System.out.println("女：才不是勒😝是我最近比較認真哈哈");
        System.out.println("男：要不要一起去福利社 為了慶祝你進步我請你吃東西");
        System.out.println("女：好啊好啊");
        System.out.println("(來到了福利社，你拿了...)");
        System.out.println("1：一瓶可樂作為獎勵");
        System.out.println("2：一個巧克力作為獎勵");
        choice = scanner.nextInt();
        if (choice == 1) {
            this.likePoint -= 10;
            System.out.println("女：我最近不能喝冰的餒");
            System.out.println("男：那就巧克力吧 當作進步的獎勵");
        }
        if( choice == 2) {
            this.likePoint += 10;
            System.out.println("女：這個巧克力剛好是我最喜歡的欸");
        }
        System.out.println("女：謝謝！");
    }

    public void DAY4_afterSchool() {
        System.out.println("（放學回家後，你準備回去趕報告，正好遇到" + this.name + "）");
        System.out.println("男：放學了，我們一起走吧");
        System.out.println("女：好啊，等我一下我整理一下馬上");

        System.out.println("1：好，我等你");
        System.out.println("2：好，快點");
        int choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 5;
        if(choice == 2) this.likePoint -= 5;
        System.out.println("女：欸我還要去上一下廁所");

        System.out.println("1：欸你拖拉機喔 很會拖欸");
        System.out.println("2：好啦趕快");
        choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 5;
        if(choice == 2) this.likePoint -= 3;
        System.out.println("女：好啦好啦哈哈我趕快");
        System.out.println("（放學路上）");

        System.out.println("1：路上車很多欸 小心一點");
        System.out.println("2：（把她拖到內側）");
        choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 1;
        if(choice == 2) this.likePoint += 10;
        System.out.println("女：(笑");
        System.out.println("男：前面有兩隻貓咪欸");
        System.out.println("女：欸真的欸 好可愛ㄚ");
        System.out.println("女：喵喵你好可愛喔（摸貓貓 ");
        System.out.println("男：我覺得還好欸");
        System.out.println("女：蛤 他們很可愛啊為什麼");
        System.out.println("1：再可愛哪有你可愛");
        System.out.println("2：我比較喜歡狗狗🐶");
        choice = scanner.nextInt();
        if(choice == 1) {
            this.likePoint += 10;
            System.out.println("女：死相啦");
        }
        if(choice == 2) {
            this.likePoint -= 5;
            System.out.println("女：狗狗也很可愛");
        }
    }

    public void DAY5_Morning() {
        System.out.println("男：欸那邊有飛機撞到計程車了 趕快蹲下");
        System.out.println("1：把" + this.name + "撲倒");
        System.out.println("2：不撲倒她");
        int choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 5;
        System.out.println("女：哇 好痛喔 幸好只是擦到而已沒有撞到我 我還以為你是開玩笑的欸");
        System.out.println("男：我這邊剛好有藥膏 你是哪裡擦傷");
        System.out.println("女：我大腿這邊有點擦傷好痛 我的手也是好痛");
        System.out.println("1：藥膏給你");
        System.out.println("2：我來幫你擦吧");
        choice = scanner.nextInt();
        if(choice == 1) {
            System.out.println("女：謝謝 真不好意思哈哈");
            this.likePoint -= 5;
        }
        if(choice == 2 && this.likePoint >= 50) {
            System.out.println("女：謝謝 真不好意思哈哈");
            this.likePoint += 10;
        }
        if(choice == 2 && this.likePoint < 50) {
            System.out.println("女：不用了謝謝，我自己來就好");
        }
    }

    public void DAY6_breakTime() {
        System.out.println("男：欸剛剛看你上課都在睡覺 啊你這樣一定學不會的啦");
        System.out.println("女：這是我新創的學習法喔 睡眠學習法");
        System.out.println("1：笑死這樣聽的懂我就做你男朋友");
        System.out.println("2：哈哈你真有才 認真問啦要不要我給你講一遍");
        int choice = scanner.nextInt();
        if(choice == 1) this.likePoint -= 20;
        if(choice == 2) this.likePoint += 20;
        System.out.println("女：不用 謝謝啦 其實我昨天先預習了 只是忙到很晚很累");
        System.out.println("男：哎呦 怎麼突然認真起來了");
        System.out.println("女：不想辜負我媽媽跟你的期待嘛");
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
        this.likePoint = random.nextInt(13) + 50;
        this.gender = "女";
    }

    public void DAY1_atSchool() {
        System.out.println("同桌：早安，我們這次是同桌喔，請多多指教");
        System.out.println("我：哦，請多多指教");
        System.out.println("(如果是同桌的話，感覺相處時間會變得多起來，應該有機會讓攻略她吧，好，那就決定是她了。)");
    }
    
    public void DAY2_atSchool() {
        System.out.println("(上課真無聊啊~~ 诶，" + this.name +"在打瞌睡?)");
        System.out.println("1：拿出便條紙，在紙條寫到:「打瞌睡小心被老師抓到，無聊的話要不要用紙條聊天」偷偷把紙條塞給在打瞌睡的同桌。");
        System.out.println("2：用鉛筆偷偷戳對方，然後笑著看著同桌跟她說這堂課很重要，小心不要睡著。順便把剛剛去合作社買的提神薄荷糖分給她。");
        int choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 10;
        if(choice == 2) this.likePoint += 6;
        System.out.println("(下課後)");
        System.out.println("同桌：剛剛真的謝謝你，作為回報，我下午請你喝飲料吧");
        System.out.println("1：只是叫醒你就有飲料喝也太好了吧，不然這樣，我負責跑腿，你負責出錢，讓我當負責跑腿的同桌吧");
        System.out.println("2：叫醒你只有飲料喝嗎，如果只有這樣，下次你再睡著我就不知道我自己會做甚麼囉");
        System.out.println("3：不用啦，不用因為這種事情請我喝飲料啦，我會不好意思");
        choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 4;
        if(choice == 2) this.likePoint -= 8;
    }

    public void DAY3_evening() {
        System.out.println("同桌：你是不是數學特別好啊，今天老師上的排列組合我不太懂，可以教我嗎？");
        System.out.println("1：當然沒問題，剛好我這次的英文文法搞不太懂，作為交換，你可以教我英文嗎？");
        System.out.println("2：你是小笨蛋嗎，我有整理好的數學筆記，偷偷跟你講，我只給你而已喔");
        int choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 2;
        if(choice == 2) this.likePoint += 8;
        System.out.println("(" + this.name + "暫時複習完今天的內容，放下筆後用手撐起頭看著我)");
        System.out.println("同桌：你好認真喔。這就是功課好的原因嗎？");
        System.out.println("1：用手把她的頭轉回去並說道：這位同學，晚自習請認真讀書。");
        System.out.println("2：學她用手把頭撐起來看著她並說道：這位同學，用這種眼神打擾晚自習的同學犯規喔，我也要打擾回去。");
        choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 2;
        if(choice == 2) this.likePoint += 8;
        System.out.println("(" + this.name + "要出去裝水，且問說要不要幫忙盛水)");
        System.out.println("1：真的嗎，我剛好水壺也沒有水，那就麻煩你了");
        System.out.println("2：把自己的水壺藏起來，並跟她說：「我今天忘記帶水壺了，我能跟我最好的同桌借水壺喝水嗎？」");
        System.out.println("3：現在四處都暗暗的ㄟ，我跟你一起去盛水好了");
        choice = scanner.nextInt();
        if(choice == 2) this.likePoint -= 10;
        if(choice == 3) this.likePoint += 8;
        System.out.println("(晚自習結束。)");
        System.out.println("1：已經很晚了，自己回家不安全，我可以陪你搭公車，要一起回家嗎？");
        System.out.println("2：已經很晚了，回家注意安全喔，到家傳訊息跟我說一下，掰掰");
        choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 8;
        if(choice == 2) this.likePoint += 2;
    }

    public void DAY4_atSchool() {
        System.out.println("老師：好，這禮拜是學園祭，我們班的主題是女僕咖啡廳，大家一起分組吧。");
        System.out.println("同桌：(跨過桌子的中線，把臉湊近說) 一起準備學園祭感覺會很有趣，我們一組吧，可是你好像有其他朋友…");
        System.out.println("1：不用在意他們，跟他們一組感覺會很沒效率，而且我也想和你一組");
        System.out.println("2：平常跟他們太常待在一起了，偶爾換換組員也不錯，我們一組吧，請多多指教");
        int choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 8;
        if(choice == 2) this.likePoint += 4;
        System.out.println("老師：好的那" + this.MainCharacter.name +"這組負責準備女僕的衣服跟設計菜單喔");
        System.out.println("同桌：幸好聽起來不是什麼太麻煩的工作，我們今天的目標是先把菜單設計完成，學園祭前一天再去租女僕衣吧。");
        System.out.println("1：沒問題，你是不是喜歡喝珍珠奶茶，那我們就公器私用，把珍珠奶茶也列入菜單吧。");
        System.out.println("2：菜單的部分我可以負責幫品項取名，但我的美術不好，美編的部分可能要交給你喔。");
        choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 6;
        System.out.println("(今天的學園祭準備工作暫時告一段落。)");
    }

    public void DAY5_pickClothes() {
        System.out.println("同桌：你提早到啦，我們趕快進去幫大家租明天要穿的女僕衣吧");
        System.out.println("同桌：你提早到啦，我們趕快進去幫大家租明天要穿的女僕衣吧");
        System.out.println("同桌：你提早到啦，我們趕快進去幫大家租明天要穿的女僕衣吧");
        System.out.println("我：進去吧，ㄟ你也會扮成女僕嗎？");
        System.out.println("同桌：會的喔，怎麼了嗎？");
        System.out.println("1：感覺會很有趣，你穿起來肯定很好看吧，可是這樣就大家都看到的了…");
        System.out.println("2：感覺會很有趣，你穿起來肯定很好看吧，我很期待喔");
        int choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 8;
        if(choice == 2) this.likePoint += 6;
        System.out.println("(一段時間後...)");
        System.out.println("同桌：大家的衣服都租好了，剩我自己還沒挑，你要不要幫我挑");
        System.out.println("1：我看一下喔，你說過你不適合太緊身的衣服，啊！這件版型感覺很適合你，你穿起來一定很好看");
        System.out.println("2：我不會挑衣服ㄟ，我怕挑到你不喜歡的，你自己選啦，反正你穿甚麼都好看。");
        choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 8;
        if(choice == 2) this.likePoint += 6;
        System.out.println("(回到學校後)");
        System.out.println("我：呼，這樣學園祭的是前準備終於告一段落了，後天一定要好好體驗學園祭");
        System.out.println("同桌：好期待後天喔");
        System.out.println("1：你是值班到１２點對吧，我之後剛好有空，要不要一起去逛學園祭");
        System.out.println("2：你後天有空嗎？我不想錯過難得的機會，我明天想要跟你一起逛學園祭");
        System.out.println("3：聽說明天３班會賣棉花糖，你不是喜歡吃棉花糖嗎？到時候要不要一起去？");
        choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 2;
        if(choice == 2) this.likePoint += 8;
        if(choice == 3) this.likePoint += 4;
        System.out.println("同桌：(笑著點頭說) 可以啊，把一點時間分給你，好期待阿。");
    }

    public void DAY6_health() {
        System.out.println("(你和" + this.name + "在為了學園祭做準備)");
        System.out.println("我：你怎麼了?");
        System.out.println("同桌：我剛剛裁紙條的時候不小心割到手了ＱＱ");
        System.out.println("1：用手帕幫她做簡單的包紮，並馬上舉手跟老師說要帶同桌去保健室。");
        System.out.println("2：用嘴巴吸住她的手指幫她止血，再帶她去保健室包紮。");
        int choice = scanner.nextInt();
        if(choice == 1) this.likePoint += 7;
        if(choice == 2) this.likePoint -= 20;
        System.out.println("到保健室包紮完回到教室後，回到座位，同桌打算繼續把沒裁完的紙割完");
        System.out.println("同桌：謝謝你剛剛帶我去保健室");
        System.out.println("1：為甚麼裁紙條不找我幫忙。");
        System.out.println("2：下次請小心，為了準備學園祭割到手好不值得，而且我會有點心疼。並且將所有的紙條搶過來自己裁");
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
        this.type = "混混";
        this.name = "湊";
        this.likePoint = random.nextInt(11) + 50;
        this.gender = "男";
    }

    public void Day2_0800() {
        System.out.println();
        System.out.println("Day2--08:00");
        System.out.println("我：完蛋要遲到了！啊啊啊啊啊！");
        System.out.println("我：我的鬧鐘呢？怎麼沒叫？靠，我沒設到鬧鐘？！");
        System.out.println("（三分鐘之內解決刷牙洗臉換衣服）");
        System.out.println("我：我出門囉！衝啊啊啊啊啊！！！");
        System.out.println("（跑到一半，別在書包上的別針掉了下來，滾落到巷子內）");
        System.out.println("我：今天到底怎麼回事啊！水逆嗎？");
        System.out.println("我：（跑到小巷子內）怎麼回事？有人在打架？");
        System.out.println("?????：走著瞧！我們走，小弟們");
        System.out.println("???:弱者才會說這種話啦！走著瞧？哈哈！你們來幾次我打幾次");
        System.out.println("（一群被打的十分狼狽的人從我身旁跑過）");
        System.out.println("我：我是不是也該閃了！別針嘛！之後再找就好了！嗯對！就這麼決定");
        System.out.println("我：可是那個人沒事嗎？他只有一個人而已欸？");
        System.out.println("我：啊啊！不想了！直接走我一定會後悔！");
        System.out.println("（小心翼翼的走過去）");
        System.out.println("我：那個...你沒事吧！ 欸？你不是我們班的嗎？你怎麼會在這裡打架？快遲到了欸！");
        System.out.println("湊：怕遲到你倒是走啊！");
        System.out.println("1：不行，我不能把你丟在這裡");
        System.out.println("2：哦好！那我走了！");
        int choice = scanner.nextInt();
        if(choice == 1) {
            likePoint += 10;
            System.out.println("我：蛤？你以為你誰啊？我應該沒跟你好到這種程度吧？");
            System.out.println("我：話不能這樣講啊！今天被我看到了！我就是要管，不然我會良心不安的，況且你是我同學");
            System.out.println("湊：好笑，那你就良心不安吧！我的事你別管了，小心引火上身");
            System.out.println("我：都什麼時候了還關心我");
            System.out.println("湊：誰他媽關心你！呃......");
        }
        else if(choice == 2) {
            likePoint -= 10;
            System.out.println("我：慢走不送");
            System.out.println("湊：你真的沒事吧？");
            System.out.println("我：你吵死了！");
            System.out.println("湊：噢！我閉嘴");
        }
        System.out.println("（只見他沿著牆壁緩緩的跌坐）");
        System.out.println("我：你果然受傷了吧！我扶你，你起得來嗎？");
        System.out.println("湊：別碰我！不想被我打的話就走開");
        System.out.println("我：哎呀！這種時候就別倔了啦！不然我陪你坐在這，等你好一點我們再走");
        System.out.println("湊：不是怕遲到？遲到就不要怪在我身上！");
        System.out.println("我：不會啦！我又不是那種人！我就不能是因為擔心你才留下來的嗎？");
        System.out.println("湊：用不著你來擔心");
        System.out.println("我：決定了！你這樣也沒辦法去學校對吧！那我送你回家！");
        System.out.println("湊：蛤？我才不需要你陪，我自己能走");
        System.out.println("（他突然站了起來）");
        System.out.println("我：欸！不要勉強啦！讓我扶你");
        System.out.println("湊：就叫你別他媽碰我");
        System.out.println("我：好好好～我不碰 我不碰");
        System.out.println("湊：那還不快走，去你的學校");
        System.out.println("我：我偏不！我一定要送你到家才走！這是我的堅持！！");
        System.out.println("湊：隨便吧！煩死了！");
        System.out.println("（跟著他走到他家）");
        System.out.println("湊的母親：啊嘞！小湊湊怎麼今天這麼早就回來？");
        System.out.println("湊的母親：欸！你還帶朋友回來喔！媽媽我好感動～嗚嗚嗚 我家小湊湊終於有朋友了！");
        System.out.println("湊：講過多少次了別在別人面前這樣叫我！還有他不是我朋友");
        System.out.println("我：（小湊湊～噗）那個，阿姨您好！我只是負責送他回來的同學而已啦！");
        System.out.println("湊的母親：啊！別在外面說了！進來喝杯茶嗎？");
        System.out.println("我：那就麻煩您了！");
        System.out.println("湊：我什麼時候同意你進我家了？");
        System.out.println("湊的母親：小湊湊不可以這樣喔！人家專程你回來欸");
        System.out.println("湊：媽的！我要回房間了！");
        System.out.println("我：那我還是不要打擾你們好了");
        System.out.println("湊的母親：不好意思啊！他的本性不壞的，唉…都是因為我");
        System.out.println("湊的母親：那個...我能拜託你一件事嗎？希望你可以接受");
        System.out.println("我：？");
        System.out.println("湊的母親：你能跟他做朋友嗎？這孩子從小就沒什麼朋友");
        System.out.println("湊的母親：我只希望那一天我不在了能有個人陪著他");
        System.out.println("湊的母親：啊！好像有點太沉重了！對不起啊");
        System.out.println("我：我答應您～");
        System.out.println("湊的母親：欸！真的嗎？謝謝你啊！那他就拜託你了！");
        System.out.println("我：前提是他想跟我做朋友啦！不然我會很尷尬的");
        System.out.println("湊的母親：他應該是想的喔！這可是他第一次帶同學回家呢！呵呵");
        System.out.println("湊的母親：那就麻煩你囉！再見");
        System.out.println("我：嗯，阿姨再見");
        System.out.println("（原來我是第一個啊！莫名的很開心呢～ 不對！我為什麼會有這種想法出現？我到底怎麼了？）");
    }
}

class Character5 extends SubCharacter {
    public Character5(Game game, MainCharacter mainCharacter) {
        super(game, mainCharacter);
        this.game = game;
        this.mainCharacter = mainCharacter;
        this.type = "姊姊";
        this.name = "default";
        this.likePoint = random.nextInt(21) + 60;
        this.gender = "女";
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
