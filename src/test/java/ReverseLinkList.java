/**
 * Class
 *
 * @author andrew
 * @date 2020/2/12
 */
public class ReverseLinkList {

    public static void main(String[] args) {

        LinkNode n1 = new LinkNode(1,null);
        LinkNode n2 = new LinkNode(2,null);
        LinkNode n3 = new LinkNode(3,null);
        LinkNode n4 = new LinkNode(4,null);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        display(n1);
        reverse2(n1);
        System.out.println("");
        display(n4);
    }

    /**
     * 递归反转链表
     * @param node
     * @return
     */
    public static LinkNode reverse(LinkNode node) {

        if(node==null||node.next==null){
            return node;
        }
        LinkNode pre = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return pre;

    }

    /**
     * 非递归反转链表
     * @param node
     */
    public static void reverse2(LinkNode node){
        LinkNode pre = null;
        LinkNode cur = node;
        while(cur!=null){
            LinkNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }
    }

    public static void display(LinkNode node){
        while(node!=null){
            System.out.print(node.data+"->");
            node = node.next;
        }
    }





    }
