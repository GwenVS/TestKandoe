package domain.user;

import domain.UserGameSessionInfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class User{

    private long userId;

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private int day;

    private int month;

    private int year;

    private String encryptedPassword;

    private Gender gender;

    private List<Authority> authorities;

    private List<UserGameSessionInfo> userGameSessionInfos = new ArrayList<>();


    public User() {
    }


    public User(String firstName, String lastName, String username, String email, int day, int month, int year, String encryptedPassword, Gender gender, List<Authority> authorities) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.day = day;
        this.month = month;

        this.year = year;
        this.encryptedPassword = encryptedPassword;
        this.gender = gender;
        this.authorities = authorities;
    }



    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }
    public String getPassword() {
        return getEncryptedPassword();
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncryptedPassword(){
        return this.encryptedPassword;
    }

    public void setEncryptedPassword(String password) {
        this.encryptedPassword = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public List<Authority> getUserRoles(){
        return this.authorities;
    }

    public Calendar getBirthday(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(getYear(), getMonth() - 1, getDay());
        return calendar;
    }


    //added
    public List<UserGameSessionInfo> getUserGameSessionInfos() {
        return userGameSessionInfos;
    }

    public void setUserGameSessionInfos(List<UserGameSessionInfo> userGameSessionInfos) {
        this.userGameSessionInfos = userGameSessionInfos;
    }

    public void addUserGameSessionInfo(UserGameSessionInfo userGameSessionInfo) {
        this.userGameSessionInfos.add(userGameSessionInfo);
    }
}
