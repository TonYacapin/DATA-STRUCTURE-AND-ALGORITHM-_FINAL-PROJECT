import java.util.*;
 
// Stack class 
class Stack {
    // Initialize data members
    int top;
    int size;
    char items[];
 
    // Constructor
    Stack(int size) {
        this.size = size;
        items = new char[size];
        top = -1;
    }
 
    // Utility function to push element
    public void push(char x) {
        if (top == size - 1) {
           
        } else {
            items[++top] = x;
        }
    }
 
    // Utility function to pop element
    public char pop() {
        if (top == -1) {
          
            return '\0';
        } else {
            char element = items[top];
            top--;
            return element;
        }
    }
 
    // Utility function to return top element
    public char peek() {
        if (top == -1) {
          
            return '\0';
        } else {
            char element = items[top];
            return element;
        }
    }
 
    public boolean isEmpty() {
        return (top == -1) ? true : false;
    }
}
 
// Main class
public class ConversionMain {
 
    // Driver program
    public void main(String[] args) {
//        String expression = "A+B*C";
//        System.out.println("Infix Expression: " + expression);
//        System.out.println("Prefix Expression: " + infixToPrefix(expression));
//        System.out.println("Postfix Expression: " + infixToPostfix(expression));
//        expression = "*-A/BC-/AKL";
//        System.out.println("Prefix Expression: " + expression);
//        System.out.println("Infix Expression: " + prefixToInfix(expression));
//       System.out.println("Postfix Expression: " + expression);
//        expression = "ABC/-AK/L-*";
//        System.out.println("Postfix Expression: " + expression);
//        System.out.println("Infix Expression: " + postfixToInfix(expression));
//        System.out.println("Prefix Expression: " + postfixToPrefix(expression));
    	Scanner sc = new Scanner(System.in);
    	char answer = 'y';
    	do {
			 System.out.println("What operation would you like to perform?\n1 - infix to prefix\n2 - infix to postfix\n3 -"
    	 		+ " prefix to infix\n4 - prefix to postfix\n5 - postfix to infix\n6 - postfix to prefix\n7 - Exit");
    	    int choice = sc.nextInt();
    	    String infix ;
    	

    	switch (choice) {

    	 case 1:
    	        System.out.println("Please enter your infix expression:");
    	        infix = sc.next();
    	        System.out.println("The prefix expression for " + infix + " is " + infixToPrefix(infix));
    	        break;
    	      case 2:
    	        System.out.println("Please enter your infix expression:");
    	        infix = sc.next();
    	        System.out.println("The postfix expression for " + infix + " is " + infixToPostfix(infix));
    	        break;
    	      case 3:
    	        System.out.println("Please enter your prefix expression:");
    	        String prefix = sc.next();
    	        System.out.println("The infix expression for " + prefix + " is " + prefixToInfix(prefix));
    	        break;
    	      case 4:
    	        System.out.println("Please enter your prefix expression:");
    	        prefix = sc.next();
    	        System.out.println("The postfix expression for " + prefix + " is " + prefixToPostfix(prefix));
    	        break;
    	      case 5:
    	        System.out.println("Please enter your postfix expression:");
    	        String postfix = sc.next();
    	        System.out.println("The infix expression for " + postfix + " is " + postfixToInfix(postfix));
    	        break;
    	      case 6:
    	        System.out.println("Please enter your postfix expression:");
    	        postfix = sc.next();
    	        System.out.println("The prefix expression for " + postfix + " is " + postfixToPrefix(postfix));
    	        break;
    	      case 7:
    	    	  
      	       return;
      	        
    	      default:
    	        System.out.println("Invalid input. Please try again.");
    	        break;
    	}
    	System.out.println("Do you want to use the program again? (Y/N)");
    	answer = sc.next().charAt(0);
		} while (answer == 'y' || answer == 'Y');
    	
    	
    	
    }
 
    // Function to convert Infix expression to Prefix expression
    static String infixToPrefix(String infix) {
        // reverse String
        StringBuilder revString = new StringBuilder(infix);
        revString = revString.reverse();
        // replace ( with ) and vice versa
        for (int i = 0; i < revString.length(); i++) {
            if (revString.charAt(i) == '(') {
                revString.setCharAt(i, ')');
                continue;
            }
            if (revString.charAt(i) == ')') {
                revString.setCharAt(i, '(');
            }
        }
        // Obtain Prefix expression
        String prefix = infixToPostfix(revString.toString());
        // reverse back Prefix expression
        return new StringBuilder(prefix).reverse().toString();
    }
 
    // Function to convert Infix expression to Postfix expression
    static String infixToPostfix(String infix) {
        // Initialize empty String for result
        String result = new String("");
        // Initialize empty stack
        Stack stack = new Stack(infix.length());
        for (int i = 0; i < infix.length(); ++i) {
            char c = infix.charAt(i);
            // If scanned character is an operand, add it to output
            if (Character.isLetterOrDigit(c))
                result += c;
            else if (c == '(')
                stack.push(c);
            // If scanned character is an ')', pop and output from the stack until and '(' is encountered.
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();
                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Invalid Expression"; // invalid expression
                else
                    stack.pop();
            } else // an operator is encountered
            {
                while (!stack.isEmpty() && prec(c) <= prec(stack.peek())) {
                    if (stack.peek() == '(')
                        return "Invalid Expression";
                    result += stack.pop();
                }
                stack.push(c);
            } 
        } 
        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }
 
    // Function to convert Prefix expression to Infix expression
    static String prefixToInfix(String prefix) {
        // Reverse prefix
        StringBuilder revString = new StringBuilder(prefix);
        revString = revString.reverse();
        // Obtain Infix expression
        String infix = postfixToInfix(revString.toString());
        // reverse back Infix expression
        return new StringBuilder(infix).reverse().toString();
    }
 
    // Function to convert Prefix expression to Postfix expression
    static String prefixToPostfix(String prefix) {
        // Obtain Postfix expression
        String postfix = infixToPostfix(prefixToInfix(prefix));
        return postfix;
    }
 
    // Function to convert Postfix expression to Infix expression
    static String postfixToInfix(String postfix) {
        // Initialize empty stack
        Stack stack = new Stack(postfix.length());
        for (int i = 0; i < postfix.length(); ++i) {
            char c = postfix.charAt(i);
            // If scanned character is an operand, push it to the stack
            if (Character.isLetterOrDigit(c))
                stack.push(c);
            else // operator
            {
                // Pop two operands from stack
                char operand1 = stack.pop();
                char operand2 = stack.pop();
                // Construct temporary string with operator as prefix
                String temp = "(" + operand2 + c + operand1 + ")";
                // Push String to stack
                stack.push(temp.charAt(0));
            }
        }
        return stack.pop() + "";
    }
 
    // Function to convert Postfix expression to Prefix expression
    static String postfixToPrefix(String postfix) {
        // Obtain Prefix expression
        String prefix = infixToPrefix(postfixToInfix(postfix));
        return prefix;
    }
 
    // Function to return precedence of a given operator
    // Higher returned value means higher precedence
    static int prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}