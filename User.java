package model;

/**
 *
 * @author Unicen Cola Candy
 */
public class User {
    private String username;
    private String password;
    private String type;
    
    public User(){
        
    }
    
    public User(String username, String password, String type){
        this.username = username;
        this.password = password;
        this.type = type;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public String getType(){
        return this.type;
    }
}
