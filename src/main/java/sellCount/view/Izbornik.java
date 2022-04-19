package sellCount.view;

import sellCount.controller.ObradaArtikl;
import sellCount.controller.ObradaOperater;
import game.Snake;
import sellCount.model.Artikl;
import sellCount.util.SellCountUtil;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Izbornik extends javax.swing.JFrame {

    private SimpleDateFormat df;
    ObradaArtikl obrada;
    ObradaOperater admin;

    public Izbornik() {
        initComponents();
        postavke();
                
            }
    
    private void nacrtajGraf(){
        List<Artikl> artikli = new ObradaArtikl().read();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        new ObradaArtikl().read().forEach(s ->{
           if(s.getKlasifikacija().getNaziv().matches("Gorivo")){
            dataset.setValue(s.getKolicina(), "Litara", s.getNaziv());
           }
        });
        
       
        JFreeChart jFreeChart = ChartFactory.createBarChart(
                "Razina goriva",
        "",
        "Litara",
        dataset,
        PlotOrientation.VERTICAL,
        false, true, false); 
        
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        
        pnlGraf.setLayout(new BorderLayout());
        pnlGraf.add(chartPanel, BorderLayout.CENTER);
        pnlGraf.validate();
        
        
    }
    private void postavke() {
        setTitle(SellCountUtil.getNaslov("Izbornik"));
        df = new SimpleDateFormat("dd.MMMM.yyy. HH:mm:ss");
        Vrijeme v = new Vrijeme();
        v.start();
        nacrtajGraf();
        if (!SellCountUtil.operater.getUloga().equals("oper")){
            jSkladiste.setVisible(false);
            mItemDjelatnici.setVisible(false);
            jSnake.setVisible(false);
            jKlasifikacija.setVisible(false);
        }
        
    }

    
    private class Vrijeme extends Thread {

        @Override
        public void run() {
            lVrijeme.setText(df.format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {

            }
            run();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        lVrijeme = new javax.swing.JLabel();
        lTop6 = new javax.swing.JLabel();
        pnlGraf = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jSnake = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mDatoteka = new javax.swing.JMenu();
        mItemDjelatnici = new javax.swing.JMenuItem();
        jKlasifikacija = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        mSkladiste = new javax.swing.JMenu();
        jSkladiste = new javax.swing.JMenuItem();
        jPopis = new javax.swing.JMenuItem();
        mPrimka = new javax.swing.JMenu();
        jZaprimi = new javax.swing.JMenuItem();
        jDokumenti = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        lVrijeme.setText("Time");
        jToolBar1.add(lVrijeme);

        pnlGraf.setMaximumSize(new java.awt.Dimension(400, 400));
        pnlGraf.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout pnlGrafLayout = new javax.swing.GroupLayout(pnlGraf);
        pnlGraf.setLayout(pnlGrafLayout);
        pnlGrafLayout.setHorizontalGroup(
            pnlGrafLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlGrafLayout.setVerticalGroup(
            pnlGrafLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 259, Short.MAX_VALUE)
        );

        jButton1.setText("Refresh graph");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSnake.setText("Snake game");
        jSnake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSnakeActionPerformed(evt);
            }
        });

        jButton2.setText("Logout");
        jButton2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton2FocusGained(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        mDatoteka.setText("Datoteka");

        mItemDjelatnici.setText("Djelatnici");
        mItemDjelatnici.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemDjelatniciActionPerformed(evt);
            }
        });
        mDatoteka.add(mItemDjelatnici);

        jKlasifikacija.setText("Klasifikacije");
        jKlasifikacija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKlasifikacijaActionPerformed(evt);
            }
        });
        mDatoteka.add(jKlasifikacija);

        jMenuItem1.setText("Izlaz");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mDatoteka.add(jMenuItem1);

        jMenuBar1.add(mDatoteka);

        mSkladiste.setText("Skladište");

        jSkladiste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, 0));
        jSkladiste.setText("Skladište");
        jSkladiste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSkladisteActionPerformed(evt);
            }
        });
        mSkladiste.add(jSkladiste);

        jPopis.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, 0));
        jPopis.setText("Popis zaliha");
        jPopis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPopisActionPerformed(evt);
            }
        });
        mSkladiste.add(jPopis);

        jMenuBar1.add(mSkladiste);

        mPrimka.setText("Primka");

        jZaprimi.setText("Zaprimi");
        jZaprimi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jZaprimiActionPerformed(evt);
            }
        });
        mPrimka.add(jZaprimi);

        jDokumenti.setText("Dokumenti");
        jDokumenti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDokumentiActionPerformed(evt);
            }
        });
        mPrimka.add(jDokumenti);

        jMenuBar1.add(mPrimka);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlGraf, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(12, 12, 12)
                        .addComponent(jSnake)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lTop6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlGraf, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jSnake)
                            .addComponent(jButton2))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lTop6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jDokumentiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDokumentiActionPerformed
        new DokumentiProzor().setVisible(true);
    }//GEN-LAST:event_jDokumentiActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jSkladisteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSkladisteActionPerformed
        new SkladisteProzor().setVisible(true);
    }//GEN-LAST:event_jSkladisteActionPerformed

    private void mItemDjelatniciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemDjelatniciActionPerformed
        new DjelatniciProzor().setVisible(true);
    }//GEN-LAST:event_mItemDjelatniciActionPerformed

    private void jPopisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPopisActionPerformed
        new PopisZalihaProzor().setVisible(true);
    }//GEN-LAST:event_jPopisActionPerformed

    private void jZaprimiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jZaprimiActionPerformed
        new ZaprimiProzor().setVisible(true);
    }//GEN-LAST:event_jZaprimiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        nacrtajGraf();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jSnakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSnakeActionPerformed
          EventQueue.invokeLater(() -> {
            JFrame ex = new Snake();
            ex.setVisible(true);
        });
    }//GEN-LAST:event_jSnakeActionPerformed

    private void jKlasifikacijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jKlasifikacijaActionPerformed
        new KlasifikacijaProzor().setVisible(true);
    }//GEN-LAST:event_jKlasifikacijaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Autorizacija().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton2FocusGained
          jButton2.paint(g);
    }//GEN-LAST:event_jButton2FocusGained
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenuItem jDokumenti;
    private javax.swing.JMenuItem jKlasifikacija;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jPopis;
    private javax.swing.JMenuItem jSkladiste;
    private javax.swing.JButton jSnake;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem jZaprimi;
    private javax.swing.JLabel lTop6;
    private javax.swing.JLabel lVrijeme;
    private javax.swing.JMenu mDatoteka;
    private javax.swing.JMenuItem mItemDjelatnici;
    private javax.swing.JMenu mPrimka;
    private javax.swing.JMenu mSkladiste;
    private javax.swing.JPanel pnlGraf;
    // End of variables declaration//GEN-END:variables
}
