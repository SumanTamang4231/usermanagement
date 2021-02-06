package com.vastika.controller;

import com.vastika.enums.OperationTypeEnum;
import com.vastika.model.User;
import com.vastika.service.UserService;
import com.vastika.service.UserServiceImpl;

import javax.swing.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;



public class UserController {


    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        String decision = "";
        {
            String choice = JOptionPane.showInputDialog("Enter which operation you want to perform: save|update|delete|List|get");

            switch (choice) {
            case "save":
                com.vastika.model.User savedUser = getUser(OperationTypeEnum.SAVE.name());
                int save = userService.saveUser(savedUser);
                if (save >= 1) {
                    JOptionPane.showMessageDialog(null, "User info is saved sucessfully");
                } else {
                    JOptionPane.showMessageDialog(null, "OPPS Error ");
                }
                break;
            case "update":
                com.vastika.model.User updatedUser = getUser(OperationTypeEnum.UPDATE.name());
                int updated = userService.updateUser(updatedUser);
                if (updated >= 1) {
                    JOptionPane.showMessageDialog(null, "User info is updated sucessfully");
                } else {
                    JOptionPane.showMessageDialog(null, "OPPS Error ");
                }
                break;
            case "delete":
                int deleteid = Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete from the jdbc"));
                int deleted = userService.deleteUser(deleteid);
                if (deleted >= 1) {
                    JOptionPane.showMessageDialog(null, "User deleted is updated sucessfully");
                } else {
                    JOptionPane.showMessageDialog(null, "OPPS Error ");
                }
                break;
            case "list":
                List<User> userList = userService.getAllUser();

                userList.forEach(user -> {
                    System.out.println("User id is : " + user.getId());
                    System.out.println("User name is : " + user.getUsername());
                    System.out.println("User password is : " + user.getPassword());
                    System.out.println("User mobieNo is : " + user.getMobileNo());
                    System.out.println("User Salary is : " + user.getSalary());
                    System.out.println("User DOB is : " + user.getDob());
                    System.out.println(" is user enabled: " + user.isEnable());
                    System.out.println("===========================================");
                });
                break;
            case "get":
                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id "));
                User user = userService.getUserById(id);
                System.out.println("User id is : " + user.getId());
                System.out.println("User name is : " + user.getUsername());
                System.out.println("User password is : " + user.getPassword());
                System.out.println("User mobieNo is : " + user.getMobileNo());
                System.out.println("User Salary is : " + user.getSalary());
                System.out.println("User DOB is : " + user.getDob());
                System.out.println(" is user enabled: " + user.isEnable());
                break;

        }

        decision = JOptionPane.showInputDialog("do you want to continue? Enter yes|no:");
    }
    while (decision.equalsIgnoreCase("yes"));

    }

    public static User getUser(String type){
        User user=new User();
        if (type.equalsIgnoreCase("update")){
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id:"));
            user.setId(id);
        }
        String username=JOptionPane.showInputDialog("Enter username:");
        String password=JOptionPane.showInputDialog("Enter password:");
      long mobileNo =Long.parseLong(JOptionPane.showInputDialog("Enter the mobile NO"));
      double salary= Double.parseDouble(JOptionPane.showInputDialog("Enter the salary"));
      String dob = JOptionPane.showInputDialog("Enter dob:");
        LocalDate d = LocalDate.parse(dob,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        boolean enable = Boolean.parseBoolean(JOptionPane.showInputDialog("is user enable?"));
        user.setUsername(username);
        user.setPassword(password);
        user.setMobile_no(mobileNo);
        user.setEnable(enable);
        user.setSalary(salary);
        user.setDob(d);
        return user;
    }


}
