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
                    <h1>Edita registro de Equipamento</h1>
                    <table>
                        <form method="post">
                            <input type="hidden" name="id" value="${equipamento.id}"/>
                        <tr>
                            <th>Equipamento: </th>
                            <td>${equipamento.serie}</td>
                        </tr>
                        <tr>
                            <th>Local: </th>
                            <td><input type="text" value="${equipamento.local}" name="local" /></td>
                        </tr>
                        <tr>
                            <th>Estado: </th>
                            <td>
                                <select name="estado">
                                        <option value="0">Novo</option>
                                        <option value="1">Em uso</option>
                                        <option value="2">Danificado</option>
                                        <option value="3">Perdido</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <button type="submit">Alterar</button>
                            </td>
                        </tr>
                        </form>
                    </table>
                </div>
                <div id="rodape">
                    Desenvolvido por <a href="mailto:luiz.santos89@yahoo.com.br">Luiz Cláudio Afonso dos Santos</a> para a disciplina de Laboratório de Persistência de Objetos.<br />
                    Centro de Ensino Superior de Juiz de Fora - Bacharelado em Sistemas de Informação.
                </div>
            </div>
        </center>
    </body>
</html>