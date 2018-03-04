import domain.CardGameSessionInfo;
import domain.GameSession;
import domain.GameSessionRole;
import domain.UserGameSessionInfo;
import domain.card.Card;
import domain.theme.SubTheme;
import domain.theme.Theme;
import domain.user.User;

import java.util.ArrayList;
import java.util.List;

public class Kandoe {
    public static void main(String[] args) {

        //testusers
        User user1 = new User();
        user1.setUserId(1);
        user1.setUsername("Jan");
        user1.setEmail("jan@test.be");

        User user2 = new User();
        user2.setUserId(2);
        user2.setUsername("tom");
        user2.setEmail("tom@test.be");

        User user3 = new User();
        user3.setUserId(3);
        user3.setUsername("mark");
        user3.setEmail("mark@test.be");


        //testthema
        Theme theme1 = new Theme();
        theme1.setThemeId((long) 1);
        theme1.setName("thema1");
        theme1.setDescription("eerste thema");


        //Testsubthema
        SubTheme subtheme1 = new SubTheme();
        subtheme1.setSubThemeId((long) 1);
        subtheme1.setSubThemeName("subthema1");
        subtheme1.setSubThemeDescription("1ste subthema");
        subtheme1.setTheme(theme1);

        //testcards
        Card card1 = new Card();
        card1.setCardId(1);
        card1.setName("Kaart1");
        card1.setSubthemeId(1);

        Card card2 = new Card();
        card2.setCardId(2);
        card2.setName("Kaart2");
        card2.setSubthemeId(1);

        Card card3 = new Card();
        card3.setCardId(3);
        card3.setName("Kaart3");
        card3.setSubthemeId(1);

        Card card4 = new Card();
        card4.setCardId(4);
        card4.setName("Kaart4");
        card4.setSubthemeId(1);

        Card card5 = new Card();
        card5.setCardId(5);
        card5.setName("Kaart5");
        card5.setSubthemeId(1);

        //Session
        GameSession gameSession = new GameSession();
        gameSession.setGameSessionId((long) 1);
        gameSession.setTitle("Sessie1");
        gameSession.setSubTheme(subtheme1);
        gameSession.setSelectionLimit(3);

        //add users to session
        UserGameSessionInfo userGameSessionInfo1 = new UserGameSessionInfo();
        userGameSessionInfo1.setUserGameSessionInfoId((long) 1);
        userGameSessionInfo1.setUser(user1);
        userGameSessionInfo1.setGameSession(gameSession);
        userGameSessionInfo1.setRole(GameSessionRole.ModeratorParticipant);
        user1.addUserGameSessionInfo(userGameSessionInfo1);
        gameSession.addUserGameSessionInfo(userGameSessionInfo1);

        UserGameSessionInfo userGameSessionInfo2 = new UserGameSessionInfo();
        userGameSessionInfo2.setUserGameSessionInfoId((long) 2);
        userGameSessionInfo2.setUser(user2);
        userGameSessionInfo2.setGameSession(gameSession);
        userGameSessionInfo2.setRole(GameSessionRole.Participant);
        user2.addUserGameSessionInfo(userGameSessionInfo2);
        gameSession.addUserGameSessionInfo(userGameSessionInfo2);

        UserGameSessionInfo userGameSessionInfo3 = new UserGameSessionInfo();
        userGameSessionInfo3.setUserGameSessionInfoId((long) 3);
        userGameSessionInfo3.setUser(user3);
        userGameSessionInfo3.setGameSession(gameSession);
        userGameSessionInfo3.setRole(GameSessionRole.Participant);
        user3.addUserGameSessionInfo(userGameSessionInfo3);
        gameSession.addUserGameSessionInfo(userGameSessionInfo3);


        //add cards to session
        List<CardGameSessionInfo> cardGameSessionInfoList = new ArrayList<>();

        CardGameSessionInfo cardGameSessionInfo1 = new CardGameSessionInfo();
        cardGameSessionInfo1.setCardGameSessionInfoId((long) 1);
        cardGameSessionInfo1.setCard(card1);
        cardGameSessionInfo1.setGameSession(gameSession);
        cardGameSessionInfoList.add(cardGameSessionInfo1);
        card1.addCardGameSessionInfo(cardGameSessionInfo1);

        CardGameSessionInfo cardGameSessionInfo2 = new CardGameSessionInfo();
        cardGameSessionInfo2.setCardGameSessionInfoId((long) 2);
        cardGameSessionInfo2.setCard(card2);
        cardGameSessionInfo2.setGameSession(gameSession);
        cardGameSessionInfoList.add(cardGameSessionInfo2);
        card2.addCardGameSessionInfo(cardGameSessionInfo2);

        CardGameSessionInfo cardGameSessionInfo3 = new CardGameSessionInfo();
        cardGameSessionInfo3.setCardGameSessionInfoId((long) 3);
        cardGameSessionInfo3.setCard(card3);
        cardGameSessionInfo3.setGameSession(gameSession);
        cardGameSessionInfoList.add(cardGameSessionInfo3);
        card3.addCardGameSessionInfo(cardGameSessionInfo3);

        CardGameSessionInfo cardGameSessionInfo4 = new CardGameSessionInfo();
        cardGameSessionInfo4.setCardGameSessionInfoId((long) 4);
        cardGameSessionInfo4.setCard(card4);
        cardGameSessionInfo4.setGameSession(gameSession);
        cardGameSessionInfoList.add(cardGameSessionInfo4);
        card4.addCardGameSessionInfo(cardGameSessionInfo4);

        CardGameSessionInfo cardGameSessionInfo5 = new CardGameSessionInfo();
        cardGameSessionInfo5.setCardGameSessionInfoId((long) 5);
        cardGameSessionInfo5.setCard(card5);
        cardGameSessionInfo5.setGameSession(gameSession);
        cardGameSessionInfoList.add(cardGameSessionInfo5);
        card5.addCardGameSessionInfo(cardGameSessionInfo5);

        gameSession.setCardGameSessionInfos(cardGameSessionInfoList);
        System.out.println(gameSession.getUserGameSessionInfos().toString());
        gameSession.start();

    }
}
