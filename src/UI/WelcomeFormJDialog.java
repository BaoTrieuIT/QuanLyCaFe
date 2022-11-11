package UI;

//import Utils.XImage;
import Utils.XImage;

/**
 *
 * @author Norcirpac
 */
public class WelcomeFormJDialog extends javax.swing.JDialog {

    /**
     * Creates new form WelcomeFormJDialog
     */
    public WelcomeFormJDialog() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        txtPercent = new javax.swing.JLabel();
        txtLoading = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLoading_Tittle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setkEndColor(new java.awt.Color(245, 245, 245));
        kGradientPanel1.setkStartColor(new java.awt.Color(245, 245, 245));

        txtPercent.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPercent.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtPercent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1496.gif"))); // NOI18N
        txtPercent.setText("0 %");

        txtLoading.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtLoading.setText("Loading...");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logo_169.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Vladimir Script", 0, 48)); // NOI18N
        jLabel2.setText("Café House");

        txtLoading_Tittle.setFont(new java.awt.Font("Vivaldi", 0, 48)); // NOI18N
        txtLoading_Tittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtLoading_Tittle.setText("Wake up and smell the coffee.");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(txtLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addGap(0, 278, Short.MAX_VALUE)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(294, 294, 294))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtLoading_Tittle, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtLoading_Tittle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLoading))
                .addContainerGap())
        );

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WelcomeFormJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WelcomeFormJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WelcomeFormJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WelcomeFormJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        welcome();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel txtLoading;
    private javax.swing.JLabel txtLoading_Tittle;
    private javax.swing.JLabel txtPercent;
    // End of variables declaration//GEN-END:variables
    private void init() {
        this.setLocationRelativeTo(null);
        this.setIconImage(XImage.getAppIcon());
    }

    static void welcome() {
        WelcomeFormJDialog sp = new WelcomeFormJDialog();
        sp.setVisible(true);

        try {
            for (int i = 0; i <= 102; i++) {
                Thread.sleep(90);

                sp.txtPercent.setText(i + "%");

                if (i == 10) {
                    sp.txtLoading.setText("Khởi chạy Modules...");
                    sp.txtLoading_Tittle.setText("Let us make your day!");
                }

                if (i == 30) {
                    sp.txtLoading.setText("Kết nối database...");
                    sp.txtLoading_Tittle.setText("Let us make your day!");

                }

                if (i == 50) {
                    sp.txtLoading.setText("Kết nối thành công...");
                    sp.txtLoading_Tittle.setText("We perk you up!");

                }
                if (i == 80) {
                    sp.txtLoading.setText("Khởi chạy ứng dụng...");
                    sp.txtLoading_Tittle.setText("Taste the freshness!");
                }

                if (i == 100) {
                    sp.dispose();
                    new LoginFormJDialog(new javax.swing.JFrame(), true).setVisible(true);
                }

            }

        } catch (Exception e) {

        }
    }
}
