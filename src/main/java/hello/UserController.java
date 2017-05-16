package hello;

import hello.models.User;
import hello.models.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by server on 2017/5/16.
 */
@RestController
public class UserController {


    /**
     * GET /create  --> Create a new user and save it in the database.
     */
    @RequestMapping("/create")
    public String create(String email, String name) {
        String userId = "";
        try {
            User user = new User(email, name);
            userDao.save(user);
            userId = String.valueOf(user.getId());
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created with id = " + userId;
    }

    /**
     * GET /delete  --> Delete the user having the passed id.
     */
    @RequestMapping("/delete")
    public String delete(long id) {
        try {
            User user = new User(id);
            userDao.delete(user);
        }
        catch (Exception ex) {
            return "Error deleting the user:" + ex.toString();
        }
        return "User succesfully deleted!";
    }

    /**
     * GET /get-by-email  --> Return the id for the user having the passed
     * email.
     */
    @RequestMapping("/get-by-email")
    public String getByEmail(String email) {
        String userId = "";
        String userName="";
        try {
            User user = userDao.findByEmail(email);
            userId = String.valueOf(user.getId());
            userName=user.getName();

        }
        catch (Exception ex) {
            return "User not found";
        }
        return "The user id is: " + userName;
    }

    @RequestMapping("/get-by-name")
    public String getByName(String name) {
        String userId = "";
        String userName="";
        try {
            User user = userDao.findByName(name);
            userId = String.valueOf(user.getId());
            userName=user.getName();

        }
        catch (Exception ex) {
            return "User not found";
        }
        return "The user id is: " + userName;
    }

    /**
     * GET /update  --> Update the email and the name for the user in the
     * database having the passed id.
     */
    @RequestMapping("/update")
    public String updateUser(long id, String email, String name) {
        try {
            User user = userDao.findOne(id);
//            user.setEmail(email);
//            user.setName(name);
            userDao.save(user);
        }
        catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }

    // Private fields

    @Autowired
    private UserDao userDao;
    }

