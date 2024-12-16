/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.SalaController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.Sala;
import model.Usuario;

/**
 *
 * @author devmat
 */
public class TelaCadastroSala extends javax.swing.JFrame {
public Usuario use;
int idSala;
    /**
     * Creates new form TelaCadastroSala
     */
    public TelaCadastroSala(Usuario usuario) {
        initComponents();
        use  =usuario;
        ListagemSalaC();
        ListagemSalaD();
        pesquisarSala();
    }
    public void pesquisarSala(){
        campoPesquisa.getDocument().addDocumentListener(
                new DocumentListener(){
            //Anotação que informa que eu nção estou escrevendo um método e sim que eu estou sobre escrevendo
            //o método atual
             @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e){
                pesquisar();
            }// fim do insertUpdate
             @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e){
                pesquisar();
            }
             @Override
         public void changedUpdate(javax.swing.event.DocumentEvent e){
                pesquisar();
         }
        private void pesquisar (){
            ListagemSalaN(campoPesquisa.getText());
        }//fim do método pesquisar
        });//fim do método de captura
    }//fim do método PesquisarUsuario
    
    public void ListagemSalaN(String nomeSala){
        
        // chamando o produtos controller
       SalaController controller = new SalaController();
        // capturando a lista de produtos que vem do banco de dados
        List<Sala> listaSala = controller.listarSalaNome(nomeSala);
        
        // Obtendo o modelo da tabela
        DefaultTableModel modeloTabela = 
                (DefaultTableModel) tabelaDeletar.getModel();
    
    // Limpando a tabela antes de adicionar novos dados
       modeloTabela.setRowCount(0);
    
    // Verificando se a lista não é nula
    if (listaSala != null && !listaSala.isEmpty()) {
        // Jogando os dados para dentro da minha tabela
        for (Sala sala : listaSala) {
            // Criando uma nova linha para a tabela
            Object[] linha = {
                sala.getId_sala(),
                sala.getNome_sala(),
                sala.getCapacidade_sala(),
                sala.getDescricao_sala(),
            };
            // Adicionando a linha ao modelo da tabela
            modeloTabela.addRow(linha);
        }
    } else {
        JOptionPane.showMessageDialog
        (this, "Nenhum produto encontrado.");
    }
}// fim do metodo ListagemUsuarioN()
    
    public void limparCampos(){
       campoNome.setText("");
        boxCapacity.setSelectedIndex(-1);
                campoDesc.setText("");
                
    }
    
    public void ListagemSalaC(){
        SalaController controller = new SalaController();
        // capturando a lista de produtos que vem do banco de dados
        List<Sala> listaSala= controller.listarSala();
        
        // Obtendo o modelo da tabela
        DefaultTableModel modeloTabela = 
                (DefaultTableModel) tabelaCadastrar.getModel();
    
    // Limpando a tabela antes de adicionar novos dados
       modeloTabela.setRowCount(0);
    
    // Verificando se a lista não é nula
    if (listaSala != null && !listaSala.isEmpty()) {
        // Jogando os dados para dentro da minha tabela
        for (Sala sala : listaSala) {
            // Criando uma nova linha para a tabela
            Object[] linha = {
                sala.getId_sala(),
                sala.getNome_sala(),
                sala.getCapacidade_sala(),
                sala.getDescricao_sala(),
            };
            // Adicionando a linha ao modelo da tabela
            modeloTabela.addRow(linha);
        }
    } else {
        JOptionPane.showMessageDialog
        (this, "Nenhum Cliente encontrado.");
    }
    }//fim do método de listagemSalaC()
    
    public void ListagemSalaD(){
        // chamando o produtos controller
        SalaController controller = new SalaController();
        // capturando a lista de produtos que vem do banco de dados
        List<Sala> listaSala= controller.listarSala();
        
        // Obtendo o modelo da tabela
        DefaultTableModel modeloTabela = 
                (DefaultTableModel) tabelaDeletar.getModel();
    
    // Limpando a tabela antes de adicionar novos dados
       modeloTabela.setRowCount(0);
    
    // Verificando se a lista não é nula
    if (listaSala != null && !listaSala.isEmpty()) {
        // Jogando os dados para dentro da minha tabela
        for (Sala sala : listaSala) {
            // Criando uma nova linha para a tabela
            Object[] linha = {
                sala.getId_sala(),
                sala.getNome_sala(),
                sala.getCapacidade_sala(),
                sala.getDescricao_sala(),
            };
            // Adicionando a linha ao modelo da tabela
            modeloTabela.addRow(linha);
        }
    } else {
        JOptionPane.showMessageDialog
        (this, "Nenhum Cliente encontrado.");
    }
    }//fim do método ListagemSalaD

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaCadastrar = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLABELn = new javax.swing.JLabel();
        bCadastrar = new javax.swing.JButton();
        campoNome = new javax.swing.JTextField();
        boxCapacity = new javax.swing.JComboBox<>();
        campoDesc = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDeletar = new javax.swing.JTable();
        bDeletar = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        campoPesquisa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 90, -1));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SALAS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 730, 66));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, -4, 730, 100));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelaCadastrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NOME", "CAPACIDADE", "DESCRIÇÃO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaCadastrar);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 690, 170));

        jLabel3.setText("CAPACIDADE");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 100, 30));

        jLabel4.setText("DESCRIÇÃO");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 100, 30));

        jLABELn.setText("NOME");
        jPanel3.add(jLABELn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 130, 30));

        bCadastrar.setText("CADASTRAR");
        bCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadastrarActionPerformed(evt);
            }
        });
        jPanel3.add(bCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 58, 120, 40));
        jPanel3.add(campoNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 300, -1));

        boxCapacity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "  ", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", " " }));
        boxCapacity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxCapacityActionPerformed(evt);
            }
        });
        jPanel3.add(boxCapacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 70, -1));

        campoDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDescActionPerformed(evt);
            }
        });
        jPanel3.add(campoDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 270, 80));

        jTabbedPane1.addTab("Cadastar", jPanel3);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelaDeletar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NOME", "CAPACIDADE", "DESCRIÇÃO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaDeletar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaDeletarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaDeletar);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 690, 240));

        bDeletar.setText("DELETAR");
        bDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeletarActionPerformed(evt);
            }
        });
        jPanel2.add(bDeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, -1, -1));

        jLabel2.setText("Pesquisar");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 80, 30));
        jPanel2.add(campoPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 200, -1));

        jTabbedPane1.addTab("Deletar", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 730, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaDeletarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaDeletarMouseClicked
        // TODO add your handling code here:
        int linhaSelecionada = tabelaDeletar.getSelectedRow();

        //verificando se alguam linha foi selecionada
        if(linhaSelecionada>0){
            //definir modelo default para a tabela
            DefaultTableModel modeloTabela =
            (DefaultTableModel) tabelaDeletar.getModel();

            //jogando os dados da tabela para os campos de texto
            idSala = Integer.parseInt(modeloTabela.getValueAt(linhaSelecionada, 0).toString());
            campoNome.setText(
                modeloTabela.getValueAt(linhaSelecionada,1).toString());
            boxCapacity.setSelectedItem(
                modeloTabela.getValueAt(linhaSelecionada,3).toString());
             campoDesc.setText(
                modeloTabela.getValueAt(linhaSelecionada,2).toString());

        }//fim do if   
    }//GEN-LAST:event_tabelaDeletarMouseClicked

    private void bCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastrarActionPerformed
        // TODO add your handling code here:
        try{
        SalaController controller = new SalaController();
         // criando um objeto do tipo usuario da pasta model
            Sala sala = new Sala(
                campoNome.getText(),
               boxCapacity.getSelectedItem().toString(),
                campoDesc.getText()        
            );
            
                // chamando o metodo de cadastrar o usuario no banco de dados
            controller.cadastroSala(sala);
            JOptionPane.showMessageDialog
            (null,"Usuario Cadastrado com Sucesso!");

            ListagemSalaC();  
            ListagemSalaD();  
            limparCampos();

        }catch(Exception e){
             JOptionPane.showMessageDialog
            (null,"Usuario Não Cadastrado! "+e);
        }
                      
    }//GEN-LAST:event_bCadastrarActionPerformed

    private void campoDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDescActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        TelaCadastro cadastro = new TelaCadastro(use);
        cadastro.setVisible(true);
        
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void boxCapacityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxCapacityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxCapacityActionPerformed

    private void bDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeletarActionPerformed
        // TODO add your handling code here:
        SalaController controller = new SalaController();
        try{
            controller.deletarSala (this.idSala);
            JOptionPane.showMessageDialog(null,"Usuario excluído com sucesso");

             ListagemSalaD();
             ListagemSalaC();
            limparCampos();
            
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null,"Erro ao excluir o Produto "+ erro);
        }
        
    }//GEN-LAST:event_bDeletarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuario use =null;
                new TelaCadastroSala(use).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCadastrar;
    private javax.swing.JToggleButton bDeletar;
    private javax.swing.JComboBox<String> boxCapacity;
    private javax.swing.JTextField campoDesc;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoPesquisa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLABELn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabelaCadastrar;
    private javax.swing.JTable tabelaDeletar;
    // End of variables declaration//GEN-END:variables
}
