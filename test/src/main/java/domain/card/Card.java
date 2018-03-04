package domain.card;


import domain.CardGameSessionInfo;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private long cardId;
    private String name;
    private String description;
    private String imagePath;
    private boolean isDefaultCard;
    private int subthemeId;


    //added
    private List<CardGameSessionInfo> cardGameSessionInfoList = new ArrayList<>();


    public int getSubthemeId() {
        return subthemeId;
    }

    public void setSubthemeId(int subthemeId) {
        this.subthemeId = subthemeId;
    }

    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public boolean isDefaultCard() {
        return isDefaultCard;
    }

    public void setDefaultCard(boolean defaultCard) {
        isDefaultCard = defaultCard;
    }


    //added

    public List<CardGameSessionInfo> getCardGameSessionInfoList() {
        return this.cardGameSessionInfoList;
    }

    public void setCardGameSessionInfoList(List<CardGameSessionInfo> cardGameSessionInfoList) {
        this.cardGameSessionInfoList = cardGameSessionInfoList;
    }

    public void addCardGameSessionInfo(CardGameSessionInfo cardGameSessionInfo){
        this.cardGameSessionInfoList.add(cardGameSessionInfo);
    }
}
