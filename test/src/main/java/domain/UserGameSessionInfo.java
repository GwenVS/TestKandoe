package domain;

import domain.user.User;

import java.util.List;

public class UserGameSessionInfo {

    private Long userGameSessionInfoId;

    private List<Notification> notifications;

    private boolean voted;

    private GameSessionRole role;

    private User user;

    private GameSession gameSession;

    public UserGameSessionInfo() {
    }

    public UserGameSessionInfo(List<Notification> notifications, boolean voted, GameSessionRole role, User user, GameSession gameSession) {
        this.notifications = notifications;
        this.voted = voted;
        this.role = role;
        this.user = user;
        this.gameSession = gameSession;
    }

    public Long getUserGameSessionInfoId() {
        return userGameSessionInfoId;
    }

    public void setUserGameSessionInfoId(Long userGameSessionInfoId) {
        this.userGameSessionInfoId = userGameSessionInfoId;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public boolean isVoted() {
        return voted;
    }

    public void setVoted(boolean voted) {
        this.voted = voted;
    }

    public GameSessionRole getRole() {
        return role;
    }

    public void setRole(GameSessionRole role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GameSession getGameSession() {
        return gameSession;
    }

    public void setGameSession(GameSession gameSession) {
        this.gameSession = gameSession;
    }
}
