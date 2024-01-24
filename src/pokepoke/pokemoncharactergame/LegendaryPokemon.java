package pokepoke.pokemoncharactergame;

public class LegendaryPokemon extends PokemonStruct{
    private static LegendaryPokemon lugia = null;

    public LegendaryPokemon(String monsterName, int maxHp, String skill1Name, int skill1Dmg) {
        super(monsterName, maxHp, skill1Name, skill1Dmg);
    }

    private LegendaryPokemon(String monsterName, String nickName, int maxHp, String skill1Name, int skill1Dmg) {
        super(monsterName, nickName, maxHp, skill1Name, skill1Dmg);
    }

    public static LegendaryPokemon getLugia() {
        if (lugia == null){
            lugia = new LegendaryPokemon(
                    "Lugia", "Legend Lugia", 30_000,
                    "눈보라", 3000
            );
            return lugia;
        }
        return null;
    }

    public static LegendaryPokemon getDuplicateLugia() {
        if (lugia == null){
            lugia = new LegendaryPokemon(
                    "Lugia", "Legend Lugia", 30_000,
                    "눈보라", 3000
            );
        }
        return lugia;
    }


    public String getMonsterName() {
        return super.getMonsterName();
    }

    public int getHp() {
        return super.getHp();
    }

    public int getMaxHp() {
        return super.getMaxHp();
    }

    public String getSkill1Name() {
        return super.getSkill1Name();
    }

    public int getSkill1Dmg() {
        return super.getSkill1Dmg();
    }

    public void setMonsterName(String monsterName) {
        super.setMonsterName(monsterName);
    }

    public void setHp(int hp) {
        super.setHp(hp);
    }

    public void setMaxHp(int maxHp) {
        super.setMaxHp(maxHp);
    }

    public void setSkill1Name(String skill1Name) {
        super.setSkill1Name(skill1Name);
    }

    public void setSkill1Dmg(int skill1Dmg) {
        super.setSkill1Dmg(skill1Dmg);
    }

    public String getNickName() {
        return super.getNickName();
    }

    public void setNickName(String nickName) {
        super.setNickName(nickName);
    }

    @Override
    public void attack(PokemonStruct targetPokemon) {
        if (targetPokemon.getHp() > 0) {
            // 피카츄 공격 후 구구 Hp 표시
            System.out.println(this.getNickName() + "(이)가" + targetPokemon.getNickName()+ "을 공격합니다.");
            System.out.println(this.getSkill1Name() + "기술을 사용합니다.");
            targetPokemon.setHp(targetPokemon.getHp()-this.getSkill1Dmg());
            System.out.println(targetPokemon.getNickName() + "남은 HP:" + targetPokemon.getHp());
            if (targetPokemon.getHp() <= 0) {
                System.out.println(targetPokemon.getNickName() + "이 항복했습니다.");
            }
        }
        System.out.println("-------------------------------------");
    }
}
