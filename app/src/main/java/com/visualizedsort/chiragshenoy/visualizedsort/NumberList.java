package com.visualizedsort.chiragshenoy.visualizedsort;

/**
 * Created by Chirag Shenoy on 21-Dec-15.
 */

import java.util.Random;


public class NumberList {


    private static int[] anArray;

    public NumberList(int size) {
        anArray = new int[size];
        for (int i = 0; i < anArray.length; i++) {
            anArray[i] = randomFill();
        }
    }

    public static void print() {
        for (int n : anArray) {
            System.out.println(n + " ");
        }
    }


    public static int randomFill() {

        Random rand = new Random();
        int randomNum = rand.nextInt(100);
        return randomNum;
    }

    public static void main(String args[]) {

    }

    public int[] getAnArray() {
        return anArray;
    }


}