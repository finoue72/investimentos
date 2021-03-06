/*
 * SimuladorRendimentosFrame.java
 *
 * Created on 3 de Outubro de 2006, 10:48
 */
package investimento;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author  Deus
 */
public class SimuladorRendimentosFrame extends javax.swing.JFrame {

    public static int ADICIONAR = 1;
    public static int ATUALIZAR = 2;
    Investimento investimento = null;
    Investimento investimentoVelho = null;
    InvestimentosFrame bovespaFrame = null;
    private int tipoOperacao = ADICIONAR;
    NumberFormat numberFormat = NumberFormat.getInstance();
    NumberFormat numberFormatDia = NumberFormat.getInstance();
    TableModelSimuladorRendimentos model;
    int tipoDataFim = Investimento.TIPO_DATA_FINAL_NUMERO_ANOS;

    /** Creates new form SimuladorRendimentosFrame */
    public SimuladorRendimentosFrame() {
        initComponents();
        this.numberFormat.setMinimumFractionDigits(2);
        this.numberFormat.setMaximumFractionDigits(2);
        //
        this.numberFormatDia.setMinimumIntegerDigits(2);
        model = new TableModelSimuladorRendimentos(getColunas());
        //
        GregorianCalendar dataAtual = new GregorianCalendar(Locale.getDefault());
        this.txtDataInicio.setText(dataAtual.get(GregorianCalendar.DAY_OF_MONTH) + "/" + (dataAtual.get(GregorianCalendar.MONTH) + 1) + "/" + dataAtual.get(GregorianCalendar.YEAR));
    }

    public SimuladorRendimentosFrame(InvestimentosFrame bovespaFrameChamador, int operacaoSolicitada, Investimento investimentoVelho) {
        this();
        this.tipoOperacao = operacaoSolicitada;
        this.tipoDataFim = Investimento.TIPO_DATA_FINAL_NUMERO_ANOS;
        if (operacaoSolicitada == SimuladorRendimentosFrame.ATUALIZAR) {
            this.transferirInvestimentoTela(investimentoVelho);

            this.investimentoVelho = investimentoVelho;
        }
        this.bovespaFrame = bovespaFrameChamador;




    }

