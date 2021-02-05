package com.vastika.util;

public class QueryUtil {
    public static final String SAVE_SQL = "insert into user_tbl1(user_name,password,mobileNo,salary,dob,enable)values(?,?,?,?,?,?)";
    public static final String UPDATE_SQL = "update user_tbl1 set user_name=?,password=?,mobileNo=?,salary=?,dob=?,enable=? where id=?";
    public static final String DELETE_SQL = "delete from user_tbl1 where id=?";
    public static final String LIST_SQL = "select * from user_tbl1";
    public static final String GET_BY_ID_SQL = "select * from user_tbl1 where id=?";

}
