package SellCount.view;

import SellCount.controller.ObradaArtikl;
import SellCount.controller.ObradaPrimka;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DokumentiProzor extends javax.swing.JFrame {
    DefaultTableModel ms;
    
    public DokumentiProzor() {
        initComponents();
        ucitajTablicu();
        
    }
    
    public void ucitajTablicu(){
        ms = new DefaultTableModel();
        ms.addColumn("Šifra");
        ms.addColumn("Broj otpremnice");
        ms.addColumn("Djelatnik");
        ms.addColumn("Dobavljač");
        ms.addColumn("Vrijeme Zaprimanja");
        ms.addColumn("Ukupan iznos");
        tblDokumenti.setModel(ms);
        
        new ObradaPrimka().read().forEach(s ->{
            Vector vec = new Vector();
            vec.add(s.getSifra());
            vec.add(s.getBrojOtpremnice());
            vec.add(s.getDjelatnik());
            vec.add(s.getDobavljac());
            vec.add(s.getVrijemeZaprimanja());
            vec.add(s.getUkupanIznos());
                                    
            ms.addRow(vec);
            });
        
        tblDokumenti.setModel(ms);
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDokumenti = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnPdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblDokumenti.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblDokumenti);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Traži");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Sortiraj");

        btnPdf.setText("PDF");
        btnPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPdf)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPdf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
     try {
           OtpremniceDkmnt();
           var izlaz = "C:\\"+"Otpremnice\\" + tblDokumenti.getValueAt(tblDokumenti.getSelectedRow(),1 ).toString() + ".pdf";
                                                
		    PdfReader pdfReader = new PdfReader("blank.pdf");	
 
		    PdfStamper pdfStamper = new PdfStamper(pdfReader,
			new FileOutputStream(izlaz));
 
		    BaseFont baseFont = BaseFont.createFont(
	                BaseFont.TIMES_ROMAN, 
	                BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
 
		    int pages = pdfReader.getNumberOfPages(); 
 
		    for(int i=1; i<=pages; i++) { 
			PdfContentByte pageContentByte = pdfStamper.getOverContent(i);
 
			pageContentByte.beginText();
			pageContentByte.setFontAndSize(baseFont, 14);
 
			pageContentByte.setTextMatrix(400, 640);
 
			pageContentByte.showText(
                                tblDokumenti.getValueAt(tblDokumenti.getSelectedRow(), 1).toString()
                                                );
			pageContentByte.endText();
		    }
                    
                    for(int i=1; i<=pages; i++) { 
			PdfContentByte pageContentByte = pdfStamper.getOverContent(i);
 
			pageContentByte.beginText();
			pageContentByte.setFontAndSize(baseFont, 14);
 
			pageContentByte.setTextMatrix(400, 615);
 
			pageContentByte.showText(
                                tblDokumenti.getValueAt(tblDokumenti.getSelectedRow(), 2).toString()
                                                );
			pageContentByte.endText();
		    }
                    
                    String vrijemeZaprimanja=tblDokumenti.getValueAt(tblDokumenti.getSelectedRow(), 4).toString();
                    String[] splitanoVrijeme= vrijemeZaprimanja.split("T");
                    String datum=splitanoVrijeme[0];
                    String satMinut=splitanoVrijeme[1];
                    
                    for(int i=1; i<=pages; i++) { 
			PdfContentByte pageContentByte = pdfStamper.getOverContent(i);
 
			pageContentByte.beginText();
			pageContentByte.setFontAndSize(baseFont, 14);
 
			pageContentByte.setTextMatrix(400, 590);
 
			pageContentByte.showText(datum);
			pageContentByte.endText();
		    }
                    for(int i=1; i<=pages; i++) { 
			PdfContentByte pageContentByte = pdfStamper.getOverContent(i);
 
			pageContentByte.beginText();
			pageContentByte.setFontAndSize(baseFont, 14);
 
			pageContentByte.setTextMatrix(400, 565);
 
			pageContentByte.showText(
                                tblDokumenti.getValueAt(tblDokumenti.getSelectedRow(), 5).toString()
                                                );
			pageContentByte.endText();
		    }
 
		    pdfStamper.close();	
 
		    System.out.println("PDF modified successfully.");
		} catch (Exception e) {
		         JOptionPane.showMessageDialog(getRootPane(), "Puklo bjatić!");
		}
    }//GEN-LAST:event_btnPdfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPdf;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblDokumenti;
    // End of variables declaration//GEN-END:variables

    private void OtpremniceDkmnt(){
        String path = "C:\\"+"Otpremnice\\";
        File folder = new File(path);
        
        if(!folder.exists()){
            folder.mkdir();
        }
        
    }
}
