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
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  


	}
	
	public List<Question> getQuestions(long subjectId) throws SQLException{
		Connection con=getConnection();
		List<Question> questions =null;
		try {
			PreparedStatement stmt= con.prepareStatement("select * from questions where suject_id=?");
			stmt.setLong(0, subjectId);
			ResultSet rs=stmt.executeQuery();  
			questions= new ArrayList<>();
			while(rs.next()) {
				Question question=new Question();
				question.setId(rs.getLong("id"));
				question.setCorrectAnswer(rs.getString("correct_answer"));
				question.setDescription(rs.getString("description"));
				question.setOption1(rs.getString("option_1"));
				question.setOption2(rs.getString("option_2"));
				question.setOption3(rs.getString("option_3"));
				question.setOption4(rs.getString("option_4"));
				question.setQuestionText(rs.getString("QUESTION_TEXT"));
				question.setTotalMarks(rs.getInt("TOTAL_MARKS"));
				question.setSujectId(subjectId);
				questions.add(question);
			}
		} finally {
			con.close();
		}
		return questions;
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/sonoo","root","root");  

	}
}
