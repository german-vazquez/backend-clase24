package com.example.backendclase24.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {
    private static final String DRIVER="org.h2.Driver";
    private static final String URL="jdbc:h2:~/clase24";

    //este nuevo URL_CREATE que añadimos, se conecta a la base de datos y ejecuta el script.
    private static final String URL_CREATE=URL+";INIT=RUNSCRIPT FROM 'create.sql'";
    private static final String USER="sa";
    private static final String PASS="";

    /*
    private static final String SQL_CREATE_TABLE_DOMICILIOS=
            "drop table if exists domicilios;" +
            "create table domicilios(" +
            "id int auto_increment primary key, " +
            "calle varchar(100) not null, " +
            "numero int not null, " +
            "localidad varchar(100) not null, " +
            "provincia varchar(100) not null)";

    private static final String SQL_CREATE_TABLE_PACIENTES="drop table if exists pacientes;" +
            "create table pacientes(" +
            "id int auto_increment primary key, " +
            "apellido varchar(100) not null, " +
            "nombre varchar(100) not null, " +
            "dni int not null, " +
            "fecha date not null, " +
            "domicilio_id int not null," +
            "email varchar (100) not null)";

    private static final String SQL_PACIENTE1=
            "insert into domicilios (calle, numero, localidad, provincia)" +
                    "values ('calle1',484, 'saltacap', 'salta');" +
                    "insert into pacientes (apellido, nombre, dni, fecha, domicilio_id, email)" +
                    "values('vazquez', 'fulanito', 5845, '2022-08-25',1,'pupu@gmail.com')";

     */

    public static Connection getConnection() throws Exception{
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL,USER,PASS);
    }
    public static void crearTablas(){
        Connection connection=null;
        try{
            Class.forName(DRIVER);
            connection=DriverManager.getConnection(URL_CREATE,USER,PASS);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }


        /*
        Connection connection=getConnection();
        Statement statement=connection.createStatement();
        statement.execute(SQL_CREATE_TABLE_DOMICILIOS);
        statement.execute(SQL_CREATE_TABLE_PACIENTES);
        statement.execute(SQL_PACIENTE1);
        */
    }
}
