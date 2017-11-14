/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abimanager;

/**
 *
 * @author Piotr.Piróg
 */
public class Login {
 
    public static int authenticate(String username, String password) {
        // hardcoded username and password
        
         if (username.equals("user") && password.equals("secret")) {
            return 1;
        }
        if (username.equals("asi") && password.equals("secret")) {
            return 2;
        }
   
       if (username.equals("abi") && password.equals("secret")) {
            return 3;
        }
       if (username.equals("ado") && password.equals("secret")) {
            return 4;
        }
        if (username.equals("admin") && password.equals("secret")) {
            return 5;
        }
        
        
        return 0;
    }
}