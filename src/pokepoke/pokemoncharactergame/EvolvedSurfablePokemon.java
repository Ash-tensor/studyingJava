package pokepoke.pokemoncharactergame;

// Flat 한 설계를 지향하는 컨벤션 또는 프로그래밍 방법론에 따르면,
// "implements ISurfable, ICrossable" 형태로 정보가 가려지지 않게 두는 것도 바람직하다.
//public class EvolvedSurfablePokemon extends EvolvedPokemonStruct implements ISurfable, ICrossable{
public class EvolvedSurfablePokemon extends EvolvedPokemonStruct implements ISurfable {
    public EvolvedSurfablePokemon(String monsterName, int maxHp,
                                  String skill1Name, int skill1Dmg,
                                  String skill2Name, int skill2Dmg) {
        super(monsterName, maxHp, skill1Name, skill1Dmg, skill2Name, skill2Dmg);
    }

    public EvolvedSurfablePokemon(String monsterName, String nickName, int maxHp,
                                  String skill1Name, int skill1Dmg,
                                  String skill2Name, int skill2Dmg) {
        super(monsterName, nickName, maxHp, skill1Name, skill1Dmg, skill2Name, skill2Dmg);
    }

    @Override
    public void surf() {
        System.out.println(this.getMonsterName()+" (이)가 서핑으로 바다를 건넙니다.");
    }

    @Override
    public void crossOcean() {
        surf();
    }
}
