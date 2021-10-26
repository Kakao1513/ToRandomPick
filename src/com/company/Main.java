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
        Random rand = new Random();
        System.out.println("****** To Random Pick Draw ******");
        System.out.print("Members:");

        String allMembers = sc.nextLine();
        String[] member = spliter.spliting(allMembers);//공백 단위로 유저 분할

        System.out.print("Gifts:");
        String gift = sc.nextLine();
        String[] winning = spliter.spliting(gift);//공백 단위로 보상분할

        int[] winningIndex = new int[winning.length];//당첨번호 입력
        for (int i = 0; i<winning.length; i++){ //당첨번호 부여파트
            winningIndex[i] = rand.nextInt(member.length);
            for(int j = 0; j<i;j++){//중복당첨 제거파트
                if(winningIndex[i]==winningIndex[j]){
                    i--;
                }
            }
        }

        System.out.println("");
        System.out.println("-당첨-");
        for(int i = 0 ; i< winning.length; i++){
            System.out.println(winning[i]+":"+member[winningIndex[i]]);
        }

        System.out.println("");
        System.out.println("-컽-");
        for(int i = 0; i< member.length;){
            for(int j = 0; j< winning.length;j++){
                if(winningIndex[j]==i){
                    break;
                }
            }
            System.out.println(member[i++]);
        }
    }
}
