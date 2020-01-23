/*
 * LinkManager.java
 *
*/

import java.lang.*;
import java.util.*;
import java.io.*;

public class LinkManager { 
    
    LinkNode head = null;
    LinkedApplication myApp;
    
    /** Creates a new instance of LinkManager */
    public LinkManager(LinkedApplication a) {
        myApp = a;
    }
    
    public boolean initialize(String fileName){
        try {
            BufferedReader inStream = new BufferedReader (new FileReader(fileName)); // Create and open the stream.
            String name = "";
            String title = "";
            int sal = 0;
            int years = 0;
            String line = inStream.readLine();            // Read one line

            while (line != null) {                        // While more text
                
               name = line;

               line = inStream.readLine();               // Read next line
	       title = line;

               line = inStream.readLine();               // Read next line
               sal = Integer.parseInt(line);

               line = inStream.readLine();               // Read next line
               years = Integer.parseInt(line);
               
               LinkNode tempNode = new LinkNode(name, title, sal, years); 
               insert (tempNode);
               
               line = inStream.readLine();            // Read one line
        }
            inStream.close();   // Close the stream
            return true;
        }
    
        catch (java.io.FileNotFoundException e) {
            myApp.displayText("IOERROR: File NOT Found: " + fileName + "\n");
            return false; // invalid operation
            //e.printStackTrace();
        } 
        catch (java.io.IOException e) {
            myApp.displayText("IOERROR: " + e.getMessage() + "\n");
            return false; // invalid operation
            //e.printStackTrace();
        }
    }
    
    public boolean isEmpty()  {
        return head == null;
    }
    
    public void insert(LinkNode newNode) { 
        if (isEmpty()) 
            head = newNode; // Insert at head of list
        else {
            LinkNode current = head;   // Start traversal at head
            while (current.getNext() != null) // While not at the last node
            {
                current = current.getNext();
            }  //   go to the next node
            current.setNext( newNode ); // Do the insertion
        }      
    } // insert()

    public String print() { 
        if (isEmpty()) {
            return "List is empty";
        }
        
        String listContents = "";
        LinkNode current = head;          // Start traversal at head

        while (current != null) {                     // While not at end of list
            listContents = listContents + current.getInfo() + "\n"; //   append node's data to string
            current = current.getNext();              //   go to the next node
        }       
        return listContents;

    } // print()
    
