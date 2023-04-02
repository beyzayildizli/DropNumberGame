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
public class MLinkedList {

    MultiNode head;
    MultiNode second;
    MultiNode third;
    MultiNode fourth;
    MultiNode tail;
    boolean gameContinues = true;

    /*
    Oyun devam ettiği sürece eklenecek elemanı ve ekleneceği sütunu(1-5) alan ve
    linkedListe ekleyen metod:
    İlk olarak girilen sütunun en altındaki pointerı kontrol eder. Boş ise o pointera
    değeri atar ve sol ve sağ tarafında kendine en yakın null olmayan diğer pointerlarla
    bağlanır. Değilse bulunduğu sütundaki pointerın üstüne eklemek için addUp fonksiyonunu
    kullanır
    */
    
    void add(int element, int location) {
        add(new MultiNode(element, location));
    }

    private void add(MultiNode newNode) {
        if (gameContinues != false) {
            switch (newNode.location) {
                case 1 -> {
                    if (head == null) {
                        head = newNode;
                        //sağ tarafı bağla:
                        if (second != null) {
                            connectNodeHorizontally(head, second);
                        } else if (third != null) {
                            connectNodeHorizontally(head, third);
                        } else if (fourth != null) {
                            connectNodeHorizontally(head, fourth);
                        } else if (tail != null) {
                            connectNodeHorizontally(head, tail);
                        }
                    } else {
                        //üste ekle:
                        addUp(newNode.data, head);
                    }
                }
                case 2 -> {
                    if (second == null) {
                        second = newNode;
                        //sol tarafı bağla:
                        if (head != null) {
                            connectNodeHorizontally(head, second);
                        }
                        //sağ tarafı bağla:
                        if (third != null) {
                            connectNodeHorizontally(second, third);
                        } else if (fourth != null) {
                            connectNodeHorizontally(second, fourth);
                        } else if (tail != null) {
                            connectNodeHorizontally(second, tail);
                        }
                    } else {
                        //üste ekle:
                        addUp(newNode.data, second);
                    }
                }
                case 3 -> {
                    if (third == null) {
                        third = newNode;
                        //sol tarafı bağla:
                        if (second != null) {
                            connectNodeHorizontally(second, third);
                        } else if (head != null) {
                            connectNodeHorizontally(head, third);
                        }
                        //sağ tarafı bağla:
                        if (fourth != null) {
                            connectNodeHorizontally(third, fourth);
                        } else if (tail != null) {
                            connectNodeHorizontally(third, tail);
                        }
                    } else {
                        //üste ekle
                        addUp(newNode.data, third);
                    }
                }
                case 4 -> {
                    if (fourth == null) {
                        fourth = newNode;
                        if (third != null) {
                            connectNodeHorizontally(third, fourth);
                        } else if (second != null) {
                            connectNodeHorizontally(second, fourth);
                        } else if (head != null) {
                            connectNodeHorizontally(head, fourth);
                        }
                        //sağ tarafı bağla:
                        if (tail != null) {
                            connectNodeHorizontally(fourth, tail);
                        }
                    } else {
                        //üste ekle
                        addUp(newNode.data, fourth);
                    }
                }
                case 5 -> {
                    if (tail == null) {
                        tail = newNode;
                        //sol tarafı bağla:
                        if (fourth != null) {
                            connectNodeHorizontally(fourth, tail);
                        } else if (third != null) {
                            connectNodeHorizontally(third, tail);
                        } else if (second != null) {
                            connectNodeHorizontally(second, tail);
                        } else if (head != null) {
                            connectNodeHorizontally(head, tail);
                        }
                    } else {
                        //üste ekle:
                        addUp(newNode.data, tail);
                    }
                }
                default -> {
                    System.out.print("1 ve 5 aralığında değer verilebilir.");
                }
            }
        }
    }

    //Bu metod iki pointerı yatayda bağlarken kullanılır:
    private void connectNodeHorizontally(MultiNode first, MultiNode second) {
        second.previous = first;
        first.next = second;
    }

