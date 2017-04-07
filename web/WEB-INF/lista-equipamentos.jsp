<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Registros</title>
        <link rel="stylesheet" href="style/main.css" />
    </head>
    <body>
    	<center>
            <div id="pagina">
                <div id="barra-menus">
                    <a href="lista.html">Listagem Geral</a>
                    <a href="lista-estado.html">Listagem com filtro</a>
                    <a href="novo-registro.html">Novo Registro</a>
                </div>
                <div id="conteudo">
                    <h1>Listagem de Registros</h1>
                    <table border="1">
                        <tr>
                            <th>Id/Editar:</th>
                            <th>Série:</th>
                            <th>Local:</th>
                            <th>Descrição:</th>
                            <th>Estado:</th>
                            <th>Excluir:</th>
                        </tr>
                        <c:forEach var="equipamento" items="${equipamentos}">
                            <tr>
                                <td align="center"><a href="edita.html?id=${equipamento.id}">${equipamento.id}</a></td>
                                <td>${equipamento.serie}</td>
                                <td>${equipamento.local}</td>
                                <td>${equipamento.descricao}</td>
                                <c:if test="${equipamento.estado==0}">
                                    <td>Novo</td>
                                </c:if>
                                <c:if test="${equipamento.estado==1}">
                                    <td>Em Uso</td>
                                </c:if>
                                <c:if test="${equipamento.estado==2}">
                                    <td>Danificado</td>
                                </c:if>
                                <c:if test="${equipamento.estado==3}">
                                    <td>Perdido</td>
                                </c:if>
                                <td><a href="exclui.html?id=${equipamento.id}">X</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <br /><br />
                    <a href="novo-registro.html">Registrar novo equipamento</a>
                </div>
                <div id="rodape">
                    Desenvolvido por <a href="mailto:luiz.santos89@yahoo.com.br">Luiz Cláudio Afonso dos Santos</a> para a disciplina de Laboratório de Persistência de Objetos.<br />
                    Centro de Ensino Superior de Juiz de Fora - Bacharelado em Sistemas de Informação.
                </div>
            </div>
        </center>
    </body>
</html>