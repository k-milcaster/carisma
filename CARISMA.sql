-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: carisma
-- ------------------------------------------------------
-- Server version	5.6.15-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `absensidokter`
--

DROP TABLE IF EXISTS `absensidokter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `absensidokter` (
  `dokter_id_dokter` varchar(10) NOT NULL,
  `kehadiranreguler_dokter` varchar(1) NOT NULL DEFAULT '0',
  `kehadiranlembur_dokter` varchar(1) NOT NULL DEFAULT '0',
  `date_absensidokter` date NOT NULL,
  KEY `fk_absensidokter_dokter1_idx` (`dokter_id_dokter`),
  CONSTRAINT `fk_absensidokter_dokter1` FOREIGN KEY (`dokter_id_dokter`) REFERENCES `dokter` (`id_dokter`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `absensidokter`
--

LOCK TABLES `absensidokter` WRITE;
/*!40000 ALTER TABLE `absensidokter` DISABLE KEYS */;
/*!40000 ALTER TABLE `absensidokter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `absensipegawai`
--

DROP TABLE IF EXISTS `absensipegawai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `absensipegawai` (
  `pegawai_id_pegawai` varchar(45) NOT NULL,
  `kehadiranreguler_pegawai` varchar(1) NOT NULL DEFAULT '0',
  `kehadiranlembur_pegawai` varchar(1) NOT NULL DEFAULT '0',
  `date_absensipegawai` date NOT NULL,
  KEY `fk_absensipegawai_pegawai1_idx` (`pegawai_id_pegawai`),
  CONSTRAINT `fk_absensipegawai_pegawai1` FOREIGN KEY (`pegawai_id_pegawai`) REFERENCES `pegawai` (`id_pegawai`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `absensipegawai`
--

LOCK TABLES `absensipegawai` WRITE;
/*!40000 ALTER TABLE `absensipegawai` DISABLE KEYS */;
/*!40000 ALTER TABLE `absensipegawai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `antrian`
--

