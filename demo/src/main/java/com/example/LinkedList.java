package com.example;

public class LinkedList {
   Node head;
    

    class Node {
        Object data;  
        Node next;

        Node(Object data) {
            this.data = data;
        }
    }

  //Linked list e obje eklemek için method
  public void insert(Object o) {
    if (o instanceof LinkedList) {
        Node newNode = new Node(o);

        //Listenin boş olup olmadığını kontrol et
        if (head == null) {
            head = newNode;
            return;
        }

        // Değilse sona git ve ekle
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;

        return;
    }

    // Passangerları priority e göre sırala
    if (o instanceof Passanger) {
      // passanger için downcast
    Passanger p = (Passanger) o;
    Node newNode = new Node(p);

    if (head == null) {
        head = newNode;
        return;
    }

    // Eğer head Passanger değilse veya newNode daha küçük priority ise başa ekle
    if (!(head.data instanceof Passanger) || p.getPriority() < ((Passanger) head.data).getPriority()) {
        newNode.next = head;
        head = newNode;
        return;
    }

    // Linked listde sıraya ekle
    Node current = head;
    while (current.next != null && current.next.data instanceof Passanger && ((Passanger) current.next.data).getPriority() <= p.getPriority()) {

        current = current.next;
    }
    newNode.next = current.next;
    current.next = newNode;

    return;
}
    //CabinCrew u credit e göre sırala
    if (o instanceof Cabin_Crew) {
      // cabin_crew iiçin downcast
    Cabin_Crew c = (Cabin_Crew) o;
    Node newNode = new Node(c);

    if (head == null) {
        head = newNode;
        return;
    }

    //head in CabinCrew olup olmadığına veya yeni gelenin crediti daha küçükse başa ekle
    if (!(head.data instanceof Cabin_Crew) || c.getCredit() < ((Cabin_Crew) head.data).getCredit()) {
        newNode.next = head;
        head = newNode;
        return;
    }

    // Araya veya sona ekleme 
    Node current = head;
    while (current.next != null && current.next.data instanceof Cabin_Crew && ((Cabin_Crew) current.next.data).getCredit() <= c.getCredit()) {

        current = current.next;
    }

    newNode.next = current.next;
    current.next = newNode;

    return;
}
  }
  }
