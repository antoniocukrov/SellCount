package SellCount.view;

import SellCount.controller.ObradaArtikl;
import SellCount.controller.ObradaPrimka;
import SellCount.controller.ObradaDjelatnik;
import SellCount.model.Artikl;
import SellCount.model.Primka;
import SellCount.model.Djelatnik;
import SellCount.util.HibernateUtil;
import SellCount.util.SellCountException;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

public class ZaprimiProzor extends javax.swing.JFrame {

    private ObradaArtikl obrada;
    private ObradaPrimka obradaP;
    private ObradaDjelatnik obradaD;
    DefaultTableModel ms;
    private double ukupniIznos;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private List<Artikl> artikliP = new ArrayList<Artikl>();

    public ZaprimiProzor() {
        initComponents();
        obrada = new ObradaArtikl();
        listaSkladiste.setCellRenderer(new PrikazArtikla());
        setTitle("Skladište");
        ucitaj();
        ucitajTablicu();
        ucitajDjelatnike();
        obradaP = new ObradaPrimka();

    }

    private void ucitajDjelatnike() {
        DefaultComboBoxModel<Djelatnik> Djelatnik = new DefaultComboBoxModel<>();
        Djelatnik dj = new Djelatnik();
        dj.setSifra(Long.valueOf(0));
        dj.setIme("Nije ");
        dj.setPrezime(" odabrano");
        Djelatnik.addElement(dj);
        new ObradaDjelatnik().read().forEach(s -> {
            Djelatnik.addElement(s);
        });
        cmbDjelatnik.setModel(Djelatnik);
    }

    private void ucitaj() {
        DefaultListModel<Artikl> m = new DefaultListModel<>();
        List<Artikl> entiteti;
        entiteti = obrada.read(txtUvjet.getText().trim());

        Collections.sort(entiteti, new ArtiklComparator());

        for (Artikl s : entiteti) {
            m.addElement(s);
        }
        listaSkladiste.setModel(m);
    }

    private void ucitajTablicu() {
        ms = new DefaultTableModel();
        obrada = new ObradaArtikl();
        ms.addColumn("Šifra");
        ms.addColumn("Naziv");
        ms.addColumn("Količina");
        ms.addColumn("JM");
        ms.addColumn("EANcode");
        tblZaprimi.setModel(ms);
        tblZaprimi.getColumnModel().getColumn(0).setMaxWidth(70);
        tblZaprimi.getColumnModel().getColumn(3).setMaxWidth(50);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        tblZaprimi.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        tblZaprimi.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblZaprimi = new javax.swing.JTable();
        txtUvjet = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaSkladiste = new javax.swing.JList<>();
        btnTrazi = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnUnesi = new javax.swing.JButton();
        btnPotvrdi = new javax.swing.JButton();
        txtOtpremnica = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cmbDjelatnik = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtUkupniIznos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblZaprimi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblZaprimi);

        txtUvjet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUvjetActionPerformed(evt);
            }
        });
        txtUvjet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUvjetKeyPressed(evt);
            }
        });

        listaSkladiste.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(listaSkladiste);

        btnTrazi.setText("Traži");
        btnTrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraziActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Pretraži po imenu");

        btnUnesi.setText("Zaprimi");
        btnUnesi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnesiActionPerformed(evt);
            }
        });

        btnPotvrdi.setText("Potvrdi");
        btnPotvrdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPotvrdiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Broj otpremnice:");

        cmbDjelatnik.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbDjelatnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDjelatnikActionPerformed(evt);
            }
        });

        jLabel2.setText("Djelatnik:");

        txtUkupniIznos.setEditable(false);

        jLabel3.setText("Ukupni iznos:");

        jLabel4.setText("kn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUnesi, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtOtpremnica, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbDjelatnik, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPotvrdi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUkupniIznos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTrazi)
                            .addComponent(txtOtpremnica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUnesi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPotvrdi, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(cmbDjelatnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtUkupniIznos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziActionPerformed
        ucitaj();
    }//GEN-LAST:event_btnTraziActionPerformed

    private void txtUvjetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUvjetKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ucitaj();
        }
    }//GEN-LAST:event_txtUvjetKeyPressed

    private void btnUnesiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnesiActionPerformed
        Vector vec = new Vector();
        vec.add(listaSkladiste.getSelectedValue().getSifra());
        vec.add(listaSkladiste.getSelectedValue().getNaziv());
        try {
            double kolicina = Double.parseDouble(JOptionPane.showInputDialog("Unesi količinu:"));
            vec.add(kolicina);
            ukupniIznos = ukupniIznos + (kolicina * listaSkladiste.getSelectedValue().getCijena());
            txtUkupniIznos.setText(df.format(ukupniIznos));
        } catch (Exception ex) {
            return;
        }
        vec.add(listaSkladiste.getSelectedValue().getJmjera());
        vec.add(listaSkladiste.getSelectedValue().getEANcode());
        ms.addRow(vec);
        tblZaprimi.setModel(ms);
        artikliP.add(listaSkladiste.getSelectedValue());


    }//GEN-LAST:event_btnUnesiActionPerformed

    private void btnPotvrdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPotvrdiActionPerformed
        if (tblZaprimi.getRowCount() < 1) {
            JOptionPane.showMessageDialog(getRootPane(), "Prvo unesite artikl koji želite zaprimiti.");
            return;
        }
        if (txtOtpremnica.getText().length() < 1) {
            JOptionPane.showMessageDialog(getRootPane(), "Unesite broj otpremnice");
        }
        for (int i = 0; i < tblZaprimi.getModel().getRowCount(); i++) {
            int sifra = Integer.parseInt(tblZaprimi.getModel().getValueAt(i, 0).toString());
            double koliko = Double.parseDouble(tblZaprimi.getModel().getValueAt(i, 2).toString());
            obrada.updateKolicina(koliko, sifra);
        }

        try {
            obradaP.setEntitet(new Primka());

            var e = obradaP.getEntitet();
            e.setBrojOtpremnice(txtOtpremnica.getText());
            e.setDjelatnik((Djelatnik) cmbDjelatnik.getSelectedItem());
            e.setUkupanIznos(ukupniIznos);
            e.setVrijemeZaprimanja(LocalDateTime.now());
            e.setArtikli(artikliP);
            e.setDobavljac(" ");

            obradaP.create();
        } catch (SellCountException ex) {
            JOptionPane.showMessageDialog(getRootPane(), "NEVALJA NEŠTO!");
        }

        artikliP.clear();
        ucitajTablicu();
        ukupniIznos = 0;

    }//GEN-LAST:event_btnPotvrdiActionPerformed

    private void txtUvjetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUvjetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUvjetActionPerformed

    private void cmbDjelatnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDjelatnikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDjelatnikActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPotvrdi;
    private javax.swing.JButton btnTrazi;
    private javax.swing.JButton btnUnesi;
    private javax.swing.JComboBox<Djelatnik> cmbDjelatnik;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Artikl> listaSkladiste;
    private javax.swing.JTable tblZaprimi;
    private javax.swing.JTextField txtOtpremnica;
    private javax.swing.JTextField txtUkupniIznos;
    private javax.swing.JTextField txtUvjet;
    // End of variables declaration//GEN-END:variables

    public Object GetData(JTable table, int row_index, int col_index) {
        return table.getModel().getValueAt(row_index, col_index);
    }

}
