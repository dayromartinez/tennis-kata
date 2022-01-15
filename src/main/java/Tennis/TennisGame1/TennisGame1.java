package Tennis.TennisGame1;

import Tennis.TennisGame;

public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String switchCaseScore(int m_score1, String score){
        switch (m_score1) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }

    public String minusResultCase(String score){
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    public int tempScoreConditional(int tempScore, int i){
        if (i == 1){
            tempScore = m_score1;
        } else {
            tempScore = m_score2;
        }
        return tempScore;
    }

    public String tempScoreCaseTwo(int i, String score){
        if(i != 1){
            score += "-";
        }
        return score;
    }

    public String tempScoreCase(String score, int tempScore){
        for (int i = 1; i < 3; i++) {

            tempScore = tempScoreConditional(tempScore, i);
            score = tempScoreCaseTwo(i, score);

            switch(tempScore) {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }

    public String getScore() {

        String score = "";
        int tempScore = 0;

        if (m_score1 == m_score2) {
            return switchCaseScore(m_score1, score);
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            score = minusResultCase(score);
        }else{
            score += tempScoreCase(score, tempScore);
        }
        return score;
    }
}
