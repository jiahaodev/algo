package stack;

/**
 * 基于链表实现的栈。
 *
 * Author: JiahaoWu
 */
public class StackBasedOnLinkedList {
    private Node top = null;  //栈中，核心的是栈顶元素

    public void push(int value) {
        Node newNode = new Node(value,null);
        // 判断是否栈空
        if (top == null) {
            top = newNode;
        }else{
            newNode.next = top;  //新节点要指向上一个节点，即上一个top节点。保持与之前的联系
            top = newNode;
        }
    }

  /**
   * 我用-1表示栈中没有数据。
   */
  public int pop() {
      if (top == null) {
          return -1;
      }
      int value = top.data;
      top = top.next;
      return value;
  }

  public void printAll() {
    Node p = top;
    while (p != null) {
      System.out.print(p.data + " ");
      p = p.next;
    }
    System.out.println();
  }

  private static class Node {
    private int data;
    private Node next;

    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }

    public int getData() {
      return data;
    }
  }
}
