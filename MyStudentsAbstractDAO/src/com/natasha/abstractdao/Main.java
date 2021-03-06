package com.natasha.abstractdao;


import com.natasha.abstractdao.dao.abstr.NewGroupDAO;
import com.natasha.abstractdao.model.GroupDbModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {

    static String JDBC_DRIVER_NAME = "com.mysql.jdbc.Driver";
    static String CONN_STRING = "jdbc:mysql://localhost:3306/my_students";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER_NAME);

        Connection dbConnect = DriverManager.getConnection(CONN_STRING, "root", "123");
        try {
            NewGroupDAO gDao = new NewGroupDAO(dbConnect);
            List<GroupDbModel> allGroupd = gDao.getAllModels();
            for (GroupDbModel gr : allGroupd) {
                gr.toString();
            }
        } finally {
            dbConnect.close();
        }
    }
}
