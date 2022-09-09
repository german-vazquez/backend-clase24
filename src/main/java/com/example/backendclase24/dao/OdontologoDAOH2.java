package com.example.backendclase24.dao;

import com.example.backendclase24.bd.BD;
import com.example.backendclase24.modelo.Domicilio;
import com.example.backendclase24.modelo.Odontologo;
import com.example.backendclase24.modelo.Paciente;

import java.sql.*;
import java.util.List;

public class OdontologoDAOH2 implements IDao<Odontologo> {

    private static final String SQL_GUARDAR =
            "insert into odontologos (apellido, nombre, matricula)" +
                    " values (?,?,?)";
    private static final String SQL_BUSCAR_X_ID =
            "select * from odontologos where ID=?";
    private static final String SQL_BUSCAR_TODOS =
            "select * from odontologos";

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        try {
            connection = BD.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_GUARDAR, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, odontologo.getApellido());
            ps.setString(2, odontologo.getNombre());
            ps.setString(3, odontologo.getMatricula());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                odontologo.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return odontologo;
    }

    @Override
    public Odontologo buscar(Integer id) {
        Connection connection = null;
        Odontologo odontologo = null;
        try {
            connection = BD.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_BUSCAR_X_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                odontologo = new Odontologo(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public Odontologo buscarXCriterio(String criterio) {
        return null;
    }


    @Override
    public List<Odontologo> buscarTodos() {
        Connection connection = null;
        List<Odontologo> odontologos = null;
        try {
            connection = BD.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_BUSCAR_TODOS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                odontologos.add(new Odontologo(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return odontologos;
    }
}

