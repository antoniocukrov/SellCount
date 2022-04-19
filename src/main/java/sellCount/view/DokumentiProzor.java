package sellCount.view;

import sellCount.controller.ObradaArtikl;
import sellCount.controller.ObradaPrimka;
import sellCount.model.Artikl;
import sellCount.model.Primka;
import sellCount.util.SellCountUtil;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DokumentiProzor extends javax.swing.JFrame {

    DefaultTableModel ms;
    ObradaPrimka Primka;

    public DokumentiProzor() {
        initComponents();
        ucitajTablicu();
        setTitle(SellCountUtil.getNaslov("Pr. dokumenti"));

    }

    public void ucitajTablicu() {
        ms = new DefaultTableModel();
        ms.addColumn("Šifra");
        ms.addColumn("Broj otpremnice");
        ms.addColumn("Djelatnik");
        ms.addColumn("Dobavljač");
        ms.addColumn("Vrijeme Zaprimanja");
        ms.addColumn("Ukupan iznos");
        tblDokumenti.setModel(ms);
        tblDokumenti.getTableHeader().setBackground(Color.LIGHT_GRAY);
        Font fontiki = new Font("Segoe", Font.BOLD, 12);
        tblDokumenti.getTableHeader().setFont(fontiki);

        new ObradaPrimka().read().forEach(s -> {
            Vector vec = new Vector();
            vec.add(s.getSifra());
            vec.add(s.getBrojOtpremnice());
            vec.add(s.getDjelatnik());
            vec.add(s.getDobavljac());
            vec.add(DajSine(s.getVrijemeZaprimanja()));
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
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnPdf = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblDokumenti.setAutoCreateRowSorter(true);
        tblDokumenti.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
        tblDokumenti.setShowGrid(true);
        jScrollPane1.setViewportView(tblDokumenti);
        tblDokumenti.getAccessibleContext().setAccessibleName("");

        jButton1.setText("Traži");

        btnPdf.setText("PDF");
        btnPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pdf.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPdf)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnPdf)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
        try {
            OtpremniceDkmnt();
            var izlaz = "C:\\" + "Otpremnice\\" + tblDokumenti.getValueAt(tblDokumenti.getSelectedRow(), 1).toString() + ".pdf";

            PdfReader pdfReader = new PdfReader("blank.pdf");

            PdfStamper pdfStamper = new PdfStamper(pdfReader,
                    new FileOutputStream(izlaz));

            BaseFont baseFont = BaseFont.createFont(
                    BaseFont.TIMES_ROMAN,
                    BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

            int pages = pdfReader.getNumberOfPages();

            for (int i = 1; i <= pages; i++) {
                PdfContentByte pageContentByte = pdfStamper.getOverContent(i);

                pageContentByte.beginText();
                pageContentByte.setFontAndSize(baseFont, 14);

                pageContentByte.setTextMatrix(400, 640);

                pageContentByte.showText(
                        tblDokumenti.getValueAt(tblDokumenti.getSelectedRow(), 1).toString()
                );
                pageContentByte.endText();
            }

            for (int i = 1; i <= pages; i++) {
                PdfContentByte pageContentByte = pdfStamper.getOverContent(i);

                pageContentByte.beginText();
                pageContentByte.setFontAndSize(baseFont, 14);

                pageContentByte.setTextMatrix(400, 615);

                pageContentByte.showText(
                        tblDokumenti.getValueAt(tblDokumenti.getSelectedRow(), 2).toString()
                );
                pageContentByte.endText();
            }

            String vrijemeZaprimanja = tblDokumenti.getValueAt(tblDokumenti.getSelectedRow(), 4).toString();
            String[] splitanoVrijeme = vrijemeZaprimanja.split(" ");
            String datum = splitanoVrijeme[0];
            String satMinut = splitanoVrijeme[1];

            for (int i = 1; i <= pages; i++) {
                PdfContentByte pageContentByte = pdfStamper.getOverContent(i);

                pageContentByte.beginText();
                pageContentByte.setFontAndSize(baseFont, 14);

                pageContentByte.setTextMatrix(400, 590);

                pageContentByte.showText(datum);
                pageContentByte.endText();
            }
            for (int i = 1; i <= pages; i++) {
                PdfContentByte pageContentByte = pdfStamper.getOverContent(i);

                pageContentByte.beginText();
                pageContentByte.setFontAndSize(baseFont, 14);

                pageContentByte.setTextMatrix(400, 565);

                pageContentByte.showText(
                        tblDokumenti.getValueAt(tblDokumenti.getSelectedRow(), 5).toString()
                );
                pageContentByte.endText();
            }

            Primka p = new ObradaPrimka().getPrimka(
                    Long.parseLong(
                            tblDokumenti.getValueAt(tblDokumenti.getSelectedRow(), 0).toString()));
            int pocetakY = 515;

            for (Artikl a : p.getArtikli()) {

                for (int i = 1; i <= pages; i++) {
                    PdfContentByte pageContentByte = pdfStamper.getOverContent(i);

                    pageContentByte.beginText();
                    pageContentByte.setFontAndSize(baseFont, 20);

                    pageContentByte.setTextMatrix(50, pocetakY);

                    pageContentByte.showText(a.getNaziv());
                    pageContentByte.endText();
                }
                pocetakY = pocetakY - 25;
            }
            //50,515

            pdfStamper.close();

            System.out.println("PDF modified successfully.");
            Desktop desktop = Desktop.getDesktop();
            File dirToOpen = null;
            try {
                dirToOpen = new File("c:\\Otpremnice");
                desktop.open(dirToOpen);
            } catch (IllegalArgumentException iae) {
                System.out.println("File Not Found");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(getRootPane(), "Puklo!");
        }
    }//GEN-LAST:event_btnPdfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPdf;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblDokumenti;
    // End of variables declaration//GEN-END:variables

    private void OtpremniceDkmnt() {
        String path = "C:\\" + "Otpremnice\\";
        File folder = new File(path);

        if (!folder.exists()) {
            folder.mkdir();
        }

    }

    private String DajSine(LocalDateTime datum) {
        LocalDateTime now = datum;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = now.format(formatter);
        return formatDateTime;
    }
}
