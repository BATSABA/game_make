class Character2 extends SubCharacter {
    public Character2(Game game, MainCharacter mainCharacter) {
        super(game, mainCharacter);
        this.mainCharacter = mainCharacter;
        this.type = "同桌";
        this.name = "default";
        this.likePoint = random.nextInt(21) + 50;
        this.gender = "男";
    }

    public void someEvent() {

    }
}