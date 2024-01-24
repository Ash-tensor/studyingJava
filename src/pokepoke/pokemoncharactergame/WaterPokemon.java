package pokepoke.pokemoncharactergame;

public class WaterPokemon extends PokemonStruct{

    public WaterPokemon(String monsterName, int maxHp,
                        String skill1Name, int skill1Dmg) {
        super(monsterName, maxHp, skill1Name, skill1Dmg);
    }

    public WaterPokemon(String monsterName, String nickName,
                        int maxHp, String skill1Name, int skill1Dmg) {
        super(monsterName, nickName, maxHp, skill1Name, skill1Dmg);
    }
}
