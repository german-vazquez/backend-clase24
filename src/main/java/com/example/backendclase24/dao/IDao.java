package com.example.backendclase24.dao;

import java.util.List;

public interface IDao <T>{
    T guardar (T t);
    T buscar (Integer id);
    T buscarXCriterio (String criterio);
    List<T> buscarTodos ();
}
