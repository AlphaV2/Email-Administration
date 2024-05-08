import java.util.Random;
import java.util.Scanner;

class Emailapp{
    private String firstName;
    private String lastName;
    private String department;
    private String alternateEmail;
    private String email ;
    private String companySuffix="xyz.com";
    private int mailboxCapacity=500;
    private int defaultpasswordlength=10;
    private char[]  password;

    //constructer for first and last name
    public Emailapp(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
        System.out.println("NEW EMPLOYEE: "+this.firstName+" "+this.lastName);

    //method for calling department 
        this.department=setDepartment();
        System.out.println("Your Department is : "+ this.department);
    //call method forr random password
        this.password=generatePassword(defaultpasswordlength);
        System.out.println("your password is "+new String(this.password));
    //------------combining email----------------------
        email = firstName + "."+ lastName + "@"+department +"." +companySuffix;
        System.out.println("Your Email is  :"+ email);

}

//------------
//method for asking department
    private String setDepartment(){
    System.out.println("Department Codes: \n1.Sales \n2.Development \n3.Accounts \nEnter your Department :");
    Scanner read=new Scanner(System.in);
    int  depChoice=read.nextInt();
    if(depChoice==1){return "sales";}
    else if(depChoice==2){return "development";}
    else if(depChoice==3){return "accounts";}
    else {return "Enter valid Department";}
}
//-------generate random passsword
    private char[] generatePassword(int len) {
        String capitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallChars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String values = capitalChars + smallChars + numbers;

        Random random = new Random();

        char[] password = new char[len];

        for (int i = 0; i < len; i++) {
            password[i] = values.charAt(random.nextInt(values.length()));
        }
        return password;
    }

//---------setting mail box capacity -----------
public void setMailboxCapacity(int Capacity){
    this.mailboxCapacity = Capacity;
}
//-----------------------------set the alternate mail=-------------

public void setAlternateEmail(String altEmail){
    this.alternateEmail = altEmail;
}
//change the password
public void setpassword(String password){
    this.password=password;
}

//
public int getMailboxCapacity(){
    return mailboxCapacity;
}
//
public String getAlternateEmail(){
    return alternateEmail;
}
//
public String getPassword(){ return password; } 
public String showInfo(){ 
    return "\nDISPLAY NAME:"+ firstName+""+lastName + 
           "\nCOMPANY EMAIL:"+ email + 
           "\nMAIL-BOX CAPACITY:"+mailboxCapacity+"mb";

}
}


    
//-------------MAIN METHOD ---------------------------------------------------------
public class Email{
    public static void main(String[] args){
        Emailapp em1=new Emailapp("John","smith");        
       System.out.println(em1.showInfo());
        
       
        
       
    
    
    }
    }
    