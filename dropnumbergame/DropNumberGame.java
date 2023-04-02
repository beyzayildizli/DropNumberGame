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
public class DropNumberGame {

    public static void main(String[] args) {
        MLinkedList list = new MLinkedList();
         //Ödevde bize verilen değerler:
        int[][] array = {{2, 1}, {2, 4}, {4, 2}, {2, 3}, {4, 5}, {2, 2}, {4, 5},
        {8, 1}, {8, 1}, {32, 2}, {2, 3}, {64, 3}, {16, 4}, {64, 2}, {32, 3},
        {16, 1}, {16, 5}, {32, 3}, {64, 2}, {8, 4}, {4, 4}, {2, 4}, {2, 4},
        {2, 2}, {64, 3}, {32, 3}, {16, 3}, {8, 3}, {8, 3}, {4, 2}, {8, 2}};
        
        //Tüm değerleri sırayla listeye ekleyen ve her adımı ekrana basan döngü:
        for (int i = 0; i < array.length; i++) {
            list.add(array[i][0], array[i][1]);
            list.print();
            System.out.println("\n*********************************************\n");
        }

        //Yeni eleman ekleyerek oyun bittiğinde oyunun devam etmediğini görelim:
        list.add(8, 2);
        list.print();
        System.out.println("\n*********************************************\n\n\n");
        
        
        //En alt satırdaki nodeların birbirine çift yönlü bağlı olduğunu göstermek istedim:
        System.out.println("-------en alt satır arası bağlantılar:-------\n");

        System.out.println("head:" + list.head.data);
        System.out.println("head.next:" + list.head.next.data);
        System.out.println("head.next.next:" + list.head.next.next.data);
        System.out.println("head.next.next.next:" + list.head.next.next.next.data);
        System.out.println("head.next.next.next.next:" + list.head.next.next.next.next.data);

        System.out.println("\n*********************************************\n");

        System.out.println("tail:" + list.tail.data);
        System.out.println("tail.next:" + list.tail.previous.data);
        System.out.println("tail.next.next:" + list.tail.previous.previous.data);
        System.out.println("tail.next.next.next:" + list.tail.previous.previous.previous.data);
        System.out.println("tail.next.next.next.next:" + list.tail.previous.previous.previous.previous.data);

    }
}
