package boj;

import java.util.Scanner;

public class boj21611 {
    // 마법사 상어와 블리자드
    public static void main(String[] args) {

    }

    public static void inputMethod(Scanner scanner) {

    }



}

class Board {
    int size;
    Room[][] roomArray;

    public Board(int number) {
        this.size = number;
        roomArray = new Room[number][number];
    }
}

class Shark {
    int[] coordinate;
    Board board;
    public Shark(int[] coordinate, Board board) {
        this.coordinate = coordinate;
        this.board = board;
    }
    public void blizard(int way, int distance) {
        // 1이면

    }




}

class Room {
    int number;
    public Room(int number) {
        this.number = number;
    }
}