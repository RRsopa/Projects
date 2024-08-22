package com.example.ezparking;

import java.sql.*;

public class DataBase {
    private static final String URL = "";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";

    private Connection connection;

    public DataBase() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }

    public void runQuery(String query){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String id = resultSet.getString("IDAcesso");
                String name = resultSet.getString("Nome");
                int contact = resultSet.getInt("Contacto");
                String status = resultSet.getString("Estatuto");
                String subName = resultSet.getString("NomeSubscricao");
                String endSub = resultSet.getString("FimSubscricao");
                String regName = resultSet.getString("NomeRegime");
                System.out.println("IDAcesso: " + id + " |Nome: " + name + " |Contacto: " + contact + " |Estatuto: " + status
                 + " |Subscrição: " + subName + " |Fim de Subscrição: " + endSub + " |Plano: " + regName);
            } }
        catch(SQLException e){
                throw new RuntimeException(e);
            }
        }


        public User authenticateUser(String email, String pw){
        try{
            /*String query = "SELECT * FROM Pessoa LEFT OUTER JOIN searchClients ON searchClients.IDAcesso = Pessoa.IDAcesso WHERE Pessoa.IDAcesso = ? AND Password = ?" +
                    " UNION " +
                    "SELECT * FROM Pessoa LEFT OUTER JOIN searchWorkers ON searchWorkers.IDAcesso = Pessoa.IDAcesso WHERE Pessoa.IDAcesso = ? AND Password = ?";
            */
            String query = "SELECT * FROM Pessoa WHERE Pessoa.IDAcesso = ? AND Pessoa.Password = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, email);
            statement.setString(2, pw);
           /* statement.setString(3, email);
            statement.setString(4,email);*/

            ResultSet result = statement.executeQuery();
            if(result.next()){
                User user = new User(result.getString("Nome"), result.getString("IDAcesso"),
                        result.getInt("Contacto"), null, null, null, null);
                /*String status = result.getString("Pessoa.Estatuto");
                User user;
                if(status.equals("Cliente") || status.equals("Colaborador")){
                    user = new User(result.getString("Pessoa.Nome"),
                            result.getString("Pessoa.IDAcesso"),
                            result.getInt("Pessoa.Contacto"),
                            status,
                            result.getString(status + ".NomeSubscricao"),
                            result.getString(status + ".NomeRegime"),
                            "2023-03-05");
                            //result.getString(status + ".FimSubscricao"));
                }
                else {
                    user = new User(result.getString("Pessoa.Nome"),
                            result.getString("Pessoa.IDAcesso"),
                            result.getInt("Pessoa.Contacto"),
                            status, null, null, null);
                }*/
                return user;
                }
            else{
                return null;
            }
        }
        catch (SQLException e){
            throw new RuntimeException("Erro na ligação ao servidor");
        }
        }

        public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Connection to the database closed.");
        } catch (SQLException e) {
            System.err.println("Failed to close the database connection.");
            e.printStackTrace();
        }
    }
}