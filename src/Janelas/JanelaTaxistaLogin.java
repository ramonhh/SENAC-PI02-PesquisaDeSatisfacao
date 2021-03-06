/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Janelas;

import Database.ManipulacaoSQL;
import Entidades.Taxista;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author Ramon Honorio
 */
public class JanelaTaxistaLogin extends javax.swing.JFrame {
    
    ManipulacaoSQL msql;
    Taxista login;
    
    /**
     * Creates new form LoginTaxista
     */
    public JanelaTaxistaLogin() {
        initComponents();
        
        // Inserir icone :D
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/botoes/icone.png")));
        
        msql = new ManipulacaoSQL();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBemvindo = new javax.swing.JLabel();
        lblPorfavor = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        campoCPF = new javax.swing.JFormattedTextField();
        campoSenha = new javax.swing.JPasswordField();
        btAutenticar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Interface de pesquisa");

        lblBemvindo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblBemvindo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBemvindo.setText("Bem vindo ao Sistema Pesquisa de Satisfação Raikon!");

        lblPorfavor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPorfavor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPorfavor.setText("Por favor, faça o login para prosseguir:");

        lblCPF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCPF.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCPF.setText("CPF: ");

        lblSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSenha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSenha.setText("Senha:");

        try {
            campoCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoCPF.setToolTipText("Insira aqui o CPF");
        campoCPF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        campoSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btAutenticar.setText("Autenticar");
        btAutenticar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAutenticarActionPerformed(evt);
            }
        });

        btLimpar.setText("Limpar campos");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBemvindo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btLimpar)
                                .addGap(82, 82, 82)
                                .addComponent(btAutenticar))
                            .addComponent(lblPorfavor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                                .addGap(18, 31, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoCPF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(106, 106, 106)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBemvindo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPorfavor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPF)
                    .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAutenticar)
                    .addComponent(btLimpar)
                    .addComponent(btCancelar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btAutenticarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAutenticarActionPerformed
        efetuarLogin();
    }//GEN-LAST:event_btAutenticarActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        // TODO add your handling code here:
        campoCPF.setValue(null);
        campoSenha.setText(null);
    }//GEN-LAST:event_btLimparActionPerformed

    void imprimirTaxista(){
        System.out.println("-------- INFORMAÇÕES CARREGADAS --------");
        System.out.println("[ID] "+login.getId());
        System.out.println("[NOME_COMPLETO] "+login.getNome());
        System.out.println("[CPF] "+login.getCpf());
        System.out.println("[SENHA] "+login.getSenha());
        System.out.println("-----------------------------------------");
    }
    
    void executar(){
        this.setVisible(true);
    }
    
    void efetuarLogin(){
        login = new Taxista(campoCPF.getText(), new String(campoSenha.getPassword()));        
        
        if(campoCPF.getText().contains(" ")){
            msgPreencherCampos();
        } else if(msql.existeTaxista(login)){
            if(msql.autenticarTaxista(login)){
                imprimirTaxista();
                JanelaTaxistaPrincipal tp = new JanelaTaxistaPrincipal();
                tp.taxista = new Taxista(login);
                tp.arrumarTitulo();
                tp.setVisible(true);
                dispose();
            } else {
                msgSenhaIncorreta();
            }
        } else {
            msgTaxistaNaoEncontrado();
        }
    }
    
    void msgSenhaIncorreta(){
        JOptionPane.showMessageDialog(this, "Senha incorreta.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    void msgPreencherCampos(){
        String mensagem = "Por favor, preencha o campo [CPF] corretamente.";
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
        campoCPF.setValue(null);
    }
    
    void msgTaxistaNaoEncontrado(){
        JOptionPane.showMessageDialog(this, "Taxista não encontrado.","Erro", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(JanelaTaxistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaTaxistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaTaxistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaTaxistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JanelaTaxistaLogin lt = new JanelaTaxistaLogin();
                lt.executar();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAutenticar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JFormattedTextField campoCPF;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JLabel lblBemvindo;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblPorfavor;
    private javax.swing.JLabel lblSenha;
    // End of variables declaration//GEN-END:variables
}
