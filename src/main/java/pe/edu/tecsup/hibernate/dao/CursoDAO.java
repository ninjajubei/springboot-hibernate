/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.tecsup.hibernate.dao;

import java.util.List;
import pe.edu.tecsup.hibernate.helper.GenericDAO;
import pe.edu.tecsup.hibernate.model.Curso;

/**
 *
 * @author PCC
 */
public interface CursoDAO extends GenericDAO<Curso> {
    
    Curso getByCodigo(String codigo);

    List<Curso> getByNombre(String nombre);
    
}
