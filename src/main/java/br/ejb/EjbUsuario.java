package br.ejb;

//import br.data.crud.CrudUsuario;
import java.util.Random;
import javax.ejb.Stateless;
import lombok.Getter;

@Stateless
public class EjbUsuario {

    @Getter
    private int valor1;
    @Getter
    private int valor2;

    public EjbUsuario() {
    }

    public void valores() {
        valor1 = new Random().nextInt(100);
        valor2 = new Random().nextInt(100);
    }

}
