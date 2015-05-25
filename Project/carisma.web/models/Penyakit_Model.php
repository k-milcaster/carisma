<?php

class Penyakit_Model extends Model {

    function __construct() {
        parent::__construct();
    }

    

    function getpenyakit($namapenyakit) {
        $statement = $this->db->prepare("SELECT nama_penyakit , deskripsi_penyakit FROM penyakit "
                . "WHERE nama_penyakit = :penyakit");
        $statement->execute(array("penyakit" => $namapenyakit));
        return $statement->fetchAll();
    }
    
    function getgrouppedpenyakit($groupped) {
        $statement = $this->db->prepare("SELECT nama_penyakit , deskripsi_penyakit FROM penyakit "
                . "WHERE nama_penyakit = :penyakit");
        $statement->execute(array("penyakit" => $groupped));
        return $statement->fetchAll();
    }

}
