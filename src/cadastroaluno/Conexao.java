package cadastroaluno;

import java.sql.*;
import cadastroaluno.ConexaoBanco;

public class Conexao {
    String driver = "com.mysql.jdbc.Driver"; //Driver para conexao com o Banco - NAO ALTERAR
    String banco = "CadAluno"; //Nome do Banco de Dados - INFORME O NOME DO SEU BANCO
    String host = "localhost"; //Servidor de Banco de Dados - NAO ALTERAR
    String stringDeConexao = "jdbc:mysql://" + host + ":3306/" + banco + "?serverTimezone=UTC"; //String de Conexao com o Banco de Dados - NAO ALTERAR
    String usuario = "root"; //Usuario do Banco de Dados - INFORME USUARIO
    String senha = "Senha123"; //Senha do Usuario - INFORME A SENHA

    public Connection conexao;
    
    /** Creates a new instance of Conexao */
    public Conexao()
    {
    }
    
    public Connection getConexao()
    {
        try
        {
            Class.forName(driver); //Carrega o driver
            return DriverManager.getConnection(this.stringDeConexao,usuario, senha);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return conexao;
        }
    }
    
    public ResultSet getResultSet(String sentenca)
    {
        try
        {
            Statement stm = new ConexaoBanco().getInstanceStatement();
            ResultSet rs = stm.executeQuery(sentenca);
            return rs;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public String atualizarBanco(String sentenca)
    {
        try
        {
            Statement stm = new ConexaoBanco().getInstanceStatement();
            stm.executeUpdate(sentenca);
            return "1";
        }
        catch (SQLException e)
        {
            return e.getMessage();
        }
        catch (Exception ex)
        {
            return ex.getMessage();
        }
    } 
    
}
