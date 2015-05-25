<?php

class Dokter_Model extends Model {

    function __construct() {
        parent::__construct();
    }

    function getAlldoctor() {
        $statement = $this->db->prepare("SELECT a.id_dokter, a.poli_id_poli, a.user_id_user, a.nama_dokter, a.alamat_dokter, a.nokartuid_dokter, a.telp_dokter, a.hp1_dokter, a.hp2_dokter, a.tempatlahir_dokter, a.tgllahir_dokter, a.kelamin_dokter, a.darah_dokter, a.bank_dokter, a.norek_dokter, a.foto_dokter, a.gajifix_dokter, a.gajilembur_dokter, a.gajikonsul_dokter, p.nama_poli
FROM DOKTER a, poli p
WHERE a.poli_id_poli = p.id_poli");
        $statement->execute();
        return $statement->fetchAll();
    }

    function getDokter($id) {
        $statement = $this->db->prepare("SELECT a.id_dokter, a.poli_id_poli, a.user_id_user, a.nama_dokter, a.alamat_dokter, a.nokartuid_dokter, a.telp_dokter, a.hp1_dokter, a.hp2_dokter, a.tempatlahir_dokter, a.tgllahir_dokter, a.kelamin_dokter, a.darah_dokter, a.bank_dokter, a.norek_dokter, a.foto_dokter, a.gajifix_dokter, a.gajilembur_dokter, a.gajikonsul_dokter, p.nama_poli
FROM DOKTER a, poli p WHERE a.id_dokter = :id AND a.poli_id_poli = p.id_poli ");
        $statement->execute(array(":id" => $id));
        return $statement->fetchAll();
    }

    function getJadwalDokter($id) {
        $statement = $this->db->prepare("SELECT a.jadwal_id,b.hari_jadwalpegawai,b.shift_jadwalpegawai FROM jadwaldokter a , jadwal b WHERE a.dokter_id_dokter = :id AND b.id = a.jadwal_id");
        $statement->execute(array(":id" => $id));
        return $statement->fetchAll();
    }

}
