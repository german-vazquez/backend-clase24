package com.example.backendclase24.servicio;

import com.example.backendclase24.dao.IDao;

import com.example.backendclase24.dao.OdontologoDAOH2;
import com.example.backendclase24.modelo.Odontologo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OdontologoService {
    private IDao<Odontologo> odontologoIDao;

    public OdontologoService() {
        this.odontologoIDao = new OdontologoDAOH2();
    }
    public Odontologo guardar(Odontologo odontologo){
        return odontologoIDao.guardar(odontologo);
    }
    public Odontologo buscarOdontologoXId(Integer id){
        return odontologoIDao.buscar(id);
    }

    public List<Odontologo> buscarTodos(){
        return odontologoIDao.buscarTodos();
    }

}


