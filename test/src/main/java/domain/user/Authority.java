package domain.user;


public class Authority{

    private Long id;

    private String name;

    private User user;

    public Authority() {
    }

    public Authority(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public String getAuthority() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
