<?php

class Pasien_Model extends Model {

    function __construct() {
        parent::__construct();
    }

    function getPasien($arg) {
        $statement = $this->db->prepare("SELECT nama_pasien, id_pasien FROM pasien "
                . "WHERE user_id_user = :id");
        $statement->execute(array(":id" => $arg));
        return $statement->fetchAll();
    }

}
