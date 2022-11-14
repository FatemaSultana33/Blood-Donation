/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author User
 */
public class MainPage extends javax.swing.JFrame {

    /**
     * Creates new form MainPage1
     */
    public MainPage() {
        initComponents();
        connect();
        setTitle("Login Page");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Login = new javax.swing.JPanel();
        UserName = new javax.swing.JLabel();
        UserNameInput = new javax.swing.JTextField();
        pass = new javax.swing.JLabel();
        Submit = new javax.swing.JButton();
        PasswordInput = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Login.setBackground(new java.awt.Color(255, 255, 255));
        Login.setMaximumSize(null);
        Login.setMinimumSize(null);
        Login.setPreferredSize(new java.awt.Dimension(766, 630));
        Login.setLayout(null);

        UserName.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        UserName.setText("   User Name");
        Login.add(UserName);
        UserName.setBounds(10, 200, 150, 42);
        Login.add(UserNameInput);
        UserNameInput.setBounds(10, 260, 150, 39);

        pass.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        pass.setText("    Password");
        Login.add(pass);
        pass.setBounds(10, 340, 150, 37);

        Submit.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Submit.setText("LOGIN");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });
        Login.add(Submit);
        Submit.setBounds(10, 500, 150, 45);
        Login.add(PasswordInput);
        PasswordInput.setBounds(10, 410, 150, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/MainPagePicture.jpg"))); // NOI18N
        Login.add(jLabel1);
        jLabel1.setBounds(0, 0, 770, 630);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Login, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void connect() {

        String query = "select count(*) from ADMIN1.BLOODINFO";

        try {
            Variables.myconnectionobj = DriverManager.getConnection("jdbc:derby://localhost:1527/BloodBank1", "admin1", "admin");
            Variables.mystatementobj = Variables.myconnectionobj.createStatement();
            Variables.my = Variables.mystatementobj.executeQuery(query);
            Variables.my.next();
            int count = Variables.my.getInt(1);
            Variables.ID = count;

        } catch (SQLException ex) {

        }

    }
    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed

        try {
            String username = UserNameInput.getText();
            char[] pwd = PasswordInput.getPassword();
            String password = new String(pwd);
            if (username.equals(Variables.Username) && password.equals(Variables.Password)) {
                JOptionPane.showMessageDialog(null, "Password Accepted");
                Login.setVisible(false);

                FristPage Frist = new FristPage();
                Frist.setVisible(true);
                dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Wrong Password");
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Wrong Password");
        }
    }//GEN-LAST:event_SubmitActionPerformed

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
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Login;
    private javax.swing.JPasswordField PasswordInput;
    private javax.swing.JButton Submit;
    private javax.swing.JLabel UserName;
    private javax.swing.JTextField UserNameInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel pass;
    // End of variables declaration//GEN-END:variables
}
