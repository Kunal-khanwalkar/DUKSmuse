/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlib;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import static mlib.Login_form.usnm;

/**
 *
 * @author sarthak
 */
public class SearchAlbum extends javax.swing.JFrame {
    ArrayList<Song> songsList=new ArrayList<>();
    String[][] play2 = new String[5][2];
    //play[0][0] = "5000";
    //play[0][1] = "sample playlist";
    /**
     * Creates new form SearchAlbum
     */
    public SearchAlbum() {
        initComponents();
        //String[][] play = new String[5][2];
        play2[0][0] = "5000";
        play2[0][1] = "sample playlist";
        play2[1][0] = "5001";
        play2[1][1] = "chill songs";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbsproject?zeroDateTimeBehavior=convertToNull","root","1234");
            System.out.print("DAFQ");
            String query1="Select playlist_id, playlist_name from playlistname natural join user1 where user_name like "+"'"+usnm+"';";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query1);
            //ComboBoxModel model = new ComboBoxModel();
            Object[] row= new Object[3];
            int i=0;
            while(rs.next())
            {
                //play[i][0] = rs.getString("playlist_id");
                //play[i][1] = rs.getString("playlist_name");
                i++;
                System.out.print(rs.getString("playlist_name"));
                list.addItem(rs.getString("playlist_name"));
                        
            }
            con.close();
            
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    /*public ArrayList<Song> songList()
    {
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbsproject?zeroDateTimeBehavior=convertToNull","root","1234");
            String aname=jTextField1.getText();
             String query1="Select song_name,artist_name,album_name,Year,song_id from artist natural join song natural join album where artist_name like "+"'"+aname+"'";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query1);
            Song song;
            while(rs.next())
            {
                song=new Song(rs.getString("song_name"),rs.getString("artist_name"),rs.getString("album_name"),rs.getString("Year"),rs.getInt("song_id"));
                songsList.add(song);
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return songsList;
    }
    public void showSongs()
    {
        ArrayList<Song> songs=songList();
        DefaultTableModel model=(DefaultTableModel)song_table.getModel();  
        Object[] row= new Object[4];
        for(int i=0;i<songs.size();i++)
        {
            row[0]=songs.get(i).getName();
            row[1]=songs.get(i).getArtist();
            row[2]=songs.get(i).getAlbum();
            row[3]=songs.get(i).getYear();
            model.addRow(row);
            
        }
        
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        song_table = new javax.swing.JTable();
        Back = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        album = new javax.swing.JTextField();
        Play = new javax.swing.JButton();
        AddtoPlaylist = new javax.swing.JButton();
        list = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocation(new java.awt.Point(500, 50));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Name Of Album");

        Search.setBackground(java.awt.Color.black);
        Search.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        Search.setForeground(new java.awt.Color(0, 204, 0));
        Search.setText("Search>");
        Search.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Search.setFocusPainted(false);
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        song_table.setBackground(java.awt.Color.black);
        song_table.setForeground(new java.awt.Color(0, 204, 0));
        song_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Rating", "Genre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(song_table);

        Back.setBackground(java.awt.Color.black);
        Back.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        Back.setForeground(new java.awt.Color(0, 204, 0));
        Back.setText("<Back");
        Back.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Back.setFocusPainted(false);
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Search");

        album.setBackground(new java.awt.Color(0, 0, 153));
        album.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N

        Play.setBackground(java.awt.Color.black);
        Play.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        Play.setForeground(new java.awt.Color(0, 204, 0));
        Play.setText("Play ");
        Play.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Play.setFocusPainted(false);
        Play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayActionPerformed(evt);
            }
        });

        AddtoPlaylist.setBackground(java.awt.Color.black);
        AddtoPlaylist.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        AddtoPlaylist.setForeground(new java.awt.Color(0, 204, 0));
        AddtoPlaylist.setText("Add to Playlist");
        AddtoPlaylist.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        AddtoPlaylist.setFocusPainted(false);
        AddtoPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddtoPlaylistActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(AddtoPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(list, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(Play, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(album, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(album, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Search)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(Play)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(AddtoPlaylist)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Back)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        // TODO add your handling code here:
       
        //String aname = album.getText();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbsproject?zeroDateTimeBehavior=convertToNull","root","1234");
            String aname=album.getText();
             String query1="Select song_name,rating,genre, artist_name, album_name, year, song_id from song natural join album natural join artist where album_name like "+"'"+aname+"%';";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query1);
            DefaultTableModel model=(DefaultTableModel)song_table.getModel();
            model.setRowCount(0);
            Object[] row= new Object[3];
            Song song;
            while(rs.next())
            {
                row[0] = rs.getString("song_name");
                row[1] = rs.getString("rating");
                row[2] = rs.getString("genre");
                model.addRow(row);
                System.out.print("INSIDE");
                song=new Song(rs.getString("song_name"),rs.getString("artist_name"),rs.getString("album_name"),rs.getString("Year"),rs.getInt("song_id"));
                songsList.add(song);
                        
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_SearchActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Search h=new Search();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void PlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayActionPerformed
        // TODO add your handling code here:
        int row=song_table.getSelectedRow();
        System.out.print("HEREINPLAY");
         System.out.println(row);
         System.out.println(songsList.get(row).getId());
         
             
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbsproject?zeroDateTimeBehavior=convertToNull","root","1234");
            /*Statement st=con.createStatement();
            int row=song_table.getSelectedRow();
            int id1=songsList.get(row-1).getId();
            String query1="select son_id from song where song_name = '"+id1;
            ResultSet rs=st.executeQuery(query1);*/
            CallableStatement mystmt=con.prepareCall("{call updatePlayCount(?)}");
            mystmt.setInt(1,songsList.get(row).getId());
            mystmt.execute();
        }
        catch(Exception e){System.out.println(e);}
    }//GEN-LAST:event_PlayActionPerformed

    private void AddtoPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddtoPlaylistActionPerformed
        // TODO add your handling code here:
        int row=song_table.getSelectedRow();
        //System.out.print("play[1][0]");
         System.out.println(row);
         System.out.println(songsList.get(row).getId());
         int j=0;
         row = list.getSelectedIndex();
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbsproject?zeroDateTimeBehavior=convertToNull","root","1234");
            /*Statement st=con.createStatement();
            int row=song_table.getSelectedRow();
            int id1=songsList.get(row-1).getId();
            String query1="select son_id from song where song_name = '"+id1;
            ResultSet rs=st.executeQuery(query1);*/
            
            CallableStatement mystmt=con.prepareCall("insert into playlist ( playlist_id, song_id ) values (" + play2[row][0] + ", " +  songsList.get(row).getId() + " );");
            //mystmt.setInt(1,songsList.get(row).getId());
            mystmt.execute();
        }
        catch(Exception e){System.out.println(e);}
        
        
        
    }//GEN-LAST:event_AddtoPlaylistActionPerformed

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
            java.util.logging.Logger.getLogger(SearchAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchAlbum().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddtoPlaylist;
    private javax.swing.JButton Back;
    private javax.swing.JButton Play;
    private javax.swing.JButton Search;
    private javax.swing.JTextField album;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> list;
    private javax.swing.JTable song_table;
    // End of variables declaration//GEN-END:variables
}