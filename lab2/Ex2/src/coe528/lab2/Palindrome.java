/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab2;

/**
 *
 * @author Subhasish, 500572222
 */
public class Palindrome {

//Requires: The argument has to be a single digit character from 1 to 4. The 
    //string going in the isPalindrome method is case sensetive.
//Modifies: Nothing gets modified. 
//Effects: If the input argument is 1,2 and 4, the output will be false. 
    //The output will only be true, if the input argument is 3. 
    public static boolean isPalindrome(String a) {
//write the code for isPalindrome
        int n = a.length();
        for (int i = 0; i < (n / 2); ++i) {
            if (a.charAt(i) != a.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        if (args.length == 1) {
            if (args[0].equals("1")) {
                System.out.println(isPalindrome(null));
            } else if (args[0].equals("2")) {
                System.out.println(isPalindrome(""));
            } else if (args[0].equals("3")) {
                System.out.println(isPalindrome("deed"));
            } else if (args[0].equals("4")) {
                System.out.println(isPalindrome("abcd"));
            }
        }
    }
}
