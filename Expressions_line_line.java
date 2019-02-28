package checkingexpression;
import java.util.Stack;
import java.util.EmptyStackException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import javax.swing.JOptionPane;
import java.io.File;
/*Author Noor Zakarneh*/
 enum validation {Valid ,NotValid,NoFile,Emptyline,EmptyFile;}

public class CheckingExpression {

    public static void f(BufferedReader b) throws IOException{
      int repeat;
     Stack  <String>st=new Stack <String>();
 
      int linescount=0;
     int linenum;
     String ex,s1;   
              
while ((ex=b.readLine()) != null) {
    st.push(ex);
    linescount++;
}
//b.close();




for(int i=0;i<st.size();i++)
JOptionPane.showMessageDialog(null, "This Expression  "+st.get(i)+" in line : "+(i)+"is"+check(st.get(i)));
       

    }
  
    

    public static validation  check (String ex){
        char c;
        try{ 
          if(ex.isEmpty())return validation.Emptyline;
    
        Stack  <Character> s=new Stack<Character>();
        
        for(int i=0;i<ex.length();i++){
            c=ex.charAt(i);
if(c=='('|| c=='{' || c=='[')
    s.push(c);

else if(c==')' && s.peek()=='(')
s.pop();

else if(c=='}' && s.peek()=='{')
s.pop();
        
else if(c==']' && s.peek()=='[')
s.pop();

}
       
if(s.empty() )

    return validation.Valid;


    return validation.NotValid;}
           
          catch( EmptyStackException e){  return validation.NotValid;}}
         
       
    public static void main(String[] args) throws IOException  {
     File file;
     FileReader f;
     BufferedReader b ;
    
        try{
             file = new File("D:\\java\\Expression.txt");
             f= new FileReader(file);
            
             b = new BufferedReader(f);
        
             
         /*Desktop desktop=null ;
      
       desktop = Desktop.getDesktop();
       desktop.open(file);*/
       
          f(b);
        }
  

        catch(IOException e) {JOptionPane.showMessageDialog(null,validation.NoFile,"Error",JOptionPane.ERROR_MESSAGE);
        }
       catch(IndexOutOfBoundsException e){JOptionPane.showMessageDialog(null, "Unsuitable Entered number","Warning",JOptionPane.WARNING_MESSAGE);
       main(null);
       }
       catch(NumberFormatException e){JOptionPane.showMessageDialog(null,"Exit ","Exit",JOptionPane.ERROR_MESSAGE);}
        }
                }