    /*
    Bu metodda konumun sütun yüksekliği hesaplanır ve üst node'un yeni node ile
    aynı verilere sahip olup olmadığı kontrol edilir.
        • Veriler farklı ise verilen özelliklerde oluşturulan node çift yönlü
    olarak üste bağlanır.
        • Veriler aynı ise yeni bir node oluşturulmadan en üstteki node'un
    verisi 2 ile çarpılır. Daha sonra bir alt öge, sütun sayısı kadar iç içe
    geçmiş öğelerle farklılık gösterene kadar kontrol edilir. Değerler aynı
    olduğunda, ifSameWithBottom(MultiNode node) metodu kullanılır.
     */
    private void addUp(int number, MultiNode location) {
        MultiNode up = location;
        int upNo = 1;
        while (up.upper != null) {
            up = up.upper;
            upNo++;
        }

        if (up.data == number) {
            switch (upNo) {
                case 1 -> {
                    location.data = number * 2;
                }
                case 2 -> {
                    location.upper.data = number * 2;
                    if (isSameWithBottom(location.upper)) {
                        ifSameWithBottom(location.upper);
                    }
                }
                case 3 -> {
                    location.upper.upper.data = number * 2;
                    if (isSameWithBottom(location.upper.upper)) {
                        ifSameWithBottom(location.upper.upper);
                        if (isSameWithBottom(location.upper)) {
                            ifSameWithBottom(location.upper);
                        }
                    }
                }
                case 4 -> {
                    location.upper.upper.upper.data = number * 2;
                    if (isSameWithBottom(location.upper.upper.upper)) {
                        ifSameWithBottom(location.upper.upper.upper);
                        if (isSameWithBottom(location.upper.upper)) {
                            ifSameWithBottom(location.upper.upper);
                            if (isSameWithBottom(location.upper)) {
                                ifSameWithBottom(location.upper);
                            }
                        }

                    }
                }
                case 5 -> {
                    location.upper.upper.upper.upper.data = number * 2;
                    if (isSameWithBottom(location.upper.upper.upper.upper)) {
                        ifSameWithBottom(location.upper.upper.upper.upper);
                        if (isSameWithBottom(location.upper.upper.upper)) {
                            ifSameWithBottom(location.upper.upper.upper);
                            if (isSameWithBottom(location.upper.upper)) {
                                ifSameWithBottom(location.upper.upper);
                                if (isSameWithBottom(location.upper)) {
                                    ifSameWithBottom(location.upper);
                                }
                            }

                        }
                    }
                }
                case 6 -> {
                    location.upper.upper.upper.upper.upper.data = number * 2;
                    if (isSameWithBottom(location.upper.upper.upper.upper.upper)) {
                        ifSameWithBottom(location.upper.upper.upper.upper.upper);
                        if (isSameWithBottom(location.upper.upper.upper.upper)) {
                            ifSameWithBottom(location.upper.upper.upper.upper);
                            if (isSameWithBottom(location.upper.upper.upper)) {
                                ifSameWithBottom(location.upper.upper.upper);
                                if (isSameWithBottom(location.upper.upper)) {
                                    ifSameWithBottom(location.upper.upper);
                                    if (isSameWithBottom(location.upper)) {
                                        ifSameWithBottom(location.upper);
                                    }
                                }

                            }
                        }
                    }
                }
                default -> {
                }
            }
        } else {
            MultiNode newNode = new MultiNode(number, location.location);
            switch (upNo) {
                case 1 -> {
                    connectWithUp(location, newNode);
                }
                case 2 -> {
                    connectWithUp(location.upper, newNode);
                }
                case 3 -> {
                    connectWithUp(location.upper.upper, newNode);
                }
                case 4 -> {
                    connectWithUp(location.upper.upper.upper, newNode);
                }
                case 5 -> {
                    connectWithUp(location.upper.upper.upper.upper, newNode);
                }
                case 6 -> {
                    connectWithUp(location.upper.upper.upper.upper.upper, newNode);
                    gameContinues = false;
                }
                default -> {
                }
            }
        }
    }

    /*
    Bu metod ile bir alttaki node'un datası ikiye katlanır. En üstteki node,
    altındaki node ile tüm bağlantıları silerek listeden kaldırılır. Ardından
    Java Garbage Collector node'u tamamen silecektir.
     */
    private void ifSameWithBottom(MultiNode node) {
        //alttakini 2katına çıkar
        node.bottom.data = (node.data) * 2;
        //üsttekini listeden ayır
        node.bottom.upper = null;
        node.bottom = null;
        node.upper = null;
    }

    //bu metod verilen node'un altındaki node ile eşit olup olmadığını kontrol eder.
    private boolean isSameWithBottom(MultiNode node) {
        return node.bottom.data == node.data;
    }

    /*
    Bu metod verilen oldUp nodunun üstüne newNode bağlanır. En üst node'un
    üstüne yeni bir node eklerken kullanılır.
     */
    private void connectWithUp(MultiNode oldUp, MultiNode newNode) {
        oldUp.upper = newNode;
        newNode.bottom = oldUp;
    }

    //verilen pointerın bulunduğu sütundaki elemanları alttan üste doğru ekrana basar.
    private void printColumn(MultiNode location) {
        if (location != null) {
            MultiNode mn = location;
            System.out.print(mn.data + " ");
            while (mn.upper != null) {
                mn = mn.upper;
                System.out.print(mn.data + " ");
            }
            System.out.println();
        } else {
            System.out.print("-\n");
        }
    }

    //Tüm LinkedList'i ekrana basar.
    public void print() {
        if (gameContinues == false) {
            System.out.println("Game over, final list:");
        }
        if (head != null) {
            printColumn(head);
        } else {
            System.out.print("-\n");
        }
        if (second != null) {
            printColumn(second);
        } else {
            System.out.print("-\n");
        }
        if (third != null) {
            printColumn(third);
        } else {
            System.out.print("-\n");
        }
        if (fourth != null) {
            printColumn(fourth);
        } else {
            System.out.print("-\n");
        }
        if (tail != null) {
            printColumn(tail);
        } else {
            System.out.print("-\n");

        }

    }
}