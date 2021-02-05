package com.vastika.controller;

import com.vastika.model.User;
import com.vastika.service.UserService;
import com.vastika.service.UserServiceImpl;

import javax.swing.*;

import static org.graalvm.compiler.options.OptionType.User;

public class UserController {


    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
    String choice  = JOptionPane.showInputDialog("Enter which operation you want to perform: save|update|delete|List|get");
    switch (choice){
        case"save":
            com.vastika.model.User savedUser = new User();
          int save=  userService.saveUser(savedUser);
          if (save>=1){
              JOptionPane.showMessageDialog(null,"User info is saved sucessfully");
          }else{
              JOptionPane.showMessageDialog(null,"OPPS Error ");
          }
            break;
        case "update":
            com.vastika.model.User updatedUser = new User();
           int updated= userService.updateUser(updatedUser);
            if (updated>=1){
                JOptionPane.showMessageDialog(null,"User info is updated sucessfully");
            }else{
                JOptionPane.showMessageDialog(null,"OPPS Error ");
            }
            break;
        case"delete":
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete from the jdbc"));
            int deleted =userService.deleteUser(id);
            if (deleted>=1){
                JOptionPane.showMessageDialog(null,"User deleted is updated sucessfully");
            }else{
                JOptionPane.showMessageDialog(null,"OPPS Error ");
            }
            break;
        case"list":


    }
    while (true);

    }

    
}
