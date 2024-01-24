package pokepoke.pokemoncharactergame;

// 자식 객체로 추상화하는 패턴 (Interface 추상화의 기본 방향과는 맞지 않음)
public interface IContinentCrossable extends IFlyable, ISurfable{
    @Override
    default void fly() {

    }

    @Override
    default void surf() {

    }

    default void crossOcean(ICrossable crossable) {
        crossable.crossOcean();
    }
}
