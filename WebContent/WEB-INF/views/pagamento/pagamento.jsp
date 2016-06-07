<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagamento Academia</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h2>List of Employees</h2>  
    <table>
        <tr>
            <td>Id</td><td>Aluno</td><td>Valor</td><td>Data de Pagamento</td>
        </tr>
        <c:forEach items="${pagamentos}" var="pagamento">
            <tr>
            <td>${pagamento.id}</td>
            <td>${pagamento.aluno}</td>
            <td>${pagamento.valor}</td>
            <td>${pagamento.dtpagamento}</td>
            <td><a href="<c:url value='/edit-${pagamento.id}-employee' />">Editar</a></td>
            <td><a href="<c:url value='/delete-${pagamento.id}-employee' />">Deletar</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/new' />">Novo Pagamento</a>
</body>
</html>