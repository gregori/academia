<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Novo Pagamento</title>
 
<style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>
 
    <h2>Registration Form</h2>
  
    <form:form method="POST" modelAttribute="pagamento">
        <form:input type="hidden" path="id" id="id"/>
        <table>
            <tr>
                <td><label for="aluno">Aluno: </label> </td>
                <td><form:input path="aluno" id="aluno"/></td>
                <td><form:errors path="aluno" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="dtPagamento">Data Pagamento: </label> </td>
                <td><form:input path="dtPagamento" id="dtPagamento"/></td>
                <td><form:errors path="dtPagamento" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td><label for="salary">Valor: </label> </td>
                <td><form:input path="valor" id="valor"/></td>
                <td><form:errors path="valor" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td><label for="ssn">ID: </label> </td>
                <td><form:input path="id" id="id"/></td>
                <td><form:errors path="id" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Register"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    Voltar a <a href="<c:url value='/list' />"> todos os pagamentos</a>
</body>
</html>