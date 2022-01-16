package Tennis.TennisGame2;

import Tennis.TennisGame;

public class TennisGame2 implements TennisGame
{
    public int p1Point = 0;
    public int p2Point = 0;
    
    public String p1Res = "";
    public String p2Res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){

        String score = "";

        if (p1Point == p2Point && p1Point < 4) {
            score = getScoreP1P2Equals(p1Point, p2Point);
            score += "-All";
        }

        if (p1Point == p2Point && p1Point >= 3)
            score = "Deuce";

        if (p1Point > 0 && p2Point == 0) {
            p1Res = pRes(p1Point);
            p2Res = "Love";
            score = p1Res + "-" + p2Res;
        }

        if (p2Point > 0 && p1Point == 0) {
            p2Res = pRes(p2Point);
            p1Res = "Love";
            score = p1Res + "-" + p2Res;
        }

        if (p1Point > p2Point && p1Point < 4) {
            p1Res = pRes(p1Point);
            p2Res = pRes(p2Point);
            score = p1Res + "-" + p2Res;
        }

        if (p2Point > p1Point && p2Point < 4) {
            p2Res = pRes(p2Point);
            p1Res = pRes(p1Point);
            score = p1Res + "-" + p2Res;
        }

        if (p1Point > p2Point && p2Point >= 3) {
            score = "Advantage player1";
        }

        if (p2Point > p1Point && p1Point >= 3) {
            score = "Advantage player2";
        }

        if (p1Point >=4 && p2Point >=0 && (p1Point - p2Point) >= 2){
            score = "Win for player1";
        }

        if (p2Point >= 4 && p1Point >= 0 && (p2Point - p1Point) >= 2){
            score = "Win for player2";
        }

        return score;
    }

    public String getScoreP1P2Equals(int p1Point, int p2Point){

        String score = "";

        switch (p1Point){

            case 0:
                score = "Love";
                break;

            case 1:
                score = "Fifteen";
                break;


            case 2:
                score = "Thirty";
                break;

            default:
                score += "-All";
                break;
        }
        return score;
    }

    public String pRes(int pPoint){

        String pRes = "";

        switch (pPoint){
            case 1:
                pRes = "Fifteen";
                break;

            case 2:
                pRes = "Thirty";
                break;

            case 3:
                pRes = "Forty";
                break;

            default:
                pRes = "Love";
                break;
        }
        return pRes;
    }
    
    public void SetP1Score(int number){
        for (int i = 0; i < number; i++) {
            P1Score();
        }
    }
    
    public void SetP2Score(int number){
        for (int i = 0; i < number; i++) {
            P2Score();
        }
    }
    
    public void P1Score(){
        p1Point++;
    }
    
    public void P2Score(){
        p2Point++;
    }

    public void wonPoint(String player) {
        if (player.equals("player1"))
            P1Score();
        else
            P2Score();
    }
}