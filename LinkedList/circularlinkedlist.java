public class circularlinkedlist {
    Node head;
    Node tail;
    private class Node {
        String val;
        Node next ;

        Node(String data){
           this. val = data;
        }
    }
    private void insert(String data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            tail = node;
            node.next = head;
            return;
        }
        else{
            node.next = head;
            tail.next = node;
            tail = node;
        }
    }
    private void print(){
        Node node = head;
        if(head == null){
            System.out.println("empty");
        }
        else{
            System.out.print(node.val);
            node = node.next;
            while(node != head){
                System.out.print("->" + node.val);
                node = node.next;
            }
        }
    }
    public static void main(String[] args) {
        circularlinkedlist list = new circularlinkedlist();
        list.insert("fist");
        list.insert("2nd");
        list.insert("last");

        list.print();

    }
}
