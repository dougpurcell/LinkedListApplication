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
            
                // TODO: start here on Thursday.
            
            } // end else   
        }
    }
    // TODO: sortByName, sortByTitle, sortByTitleAndSalary.
    public void sortByName() {
        
    }
    
    public void sortByTitle() {
        
    }
    
    public void sortByTitleAndSalary() {
        
    }
    // TODO: addItem, removeItem.
    
    public void addItem(String nameInput, String titleInput, String salaryInput, String yearsInput) {  // When adding a node, you will need to ask the user to enter all required information for that node.
        String name = nameInput;
        String title = titleInput;
        String sal = salaryInput;
        String years = yearsInput;
        
        if (name != "" && title != "" && sal != "" && years != "") {
            myApp.displayText(name + " " + title + " " + sal + " " + years);
        }
        else {
            myApp.displayText("All fields must be filled out.");
            System.out.print("All fields must be filled out.");
        }
    }   
    public void removeItem() {
        
    }
}
