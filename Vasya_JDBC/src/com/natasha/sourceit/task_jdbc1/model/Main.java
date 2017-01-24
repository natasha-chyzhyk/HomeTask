package com.natasha.sourceit.task_jdbc1.model;

import javax.security.auth.Subject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Stas on 18.01.2017.
 */

public class Main {
    static String JDBC_DRIVER_NAME = "com.mysql.jdbc.Driver";
    static String CONN_STRING = "jdbc:mysql://localhost:3306/vasya";

    public static void main(String[] args) {

        Connection conn = null;
        try {

            try {
                Main objMain = new Main(conn = openDatabase());
                objMain.doJob();
            }catch (ClassNotFoundException ex){}

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e){}
        }



    }


    private static Connection openDatabase() throws ClassNotFoundException, SQLException{
        Class.forName(JDBC_DRIVER_NAME);
        Connection conn = DriverManager.getConnection(CONN_STRING, "root", "123");
        return conn;
    }



    private Connection dbConn;
    private Main(Connection dbConn) {
        this.dbConn = dbConn;
    }

    private void doJob() throws SQLException {

        Map<Integer, SchoolDbModel> schools = getAllSchools();

        Map<Integer, RoomDbModel> rooms = getAllRooms(schools);

        Map<Integer, ClassDbModel> classes = getAllClasses(rooms);

        Map<Integer, AccountDbModel> account = getAllAccount(classes, rooms);
        for (AccountDbModel ac : account.values()){
            System.out.println(ac.getClass().getSimpleName() + ":" + ac.toString());
        }

        Map<Integer, SubjectDbModel> subject = getAllSubjects(rooms);
    }


    private Map<Integer, SchoolDbModel> getAllSchools() throws SQLException {
        String sql = "SELECT * FROM vasya.school;";
        Map<Integer, SchoolDbModel> schoolDbModelMap = new HashMap<>();
        ResultSet rs = dbConn.createStatement().executeQuery(sql);
        if (rs.first()) {
            do {
                SchoolDbModel school = new SchoolDbModel(rs.getInt(rs.findColumn("id")));
                school.setAddress(rs.getString(rs.findColumn("address")));
                school.setNumber(rs.getString(rs.findColumn("number")));
                school.setFloors(rs.getInt(rs.findColumn("floors")));
                schoolDbModelMap.put(school.getId(), school);
            } while (rs.next());
        }
        return schoolDbModelMap;
    }

    private Map<Integer, RoomDbModel> getAllRooms(Map<Integer, SchoolDbModel> schoolDbModelMap) throws SQLException {
            String sql = "SELECT * FROM vasya.room;";
            Map<Integer, RoomDbModel> roomDbModelMap = new HashMap<>();
            ResultSet rs = dbConn.createStatement().executeQuery(sql);
            if (rs.first()) {
                do {
                    RoomDbModel room = new RoomDbModel(rs.getInt(rs.findColumn("id")));
                    room.setNumber(rs.getString(rs.findColumn("number")));
                    room.setFloor(rs.getInt(rs.findColumn("floor")));
                    room.setAmount(rs.getInt(rs.findColumn("amount")));
                    room.setSchool(schoolDbModelMap.get(rs.getInt(rs.findColumn("school_id"))));
                    roomDbModelMap.put(room.getId(), room);
                }while (rs.next());
            }
        return roomDbModelMap;
    }

    private Map<Integer, ClassDbModel> getAllClasses(Map<Integer, RoomDbModel> rooms) throws SQLException {
        String sql = "SELECT * FROM vasya.class;";
        Map<Integer, ClassDbModel> classDbModelMap = new HashMap<>();
        ResultSet rs = dbConn.createStatement().executeQuery(sql);
        if (rs.first()) {
            do {
                ClassDbModel classDbModel = new ClassDbModel(rs.getInt(rs.findColumn("id")));
                classDbModel.setNumber(rs.getString(rs.findColumn("number")));
                classDbModel.setRoom(rooms.get(rs.getInt(rs.findColumn("room_id"))));
                classDbModelMap.put(classDbModel.getId(), classDbModel);
            } while (rs.next());
        }
        return classDbModelMap;
    }

    private Map<Integer, SubjectDbModel> getAllSubjects(Map<Integer, RoomDbModel> rooms) throws SQLException {
        String sql = "SELECT * FROM vasya.subject;";
        Map<Integer, SubjectDbModel> subjectDbModelMap = new HashMap<>();
        ResultSet rs = dbConn.createStatement().executeQuery(sql);
        if (rs.first()) {
            do {
                SubjectDbModel subject = new SubjectDbModel(rs.getInt(rs.findColumn("id")));
                subject.setName(rs.getString(rs.findColumn("name")));
                subject.setRoom(rooms.get(rs.getInt(rs.findColumn("room_id"))));
                subjectDbModelMap.put(subject.getId(), subject);
            }while (rs.next());
        }
        return subjectDbModelMap;
    }

    private Map<Integer, AccountDbModel> getAllAccount(Map<Integer, ClassDbModel> classDbModelMap, Map<Integer, RoomDbModel> rooms) throws SQLException {
        String sql = "SELECT * FROM vasya.account;";
        Map<Integer, AccountDbModel> accountDbModelMap = new HashMap<>();
        ResultSet rs = dbConn.createStatement().executeQuery(sql);
        if (rs.first()) {
            do {
                AccountDbModel account = new AccountDbModel(rs.getInt(rs.findColumn("id")));
                account.setName(rs.getString(rs.findColumn("name")));
                account.setAge(rs.getInt(rs.findColumn("age")));
                account.setClasses(classDbModelMap.get(rs.getInt(rs.findColumn("class_id"))));
                account.setSudject(getSubjectsforAccount(rs.getInt(rs.findColumn("id")), rooms));
                accountDbModelMap.put(account.getId(), account);
            } while (rs.next());
        }
        return accountDbModelMap;
    }

    private List<SubjectDbModel> getSubjectsforAccount(int account_id, Map<Integer, RoomDbModel> rooms) throws SQLException {

        List<Integer> subIds = selectSubjectIdsForAccount(account_id);

        List<SubjectDbModel> subjectDbModel = selectSubjectsForIds(subIds, rooms);
        return subjectDbModel;
    }

    private List<Integer> selectSubjectIdsForAccount(int account_id) throws SQLException {

        List<Integer> subjectIdsForAccount = new ArrayList<>();

        String sql = String.format("SELECT * FROM vasya.account_to_subject WHERE account_id = %d;", account_id);
        ResultSet rs = dbConn.createStatement().executeQuery(sql);
        if (rs.first()) {
            do {
                subjectIdsForAccount.add(rs.getInt(rs.findColumn("subject_id")));
            } while (rs.next());
        }
        return subjectIdsForAccount;
    }

    private List<SubjectDbModel> selectSubjectsForIds(List<Integer> subIds, Map<Integer, RoomDbModel> rooms)throws SQLException{

        List<SubjectDbModel> subjects = new ArrayList<>();
        String sIds = getWhereForIN("id", subIds);
        String sql = String.format("SELECT * FROM vasya.subject WHERE %s;", sIds);
        ResultSet rs = dbConn.createStatement().executeQuery(sql);

            if (rs.first()) {
                do {
                    SubjectDbModel subjectDbModel = new SubjectDbModel(rs.getInt(rs.findColumn("id")));
                    subjectDbModel.setName(rs.getString(rs.findColumn("name")));
                    subjectDbModel.setRoom(rooms.get(rs.getInt(rs.findColumn("room_id"))));
                    subjects.add(subjectDbModel);
                } while (rs.next());
            }

        return subjects;
    }

    private String getWhereForIN(String colName, List<Integer> ids) {
        StringBuilder sb = new StringBuilder("("+colName+" IN (");
        for (int i=0; i<ids.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(ids.get(i));
        }
        sb.append("))");
        return sb.toString();
    }
}
