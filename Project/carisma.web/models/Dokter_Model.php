<?php

class Dokter_Model extends Model{

    function __construct() {
        parent::__construct();
        
    }
    function getAlldoctor(){
       $statement = $this->db->prepare("SELECT a.id_dokter, a.poli_id_poli, a.user_id_user, a.nama_dokter, a.alamat_dokter, a.nokartuid_dokter, a.telp_dokter, a.hp1_dokter, a.hp2_dokter, a.tempatlahir_dokter, a.tgllahir_dokter, a.kelamin_dokter, a.darah_dokter, a.bank_dokter, a.norek_dokter, a.foto_dokter, a.gajifix_dokter, a.gajilembur_dokter, a.gajikonsul_dokter, p.nama_poli
FROM DOKTER a, poli p");
       $statement->execute();
       return $statement->fetchAll();
       
       
    }
    
    
    
}