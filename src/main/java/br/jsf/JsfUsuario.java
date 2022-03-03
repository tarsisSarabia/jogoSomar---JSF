package br.jsf;

//import br.data.model.Usuario;
import br.ejb.EjbUsuario;
import java.util.Random;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.Queue;
import lombok.Getter;
import lombok.Setter;

@Named(value = "jsfUsuario")
@RequestScoped
public class JsfUsuario {

    @EJB
    private EjbUsuario ejbUsuario;
    @Getter
    @Setter
    private String nome;
    private int valor1 = 0;

    private int valor2 = 0;

    public int getValor1() {
        return valor1 = ejbUsuario.getValor1();
    }

    public int getValor2() {
        return valor2 = ejbUsuario.getValor2();
    }

    public void valores() {
        ejbUsuario.valores();

    }
       
   @Resource(lookup = "java:comp/DefaultJMSConnectionFactory")
    private ConnectionFactory connectionFactory;
    
    @Resource(lookup = "java/Fila")
    private Queue fila;


    /**
     * Creates a new instance of JsfProduto
     */
    public JsfUsuario() {

    }

    @Getter @Setter
    private String mensagem;
    
    public void send(){
        try {
            JMSContext context= connectionFactory.createContext();
              context.createProducer().send((Destination) fila, mensagem);
            
        } catch (Exception e) {
            System.out.println("error");
            System.out.println(e.getMessage());
        }
      
        
    }

}
