package com.natasha.sourceit.task_jdbc;

import com.natasha.sourceit.task_jdbc.dao.abstr.SchoolDAO;
import com.natasha.sourceit.task_jdbc.model.SchoolDbModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


public class Main {
    static String JDBC_DRIVER_NAME = "com.mysql.jdbc.Driver";
    static String CONN_STRING = "jdbc:mysql://localhost:3306/vasya";



        public static void main(String[] args) throws ClassNotFoundException, SQLException {

            Class.forName(JDBC_DRIVER_NAME);

            Connection dbConnect = DriverManager.getConnection(CONN_STRING, "root", "123");
            try {
                SchoolDAO gDao = new SchoolDAO(dbConnect);

                List<SchoolDbModel> allGroupd = gDao.getAllModels();

                for (SchoolDbModel gr : allGroupd) {
                    System.out.println(gr.getClass().getSimpleName() + ":" + gr.toString());
                }

            } finally {
                dbConnect.close();
            }
        }

}
