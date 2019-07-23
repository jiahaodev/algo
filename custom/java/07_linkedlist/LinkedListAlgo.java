package linkedlist;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 *
 * Author: Zheng
 */
public class LinkedListAlgo {

    //单链表反转
    public static Node reverse(Node list){
        Node cur = list;
        Node pre = null;
        Node next = null;
        while(cur!= null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

    //链表中的环检测
    //思路：快慢指针，无论奇偶，经过“两圈”后，都相遇与开始节点
    //https://leetcode-cn.com/problems/linked-list-cycle/submissions/
    public static boolean checkCircle(Node list){
        if (list == null) return false;
        Node fast = list;
        Node slow = list;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) return true;
        }  
        return false;
    }

    //两个有序的链表的合并
    public static Node mergeSortedLists(Node la,Node lb){
        if(la == null) return lb;
        if(lb == null) return la;
        Node p = la;
        Node q = lb;
        Node head;
        //确定头结点，谁小选谁
        if(p.data < q.data){
            head = p;
            p = p.next;
        }else{
            head = q;
            q = q.next;
        }

        //一个遍历指针
        Node r = head;

        //连接中间节点，谁小谁优先
        while(p!=null && q!=null){
            if(p.data < q.data){
                r.next = p;
                p = p.next;
            }else{
                r.next = q;
                q = q.next;
            }
            r = r.next; //往下走
        }

        //考虑长度不相同的情况下，下一个节点应该选谁
        if( p!= null){
            r.next = p;
        }else{
          r.next = q;
        }

        return head;
    }

    //删除倒数第k个节点
    //todo： 有待理解
    public static Node deleteLastKth(Node list,int k){
        Node fast =  list;
        int i = 1;
        //先走(k-1)步。 倒数节点从1开始数，1,2,3，...，k-1
        while(fast != null && i < k){
            fast = fast.next;
            i++;
        }
        if(fast == null) return list;

        Node slow = list;
        Node prev = null;
        while(fast.next != null){
            fast = fast.next;
            prev = slow; //记录前继节点，用于删除
            slow = slow.next;
        }
        if(prev == null){
            list = list.next;
        }else{
            prev.next = prev.next.next;
        }
        return list;
    }
    

    //求中间节点
    public static Node findMiddleNode(Node list){
        if(list == null) return null;
        Node fast = list;
        Node slow = list;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }



    public static void printAll(Node list){
        Node p = list;
        while(p!=null){
            System.out.print(p.data + " ");
        }
        System.out.println();
    }

    public static class Node{
      public int data;
      public Node next;
      public Node(int data,Node next){
          this.data = data;
          this.next = next;
      }
    }

}
