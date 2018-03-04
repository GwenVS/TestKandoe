package domain;

import domain.card.Card;

//new class added
public class CardGameSessionInfo {

    private Long cardGameSessionInfoId;

    private GameSession gameSession;

    private Card card;

    private int cardLevel = 0; //op welk niveau ligt een kaartje, start op 0

    public CardGameSessionInfo() {
    }

    public CardGameSessionInfo(GameSession gameSession, Card card) {
        this.gameSession = gameSession;
        this.card = card;
    }

    public Long getCardGameSessionInfoId() {
        return cardGameSessionInfoId;
    }

    public void setCardGameSessionInfoId(Long cardGameSessionInfoId) {
        this.cardGameSessionInfoId = cardGameSessionInfoId;
    }

    public GameSession getGameSession() {
        return gameSession;
    }

    public void setGameSession(GameSession gameSession) {
        this.gameSession = gameSession;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public int getCardLevel() {
        return cardLevel;
    }

    public void setCardLevel(int cardLevel) {
        this.cardLevel = cardLevel;
    }
}
