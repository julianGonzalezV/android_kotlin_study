package co.com.study.examples;

import java.util.Stack;

public class StackExample {

    /**
     *
     * @param input
     * @return
     */
    static boolean parenthesisValidation(String input){
        String openSymbols = "{[(";
        String closeSymbols = ")]}";
        if(input==null || input.length() == 0 || closeSymbols.contains(input.substring(0,1))
                || openSymbols.contains(input.substring(input.length()-1))) {
            return false;
        }else {
            Stack parenthStack = new Stack();
            boolean result = true;
            for (Character s : input.toCharArray()){

                if (openSymbols.contains(s.toString())) {
                    parenthStack.push(s);
                }
                else if (closeSymbols.contains(s.toString()) && openSymbols.contains(parenthStack.peek().toString())) {
                    parenthStack.pop();
                }else{
                    result = false;
                }

                if(parenthStack.isEmpty()){
                    result =  true;
                    break;
                }

            }
            return result;
        }
    }


    public static void main(String ... args){
        System.out.println("(a[0]+b[2c[6]]){24+3} --> "+StackExample.parenthesisValidation("(a[0]+b[2c[6]]){24+3}"));
        System.out.println("f(e(d))-->"+StackExample.parenthesisValidation("f(e(d))"));
        System.out.println("[()]{}([])-->"+StackExample.parenthesisValidation("[()]{}([])"));
        System.out.println("((b)-->"+StackExample.parenthesisValidation("((b)"));
        System.out.println("(c] -->"+StackExample.parenthesisValidation("(c]"));
        System.out.println("{(a[])-->"+StackExample.parenthesisValidation("{(a[])"));
        System.out.println("([)]-->"+StackExample.parenthesisValidation("([)]"));
        System.out.println(")(-->"+StackExample.parenthesisValidation(")("));
        System.out.println("Empty-->"+StackExample.parenthesisValidation(""));
    }
}
