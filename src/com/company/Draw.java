package com.company;

import java.math.BigDecimal;
import java.util.Random;

class spliter{
    public static String[] spliting(String a){
        return a.split(" ");
    }
}
class GiftMoreThanMemberExpcetion extends Exception{
    public GiftMoreThanMemberExpcetion(){
        super("상품의 갯수가 사람의 수보다 많습니다.");
    }
}
class OverPercentageExpcetion extends Exception{
    public OverPercentageExpcetion(){
        super("확률의 최댓값을 초과하였습니다.");
    }
}
class Draw{
    protected String[] members, gifts, winner;
    private final Random rand = new Random();
    private String[][] winnerGift;
    private int[] winnerIndex;

    Draw(String mem, String gi) throws GiftMoreThanMemberExpcetion{
        this.members = new String[spliter.spliting(mem).length];
        this.gifts = new String[spliter.spliting(gi).length];
        if(gifts.length> members.length){
            throw new GiftMoreThanMemberExpcetion();
        }
        this.winnerIndex = new int[gifts.length];
        this.winnerGift = new String[2][members.length];//세로 2 가로 멤버 변수의 길이 만큼의 배열
        members=spliter.spliting(mem);
        gifts=spliter.spliting(gi);
        winnerGift[0]=members;
    }
    public static boolean percentage(BigDecimal a){
        int firstScale, DecimalScale;
        firstScale=a.precision()-a.scale();
        DecimalScale=a.scale();
        try{
            if(firstScale>2){
                throw new OverPercentageExpcetion();
            }
        }catch (OverPercentageExpcetion e){
            System.out.println(e.getMessage());
        }

        return true;
    }

    void winnerDraw() {

        for (int i = 0; i < gifts.length; i++) { //당첨 번호 뽑기 파트
            winnerIndex[i] = rand.nextInt(members.length);
            for (int j = 0; j < i; j++) {
                if (winnerIndex[i] == winnerIndex[j]) {//중복 제거 파트
                    i--;
                }
            }
        }

        setGifts();
    }
    private void setGifts(){
        for (int i = 0; i < gifts.length; i++) {//당첨자의 길이 만큼 반복.
            winnerGift[1][winnerIndex[i]] = gifts[i]; //당첨자와 상품 매치
        }
        for(int i = 0, j = 0; i< members.length;i++){//members의 길이만큼 반복
            if(winnerGift[1][i]==null){
                winnerGift[1][i]="꽝";
            }
        }
    }
    void showWinner(){
        System.out.println("\n-----당첨-----");
        for(int i = 0 ; i< gifts.length; i++){
            System.out.println(winnerGift[0][winnerIndex[i]]+":"+winnerGift[1][winnerIndex[i]]);
        }
    }
    void showfail(){
        System.out.println("\n-----꽝------");
        for(int i = 0; i < members.length; i++){
            if(winnerGift[1][i].equals("꽝")){
                System.out.println(winnerGift[0][i]);
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