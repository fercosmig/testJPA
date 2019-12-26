<%@page import="java.util.List"%>
<%@page import="Repository.ContatoRepository"%>
<%@page import="model.Contato"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test JPA</title>
</head>
<body>

	<form id="frm1" name="form1" method="post" action="contatoScript.jsp">
		<input type="hidden" name="action" value="create" />
		<table>
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="tNome" required="required" /></td>
			</tr>
			<tr>
				<td>E-mail:</td>
				<td><input type="email" name="eEmail" /></td>
			</tr>
			<tr>
				<td>Telefone:</td>
				<td><input type="text" name="tPhone" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="sSend"
					value="Enviar" /></td>
			</tr>
		</table>

	</form>

	<%
		String nome = request.getParameter("tNome");
		if (nome != null && nome != "") {
			String email = request.getParameter("eEmail");
			String phone = request.getParameter("tPhone");
			Contato contato = new Contato();
			contato.setName(nome);
			contato.setEmail(email);
			contato.setPhone(phone);
			ContatoRepository.create(contato);
		}
	%>

	<br />
	<hr />
	<br />

	<table border="1">
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Email</th>
			<th>Telefone</th>
			<th>Data de cadastro</th>
			<th></th>
			<th></th>
		</tr>
		<%
			List<Contato> contatos = ContatoRepository.retrieveAll();
			for (Contato c : contatos) {
				out.println("<tr>");
				out.println("<td>");
				out.println(c.getId());
				out.println("</td>");
				out.println("<td>");
				out.println(c.getName());
				out.println("</td>");
				out.println("<td>");
				out.println(c.getEmail());
				out.println("</td>");
				out.println("<td>");
				out.println(c.getPhone());
				out.println("</td>");
				out.println("<td>");
				out.println(c.getRegistrationDate());
				out.println("</td>");
				out.println("<td>");
				out.println("<form method='post' action='contatoAlteracaoForm.jsp'>");
				out.println("<input type='hidden' name='hId' value='"+c.getId()+"' />");
				out.println("<input type='submit' name='sAlterar' value='Alterar' />");
				out.println("</form>");
				out.println("</td>");
				out.println("<td>");
				out.println("<form method='post' action='contatoScript.jsp'>");
				out.println("<input type='hidden' name='action' value='delete' />");
				out.println("<input type='hidden' name='hId' value='"+c.getId()+"' />");
				out.println("<input type='submit' name='sDelete' value='Excluir' />");
				out.println("</form>");
				out.println("</td>");
				out.println("</tr>");
			}
		%>
	</table>

</body>
</html>