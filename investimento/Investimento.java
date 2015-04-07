/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package investimento;

import java.util.GregorianCalendar;
import java.io.Serializable;

/**
 *
 * @author finoue
 */
public class Investimento implements Serializable, Comparable, Cloneable {

    public static int TIPO_DATA_FINAL_NUMERO_ANOS = 1;
    public static int TIPO_DATA_FINAL_DATA = 2;
    //
    private String nome = "Nome";
    private Double valorInicial = new Double(0);
    private Double valorMensal = new Double(0);
    private Double taxa = new Double(0);
    private GregorianCalendar dataInicio = new GregorianCalendar();
    //
    private GregorianCalendar dataFim = new GregorianCalendar();   
    private Double valorFinalInvestimento = new Double(0);
    //
    private Integer numeroAnos = new Integer(0);
    private Integer tipoDataFim = new Integer(TIPO_DATA_FINAL_NUMERO_ANOS);
    //
    private Double jurosAcumulados = new Double(0);

    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e){
            return null;
        }
    }

    public Double getJurosAcumulados() {
        return jurosAcumulados;
    }

    public void setJurosAcumulados(Double jurosAcumulados) {
        this.jurosAcumulados = jurosAcumulados;
    }
    //

    public Investimento() {
    }

    public String toString() {
        return this.getNome();
    }

    public int compareTo(Object obj) {
        int resultado = -1;
        if (obj instanceof Investimento) {
            Investimento outro = (Investimento) obj;
            return this.getNome().compareToIgnoreCase(outro.getNome());

        }
        return resultado;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Investimento) {
            Investimento outro = (Investimento) obj;
            return this.getNome().equalsIgnoreCase(outro.getNome());
        }
        return false;
    }
    // *****************************************************

    public Integer getNumeroAnos() {
        return numeroAnos;
    }

    public void setNumeroAnos(Integer numeroAnos) {
        this.numeroAnos = numeroAnos;
    }

    public Integer getTipoDataFim() {
        return tipoDataFim;
    }

    public void setTipoDataFim(Integer tipoDataFim) {
        this.tipoDataFim = tipoDataFim;
    }

    public Double getValorFinalInvestimento() {
        return valorFinalInvestimento;
    }

    public void setValorFinalInvestimento(Double valorFinalInvestimento) {
        this.valorFinalInvestimento = valorFinalInvestimento;
    }

    public Double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(Double valorMensal) {
        this.valorMensal = valorMensal;
    }

  
    public Double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public GregorianCalendar getDataFim() {
        return dataFim;
    }

    public void setDataFim(GregorianCalendar dataFim) {
        this.dataFim = dataFim;
    }

    /**
     * Get the value of dataInicio
     *
     * @return the value of dataInicio
     */
    public GregorianCalendar getDataInicio() {
        return dataInicio;
    }

    /**
     * Set the value of dataInicio
     *
     * @param dataInicio new value of dataInicio
     */
    public void setDataInicio(GregorianCalendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * Get the value of taxa
     *
     * @return the value of taxa
     */
    public Double getTaxa() {
        return taxa;
    }

    /**
     * Set the value of taxa
     *
     * @param taxa new value of taxa
     */
    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }

    /**
     * Get the value of nome
     *
     * @return the value of nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Set the value of nome
     *
     * @param nome new value of nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
