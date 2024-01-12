package nestedclasssample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Doe");
// 각 요소를 출력하는 람다 표현식
        names.forEach(name -> System.out.println(name));

        List<String> numbers = Arrays.asList("1", "2", "3");
        List<Integer> numberString = numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
