//infix to postfix conversion using stack
import java.util.*;
public class Main 
{
    int prec(char c)
    {
        if(c=='+'|| c=='-')
        return 1;
        if(c=='*'|| c=='/')
        return 2;
        if(c=='^')
        return 3;
        else
        return 0;
    }
    void convert(String s)
    {
        String res=new String("");
        Stack<Character>stack=new Stack<Character>();
        for(int i=s.length()-1;i>=0;i--)
        {
        if(Character.isLetter(s.charAt(i)))
        res+=s.charAt(i);
         else if(s.charAt(i)==')')
         stack.push(s.charAt(i));
         else if(s.charAt(i)=='(')
         {
         while(!stack.isEmpty() && stack.peek()!=')')
         res+=stack.pop();
         if(stack.peek()==')')
         stack.pop();
         }
         else
         {
             while(!stack.isEmpty() && prec(stack.peek())>=prec(s.charAt(i)))
             res+=stack.pop();
             stack.push(s.charAt(i));
         }
        }
         while(!stack.isEmpty())
         {
             res+=stack.pop();
         }
         String newres="";
         for(int i=res.length()-1;i>=0;i--)
         newres+=res.charAt(i);
         System.out.println(newres);
        
    }
    public static void main(String[] args)
    {
        Main obj=new Main();
        obj.convert("(a-b/c)*(a/k-l)");
    }
}
    

