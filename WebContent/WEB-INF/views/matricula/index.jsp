<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Matricula</title>
<link rel="stylesheet"
	href="../assets/stylesheets/semantic.min.css" />
</head>
<body>
	<div class="ui fixed inverted menu">
		<div class="ui container">
			<a href="" class="header item">Index</a>
		</div>
	</div>
	<div class="ui main text container" style="padding-top: 80px">
		<table class="ui blue celled table">
			<thead>
				<tr>
					<th>#</th>
					<th>Data</th>
					<th>Validade</th>
					<th>Plano</th>
					<th>Aluno</th>
					<th></th>
				</tr>
			</thead>
			<c:if test="${matriculas.isEveryElementActive()}">
				<tbody>
					<c:forEach items="${matriculas}" var="matricula">
						<c:if test="${matricula.getIsActive()}">
							<tr>
								<td>${matricula.id}</td>
								<td>${matricula.data}</td>
								<td>${matricula.validade}</td>
								<td>${matricula.plano.descricao}</td>
								<td>${matricula.aluno.nome}</td>
								<td>
									<form method="POST" action="/academia/matricula/remove">
										<input type="hidden" name="id" value="${matricula.id}" /> <input
											type="submit" class="ui button red" value="Remover" />
									</form>
								</td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</c:if>
			<c:if test="${!matriculas.isEveryElementActive()}">
				<tbody>
					<tr>
						<td colspan="4">
							<div class="ui ribbon label">Nenhuma matricula foi cadastrada...</div>
						</td>
					</tr>
				</tbody>
			</c:if>
			<tfoot class="full-width">
				<tr>
					<th colspan="4">
						<div onclick="location.href='/matricula/car/add';"
							class="ui right floated small primary labeled icon button">
							<i class="plus icon"></i> Adicionar matricula
						</div>
					</th>
				</tr>
			</tfoot>
		</table>
	</div>

	<script type="text/javascript"
		src="../assets/javascripts/jquery.min.js"></script>
	<script type="text/javascript"
		src="../assets/javascripts/semantic.min.js"></script>
</body>
</html>