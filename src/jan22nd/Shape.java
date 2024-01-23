package jan22nd;

public sealed class Shape permits Circle, Square{
}

final class Circle extends Shape{}

final class Square extends Shape {}


// sealed zmffotmdml gyrhk
//상속 계층 구조를 특정 범위까지만 허용하는 효과를 가져온다.
//final class Cube extends Shape{} << 이게 금지됨