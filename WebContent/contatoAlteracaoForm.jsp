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
		Contato contato = new Contato();

		String strId = request.getParameter("hId");
		Integer id = Integer.parseInt(strId);
		contato = ContatoRepository.retrieveById(id);
	%>



	<form id="frm1" name="form1" method="post" action="contatoScript.jsp">

		<input type="hidden" name="action" value="update" />
		<input type="hidden" name="hId" value="<%=contato.getId()%>" />

		<table>
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="tNome" required="required"
					value="<%=contato.getName()%>" /></td>
			</tr>
			<tr>
				<td>E-mail:</td>
				<td><input type="email" name="eEmail"
					value="<%=contato.getEmail()%>" /></td>
			</tr>
			<tr>
				<td>Telefone:</td>
				<td><input type="text" name="tPhone"
					value="<%=contato.getPhone()%>" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="sSend"
					value="Enviar" /></td>
			</tr>
		</table>

	</form>

</body>
</html>