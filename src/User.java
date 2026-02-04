public class User {

    static int userCount=1;
    private int userId;
    private String userName;
    private String password;

    public User(String userName, String password){
        userId = userCount++;
        this.userName = userName;
        this.password = password;
    }

    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }
    public int getUserId(){
        return userId;
    }


}
