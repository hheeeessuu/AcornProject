package com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.TableDTO;
import com.service.MyTableService;

/**
 * Servlet implementation class MyBoardListServlet
 */
@WebServlet("/MyBoardListServlet")
public class MyBoardListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		String searchName= request.getParameter("searchName");
		String searchValue= request.getParameter("searchValue");
		
		HashMap<String, String> map = new HashMap<>();
		map.put("searchName", searchName);
		map.put("searchValue", searchValue);
		
		MyTableService service = new  MyTableService();
		List<TableDTO> list = service.select(map);
		
		request.setAttribute("list", list);
		
		RequestDispatcher dis = 
				request.getRequestDispatcher("table.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
