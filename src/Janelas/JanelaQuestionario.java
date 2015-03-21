/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Janelas;

import Database.ManipulacaoSQL;
import Entidades.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import uteis.GrupoDeBotoes;

/**
 *
 * @author Ramon Honorio
 */
public class JanelaQuestionario extends javax.swing.JFrame {
    
    // Controle dos paineis
    private int cardAtual;
    private final int qtdPaineis;
    private final uteis.GrupoDeBotoes utGrupo;
    
    // Informacoes que foram passadas das janelas anteriores
    public Taxista taxista;
    public Cliente cliente;
    public Questionario quest;
    public Pergunta[] perguntas;
    public Pesquisa pesquisa;
    
    // Manipular banco de dados
    public ManipulacaoSQL msql;
    
    public JanelaQuestionario() {
        initComponents();
        
        // Inserir icone :D
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/botoes/icone.png")));
        
        cardAtual = 1;
        utGrupo = new GrupoDeBotoes();
        qtdPaineis = painelPrincipal.getComponentCount();
        perguntas = new Pergunta[qtdPaineis];
        quest = new Questionario("0", new String[qtdPaineis]);
        
        msql = new ManipulacaoSQL();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoP1 = new javax.swing.ButtonGroup();
        grupoP2 = new javax.swing.ButtonGroup();
        grupoP3 = new javax.swing.ButtonGroup();
        grupoP4 = new javax.swing.ButtonGroup();
        painelPrincipal = new javax.swing.JPanel();
        painel1 = new javax.swing.JPanel();
        jltitulo = new javax.swing.JLabel();
        lblPergunta1 = new javax.swing.JLabel();
        rbPessimo = new javax.swing.JRadioButton();
        rbRuim = new javax.swing.JRadioButton();
        rbRegular = new javax.swing.JRadioButton();
        rbBom = new javax.swing.JRadioButton();
        painel2 = new javax.swing.JPanel();
        lblTitulo2 = new javax.swing.JLabel();
        lblPergunta2 = new javax.swing.JLabel();
        rbPessimo1 = new javax.swing.JRadioButton();
        rbRuim1 = new javax.swing.JRadioButton();
        rbRegular1 = new javax.swing.JRadioButton();
        rbBom1 = new javax.swing.JRadioButton();
        painel3 = new javax.swing.JPanel();
        lblTitulo3 = new javax.swing.JLabel();
        lblPergunta3 = new javax.swing.JLabel();
        rbPessimo2 = new javax.swing.JRadioButton();
        rbRuim2 = new javax.swing.JRadioButton();
        rbRegular2 = new javax.swing.JRadioButton();
        rbBom2 = new javax.swing.JRadioButton();
        painel4 = new javax.swing.JPanel();
        lblTitulo4 = new javax.swing.JLabel();
        lblPergunta4 = new javax.swing.JLabel();
        rbPessimo3 = new javax.swing.JRadioButton();
        rbRuim3 = new javax.swing.JRadioButton();
        rbRegular3 = new javax.swing.JRadioButton();
        rbBom3 = new javax.swing.JRadioButton();
        painel5 = new javax.swing.JPanel();
        lblTituloSugestao = new javax.swing.JLabel();
        lblSugestao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaSugestao = new javax.swing.JTextArea();
        lblCaracteres = new javax.swing.JLabel();
        lblCaracteresContador = new javax.swing.JLabel();
        botaoAvancar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa de Satisfacao");
        setResizable(false);

        painelPrincipal.setLayout(new java.awt.CardLayout());

        jltitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jltitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jltitulo.setText("Questionário (1/4)");

        lblPergunta1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPergunta1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPergunta1.setText("Pergunta 1");

        grupoP1.add(rbPessimo);
        rbPessimo.setText("Péssimo");
        rbPessimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/pessimo_naos.png"))); // NOI18N
        rbPessimo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/pessimo_rollover.png"))); // NOI18N
        rbPessimo.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/pessimo_selec.png"))); // NOI18N

        grupoP1.add(rbRuim);
        rbRuim.setText("Ruim");
        rbRuim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/ruim_naos.png"))); // NOI18N
        rbRuim.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/ruim_rollover.png"))); // NOI18N
        rbRuim.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/ruim_selec.png"))); // NOI18N

        grupoP1.add(rbRegular);
        rbRegular.setText("Regular");
        rbRegular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/regular_naos.png"))); // NOI18N
        rbRegular.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/regular_rollover.png"))); // NOI18N
        rbRegular.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/regular_selec.png"))); // NOI18N

        grupoP1.add(rbBom);
        rbBom.setText("Bom");
        rbBom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/bom_naos.png"))); // NOI18N
        rbBom.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/bom_rollover.png"))); // NOI18N
        rbBom.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/bom_selec.png"))); // NOI18N

        javax.swing.GroupLayout painel1Layout = new javax.swing.GroupLayout(painel1);
        painel1.setLayout(painel1Layout);
        painel1Layout.setHorizontalGroup(
            painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jltitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPergunta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painel1Layout.createSequentialGroup()
                        .addComponent(rbPessimo)
                        .addGap(18, 18, 18)
                        .addComponent(rbRuim)
                        .addGap(18, 18, 18)
                        .addComponent(rbRegular)
                        .addGap(18, 18, 18)
                        .addComponent(rbBom)
                        .addContainerGap(13, Short.MAX_VALUE))))
        );
        painel1Layout.setVerticalGroup(
            painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel1Layout.createSequentialGroup()
                .addComponent(jltitulo)
                .addGap(18, 18, 18)
                .addComponent(lblPergunta1)
                .addGap(18, 18, 18)
                .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbRuim)
                    .addComponent(rbPessimo)
                    .addComponent(rbRegular)
                    .addComponent(rbBom))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelPrincipal.add(painel1, "pergunta1");

        lblTitulo2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo2.setText("Questionário (2/4)");

        lblPergunta2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPergunta2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPergunta2.setText("Pergunta 2");

        grupoP2.add(rbPessimo1);
        rbPessimo1.setText("Péssimo");
        rbPessimo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/pessimo_naos.png"))); // NOI18N
        rbPessimo1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/pessimo_rollover.png"))); // NOI18N
        rbPessimo1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/pessimo_selec.png"))); // NOI18N

        grupoP2.add(rbRuim1);
        rbRuim1.setText("Ruim");
        rbRuim1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/ruim_naos.png"))); // NOI18N
        rbRuim1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/ruim_rollover.png"))); // NOI18N
        rbRuim1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/ruim_selec.png"))); // NOI18N

        grupoP2.add(rbRegular1);
        rbRegular1.setText("Regular");
        rbRegular1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/regular_naos.png"))); // NOI18N
        rbRegular1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/regular_rollover.png"))); // NOI18N
        rbRegular1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/regular_selec.png"))); // NOI18N

        grupoP2.add(rbBom1);
        rbBom1.setText("Bom");
        rbBom1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/bom_naos.png"))); // NOI18N
        rbBom1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/bom_rollover.png"))); // NOI18N
        rbBom1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/bom_selec.png"))); // NOI18N

        javax.swing.GroupLayout painel2Layout = new javax.swing.GroupLayout(painel2);
        painel2.setLayout(painel2Layout);
        painel2Layout.setHorizontalGroup(
            painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblPergunta2, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
            .addGroup(painel2Layout.createSequentialGroup()
                .addComponent(rbPessimo1)
                .addGap(18, 18, 18)
                .addComponent(rbRuim1)
                .addGap(18, 18, 18)
                .addComponent(rbRegular1)
                .addGap(18, 18, 18)
                .addComponent(rbBom1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        painel2Layout.setVerticalGroup(
            painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel2Layout.createSequentialGroup()
                .addComponent(lblTitulo2)
                .addGap(18, 18, 18)
                .addComponent(lblPergunta2)
                .addGap(18, 18, 18)
                .addGroup(painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbRuim1)
                    .addComponent(rbPessimo1)
                    .addComponent(rbRegular1)
                    .addComponent(rbBom1))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        painelPrincipal.add(painel2, "pergunta2");

        lblTitulo3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo3.setText("Questionário (3/4)");

        lblPergunta3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPergunta3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPergunta3.setText("Pergunta 3");

        grupoP3.add(rbPessimo2);
        rbPessimo2.setText("Péssimo");
        rbPessimo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/pessimo_naos.png"))); // NOI18N
        rbPessimo2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/pessimo_rollover.png"))); // NOI18N
        rbPessimo2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/pessimo_selec.png"))); // NOI18N

        grupoP3.add(rbRuim2);
        rbRuim2.setText("Ruim");
        rbRuim2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/ruim_naos.png"))); // NOI18N
        rbRuim2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/ruim_rollover.png"))); // NOI18N
        rbRuim2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/ruim_selec.png"))); // NOI18N

        grupoP3.add(rbRegular2);
        rbRegular2.setText("Regular");
        rbRegular2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/regular_naos.png"))); // NOI18N
        rbRegular2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/regular_rollover.png"))); // NOI18N
        rbRegular2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/regular_selec.png"))); // NOI18N

        grupoP3.add(rbBom2);
        rbBom2.setText("Bom");
        rbBom2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/bom_naos.png"))); // NOI18N
        rbBom2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/bom_rollover.png"))); // NOI18N
        rbBom2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/bom_selec.png"))); // NOI18N

        javax.swing.GroupLayout painel3Layout = new javax.swing.GroupLayout(painel3);
        painel3.setLayout(painel3Layout);
        painel3Layout.setHorizontalGroup(
            painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblPergunta3, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
            .addGroup(painel3Layout.createSequentialGroup()
                .addComponent(rbPessimo2)
                .addGap(18, 18, 18)
                .addComponent(rbRuim2)
                .addGap(18, 18, 18)
                .addComponent(rbRegular2)
                .addGap(18, 18, 18)
                .addComponent(rbBom2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        painel3Layout.setVerticalGroup(
            painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel3Layout.createSequentialGroup()
                .addComponent(lblTitulo3)
                .addGap(18, 18, 18)
                .addComponent(lblPergunta3)
                .addGap(18, 18, 18)
                .addGroup(painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbRuim2)
                    .addComponent(rbPessimo2)
                    .addComponent(rbRegular2)
                    .addComponent(rbBom2))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        painelPrincipal.add(painel3, "pergunta3");

        lblTitulo4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitulo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo4.setText("Questionário (4/4)");

        lblPergunta4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPergunta4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPergunta4.setText("Pergunta 4");

        grupoP4.add(rbPessimo3);
        rbPessimo3.setText("Péssimo");
        rbPessimo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/pessimo_naos.png"))); // NOI18N
        rbPessimo3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/pessimo_rollover.png"))); // NOI18N
        rbPessimo3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/pessimo_selec.png"))); // NOI18N

        grupoP4.add(rbRuim3);
        rbRuim3.setText("Ruim");
        rbRuim3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/ruim_naos.png"))); // NOI18N
        rbRuim3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/ruim_rollover.png"))); // NOI18N
        rbRuim3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/ruim_selec.png"))); // NOI18N

        grupoP4.add(rbRegular3);
        rbRegular3.setText("Regular");
        rbRegular3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/regular_naos.png"))); // NOI18N
        rbRegular3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/regular_rollover.png"))); // NOI18N
        rbRegular3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/regular_selec.png"))); // NOI18N

        grupoP4.add(rbBom3);
        rbBom3.setText("Bom");
        rbBom3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/bom_naos.png"))); // NOI18N
        rbBom3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/bom_rollover.png"))); // NOI18N
        rbBom3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questionario/bom_selec.png"))); // NOI18N

        javax.swing.GroupLayout painel4Layout = new javax.swing.GroupLayout(painel4);
        painel4.setLayout(painel4Layout);
        painel4Layout.setHorizontalGroup(
            painel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPergunta4, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
            .addGroup(painel4Layout.createSequentialGroup()
                .addComponent(rbPessimo3)
                .addGap(18, 18, 18)
                .addComponent(rbRuim3)
                .addGap(18, 18, 18)
                .addComponent(rbRegular3)
                .addGap(18, 18, 18)
                .addComponent(rbBom3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(lblTitulo4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painel4Layout.setVerticalGroup(
            painel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel4Layout.createSequentialGroup()
                .addComponent(lblTitulo4)
                .addGap(18, 18, 18)
                .addComponent(lblPergunta4)
                .addGap(18, 18, 18)
                .addGroup(painel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbRuim3)
                    .addComponent(rbPessimo3)
                    .addComponent(rbRegular3)
                    .addComponent(rbBom3))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        painelPrincipal.add(painel4, "pergunta4");

        lblTituloSugestao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTituloSugestao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloSugestao.setText("Sugestão (Opcional)");

        lblSugestao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSugestao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSugestao.setText("<html>É muito importante pra nós você deixar alguma sugestão para que possamos melhorar ainda mais o nosso serviço. </html>");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setFocusable(false);
        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtAreaSugestao.setColumns(2);
        txtAreaSugestao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAreaSugestao.setLineWrap(true);
        txtAreaSugestao.setRows(2);
        jScrollPane1.setViewportView(txtAreaSugestao);

        lblCaracteres.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCaracteres.setText("Caracteres restantes:");

        lblCaracteresContador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCaracteresContador.setText("140");

        javax.swing.GroupLayout painel5Layout = new javax.swing.GroupLayout(painel5);
        painel5.setLayout(painel5Layout);
        painel5Layout.setHorizontalGroup(
            painel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel5Layout.createSequentialGroup()
                .addGroup(painel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTituloSugestao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSugestao, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(painel5Layout.createSequentialGroup()
                                .addGroup(painel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel5Layout.createSequentialGroup()
                                        .addComponent(lblCaracteres)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblCaracteresContador)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        painel5Layout.setVerticalGroup(
            painel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel5Layout.createSequentialGroup()
                .addComponent(lblTituloSugestao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSugestao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCaracteresContador)
                    .addComponent(lblCaracteres))
                .addContainerGap())
        );

        painelPrincipal.add(painel5, "sugestao");

        botaoAvancar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoAvancar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botoes/proximo naos.png"))); // NOI18N
        botaoAvancar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botoes/proximo rollover.png"))); // NOI18N
        botaoAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAvancarActionPerformed(evt);
            }
        });

        botaoVoltar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botoes/anterior naos.png"))); // NOI18N
        botaoVoltar.setEnabled(false);
        botaoVoltar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botoes/anterior rollover.png"))); // NOI18N
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(botaoVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoAvancar)
                        .addGap(9, 9, 9)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoVoltar)
                    .addComponent(botaoAvancar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAvancarActionPerformed
        String entrada = getInformacaoInserida();
        
        if (entrada!=null){
            quest.setResposta(entrada, cardAtual-1);
            
            System.out.println(">> Entrada [PAINEL Nº "+cardAtual+"]: "+entrada);
            avancar();            
        } else 
            JOptionPane.showMessageDialog(this, "Você precisa selecionar uma das opções.", "Erro", JOptionPane.ERROR_MESSAGE);
        
    }//GEN-LAST:event_botaoAvancarActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        
        voltar();         
        
    }//GEN-LAST:event_botaoVoltarActionPerformed

    String getInformacaoInserida(){
        String input;
        
        switch(cardAtual){
            case 1:
                input = utGrupo.getSelectedButtonText(grupoP1);
                break;
            case 2:
                input = utGrupo.getSelectedButtonText(grupoP2);
                break;
            case 3:
                input = utGrupo.getSelectedButtonText(grupoP3);
                break;
            case 4:
                input = utGrupo.getSelectedButtonText(grupoP4);
                break;
            default:
                input = txtAreaSugestao.getText();
                break;
        }
        
        return input;  
    }
    
    void avancar(){
        // Variavel cardAtual incrementa 1
            cardAtual++;

            // botaoVoltar fica Enabled
            botaoVoltar.setEnabled(true);

            // Caso o usuário finalize a pesquisa, é exibida a mensagem e encerra-se o programa
            if(cardAtual>qtdPaineis){
                JOptionPane.showMessageDialog(this, "Muito obrigado! :)", 
                        "Pesquisa finalizada", JOptionPane.INFORMATION_MESSAGE);
                if(quest.getResposta()[quest.getResposta().length-1].equals(""))
                    quest.setResposta(null, quest.getResposta().length-1);
                msql.cadastrarQuestionario(taxista, cliente, perguntas, quest);
                dispose();
            }
            // Painel principal altera-se para o próximo card (painel)
            CardLayout card = (CardLayout) painelPrincipal.getLayout();
            card.next(painelPrincipal);
    }
    
    void voltar(){
        if(cardAtual>1){
            // Ao usuário voltar do card 2 para o 1, desativar o botaoVoltar
            if(cardAtual==2)
                botaoVoltar.setEnabled(false);
                        
            // Variável cardAtual decrementa 1
            cardAtual--;
            
            // Painel principal altera-se para o card (painel) anterior 
            CardLayout card = (CardLayout) painelPrincipal.getLayout();
            card.previous(painelPrincipal); 
        }     
    }
    
    void filtroCampoSugestao(){
        //
        AbstractDocument filtro = (AbstractDocument) txtAreaSugestao.getDocument();
        filtro.setDocumentFilter(new Uteis.FiltroCaracteres(141, this));
        
        txtAreaSugestao.getDocument().addDocumentListener(new DocumentListener() {
            
        //<editor-fold defaultstate="collapsed" desc="metodos de DocumentListener">
            @Override
            public void insertUpdate(DocumentEvent de) {
                checar();
            }
            @Override
            public void removeUpdate(DocumentEvent de) {
                checar();
            }
            @Override
            public void changedUpdate(DocumentEvent de) {
                checar();
            }
//</editor-fold>
            public void checar(){
                int cont = 140 - txtAreaSugestao.getText().length();
                
                if(cont < 25){
                    lblCaracteresContador.setForeground(Color.RED);
                } else {
                    lblCaracteresContador.setForeground(Color.BLACK);
                }
                
                lblCaracteresContador.setText(String.valueOf(cont));
            }
        });
    }
    
    void executar(){
        // Habilita o filtro e a visibilidade no início da execução
        this.filtroCampoSugestao();
        this.criarPerguntas();
        this.setVisible(true);
    }
    
    void criarPerguntas(){
        perguntas = msql.carregarPerguntas();
        
        lblPergunta1.setText(perguntas[0].getDescricao());
        lblPergunta2.setText(perguntas[1].getDescricao());
        lblPergunta3.setText(perguntas[2].getDescricao());
        lblPergunta4.setText(perguntas[3].getDescricao());
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaQuestionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaQuestionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaQuestionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaQuestionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JanelaQuestionario q = new JanelaQuestionario();
                q.executar();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAvancar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.ButtonGroup grupoP1;
    private javax.swing.ButtonGroup grupoP2;
    private javax.swing.ButtonGroup grupoP3;
    private javax.swing.ButtonGroup grupoP4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jltitulo;
    private javax.swing.JLabel lblCaracteres;
    private javax.swing.JLabel lblCaracteresContador;
    private javax.swing.JLabel lblPergunta1;
    private javax.swing.JLabel lblPergunta2;
    private javax.swing.JLabel lblPergunta3;
    private javax.swing.JLabel lblPergunta4;
    private javax.swing.JLabel lblSugestao;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblTitulo3;
    private javax.swing.JLabel lblTitulo4;
    private javax.swing.JLabel lblTituloSugestao;
    private javax.swing.JPanel painel1;
    private javax.swing.JPanel painel2;
    private javax.swing.JPanel painel3;
    private javax.swing.JPanel painel4;
    private javax.swing.JPanel painel5;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JRadioButton rbBom;
    private javax.swing.JRadioButton rbBom1;
    private javax.swing.JRadioButton rbBom2;
    private javax.swing.JRadioButton rbBom3;
    private javax.swing.JRadioButton rbPessimo;
    private javax.swing.JRadioButton rbPessimo1;
    private javax.swing.JRadioButton rbPessimo2;
    private javax.swing.JRadioButton rbPessimo3;
    private javax.swing.JRadioButton rbRegular;
    private javax.swing.JRadioButton rbRegular1;
    private javax.swing.JRadioButton rbRegular2;
    private javax.swing.JRadioButton rbRegular3;
    private javax.swing.JRadioButton rbRuim;
    private javax.swing.JRadioButton rbRuim1;
    private javax.swing.JRadioButton rbRuim2;
    private javax.swing.JRadioButton rbRuim3;
    private javax.swing.JTextArea txtAreaSugestao;
    // End of variables declaration//GEN-END:variables
}
