package pokepoke.pokemoncharactergame;

public class EarthPokemon extends PokemonStruct{
    public EarthPokemon(String monsterName, int maxHp,
                        String skill1Name, int skill1Dmg) {
        super(monsterName, maxHp, skill1Name, skill1Dmg);
    }

    public EarthPokemon(String monsterName, String nickName,
                        int maxHp, String skill1Name, int skill1Dmg) {
        super(monsterName, nickName, maxHp, skill1Name, skill1Dmg);
    }

    public void dig() {
        System.out.println("땅을 파서 대륙을 횡단합니다.");
    }
}
