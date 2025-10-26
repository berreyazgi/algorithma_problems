package com.example;

public class LinkedList {
   Node head;
    

    static class Node {
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
    else if (o instanceof Passanger) {
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
    else  if (o instanceof Cabin_Crew) {
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
//option 4 için personları ıd lere göre liste içinde obje oluşturma
else if (o instanceof Person) {
    Person p = (Person) o;
    Node newNode = new Node(p);

    if (head == null || p.getID() < ((Person) head.data).getID()) {
        newNode.next = head;
        head = newNode;
        return;
    }

    Node current = head;
    while (current.next != null && current.next.data instanceof Person &&
           ((Person) current.next.data).getID() <= p.getID()) {

        current = current.next;
    }

    newNode.next = current.next;
    current.next = newNode;
    return;
}
  }
  //option 2 listelerdeki kişileri göstermek için
  public void displayList() {
    Node current = head;

    while (current != null) {
        Object data = current.data;

        if (data instanceof Passanger) {
            Passanger p = (Passanger) data;
            System.out.println("Name: " + p.getName() + 
                               ", Type: " + p.getType() + 
                               ", ID: " + p.getID() +
                               ", Ticket: " + p.getTicket() + 
                               ", Priority: " + p.getPriority());

        } else if (data instanceof Cabin_Crew) {
            Cabin_Crew c = (Cabin_Crew) data;
            System.out.println("Name: " + c.getName() + 
                               ", Type: " + c.getType() + 
                               ", ID: " + c.getID() +
                               ", Job: " + c.getJob() + 
                               ", Credit: " + c.getCredit());

        } else if (data instanceof LinkedList) {
            //Alt listeyi yazdır 
            ((LinkedList) data).displayList();
        }

        current = current.next;
    }
}
//option 3 için listedeki personların Idlerini bulup silme
public void deleteById(long id) {
    while (head != null && head.data instanceof Person && ((Person) head.data).getID() == id) {
        head = head.next;
    }

    Node current = head;

    //Listeyi dolaşarak aynı Id ye sahip insanları bul
    while (current != null && current.next != null) {
        if (current.next.data instanceof Person && ((Person) current.next.data).getID() == id) {
            current.next = current.next.next; // node'u atla = sil
        } else {
            current = current.next;
        }
    }
}
//aynı Id lere sahip olan personları bütün listelerden sil
public static void deleteEverywhere(LinkedList listOfLists, long id) {
    Node current = listOfLists.head;

    while (current != null) {
        if (current.data instanceof LinkedList) {
            ((LinkedList) current.data).deleteById(id);
        }
        current = current.next;
    }
}
public void reverse() {
    Node prev = null;
    Node current = head;
    Node next;

    while (current != null) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }

    head = prev;
}
//option 4 Id ye göre sıralama
public static LinkedList combineById(LinkedList listOfLists) {

    LinkedList result = new LinkedList();

    //Alt listelerdeki nesneler null olana kadar devam eder
    while (true) {
        //head yerine first kullandım listenin başını temsil etmesi için
        Person first = null; 
        Node firstListNode = null; //en küçük ıd ye sahip kişinin bulunduğu listenin Node’u

        Node current = listOfLists.head;

        // list_of_lists'in içindeki her listeyi dolaş
        while (current != null) {

            if (current.data instanceof LinkedList) {
                LinkedList subList = (LinkedList) current.data;

                // Bu alt liste boş değilse, head Person'ına bak
                if (subList.head != null && subList.head.data instanceof Person) {
                    Person candidate = (Person) subList.head.data;

                    // first henüz seçilmediyse veya daha küçük ID bulunduysa güncelle
                    if (first == null || candidate.getID() < first.getID()) {
                        first = candidate;
                        firstListNode  = current;
                    }
                }
            }

            current = current.next;
        }

        //Eğer first hala null ise tüm listeler boş demektir döngü sonlanır
        if (first == null) {
            break;
        }

        //Seçilen first Person'ı result'a ekler
         Node n = new Node(first);
        n.next = result.head;
        result.head = n;

        //Seçilen Person'ı kendi listesinden çıkar, head'i ilerlet
        LinkedList chosenList = (LinkedList) firstListNode.data;
        chosenList.head = chosenList.head.next;
    }
    result.reverse();

    return result;
}
}