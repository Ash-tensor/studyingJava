package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class boj12100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<node> nodeList = new ArrayList<>();
        node[][] inputModel = gameSetter(scanner);
        board Board = new board(inputModel);


        while (true) {
            System.out.println("왼쪽 0, 오른쪽 1, 위 2, 아래 3");
            int condition = scanner.nextInt();
            switch (condition) {
                case 0 :
                    Board.left();
                    break;
                case 1 :
                    Board.right();
                    break;
                case 2 :
                    Board.up();
                    break;
                case 3 :
                    Board.down();
                    break;
            }
            System.out.println();
            Board.printBoard();
        }
    }
    public static node[][] gameSetter(Scanner scanner) {
        int boardSize = scanner.nextInt();
        scanner.nextLine();

        node[][] tempBoard = new node[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++) {
            for (int k = 0; k < boardSize; k++) {
                int[] coordinate = {i, k};
                int tempValue = scanner.nextInt();
                node tempNode = new node(tempValue, coordinate, tempBoard);
            }
            scanner.nextLine();
        }
        return tempBoard;
    }

}
class node {
    node[][] model;
    int value;
    int[] coordinate;
// 생성자임
    public node(int value, int[] coordinate, node[][] model) {
        this.model = model;
        this.value = value;
        this.coordinate = coordinate;
        this.model[coordinate[0]][coordinate[1]] = this;
    }
    // 그런데 그러면 board를 업데이트해야함
    public void leftMove() {
        if (leftCheck() == 1){
            // 왼쪽으로 갈 수 있으면 왼쪽으로 감
//            this.coordinate[0] -= 1; << 이런식으로 직접 노드를 옮겨서는 안 됨.
            // value를 좌측으로 옮기고 이 노드의 value는 0이 되어야 함.
            // 각 체크의 결과는 1 0 value의 값이 나옴, 1인 경우는 옮길 수 있고, 0인 경우는 못옮김
            int temp = this.value;
            this.value = 0;
            // 이 노드의 값을 0으로 초기화하고
            // 좌측이므로
            node targetNode = this.model[this.coordinate[0]][this.coordinate[1] - 1];
            // 좌측 노드의 값을 이 노드의 값으로 치환함
            targetNode.value = temp;
            // 그리고 그 노드가 왼쪽 끝까지 가야하기 때문에 연쇄적으로 leftMove콜을 함
            targetNode.leftMove();
        }
        else if (leftCheck() == 0) {
        }
        else {
            // 만약 왼편에 존재하는 노드가 값을 가지고 있는 노드의 경우에는
            // << 현재 노드의 값과 같으면 합쳐진다
            node targetNode = this.model[this.coordinate[0]][this.coordinate[1] - 1];
            if (targetNode.value == this.value) {
                targetNode.value = targetNode.value * 2;
                this.value = 0;

                // 보니까 한번만 합쳐지는것같음 모든 블록은 한번만 합쳐져야하기때문에 합친 후에는 연쇄콜을 하면 안됨
//                targetNode.leftMove();
            }
        }
    }
    public void rightMove() {
        // leftMove와 작동방식이 같기 때문에 굳이 주석은 적지 않겠다
        if (rightCheck() == 1) {
            int temp = this.value;
            node targetNode = this.model[this.coordinate[0]][this.coordinate[1] + 1];
            targetNode.value = temp;
            this.value = 0;
            targetNode.rightMove();
        } else if (rightCheck() == 0) {}
        else {
            node targetNode = this.model[this.coordinate[0]][this.coordinate[1] + 1];
            if (targetNode.value == this.value) {
                targetNode.value = targetNode.value * 2;
                this.value = 0;
//                targetNode.rightMove();
            }
        }
    }
    public void upMove() {
        if (upCheck() == 1) {
            int temp = this.value;
            node targetNode = this.model[this.coordinate[0] - 1][this.coordinate[1]];
            targetNode.value = temp;
            this.value = 0;
            targetNode.upMove();
        } else if (upCheck() == 0) {}
        else {
            node targetNode = this.model[this.coordinate[0] - 1][this.coordinate[1]];
            if (targetNode.value == this.value) {
                targetNode.value = targetNode.value * 2;
                this.value = 0;
//                targetNode.upMove();
            }
        }
    }
    public void downMove() {
//        downCheck는 0이면 움직일 수 없는 곳, 1이면 움직일 수 있는 곳,
        if (downCheck() == 1) {
            int temp = this.value;
            node targetNode = this.model[this.coordinate[0] + 1][this.coordinate[1]];
            targetNode.value = temp;
            this.value = 0;
            targetNode.downMove();
        } else if (downCheck() == 0) {}
//        1도 0도 아닌 정수값인경우
        else {
            node targetNode = this.model[this.coordinate[0] + 1][this.coordinate[1]];
            if (targetNode.value == this.value) {
                targetNode.value = targetNode.value * 2;
                this.value = 0;
//                targetNode.downMove();
            }
        }

    }
    public int leftCheck() {
        int xIndex = this.coordinate[0];
        int yIndex = this.coordinate[1];
        if (yIndex == 0) {
            return 0;
            // 0 이면 불가능함
        }
        else {
            if (this.model[xIndex][yIndex - 1].value == 0) {
                return 1;
                // 1이면 옮길 수 있음
            }
            else {
                return this.model[xIndex][yIndex - 1].value;
                // 모두 아닌 경우에는 그 노드의 값을 리턴함
            }
        }
    }
    public int rightCheck() {
        int xIndex = this.coordinate[0];
        int yIndex = this.coordinate[1];
        // 문제 공간은 정사각형 형태이고 가장 오른쪽에 위치해 있을 때이고
        // length는 index보다 1높게 나오므로 1빼줘야함 ㅇㄱㄹㅇ
        if (yIndex == this.model[0].length - 1) {
            return 0;
        }
        else {
            if (this.model[xIndex][yIndex + 1].value == 0) {
                //오른쪽 노드가 공노드이면
                return 1;
            }
            else {
                return this.model[xIndex][yIndex + 1].value;
            }
        }
    }
    public int upCheck() {
        int xIndex = this.coordinate[0];
        int yIndex = this.coordinate[1];
        if (xIndex == 0) {
            //위로 더 이상 올라갈 수 없으면
            return 0;
        }
        else {
            if (this.model[xIndex - 1][yIndex].value == 0) {
                return 1;
            }
            else {
                return this.model[xIndex - 1][yIndex].value;
            }
        }
    }
    /**
     * 아래로 움직일 수 있는지 아닌지를 검사하는 함수임
     *
     * @return 아래로 움직일 수 있으면 0, 아래로 움직일 수 없으면 1, 다른 값이면 해당 노드의 값을 리턴
     */
    public int downCheck() {
        int xIndex = this.coordinate[0];
        int yIndex = this.coordinate[1];
        if (xIndex == this.model[0].length - 1) {
            //아래로 더 이상 내려갈 수 없으면
            return 0;
        }
        else {
            if (this.model[xIndex + 1][yIndex].value == 0) {
                return 1;
            }
            else {
                return this.model[xIndex + 1][yIndex].value;
            }
        }
    }
}
class board {
    node[][] model;

