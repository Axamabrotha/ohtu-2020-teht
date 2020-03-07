package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password
        boolean usr = false;
        boolean pwd = true;
        
        if (username.length() >= 3) {
            char[] charArray = username.toCharArray();
            for(int i=0; i<charArray.length; ++i) {
                if(Character.isLowerCase(charArray[i]))
                    usr = true;
            }
        } else usr = false;
        
        if (password.length() >= 8) {
            char[] charArray2 = password.toCharArray();
            
            for(int k=0; k<charArray2.length; ++k) {
                if(Character.isLetterOrDigit(charArray2[k]))
                    pwd = true;
            }

            
        } else pwd = false;
        
        if (usr == true && pwd == true) {
            return false;
        } else return true;
    }
}