    private Vector getColunas() {
        Vector colunas = new Vector();
        colunas.add("Data");
        colunas.add("Aplicado");
        colunas.add("Juros mensal");
        colunas.add("Juros acumulados");
        colunas.add("Total(Apl+Juros)");


        return colunas;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTipoDataFinal = new javax.swing.ButtonGroup();
        panelDadosInvestimento = new javax.swing.JPanel();
        layeredPaneDataFinal = new javax.swing.JLayeredPane();
        radionTipoDataFimAnos = new javax.swing.JRadioButton();
        radioTipoDataFimData = new javax.swing.JRadioButton();
        txtAnosCalculo = new javax.swing.JTextField();
        txtDataFinal = new javax.swing.JTextField();
        txtDataInicio = new javax.swing.JTextField();
        lblDataInicio = new javax.swing.JLabel();
        txtNomeInvestimento = new javax.swing.JTextField();
        lblNomeInvestimento = new javax.swing.JLabel();
        cmdCalcular = new javax.swing.JButton();
        lblValorAplicado = new javax.swing.JLabel();
        lblJuros = new javax.swing.JLabel();
        lblValorAplicacaoMensal = new javax.swing.JLabel();
        txtValorAplicado = new javax.swing.JTextField();
        txtValorMensal = new javax.swing.JTextField();
        txtJuros = new javax.swing.JTextField();
        cmdSalvarInvestimento = new javax.swing.JButton();
        cmdCancelar = new javax.swing.JButton();
        scrollPaneTabelaResultado = new javax.swing.JScrollPane();
        tableCalculo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Investimento");
        setName("frameInvestimentos"); // NOI18N

        panelDadosInvestimento.setPreferredSize(new java.awt.Dimension(600, 304));

        layeredPaneDataFinal.setBorder(javax.swing.BorderFactory.createTitledBorder("* Data final"));

        buttonGroupTipoDataFinal.add(radionTipoDataFimAnos);
        radionTipoDataFimAnos.setSelected(true);
        radionTipoDataFimAnos.setText("Anos:");
        radionTipoDataFimAnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radionTipoDataFimAnosActionPerformed(evt);
            }
        });
        radionTipoDataFimAnos.setBounds(40, 30, 93, 20);
        layeredPaneDataFinal.add(radionTipoDataFimAnos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        buttonGroupTipoDataFinal.add(radioTipoDataFimData);
        radioTipoDataFimData.setText("Data final:");
        radioTipoDataFimData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTipoDataFimDataActionPerformed(evt);
            }
        });
        radioTipoDataFimData.setBounds(260, 30, 100, 20);
        layeredPaneDataFinal.add(radioTipoDataFimData, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtAnosCalculo.setBounds(150, 30, 50, 20);
        layeredPaneDataFinal.add(txtAnosCalculo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtDataFinal.setEnabled(false);
        txtDataFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataFinalActionPerformed(evt);
            }
        });
        txtDataFinal.setBounds(380, 30, 70, 20);
        layeredPaneDataFinal.add(txtDataFinal, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblDataInicio.setText("*Data in�cio:");

        txtNomeInvestimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeInvestimentoActionPerformed(evt);
            }
        });

        lblNomeInvestimento.setText("Nome:");

        cmdCalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/investimento/imagens/calculadora.png"))); // NOI18N
        cmdCalcular.setText("Detalhar");
        cmdCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCalcularActionPerformed(evt);
            }
        });

        lblValorAplicado.setText("Valor inicial:");

        lblJuros.setText("* Taxa % a.m.:");

        lblValorAplicacaoMensal.setText("Aplica��o mensal:");

        cmdSalvarInvestimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/investimento/imagens/salvar.png"))); // NOI18N
        cmdSalvarInvestimento.setText("Gravar");
        cmdSalvarInvestimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSalvarInvestimentoActionPerformed(evt);
            }
        });

        cmdCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/investimento/imagens/cancelar.png"))); // NOI18N
        cmdCancelar.setText("Cancelar");
        cmdCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout panelDadosInvestimentoLayout = new org.jdesktop.layout.GroupLayout(panelDadosInvestimento);
        panelDadosInvestimento.setLayout(panelDadosInvestimentoLayout);
        panelDadosInvestimentoLayout.setHorizontalGroup(
            panelDadosInvestimentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelDadosInvestimentoLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelDadosInvestimentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelDadosInvestimentoLayout.createSequentialGroup()
                        .add(panelDadosInvestimentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(lblNomeInvestimento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 77, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(lblValorAplicado, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .add(lblJuros, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(panelDadosInvestimentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtNomeInvestimento, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .add(panelDadosInvestimentoLayout.createSequentialGroup()
                                .add(panelDadosInvestimentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(txtJuros, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(txtValorAplicado, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(87, 87, 87)
                                .add(panelDadosInvestimentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(lblDataInicio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 91, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(lblValorAplicacaoMensal))))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(panelDadosInvestimentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtValorMensal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 89, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(txtDataInicio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 89, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(panelDadosInvestimentoLayout.createSequentialGroup()
                        .add(54, 54, 54)
                        .add(cmdCalcular, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 121, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(46, 46, 46)
                        .add(cmdSalvarInvestimento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 126, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 55, Short.MAX_VALUE)
                        .add(cmdCancelar))
                    .add(layeredPaneDataFinal, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE))
                .add(673, 673, 673))
        );
        panelDadosInvestimentoLayout.setVerticalGroup(
            panelDadosInvestimentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelDadosInvestimentoLayout.createSequentialGroup()
                .add(31, 31, 31)
                .add(panelDadosInvestimentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblNomeInvestimento)
                    .add(txtNomeInvestimento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(panelDadosInvestimentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtValorAplicado, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblValorAplicado)
                    .add(lblValorAplicacaoMensal)
                    .add(txtValorMensal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelDadosInvestimentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(panelDadosInvestimentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(lblJuros)
                        .add(txtJuros, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(panelDadosInvestimentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(lblDataInicio)
                        .add(txtDataInicio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(18, 18, 18)
                .add(layeredPaneDataFinal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(26, 26, 26)
                .add(panelDadosInvestimentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cmdCalcular)
                    .add(cmdCancelar)
                    .add(cmdSalvarInvestimento))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        getContentPane().add(panelDadosInvestimento, java.awt.BorderLayout.NORTH);

        scrollPaneTabelaResultado.setBackground(new java.awt.Color(255, 255, 255));
        scrollPaneTabelaResultado.setMaximumSize(new java.awt.Dimension(600, 1000));

        tableCalculo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 204, 255), null, null));
        tableCalculo.setFont(new java.awt.Font("Monospaced", 0, 12));
        tableCalculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Data", "Aplicado", "Juros/M�s", "Juros acumulado", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCalculo.setMaximumSize(new java.awt.Dimension(600, 400));
        scrollPaneTabelaResultado.setViewportView(tableCalculo);

        getContentPane().add(scrollPaneTabelaResultado, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Investimento lerInvestimentoTela() {
        Investimento investimentoTela = new Investimento();
        try {

            //
            GregorianCalendar dataAtual = new GregorianCalendar(Locale.getDefault());

            // Ler data de in�cio
            try {
                if ((this.txtDataInicio.getText() != null) && (!this.txtDataInicio.getText().trim().equals(""))) {
                    java.util.Date dataAtualTela = new SimpleDateFormat("dd/MM/yyyy").parse(this.txtDataInicio.getText());
                    dataAtual.setTimeInMillis(dataAtualTela.getTime());

                } else {
                    this.txtDataInicio.setText(dataAtual.get(GregorianCalendar.DAY_OF_MONTH) + "/" + (dataAtual.get(GregorianCalendar.MONTH) + 1) + "/" + dataAtual.get(GregorianCalendar.YEAR));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


            GregorianCalendar dataFinal = new GregorianCalendar(Locale.getDefault());
            dataFinal.setTimeInMillis(dataAtual.getTimeInMillis());
            double valorAplicado = 0;
            double valorAplicadoMensal = 0;
            double taxaJuros = 0;


            // Valor inicial
            try {
                if ((this.txtValorAplicado.getText() != null) && (!this.txtValorAplicado.getText().trim().equals(""))) {
                    valorAplicado = this.numberFormat.parse(this.txtValorAplicado.getText()).doubleValue();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Valor para aplica��o mensal
            try {
                if ((this.txtValorMensal.getText() != null) && (!this.txtValorMensal.getText().trim().equals(""))) {
                    valorAplicadoMensal = this.numberFormat.parse(this.txtValorMensal.getText()).doubleValue();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Taxa de juros
            try {
                if ((this.txtJuros.getText() != null) && (!this.txtJuros.getText().trim().equals(""))) {
                    taxaJuros = this.numberFormat.parse(this.txtJuros.getText()).doubleValue() / 100;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Tipo de data fim
            try {
                // Numero de anos
                if (this.tipoDataFim == Investimento.TIPO_DATA_FINAL_NUMERO_ANOS) {
                    dataFinal.add(GregorianCalendar.YEAR, Integer.parseInt(this.txtAnosCalculo.getText()));                   
                } else {
                    // Data final
                    if ((this.txtDataFinal.getText() != null) && (!this.txtDataFinal.getText().trim().equals(""))) {
                        java.util.Date dataFinalTela = new SimpleDateFormat("dd/MM/yyyy").parse(this.txtDataFinal.getText());
                        dataFinal.setTimeInMillis(dataFinalTela.getTime());

                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            //
            investimentoTela.setNome(this.txtNomeInvestimento.getText());
            investimentoTela.setDataInicio(dataAtual);

            investimentoTela.setValorInicial(new Double(valorAplicado));
            investimentoTela.setValorMensal(new Double(valorAplicadoMensal));
            investimentoTela.setTaxa(new Double(taxaJuros));
            investimentoTela.setTipoDataFim(new Integer(this.tipoDataFim));
            investimentoTela.setDataFim(dataFinal);
            investimentoTela.setNumeroAnos(new Integer(Integer.parseInt(this.txtAnosCalculo.getText())));
            //

        } catch (Exception e) {
            e.printStackTrace();
            //
        }
        return investimentoTela;

    }

    private void transferirInvestimentoTela(Investimento investimentoVelho) {
        try {
            this.txtNomeInvestimento.setText(investimentoVelho.getNome());
            this.txtValorAplicado.setText("" + this.numberFormat.format(investimentoVelho.getValorInicial().doubleValue()));
            this.txtValorMensal.setText("" + this.numberFormat.format(investimentoVelho.getValorMensal().doubleValue()));
            this.txtJuros.setText("" + this.numberFormat.format((investimentoVelho.getTaxa().doubleValue() * 100)));
            this.txtDataInicio.setText("" + this.numberFormatDia.format(investimentoVelho.getDataInicio().get(GregorianCalendar.DAY_OF_MONTH)) + "/" + this.numberFormatDia.format((investimentoVelho.getDataInicio().get(GregorianCalendar.MONTH) + 1)) + "/" + investimentoVelho.getDataInicio().get(GregorianCalendar.YEAR));
            this.tipoDataFim = investimentoVelho.getTipoDataFim().intValue();
            if (investimentoVelho.getTipoDataFim().intValue() == Investimento.TIPO_DATA_FINAL_NUMERO_ANOS) {
                this.radionTipoDataFimAnos.setSelected(true);
                this.radioTipoDataFimData.setSelected(false);
                this.txtAnosCalculo.setEnabled(true);
                this.txtDataFinal.setEnabled(false);
                this.txtAnosCalculo.setText("" + investimentoVelho.getNumeroAnos().intValue());
                this.txtDataFinal.setText("");
            } else {
                this.radionTipoDataFimAnos.setSelected(false);
                this.radioTipoDataFimData.setSelected(true);
                this.txtAnosCalculo.setEnabled(false);
                this.txtDataFinal.setEnabled(true);
                this.txtDataFinal.setText("" + this.numberFormatDia.format(investimentoVelho.getDataFim().get(GregorianCalendar.DAY_OF_MONTH)) + "/" + this.numberFormatDia.format((investimentoVelho.getDataFim().get(GregorianCalendar.MONTH) + 1)) + "/" + investimentoVelho.getDataFim().get(GregorianCalendar.YEAR));
                this.txtAnosCalculo.setText("");
            }
            //
            this.investimento = (Investimento) investimentoVelho.clone();
            //

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void cmdCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCalcularActionPerformed
// TODO add your handling code here:
        try {
            this.investimento = lerInvestimentoTela();
            //
            double valorAplicado = this.investimento.getValorInicial().doubleValue();
            double valorAplicadoMensal = this.investimento.getValorMensal().doubleValue();
            GregorianCalendar dataAtual = (GregorianCalendar) this.investimento.getDataInicio().clone();
            GregorianCalendar dataFinal = (GregorianCalendar) this.investimento.getDataFim().clone();
            //

            //

            double taxaJuros = this.investimento.getTaxa().doubleValue();


            //

            double jurosMes = 0;
            double jurosAcumulados = 0;
            double total = 0;

            Vector tabelaCalculo = new Vector();
           // 
            GregorianCalendar mesAnterior = null;

            while ((!dataAtual.after(dataFinal)) && (!dataAtual.equals(dataFinal))) {
                // Preservar o mes anterior
                mesAnterior = (GregorianCalendar) dataAtual.clone();
                //
                dataAtual.add(GregorianCalendar.MONTH, 1);
                // Verifica se � juro parcial devido a m�s quebrado
                if (dataAtual.after(dataFinal) && (!dataAtual.equals(dataFinal))) {
                    // Para m�s fracionado considera o m�s comercial de 30 dias
                    GregorianCalendar diasFaltantes = new GregorianCalendar();                   
                    diasFaltantes.setTimeInMillis(dataFinal.getTimeInMillis() - mesAnterior.getTimeInMillis());
                    // Calcula a taxa proporciona ao n�mero de dias
                    taxaJuros = diasFaltantes.get(GregorianCalendar.DAY_OF_MONTH) * (taxaJuros/30);
                    tabelaCalculo.add(this.numberFormatDia.format(dataFinal.get(GregorianCalendar.DAY_OF_MONTH)) + "/" + this.numberFormatDia.format(dataFinal.get(GregorianCalendar.MONTH) + 1) + "/" + dataFinal.get(GregorianCalendar.YEAR));

                } else {
                    // Mes corrente
                    tabelaCalculo.add(this.numberFormatDia.format(dataAtual.get(GregorianCalendar.DAY_OF_MONTH)) + "/" + this.numberFormatDia.format(dataAtual.get(GregorianCalendar.MONTH) + 1) + "/" + dataAtual.get(GregorianCalendar.YEAR));
                }
                // Valor Aplicado acumulado
                valorAplicado = valorAplicado + valorAplicadoMensal;
                tabelaCalculo.add(new Double(valorAplicado));
                // Juros do m�s
                jurosMes = taxaJuros * (valorAplicado + jurosAcumulados);
                tabelaCalculo.add(new Double(jurosMes));
                // Juros acumulados at� o periodo
                jurosAcumulados = jurosAcumulados + jurosMes;
                tabelaCalculo.add(new Double(jurosAcumulados));
                // Total final at� o periodo
                total = valorAplicado + jurosAcumulados;
                tabelaCalculo.add(new Double(total));


            }
            //
            this.investimento.setValorFinalInvestimento(new Double(total));
            this.investimento.setJurosAcumulados(new Double(jurosAcumulados));
            //
            model.setData(tabelaCalculo);
            this.tableCalculo.setModel(model);
            this.tableCalculo.setDefaultRenderer(Double.class, new NumberRenderer());
            this.tableCalculo.setRowSelectionAllowed(true);
            //








        } catch (Exception e) {
            e.printStackTrace();
            //
        }
    }//GEN-LAST:event_cmdCalcularActionPerformed

    private void txtNomeInvestimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeInvestimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeInvestimentoActionPerformed

    private void radionTipoDataFimAnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radionTipoDataFimAnosActionPerformed
        // TODO add your handling code here:
        this.trataTipoDataFim(evt);
    }//GEN-LAST:event_radionTipoDataFimAnosActionPerformed

    private void radioTipoDataFimDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTipoDataFimDataActionPerformed
        // TODO add your handling code here:
        this.trataTipoDataFim(evt);

    }//GEN-LAST:event_radioTipoDataFimDataActionPerformed

    private void cmdSalvarInvestimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSalvarInvestimentoActionPerformed
        // TODO add your handling code here:
        this.cmdCalcularActionPerformed(evt);
        InvestimentoFacade investimentoFacade = new InvestimentoFacade();
        investimentoFacade.lerArquivoInvestimentos();
        if (this.tipoOperacao == SimuladorRendimentosFrame.ADICIONAR) {
            if (!investimentoFacade.getVetorInvestimentos().contains(this.investimento)) {
                if (this.investimento.getNome() != null && (!this.investimento.getNome().trim().equals(""))) {
                    investimentoFacade.getVetorInvestimentos().add(this.investimento);
                    investimentoFacade.gravarArquivoInvestimentos();
                    this.bovespaFrame.disparaAtualizacao(evt);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Voc� deve colocar um nome para o investimento.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "J� existe um investimento com este nome.");
            }
        } else {
            if ((this.investimento.getNome().equals(this.investimentoVelho.getNome())) || (!investimentoFacade.getVetorInvestimentos().contains(this.investimento))) {
                if (this.investimento.getNome() != null && (!this.investimento.getNome().trim().equals(""))) {
                    investimentoFacade.getVetorInvestimentos().remove(this.investimentoVelho);
                    investimentoFacade.getVetorInvestimentos().add(this.investimento);
                    investimentoFacade.gravarArquivoInvestimentos();
                    this.bovespaFrame.disparaAtualizacao(evt);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Voc� deve colocar um nome para o investimento.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "J� existe um investimento com este nome.");
            }

        }

    }//GEN-LAST:event_cmdSalvarInvestimentoActionPerformed

    private void txtDataFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataFinalActionPerformed

    private void cmdCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelarActionPerformed
        // TODO add your handling code here:
        this.bovespaFrame.disparaAtualizacao(evt);
        this.setVisible(false);
    }//GEN-LAST:event_cmdCancelarActionPerformed

    private void trataTipoDataFim(java.awt.event.ActionEvent evt) {
        if (radionTipoDataFimAnos.isSelected()) {
            txtAnosCalculo.setEnabled(true);
            txtDataFinal.setEnabled(false);
            txtDataFinal.setText("");
            this.tipoDataFim = Investimento.TIPO_DATA_FINAL_NUMERO_ANOS;

        } else {
            txtAnosCalculo.setEnabled(false);
            txtDataFinal.setEnabled(true);
            txtAnosCalculo.setText("");
            this.tipoDataFim = Investimento.TIPO_DATA_FINAL_DATA;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupTipoDataFinal;
    private javax.swing.JButton cmdCalcular;
    private javax.swing.JButton cmdCancelar;
    private javax.swing.JButton cmdSalvarInvestimento;
    private javax.swing.JLayeredPane layeredPaneDataFinal;
    private javax.swing.JLabel lblDataInicio;
    private javax.swing.JLabel lblJuros;
    private javax.swing.JLabel lblNomeInvestimento;
    private javax.swing.JLabel lblValorAplicacaoMensal;
    private javax.swing.JLabel lblValorAplicado;
    private javax.swing.JPanel panelDadosInvestimento;
    private javax.swing.JRadioButton radioTipoDataFimData;
    private javax.swing.JRadioButton radionTipoDataFimAnos;
    private javax.swing.JScrollPane scrollPaneTabelaResultado;
    private javax.swing.JTable tableCalculo;
    private javax.swing.JTextField txtAnosCalculo;
    private javax.swing.JTextField txtDataFinal;
    private javax.swing.JTextField txtDataInicio;
    private javax.swing.JTextField txtJuros;
    private javax.swing.JTextField txtNomeInvestimento;
    private javax.swing.JTextField txtValorAplicado;
    private javax.swing.JTextField txtValorMensal;
    // End of variables declaration//GEN-END:variables
}

class NumberRenderer extends DefaultTableCellRenderer {

    NumberFormat formatter;
    String valorFormatado = "";

    public NumberRenderer() {
        super();
    }

    public void setValue(Object value) {
        if (formatter == null) {
            formatter = NumberFormat.getInstance();
            formatter.setMinimumFractionDigits(2);
            formatter.setMaximumFractionDigits(2);
        }
        valorFormatado = ((value == null) ? "" : formatter.format(value));
        setText("R$ " + valorFormatado);

    }
}
