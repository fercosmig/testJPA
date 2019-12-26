<%@page import="Repository.ContatoRepository"%>
<%@page import="model.Contato"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String strId = "";
		Integer id = 0;
		String nome = "";
		String email = "";
		String phone = "";
		Contato contato = null;
		String action = request.getParameter("action");

		switch (action) {
		case "create":
			nome = request.getParameter("tNome");
			email = request.getParameter("eEmail");
			phone = request.getParameter("tPhone");
			contato = new Contato();
			contato.setName(nome);
			contato.setEmail(email);
			contato.setPhone(phone);
			ContatoRepository.create(contato);
			break;
		case "update":
			strId = request.getParameter("hId");
			id = Integer.parseInt(strId);
			contato = ContatoRepository.retrieveById(id);
			nome = request.getParameter("tNome");
			email = request.getParameter("eEmail");
			phone = request.getParameter("tPhone");
			contato.setName(nome);
			contato.setEmail(email);
			contato.setPhone(phone);
			ContatoRepository.update(contato);
			break;
		case "delete":
			strId = request.getParameter("hId");
			id = Integer.parseInt(strId);
			contato = ContatoRepository.retrieveById(id);
			contato.setStatus(false);
			ContatoRepository.update(contato);
			break;
		}
		response.sendRedirect("index.jsp");
	%>

</body>
</html>