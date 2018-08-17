package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.mail.PasswordAuthentication;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MemberService;
import com.service.SendMail;
import com.vo.MemberVo;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("*.do")
public class RegisterServlet extends HttpServlet {

	public RegisterServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		MemberService service = new MemberService();
		System.out.println(command);
		if (command.equals("/confirm.do")) {
			String userid = request.getQueryString();
			List<MemberVo> list = service.selectMemberCount(userid);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = response.getWriter();
			if (list.size() > 0) {
				writer.print("false");
			} else {
				writer.print("true");
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		MemberService service = new MemberService();
		if(command.equals("/register.do")) {
			MemberVo.Builder builder = new MemberVo.Builder();
			MemberVo vo = builder.withUserid(request.getParameter("userid"))
					             .withPasswd(request.getParameter("passwd"))
								 .withUsername(request.getParameter("username"))
								 .withPost(request.getParameter("post"))
								 .withAddr1(request.getParameter("addr1"))
								 .withAddr2(request.getParameter("addr2"))
								 .withPhone1(request.getParameter("phone"))
								 .withPhone2("none")
								 .withPhone3("none")
								 .withEmail1(request.getParameter("email"))
								 .withEmail2("none")
								 .build();
			int i = service.insertMember(vo);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = response.getWriter();
			if(i==1) {
				writer.write("회원가입 성공");
			}else {
				writer.write("회원가입 실패");
			}
		}
	}

}
