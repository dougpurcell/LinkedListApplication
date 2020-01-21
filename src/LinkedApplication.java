/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dls102
 */
public class LinkedApplication extends javax.swing.JFrame {

    /**
     * Creates new form LinkedApplication
     */
    public LinkedApplication() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileNameLabel = new javax.swing.JLabel();
        filenameField = new javax.swing.JTextField();
        buildDisplayButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        display = new javax.swing.JTextArea();
        sortbByYearsButton = new javax.swing.JToggleButton();
        sortByName = new javax.swing.JToggleButton();
        sortByTitleAndSalary = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileNameLabel.setText("Enter Filename:");

        filenameField.setText("sampledata.txt");

        buildDisplayButton.setText("Build and Display");
        buildDisplayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buildDisplayButtonActionPerformed(evt);
            }
        });

        display.setColumns(20);
        display.setRows(5);
        jScrollPane1.setViewportView(display);

        sortbByYearsButton.setText("Sort By Years");
        sortbByYearsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortbByYearsButtonActionPerformed(evt);
            }
        });

        sortByName.setText("Sort By Name");
        sortByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortByNameActionPerformed(evt);
            }
        });

        sortByTitleAndSalary.setText("Sort Title & Salary");
        sortByTitleAndSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortByTitleAndSalaryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fileNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filenameField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buildDisplayButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sortbByYearsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sortByName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sortByTitleAndSalary)
                        .addGap(0, 205, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileNameLabel)
                    .addComponent(filenameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buildDisplayButton)
                    .addComponent(sortbByYearsButton)
                    .addComponent(sortByName)
                    .addComponent(sortByTitleAndSalary))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buildDisplayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buildDisplayButtonActionPerformed
        if (manager.initialize(filenameField.getText()))  // true = operation successful
        display.setText(manager.print());
    }//GEN-LAST:event_buildDisplayButtonActionPerformed

    private void sortbByYearsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortbByYearsButtonActionPerformed
        manager.sortByYears();  // true = operation successful
        display.setText(manager.print());
    }//GEN-LAST:event_sortbByYearsButtonActionPerformed

    private void sortByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortByNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sortByNameActionPerformed

    private void sortByTitleAndSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortByTitleAndSalaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sortByTitleAndSalaryActionPerformed

    public void displayText(String s)
    {
        display.setText(s);
    }
    
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
            java.util.logging.Logger.getLogger(LinkedApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LinkedApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LinkedApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LinkedApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LinkedApplication().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buildDisplayButton;
    private javax.swing.JTextArea display;
    private javax.swing.JLabel fileNameLabel;
    private javax.swing.JTextField filenameField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton sortByName;
    private javax.swing.JToggleButton sortByTitleAndSalary;
    private javax.swing.JToggleButton sortbByYearsButton;
    // End of variables declaration//GEN-END:variables

private LinkManager manager = new LinkManager(this);
}
