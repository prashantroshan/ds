package org.example;

/** Node class **/
class Node implements Cloneable {
    int i;
    String val;
    int wt;
    Node next;
    private static int len;

    public Node(String val) {
        super();
        this.val=val;
    }

    public Node(int i, String val, int wt) {
        super();
        this.i 		= i;
        this.val 	= val;
        this.wt		= wt;
        next		= null;
    }

    public int getLen(){
        int count = 0;
        Node itr = this.deepClone();
        if (itr != null) {
            count++;
        }
        Node ll = null;
        if(itr.next != null) {
            ll = new Node(itr.next);
        }
        while (ll != null) {
            count++;
            ll = ll.next;
        }
        len = count;
        return len;
    }
    public Node() {
        super();
    }

    public Node(Node firstNode) {
        this.i 		= firstNode.i;
        this.val 	= firstNode.val;
        this.wt		= firstNode.wt;
        next		= firstNode.next;
    }

    @Override
    public String toString() {
        String str ="Node [i=" + i + ", val=" + val + ", wt=" + wt ;
        if(next == null) {
            str = str.concat(", node="+null+"]");
        } else {
            str = str.concat(", node="+next.val+"]");
        }
        return str;
    }

    protected Node deepClone() {
        Node deepCopy = null;
        Node fHead    = null;
        Node headCopy = new Node(this);
        if (headCopy != null && deepCopy == null) {
            deepCopy = new Node(headCopy);
            fHead = deepCopy;
        }
        while (headCopy.next != null) {
            Node n 			= new Node(headCopy.next);
            deepCopy.next 	=	n;
            deepCopy 		= deepCopy.next;
            headCopy 		= headCopy.next;
        }
        return fHead;
    }

    public void print()  {
        Node itrate 	= this.deepClone();
        if(itrate!=null && itrate.getLen() != 0) {
            while(itrate != null) {
                System.out.print(itrate + "-->");
                itrate = itrate.next;
            }
            System.out.println();
        }
    }
}




public class SinglyLinkedListImpl {

    private static Node linkedList;
    private static Node head;
    public SinglyLinkedListImpl() {}
    public static void main(String[] arg) {
        prepareData();
        addNode(new Node(8,"G",122));
        head.print();
        removeNode(new Node("C"));
        head.print();
        System.out.println(getIndex(new Node("C")));
        System.out.println(getIndex(new Node("G")));
        System.out.println(getNode(1));
    }

    /** Data prepared for linked list and added*/
    private static void prepareData() {
        Node f1 		= new Node(1,"A",6);
        Node f2 		= new Node(2,"B",-6);
        Node f3 		= new Node(3,"C",-12);
        Node f4        	= new Node(4,"D",8);
        Node f5        	= new Node(5,"E",4);
        Node f6        	= new Node(6,"F",9);
        addNode(f1);
        addNode(f2);
        addNode(f3);
        addNode(f4);
        addNode(f5);
        addNode(f6);
        head.print();
    }

    /** Addition of node **/
    public static void addNode(Node node) {
        Node n = new Node(node);
        if (head == null) {
            head = n;
        }

        n.next = null;
        if (linkedList == null || linkedList.getLen() == 0) {
            linkedList = n;
        } else {
            while (linkedList.next != null) {
                linkedList = linkedList.next;
            }
            if (linkedList.next == null) {
                linkedList.next = n;
            }
        }
    }

    /** removal of node */
    public static void removeNode(Node node) {
        Node fhead 		= head.deepClone();
        Node cur   		= fhead;
        Node nxt		= cur.next;
        Node prv 		= null;
        boolean isPre 	= false;
        if (fhead.getLen() == 1 && fhead.val.equalsIgnoreCase(node.val)) {
            fhead 		= null;
        } else if (fhead.getLen() == 1){
            System.out.println("No such node found!");
        } else if (fhead.val.equalsIgnoreCase(node.val)) {
            fhead 		= fhead.next;
        } else {
            while (cur != null ) {
                if (cur.val.equalsIgnoreCase(node.val)) {
                    prv.next = nxt;
                    cur = nxt;
                    isPre = true;
                    break;
                } else {
                    prv = cur;
                    cur = nxt;
                    if(cur != null) {
                        nxt = cur.next;
                    }
                }
            }
        }
        if (isPre) {
            head= fhead;
        } else {
            System.out.println("Element not found :: "+ node);
        }
    }

    /** Get indx postion */
    public static int getIndex(Node node){
        int pos 		= 0;
        Node fHead 		= head.deepClone();
        int fLen		= fHead.getLen();
        boolean	isPre 	= false;
        while (fHead != null && pos < fLen) {
            if (node.val.equalsIgnoreCase(fHead.val)) {
                isPre = true;
                break;
            }
            pos += 1;
            fHead = fHead.next;
        }
        if (isPre) {
            return pos;
        } else {
            return -1;
        }
    }
    /** Get node based on node value*/
    public static Node getNode(Node node){
        Node nde 		= null;
        int pos 		= 1;
        Node fHead 		= head.deepClone();
        int fLen		= fHead.getLen();
        while (fHead != null && pos < fLen+1) {
            if (node.val.equalsIgnoreCase(fHead.val)) {
                nde 	= fHead;
                break;
            }
            pos += 1;
            fHead = fHead.next;
        }
        return nde;
    }

    /** Get Node based on index*/
    public static Node getNode(int indx){
        Node nde 		= null;
        int pos 		= 0;
        Node fHead 		= head.deepClone();
        int fLen		= fHead.getLen();
        while (fHead != null && pos < fLen+1) {
            if (pos == indx) {
                nde = fHead;
            }
            pos += 1;
            fHead = fHead.next;
        }
        return nde;
    }
}