    public board(node[][] inputModel) {
        //정사각형이니까
        this.model = inputModel;
    }
    public void printBoard() {
        for (node[] x : model) {
            for (node y : x) {
                System.out.printf("%d ", y.value);
            }
            System.out.println();
        }
    }


    public void setModel(node[][] model) {
        this.model = model;
    }
    public node[][] getModel() {
        return model;
    }

    /**
     * 모든 노드에 대해서 왼쪽 명령을 내림
     */
    public void left() {
        // 모든 노드에 대해서 왼쪽 노드로 이동
        for (node[] x : model) {
            for (node y : x) {
                y.leftMove();
            }
        }
    }
    public void right() {
        // 모든 노드에 대해서 오른쪽 노드로 이동
//        for (node[] x : model) {
//            for (node y : x) {
//                y.rightMove();
//            }
//        }
        // 근데 위의 left식으로 구현하면 안 됨, 왜냐하면 가장 오른편부터 합쳐져야 하기 때문임
        int max = model.length - 1;
        for (node[] x : model) {
            for (int i = max; i >= 0; i--) {
                x[i].rightMove();
            }
        }
    }
    public void up() {
        for (node[] x : model) {
            for (node y : x) {
                y.upMove();
            }
        }
    }
    public void down() {
//        for (node[] x : model) {
//            for (node y : x) {
//                y.downMove();
//            }
//        }

        // 근데 위의 down 식으로 구현하면 안 됨, 왜냐하면 가장 아래쪽부터 합쳐져야 하기 때문임니당
        int max = model.length - 1;
        for (int i = max; i >= 0; i--) {
            node[] targetRow = model[i];
            for (node x : targetRow) {
                x.downMove();
            }
        }
    }
}
