public class linkedL {
  Node head;

  private int size;

  linkedL() {
    this.size = 0;
  }

  class Node {
    String data;
    Node next;

    // constructer
    Node(String data) {
      this.data = data;
      this.next = null;
    }
  }

  // add-> first, last
  public void addfirst(String data) {
    size++;
    Node newnode = new Node(data);
    if (head == null) {
      head = newnode;
      return;
    }
    newnode.next = head;
    head = newnode;
  }

  public void addlast(String data) {
    size++;
    Node newnode = new Node(data);
    if (head == null) {
      head = newnode;
      return;
    }
    Node currNode = head;
    while (currNode.next != null) {
      currNode = currNode.next;
    }
    currNode.next = newnode;
  }
  // remove> first,last

  public void removefirst() {
    if (head == null) {
      System.out.println("empty");
      return;
    }
    size--;
    head = head.next;
  }

  // last
  public void removelast() {
    if (head == null) {
      System.out.println("empty");
      return;
    }
    size--;
    if (head.next == null) {
      head = null;
      return;
    }

    Node currNode = head;
    Node previouNode = null;
    while (currNode.next != null) {
      previouNode = currNode;
      currNode = currNode.next;
    }
    previouNode.next = null;
  }

  // print
  public void printlist() {
    if (head == null) {
      return;
    }
    Node currNode = head;
    while (currNode != null) {
      System.out.print(currNode.data + "-->");
      currNode = currNode.next;
    }
  }

  // reverse linked list
  public void reverse() {
    if (head == null || head.next == null) {
      return;
    }
    // reverse if linked list is not null
    Node previouNode = head;
    Node current = head.next;
    while (current != null) {
      Node newnNode = current.next;
      current.next = previouNode;
      // update
      previouNode = current;
      current = newnNode;
    }
    head.next = null;
    head = previouNode;
  }
  //reverse using resursion
   public Node reverseRecursive(Node head){
       if(head == null || head.next == null){
        return head;
       }

       Node newhead = reverseRecursive(head.next);
       head.next.next = head;
       head.next = null;
      return newhead;
   }

   //insert in between
   public void insert(String data,int postition){
    Node newnode = new Node(data);
    if(head == null){
      head = newnode;
    }
    //add first
    if(postition == 1){
      newnode.next = head;
      head = newnode;
      return;
    }
    int c = 1;
    Node previous  = head;
    while(c != postition -1){
      previous = previous.next;
      c++;
    }
    newnode.next = previous.next;
    previous.next = newnode;
   }

   //insert using recursion
   private void insertRec(String val, int index){
      insertRecursive(val,index,head);
   }
   private Node insertRecursive(String val,int index,Node head){
    if(index == 0){
      Node newnode = new Node(val);
      newnode.next = head;
      return newnode;
    }
    head.next = insertRecursive(val,index -1,head.next);
    return head;
   } 
  public int size() {
    return size;
  }

  public static void main(String[] args) {
    linkedL linkedlist = new linkedL();
    linkedlist.addfirst("done");
    linkedlist.addfirst("first job ");
    linkedlist.addlast("23/september/2023");
    linkedlist.printlist();
    System.out.println("");

    linkedlist.addfirst("garbage first");
    linkedlist.addlast("garbage last");
    linkedlist.printlist();
    System.out.println("");

    linkedlist.removefirst();
    linkedlist.printlist();
    System.out.println("");
    linkedlist.removelast();
    linkedlist.printlist();
    System.out.println("");

    System.out.println("size :" + linkedlist.size());

    linkedlist.printlist();
    System.out.println("");
    linkedlist.reverse();
    linkedlist.printlist();
    System.out.println("\nreverse using recurion..");
    linkedlist.head =linkedlist.reverseRecursive(linkedlist.head);
    linkedlist.printlist();
    System.out.println("");

    linkedlist.insert("inse4ted",4);
    linkedlist.printlist();
    System.out.println("");
    
    //inserting using recursion
    System.out.println("insert_using_recursion..>");
    linkedlist.insertRec("insertd_using_resursion", 1);
    linkedlist.printlist();
  }
}
