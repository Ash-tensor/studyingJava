package boj;

import java.util.*;

public class boj1935 {
    public static void main(String[] args) {
        solve();

    }
    public static void solve() {
        Scanner scanner = new Scanner(System.in);
        int quest = scanner.nextInt();
        scanner.nextLine();

//        int quest = 5;

        Map<String, Double> operandMap = new HashMap<>();


        char[] operator = {'*', '+', '-', '/'};

        List<Character> operators = new ArrayList<>();
        for (char c : operator) {
            operators.add(c);
        }

        String questLine = scanner.nextLine();
//        String questLine = "ABC*+DE/-";

        // ABC*+DE/-



        char[] questArray = questLine.toCharArray();


        Stack<String> questStack = new Stack<>();
//        StringBuilder answer = new StringBuilder();


        for (int i = 0; i < questLine.length(); i++) {
            if (operators.contains(questArray[i])) {
                // questArray[I] 가 연산자이면

                switch(questArray[i]) {
                    case '*' :
                        String temp1 = questStack.pop();
                        String temp2 = questStack.pop();

                        Double operand1 = operandMap.get(temp2);
                        Double operand2 = operandMap.get(temp1);

                        Double tempAnswer = operand1 * operand2;
                        questStack.push(tempAnswer.toString());
                        operandMap.put(tempAnswer.toString(), tempAnswer);
                        break;

                    case '-' :
                        String temp3 = questStack.pop();
                        String temp4 = questStack.pop();

                        Double operand3 = operandMap.get(temp4);
                        Double operand4 = operandMap.get(temp3);

                        Double tempAnswer1 = operand3 - operand4;
                        questStack.push(tempAnswer1.toString());
                        operandMap.put(tempAnswer1.toString(), tempAnswer1);
                        break;

                    case '+' :
                        String temp5 = questStack.pop();
                        String temp6 = questStack.pop();

                        Double operand5 = operandMap.get(temp6);
                        Double operand6 = operandMap.get(temp5);

                        Double tempAnswer2 = operand5 + operand6;
                        questStack.push(tempAnswer2.toString());
                        operandMap.put(tempAnswer2.toString(), tempAnswer2);
                        break;

                    case '/' :
                        String temp7 = questStack.pop();
                        String temp8 = questStack.pop();

                        Double operand7 = operandMap.get(temp8);
                        Double operand8 = operandMap.get(temp7);

                        Double tempAnswer3 = operand7 / operand8;
                        questStack.push(tempAnswer3.toString());
                        operandMap.put(tempAnswer3.toString(), tempAnswer3);
                        break;
                }
            }
            else {
                //string / char 여서 같지 않다고 나옴
                if(operandMap.containsKey(Character.toString(questArray[i]))) {
                    questStack.push(Character.toString(questArray[i]));

                }
                else {
                Double temp = scanner.nextDouble();
                scanner.nextLine();

                operandMap.put(Character.toString(questArray[i]), temp);
                questStack.push(Character.toString(questArray[i]));
                }
            }
        }

        String answer = questStack.pop();
        Double finalAnswer = Double.parseDouble(answer);
        System.out.print(String.format("%.2f", finalAnswer));


//        System.out.print(finalAnswer);
    }
}
