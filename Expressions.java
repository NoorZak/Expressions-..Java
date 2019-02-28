package expressions;
import java.util.Stack;
import java.util.Scanner;
import java.util.EmptyStackException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 *
 * @author Noor Al Din Zakarneh 
 */
 
 enum validation {Valid ,NotValid;}


 enum error{success,overflow,underflow;}

/*
class Stack<T>{
    

      final int maxsize=100;
    Object entry[]=new Object[maxsize];
    int top;
    
    Stack(){top=0;
    
    
    
}
    
    error push(T  item){if(top==maxsize)return error.overflow;
    entry[top++]=item;
    return error.success;
    }
    
    boolean empty(){
        return(top==0);
        
    }
    
    error pop(){
        if(empty())return error.underflow;
        top--;
        return error.success;
        
    }
    error Top(Object item){
        if(empty())
            return error.underflow;
       
        item=entry[top-1];
        return error.success;
        
    }
    }*/
public class Expressions {

    
     // @param args the command line arguments
     
    
    public static validation  check (String ex){
        
        
        Stack  <Character> s=new Stack<Character>();
        for(int i=0;i<ex.length();i++){
           
if(ex.charAt(i)=='('|| ex.charAt(i)=='{' || ex.charAt(i)=='[')
{
s.push(ex.charAt(i));
}
else if(ex.charAt(i)==')' && s.peek()=='(')
{
s.pop();
}
else if(ex.charAt(i)=='}' && s.peek()=='{')
{
s.pop();
}
else if(ex.charAt(i)==']' && s.peek()=='[')
{
s.pop();
}

}
       
if(s.empty() )

    return validation.Valid;


    return validation.NotValid;}
        
       


        
    
    public static void main(String[] args) {
        // TODO code application logic here
       
        
        //System.out.println("Enter the name of the file");
      //  String name=input.nextLine();
        
      FileOutputStream out;
      FileInputStream in;
        
        
        try{
            
            out =new FileOutputStream("D:\\java\\Expression.txt");
            in = new FileInputStream("D:\\java\\Expression.txt");
            String ex=new Scanner(in).nextLine();
           
                
            System.out.println(check(ex));}
           
           
  catch( EmptyStackException e){   System.out.println(validation.NotValid);}

        catch(IOException e) {System.out.println(e.getMessage());}
        
        catch(Exception e){e.getMessage();}
        }}