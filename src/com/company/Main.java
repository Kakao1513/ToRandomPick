package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("To Random Pick Draw");
        System.out.print("뽑을사람:");

        String allMembers = new String();
        allMembers = sc.nextLine();
        String[] member = allMembers.split(" ");//공백 단위로 유저 분할

        String gift = new String();
        gift = sc.nextLine();
        String[] winning = gift.split(" ");//공백 단위로 보상분할
        //푸시확인
    }
}
