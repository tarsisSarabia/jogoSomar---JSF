/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.crud;

import br.data.model.ListaRanking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import javax.ejb.Stateful;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author tarsi
 */
@Stateful
public class EjbRanking {

    private ArrayList<ListaRanking> lRanking;
    @Getter
    @Setter
    private int resultado;
    @Getter
    @Setter
    private int valorInformado;

    public EjbRanking() {
        lRanking = new ArrayList<>();

    }

    public void add(String nome) {
        boolean achou = false;
        if (valorInformado == resultado) {
            for (ListaRanking listaRanking : lRanking) {
                if (listaRanking.getNome().equals(nome)) {
                    listaRanking.setQuantidade(listaRanking.getQuantidade() + 1);
                    achou = true;

                }
            }

            if (!achou) {
                lRanking.add(new ListaRanking(nome, 1));
            }
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage("Valor informado está correto, Parabéns!!"));
        } else {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage("Valor informado está incorreto!!"));

        }

    }

    public ArrayList<ListaRanking> getAll() {
        ArrayList<ListaRanking> lcompraOrd = (ArrayList<ListaRanking>) lRanking.stream().
                sorted(Comparator.comparing(ListaRanking::getQuantidade).reversed()).
                collect(Collectors.toList());
        return lcompraOrd;
    }

    public void somar(int a, int b) {
        resultado = a + b;
    }

}
