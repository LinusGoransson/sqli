/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inloggning;

/**
 *
 * @author Lobo
 */
public class User {
    
    private String username;
    private int userlvl;

    public User(String username, int userlvl) {
        setUserlvl(userlvl);
        setUsername(username);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserlvl() {
        return userlvl;
    }

    private void setUserlvl(int userlvl) {
        if(userlvl < 0){
            userlvl = 0;
        }
        this.userlvl = userlvl;
    }
    
}
