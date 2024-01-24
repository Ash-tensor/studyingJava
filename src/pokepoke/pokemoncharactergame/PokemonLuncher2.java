package pokepoke.pokemoncharactergame;

import java.util.Arrays;
import java.util.List;

public class PokemonLuncher2 {
    public static void main(String[] args) {
        PokemonStruct myPikachu = new PokemonStruct("Pikachu", "myPikachu", 50, "백만볼트", 20);
        PokemonStruct myKkobugi = new PokemonStruct("Kkobugi", "myKkobugi", 60 ,"물대포", 15);
        PokemonStruct myGugu = new PokemonStruct("Gugu", "myGugu",30, "부리로 쪼기", 10);
        PokemonStruct myKkoret = new PokemonStruct("kkoret", "myKKoret", 40 ,"깨물기", 10);
//
//        System.out.println(myPikachu);
//        System.out.println(myKkobugi);
//        System.out.println(myGugu);
//        System.out.println(myKkoret);
//
//        PokemonStruct dexPikachu = PokemonStruct.pokeDex.get("Pikachu");
//        PokemonStruct dexKkobugi = PokemonStruct.pokeDex.get("Kkobugi");
//        PokemonStruct dexGugu = PokemonStruct.pokeDex.get("Gugu");
//        PokemonStruct dexKkoret = PokemonStruct.pokeDex.get("Kkoret");
//
//        System.out.println(dexPikachu);
//        System.out.println(dexKkobugi);
//        System.out.println(dexGugu);
//        System.out.println(dexKkoret);

        PokemonTrainer jiwoo = new PokemonTrainer("Jiwoo", new PokemonStruct[10]);
//        jiwoo.pokemonCaptured[0] = myPikachu;
//        jiwoo.pokemonCaptured[1] = myKkobugi;
//        jiwoo.pokemonCaptured[2] = myGugu;
//        jiwoo.pokemonCaptured[3] = myKkoret;
        jiwoo.captureNewPokemon(myPikachu);
        System.out.println(Arrays.toString(jiwoo.getPokemonCaptured()));

        PokemonTrainer leeseul = new PokemonTrainer("leeseul");
        leeseul.captureNewPokemonInList(myKkobugi);
        System.out.println(leeseul.getCapturedPokemonList());

        GenericPokemonTrainer<EarthPokemon> woong = new GenericPokemonTrainer<>("woong");
//        woong.captureNewPokemonInList(myGugu);  // 제네릭을 통한 타입 제한이 적용됨!
        EarthPokemon digda = new EarthPokemon(
                "Digda", "myDigda", 50, "땅파기", 20
        );
        woong.captureNewPokemonInList(digda);
        System.out.println(woong.getCapturedPokemons());

        List<EarthPokemon> woongsPokemons = woong.getCapturedPokemons();
        System.out.println(woongsPokemons);

        EarthPokemon woongsPokemon1 = woongsPokemons.get(0);
        System.out.println(woongsPokemon1);

        // 만약 제네릭하지 않았다면.....
        if (woongsPokemon1 instanceof EarthPokemon){
            // 확인 후에 타입이 지원하는 메서드를 호출할 수가 있었을 겁니다....
        };

        woongsPokemon1.dig();
    }
}
