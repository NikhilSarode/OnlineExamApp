package com.onlineexamapp.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineexamapp.dao.CommonDao;
import com.onlineexamapp.model.Question;
import com.onlineexamapp.model.Subject;

public class QuestionsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =request.getRequestDispatcher("QuestionView/Question.jsp");
		String questionNumber=request.getParameter("nextQuestionNumber");
		if(questionNumber==null)questionNumber=request.getParameter("previousQuestionNumber");
		if(questionNumber==null)questionNumber="0";
		
		CommonDao commonDao = new CommonDao();
		Question question=commonDao.getQuestion(1, questionNumber);
		request.setAttribute("question", question);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
