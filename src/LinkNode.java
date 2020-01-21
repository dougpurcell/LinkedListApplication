/*
 * LinkNode.java
 *
 */


public class LinkNode {
    
    private String empName;
    private String jobTitle;
    private int salary;
    private int yearsEmp;
    private LinkNode next;
    
  
    public LinkNode(String name, String title, int sal, int years) { 
        empName = name;
        jobTitle = title;
        salary = sal;
        yearsEmp = years;
        next = null;
    } // LinkNode()
  
    public void setNext(LinkNode nextPtr) {
        next = nextPtr;
    } 
  
    public LinkNode getNext() {
        return next;
    } 
    
    public String getInfo()
    {
        return empName + "\t" + jobTitle + "\t"+ salary + "\t" + yearsEmp;
    }
    
    public int getYears(){
        return yearsEmp;
    }
    public int getSalary(){
        return salary;
    }
    public String getTitle() {
        return jobTitle;
    }
    public String getName() {
        return empName;
    }
}
