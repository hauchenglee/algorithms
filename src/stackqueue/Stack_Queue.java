package stackqueue;

public class Stack_Queue {
    // no.1 ref
    private Node first = null;

    public class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /* stack: last in first out LIFO 角度是時間 */
    /* queue: first in first out LIFO 角度是位置 */
    public void push(String item) {
        /*
                  // save a link to the last node
                  Node oldLast = last;

                  // create a new node for the end
                  last = new Node();
                  last.item = item;
                  last.next = null;

                  // special cases for empty queue
                  if (isEmpty()) first = last;

                  // link the new node to the end of the list
                  else oldLast.next = last;
         */

        Node oldFirst = first; //保存要關聯的現在節點，在stack是以時間次序規則為first，queue則是列隊位置為last
        first = new Node(); // 建立新的節點
        first.item = item; // 跟queue一樣
        first.next = oldFirst; // first of next，就是時間的上一個（過去）節點

        // 不一樣的地方

        //if (isEmpty()) first = last;
        //else oldLast.next = last;
    }

    public String pop() {
        /*
                  // save item to return
                  String item = first.item;

                  // delete first node
                  first = first.next;

                  // special cases for empty queue
                  if (isEmpty()) last = null;

                  //  return saved item
                  return item;
         */

        String item = first.item;
        first = first.next;
        return item;

        // 這裡queue有檢查null

        //if (isEmpty()) last = null;
        //return item;
    }
}