DROP TABLE IF EXISTS `antrian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `antrian` (
  `id_antrian` varchar(45) NOT NULL,
  `pasien_id_pasien` varchar(10) NOT NULL,
  `dokter_id_dokter` varchar(10) NOT NULL,
  `nomor_antrian` int(11) NOT NULL,
  `jenis_antrian` varchar(45) NOT NULL,
  `tgl_antrian` date NOT NULL,
  `hadir` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id_antrian`),
  KEY `fk_antrian_pasien1_idx` (`pasien_id_pasien`),
  KEY `fk_antrian_dokter1_idx` (`dokter_id_dokter`),
  CONSTRAINT `fk_antrian_dokter1` FOREIGN KEY (`dokter_id_dokter`) REFERENCES `dokter` (`id_dokter`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_antrian_pasien1` FOREIGN KEY (`pasien_id_pasien`) REFERENCES `pasien` (`id_pasien`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `antrian`
--

LOCK TABLES `antrian` WRITE;
/*!40000 ALTER TABLE `antrian` DISABLE KEYS */;
/*!40000 ALTER TABLE `antrian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detailobat`
--

DROP TABLE IF EXISTS `detailobat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detailobat` (
  `id_detail` int(11) NOT NULL,
  `obat_id_obat` int(11) NOT NULL,
  `tglkadaluarsa_detail` date DEFAULT NULL,
  PRIMARY KEY (`id_detail`),
  KEY `fk_detailobat_obat1_idx` (`obat_id_obat`),
  CONSTRAINT `fk_detailobat_obat1` FOREIGN KEY (`obat_id_obat`) REFERENCES `obat` (`id_obat`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detailobat`
--

LOCK TABLES `detailobat` WRITE;
/*!40000 ALTER TABLE `detailobat` DISABLE KEYS */;
/*!40000 ALTER TABLE `detailobat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detailresep`
--

DROP TABLE IF EXISTS `detailresep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detailresep` (
  `id_detailresep` varchar(45) NOT NULL,
  `resep_id_resep` varchar(45) NOT NULL,
  `namaobat_resep` varchar(45) DEFAULT NULL,
  `qty_resep` int(11) DEFAULT NULL,
  `aturanpakai_resep` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_detailresep`),
  KEY `fk_detailresep_resep1_idx` (`resep_id_resep`),
  CONSTRAINT `fk_detailresep_resep1` FOREIGN KEY (`resep_id_resep`) REFERENCES `resep` (`id_resep`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detailresep`
--

LOCK TABLES `detailresep` WRITE;
/*!40000 ALTER TABLE `detailresep` DISABLE KEYS */;
/*!40000 ALTER TABLE `detailresep` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detailtransaksibeliobat`
--

DROP TABLE IF EXISTS `detailtransaksibeliobat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detailtransaksibeliobat` (
  `transaksibeliobat_id_transaksibeliobat` varchar(45) NOT NULL,
  `obat_id_obat` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  PRIMARY KEY (`transaksibeliobat_id_transaksibeliobat`,`obat_id_obat`),
  KEY `fk_detailtransaksibeliobat_obat1_idx` (`obat_id_obat`),
  CONSTRAINT `fk_detailtransaksibeliobat_obat1` FOREIGN KEY (`obat_id_obat`) REFERENCES `obat` (`id_obat`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detailtransaksibeliobat_transaksibeliobat1` FOREIGN KEY (`transaksibeliobat_id_transaksibeliobat`) REFERENCES `transaksibeliobat` (`id_transaksibeliobat`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detailtransaksibeliobat`
--

LOCK TABLES `detailtransaksibeliobat` WRITE;
/*!40000 ALTER TABLE `detailtransaksibeliobat` DISABLE KEYS */;
/*!40000 ALTER TABLE `detailtransaksibeliobat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detailtransaksijualobat`
--

DROP TABLE IF EXISTS `detailtransaksijualobat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detailtransaksijualobat` (
  `transaksijualobat_id_transaksijual` varchar(45) NOT NULL,
  `obat_id_obat` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  PRIMARY KEY (`transaksijualobat_id_transaksijual`,`obat_id_obat`),
  KEY `fk_detailtransaksijualobat_obat1_idx` (`obat_id_obat`),
  KEY `fk_detailtransaksijualobat_transaksijualobat1_idx` (`transaksijualobat_id_transaksijual`),
  CONSTRAINT `fk_detailtransaksijualobat_obat1` FOREIGN KEY (`obat_id_obat`) REFERENCES `obat` (`id_obat`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detailtransaksijualobat_transaksijualobat1` FOREIGN KEY (`transaksijualobat_id_transaksijual`) REFERENCES `transaksijualobat` (`id_transaksijual`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detailtransaksijualobat`
--

LOCK TABLES `detailtransaksijualobat` WRITE;
/*!40000 ALTER TABLE `detailtransaksijualobat` DISABLE KEYS */;
/*!40000 ALTER TABLE `detailtransaksijualobat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dokter`
--

DROP TABLE IF EXISTS `dokter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dokter` (
  `id_dokter` varchar(10) NOT NULL,
  `poli_id_poli` varchar(5) NOT NULL,
  `user_id_user` int(11) NOT NULL,
  `nama_dokter` varchar(45) NOT NULL,
  `alamat_dokter` varchar(45) NOT NULL,
  `nokartuid_dokter` varchar(45) NOT NULL,
  `telp_dokter` varchar(45) DEFAULT NULL,
  `hp1_dokter` varchar(45) DEFAULT NULL,
  `hp2_dokter` varchar(45) DEFAULT NULL,
  `tempatlahir_dokter` varchar(45) NOT NULL,
  `tgllahir_dokter` date NOT NULL,
  `kelamin_dokter` varchar(1) NOT NULL,
  `darah_dokter` varchar(2) NOT NULL DEFAULT '-',
  `bank_dokter` varchar(45) DEFAULT NULL,
  `norek_dokter` varchar(45) DEFAULT NULL,
  `foto_dokter` longblob,
  `gajifix_dokter` int(11) DEFAULT NULL,
  `gajilembur_dokter` int(11) DEFAULT NULL,
  `gajikonsul_dokter` double DEFAULT NULL,
  PRIMARY KEY (`id_dokter`),
  UNIQUE KEY `user_id_user_UNIQUE` (`user_id_user`),
  KEY `fk_dokter_poli1_idx` (`poli_id_poli`),
  KEY `fk_dokter_user1_idx` (`user_id_user`),
  CONSTRAINT `fk_dokter_poli1` FOREIGN KEY (`poli_id_poli`) REFERENCES `poli` (`id_poli`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_dokter_user1` FOREIGN KEY (`user_id_user`) REFERENCES `user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dokter`
--

LOCK TABLES `dokter` WRITE;
/*!40000 ALTER TABLE `dokter` DISABLE KEYS */;
/*!40000 ALTER TABLE `dokter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gajidokter`
--

DROP TABLE IF EXISTS `gajidokter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gajidokter` (
  `dokter_id_dokter` varchar(10) NOT NULL,
  `bulanan_gajidokter` int(11) NOT NULL,
  `dibayarkan_gajidokter` date NOT NULL,
  `bonus_gajidokter` int(11) DEFAULT NULL,
  `keterangan_gajidokter` varchar(45) DEFAULT NULL,
  KEY `fk_gajidokter_dokter1_idx` (`dokter_id_dokter`),
  CONSTRAINT `fk_gajidokter_dokter1` FOREIGN KEY (`dokter_id_dokter`) REFERENCES `dokter` (`id_dokter`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gajidokter`
--

LOCK TABLES `gajidokter` WRITE;
/*!40000 ALTER TABLE `gajidokter` DISABLE KEYS */;
/*!40000 ALTER TABLE `gajidokter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gajipegawai`
--

DROP TABLE IF EXISTS `gajipegawai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gajipegawai` (
  `pegawai_id_pegawai` varchar(45) NOT NULL,
  `bulanan_gajipegawai` int(11) DEFAULT NULL,
  `dibayarkan_gajipegawai` date DEFAULT NULL,
  `bonus_gajipegawai` int(11) DEFAULT NULL,
  `keterangan_gajipegawai` varchar(45) DEFAULT NULL,
  KEY `fk_gajipegawai_pegawai1_idx` (`pegawai_id_pegawai`),
  CONSTRAINT `fk_gajipegawai_pegawai1` FOREIGN KEY (`pegawai_id_pegawai`) REFERENCES `pegawai` (`id_pegawai`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gajipegawai`
--

LOCK TABLES `gajipegawai` WRITE;
/*!40000 ALTER TABLE `gajipegawai` DISABLE KEYS */;
/*!40000 ALTER TABLE `gajipegawai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jadwal`
--

DROP TABLE IF EXISTS `jadwal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jadwal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hari_jadwalpegawai` varchar(45) NOT NULL,
  `shift_jadwalpegawai` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jadwal`
--

LOCK TABLES `jadwal` WRITE;
/*!40000 ALTER TABLE `jadwal` DISABLE KEYS */;
/*!40000 ALTER TABLE `jadwal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jadwaldokter`
--

DROP TABLE IF EXISTS `jadwaldokter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jadwaldokter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dokter_id_dokter` varchar(10) NOT NULL,
  `jadwal_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_jadwaldokter_dokter1_idx` (`dokter_id_dokter`),
  KEY `fk_jadwaldokter_jadwal1_idx` (`jadwal_id`),
  CONSTRAINT `fk_jadwaldokter_dokter1` FOREIGN KEY (`dokter_id_dokter`) REFERENCES `dokter` (`id_dokter`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_jadwaldokter_jadwal1` FOREIGN KEY (`jadwal_id`) REFERENCES `jadwal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jadwaldokter`
--

LOCK TABLES `jadwaldokter` WRITE;
/*!40000 ALTER TABLE `jadwaldokter` DISABLE KEYS */;
/*!40000 ALTER TABLE `jadwaldokter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jadwalpegawai`
--

DROP TABLE IF EXISTS `jadwalpegawai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jadwalpegawai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pegawai_id_pegawai` varchar(45) NOT NULL,
  `jadwal_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_jadwalpegawai_pegawai1_idx` (`pegawai_id_pegawai`),
  KEY `fk_jadwalpegawai_jadwal1_idx` (`jadwal_id`),
  CONSTRAINT `fk_jadwalpegawai_jadwal1` FOREIGN KEY (`jadwal_id`) REFERENCES `jadwal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_jadwalpegawai_pegawai1` FOREIGN KEY (`pegawai_id_pegawai`) REFERENCES `pegawai` (`id_pegawai`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jadwalpegawai`
--

LOCK TABLES `jadwalpegawai` WRITE;
/*!40000 ALTER TABLE `jadwalpegawai` DISABLE KEYS */;
/*!40000 ALTER TABLE `jadwalpegawai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kamar`
--

DROP TABLE IF EXISTS `kamar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kamar` (
  `id_kamar` int(11) NOT NULL,
  `nama_kamar` varchar(45) NOT NULL,
  `kelas` varchar(45) NOT NULL,
  `tarif` int(11) NOT NULL,
  PRIMARY KEY (`id_kamar`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kamar`
--

LOCK TABLES `kamar` WRITE;
/*!40000 ALTER TABLE `kamar` DISABLE KEYS */;
/*!40000 ALTER TABLE `kamar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kartupasien`
--

DROP TABLE IF EXISTS `kartupasien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kartupasien` (
  `pasien_id_pasien` varchar(10) NOT NULL,
  `cetak_kartupasien` date NOT NULL,
  `berlakusampai_kartupasien` date NOT NULL,
  PRIMARY KEY (`pasien_id_pasien`),
  CONSTRAINT `fk_kartupasien_pasien1` FOREIGN KEY (`pasien_id_pasien`) REFERENCES `pasien` (`id_pasien`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kartupasien`
--

LOCK TABLES `kartupasien` WRITE;
/*!40000 ALTER TABLE `kartupasien` DISABLE KEYS */;
/*!40000 ALTER TABLE `kartupasien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kota`
--

DROP TABLE IF EXISTS `kota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kota` (
  `id_kota` varchar(10) NOT NULL,
  `provinsi_id_provinsi` varchar(10) NOT NULL,
  `nama_kota` varchar(45) NOT NULL,
  PRIMARY KEY (`id_kota`,`provinsi_id_provinsi`),
  KEY `fk_kota_provinsi1_idx` (`provinsi_id_provinsi`),
  CONSTRAINT `fk_kota_provinsi1` FOREIGN KEY (`provinsi_id_provinsi`) REFERENCES `provinsi` (`id_provinsi`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kota`
--

LOCK TABLES `kota` WRITE;
/*!40000 ALTER TABLE `kota` DISABLE KEYS */;
/*!40000 ALTER TABLE `kota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kunjungan`
--

DROP TABLE IF EXISTS `kunjungan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kunjungan` (
  `id_kunjungan` varchar(45) NOT NULL,
  `pasien_id_pasien` varchar(10) NOT NULL,
  `rekammedik_id_rekammedik` varchar(45) NOT NULL,
  `transaksijualobat_id_transaksijual` varchar(45) DEFAULT 'Kosong',
  `pasien_kamar_id_peminjaman` varchar(10) DEFAULT 'Kosong',
  `tanggaljam_kunjungan` datetime NOT NULL,
  `biaya_kunjungan` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_kunjungan`),
  KEY `fk_kunjungan_pasien1_idx` (`pasien_id_pasien`),
  KEY `fk_kunjungan_rekammedis1_idx` (`rekammedik_id_rekammedik`),
  KEY `fk_kunjungan_transaksijualobat1_idx` (`transaksijualobat_id_transaksijual`),
  KEY `fk_kunjungan_pasien_kamar1_idx` (`pasien_kamar_id_peminjaman`),
  CONSTRAINT `fk_kunjungan_pasien1` FOREIGN KEY (`pasien_id_pasien`) REFERENCES `pasien` (`id_pasien`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_kunjungan_pasien_kamar1` FOREIGN KEY (`pasien_kamar_id_peminjaman`) REFERENCES `pasien_kamar` (`id_peminjaman`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_kunjungan_rekammedis1` FOREIGN KEY (`rekammedik_id_rekammedik`) REFERENCES `rekammedik` (`id_rekammedik`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_kunjungan_transaksijualobat1` FOREIGN KEY (`transaksijualobat_id_transaksijual`) REFERENCES `transaksijualobat` (`id_transaksijual`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kunjungan`
--

LOCK TABLES `kunjungan` WRITE;
/*!40000 ALTER TABLE `kunjungan` DISABLE KEYS */;
/*!40000 ALTER TABLE `kunjungan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `obat`
--

DROP TABLE IF EXISTS `obat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `obat` (
  `id_obat` int(11) NOT NULL,
  `nama_obat` varchar(45) DEFAULT NULL,
  `qty_obat` int(11) DEFAULT NULL,
  `jenis_obat` varchar(45) DEFAULT NULL,
  `keterangan` varchar(45) DEFAULT NULL,
  `hargajual_obat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_obat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `obat`
--

LOCK TABLES `obat` WRITE;
/*!40000 ALTER TABLE `obat` DISABLE KEYS */;
/*!40000 ALTER TABLE `obat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pasien`
--

DROP TABLE IF EXISTS `pasien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pasien` (
  `id_pasien` varchar(10) NOT NULL,
  `kota_id_kota` varchar(10) NOT NULL,
  `user_id_user` int(11) NOT NULL,
  `nama_pasien` varchar(45) NOT NULL,
  `alamat_pasien` varchar(45) NOT NULL,
  `kartuid_pasien` varchar(45) NOT NULL,
  `nokartuid_pasien` varchar(45) NOT NULL,
  `telp_pasien` varchar(45) DEFAULT NULL,
  `hp_pasien` varchar(45) DEFAULT NULL,
  `tempatlahir_pasien` varchar(45) NOT NULL,
  `tgllahir_pasien` date NOT NULL,
  `kelamin_pasien` varchar(1) NOT NULL,
  `darah_pasien` varchar(2) NOT NULL DEFAULT '-',
  `berat_pasien` int(11) DEFAULT NULL,
  `tinggi_pasien` int(11) DEFAULT NULL,
  `regdate_pasien` date NOT NULL,
  PRIMARY KEY (`id_pasien`),
  UNIQUE KEY `user_id_user_UNIQUE` (`user_id_user`),
  KEY `fk_pasien_kota1_idx` (`kota_id_kota`),
  KEY `fk_pasien_user1_idx` (`user_id_user`),
  CONSTRAINT `fk_pasien_kota1` FOREIGN KEY (`kota_id_kota`) REFERENCES `kota` (`id_kota`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pasien_user1` FOREIGN KEY (`user_id_user`) REFERENCES `user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pasien`
--

LOCK TABLES `pasien` WRITE;
/*!40000 ALTER TABLE `pasien` DISABLE KEYS */;
/*!40000 ALTER TABLE `pasien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pasien_kamar`
--

DROP TABLE IF EXISTS `pasien_kamar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pasien_kamar` (
  `id_peminjaman` varchar(10) NOT NULL,
  `kamar_id_kamar` int(11) NOT NULL,
  `datein_pasien_kamar` datetime NOT NULL,
  `dateout_pasien_kamar` datetime NOT NULL,
  `keterangan` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_peminjaman`),
  KEY `fk_pasien_kamar_kamar1` (`kamar_id_kamar`),
  CONSTRAINT `fk_pasien_kamar_kamar1` FOREIGN KEY (`kamar_id_kamar`) REFERENCES `kamar` (`id_kamar`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pasien_kamar`
--

LOCK TABLES `pasien_kamar` WRITE;
/*!40000 ALTER TABLE `pasien_kamar` DISABLE KEYS */;
/*!40000 ALTER TABLE `pasien_kamar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pegawai`
--

DROP TABLE IF EXISTS `pegawai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pegawai` (
  `id_pegawai` varchar(45) NOT NULL,
  `user_id_user` int(11) NOT NULL,
  `nama_pegawai` varchar(45) NOT NULL,
  `alamat_pegawai` varchar(45) NOT NULL,
  `nokartuid_pegawai` varchar(45) NOT NULL,
  `telp_pegawai` varchar(45) DEFAULT NULL,
  `hp1_pegawai` varchar(45) DEFAULT NULL,
  `hp2_pegawai` varchar(45) DEFAULT NULL,
  `tempatlahir_pegawai` varchar(45) NOT NULL,
  `tgllahir_pegawai` varchar(45) NOT NULL,
  `kelamin_pegawai` varchar(1) NOT NULL,
  `darah_pegawai` varchar(2) NOT NULL DEFAULT '-',
  `jabatan_pegawai` varchar(45) NOT NULL,
  `bank_pegawai` varchar(45) DEFAULT NULL,
  `norek_pegawai` varchar(45) DEFAULT NULL,
  `foto_pegawai` longblob,
  `gajifix_pegawai` int(11) DEFAULT NULL,
  `gajilembur_pegawai` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_pegawai`),
  UNIQUE KEY `user_id_user_UNIQUE` (`user_id_user`),
  KEY `fk_pegawai_user1_idx` (`user_id_user`),
  CONSTRAINT `fk_pegawai_user1` FOREIGN KEY (`user_id_user`) REFERENCES `user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pegawai`
--

LOCK TABLES `pegawai` WRITE;
/*!40000 ALTER TABLE `pegawai` DISABLE KEYS */;
/*!40000 ALTER TABLE `pegawai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `penyakit`
--

DROP TABLE IF EXISTS `penyakit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `penyakit` (
  `id_penyakit` varchar(10) NOT NULL,
  `nama_penyakit` varchar(45) NOT NULL,
  `deskripsi_penyakit` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id_penyakit`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `penyakit`
--

LOCK TABLES `penyakit` WRITE;
/*!40000 ALTER TABLE `penyakit` DISABLE KEYS */;
/*!40000 ALTER TABLE `penyakit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `poli`
--

DROP TABLE IF EXISTS `poli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `poli` (
  `id_poli` varchar(5) NOT NULL,
  `nama_poli` varchar(45) NOT NULL,
  `keterangan` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_poli`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poli`
--

LOCK TABLES `poli` WRITE;
/*!40000 ALTER TABLE `poli` DISABLE KEYS */;
/*!40000 ALTER TABLE `poli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provinsi`
--

DROP TABLE IF EXISTS `provinsi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provinsi` (
  `id_provinsi` varchar(10) NOT NULL,
  `nama_provinsi` varchar(45) NOT NULL,
  PRIMARY KEY (`id_provinsi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provinsi`
--

LOCK TABLES `provinsi` WRITE;
/*!40000 ALTER TABLE `provinsi` DISABLE KEYS */;
/*!40000 ALTER TABLE `provinsi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rakobat`
--

DROP TABLE IF EXISTS `rakobat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rakobat` (
  `id_rak` int(11) NOT NULL,
  `obat_id_obat` int(11) NOT NULL,
  `nama_rak` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_rak`),
  KEY `fk_rakobat_obat1_idx` (`obat_id_obat`),
  CONSTRAINT `fk_rakobat_obat1` FOREIGN KEY (`obat_id_obat`) REFERENCES `obat` (`id_obat`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rakobat`
--

LOCK TABLES `rakobat` WRITE;
/*!40000 ALTER TABLE `rakobat` DISABLE KEYS */;
/*!40000 ALTER TABLE `rakobat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rekammedik`
--

DROP TABLE IF EXISTS `rekammedik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rekammedik` (
  `id_rekammedik` varchar(45) NOT NULL,
  `dokter_id_dokter` varchar(10) NOT NULL,
  `pasien_id_pasien` varchar(10) NOT NULL,
  `tgl_rekammedik` datetime NOT NULL,
  `keluhan_rekammedik` varchar(512) DEFAULT NULL,
  `pemeriksaan_rekammedik` varchar(512) DEFAULT NULL,
  `terapi_rekammedik` varchar(512) DEFAULT NULL,
  `alergiobat_rekammedik` varchar(50) DEFAULT NULL,
  `kesimpulan_rekammedis` varchar(50) DEFAULT NULL,
  `kondisipasienkeluar_rekammedis` varchar(60) NOT NULL,
  `resep_id_resep` varchar(45) NOT NULL,
  PRIMARY KEY (`id_rekammedik`),
  KEY `fk_rekammedis_dokter1_idx` (`dokter_id_dokter`),
  KEY `fk_rekammedis_pasien1_idx` (`pasien_id_pasien`),
  KEY `fk_rekammedis_resep1_idx` (`resep_id_resep`),
  CONSTRAINT `fk_rekammedis_dokter1` FOREIGN KEY (`dokter_id_dokter`) REFERENCES `dokter` (`id_dokter`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rekammedis_pasien1` FOREIGN KEY (`pasien_id_pasien`) REFERENCES `pasien` (`id_pasien`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rekammedis_resep1` FOREIGN KEY (`resep_id_resep`) REFERENCES `resep` (`id_resep`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rekammedik`
--

LOCK TABLES `rekammedik` WRITE;
/*!40000 ALTER TABLE `rekammedik` DISABLE KEYS */;
/*!40000 ALTER TABLE `rekammedik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rekammedis_penyakit`
--

DROP TABLE IF EXISTS `rekammedis_penyakit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rekammedis_penyakit` (
  `rekammedik_id_rekammedik` varchar(45) NOT NULL,
  `penyakit_id_penyakit` varchar(10) NOT NULL,
  KEY `fk_rekammedis_penyakit_rekammedis1_idx` (`rekammedik_id_rekammedik`),
  KEY `fk_rekammedis_penyakit_penyakit1_idx` (`penyakit_id_penyakit`),
  CONSTRAINT `fk_rekammedis_penyakit_penyakit1` FOREIGN KEY (`penyakit_id_penyakit`) REFERENCES `penyakit` (`id_penyakit`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rekammedis_penyakit_rekammedis1` FOREIGN KEY (`rekammedik_id_rekammedik`) REFERENCES `rekammedik` (`id_rekammedik`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rekammedis_penyakit`
--

LOCK TABLES `rekammedis_penyakit` WRITE;
/*!40000 ALTER TABLE `rekammedis_penyakit` DISABLE KEYS */;
/*!40000 ALTER TABLE `rekammedis_penyakit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resep`
--

DROP TABLE IF EXISTS `resep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resep` (
  `id_resep` varchar(45) NOT NULL,
  `keterangan` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_resep`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resep`
--

LOCK TABLES `resep` WRITE;
/*!40000 ALTER TABLE `resep` DISABLE KEYS */;
/*!40000 ALTER TABLE `resep` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timestamps`
--

DROP TABLE IF EXISTS `timestamps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timestamps` (
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timestamps`
--

LOCK TABLES `timestamps` WRITE;
/*!40000 ALTER TABLE `timestamps` DISABLE KEYS */;
/*!40000 ALTER TABLE `timestamps` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaksibeliobat`
--

DROP TABLE IF EXISTS `transaksibeliobat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaksibeliobat` (
  `id_transaksibeliobat` varchar(45) NOT NULL,
  `date_transaksibeli` date DEFAULT NULL,
  `keterangan` varchar(45) DEFAULT NULL,
  `hargabeli_obat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_transaksibeliobat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaksibeliobat`
--

LOCK TABLES `transaksibeliobat` WRITE;
/*!40000 ALTER TABLE `transaksibeliobat` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaksibeliobat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaksijualobat`
--

DROP TABLE IF EXISTS `transaksijualobat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaksijualobat` (
  `id_transaksijual` varchar(45) NOT NULL,
  `date_transaksijual` date DEFAULT NULL,
  `keterangan` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_transaksijual`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaksijualobat`
--

LOCK TABLES `transaksijualobat` WRITE;
/*!40000 ALTER TABLE `transaksijualobat` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaksijualobat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `registered` datetime NOT NULL,
  `lastlogin` datetime NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'carisma','carisma','2015-03-13 00:00:00','2015-03-13 00:00:00','administrator');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-29 20:46:12
