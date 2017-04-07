
package br.cesjf.lppo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "NovoEquipamento", urlPatterns = {"/novo-registro.html"})
public class NovoEquipamento extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        request.getRequestDispatcher("WEB-INF/novo-registro.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String serie = request.getParameter("serie");
        String local = request.getParameter("local");
        String descricao = request.getParameter("descricao");
        int estado = Integer.parseInt(request.getParameter("estado"));
        
        Logger.getLogger(NovoEquipamento.class.getName()).log(Level.INFO, "POST: " +serie+" "+local+""+descricao+""+estado);
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527//lppo-2017-1";  
            Connection conexao = DriverManager.getConnection(url, "usuario", "senha");
            System.out.println("Conexao aberta com sucesso");
            String sql = "INSERT INTO equipamento (serie,local,descricao,estado) VALUES ('"
                    +serie+ "','"
                    +local+ "','"
                    +descricao+ "',"
                    +estado+")";
            Statement operacao = conexao.createStatement();
            System.out.println(sql);
            operacao.executeUpdate(sql);             
        } catch (Exception e) {
            Logger.getLogger(NovoEquipamento.class.getName()).log(Level.SEVERE, "Erro ao inserir o registro!" +e);            
            
        }
        response.sendRedirect("lista.html");
    }
}
