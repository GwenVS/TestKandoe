package domain;

import domain.card.Card;
import domain.theme.SubTheme;
import domain.user.User;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameSession {

    private Long gameSessionId;

    private boolean isOrganisatorPlaying;

    private boolean allowUsersToAdd;

    private int addLimit;

    private int selectionLimit;

    private int timerLength; //Seconds

    private String title; //GameTitle

    private List<UserGameSessionInfo> userGameSessionInfos = new ArrayList<>();


    //added
    private List<CardGameSessionInfo> cardGameSessionInfos = new ArrayList<>();

    private SubTheme subTheme = new SubTheme();


    public GameSession() {
    }

    public boolean isOrganisatorPlaying() {
        return isOrganisatorPlaying;
    }

    public void setOrganisatorPlaying(boolean organisatorPlaying) {
        isOrganisatorPlaying = organisatorPlaying;
    }

    public boolean isAllowUsersToAdd() {
        return allowUsersToAdd;
    }

    public void setAllowUsersToAdd(boolean allowUsersToAdd) {
        this.allowUsersToAdd = allowUsersToAdd;
    }

    public int getAddLimit() {
        return addLimit;
    }

    public void setAddLimit(int addLimit) {
        this.addLimit = addLimit;
    }

    public int getSelectionLimit() {
        return selectionLimit;
    }

    public void setSelectionLimit(int selectionLimit) {
        this.selectionLimit = selectionLimit;
    }

    public int getTimerLength() {
        return timerLength;
    }

    public void setTimerLength(int timerLength) {
        this.timerLength = timerLength;
    }

    public Long getGameSessionId() {
        return gameSessionId;
    }

    public void setGameSessionId(Long gameSessionId) {
        this.gameSessionId = gameSessionId;
    }

    public List<UserGameSessionInfo> getUserGameSessionInfos() {
        return userGameSessionInfos;
    }

    public void setUserGameSessionInfos(List<UserGameSessionInfo> userGameSessionInfos) {
        this.userGameSessionInfos = userGameSessionInfos;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrganisatorName() {
        for (UserGameSessionInfo info : userGameSessionInfos) {
            if (info.getRole() == GameSessionRole.ModeratorParticipant || info.getRole() == GameSessionRole.Moderator)
                return info.getUser().getUsername();
        }
        return "";
    }


    //added
    public void addUserGameSessionInfo(UserGameSessionInfo userGameSessionInfo) {
        this.userGameSessionInfos.add(userGameSessionInfo);
    }

    public List<CardGameSessionInfo> getCardGameSessionInfos() {
        return cardGameSessionInfos;
    }

    public void setCardGameSessionInfos(List<CardGameSessionInfo> cardGameSessionInfos) {
        this.cardGameSessionInfos = cardGameSessionInfos;
    }

    public void addCardGameSessionInfo(CardGameSessionInfo cardGameSessionInfo) {
        this.cardGameSessionInfos.add(cardGameSessionInfo);
    }

    public SubTheme getSubTheme() {
        return subTheme;
    }

    public void setSubTheme(SubTheme subTheme) {
        this.subTheme = subTheme;
    }


    //play the game
    public void start() {
        List<Card> chosenCards = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Sessie met titel: \"" + title + "\" getart rond het subthema: \"" + subTheme.getSubThemeName() + "\".");
        System.out.println("Het maximum aantal toe te voegen kaarten per speler : " + this.getSelectionLimit());

        boolean chosen = false;  //round 1 : choose cards
        while (!chosen) {
            System.out.println("Kies een user via zijn nummer uit de lijst om kaarten voor te kiezen (0 om te stoppen)");

            for (UserGameSessionInfo userGameSessionInfo : userGameSessionInfos) {
                User user = userGameSessionInfo.getUser();
                System.out.println(user.getUserId() + " : " + user.getUsername());
            }
            int userId = in.nextInt(); // read the userId
            if (userId == 0) {
                chosen = true;
            } else {
                for (UserGameSessionInfo userGameSessionInfo : userGameSessionInfos) {
                    if (userGameSessionInfo.getUser().getUserId() == userId) {
                        //counter: how many times you may add a card
                        int counter = 0;
                        boolean stopChoosingCards = false;
                        while (counter < this.getSelectionLimit() && !stopChoosingCards) {
                            System.out.println(userGameSessionInfo.getUser().getUsername() + ", kies een kaart om toe te voegen (0 om te stoppen): ");
                            for (CardGameSessionInfo cardGameSessionInfo : cardGameSessionInfos) {
                                Card card = cardGameSessionInfo.getCard();
                                System.out.println(card.getCardId() + "      |  " + card.getName());
                            }
                            int chosenCardId = in.nextInt();   //read the cardId
                            if (chosenCardId == 0) {
                                stopChoosingCards = true;
                            } else {
                                for (CardGameSessionInfo cardGameSessionInfo : cardGameSessionInfos) {
                                    Card card = cardGameSessionInfo.getCard();
                                    if (card.getCardId() == chosenCardId) {
                                        if(!chosenCards.contains(card)){
                                            chosenCards.add(card);
                                            counter++;
                                            System.out.println("Kaart " + chosenCardId + " werd toegevoegd.");
                                        } else {
                                            counter++;
                                            System.out.println("Gekozen kaart werd al eens toegevoegd");
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        //next rounds: add levels to cards
        boolean done = false;
        while (!done) {
            for (UserGameSessionInfo userGameSessionInfo : userGameSessionInfos) {
                int chosenCardNumber;
                User user = userGameSessionInfo.getUser();
                System.out.println();
                System.out.println("De Beurt is aan " + user.getUsername() + ".");
                System.out.println("Kies een kaart door het nummer in te geven: (0 om te eindigen) ");
                System.out.println("Nummer |  Naam    |  Level");
                System.out.println("---------------------------");
                for (CardGameSessionInfo cardGameSessionInfo : cardGameSessionInfos) {
                    Card card = cardGameSessionInfo.getCard();
                    if (chosenCards.contains(card)) {
                        System.out.println(card.getCardId() + "      |  " + card.getName() + "  |  " + cardGameSessionInfo.getCardLevel());
                    }
                }
                chosenCardNumber = in.nextInt();   //read the cardId

                Card chosenCard = new Card();
                for (CardGameSessionInfo cardGameSessionInfo : cardGameSessionInfos) {
                    Card card = cardGameSessionInfo.getCard();
                    if (card.getCardId() == chosenCardNumber) {
                        chosenCard = card;
                    }
                }

                if (chosenCardNumber == 0) {
                    done = true;
                    break;
                } else if (chosenCards.contains(chosenCard)) {
                    for (CardGameSessionInfo cardGameSessionInfo : cardGameSessionInfos) {
                        Card card = cardGameSessionInfo.getCard();
                        if (card.getCardId() == chosenCardNumber) {
                            int cardLevel = cardGameSessionInfo.getCardLevel();
                            cardLevel++;
                            cardGameSessionInfo.setCardLevel(cardLevel);
                        }
                    }
                } else {
                    System.out.println("ongeldige keuze");
                }
            }
        }
    }
}
