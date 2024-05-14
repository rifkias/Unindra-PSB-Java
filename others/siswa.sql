-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.30 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping structure for table psb_java.admin
CREATE TABLE IF NOT EXISTS `admin` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `tanggal_lahir` date DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table psb_java.admin: ~3 rows (approximately)
INSERT IGNORE INTO `admin` (`id_user`, `username`, `password`, `nama`, `alamat`, `tanggal_lahir`) VALUES
	(1, 'rifki', 'rifki', 'rifki', 'rifki', '2003-03-08'),
	(2, 'test', 'test', 'test', 'test', '2011-04-05'),
	(3, 'test22211', 'test2', 'test2323', 'teste', '2024-07-03');

-- Dumping structure for table psb_java.ekstrakulikuler
CREATE TABLE IF NOT EXISTS `ekstrakulikuler` (
  `id_ekstrakulikuler` int NOT NULL AUTO_INCREMENT,
  `nama_esktrakulikuler` varchar(255) DEFAULT NULL,
  `keterangan` text,
  PRIMARY KEY (`id_ekstrakulikuler`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table psb_java.ekstrakulikuler: ~2 rows (approximately)
INSERT IGNORE INTO `ekstrakulikuler` (`id_ekstrakulikuler`, `nama_esktrakulikuler`, `keterangan`) VALUES
	(1, 'ROHIS', 'Rohani Islam'),
	(3, 'Paskibra', 'Eskul Paskibra'),
	(5, 'Futsal', 'Eskul Futsal'),
	(6, 'Silat', 'Eskul Silat'),
	(7, 'Bulu Tangkis', 'Eskul Bulutangkis');

-- Dumping structure for table psb_java.jurusan
CREATE TABLE IF NOT EXISTS `jurusan` (
  `id_jurusan` int NOT NULL AUTO_INCREMENT,
  `nama_jurusan` varchar(255) DEFAULT NULL,
  `keterangan` text,
  PRIMARY KEY (`id_jurusan`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table psb_java.jurusan: ~2 rows (approximately)
INSERT IGNORE INTO `jurusan` (`id_jurusan`, `nama_jurusan`, `keterangan`) VALUES
	(1, 'Teknik Jaringan Komputer', 'Jurusan TKJ\n'),
	(4, 'Rekayasa Perangkat Lunak', 'Jurusan RPL'),
	(5, 'Teknik Kendaraan Ringan', 'Jurusan TKR'),
	(6, 'Audio Vidio', 'Jurusan AUV'),
	(7, 'Akutansi', 'Jurusan Akutansi'),
	(8, 'Multimedia', 'Jurusan Multi Media');

-- Dumping structure for table psb_java.nilai
CREATE TABLE IF NOT EXISTS `nilai` (
  `id_nilai` int NOT NULL AUTO_INCREMENT,
  `id_pendaftaran` int DEFAULT NULL,
  `nama_jenis` varchar(255) DEFAULT NULL,
  `nilai` int DEFAULT NULL,
  PRIMARY KEY (`id_nilai`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table psb_java.nilai: ~11 rows (approximately)
INSERT IGNORE INTO `nilai` (`id_nilai`, `id_pendaftaran`, `nama_jenis`, `nilai`) VALUES
	(1, 1, 'IPS', 80),
	(2, 1, 'IPA', 98),
	(3, 1, 'MTK', 75),
	(4, 2, 'IPA', 85),
	(5, 2, 'IPS', 90),
	(6, 2, 'Bahasa Indonesia', 88),
	(7, 2, 'Matematika', 70),
	(8, 3, 'IPA', 100),
	(9, 3, 'IPS', 95),
	(10, 3, 'MTK', 85),
	(11, 3, 'Bahasa Indonesia', 98);

-- Dumping structure for table psb_java.pendaftaran
CREATE TABLE IF NOT EXISTS `pendaftaran` (
  `id_pendaftaran` int NOT NULL AUTO_INCREMENT,
  `no_ijazah` varchar(255) DEFAULT NULL,
  `id_jurusan` int DEFAULT NULL,
  `nama_ayah` varchar(255) DEFAULT NULL,
  `pekerjaan_ayah` varchar(255) DEFAULT NULL,
  `nama_ibu` varchar(255) DEFAULT NULL,
  `pekerjaan_ibu` varchar(255) DEFAULT NULL,
  `sekolah_asal` varchar(255) DEFAULT NULL,
  `tahun_lulus` int DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `step` int DEFAULT NULL,
  `id_siswa` int DEFAULT NULL,
  `approval_by` int DEFAULT NULL,
  `no_pendaftaran` varchar(255) DEFAULT NULL,
  `is_eskul` tinyint DEFAULT NULL,
  `eskul_id` int DEFAULT NULL,
  PRIMARY KEY (`id_pendaftaran`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table psb_java.pendaftaran: ~3 rows (approximately)
INSERT IGNORE INTO `pendaftaran` (`id_pendaftaran`, `no_ijazah`, `id_jurusan`, `nama_ayah`, `pekerjaan_ayah`, `nama_ibu`, `pekerjaan_ibu`, `sekolah_asal`, `tahun_lulus`, `status`, `step`, `id_siswa`, `approval_by`, `no_pendaftaran`, `is_eskul`, `eskul_id`) VALUES
	(1, '1', 1, 'asfsaf12', 'asfas', 'afsa', 'asfas', 'asafs', 12121, 'Selesai', 1, 1, NULL, '1234', 1, 1),
	(2, 'TEST', 1, 'TEST', 'TEST', 'TEST', 'TEST', 'TEST', 1234, 'Diterima', NULL, 3, NULL, '202405019412', 1, 1),
	(3, 'TEST', 1, 'TEST', 'TEST', 'TEST', 'TEST', 'TEST', 1234, 'Selesai', NULL, 6, 1, '2024051161813', 1, 1);

-- Dumping structure for table psb_java.siswa
CREATE TABLE IF NOT EXISTS `siswa` (
  `id_siswa` int NOT NULL AUTO_INCREMENT,
  `nama` varchar(45) DEFAULT NULL,
  `jenis_kelamin` varchar(45) DEFAULT NULL,
  `agama` varchar(45) DEFAULT NULL,
  `golongan_darah` varchar(45) DEFAULT NULL,
  `tanggal_lahir` date DEFAULT NULL,
  `nisn` int DEFAULT NULL,
  `tempat_lahir` varchar(45) DEFAULT NULL,
  `nomor_telpon` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_siswa`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table psb_java.siswa: ~4 rows (approximately)
INSERT IGNORE INTO `siswa` (`id_siswa`, `nama`, `jenis_kelamin`, `agama`, `golongan_darah`, `tanggal_lahir`, `nisn`, `tempat_lahir`, `nomor_telpon`, `email`) VALUES
	(1, 'rifki', 'Laki - Laki', 'Islam', 'B', '2013-04-06', 21321132, 'jakarta', '21321132', 'afasasf@fasfs.com'),
	(3, 'rifki', 'Laki - Laki', 'islam', 'A', '2002-04-20', 12345, 'jakarta', '123456', 'afsafsaas'),
	(4, 'asfssfa22', 'Laki - Laki', 'assafasf', 'A', '2000-01-01', 123456, 'saffsa', '123456', '123456'),
	(6, 'TEST', 'Laki - Laki', 'Islam', 'A', '2002-02-02', 123451, 'JAKARTA', '123451', 'test@test.com');

-- Dumping structure for table psb_java.tagihan
CREATE TABLE IF NOT EXISTS `tagihan` (
  `id_tagihan` int NOT NULL AUTO_INCREMENT,
  `nama_tagihan` varchar(45) DEFAULT NULL,
  `biaya` double DEFAULT NULL,
  `dibayar` double DEFAULT NULL,
  `id_pendaftaran` int DEFAULT NULL,
  PRIMARY KEY (`id_tagihan`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table psb_java.tagihan: ~10 rows (approximately)
INSERT IGNORE INTO `tagihan` (`id_tagihan`, `nama_tagihan`, `biaya`, `dibayar`, `id_pendaftaran`) VALUES
	(1, 'Biaya SPP', 200000, 200000, 1),
	(5, 'Biaya SPP', 500000, 500000, 1),
	(6, 'Uang Pengembangan', 1500000, 0, 2),
	(7, 'Uang Gedung', 500000, 0, 2),
	(8, 'Uang Rokok', 250000, 0, 2),
	(9, 'Formulir Pendaftaran', 35000, 0, 2),
	(10, 'UANG PEMBANGUNAN', 250000, 250000, 3),
	(11, 'SERAGAM', 300000, 300000, 3),
	(12, 'UANG PRAKTEK', 1500000, 1500000, 3),
	(13, 'SPP', 500000, 500000, 3);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
