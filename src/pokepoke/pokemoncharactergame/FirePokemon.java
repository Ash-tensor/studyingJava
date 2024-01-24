package pokepoke.pokemoncharactergame;

public class FirePokemon extends PokemonStruct{
    public FirePokemon(String monsterName, int maxHp,
                       String skill1Name, int skill1Dmg) {
        super(monsterName, maxHp, skill1Name, skill1Dmg);
    }

    public FirePokemon(String monsterName, String nickName, int maxHp,
                       String skill1Name, int skill1Dmg) {
        super(monsterName, nickName, maxHp, skill1Name, skill1Dmg);
    }
}
