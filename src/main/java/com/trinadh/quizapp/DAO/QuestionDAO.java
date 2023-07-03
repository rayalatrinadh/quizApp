package com.trinadh.quizapp.DAO;


import com.trinadh.quizapp.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Repository
public class QuestionDAO {

    static final String url = "jdbc:postgresql://localhost:5432/Quiz";
    static final String user = "postgres";
    static final String password = "password";//"<add your password>";


    public  List<Question> questionDetailsFetch() throws SQLException {
        String query = "SELECT * FROM question";
        List<Question> list = new ArrayList<>();


        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            conn.setAutoCommit(false);
            ResultSet rs = pstmt.executeQuery();
            conn.commit();
            while (rs.next()) {

                Question que = new Question(rs.getInt("id"),
                        rs.getString("category"),
                        rs.getString("difficultylevel"),
                        rs.getString("option1"),
                        rs.getString("option2"),
                        rs.getString("option3"),
                        rs.getString("option4"),
                        rs.getString("question_title"),
                        rs.getString("right_answer")
                );

                list.add(que);
            }

            if (!conn.isClosed()) {
                System.out.println("\n\n");
                conn.close();
                pstmt.close();
                rs.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }


    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     * @throws SQLException
     */
    public static Connection connect() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            //Attempts to establish a connection to the given database URL
            //System.out.println("Establising a connection to the driver : " + url);
            conn = DriverManager.getConnection(url, user, password);
            //System.out.println("Connected to the PostgreSQL server successfully in JDBC_Connection.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Exception in JDBC_Connection.java");
        }
        return conn;
    }
}
