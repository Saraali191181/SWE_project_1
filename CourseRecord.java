/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sweproject.pkg1;
  import java.util.Vector; 
import java.util.Enumeration; 
/**
 *
 * @author hp
 */
public class CourseRecord {
    
 
private Student student; 
private Vector assignments;
CourseRecord() {assignments=new Vector();} 
public Student getStudent() {
return student;
}
public void setStudent(Student s) { 
student = s;

}

public void addAssignment(Assignment a) { 
assignments.addElement(a);
}
public Enumeration getAssignments() { 
return assignments.elements();
}

 public double average() throws NotYetSetException {

        // get all the vector elements into enumeration
        double total = 0;
        double average = 0;
        int numberOfAssignementsWithMarks = 0;
        Enumeration<Assignment> e = assignments.elements();
        // iterate untill the last element
        while (e.hasMoreElements()) {
            try {
                total += e.nextElement().getMark();
                numberOfAssignementsWithMarks++;
            } catch (Exception ex) {
               
            } 
        }
        average = total / numberOfAssignementsWithMarks;

        return average;
    }

public boolean canTakeFinalExam() {

        int count = 0;
        Enumeration<Assignment> e = assignments.elements();
        while(e.hasMoreElements()) {
            Assignment a = e.nextElement();
            try {
                a.getMark();
                count++;
            } catch (Exception ex) {
                //TODO:
            }
        }
        return count >= 3;
    }


}




