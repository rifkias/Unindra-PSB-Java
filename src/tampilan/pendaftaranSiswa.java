/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import koneksi.koneksi;

/**
 *
 * @author lincbp
 */
public class pendaftaranSiswa extends javax.swing.JPanel {
    private Connection conn = new koneksi().connect();
    
    private List<Map.Entry<String, String>> listEskul;
    private List<Map.Entry<String, String>> listJurusan;
    
    private int idPendaftaran;
    private int IdSiswa;
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhms");
    /**
     * Creates new form pendaftaranSiswa
     */
    public pendaftaranSiswa(int idSiswa) {
        initComponents();
        IdSiswa = idSiswa;
        this.initEskul();
        this.initJurusan();
        this.checkPendaftaran();
    }
    
    public void reset(){
        namaAyahTxt.setText("");
        pekerjaanAyahTxt.setText("");
        namaIbuTxt.setText("");
        pekerjaanIbuTxt.setText("");
        namaSekolahAsalTxt.setText("");
        nomorIjazahTxt.setText("");
        tahunLulusTxt.setText("");
        isEskulYes.setSelected(true);
        comboEskul.setSelectedIndex(0);
        comboJurusan.setSelectedIndex(0);
        
    }
    
    public void initEskul(){
        Map<String, String> map = new HashMap<>(); 
        String sql = "SELECT * FROM ekstrakulikuler";
        comboEskul.removeAllItems();
        comboEskul.addItem("");
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                map.put(hasil.getString("id_ekstrakulikuler"), hasil.getString("nama_esktrakulikuler"));
                comboEskul.addItem(hasil.getString("nama_esktrakulikuler"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        
        Set<Map.Entry<String, String> > set = map.entrySet();
        List<Map.Entry<String, String> > list = new ArrayList<>(set);
        listEskul = list;
    }
    
    public void initJurusan(){
        Map<String, String> map = new HashMap<>(); 
        String sql = "SELECT * FROM jurusan";
        comboJurusan.removeAllItems();
        comboJurusan.addItem("");
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                map.put(hasil.getString("id_jurusan"), hasil.getString("nama_jurusan"));
                comboJurusan.addItem(hasil.getString("nama_jurusan"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        
        Set<Map.Entry<String, String> > set = map.entrySet();
        List<Map.Entry<String, String> > list = new ArrayList<>(set);
        listJurusan = list;
    }
    
    public int getEskul(String nama){
        int res = 0;
        
        for(int i = 0; i<listEskul.size(); i++){
            if(listEskul.get(i).getValue().equals(nama)){
                res = Integer.valueOf(listEskul.get(i).getKey());
                break;
            }
        }
        
        return res;
    }
    public int getJurusan(String nama){
        int res = 0;
        
        for(int i = 0; i<listJurusan.size(); i++){
            if(listJurusan.get(i).getValue().equals(nama)){
                res = Integer.valueOf(listJurusan.get(i).getKey());
                break;
            }
        }
        
        return res;
    }

    public void checkPendaftaran(){
        if(queryCheckPendaftaran()){
            // Has Saved Before
            btnUpdate.setVisible(true);
            btnSave.setVisible(false);
        }else{
            // Never Save Register
            btnSave.setVisible(true);
            btnUpdate.setVisible(false);
        }
    }
    
    public boolean queryCheckPendaftaran(){
        
        boolean res = false;
        String sql = "SELECT  p.*,e.nama_esktrakulikuler AS nama_eskul, j.nama_jurusan AS nama_jurusan FROM pendaftaran p LEFT JOIN jurusan j ON j.id_jurusan = p.id_jurusan LEFT JOIN ekstrakulikuler e ON e.id_ekstrakulikuler = p.eskul_id WHERE id_siswa = '"+ IdSiswa +"' limit 1";
        
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            ResultSet rs = stat.executeQuery(sql);
            if(rs.next()){
                res = true;
                namaAyahTxt.setText(rs.getString("nama_ayah"));
                pekerjaanAyahTxt.setText(rs.getString("pekerjaan_ayah"));
                namaIbuTxt.setText(rs.getString("nama_ibu"));
                pekerjaanIbuTxt.setText(rs.getString("pekerjaan_ibu"));
                namaSekolahAsalTxt.setText(rs.getString("sekolah_asal"));
                tahunLulusTxt.setText(rs.getString("tahun_lulus"));
                comboEskul.setSelectedItem(rs.getString("nama_eskul"));
                comboJurusan.setSelectedItem(rs.getString("nama_jurusan"));
                nomorIjazahTxt.setText(rs.getString("no_ijazah"));
                idPendaftaran = rs.getInt("id_pendaftaran");
                
                int isEskul = rs.getInt("is_eskul");
                
                if(isEskul == 0){
                    isEskulNo.setSelected(true);
                }
                if(isEskul == 1){
                    isEskulYes.setSelected(true);
                }
                
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        
        return res;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        bgIsEskul = new javax.swing.ButtonGroup();
        cardLayout = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        namaAyahTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pekerjaanAyahTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        namaIbuTxt = new javax.swing.JTextField();
        pekerjaanIbuTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        namaSekolahAsalTxt = new javax.swing.JTextField();
        nomorIjazahTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tahunLulusTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        isEskulYes = new javax.swing.JRadioButton();
        isEskulNo = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        comboEskul = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        comboJurusan = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setLayout(new java.awt.CardLayout());

        cardLayout.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cardLayout.setLayout(new javax.swing.BoxLayout(cardLayout, javax.swing.BoxLayout.LINE_AXIS));

        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));
        jPanel6.setPreferredSize(new java.awt.Dimension(100, 421));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 99, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
        );

        cardLayout.add(jPanel6);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        jLabel1.setText("1. Masukan Nama Ayah Kandung Anda");

        jLabel2.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        jLabel2.setText("2. Masukan Pekerjaan Ayah Anda");

        jLabel3.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        jLabel3.setText("3. Masukan Nama Ibu Kandung Anda");

        jLabel4.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        jLabel4.setText("4. Masukan Pekerjaan Ibu Anda");

        jLabel5.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        jLabel5.setText("5 . Masukan Nama Sekolah Anda Sebelumnya");

        jLabel6.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        jLabel6.setText("6. Masukan Nomor Ijazah Anda ");

        jLabel7.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        jLabel7.setText("7. Masukan Tahun Lulus Anda");

        tahunLulusTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tahunLulusTxtKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tahunLulusTxtKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        jLabel8.setText("8. Apakah Anda Mengikuti Eskul Di Sekolah Sebelumnya ");

        isEskulYes.setBackground(new java.awt.Color(255, 255, 255));
        bgIsEskul.add(isEskulYes);
        isEskulYes.setText("Ya");
        isEskulYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isEskulYesActionPerformed(evt);
            }
        });

