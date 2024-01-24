package pokepoke.pokemoncharactergame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PokemonLuncher {
    public static void main(String[] args) {
        // 여기는 태초마을 입니다.
        System.out.println("태초마을에 오신 것을 환영합니다.");
        // 피카츄 만들기
        PokemonStruct pikachu = new PokemonStruct("Pikachu", "myPikachu", 50, "백만볼트", 20);
        // 꼬부기 만들기
        PokemonStruct kkobugi = new PokemonStruct("Kkobugi", "myKkobugi", 60 ,"물대포", 15);
//        System.out.printf("name: %s, hp: %d, skill: %s, damage: %d \n", kkobugi.monsterName, kkobugi.getHp(), kkobugi.skill1Name, kkobugi.skill1Dmg);
//        System.out.println(pikachu);
//        System.out.println(kkobugi);

        // 구구 만들기
        PokemonStruct gugu = new PokemonStruct("Gugu", "myGugu",30, "부리로 쪼기", 10);
        // 꼬렛 만들기
        PokemonStruct kkoret = new PokemonStruct("kkoret", "myKKoret", 40 ,"깨물기", 10);
//        System.out.printf("name: %s, hp: %d, skill: %s, damage: %d \n", kkoret.monsterName, kkoret.getHp(), kkoret.skill1Name, kkoret.skill1Dmg);
//        System.out.println(gugu);
//        System.out.println(kkoret);

        // 구조체를 기능 단위로 통합해볼까?
//        PokemonBattleStruct battleData = new PokemonBattleStruct(
//                "Kkobugi", 60 ,"물대포", 15,
//                "kkoret", 40 ,"깨물기", 10
//        );
        // 배틀 수행 후
//        pokemonObjectUnitBattle(kkobugi, kkoret);
//        // 회복 센터로 갑니다.
////        pokemonHealingCenter(kkobugi);
        kkobugi.visitHealingCenter();

        // PokemonStruct 클래스 말고, EvolvedPokemon 으로 따로 만들어 볼까?
        kkobugi.getSkill1Name();
//        kkobugi.getSkill2Name();

        // 진화한 포켓몬을 별도 클래스로 분리하여 재선언
        EvolvedPokemon unibugiNoInherit = new EvolvedPokemon(
                "어니부기", 120,
                "물대포", 15,
                "거품광선", 30
        );
//        pokemonObjectUnitBattle(unibugi, kkoret);  // 같은 종류의 (계보의) 객체끼리 동일하게 다루지 못하는 부작용
        // EvolvedPokemon is a PokemonStruct
        // 상속 형태로 클래스(객체)를 확장해서,
        // 확장될 필요가 있을 때만 확장된 클래스를 사용하자.

        // 불법 진화 포켓몬 생산 (진화형부터 바로 만들어버림) -> 로켓단
        EvolvedPokemonStruct unibugi = new EvolvedPokemonStruct(
                "어니부기", null, 120,
                "물대포", 15,
                "거품광선", 30
        );

//        pokemonObjectUnitBattle(unibugi, kkoret);
//
        PokemonStruct[] ppippiArray = new PokemonStruct[10];
        PokemonStruct[] purinArray = new PokemonStruct[10];
        for (int i = 0; i<10; i++) {
            if (i % 2 == 0) {
                ppippiArray[i] = new PokemonStruct("Ppippi", "삐삐"+i, 100, "손가락 흔들기", 0);
                purinArray[i] = new PokemonStruct("Purin", "푸린"+i, 100, "노래부르기", 0);
            } else {
                ppippiArray[i] = new PokemonStruct("Ppippi","삐삐"+i, 100, "손가락 흔들기", 0).evolve();
                purinArray[i] = new PokemonStruct("Purin", "푸린"+i, 100, "노래부르기", 0).evolve();
            }
        }  // 클래스가 적용된 자체로 인해서 여러 종류 포켓몬은 기본적으로 같이 다룰 수가 있다.
        // 이종 모음 배열 준비 완료

        // 포켓몬 도감 사용하기 (Map 자료형 만들고 이종 데이터 값을 가져오기)
        // toString 이 적절하게 오버라이드 된 상속 클래스 만들기
//        PokemonStruct pikachuInDogam = PokemonStruct.pokeDex.get("Pikachu");
//        System.out.println(PokemonStruct.pokeDex.get("Pikachu"));
//        System.out.println(PokemonStruct.pokeDex.get("Unibugi"));
//        System.out.println(PokemonStruct.pokeDex.get("Ppippi"));
//        System.out.println(PokemonStruct.pokeDex.get("Purin"));

        // 진화 도감에서 데이터를 조회해 보자
//        String evolveName = PokemonStruct.pokeEvolveDex.get(pikachuInDogam.getMonsterName());
//        System.out.println(evolveName);
//
//        System.out.println(PokemonStruct.pokeEvolveDex.get("Purin"));
//        System.out.println(PokemonStruct.pokeEvolveDex.get("Ppippi"));
//
//        String evolvedFormName = PokemonStruct.pokeEvolveDex.get("Purin");
//        PokemonStruct evolvedInfoObj = PokemonStruct.pokeDex.get(evolvedFormName);
//        System.out.println(evolvedInfoObj);
//
//
//        System.out.println(Arrays.toString(ppippiArray));
        // 이종 타입을 모두 포함하는 배열
        // 이미 진화를 마친 삐삐와 푸린 (픽시, 푸크린) -> 섞여 있으면 어떻게하지?

        PokemonStruct[] evolvedPpippiArray = new PokemonStruct[10];
        int count = 0;
        for (PokemonStruct ppippiOrPixy : ppippiArray) {
            if (PokemonStruct.pokeEvolveDex.get(ppippiOrPixy.getMonsterName()) == null) {
                evolvedPpippiArray[count] = ppippiOrPixy;
            } else {
                evolvedPpippiArray[count] = ppippiOrPixy.evolve();
            }
            System.out.println(evolvedPpippiArray[count]);
            count++;
        }
        System.out.println(Arrays.toString(evolvedPpippiArray));

        PokemonStruct.groupEvolve(ppippiArray);
        PokemonStruct.groupEvolve(purinArray);





        List<PokemonStruct> evolvedPpippiList = new ArrayList<>();

        // null이면 진화하는건가? 몰?루겠네

        List<PokemonStruct> newPpippiArray = Arrays.asList(ppippiArray);
        List<PokemonStruct> firstFilterArray = newPpippiArray.stream().filter(x -> PokemonStruct.pokeEvolveDex.get(x.getMonsterName()) != null).peek(x -> evolvedPpippiList.add(x)).collect(Collectors.toList());
        System.out.println(firstFilterArray);

        List<PokemonStruct> secondFilterArray = newPpippiArray.stream().filter(x -> PokemonStruct.pokeEvolveDex.get(x.getMonsterName()) == null).peek(x -> evolvedPpippiList.add(x.evolve())).collect(Collectors.toList());
        System.out.println(secondFilterArray);
//        System.out.println(newPpippiArray);






        EvolvedFlyablePokemon flyablePokemon = new EvolvedFlyablePokemon(
                "Pigeon", "myPigeon", 300,
                "날개치기", 50,
                "전광석화", 100
        );
//        flyablePokemon.fly();

        EvolvedSurfablePokemon surfablePokemon = new EvolvedSurfablePokemon(
                "Lapras", "myLapras", 300,
                "물대포", 50,
                "등딱지에 숨기", 0
        );
//        surfablePokemon.surf();

        EvolvedPokemonStruct randomPokemon = new EvolvedPokemonStruct(
                "LaprasMutant", "myLaprasMutant", 300,
                "물대포", 50,
                "등딱지에 숨기", 0
        );

//        randomPokemon.crossOcean();
//        EvolvedPokemonStruct.crossOceanOptions(randomPokemon);
//        EvolvedPokemonStruct.crossOceanOptions(surfablePokemon);
//        EvolvedPokemonStruct.crossOceanOptions(flyablePokemon);

//        EvolvedPokemonStruct.crossOcean2(surfablePokemon);
//        EvolvedPokemonStruct.crossOcean2(flyablePokemon);

        // 싱긅톤으로 선언된 전설의 포켓몬이 중복 생성되는 것은 막을 수 있지만, 중복 참조되는 것은 막지 못한 모습
        // 중복 참조까지 막을 수 있는 방법이 필요함.
        LegendaryPokemon lugiaEncounterd = LegendaryPokemon.getLugia();
//        System.out.println(lugiaEncounterd);
//        LegendaryPokemon lugiaObtained = LegendaryPokemon.getLugia();
        LegendaryPokemon lugiaObtained = LegendaryPokemon.getDuplicateLugia();
//        System.out.println(lugiaObtained);

        PokemonStruct.pokemonObjectUnitBattle(lugiaObtained, lugiaEncounterd);

    }

    // 구조체를 사물 단위로 묶어서 동작과 함께 다루면 어떨까? => 클래스의 개념이 정립됨.
    public static void pokemonObjectUnitBattle (PokemonStruct pokemon1, PokemonStruct pokemon2){
        while (pokemon1.getHp() >= 0 && pokemon2.getHp() >= 0) {
            // 테스트 코드 (HP를 조절해보자)
            pokemon1.attack(pokemon2);
            if (pokemon2.getHp()>0) {
                pokemon2.attack(pokemon1);
            }
        }
    }

    // 합의되지 않은 방법으로, 일관적이지 않게 객체 데이터를 접근하고 수정하는 방식
    // Encapsulation 을 적용해서 사라짐
//    public static void pokemonHealingCenter (PokemonStruct pokemon1) {
//        if (pokemon1.monsterName == "kkobugi"){
//            pokemon1.getHp() = 60;
//        } else if (pokemon1.monsterName == "kkoret") {
//            pokemon1.getHp() = 40;
//        }
        // 꼬부기는 최대 HP 가 60인데, 그 이상으로 제어가 됨.
        // 그 외의 다른 포켓몬 (HP max 200) 의 경우에는 정해진 최대치 회복이 안됨.
        // 일관적인 동작도 안되고, 개별적인 상황도 반영을 하기가 어려워 졌다.

//        // 1. 객체 내에 모든 동작을 집어넣자. (= 바깥에서 하지 말자)
//        System.out.println("회복 전" +pokemon1.monsterName+ " HP:" + pokemon1.getHp());
//        pokemon1.visitHealingCenter();
//        System.out.println("회복 후" +pokemon1.monsterName+ " HP:" + pokemon1.getHp());

        // 2. 객체 데이터 수정 자체를 객체에 약속된 동작 방식 외로는 불가능하게 하자
//        pokemon1.hp += 100; // <=  자꾸만 왼쪽처림 약속을 위반하는 코드를 짜는 개발자들이 발생
        // Encapsulation -> 캡슐화 : 객체 내부의 데이터를 외부에서 접근 불가능하게 감싸기
//        pokemon1.setHp(pokemon1.getHp()+100);
//        pokemon1.setHp(pokemon1.getMaxHp());
        // 합의되지 않은, 의도하지 않은 로직이 코드 내에 산개해서 유지보수를 방향하는 상황이 예방된다.
//    }
}
