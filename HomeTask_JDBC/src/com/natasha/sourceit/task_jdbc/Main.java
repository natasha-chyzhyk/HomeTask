package com.natasha.sourceit.task_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        String jdbcDriverName = "com.mysql.jdbc.Driver";
        String connectionString = "jdbc:mysql://localhost:3306/vasya";

        Connection conn = null;
        PreparedStatement stmt = null;

        Class.forName(jdbcDriverName);

        conn = DriverManager.getConnection(connectionString, "root", "123");

        String query = "select * from vasya.account";
        stmt = conn.prepareStatement(query);

        stmt.execute();

        ResultSet rs = stmt.executeQuery();

        Map<Integer, Object> m = new HashMap<>();

        while (rs.next()) {
            Account account = new Account();
            account.setId(rs.getInt("id"));
            account.setName(rs.getString(("name").toString()));
            account.setAge(rs.getInt("age"));
            System.out.println(account.getId() + " " + account.getName() + " " + account.getAge() + " " +);

            m.put(account.getId(), account);
        }
    }
}