        isEskulNo.setBackground(new java.awt.Color(255, 255, 255));
        bgIsEskul.add(isEskulNo);
        isEskulNo.setText("Tidak");
        isEskulNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isEskulNoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        jLabel9.setText("9. Pilih Eskul Yang Ingin Anda Ikuti");

        comboEskul.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        jLabel10.setText("10. Pilih Jurusan Yang Ingin Anda Inginkan");

        comboJurusan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namaAyahTxt)
                            .addComponent(pekerjaanAyahTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(namaIbuTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(pekerjaanIbuTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(namaSekolahAsalTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(nomorIjazahTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(tahunLulusTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(isEskulYes)
                                .addGap(18, 18, 18)
                                .addComponent(isEskulNo)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(comboEskul, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboJurusan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(namaAyahTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pekerjaanAyahTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(namaIbuTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pekerjaanIbuTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(namaSekolahAsalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(nomorIjazahTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tahunLulusTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(isEskulYes)
                    .addComponent(isEskulNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(comboEskul, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(comboJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnUpdate))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        cardLayout.add(jPanel1);

        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel7.setPreferredSize(new java.awt.Dimension(100, 421));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 99, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
        );

        cardLayout.add(jPanel7);

        add(cardLayout, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void isEskulYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isEskulYesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isEskulYesActionPerformed

    private void isEskulNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isEskulNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isEskulNoActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String namaAyah = namaAyahTxt.getText();
        String pekerjaanAyah = pekerjaanAyahTxt.getText();
        String namaIbu = namaIbuTxt.getText();
        String pekerjaanIbu = pekerjaanIbuTxt.getText();
        String namaSekolah = namaSekolahAsalTxt.getText();
        String nomorIjazah = nomorIjazahTxt.getText();
        
        int tahunLulus = 0;
        if(tahunLulusTxt.getText().length() > 0){
           tahunLulus = Integer.valueOf(tahunLulusTxt.getText());
        }
        String noPendaftaran = sdf.format(new Date());
        int isEskul = 0;
        if(isEskulYes.isSelected()){
            isEskul = 1;
        }else{
            isEskul = 0;
        }
        
        int idEskul = 0;
        if(comboEskul.getSelectedIndex() > 0){
            idEskul = getEskul(comboEskul.getSelectedItem().toString());
        }
        
        int idJurusan = 0;
        if(comboJurusan.getSelectedIndex() > 0){
            idJurusan = getJurusan(comboJurusan.getSelectedItem().toString());
        }
        
        String sql = "INSERT INTO pendaftaran (no_ijazah, id_jurusan, nama_ayah, pekerjaan_ayah, nama_ibu, pekerjaan_ibu, sekolah_asal, tahun_lulus, status, id_siswa, no_pendaftaran, is_eskul, eskul_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, nomorIjazah);
                stat.setInt(2, idJurusan);
                stat.setString(3, namaAyah);
                stat.setString(4, pekerjaanAyah);
                stat.setString(5, namaIbu);
                stat.setString(6, pekerjaanIbu);
                stat.setString(7, namaSekolah);
                stat.setInt(8, tahunLulus);
                stat.setString(9, "Baru");
                stat.setInt(10, IdSiswa);
                stat.setString(11, noPendaftaran);
                stat.setInt(12, isEskul);
                stat.setInt(13, idEskul);
               
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan: " + e.getMessage());
            }
        
        
        
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tahunLulusTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tahunLulusTxtKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tahunLulusTxtKeyPressed

    private void tahunLulusTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tahunLulusTxtKeyTyped
        // TODO add your handling code here:
        int length = tahunLulusTxt.getText().length();
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter)) || length >= 4){
            evt.consume();
        }
    }//GEN-LAST:event_tahunLulusTxtKeyTyped

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        
        String namaAyah = namaAyahTxt.getText();
        String pekerjaanAyah = pekerjaanAyahTxt.getText();
        String namaIbu = namaIbuTxt.getText();
        String pekerjaanIbu = pekerjaanIbuTxt.getText();
        String namaSekolah = namaSekolahAsalTxt.getText();
        String nomorIjazah = nomorIjazahTxt.getText();
        
        int tahunLulus = 0;
        if(tahunLulusTxt.getText().length() > 0){
           tahunLulus = Integer.valueOf(tahunLulusTxt.getText());
        }
        String noPendaftaran = sdf.format(new Date());
        int isEskul = 0;
        if(isEskulYes.isSelected()){
            isEskul = 1;
        }else{
            isEskul = 0;
        }
        
        int idEskul = 0;
        if(comboEskul.getSelectedIndex() > 0){
            idEskul = getEskul(comboEskul.getSelectedItem().toString());
        }
        
        int idJurusan = 0;
        if(comboJurusan.getSelectedIndex() > 0){
            idJurusan = getJurusan(comboJurusan.getSelectedItem().toString());
        }
        String sql = "UPDATE pendaftaran SET no_ijazah=?, id_jurusan=?, nama_ayah=?, pekerjaan_ayah=?, nama_ibu=?, pekerjaan_ibu=?, sekolah_asal=?, tahun_lulus=?, status=?, is_eskul=?, eskul_id=? WHERE id_pendaftaran=?";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, nomorIjazah);
                stat.setInt(2, idJurusan);
                stat.setString(3, namaAyah);
                stat.setString(4, pekerjaanAyah);
                stat.setString(5, namaIbu);
                stat.setString(6, pekerjaanIbu);
                stat.setString(7, namaSekolah);
                stat.setInt(8, tahunLulus);
                stat.setString(9, "Baru");
                stat.setInt(10, isEskul);
                stat.setInt(11, idEskul);
                stat.setInt(12, idPendaftaran);
               
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan: " + e.getMessage());
            }
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgIsEskul;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel cardLayout;
    private javax.swing.JComboBox<String> comboEskul;
    private javax.swing.JComboBox<String> comboJurusan;
    private javax.swing.JRadioButton isEskulNo;
    private javax.swing.JRadioButton isEskulYes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField namaAyahTxt;
    private javax.swing.JTextField namaIbuTxt;
    private javax.swing.JTextField namaSekolahAsalTxt;
    private javax.swing.JTextField nomorIjazahTxt;
    private javax.swing.JTextField pekerjaanAyahTxt;
    private javax.swing.JTextField pekerjaanIbuTxt;
    private javax.swing.JTextField tahunLulusTxt;
    // End of variables declaration//GEN-END:variables
}
