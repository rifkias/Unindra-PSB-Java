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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;

/**
 *
 * @author lincbp
 */
public class MasterPendaftaran extends javax.swing.JPanel {
    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    private int selectedId;
    private int selectedIdTagihan;
    private int loginId;
    private String prevPage;
    private String selectedStatus;
    /**
     * Creates new form MasterPendaftaran
     */
    public MasterPendaftaran(int loginId) {
        initComponents();
        this.loginId = loginId;
        
        initTable();
        
        this.btnDetail.setVisible(false);
        this.btnTerimaPendaftaran.setVisible(false);
        this.btnTagihan.setVisible(false);
        this.btnTerimaPembayaran.setVisible(false);
        this.btnTolakPembayaran.setVisible(false);
        this.btnTolakPendaftaran.setVisible(false);
        this.btnKembalikan.setVisible(false);
    }
    
    public void initTable(){
        Object[] Baris={"Id","Nama Siswa","NISN","No Pendaftaran","Nama Jurusan","Pilihan Eskul","Status","Nilai Rata - Rata",};
        tabmode = new DefaultTableModel(null, Baris);
        dataTable.setModel(tabmode);   
        
        String sql = "SELECT \n" +
            "	j.nama_jurusan, \n" +
            "	e.nama_esktrakulikuler, \n" +
            "	s.nama AS nama_siswa,\n" +
            "	s.nisn AS nisn,\n" +
            "	p.id_pendaftaran,\n" +
            "	p.no_pendaftaran, \n" +
            "	p.status,\n" +
            "	COUNT(n.id_nilai) AS jumlah_nilai,\n" +
            "	SUM(n.nilai) AS total_nilai,\n" +
            "	(SUM(n.nilai)/COUNT(n.id_nilai)) AS rataRata\n" +
            "	\n" +
            "FROM pendaftaran p \n" +
            "LEFT JOIN jurusan j \n" +
            "	ON p.id_jurusan = j.id_jurusan \n" +
            "LEFT JOIN ekstrakulikuler e \n" +
            "	ON p.eskul_id = e.id_ekstrakulikuler\n" +
            "LEFT JOIN siswa s \n" +
            "	ON p.id_siswa = s.id_siswa\n" +
            "LEFT JOIN nilai n \n" +
            "	ON p.id_pendaftaran = n.id_pendaftaran\n" +
            "GROUP BY j.nama_jurusan,e.nama_esktrakulikuler,s.nama,s.nisn,p.id_pendaftaran";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                int a = hasil.getInt("id_pendaftaran");
                String b = hasil.getString("nama_siswa");
                String c = hasil.getString("nisn");
                String d = hasil.getString("no_pendaftaran");
                String e = hasil.getString("nama_jurusan");
                String f = hasil.getString("nama_esktrakulikuler");
                String g = hasil.getString("status");
                String h = hasil.getString("rataRata");

                Object[] data={a,b,c,d,e,f,g,h};
                tabmode.addRow(data);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void moveToTable(){
        cardLayout.removeAll();
        cardLayout.repaint();
        cardLayout.revalidate();
        
        cardLayout.add(panelTable);
        cardLayout.repaint();
        cardLayout.revalidate();
    }
    
    public void moveToForm(){
        cardLayout.removeAll();
        cardLayout.repaint();
        cardLayout.revalidate();
        
        cardLayout.add(panelForm);
        cardLayout.repaint();
        cardLayout.revalidate();
    }
    
    public void moveToTableTagihan(){
        cardLayout.removeAll();
        cardLayout.repaint();
        cardLayout.revalidate();
        
        cardLayout.add(panelTagihan);
        cardLayout.repaint();
        cardLayout.revalidate();
        
        this.resetTagihan();
    }
    
    public void moveToFormTagihan(){
        cardLayout.removeAll();
        cardLayout.repaint();
        cardLayout.revalidate();
        
        cardLayout.add(panelFormTagihan);
        cardLayout.repaint();
        cardLayout.revalidate();
    }
    
    public void reset(){
        noPendaftaranTxt.setText("");
        noIjazahTxt.setText("");
        namaAyahTxt.setText("");
        pekerjaanAyahTxt.setText("");
        namaIbuTxt.setText("");
        pekerjaanIbuTxt.setText("");
        sekolahAsalTxt.setText("");
        tahunLulusTxt.setText("");
        jurusanTxt.setText("");
        ckbIsEskul.setSelected(false);
        eskulTxt.setText("");
        
        namaSiswaTxt.setText("");
        jenisKelaminTxt.setText("");
        agamaTxt.setText("");
        golDarTxt.setText("");
        tempatLahirTxt.setText("");
        tanggalLahirTxt.setText("");
        nisnTxt.setText("");
        noTelpTxt.setText("");
        emailTxt.setText("");
        
        this.btnDetail.setVisible(false);
        this.btnTerimaPendaftaran.setVisible(false);
        this.btnTagihan.setVisible(false);
        this.btnTagihanForm.setVisible(false);
        this.btnTerimaPendaftaranForm.setVisible(false);
        this.btnTerimaPembayaran.setVisible(false);
        this.btnTolakPembayaran.setVisible(false);
        this.btnTolakPendaftaran.setVisible(false);
        
        
        this.nilaiRata.setText("");
        
        this.selectedId = 0;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardLayout = new javax.swing.JPanel();
        panelTable = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        btnDetail = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        searchTxt = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        btnTerimaPendaftaran = new javax.swing.JButton();
        btnTagihan = new javax.swing.JButton();
        btnTerimaPembayaran = new javax.swing.JButton();
        btnTolakPendaftaran = new javax.swing.JButton();
        btnTolakPembayaran = new javax.swing.JButton();
        btnKembalikan = new javax.swing.JButton();
        panelForm = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        boxPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        namaAyahTxt = new javax.swing.JTextField();
        pekerjaanAyahTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        namaIbuTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        pekerjaanIbuTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        noIjazahTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        sekolahAsalTxt = new javax.swing.JTextField();
        tahunLulusTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        eskulTxt = new javax.swing.JTextField();
        ckbIsEskul = new javax.swing.JCheckBox();
        jurusanTxt = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        noPendaftaranTxt = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jenisKelaminTxt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        agamaTxt = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        golDarTxt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tempatLahirTxt = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        nisnTxt = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        noTelpTxt = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        tanggalLahirTxt = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        namaSiswaTxt = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTableNilai = new javax.swing.JTable();
        nilaiRata = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnTerimaPendaftaranForm = new javax.swing.JButton();
        btnTagihanForm = new javax.swing.JButton();
        panelTagihan = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        btnTagihanTambah = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        dataTableTagihan = new javax.swing.JTable();
        btnTagihanHapus = new javax.swing.JButton();
        btnTagihanKirimData = new javax.swing.JButton();
        btnTagihanKembali = new javax.swing.JButton();
        tagihanView = new javax.swing.JLabel();
        dibayarView = new javax.swing.JLabel();
        panelFormTagihan = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        tagihanNamaTxt = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        biayaTagihanTxt = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        btnSaveTagihan = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        cardLayout.setLayout(new java.awt.CardLayout());

        panelTable.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Source Sans Pro", 0, 24)); // NOI18N
        jLabel2.setText("Data Pendaftaran");

        jScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane.setEnabled(false);

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
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
        dataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataTableMouseClicked(evt);
            }
        });
        jScrollPane.setViewportView(dataTable);

        btnDetail.setText("Detail");
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });

        jLabel1.setText("Cari");

        jButton3.setText("Cari");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnTerimaPendaftaran.setText("Terima Pendaftaran");
        btnTerimaPendaftaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerimaPendaftaranActionPerformed(evt);
            }
        });

        btnTagihan.setText("Tagihan");
        btnTagihan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTagihanActionPerformed(evt);
            }
        });

        btnTerimaPembayaran.setText("Terima Pembayaran");
        btnTerimaPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerimaPembayaranActionPerformed(evt);
            }
        });

        btnTolakPendaftaran.setText("Tolak Pendaftaran");
        btnTolakPendaftaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTolakPendaftaranActionPerformed(evt);
            }
        });

        btnTolakPembayaran.setText("Tolak Pembayaran");
        btnTolakPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTolakPembayaranActionPerformed(evt);
            }
        });

        btnKembalikan.setText("Kembalikan Pendaftaran");
        btnKembalikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembalikanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTableLayout = new javax.swing.GroupLayout(panelTable);
        panelTable.setLayout(panelTableLayout);
        panelTableLayout.setHorizontalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane)
                    .addGroup(panelTableLayout.createSequentialGroup()
                        .addGroup(panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(panelTableLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3))
                            .addGroup(panelTableLayout.createSequentialGroup()
                                .addComponent(btnDetail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTerimaPendaftaran)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTagihan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTerimaPembayaran)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTolakPendaftaran)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTolakPembayaran)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnKembalikan)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelTableLayout.setVerticalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetail)
                    .addComponent(btnTerimaPendaftaran)
                    .addComponent(btnTagihan)
                    .addComponent(btnTerimaPembayaran)
                    .addComponent(btnTolakPendaftaran)
                    .addComponent(btnTolakPembayaran)
                    .addComponent(btnKembalikan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                .addGap(137, 137, 137))
        );

        cardLayout.add(panelTable, "card2");

        panelForm.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Detail Pendaftaran");

        boxPanel.setBackground(new java.awt.Color(255, 255, 255));
        boxPanel.setLayout(new javax.swing.BoxLayout(boxPanel, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 395));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Data Pendaftaran");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nama Ayah");

        namaAyahTxt.setEditable(false);

        pekerjaanAyahTxt.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Pekerjaan Ayah");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Nama Ibu");

        namaIbuTxt.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Pekerjaan Ibu");

        pekerjaanIbuTxt.setEditable(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("No Ijazah");

        noIjazahTxt.setEditable(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Sekolah Asal");

        sekolahAsalTxt.setEditable(false);

        tahunLulusTxt.setEditable(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Tahun Lulus");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Jurusan");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Eskul");

        eskulTxt.setEditable(false);

        ckbIsEskul.setEnabled(false);
        ckbIsEskul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbIsEskulActionPerformed(evt);
            }
        });

        jurusanTxt.setEditable(false);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("No Pendaftaran");

        noPendaftaranTxt.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(pekerjaanAyahTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(43, 43, 43)
                        .addComponent(namaAyahTxt))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(56, 56, 56)
                        .addComponent(noIjazahTxt))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(54, 54, 54)
                        .addComponent(namaIbuTxt))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(29, 29, 29)
                        .addComponent(pekerjaanIbuTxt))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(39, 39, 39)
                        .addComponent(sekolahAsalTxt))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eskulTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tahunLulusTxt)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(65, 65, 65)
                        .addComponent(jurusanTxt))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(18, 18, 18)
                        .addComponent(noPendaftaranTxt))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ckbIsEskul)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(noPendaftaranTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(noIjazahTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(namaAyahTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(pekerjaanAyahTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(namaIbuTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(pekerjaanIbuTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(sekolahAsalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tahunLulusTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jurusanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(eskulTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ckbIsEskul))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        boxPanel.add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 395));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Detail Siswa");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Jenis Kelamin");

        jenisKelaminTxt.setEditable(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Agama");

        agamaTxt.setEditable(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Golongan Darah");

        golDarTxt.setEditable(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Tempat Lahir");

        tempatLahirTxt.setEditable(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("NISN");

        nisnTxt.setEditable(false);
        nisnTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nisnTxtActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("No Telpon");

        noTelpTxt.setEditable(false);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Tanggal Lahir");

        tanggalLahirTxt.setEditable(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Email");

        emailTxt.setEditable(false);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Nama Siswa");

        namaSiswaTxt.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel18)
                    .addComponent(jLabel21)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailTxt)
                    .addComponent(noTelpTxt)
                    .addComponent(nisnTxt)
                    .addComponent(tanggalLahirTxt)
                    .addComponent(tempatLahirTxt)
                    .addComponent(jenisKelaminTxt)
                    .addComponent(agamaTxt)
                    .addComponent(golDarTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(namaSiswaTxt))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(namaSiswaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jenisKelaminTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(agamaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(golDarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(tempatLahirTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(tanggalLahirTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(nisnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(noTelpTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        boxPanel.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("Data Nilai");

        dataTableNilai.setModel(new javax.swing.table.DefaultTableModel(
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
        dataTableNilai.setEnabled(false);
        jScrollPane1.setViewportView(dataTableNilai);

        nilaiRata.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nilaiRata.setText("rata-rata");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nilaiRata))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(nilaiRata))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnTerimaPendaftaranForm.setText("Terima Pendaftaran");
        btnTerimaPendaftaranForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerimaPendaftaranFormActionPerformed(evt);
            }
        });

        btnTagihanForm.setText("Data Tagihan");
        btnTagihanForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTagihanFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFormLayout = new javax.swing.GroupLayout(panelForm);
        panelForm.setLayout(panelFormLayout);
        panelFormLayout.setHorizontalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boxPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTagihanForm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTerimaPendaftaranForm))
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelFormLayout.setVerticalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boxPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnTerimaPendaftaranForm)
                    .addComponent(btnTagihanForm))
                .addContainerGap(146, Short.MAX_VALUE))
        );

        cardLayout.add(panelForm, "card3");

        jLabel27.setFont(new java.awt.Font("Source Sans Pro", 0, 24)); // NOI18N
        jLabel27.setText("Tagihan Siswa");

        btnTagihanTambah.setText("Tambah");
        btnTagihanTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTagihanTambahActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        dataTableTagihan.setModel(new javax.swing.table.DefaultTableModel(
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
        dataTableTagihan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataTableTagihanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(dataTableTagihan);

        btnTagihanHapus.setText("Hapus");
        btnTagihanHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTagihanHapusActionPerformed(evt);
            }
        });

        btnTagihanKirimData.setText("Kirim Data");
        btnTagihanKirimData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTagihanKirimDataActionPerformed(evt);
            }
        });

        btnTagihanKembali.setText("Kembali");
        btnTagihanKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTagihanKembaliActionPerformed(evt);
            }
        });

        tagihanView.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tagihanView.setText("jLabel1");

        dibayarView.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dibayarView.setText("jLabel1");

        javax.swing.GroupLayout panelTagihanLayout = new javax.swing.GroupLayout(panelTagihan);
        panelTagihan.setLayout(panelTagihanLayout);
        panelTagihanLayout.setHorizontalGroup(
            panelTagihanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTagihanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTagihanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                    .addGroup(panelTagihanLayout.createSequentialGroup()
                        .addComponent(btnTagihanKembali)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTagihanTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTagihanHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTagihanKirimData)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTagihanLayout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelTagihanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tagihanView, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                            .addComponent(dibayarView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelTagihanLayout.setVerticalGroup(
            panelTagihanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTagihanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTagihanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(tagihanView))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dibayarView)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTagihanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTagihanTambah)
                    .addComponent(btnTagihanHapus)
                    .addComponent(btnTagihanKirimData)
                    .addComponent(btnTagihanKembali))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addGap(251, 251, 251))
        );

        cardLayout.add(panelTagihan, "card4");

        jLabel28.setFont(new java.awt.Font("Source Sans Pro", 0, 24)); // NOI18N
        jLabel28.setText("Data Tagihan Siswa");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Nama Tagihan");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Total Biaya");

        biayaTagihanTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                biayaTagihanTxtKeyTyped(evt);
            }
        });

        jButton5.setText("Kembali");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnSaveTagihan.setText("Simpan");
        btnSaveTagihan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveTagihanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFormTagihanLayout = new javax.swing.GroupLayout(panelFormTagihan);
        panelFormTagihan.setLayout(panelFormTagihanLayout);
        panelFormTagihanLayout.setHorizontalGroup(
            panelFormTagihanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormTagihanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormTagihanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormTagihanLayout.createSequentialGroup()
                        .addGroup(panelFormTagihanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31))
                        .addGap(18, 18, 18)
                        .addGroup(panelFormTagihanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(biayaTagihanTxt)
                            .addComponent(tagihanNamaTxt)))
                    .addGroup(panelFormTagihanLayout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(0, 460, Short.MAX_VALUE))
                    .addGroup(panelFormTagihanLayout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSaveTagihan)))
                .addContainerGap())
        );
        panelFormTagihanLayout.setVerticalGroup(
            panelFormTagihanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormTagihanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormTagihanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(tagihanNamaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormTagihanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(biayaTagihanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormTagihanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(btnSaveTagihan))
                .addContainerGap(584, Short.MAX_VALUE))
        );

        cardLayout.add(panelFormTagihan, "card5");

        add(cardLayout, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void dataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataTableMouseClicked
        // TODO add your handling code here:
        int row = dataTable.getSelectedRow();

        if(row != -1){

            if(selectedId > 0 && selectedId == Integer.valueOf(dataTable.getValueAt(row, 0).toString())){
                this.reset();
            }else{
                this.reset();
                int selectedId = Integer.valueOf(dataTable.getValueAt(row, 0).toString());
                this.selectedId = selectedId;
                String status = dataTable.getValueAt(row, 6).toString();
                selectedStatus = status;
                btnDetail.setVisible(true);
                
                if(!status.equals("Baru") && !status.equals("Ditolak")){
                    btnTagihan.setVisible(true);
                }
                
                if(status.equals("Dikirim") && this.checkTagihan() > 0){
                    btnTerimaPendaftaran.setVisible(true);
                }
                
                if(status.equals("Dikirim")){
                    btnTolakPendaftaran.setVisible(true);
                    btnKembalikan.setVisible(true);
                }
                
                if(status.equals("Validasi Pembayaran")){
                    btnTerimaPembayaran.setVisible(true);
                    btnTolakPembayaran.setVisible(true);
                }
                
                
            }
        }
    }//GEN-LAST:event_dataTableMouseClicked

    public void tolakPendaftaran(){
        int res = JOptionPane.showConfirmDialog(null, "Apakah Anda Sudah Yakin ?","Warning",JOptionPane.YES_NO_OPTION);
        
            if(res == JOptionPane.YES_OPTION){
                String sql = "UPDATE PENDAFTARAN SET status = 'Ditolak' WHERE id_pendaftaran = ?";
                try {
                    PreparedStatement stat = conn.prepareStatement(sql);
                    stat.setInt(1, selectedId);

                    int rowsAffected = stat.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
                        initTable();
                        moveToTable();
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Data Gagal Dihapus: " + e.getMessage());
                }
            }
    }
    
    public void getDetailPendaftaran(int id){
        try{
             String sql = "SELECT  p.*,e.nama_esktrakulikuler AS nama_eskul, j.nama_jurusan AS nama_jurusan FROM pendaftaran p LEFT JOIN jurusan j ON j.id_jurusan = p.id_jurusan LEFT JOIN ekstrakulikuler e ON e.id_ekstrakulikuler = p.eskul_id WHERE id_pendaftaran = '"+ id +"' limit 1";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            ResultSet rs = stat.executeQuery(sql);
            if(rs.next()){
                String status = rs.getString("status");
                selectedStatus = status;
                if(!status.equals("Baru")){
                    btnTagihanForm.setVisible(true);
                }
                
                if(status.equals("Dikirim")){
                    btnTerimaPendaftaranForm.setVisible(true);
                }
                
                namaAyahTxt.setText(rs.getString("nama_ayah"));
                pekerjaanAyahTxt.setText(rs.getString("pekerjaan_ayah"));
                namaIbuTxt.setText(rs.getString("nama_ibu"));
                pekerjaanIbuTxt.setText(rs.getString("pekerjaan_ibu"));
                sekolahAsalTxt.setText(rs.getString("sekolah_asal"));
                tahunLulusTxt.setText(rs.getString("tahun_lulus"));
                eskulTxt.setText(rs.getString("nama_eskul"));
                jurusanTxt.setText(rs.getString("nama_jurusan"));
                noIjazahTxt.setText(rs.getString("no_ijazah"));
                noPendaftaranTxt.setText(rs.getString("no_pendaftaran"));
                
                int isEskul = rs.getInt("is_eskul");
                
                if(isEskul > 0){
                    ckbIsEskul.setSelected(true);
                }else{
                    ckbIsEskul.setSelected(false);
                }
                
                this.getDetailSiswa(rs.getInt("id_siswa"));
                this.initNilai(id);
                
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void initNilai(int id){
        Object[] Baris={"Id","Nama Mata Pelajaran","Nilai"};
        tabmode = new DefaultTableModel(null, Baris);
        dataTableNilai.setModel(tabmode);
        int nilaiRataRata = 0;
        int totalNilai = 0;
        
        String sql = "select * from nilai where id_pendaftaran = '"+id+"'";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                int a = hasil.getInt("id_nilai");
                String b = hasil.getString("nama_jenis");
                String c = hasil.getString("nilai");
                
                nilaiRataRata += hasil.getInt("nilai");
                totalNilai++;
                
                Object[] data={a,b,c};
                tabmode.addRow(data);
            }
            
            Double nilaiView = Double.valueOf(nilaiRataRata/totalNilai);
            nilaiRata.setText("Nilai Rata - Rata : "+nilaiView.toString());
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void initTagihan(){
        Object[] Baris={"Id","Nama Tagihan","Biaya","DiBayar"};
        tabmode = new DefaultTableModel(null, Baris);
        dataTableTagihan.setModel(tabmode);
        int totalTagihan = 0;
        int totalDibayar = 0;
        int totalRow = 0;
        String sql = "select * from tagihan where id_pendaftaran = '"+selectedId+"'";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                int a = hasil.getInt("id_tagihan");
                String b = hasil.getString("nama_tagihan");
                String c = hasil.getString("biaya");
                String d = hasil.getString("dibayar");
                
                totalTagihan += hasil.getDouble("biaya");
                totalDibayar += hasil.getDouble("dibayar");
                totalRow++;
                Object[] data={a,b,c,d};
                tabmode.addRow(data);
            }
            
            if(totalRow>0 && selectedStatus.equals("Dikirim")){
                this.btnTagihanKirimData.setVisible(true);
            }else{
                btnTagihanKirimData.setVisible(false);
                btnTagihanHapus.setVisible(false);
            }
            
            this.dibayarView.setText("Total Dibayar : "+String.valueOf(totalDibayar));
            this.tagihanView.setText("Total Tagihan : "+String.valueOf(totalTagihan));
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void getDetailSiswa(int id){
        try{
            String sql = "SELECT * FROM siswa WHERE id_siswa ='"+id+"'";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            ResultSet rs = stat.executeQuery(sql);
            
            if(rs.next()){
                namaSiswaTxt.setText(rs.getString("nama"));
                jenisKelaminTxt.setText(rs.getString("jenis_kelamin"));
                agamaTxt.setText(rs.getString("agama"));
                golDarTxt.setText(rs.getString("golongan_darah"));
                tempatLahirTxt.setText(rs.getString("tempat_lahir"));
                tanggalLahirTxt.setText(rs.getString("tanggal_lahir"));
                nisnTxt.setText(rs.getString("nisn"));
                emailTxt.setText(rs.getString("email"));
                noTelpTxt.setText(rs.getString("nomor_telpon"));
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        // TODO add your handling code here:
        
        if(this.selectedId == 0){
            JOptionPane.showMessageDialog(null, "Something Wrong !!!");
            System.out.println("Empty Selected Id '"+this.selectedId+"'");
        }else{
            this.prevPage = "MainTable";
            this.getDetailPendaftaran(this.selectedId);
            this.moveToForm();
        }
//        btnFormUpdate.setVisible(false);
//        btnFormSave.setVisible(true);
//        this.reset();
    }//GEN-LAST:event_btnDetailActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String search = "'%"+searchTxt.getText()+"%'";

        Object[] Baris={"Id","Nama Siswa","NISN","No Pendaftaran","Nama Jurusan","Pilihan Eskul","Status","Nilai Rata - Rata",};
        tabmode = new DefaultTableModel(null, Baris);
        dataTable.setModel(tabmode);   
        
        String sql = "SELECT \n" +
            "	j.nama_jurusan, \n" +
            "	e.nama_esktrakulikuler, \n" +
            "	s.nama AS nama_siswa,\n" +
            "	s.nisn AS nisn,\n" +
            "	p.id_pendaftaran,\n" +
            "	p.no_pendaftaran, \n" +
            "	p.status,\n" +
            "	COUNT(n.id_nilai) AS jumlah_nilai,\n" +
            "	SUM(n.nilai) AS total_nilai,\n" +
            "	(SUM(n.nilai)/COUNT(n.id_nilai)) AS rataRata\n" +
            "	\n" +
            "FROM pendaftaran p \n" +
            "LEFT JOIN jurusan j \n" +
            "	ON p.id_jurusan = j.id_jurusan \n" +
            "LEFT JOIN ekstrakulikuler e \n" +
            "	ON p.eskul_id = e.id_ekstrakulikuler\n" +
            "LEFT JOIN siswa s \n" +
            "	ON p.id_siswa = s.id_siswa\n" +
            "LEFT JOIN nilai n \n" +
            "	ON p.id_pendaftaran = n.id_pendaftaran\n" +
            " WHERE p.no_pendaftaran LIKE "+search+" OR s.nama LIKE "+search+
            "GROUP BY j.nama_jurusan,e.nama_esktrakulikuler,s.nama,s.nisn,p.id_pendaftaran";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                int a = hasil.getInt("id_pendaftaran");
                String b = hasil.getString("nama_siswa");
                String c = hasil.getString("nisn");
                String d = hasil.getString("no_pendaftaran");
                String e = hasil.getString("nama_jurusan");
                String f = hasil.getString("nama_esktrakulikuler");
                String g = hasil.getString("status");
                String h = hasil.getString("rataRata");

                Object[] data={a,b,c,d,e,f,g,h};
                tabmode.addRow(data);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void ckbIsEskulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbIsEskulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckbIsEskulActionPerformed

    private void nisnTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nisnTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nisnTxtActionPerformed

    private void btnTerimaPendaftaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerimaPendaftaranActionPerformed
        // TODO add your handling code here:
        this.sendTagihan();
    }//GEN-LAST:event_btnTerimaPendaftaranActionPerformed

    private void btnTagihanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTagihanActionPerformed
        // TODO add your handling code here:
        this.prevPage = "MainTable";
        this.moveToTableTagihan();
        this.initTagihan();
    }//GEN-LAST:event_btnTagihanActionPerformed

    private void btnTagihanTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTagihanTambahActionPerformed
        // TODO add your handling code here:
        this.moveToFormTagihan();
    }//GEN-LAST:event_btnTagihanTambahActionPerformed

    private void dataTableTagihanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataTableTagihanMouseClicked
        // TODO add your handling code here:
        int row = dataTableTagihan.getSelectedRow();

        if(row != -1){

            if(selectedIdTagihan > 0 && selectedIdTagihan == Integer.valueOf(dataTableTagihan.getValueAt(row, 0).toString())){
                this.resetTagihan();
            }else{
                this.resetTagihan();
                int selectedId = Integer.valueOf(dataTableTagihan.getValueAt(row, 0).toString());
                this.selectedIdTagihan = selectedId;
                
                if(selectedStatus.equals("Dikirim")){
                    this.btnTagihanHapus.setVisible(true);
                }

                
                
            }
        }
    }//GEN-LAST:event_dataTableTagihanMouseClicked

    private void btnTagihanHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTagihanHapusActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showConfirmDialog(null, "Yakin pengen di hapus ?","Warning",JOptionPane.YES_NO_OPTION);
        
        if(res == JOptionPane.YES_OPTION){            
           String sql = "DELETE FROM tagihan WHERE id_tagihan = ?";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setInt(1, selectedIdTagihan);

                int rowsAffected = stat.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                    initTagihan();
                    resetTagihan();
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus: " + e.getMessage());
            }
        }
        
    }//GEN-LAST:event_btnTagihanHapusActionPerformed

    private void btnTagihanKirimDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTagihanKirimDataActionPerformed
        // TODO add your handling code here:
        this.sendTagihan();
    }//GEN-LAST:event_btnTagihanKirimDataActionPerformed

    private void btnTagihanKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTagihanKembaliActionPerformed
        // TODO add your handling code here:
        if(!this.prevPage.equals("")){
            if(this.prevPage.equals("DetailForm")){
                this.moveToForm();
            }else if(this.prevPage.equals("MainTable")){
                this.moveToTable();                
            }else{
                this.moveToTable();
            }
        }else{
            this.moveToTable();
        }
    }//GEN-LAST:event_btnTagihanKembaliActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.moveToTableTagihan();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.moveToTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnTagihanFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTagihanFormActionPerformed
        // TODO add your handling code here:
        this.initTagihan();
        this.moveToTableTagihan();
        this.prevPage = "DetailForm";
    }//GEN-LAST:event_btnTagihanFormActionPerformed

    private void btnSaveTagihanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveTagihanActionPerformed
        // TODO add your handling code here:
        String valid = this.validateMessage();
        
        if(valid.equals("Success")){
            try{
                String sql = "INSERT INTO tagihan (nama_tagihan, biaya, id_pendaftaran) VALUES (?,?,?)";
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, tagihanNamaTxt.getText());
                stat.setString(2, biayaTagihanTxt.getText());
                stat.setInt(3, selectedId);

                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                this.moveToTableTagihan();
                this.resetTagihan();
                this.initTagihan();
                
            }catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnSaveTagihanActionPerformed

    private void biayaTagihanTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_biayaTagihanTxtKeyTyped
        // TODO add your handling code here:
                char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();
        }
    }//GEN-LAST:event_biayaTagihanTxtKeyTyped

    private void btnTerimaPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerimaPembayaranActionPerformed
        // TODO add your handling code here:
        this.terimaPembayaran();
    }//GEN-LAST:event_btnTerimaPembayaranActionPerformed

    private void btnTolakPendaftaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTolakPendaftaranActionPerformed
        // TODO add your handling code here:
        this.tolakPendaftaran();
    }//GEN-LAST:event_btnTolakPendaftaranActionPerformed

    private void btnTolakPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTolakPembayaranActionPerformed
        // TODO add your handling code here:
        this.tolakPembayaran();
    }//GEN-LAST:event_btnTolakPembayaranActionPerformed

    private void btnTerimaPendaftaranFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerimaPendaftaranFormActionPerformed
        // TODO add your handling code here:
        this.sendTagihan();
    }//GEN-LAST:event_btnTerimaPendaftaranFormActionPerformed

    private void btnKembalikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembalikanActionPerformed
        // TODO add your handling code here:
         int res = JOptionPane.showConfirmDialog(null, "Apakah Anda Sudah Yakin ?","Warning",JOptionPane.YES_NO_OPTION);
        
            if(res == JOptionPane.YES_OPTION){
                String sql = "UPDATE PENDAFTARAN SET status = 'Baru' WHERE id_pendaftaran = ?";
                try {
                    PreparedStatement stat = conn.prepareStatement(sql);
                    stat.setInt(1, selectedId);

                    int rowsAffected = stat.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
                        initTable();
                        moveToTable();
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Data Gagal Dihapus: " + e.getMessage());
                }
            }
    }//GEN-LAST:event_btnKembalikanActionPerformed

    
    public void tolakPembayaran(){
        int res = JOptionPane.showConfirmDialog(null, "Apakah Anda Sudah Yakin ?","Warning",JOptionPane.YES_NO_OPTION);
        
            if(res == JOptionPane.YES_OPTION){
                String sql = "UPDATE PENDAFTARAN SET status = 'Diterima' WHERE id_pendaftaran = ?";
                try {
                    PreparedStatement stat = conn.prepareStatement(sql);
                    stat.setInt(1, selectedId);

                    int rowsAffected = stat.executeUpdate();

                    if (rowsAffected > 0) {
                        this.removeDibayar();
                        JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
                        initTable();
                        moveToTable();
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Data Gagal Dihapus: " + e.getMessage());
                }
            }
    }
    
    public void removeDibayar(){
        String sql = "UPDATE tagihan SET dibayar = '0' WHERE id_pendaftaran = ?";
                try {
                    PreparedStatement stat = conn.prepareStatement(sql);
                    stat.setInt(1, selectedId);

                    int rowsAffected = stat.executeUpdate();

                    if (rowsAffected > 0) {
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Data Gagal Dihapus: " + e.getMessage());
                }
    }
    
    public void resetTagihan(){
        tagihanNamaTxt.setText("");
        biayaTagihanTxt.setText("");
        
        btnTagihanHapus.setVisible(false);
        if(!selectedStatus.equals("Dikirim")){
            btnTagihanKirimData.setVisible(false);
            btnTagihanTambah.setVisible(false);
            btnTagihanHapus.setVisible(false);
        }
    }
    
    public String validateMessage(){
        String res = "Success";
        String message = "";
        if(tagihanNamaTxt.getText().equals("")){
            message += "Nama Tagihan Tidak Boleh Kosong \n";
            res = "error";
        }
        
        if(biayaTagihanTxt.getText().equals("")){
            message += "Biaya Tagihan Tidak Boleh Kosong \n";
            res = "error";
            
        }
        
        if(res.equals("error")){
            JOptionPane.showMessageDialog(null, message);
        }
        
        return res;
    }
    
    public void sendTagihan(){
        if(checkTagihan() > 0){
            int res = JOptionPane.showConfirmDialog(null, "Apakah Anda Sudah Yakin ?","Warning",JOptionPane.YES_NO_OPTION);
        
            if(res == JOptionPane.YES_OPTION){
                String sql = "UPDATE PENDAFTARAN SET status = 'Diterima' WHERE id_pendaftaran = ?";
                try {
                    PreparedStatement stat = conn.prepareStatement(sql);
                    stat.setInt(1, selectedId);

                    int rowsAffected = stat.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
                        initTable();
                        moveToTable();
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Data Gagal Dihapus: " + e.getMessage());
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Data Tagihan Kosong");
        }
        
    }
    
    public void terimaPembayaran(){
            int res = JOptionPane.showConfirmDialog(null, "Apakah Anda Sudah Yakin ?","Warning",JOptionPane.YES_NO_OPTION);
        
            if(res == JOptionPane.YES_OPTION){
                String sql = "UPDATE PENDAFTARAN SET status = 'Selesai', approval_by=? WHERE id_pendaftaran = ?";
                try {
                    PreparedStatement stat = conn.prepareStatement(sql);
                    stat.setInt(1, loginId);
                    stat.setInt(2, selectedId);

                    int rowsAffected = stat.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
                        initTable();
                        moveToTable();
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Data Gagal Dihapus: " + e.getMessage());
                }
            }
    }
    
    public int checkTagihan(){
        int res = 0;
        
        String sql = "select * from tagihan where id_pendaftaran = '"+selectedId+"'";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            if(hasil.next()){
                res++;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return res;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agamaTxt;
    private javax.swing.JTextField biayaTagihanTxt;
    private javax.swing.JPanel boxPanel;
    private javax.swing.JButton btnDetail;
    private javax.swing.JButton btnKembalikan;
    private javax.swing.JButton btnSaveTagihan;
    private javax.swing.JButton btnTagihan;
    private javax.swing.JButton btnTagihanForm;
    private javax.swing.JButton btnTagihanHapus;
    private javax.swing.JButton btnTagihanKembali;
    private javax.swing.JButton btnTagihanKirimData;
    private javax.swing.JButton btnTagihanTambah;
    private javax.swing.JButton btnTerimaPembayaran;
    private javax.swing.JButton btnTerimaPendaftaran;
    private javax.swing.JButton btnTerimaPendaftaranForm;
    private javax.swing.JButton btnTolakPembayaran;
    private javax.swing.JButton btnTolakPendaftaran;
    private javax.swing.JPanel cardLayout;
    private javax.swing.JCheckBox ckbIsEskul;
    private javax.swing.JTable dataTable;
    private javax.swing.JTable dataTableNilai;
    private javax.swing.JTable dataTableTagihan;
    private javax.swing.JLabel dibayarView;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JTextField eskulTxt;
    private javax.swing.JTextField golDarTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jenisKelaminTxt;
    private javax.swing.JTextField jurusanTxt;
    private javax.swing.JTextField namaAyahTxt;
    private javax.swing.JTextField namaIbuTxt;
    private javax.swing.JTextField namaSiswaTxt;
    private javax.swing.JLabel nilaiRata;
    private javax.swing.JTextField nisnTxt;
    private javax.swing.JTextField noIjazahTxt;
    private javax.swing.JTextField noPendaftaranTxt;
    private javax.swing.JTextField noTelpTxt;
    private javax.swing.JPanel panelForm;
    private javax.swing.JPanel panelFormTagihan;
    private javax.swing.JPanel panelTable;
    private javax.swing.JPanel panelTagihan;
    private javax.swing.JTextField pekerjaanAyahTxt;
    private javax.swing.JTextField pekerjaanIbuTxt;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JTextField sekolahAsalTxt;
    private javax.swing.JTextField tagihanNamaTxt;
    private javax.swing.JLabel tagihanView;
    private javax.swing.JTextField tahunLulusTxt;
    private javax.swing.JTextField tanggalLahirTxt;
    private javax.swing.JTextField tempatLahirTxt;
    // End of variables declaration//GEN-END:variables
}
