/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Swapnil
 */
public class Login_form extends javax.swing.JFrame {

    /**
     * Creates new form Login_form
     */
    
    public static String usnm, pwd;
    public Login_form() {
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

        jPanel1 = new javax.swing.JPanel();
        login = new javax.swing.JButton();
        unm = new javax.swing.JTextField();
        signup = new javax.swing.JButton();
        pw = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        login.setBorder(null);
        login.setBorderPainted(false);
        login.setContentAreaFilled(false);
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel1.add(login);
        login.setBounds(191, 490, 180, 30);

        unm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unmActionPerformed(evt);
            }
        });
        jPanel1.add(unm);
        unm.setBounds(150, 250, 214, 30);

        signup.setBorder(null);
        signup.setBorderPainted(false);
        signup.setContentAreaFilled(false);
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });
        jPanel1.add(signup);
        signup.setBounds(130, 600, 300, 40);

        pw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwActionPerformed(evt);
            }
        });
        jPanel1.add(pw);
        pw.setBounds(180, 310, 250, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mlib/login.png"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 0, 538, 810);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
        
        String usname=unm.getText();
       
       
        
         if(usname.equals("admin") &&  new String(pw.getPassword()).equals("admin"))
        {
            Admin w=new Admin();
            w.setVisible(true);
            this.dispose();
            
            
        }
   
         
         // add query to check if username and email address exists in user1 table, if yes then redirect to hub.java
         
          else 
         {
            int flag=0;
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbsproject?zeroDateTimeBehavior=convertToNull","root","1234");
                usnm=unm.getText();
                pwd = new String(pw.getPassword());
                String query1="Select user_name, password from user1 where user_name like "+"'"+usnm+"' and password like '" + pwd + "';";
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(query1);
                System.out.print("HERE");
                while(rs.next())
                {
                    flag=1;
                }
                con.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            if (flag==1)
            {
                Hub h = new Hub();
                h.setVisible(true);
                try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbsproject?zeroDateTimeBehavior=convertToNull","root","1234");
                    //usnm=unm.getText(); 
                    String query3 = "delete from temp_id;";
                    Statement st = con.createStatement();
                    st.execute(query3);
                    
                    String query2 = "insert into temp_id select user_id from user1 where user_name like "+"'"+usnm+"'";                    
                    Statement st2 = con.createStatement();
                    st2.execute(query2);
                    con.close();
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "WRONG USERNAME OR PASSWORD", "ERROR", JOptionPane.WARNING_MESSAGE);

            }
            
                 
         }
        
    }//GEN-LAST:event_loginActionPerformed

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
        // TODO add your handling code here:
        
        Signup su=new Signup();
        su.show();
        su.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
    }//GEN-LAST:event_signupActionPerformed

    private void unmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unmActionPerformed

    private void pwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwActionPerformed

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
            java.util.logging.Logger.getLogger(Login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField pw;
    private javax.swing.JButton signup;
    private javax.swing.JTextField unm;
    // End of variables declaration//GEN-END:variables
}
