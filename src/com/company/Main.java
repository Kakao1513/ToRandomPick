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
    private String[][] winnerGift;
    private int[] winnerIndex;
    Draw(String mem, String gi){
        this.members = new String[spliter.spliting(mem).length];
        this.gifts = new String[spliter.spliting(gi).length];
        this.winner = new String[gifts.length];
        this.winnerIndex = new int[gifts.length];
        this.winnerGift = new String[2][members.length];//세로 2 가로 멤버 변수의 길이 만큼의 배열
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
        for (int i = 0; i < winner.length; i++) {//당첨자의 길이 만큼 반복.
            winner[i]=members[winnerIndex[i]];
        }
        setGifts();
    }
    private void setGifts(){

        for(int i = 0, j = 0; i< members.length;i++){//members의 길이만큼 반복
            try{
                if(winnerIndex[j]==i){
                    winnerGift[0][i]=members[i];
                    winnerGift[1][i]=gifts[j++];
                }   else{
                    winnerGift[0][i]=members[i];
                    winnerGift[1][i]="꽝";
                }
            }catch (ArrayIndexOutOfBoundsException e){
                e.getMessage();
                winnerGift[0][i]=members[i];
                winnerGift[1][i]="꽝";
            }
        }
    }
    void showWinner(){
        System.out.println("\n-----당첨-----");
        for(int i = 0 ; i< winner.length; i++){
            System.out.println(winner[i]+":"+gifts[i]);
        }
    }
    void showfail(){
        System.out.println("\n-----컽------");
        for(int i = 0 ; i<members.length;i++){
            if(winnerGift[1][i].equals("꽝")){
                System.out.println(members[i]);
            }
        }
    }
    void showSequence(){
        System.out.println("----뽑기 중----");
        for(int i = 0 ; i< members.length;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(winnerGift[0][i]+":"+winnerGift[1][i]);

        }
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
