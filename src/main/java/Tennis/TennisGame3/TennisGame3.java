package Tennis.TennisGame3;

import Tennis.TennisGame;

public class TennisGame3 implements TennisGame {
    
    private int p2;
    private int p1;
    private String p1N;
    private String p2N;
    private String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getScore() {

        String s = "";
        int sum = p1 + p2;

        if (p1 < 4 && p2 < 4 && sum != 6) {
            s = p[p1];
            return case1(s);
        } else {
            return case2(s);
        }
    }

    public String case1(String score){

        if (p1 == p2){
            score += "-All";
        } else {
            score += "-" + p[p2];
        }
        return score;
    }

    public String case2(String score){
        if (p1 == p2){
            return "Deuce";
        }else{
            score = p1 > p2 ? p1N : p2N;
            return case3(score);
        }
    }

    public String case3(String score){

        int resta = p1-p2;
        int multiplicacion = resta * resta;
        String resultado = "";

        if (multiplicacion == 1){
            resultado = "Advantage " + score;
        } else {
            resultado = "Win for " + score;
        }
        return resultado;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            this.p1 += 1;
        }else {
            this.p2 += 1;
        }
    }
}
