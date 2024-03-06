package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class boj12100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<node> nodeList = new ArrayList<>();

    }
}
class node {
    node[][] model;
    int value;
    int[] coordinate;

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
                targetNode.leftMove();
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
                targetNode.rightMove();
            }
        }
    }
    public void upMove() {
        if (upCheck() == 1) {
            int temp = this.value;
            node targetNode = this.model[this.coordinate[0]][this.coordinate[1]];
        }

    }
    public void downMove() {}

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
        // 문제 공간은 정사각형 형태이고 가장 오른쪽에 위치해 있을 때
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
    public int downCHeck() {
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
    ArrayList<node> nodeList;

    public board(int value, ArrayList<node> nodeList) {
        this.model = new node[value][value];
        this.nodeList = nodeList;
    }


    public void setModel(node[][] model) {
        this.model = model;
    }

    public void boardUpdate() {

    }
    public node[][] getModel() {
        return model;
    }
    public void left() {
        for(node[] x : this.model){
            for (node y : x) {
                // 왼쪽 노드를 확인해서 비어있는게 false가 될 때까지 이동
                while(y.leftCheck()) {
                    y.

                }
            }
        }
//        모든 블록이 왼편으로 감
//

    }
    public void right() {

    }
    public void up() {

    }
    public void down() {

    }

}
