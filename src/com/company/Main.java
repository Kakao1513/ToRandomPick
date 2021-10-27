package com.company;

import java.util.Random;
import java.util.Scanner;

class spliter{
    public static String[] spliting(String a){
        return a.split(" ");
    }
}

class Draw{
    protected String[] members, gifts, winner;
    private final Random rand = new Random();
    private int[] winnerIndex;
    Draw(String mem, String gi){
        this.members = new String[spliter.spliting(mem).length];
        this.gifts = new String[spliter.spliting(gi).length];
        this.winner = new String[gifts.length];
        this.winnerIndex = new int[gifts.length];
        members=spliter.spliting(mem);
        gifts=spliter.spliting(gi);
    }


    void winnerDraw() {

        for (int i = 0; i < gifts.length; i++) { //당첨 번호 뽑기 파트
            winnerIndex[i] = rand.nextInt(members.length);
            for (int j = 0; j < i; j++) {
                if (winnerIndex[i] == winnerIndex[j]) {
                    i--;
                }
            }
        }
        for (int i = 0; i < winner.length; i++) {//맴버의 길이 만큼 반복.
            winner[i]=members[winnerIndex[i]];
        }
    }
    void showWinner(){
        System.out.println("\n-----당첨-----");
        for(int i = 0 ; i< winner.length; i++){
            System.out.println(gifts[i]+":"+winner[i]);
        }
    }
    void showfail(){
        int k=0;
        System.out.println("\n-----컽------");
        for (String member : members) {
            if (k > winner.length - 1) {
                k = winner.length - 1;
            }
            if (!member.equals(winner[k])) {
                System.out.println(member);
            } else {//멤버가 같은경우
                k++;
            }
        }
    }

}
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("****** To Random Pick Draw ******");

        System.out.print("Members:");
        String allMembers = sc.nextLine();

        System.out.print("Gifts:");
        String gift = sc.nextLine();

        Draw draw = new Draw(allMembers, gift);
        draw.winnerDraw();
        draw.showWinner();
        draw.showfail();
    }
}
