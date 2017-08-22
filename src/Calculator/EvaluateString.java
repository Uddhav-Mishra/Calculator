package Calculator;

import java.util.Stack;

public class EvaluateString {
    public  String evaluate(String expression){
        int cnt = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                cnt++;
            }
            else if (expression.charAt(i) == ')') {
                cnt--;
            }
        }
        for(int i = 0;i < cnt; i++) {
             expression = expression + ')';
           
        }
        
        char[] tokens = expression.toCharArray();
 
         // Stack for numbers: 'values'
        Stack<Double> values = new Stack<Double>();
 
        // Stack for Operators: 'ops'
        Stack<Character> ops = new Stack<Character>();
        int index = tokens.length-1;
        for (int i =  tokens.length-1; i >= 0; i--)
        { 
            if (tokens[i] != ' ' && tokens[i] != '(' && tokens[i] != ')') {
                index = i;
                break;
            }
        }
        if (!(tokens[index] >= '0' && tokens[index] <='9')) {
            return "invalid";
        }
        for (int i = 0; i < tokens.length; )
        {   //System.out.println("char length"+tokens[i]);
             // Current token is a whitespace, skip it
            if (tokens[i] == ' ')
            {i++; continue;}
            
            double negflag = 1.0;
                // There may be more than one digits in number
                if (tokens[i] == '-') {
                    if (i > 0 ) { 
                       if (tokens[i-1] == '(') {
                            System.out.println("negative number");
                           negflag = -1.0 ;
                           i++;
                       }
                    }        
                }
            // Current token is a number, push it to stack for numbers
            if ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '.' )
            {
                StringBuffer sbuf = new StringBuffer();
             
                while ((i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') || 
                        (i < tokens.length && tokens[i] == '.'))
                    sbuf.append(tokens[i++]);
                values.push((negflag*Double.parseDouble(sbuf.toString())));
            }
 
            // Current token is an opening brace, push it to 'ops'
            else if (tokens[i] == '(')
                ops.push(tokens[i++]);
 
            // Closing brace encountered, solve entire brace
            else if (tokens[i] == ')')
            {
                while (ops.peek() != '(')
                  values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
                i++;
            }
 
            // Current token is an operator.
            else if (tokens[i] == '+' || (tokens[i] == '-' && negflag > 0) ||
                     tokens[i] == '*' || tokens[i] == '/' || tokens[i] == '&' || tokens[i] == '|' 
                     || tokens[i] == '^')
            {    System.out.println("++++");
                // While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                  values.push(applyOp(ops.pop(), values.pop(), values.pop()));
 
                // Push current token to 'ops'.
                ops.push(tokens[i++]);
            }
        }
        System.out.println(ops.size());
        // Entire expression has been parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
 
        // Top of 'values' contains result, return it
        return values.pop().toString();
    }
 
    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
 
    // A utility method to apply an operator 'op' on operands 'a' 
    // and 'b'. Return the result.
    public static double applyOp(char op, double b, double a)
    {
        switch (op)
        {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            return a / b;
        case '&':
            return (double)(Math.round(a) & Math.round(b)) ;
        case '|':
            return (double)(Math.round(a) | Math.round(b)) ;
        case '^':
            return (double)(Math.round(a) ^ Math.round(b)) ;
        case '%':
            return (double)(Math.round(a) % Math.round(b)) ;
        }
        return 0;
     
    }
}
