package pokepoke.pokemoncharactergame;

public class PokemonBattleStruct {
    // 기능을 중심으로 묶었더니 한계가 있더라
    String monster1Name;
    int monster1hp;
    String monster1skill1Name;
    int monster1skill1Dmg;

    String monster2Name;
    int monster2hp;
    String monster2skill1Name;
    int monster2skill1Dmg;

    public PokemonBattleStruct(String monster1Name, int monster1hp,
                               String monster1skill1Name, int monster1skill1Dmg,
                               String monster2Name, int monster2hp,
                               String monster2skill1Name, int monster2skill1Dmg)
    {
        this.monster1Name = monster1Name;
        this.monster1hp = monster1hp;
        this.monster1skill1Name = monster1skill1Name;
        this.monster1skill1Dmg = monster1skill1Dmg;
        this.monster2Name = monster2Name;
        this.monster2hp = monster2hp;
        this.monster2skill1Name = monster2skill1Name;
        this.monster2skill1Dmg = monster2skill1Dmg;
    }

    public void pokemonBattleInStruct()
    {
        boolean surrenderAny = false;
        while (!surrenderAny) {
            if (this.monster1hp > 0) {
                // 피카츄 공격 후 구구 Hp 표시
                System.out.println(this.monster1Name + "(이)가" + this.monster2Name+ "을 공격합니다.");
                System.out.println(this.monster1skill1Name + "기술을 사용합니다.");
                this.monster2hp -= this.monster1skill1Dmg;
                System.out.println(this.monster2Name + "남은 HP:" + this.monster2hp);
                if (this.monster2hp <= 0) {
                    surrenderAny = true;
                    System.out.println(this.monster2Name + "이 항복했습니다.");
                }
            } else {
                surrenderAny = true;
                System.out.println(this.monster2Name + "이 항복했습니다.");
            }
            System.out.println("-------------------------------------");
            if (!surrenderAny) {
                if (this.monster1hp > 0) {
                    // 구구 공격 후 피카츄 Hp 표시
                    System.out.println(this.monster2Name + "(이)가" + this.monster1Name+ "을 공격합니다.");
                    System.out.println(this.monster2skill1Name + "기술을 사용합니다.");
                    this.monster1hp -= this.monster2skill1Dmg;
                    System.out.println(this.monster1Name + "남은 HP:" + this.monster1hp);
                    if (this.monster1hp <= 0) {
                        surrenderAny = true;
                        System.out.println(this.monster1Name + "이 항복했습니다.");
                    }
                } else {
                    surrenderAny = true;
                    System.out.println(this.monster1Name + "이 항복했습니다.");
                }
                System.out.println("-------------------------------------");
            }
        }
    }
    public void pokemonSpecialBattleInStruct()
    {
        boolean surrenderAny = false;
        while (!surrenderAny) {
            if (this.monster1hp > 0) {
                // 피카츄 공격 후 구구 Hp 표시
                System.out.println(this.monster1Name + "(이)가" + this.monster2Name+ "을 공격합니다.");
                System.out.println(this.monster1skill1Name + "기술을 사용합니다.");
                this.monster2hp -= this.monster1skill1Dmg * 2;
                System.out.println(this.monster2Name + "남은 HP:" + this.monster2hp);
                if (this.monster2hp <= 0) {
                    surrenderAny = true;
                    System.out.println(this.monster2Name + "이 항복했습니다.");
                }
            } else {
                surrenderAny = true;
                System.out.println(this.monster2Name + "이 항복했습니다.");
            }
            System.out.println("-------------------------------------");
            if (!surrenderAny) {
                if (this.monster1hp > 0) {
                    // 구구 공격 후 피카츄 Hp 표시
                    System.out.println(this.monster2Name + "(이)가" + this.monster1Name+ "을 공격합니다.");
                    System.out.println(this.monster2skill1Name + "기술을 사용합니다.");
                    this.monster1hp -= this.monster2skill1Dmg;
                    System.out.println(this.monster1Name + "남은 HP:" + this.monster1hp);
                    if (this.monster1hp <= 0) {
                        surrenderAny = true;
                        System.out.println(this.monster1Name + "이 항복했습니다.");
                    }
                } else {
                    surrenderAny = true;
                    System.out.println(this.monster1Name + "이 항복했습니다.");
                }
                System.out.println("-------------------------------------");
            }
        }
    }

    public void pokemonSpecialBattle2InStruct()
    {
        boolean surrenderAny = false;
        while (!surrenderAny) {
            if (this.monster1hp > 0) {
                // 피카츄 공격 후 구구 Hp 표시
                System.out.println(this.monster1Name + "(이)가" + this.monster2Name+ "을 공격합니다.");
                System.out.println(this.monster1skill1Name + "기술을 사용합니다.");
                this.monster2hp -= this.monster1skill1Dmg * 2;
                System.out.println(this.monster2Name + "남은 HP:" + this.monster2hp);
                if (this.monster2hp <= 0) {
                    surrenderAny = true;
                    System.out.println(this.monster2Name + "이 항복했습니다.");
                }
            } else {
                surrenderAny = true;
                System.out.println(this.monster2Name + "이 항복했습니다.");
            }
            System.out.println("-------------------------------------");
            if (!surrenderAny) {
                if (this.monster1hp > 0) {
                    // 구구 공격 후 피카츄 Hp 표시
                    System.out.println(this.monster2Name + "(이)가" + this.monster1Name+ "을 공격합니다.");
                    System.out.println(this.monster2skill1Name + "기술을 사용합니다.");
                    this.monster1hp -= this.monster2skill1Dmg / 2;
                    System.out.println(this.monster1Name + "남은 HP:" + this.monster1hp);
                    if (this.monster1hp <= 0) {
                        surrenderAny = true;
                        System.out.println(this.monster1Name + "이 항복했습니다.");
                    }
                } else {
                    surrenderAny = true;
                    System.out.println(this.monster1Name + "이 항복했습니다.");
                }
                System.out.println("-------------------------------------");
            }
        }
    }
}
