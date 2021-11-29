
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Win 8.1
 */
public class Main {

    public static ArrayList<Person> people = new ArrayList<>();
    
   

    public static void main(String[] args) throws Exception {
       
         Scanner input = new Scanner(System.in);
         
        retraivePeople();
        System.out.println("ID :  ");
        String ID = input.next();
        System.out.println("First name  : ");
        String Fname = input.next();
        System.out.println("Last name  : ");
        String Lname = input.next();
        System.out.println("Password  : ");
        String passward = input.next();
        System.out.println("Phone number  :   ");
        String phoneNo = input.next();
        System.out.println("Birth of Date :    ");
        String birthDate = input.next();
        System.out.println("Address : ");
        String Address = input.next();
        
       
        Customer customer = new Customer();
        System.out.println(customer.makePayment(400));
        
   boolean DataIsValid = checkData(ID, Fname, Lname, passward, phoneNo, birthDate, Address);
   if (DataIsValid){
       System.out.println("Account has been created!");
   }
       
  
    }

    private static void retraivePeople() throws Exception {
        File file = new File("People.txt");
        if (!file.exists()) {
            System.out.println("People.txt File Dose not exists");
            System.exit(0);
        }
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            Person obj = Person.createFromString(input.nextLine());
            people.add(obj);
        }
    }

    private static void savePeople() {
        try {
            PrintWriter out = new PrintWriter("People.txt");
            for (int i = 0; i < people.size(); i++) {
                out.println(people.get(i).createToString());
            }
            out.close();
        } catch (FileNotFoundException ex) {
        }
    }
    
   
 


    public static boolean checkData(String ID, String Fname, String Lname, String passward, String phoneNo, String birthDate, String Address) {
        //check Id;
        if (!(Checker.isOnlyNumbers(ID) && Checker.isExactLength(ID, 10))) {
            System.out.println("it must exacly 10 numbers!"); 
            return false;
        }

        //check Fname;
        if (!(Checker.isOnlyLetters(Fname) && !Checker.isEmpty(Fname))) {
            System.out.println("Only letters Allowed!");
            return false;
        }
        //check Lname;
        if (!(Checker.isOnlyLetters(Lname) && !Checker.isEmpty(Lname))) {
         System.out.println("Only letters Allowed!");
            return false;

        }

        //check passward;
        if (!(Checker.isOnlyNumbersAndLetters(passward) && Checker.isMinLength(passward, 8))) {
            System.out.println("Password at least 8 characters ! ");
            return false;
        }
        //check birthDate;
        if (!Checker.isValidDate(birthDate)) {
            System.out.println("Please Enter BirthDate with this format dd-mm-yyyy");
            return false;
        }
        //check address;
        if (!Checker.isValidAddress(Address)) {
             System.out.println("Please Enter valid address! ");
            return false;
        }

        return true;
    }

}
