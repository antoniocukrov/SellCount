package SellCount.view;

import SellCount.controller.Obrada;
import SellCount.controller.ObradaArtikl;
import SellCount.model.Artikl;
import java.util.List;
import java.util.Vector;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class PopisZaliha extends javax.swing.JFrame {

    private ObradaArtikl obradaA;
    private TableRowSorter sorter;
    DefaultTableModel ms;
            
    
    public PopisZaliha() {
        initComponents();
        ucitajTablicu();
        setTitle(SellCount.util.SellCountUtil.NAZIV_APP +"|Popis Zaliha");
       
        sorter = new TableRowSorter<>(ms);
        tblPopis.setRowSorter(sorter);
        
        txtTrazi.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
            search(txtTrazi.getText());
         }
         @Override
         public void removeUpdate(DocumentEvent e) {
            search(txtTrazi.getText());
         }
         @Override
         public void changedUpdate(DocumentEvent e) {
            search(txtTrazi.getText());
         }
         public void search(String str) {
            if (str.length() == 0) {
               sorter.setRowFilter(null);
            } else {
               sorter.setRowFilter(RowFilter.regexFilter(str));
            }
         }
      });
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPopis = new javax.swing.JTable();
        txtTrazi = new javax.swing.JTextField();
        lblTrazi = new javax.swing.JLabel();
        pngSkladiste = new javax.swing.JLabel();
        bPrint = new javax.swing.JButton();
        bPdf = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblPopis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPopis.setEnabled(false);
        tblPopis.setShowGrid(true);
        jScrollPane1.setViewportView(tblPopis);

        lblTrazi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrazi.setText("Traži");

        pngSkladiste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storage.jpg"))); // NOI18N

        bPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/print.jpg"))); // NOI18N
        bPrint.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        bPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pdf.jpg"))); // NOI18N
        bPdf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        jLabel1.setText("Storage");
        jLabel1.setFocusTraversalPolicyProvider(true);

        jLabel2.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        jLabel2.setText("ROOM");
        jLabel2.setFocusTraversalPolicyProvider(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pngSkladiste)
                        .addGap(43, 43, 43)
                        .addComponent(lblTrazi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2))
                            .addComponent(txtTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64)
                        .addComponent(bPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 99, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTrazi)))
                    .addComponent(pngSkladiste, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bPdf;
    private javax.swing.JButton bPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTrazi;
    private javax.swing.JLabel pngSkladiste;
    private javax.swing.JTable tblPopis;
    private javax.swing.JTextField txtTrazi;
    // End of variables declaration//GEN-END:variables

    private void ucitajTablicu() {
        ms = new DefaultTableModel();
        obradaA = new ObradaArtikl();
        ms.addColumn("Naziv");
        ms.addColumn("Cijena");
        ms.addColumn("Količina");
        ms.addColumn("JM");
        ms.addColumn("Klasifikacija");
        ms.addColumn("EANcode");
        
       
        
        new ObradaArtikl().read().forEach(s ->{
            Vector vec = new Vector();
            vec.add(s.getNaziv());
            vec.add(s.getCijena());
            vec.add(s.getKolicina());
            vec.add(s.getJmjera());
            vec.add(s.getKlasifikacija());
            vec.add(s.getEANcode());
            ms.addRow(vec);
            });
                
        tblPopis.setModel(ms);
        tblPopis.getColumnModel().getColumn(0).setMaxWidth(210);
        tblPopis.getColumnModel().getColumn(0).setPreferredWidth(200);
        tblPopis.getColumnModel().getColumn(1).setMaxWidth(80);
        tblPopis.getColumnModel().getColumn(2).setMaxWidth(100);
        tblPopis.getColumnModel().getColumn(3).setMaxWidth(50);
        tblPopis.getColumnModel().getColumn(4).setMaxWidth(100);
        tblPopis.getColumnModel().getColumn(5).setMaxWidth(150);
    }
}
