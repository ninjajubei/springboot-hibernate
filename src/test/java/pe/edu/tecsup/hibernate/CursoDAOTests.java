/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.tecsup.hibernate;

import java.util.List;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.edu.tecsup.hibernate.dao.CursoDAO;
import pe.edu.tecsup.hibernate.model.Curso;

/**
 *
 * @author PCC
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CursoDAOTests {
    
    Date hoy = new Date();
    
    @Autowired
    CursoDAO cursoDAO;
    
    @Test
    public void verifyList() {

        List<Curso> cursos = cursoDAO.list();
        for (Curso curso : cursos) {
            System.out.println(curso.getId());
            System.out.println(curso.getNombre());
            try{
                System.out.println(curso.getPrograma().getNombre());
            } catch (Exception e){
                System.out.println("programa null");
            }
            
        }
        Assert.assertTrue(cursos.size() > 0);
    }
    
    //@Test
    public void verifyFind() {
        Curso curso = cursoDAO.get(34l);
        System.out.println(curso.getNombre());
        Assert.assertTrue(curso.getId() == 34);
    }
    
    //@Test
    public void verifySave() {

        Curso curso = new Curso();
        curso.setCodigo("1020");
        curso.setNombre("Nuevo Curso");
        curso.setFechaInicio(hoy);

        cursoDAO.save(curso);
        Assert.assertTrue(curso.getId() != null);
    }
    
    //@Test
    public void verifyUpdate() {

        // cambiar el código para validar
        Curso curso = new Curso();
        curso.setId(31l);
        curso.setCodigo("159");
        curso.setNombre("Curso Java");

        cursoDAO.update(curso);
        Assert.assertTrue(cursoDAO.get(31l).getCodigo().equals("345"));
    }
    
    //@Test
    public void verifyDelete() {

        Curso curso = new Curso();
        curso.setId(31l);
        cursoDAO.delete(curso);

        Assert.assertTrue(cursoDAO.get(31l) == null);
    }
}
