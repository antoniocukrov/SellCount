package sellCount.view;

import sellCount.controller.Obrada;
import sellCount.controller.ObradaArtikl;
import sellCount.model.Artikl;
import java.util.List;
import java.util.Vector;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class PopisZalihaProzor extends javax.swing.JFrame {

    private ObradaArtikl obradaA;
    private TableRowSorter sorter;
    DefaultTableModel ms;
            
    
    public PopisZalihaProzor() {
        initComponents();
        ucitajTablicu();
        setTitle(sellCount.util.SellCountUtil.getNaslov("Popis zaliha"));
       
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pngSkladiste)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTrazi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTrazi)
                            .addComponent(txtTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(pngSkladiste, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
