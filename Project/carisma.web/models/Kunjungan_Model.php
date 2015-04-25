<?php

class Kunjungan_Model extends Model {

    function __construct() {
        parent::__construct();
    }

    function getkunjunganpasien($username,$password) {
        $statement = $this->db->prepare("SELECT a.tgl_rekammedik , a.keluhan_rekammedik , b.nama_dokter "
                . "FROM rekammedik as a ,dokter as b WHERE a.dokter_id_dokter=b.id_dokter AND"
                . " a.pasien_id_pasien = (SELECT id_pasien FROM  pasien WHERE user_id_user = (SELECT id_user FROM"
                . " user WHERE username = :username  AND password = :password)) ");
        $statement->execute(array(":username" => $username, ":password" => $password));
        return $statement->fetchAll();
    }
    
}
