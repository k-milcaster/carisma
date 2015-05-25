<?php

class Antrian_Model extends Model {

    function __construct() {
        parent::__construct();
    }

    function insertAntrian($id, $pasien, $dokter, $antrian, $jenis, $tgl) {
        $statement = $this->db->prepare("INSERT INTO antrian (id_antrian, pasien_id_pasien, dokter_id_dokter, nomor_antrian, jenis_antrian, tgl_antrian) VALUES (:id, :pasien, :dokter, :antrian, :jenis, :tgl)");
        $statement->execute(array(':id' => $id,
            ':pasien' => $pasien,
            ':dokter' => $dokter,
            ':antrian' => $antrian,
            ':jenis' => $jenis,
            ':tgl' => $tgl));
        return $statement->fetchAll();
    }

    function getCountAntrian() {
        $statement = $this->db->prepare("SELECT COUNT(id_antrian) FROM antrian WHERE id_antrian LIKE ('O%');");
        $statement->execute();
        return $statement->fetchAll();
    }

    function getLastNomorAntrian() {
        $statement = $this->db->prepare("SELECT MAX(nomor_antrian) FROM antrian;");
        $statement->execute();
        return $statement->fetchAll();
    }

}