    public void sortByYears() {
        // Sorts the linked list according to years of employment (increasing order) and displays the information from the reordered list in the text area.
        LinkNode sortedYearHead = null; // temp head to be used for sorting by year.
        LinkNode current = head; // point to current node (to be added)
        LinkNode temp; // will keep location of next node to be placed from the current list
        LinkNode prevNode; // will be use in the new list ot keep track fo the node before next.
        LinkNode nextNode; // will be use in the new list ot keep track fo the node after previous.
        
        while (current != null) { // visit each node in the original list
            if (sortedYearHead == null) { // if there are no nodes in new list
                sortedYearHead = current; // set location to new node.
                head = current; //assign head of list to current node.
                temp = current.getNext(); // remember first node in the rest of the OG list.
                current.setNext(null); // severs link to next item in list.
                current = temp; // set current back to next node to be placed, and keep while loop active.
            } //end if
            
            else if (current.getYears() < head.getYears()) { // place node at front
                temp = current.getNext(); // set temp to next node
                head = current; // place new node at head of list
                head.setNext(sortedYearHead);
                sortedYearHead = head; // reassign new sorted year head.
                current = temp; // set current back to next node to be placed, and keep while loop active.
            } // end else if
            
            else  { // node needs to be placed at the middle or end of the list.
                temp = current.getNext(); // Keep the rest of the list.
                prevNode = sortedYearHead; // set pre to head of the list.
                nextNode = sortedYearHead.getNext(); // set next to node after head.
                
                while ((nextNode != null) && (current.getYears() > nextNode.getYears())) {
                    prevNode = nextNode;
                    nextNode = nextNode.getNext();
                }
                
                if (nextNode == null ) {
                    prevNode.setNext(current);
                    current.setNext(null);
                    current = temp;
                    
                }
                else { // add to middle. Place current between prevnode and nextnode
                    current.setNext(nextNode);
                    prevNode.setNext(current);
                    current = temp;
                }
            } // end else   
        }
    }
    // TODO: sortByName, sortByTitle, sortByTitleAndSalary.
    public void sortByName() { // Sorts the linked list alphabetical by name.
        LinkNode sortedNameHead = null; // temp head to be used for sorting by year.
        LinkNode current = head; // point to current node (to be added)
        LinkNode temp; // will keep location of next node to be placed from the current list
        LinkNode prevNode; // will be use in the new list ot keep track fo the node before next.
        LinkNode nextNode; // will be use in the new list ot keep track fo the node after previous.
        
        while (current != null) { // visit each node in the original list
            if (sortedNameHead == null) { // if there are no nodes in new list
                sortedNameHead = current; // set location to new node.
                head = current; //assign head of list to current node.
                temp = current.getNext(); // remember first node in the rest of the OG list.
                current.setNext(null); // severs link to next item in list.
                current = temp; // set current back to next node to be placed, and keep while loop active.
            } //end if
            
            else if (current.getName().compareTo(head.getName()) < 0) { // place node at front
                temp = current.getNext(); // set temp to next node
                head = current; // place new node at head of list
                head.setNext(sortedNameHead);
                sortedNameHead = head; // reassign new sorted year head.
                current = temp; // set current back to next node to be placed, and keep while loop active.
            } // end else if
            
            else  { // node needs to be placed at the middle or end of the list.
                temp = current.getNext(); // Keep the rest of the list.
                prevNode = sortedNameHead; // set pre to head of the list.
                nextNode = sortedNameHead.getNext(); // set next to node after head.
                
                while ((nextNode != null) && (current.getName().compareTo(nextNode.getName()) > 0 )) {
                    prevNode = nextNode;
                    nextNode = nextNode.getNext();
                }
                
                if (nextNode == null ) {
                    prevNode.setNext(current);
                    current.setNext(null);
                    current = temp;
                    
                }
                else { // add to middle. Place current between prevnode and nextnode
                    current.setNext(nextNode);
                    prevNode.setNext(current);
                    current = temp;
                }
            } // end else   
        }
    }
    
    public void sortByTitleAndSalary() {
        
    }
    // TODO: addItem, removeItem.
    
    public void addItem(String nameInput, String titleInput, String salaryInput, String yearsInput) {  // When adding a node, you will need to ask the user to enter all required information for that node.
        try {
            String name = nameInput;
            String title = titleInput;
            int sal = Integer.parseInt(salaryInput);
            int years = Integer.parseInt(yearsInput);
           
            LinkNode addNode = new LinkNode(name, title, sal, years); 
            insert (addNode);
        }
        catch (NumberFormatException e) {
            myApp.displayText("Invalid Data for Add");
        }
    }   
    public void removeItem(String nameInput, String titleInput, String salaryInput, String yearsInput) {
        String name = nameInput;
        String title = titleInput;
        int sal = Integer.parseInt(salaryInput);
        int years = Integer.parseInt(yearsInput);
        
        LinkNode removeNode = new LinkNode(name, title, sal, years);
        
        LinkNode current = head; // point to current node (to be added)
        LinkNode temp; // will keep location of next node to be placed from the current list
        LinkNode prevNode; // will be use in the new list ot keep track fo the node before next.
        LinkNode nextNode; // will be use in the new list ot keep track fo the node after previous.
        
        if( (removeNode.getName().compareTo(current.getName()) == 0) &&
            (removeNode.getTitle().compareTo(current.getTitle()) == 0) &&
            (removeNode.getSalary() == current.getSalary()) &&
            (removeNode.getYears() == current.getYears())
            ){
            head = head.getNext();   
        }
        
        // TODO: finish this.
        
    }
}
