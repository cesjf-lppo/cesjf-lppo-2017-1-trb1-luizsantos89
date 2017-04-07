<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<!DOCTYPE html>
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
                    <h1>Registro de Equipamento:</h1>
                    <form method="post">
                        <table>
                            <tr>
                                <th>Série: </th>
                                <td><input type="text" name="serie" /></td>
                            </tr>
                            <tr>
                                <th>Local: </th>
                                <td><input type="text" name="local" /></td>
                            </tr>
                            <tr>
                                <th>Descrição </th>
                                <td>
                                    <textarea name="descricao"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <th>Estado:</th>
                                <td>
                                    <select name="estado">
                                        <option value="0">Novo</option>
                                        <option value="1">Em Uso</option>
                                        <option value="2">Danificado</option>
                                        <option value="3">Perdido</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <button type="reset">Limpar</button>
                                </td>
                                <td>
                                    <button type="submit">Enviar</button>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
                <div id="rodape">
                    Desenvolvido por <a href="mailto:luiz.santos89@yahoo.com.br">Luiz Cláudio Afonso dos Santos</a> para a disciplina de Laboratório de Persistência de Objetos.<br />
                    Centro de Ensino Superior de Juiz de Fora - Bacharelado em Sistemas de Informação.
                </div>
            </div>
        </center>
    </body>
</html>