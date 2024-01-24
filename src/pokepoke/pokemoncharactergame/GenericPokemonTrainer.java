package pokepoke.pokemoncharactergame;

import java.util.ArrayList;
import java.util.List;

public class GenericPokemonTrainer<POKEMON_TYPE extends PokemonStruct> {
    // 제네릭 타입 선언 시, 타입 힌트를 제공해 사용 가능한 타입의 범위를 제한한다.
    private String name;
    private List<POKEMON_TYPE> capturedPokemons;

    public GenericPokemonTrainer(String name) {
        this.name = name;
        this.capturedPokemons = new ArrayList<>();
    }

//    public void captureNewPokemonInList(PokemonStruct newPokemon) { // 너무 일반적인 타입을 파라미터로 받을 수 없게 됨
    public void captureNewPokemonInList(POKEMON_TYPE newPokemon) { // 너무 일반적인 타입을 파라미터로 받을 수 없게 됨
        int currentSize = capturedPokemons.size();
        capturedPokemons.add(newPokemon);
        // 아래 Generic 타입에서 메서드를 호출하기 위해서는 추가적인 타입 힌트가 필요함
        System.out.println(newPokemon.getNickName() + "을 " + currentSize + "번지에 담았습니다.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<POKEMON_TYPE> getCapturedPokemons() {
        return capturedPokemons;
    }
}
