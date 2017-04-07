package br.cesjf.lppo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListaEquipamentoEstado", urlPatterns = {"/lista-estado.html"})
public class ListaEquipamentoEstado extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            
        List<Equipamento> equipamentos = new ArrayList<>();
        
        try {
            //Pegar os dados do banco
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1","usuario","senha");
            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery("SELECT * FROM equipamento ORDER BY local");
            while(resultado.next()) {
                Equipamento equipamento = new Equipamento();
                equipamento.setId(resultado.getInt("id"));
                equipamento.setSerie(resultado.getString("serie"));
                equipamento.setLocal(resultado.getString("local"));
                equipamento.setDescricao(resultado.getString("descricao"));
                equipamento.setEstado(resultado.getInt("estado"));
                equipamentos.add(equipamento);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("equipamentos", equipamentos);
        request.getRequestDispatcher("WEB-INF/lista-equip-estado.jsp").forward(request,response);
        }
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
        int filtro;
        
        if (request.getParameter("filtro-estado")==null) {
            filtro = -1;
        } else {
            filtro = Integer.parseInt(request.getParameter("filtro-estado"));
        }
        
            
        List<Equipamento> equipamentos = new ArrayList<>();
        
        try {
            //Pegar os dados do banco
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1","usuario","usuario");
            Statement operacao = conexao.createStatement();
            ResultSet resultado;
            if (filtro==-1) {
                resultado = operacao.executeQuery("SELECT * FROM equipamento ORDER BY local");
            } else {
                resultado = operacao.executeQuery("SELECT * FROM equipamento WHERE estado = " + filtro + " ORDER BY local");
            }
            while(resultado.next()) {
                Equipamento equipamento = new Equipamento();
                equipamento.setId(resultado.getInt("id"));
                equipamento.setSerie(resultado.getString("serie"));
                equipamento.setLocal(resultado.getString("local"));
                equipamento.setDescricao(resultado.getString("descricao"));
                equipamento.setEstado(resultado.getInt("estado"));
                equipamentos.add(equipamento);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("equipamentos", equipamentos);
        request.getRequestDispatcher("WEB-INF/lista-equip-estado.jsp").forward(request,response);
        }        
        
    }
    
}
