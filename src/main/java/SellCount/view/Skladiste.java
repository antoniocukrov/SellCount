package SellCount.view;

import SellCount.controller.ObradaArtikl;
import SellCount.controller.ObradaJmjera;
import SellCount.controller.ObradaKlasifikacija;
import SellCount.model.Artikl;
import SellCount.model.Jmjera;
import SellCount.model.Klasifikacija;
import SellCount.util.SellCountException;
import java.awt.event.KeyEvent;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class Skladiste extends javax.swing.JFrame {
        private ObradaArtikl obrada;
             
    
        public Skladiste() {
        initComponents();
        obrada = new ObradaArtikl();
        listaSkladiste.setCellRenderer(new PrikazArtikla());
        setTitle("Skladište");
        ucitaj();
        ucitajJmjere();
        ucitajKlasifikaciju();
        
    }
    
        private void ucitaj() {
            DefaultListModel<Artikl> m = new DefaultListModel<>();
            List<Artikl> entiteti;
            entiteti=obrada.read(txtUvjet.getText().trim());
            
            Collections.sort(entiteti,new ArtiklComparator());
            
            for(Artikl s: entiteti){
                m.addElement(s);
            }
        listaSkladiste.setModel(m); 
        }
        
        private void ucitajJmjere() {
        DefaultComboBoxModel<Jmjera> ms = new DefaultComboBoxModel<>();
        Jmjera jm = new Jmjera();
        jm.setSifra(Long.valueOf(0));
        jm.setNaziv("-");
        ms.addElement(jm);
        new ObradaJmjera().read().forEach(s -> {
            ms.addElement(s);
        });
        cmbJM.setModel(ms);
    }
            
        public void ucitajKlasifikaciju(){
            DefaultComboBoxModel<Klasifikacija> ks = new DefaultComboBoxModel<>();
            Klasifikacija klas = new Klasifikacija();
            klas.setSifra(Long.valueOf(0));
            klas.setNaziv("Nije odabrano");
            ks.addElement(klas);
            new ObradaKlasifikacija().read().forEach(s -> {
                ks.addElement(s);
            });
            cmbKlas.setModel(ks);
        }
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        listaSkladiste = new javax.swing.JList<>();
        txtUvjet = new javax.swing.JTextField();
        txtNaziv = new javax.swing.JTextField();
        txtCijena = new javax.swing.JTextField();
        txtEan = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbJM = new javax.swing.JComboBox<>();
        btnTrazi = new javax.swing.JButton();
        btnKreiraj = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cmbKlas = new javax.swing.JComboBox<>();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtKolicina = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        listaSkladiste.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaSkladiste.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaSkladisteValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listaSkladiste);

        txtUvjet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUvjetKeyPressed(evt);
            }
        });

        txtNaziv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNazivActionPerformed(evt);
            }
        });

        txtCijena.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCijena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCijenaActionPerformed(evt);
            }
        });

        txtEan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEanActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Naziv");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Eancode");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Cijena");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("JM");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Klasifikacija");

        cmbJM.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbJM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbJMActionPerformed(evt);
            }
        });

        btnTrazi.setText("Traži");
        btnTrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraziActionPerformed(evt);
            }
        });

        btnKreiraj.setText("Kreiraj");
        btnKreiraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cash.png"))); // NOI18N

        cmbKlas.setToolTipText("");

        btnPromjeni.setText("Promjeni");
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Pretraži po imenu");

        txtKolicina.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Količina");

        jLabel9.setFont(new java.awt.Font("Ravie", 1, 34)); // NOI18N
        jLabel9.setText("ADMIN");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("kn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(txtUvjet)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEan)
                            .addComponent(txtNaziv)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(cmbKlas, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnKreiraj)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnObrisi))
                                    .addComponent(btnPromjeni)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCijena, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10)))
                                .addGap(0, 6, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(cmbJM, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTrazi)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(1, 1, 1)
                        .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2)
                        .addGap(1, 1, 1)
                        .addComponent(txtEan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtCijena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel4)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbJM, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbKlas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnKreiraj)
                            .addComponent(btnObrisi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPromjeni))
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUvjetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUvjetKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            ucitaj();
        }
    }//GEN-LAST:event_txtUvjetKeyPressed

    private void txtNazivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNazivActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNazivActionPerformed

    private void txtCijenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCijenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCijenaActionPerformed

    private void txtEanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEanActionPerformed

    private void listaSkladisteValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaSkladisteValueChanged
        if (evt.getValueIsAdjusting() || listaSkladiste.getSelectedValue()==null){
            return;
        }
        obrada.setEntitet(listaSkladiste.getSelectedValue());
        var e = obrada.getEntitet();
        txtNaziv.setText(e.getNaziv());
        txtEan.setText(e.getEANcode());
        txtCijena.setText(Double.toString(e.getCijena()));
        txtKolicina.setText(Double.toString(e.getKolicina()));
       
        if (e.getJmjera()==null) {
        cmbJM.setSelectedIndex(0);
        } else {
            cmbJM.setSelectedItem(e.getJmjera());
            }
        
        if (e.getKlasifikacija()==null){
            cmbKlas.setSelectedIndex(0);
        } else {
            cmbKlas.setSelectedItem(e.getKlasifikacija());
        }
              
                          
    }//GEN-LAST:event_listaSkladisteValueChanged

    private void btnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziActionPerformed
        ucitaj();
    }//GEN-LAST:event_btnTraziActionPerformed

    private void btnKreirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajActionPerformed
        try {
            obrada.setEntitet(new Artikl());
            preuzmiVrijednosti();
            obrada.create();
            ucitaj();
        } catch (SellCountException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }
    }//GEN-LAST:event_btnKreirajActionPerformed

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed

        if (obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberite stavku");
            return;
        }
        preuzmiVrijednosti();

        try {
            obrada.update();
            ucitaj();
        } catch (SellCountException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }
    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed

        if (obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberite stavku");
            return;
        }

        if(JOptionPane.showConfirmDialog(
            getRootPane(),
            "Sigurno obrisati \"" + obrada.getEntitet().getNaziv() + "\"?",
            "Brisanje",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE)==JOptionPane.NO_OPTION){
        return;
        }

        try {
            obrada.delete();
            ucitaj();
        } catch (SellCountException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void cmbJMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbJMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbJMActionPerformed

    private void preuzmiVrijednosti() {
        var e = obrada.getEntitet();
        e.setNaziv(txtNaziv.getText());
        e.setEANcode(txtEan.getText());
        e.setCijena(Double.parseDouble(txtCijena.getText()));
        e.setKolicina(Double.parseDouble(txtKolicina.getText()));
        e.setJmjera((Jmjera) cmbJM.getSelectedItem());
        e.setKlasifikacija((Klasifikacija)cmbKlas.getSelectedItem());
       
        
        
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKreiraj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JButton btnTrazi;
    private javax.swing.JComboBox<Jmjera> cmbJM;
    private javax.swing.JComboBox<Klasifikacija> cmbKlas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Artikl> listaSkladiste;
    private javax.swing.JTextField txtCijena;
    private javax.swing.JTextField txtEan;
    private javax.swing.JTextField txtKolicina;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtUvjet;
    // End of variables declaration//GEN-END:variables
}
