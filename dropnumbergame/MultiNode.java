
package dropnumbergame;

/**
* @file MLinkedList.java
* @description This project is a game in which the number given by the user is
* added to the desired position in a 5x7 game table, if there is an element in
* that position, it is added on top of it, and the overlapping values are
* combined when they are the same. When 7 elements are in a row, the game is
* over and no more values are added.
* @assignment DropNumberGame
* @date 23.03.2023
* @author Beyza Yıldızlı beyzayildizli10@gmail.com
*/

public class MultiNode {
    int data;
    int location;
    MultiNode previous;
    MultiNode next;
    MultiNode upper;
    MultiNode bottom;

    public MultiNode(int data, int location) {
        this.data = data;
        this.location = location;
        this.next = null;
        this.previous = null;
        this.upper = null;
        this.bottom = null;
    }
}