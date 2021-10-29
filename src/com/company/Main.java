package com.company;

import java.util.Random;
import java.util.Scanner;

class spliter{
    public static String[] spliting(String a){
        return a.split(" ");
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("****** To Random Pick Draw ******");
        while(true) {
            System.out.print("Members:");
            String allMembers = sc.nextLine();

            System.out.print("Gifts:");
            String gift = sc.nextLine();

            Draw draw = new Draw(allMembers, gift);
            draw.winnerDraw();
            draw.showSequence();
            draw.showWinner();
            draw.showfail();

            System.out.println("continue? Stop?");
            System.out.println("If you want to continue, please enter the 1, otherwise enter another key.");
            System.out.print("Enter:");
            char ent = sc.next().charAt(0);
            sc.nextLine();
            if(ent!='1'){
                break;
            }
        }

    }
}
