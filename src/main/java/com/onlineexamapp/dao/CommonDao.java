package com.onlineexamapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onlineexamapp.model.Question;

public class CommonDao {
	
	
	public Question getQuestion(long subjectId,String questionNumber) {
		Question question=null;
		Connection con=null;
		try {
			con=getConnection();
			PreparedStatement stmt= con.prepareStatement("select * from questions where subject_id=? and question_number=?");
			stmt.setLong(1, subjectId);
			stmt.setString(2, questionNumber);
			
			ResultSet rs=stmt.executeQuery(); 
			question=new Question();
			while(rs.next()) {
				question.setId(rs.getLong("id"));
				question.setCorrectAnswer(rs.getInt("correct_answer"));
				question.setDescription(rs.getString("description"));
				question.setOption1(rs.getString("option_1"));
				question.setOption2(rs.getString("option_2"));
				question.setOption3(rs.getString("option_3"));
				question.setOption4(rs.getString("option_4"));
				question.setQuestionText(rs.getString("QUESTION_TEXT"));
				question.setTotalMarks(rs.getInt("TOTAL_MARKS"));
				question.setSujectId(subjectId);
			}
		}
		catch (SQLException ex) {ex.printStackTrace();}
		finally {
			try {
				if(con!=null)con.close();
			} catch (SQLException e) {
				
			}
		}
		return question;
	}

	private Connection getConnection() throws SQLException  {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/onlineexamapp","root","root");  

	}
}
