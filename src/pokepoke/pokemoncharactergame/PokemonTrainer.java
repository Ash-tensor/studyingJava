package pokepoke.pokemoncharactergame;

import java.util.ArrayList;
import java.util.List;

public class PokemonTrainer {
    private String name;
    private PokemonStruct[] pokemonCaptured;
    private List<PokemonStruct> capturedPokemonList;
    private String trainerType;
    private List<WaterPokemon> capturedWaterPokemonList;
    private List<FirePokemon> capturedFirePokemonList;

    public PokemonTrainer(String name) {
        this.name = name;
        this.capturedPokemonList = new ArrayList<>();
    }

    public PokemonTrainer(String name, PokemonStruct[] pokemonCaptured) {
        this.name = name;
        this.pokemonCaptured = pokemonCaptured;
    }

    public PokemonTrainer(String name, String trainerType) {
        this.name = name;
        this.trainerType = trainerType;
        if (trainerType.equals("Water")) {
            this.capturedWaterPokemonList = new ArrayList<>();
        } else if (trainerType.equals("Fire") ) {
            this.capturedFirePokemonList = new ArrayList<>();
        }
        // 개선방법 1. 각각의 타입을 Enum 을 사용해서 쉽게 순회해 볼까?
        // => Enum 을 쓰는 경우에도 순회가 필요함
        // 개선방법 1-2. 타입 검사하는 코드를 분리해서 별도 메서드로 다루면 코드가 간결해지겠네?
        // => 타입별 개별 몬스터 슬롯 필드를 사용하는 것에는 개선이 없다.
        // 개선방법 2. 제네릭을 적용해야 한다.
        // => 타입명도 파라미터로 받아서 사용하면 되겠다.
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PokemonStruct[] getPokemonCaptured() {
        return pokemonCaptured;
    }

    public List<PokemonStruct> getCapturedPokemonList() {
        return capturedPokemonList;
    }

    //    public void setPokemonCaptured(PokemonStruct[] pokemonCaptured) {
//        this.pokemonCaptured = pokemonCaptured;
//    }

    public void captureNewPokemon(PokemonStruct newPokemon) {
        // PokemonStruct[] 으로도 문제를 해결해야 한다.
//        System.out.println(pokemonCaptured.length); 현재 길이 정보로는 해결하기 어려웠다.
        // 배열에서 초기화하지 않은 위치
        // -> 참조 자효형의 경우 null, 기본 자료형의 경우 해당 자료형의 부정표현 (0, 0.0, false)
        int count = 0;
        for (PokemonStruct pokemonSlot : pokemonCaptured) {
            if (pokemonSlot == null) {
                pokemonCaptured[count] = newPokemon;
                System.out.println(newPokemon.getNickName() + "을 " + count + "번지에 담았습니다.");
                return;
            }
            count++;
        }
        System.out.println(newPokemon.getNickName() + "을 담을 공간이 없습니다.");
        // List<> or ArrayList<>
    }

    public void captureNewPokemonInList(PokemonStruct newPokemon) {
        int currentSize = capturedPokemonList.size();
        capturedPokemonList.add(newPokemon);
        System.out.println(newPokemon.getNickName() + "을 " + currentSize + "번지에 담았습니다.");
    }


}
