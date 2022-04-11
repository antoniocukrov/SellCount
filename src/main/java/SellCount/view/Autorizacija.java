package SellCount.view;

import SellCount.controller.ObradaOperater;
import SellCount.model.Operater;
import SellCount.util.SellCountUtil;
import javax.swing.JOptionPane;
public class Autorizacija extends javax.swing.JFrame {

    private ObradaOperater obradaOperater;
    
    public Autorizacija() {
        initComponents();
        postavke();
    }
    private void postavke(){
         obradaOperater = new ObradaOperater();
        txtUsername.setText("Blagajnik");
        txtLozinka.setText("racun");
        setTitle(SellCountUtil.getNaslov("Autorizacija"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtLozinka = new javax.swing.JPasswordField();
        btnPrijava = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Username");

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel2.setText("Lozinka");

        txtLozinka.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtLozinka.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLozinkaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLozinkaFocusLost(evt);
            }
        });
        txtLozinka.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLozinkaKeyPressed(evt);
            }
        });

        btnPrijava.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPrijava.setText("Prijava");
        btnPrijava.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrijavaMouseClicked(evt);
            }
        });
        btnPrijava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrijavaActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jLabel1))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(btnPrijava, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(txtLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrijava, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrijavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrijavaActionPerformed
        autorizacija();
    }//GEN-LAST:event_btnPrijavaActionPerformed

    private void txtLozinkaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLozinkaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLozinkaKeyPressed

    private void txtLozinkaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLozinkaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLozinkaFocusLost

    private void txtLozinkaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLozinkaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLozinkaFocusGained

    private void btnPrijavaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrijavaMouseClicked
       autorizacija();
    }//GEN-LAST:event_btnPrijavaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrijava;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtLozinka;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void autorizacija(){
        if(txtUsername.getText().trim().isEmpty()){
            txtUsername.requestFocus();
            return;
        } 
        
         if(txtLozinka.getPassword().length==0){
            txtLozinka.requestFocus();
            return;
        } 

        Operater operater = obradaOperater.autoriziraj(txtUsername.getText(), new String(txtLozinka.getPassword()));
         
         if(operater==null){
             JOptionPane.showMessageDialog(getRootPane(), "Neispravna kombinacija username i lozinke");
             return;
         }
         
         SellCountUtil.operater=operater;
         
         new Izbornik().setVisible(true);
         dispose();
         
         
         
    }
}
