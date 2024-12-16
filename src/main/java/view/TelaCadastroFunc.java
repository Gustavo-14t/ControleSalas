/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.UsuarioController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.Usuario;

/**
 *
 * @author Estudo_TI
 */
public class TelaCadastroFunc extends javax.swing.JFrame {
    
public Usuario use;
int idProduto;

    /**
     * Creates new form TelaCadastroFunc
     */
    public TelaCadastroFunc(Usuario usuario) {
        initComponents();
        use =usuario;
           ListagemUsuarioC();  
           ListagemUsuarioP();
           pesquisarUsuario();
    }
    public void pesquisarUsuario(){
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
            ListagemUsuarioN(campoPesquisa.getText());
        }//fim do método pesquisar
        });//fim do método de captura
    }//fim do método PesquisarUsuario
        
        
                
        public void ListagemUsuarioN(String nomeUsuario){
        
        // chamando o produtos controller
        UsuarioController controller = new UsuarioController();
        // capturando a lista de produtos que vem do banco de dados
        List<Usuario> listausuario = controller.listarUsuarioNome(nomeUsuario);
        
        // Obtendo o modelo da tabela
        DefaultTableModel modeloTabela = 
                (DefaultTableModel) tabelaDeletar.getModel();
    
    // Limpando a tabela antes de adicionar novos dados
       modeloTabela.setRowCount(0);
    
    // Verificando se a lista não é nula
    if (listausuario != null && !listausuario.isEmpty()) {
        // Jogando os dados para dentro da minha tabela
        for (Usuario produto : listausuario) {
            // Criando uma nova linha para a tabela
            Object[] linha = {
                produto.getId_usuario(),
                produto.getNome(),
                produto.getCpf(),
                produto.getCargo(),
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
                campoCpf.setText("");
                campoSenha.setText("");
                cargoBox.setSelectedIndex(-1);
    }
 public void ListagemUsuarioP(){
    
        
        // chamando o produtos controller
        UsuarioController controller = new UsuarioController();
        // capturando a lista de produtos que vem do banco de dados
        List<Usuario> listaUsuario= controller.listarUsuario();
        
        // Obtendo o modelo da tabela
        DefaultTableModel modeloTabela = 
                (DefaultTableModel) tabelaDeletar.getModel();
    
    // Limpando a tabela antes de adicionar novos dados
       modeloTabela.setRowCount(0);
    
    // Verificando se a lista não é nula
    if (listaUsuario != null && !listaUsuario.isEmpty()) {
        // Jogando os dados para dentro da minha tabela
        for (Usuario usuario : listaUsuario) {
            // Criando uma nova linha para a tabela
            Object[] linha = {
                usuario.getId_usuario(),
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getCargo(),
            };
            // Adicionando a linha ao modelo da tabela
            modeloTabela.addRow(linha);
        }
    } else {
        JOptionPane.showMessageDialog
        (this, "Nenhum Cliente encontrado.");
    }
       
 }//fim do método de listagemUsuarioP()
 
 
        public void ListagemUsuarioC(){
        
        // chamando o produtos controller
        UsuarioController controller = new UsuarioController();
        // capturando a lista de produtos que vem do banco de dados
        List<Usuario> listaUsuario= controller.listarUsuario();
        
        // Obtendo o modelo da tabela
        DefaultTableModel modeloTabela = 
                (DefaultTableModel) tabelaUsuario.getModel();
    
    // Limpando a tabela antes de adicionar novos dados
       modeloTabela.setRowCount(0);
    
    // Verificando se a lista não é nula
    if (listaUsuario != null && !listaUsuario.isEmpty()) {
        // Jogando os dados para dentro da minha tabela
        for (Usuario usuario : listaUsuario) {
            // Criando uma nova linha para a tabela
            Object[] linha = {
                usuario.getId_usuario(),
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getCargo(),
            };
            // Adicionando a linha ao modelo da tabela
            modeloTabela.addRow(linha);
        }
    } else {
        JOptionPane.showMessageDialog
        (this, "Nenhum Cliente encontrado.");
    }
        }//fim do método ListagemUsuario()
    
    // Método que será chamado quando a seleção do JComboBox mudar
   public void campoCargoActionPerformed() {
        // Obtém o cargo selecionado no JComboBox
        String cargoSelecionado = (String)  cargoBox.getSelectedItem();

        // Verifica se o cargo selecionado é "coped" ou "porteiro"
        if (cargoSelecionado != null && (cargoSelecionado.equals("coped") || cargoSelecionado.equals("porteiro"))) {
            jLabelSenha.setVisible(true);  // Torna a JLabel visível
            campoSenha.setVisible(true);   // Torna o JTextField visível
        } else {
            jLabelSenha.setVisible(false); // Torna a JLabel invisível
            campoSenha.setVisible(false);  // Torna o JTextField invisível
        }
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        voltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDeletar = new javax.swing.JTable();
        deletar = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        campoPesquisa = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaUsuario = new javax.swing.JTable();
        cargoBox = new javax.swing.JComboBox<>();
        campoSenha = new javax.swing.JTextField();
        campoNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelSenha = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bCadastrar = new javax.swing.JButton();
        campoCpf = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });
        jPanel1.add(voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, -1));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FUNCIONÁRIOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 730, 66));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, -4, 730, 100));

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

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 690, 230));

        deletar.setText("DELETAR");
        deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarActionPerformed(evt);
            }
        });
        jPanel2.add(deletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, -1, -1));

        jLabel4.setText("PESQUISAR");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 26, 100, 20));
        jPanel2.add(campoPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 200, -1));

        jTabbedPane1.addTab("Deletar", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelaUsuario.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabelaUsuario);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 690, 170));

        cargoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "  ", "coped", "porteiro", "docente", "operacional" }));
        cargoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargoBoxActionPerformed(evt);
            }
        });
        jPanel3.add(cargoBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 130, -1));

        campoSenha.setVisible(false);
        campoSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoSenhaActionPerformed(evt);
            }
        });
        jPanel3.add(campoSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 200, -1));

        campoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeActionPerformed(evt);
            }
        });
        jPanel3.add(campoNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 200, -1));

        jLabel2.setText("CPF");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 100, 30));

        jLabel3.setText("CARGO");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 80, 30));

        jLabelSenha.setText("SENHA");
        jLabelSenha.setVisible(false);
        jPanel3.add(jLabelSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 100, 30));

        jLabel5.setText("NOME");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 16, 100, 30));

        bCadastrar.setText("CADASTRAR");
        bCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadastrarActionPerformed(evt);
            }
        });
        jPanel3.add(bCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 150, -1));

        try {
            campoCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel3.add(campoCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 200, -1));

        jTabbedPane1.addTab("Cadastar", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 730, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoSenhaActionPerformed

    private void campoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeActionPerformed

    private void cargoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargoBoxActionPerformed
        // TODO add your handling code here:
        campoCargoActionPerformed();
    }//GEN-LAST:event_cargoBoxActionPerformed

    private void bCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastrarActionPerformed
        // TODO add your handling code here:
        try{
        UsuarioController controller = new UsuarioController();
         // criando um objeto do tipo usuario da pasta model
            Usuario user = new Usuario(
                campoNome.getText(),
                campoCpf.getText(),
                campoSenha.getText(),
                cargoBox.getSelectedItem().toString()       
            );
            
                // chamando o metodo de cadastrar o usuario no banco de dados
            controller.cadastroUsuario(user);
            JOptionPane.showMessageDialog
            (null,"Usuario Cadastrado com Sucesso!");

            ListagemUsuarioC();  
            ListagemUsuarioP();  
            limparCampos();

        }catch(Exception e){
             JOptionPane.showMessageDialog
            (null,"Usuario Não Cadastrado! "+e);
        }
    }//GEN-LAST:event_bCadastrarActionPerformed

    private void tabelaDeletarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaDeletarMouseClicked
                              //Capturar qual a linha que o usuario clicou
        int linhaSelecionada = tabelaDeletar.getSelectedRow();

        //verificando se alguam linha foi selecionada
        if(linhaSelecionada>0){
            //definir modelo default para a tabela
            DefaultTableModel modeloTabela =
            (DefaultTableModel) tabelaDeletar.getModel();

            //jogando os dados da tabela para os campos de texto
            idProduto = Integer.parseInt(modeloTabela.getValueAt(linhaSelecionada, 0).toString());
            campoNome.setText(
                modeloTabela.getValueAt(linhaSelecionada,1).toString());
            campoCpf.setText(
                modeloTabela.getValueAt(linhaSelecionada,2).toString());
            cargoBox.setSelectedItem(
                modeloTabela.getValueAt(linhaSelecionada,3).toString());

        }//fim do if   
    }//GEN-LAST:event_tabelaDeletarMouseClicked

    private void deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarActionPerformed
        // TODO add your handling code here:
        UsuarioController controller = new UsuarioController();

        try{
            controller.deletarUsuario (this.idProduto);
            JOptionPane.showMessageDialog(null,"Usuario excluído com sucesso");

             ListagemUsuarioP();
             ListagemUsuarioC();
            limparCampos();
            
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null,"Erro ao excluir o Produto "+ erro);
        }
        
    }//GEN-LAST:event_deletarActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // TODO add your handling code here:
        TelaCadastro cadastro = new TelaCadastro(use);
        cadastro.setVisible(true);
        
        dispose();   
    }//GEN-LAST:event_voltarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuario use =null;
                new TelaCadastroFunc(use).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCadastrar;
    private javax.swing.JFormattedTextField campoCpf;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoPesquisa;
    private javax.swing.JTextField campoSenha;
    private javax.swing.JComboBox<String> cargoBox;
    private javax.swing.JToggleButton deletar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabelaDeletar;
    private javax.swing.JTable tabelaUsuario;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
