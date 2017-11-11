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
public class Ex1 {
//Requires: The index of the array has to be initialized as an integer. Arrays A
    //and B are declared as integers. The content of the array a and b has to be 
    //integers because maximum and minimum values of the arrays are declared as
    //integers.

//Modifies: The first content of the array is initialized as maximum value of
    //of array. Using the for loops, comparing values of each content of the
    //array a and b with the initialized Maximum vale of the Array. If a 
    //content of the array is higher than the assigned maximum value, the 
    //maximum value of the array will be modified. 
//Effects: SubstituteMax method checks the context of each index of array and  
    //initializes to the maximum value of the array. 
    public static void substituteMax(int[] a, int[] b) {
        int maxOfA = a[0];
        int index = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > maxOfA) {
                maxOfA = a[i];
                index = i;
            }
        }

        int maxOfB = b[0];
        for (int i = 0; i < b.length; i++) {
            if (b[i] > maxOfB) {
                maxOfB = b[i];
            }
        }
        a[index] = maxOfB;
    }

}
