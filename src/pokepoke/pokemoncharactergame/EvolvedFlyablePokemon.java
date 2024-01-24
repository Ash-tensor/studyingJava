package pokepoke.pokemoncharactergame;

//public class EvolvedFlyablePokemon extends EvolvedPokemonStruct implements IFlyable, ICrossable{
public class EvolvedFlyablePokemon extends EvolvedPokemonStruct implements IFlyable {
    public EvolvedFlyablePokemon(String monsterName, int maxHp,
                                 String skill1Name, int skill1Dmg,
                                 String skill2Name, int skill2Dmg) {
        super(monsterName, maxHp, skill1Name, skill1Dmg, skill2Name, skill2Dmg);
    }

    public EvolvedFlyablePokemon(String monsterName, String nickName, int maxHp,
                                 String skill1Name, int skill1Dmg,
                                 String skill2Name, int skill2Dmg) {
        super(monsterName, nickName, maxHp, skill1Name, skill1Dmg, skill2Name, skill2Dmg);
    }

    @Override
    public void fly() {
        System.out.println(this.getMonsterName()+" (이)가 하늘을 날아서 바다를 건넙니다.");
    }

    @Override
    public void crossOcean() {
        fly();
    }
}
