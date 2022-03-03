/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.data.crud.EjbRanking;
import br.data.model.ListaRanking;
import br.ejb.EjbUsuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.ejb.EJB;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author tarsi
 */
@Named(value = "jsfRanking")
@SessionScoped
public class JsfRanking implements Serializable {

    @EJB
    private EjbRanking ejbRanking;
    @Getter
    @Setter
    private int valorInformado;

    /**
     * Creates a new instance of JsfCompra
     */
    public JsfRanking() {

    }

    public void add(String nome) {
        ejbRanking.add(nome);

    }

    public ArrayList<ListaRanking> getAll() {

        return ejbRanking.getAll();
    }

    public void somar(int a, int b) {
        ejbRanking.setValorInformado(valorInformado);
        ejbRanking.somar(a, b);
        valorInformado = 0;

    }

}
