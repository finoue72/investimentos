/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package investimento;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import java.text.NumberFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author finoue
 */
public class InvestimentoFacade {

    private NumberFormat numberFormat = NumberFormat.getInstance();
    private Vector vetorInvestimentos = new Vector();
    private String nomeArquivoInvestimento = "./investimentos.dat";

    public InvestimentoFacade() {
        this.numberFormat.setMinimumFractionDigits(2);
        this.numberFormat.setMaximumFractionDigits(2);
    }

    public Vector getVetorInvestimentos() {
        return vetorInvestimentos;
    }

    public void setVetorInvestimentos(Vector vetorInvestimentos) {
        this.vetorInvestimentos = vetorInvestimentos;
    }

    public void ordenarInvestimentos() {
        if (this.vetorInvestimentos instanceof Vector) {
            java.util.Collections.sort(this.vetorInvestimentos);

        }
    }

    public boolean lerArquivoInvestimentos() {
        try {

            FileInputStream arquivo = new FileInputStream(new File(this.nomeArquivoInvestimento));
            ObjectInputStream ois = new ObjectInputStream(arquivo);
            Object obj = ois.readObject();
            if (obj instanceof Vector) {
                this.vetorInvestimentos = (Vector) obj;
            } else {
                this.vetorInvestimentos = new Vector();
            }


            ois.close();
        } catch (Exception e) {
            this.vetorInvestimentos = new Vector();
        }
        return true;
    }

    public void gravarArquivoInvestimentos() {
        // gravar
        try {
            FileOutputStream arquivo = new FileOutputStream(this.nomeArquivoInvestimento);
            ObjectOutputStream oos = new ObjectOutputStream(arquivo);
            java.util.Collections.sort(this.vetorInvestimentos);
            oos.writeObject(this.vetorInvestimentos);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    public String[][] getArrayInvestimentos() {
        String[][] data = new String[this.getVetorInvestimentos().size() + 1][11];
        Investimento investimento = null;
        int i = 0;
        double totalValorFinalInvestimento = 0;
        double totalValorAplicado = 0;
        double totalJurosAcumulados = 0;
       
        for (; i < vetorInvestimentos.size(); i++) {
            investimento = (Investimento) vetorInvestimentos.elementAt(i);
            // Nome
            data[i][0] = investimento.getNome();
            // Valor inicial do investimento
            data[i][1] = "" + this.numberFormat.format(investimento.getValorInicial().doubleValue());
            // Valor investimento mensal aplicado
            data[i][2] = "" + this.numberFormat.format(investimento.getValorMensal().doubleValue());
            // Taxa de juros mensal
            data[i][3] = "" + (this.numberFormat.format(investimento.getTaxa().doubleValue() * 100));
            // Data de inicio
            data[i][4] = "" + this.getDataToString(investimento.getDataInicio());
            // Data final do investimento
            data[i][5] = "" + this.getDataToString(investimento.getDataFim());
            // Numero de anos do investimento
            data[i][6] = "" + (investimento.getNumeroAnos().intValue() == 0 ? "" : "" + investimento.getNumeroAnos().intValue());
            // Valor Aplicado
            data[i][7] = "" + this.numberFormat.format(investimento.getValorFinalInvestimento().doubleValue() - investimento.getJurosAcumulados().doubleValue());
            // Rendimento em R$
            data[i][8] = "" + this.numberFormat.format(investimento.getJurosAcumulados().doubleValue());
            // Rendimento em %
            data[i][9] = "" + this.numberFormat.format((investimento.getValorFinalInvestimento().doubleValue() - investimento.getJurosAcumulados().doubleValue()) == 0? 0:((investimento.getJurosAcumulados().doubleValue() / (investimento.getValorFinalInvestimento().doubleValue() - investimento.getJurosAcumulados().doubleValue())) * 100));

            // Valor Final
            data[i][10] = "" + this.numberFormat.format(investimento.getValorFinalInvestimento().doubleValue());

            // Somatórios dos investimentos
            totalValorAplicado = totalValorAplicado + (investimento.getValorFinalInvestimento().doubleValue() - investimento.getJurosAcumulados().doubleValue());
            totalJurosAcumulados = totalJurosAcumulados + investimento.getJurosAcumulados().doubleValue();
            totalValorFinalInvestimento = totalValorFinalInvestimento + investimento.getValorFinalInvestimento().doubleValue();



        }
        // Somatório
        data[i][0] = "<< TOTAIS >>";
        data[i][1] = "-";
        data[i][2] = "-";
        data[i][3] = "-";
        data[i][4] = "-";
        data[i][5] = "-";
        data[i][6] = "===>";
        data[i][7] = "" + this.numberFormat.format(totalValorAplicado);
        // Total de Rendimentos em R$
        data[i][8] = "" + this.numberFormat.format(totalJurosAcumulados);
        // Total de Rendimentos em %
        data[i][9] = "" + this.numberFormat.format((totalValorFinalInvestimento - totalJurosAcumulados)==0? 0 : ((totalJurosAcumulados / (totalValorFinalInvestimento - totalJurosAcumulados)) * 100));
        // Total Final
        data[i][10] = "" + this.numberFormat.format(totalValorFinalInvestimento);

        //
        return data;
    }

    public String getDataToString(GregorianCalendar data) {
        return (data.get(GregorianCalendar.DAY_OF_MONTH)) + "/" + (data.get(GregorianCalendar.MONTH) + 1) + "/" + data.get(GregorianCalendar.YEAR);
    }
}
