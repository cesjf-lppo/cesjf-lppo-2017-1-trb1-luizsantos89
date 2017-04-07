package br.cesjf.lppo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditaEquipamento", urlPatterns = {"/edita.html"})
public class EditaEquipamento extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Equipamento equipamento = new Equipamento();
        Long id = Long.parseLong(request.getParameter("id"));
        
        try {
            //Pegar os dados do banco
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527//lppo-2017-1", "usuario", "usuario");
             
             Statement operacao = conexao.createStatement();
             ResultSet resultado = operacao.executeQuery("SELECT * FROM equipamento WHERE id="+id);
                if(resultado.next()){
                    equipamento.setId(resultado.getInt("id"));        
                    equipamento.setLocal(resultado.getString("local"));
                    equipamento.setSerie(resultado.getString("serie"));
                    equipamento.setSerie(resultado.getString("resultado"));                    
                }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditaEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditaEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("equipamento", equipamento);
        request.getRequestDispatcher("WEB-INF/edita-equipamento.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Equipamento equipamento = new Equipamento();
        equipamento.setId(Integer.parseInt(request.getParameter("id")));
        equipamento.setEstado(Integer.parseInt(request.getParameter("estado")));
        equipamento.setLocal(request.getParameter("local"));
        
        try {
            //Pegar os dados do banco
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527//lppo-2017-1", "usuario", "usuario");
             
            Statement operacao = conexao.createStatement();
            String sql = "UPDATE equipamento SET estado = "
                     +equipamento.getEstado()+", local ='"
                     +equipamento.getLocal()+ "' WHERE id = "
                     +equipamento.getId();
            operacao.executeUpdate(sql);
            System.out.println(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditaEquipamento.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Impossível atualizar o BD");
        } catch (SQLException ex) {
            Logger.getLogger(EditaEquipamento.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro de conexão");
        }
                
        response.sendRedirect("lista.html");
    }
}
