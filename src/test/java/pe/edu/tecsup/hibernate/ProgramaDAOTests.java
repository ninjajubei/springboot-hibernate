package pe.edu.tecsup.hibernate;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.edu.tecsup.hibernate.dao.ProgramaDAO;
import pe.edu.tecsup.hibernate.model.Programa;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProgramaDAOTests {

    @Autowired
    ProgramaDAO programaDAO;
    
//    @Test
    public void verifyList() {

        List<Programa> programas = programaDAO.list();
        for (Programa programa : programas) {
            System.out.println(programa.getId());
            System.out.println(programa.getNombre());
        }
        Assert.assertTrue(programas.size() > 0);
    }

//    @Test
    public void verifyFind() {
        Programa programa = programaDAO.get(72l);
        System.out.println(programa.getNombre());
        Assert.assertTrue(programa.getId() == 72);
    }

//    @Test
    public void verifySave() {

        Programa programa = new Programa();
        programa.setCodigo("1020");
        programa.setNombre("Nuevo Programa");
        programa.setDescripcion("......");

        programaDAO.save(programa);
        Assert.assertTrue(programa.getId() != null);
    }

//    @Test
    public void verifyUpdate() {

        // cambiar el código para validar
        Programa programa = new Programa();
        programa.setId(72l);
        programa.setCodigo("345");
        programa.setNombre("Programa Modificado 2");

        programaDAO.update(programa);
        Assert.assertTrue(programaDAO.get(72l).getCodigo().equals("345"));
    }

    @Test
    public void verifyDelete() {

        Programa programa = new Programa();
        programa.setId(72l);
        programaDAO.delete(programa);

        Assert.assertTrue(programaDAO.get(72l) == null);
    }

    

}
