<?php

Class Jadwaldokter_Model extends Model {

    function __construct() {
        parent::__construct();
    }

    public function dayJadwal($iddokter) {
        $statement = $this->db->prepare("SELECT DISTINCT j.hari_jadwalpegawai FROM jadwal j, jadwaldokter d WHERE d.jadwal_id = j.id AND d.dokter_id_dokter = :id");
        $statement->execute(array(':id' => $iddokter));
        return $statement->fetchAll();
    }

    public function dateJadwal($day) {
        $statement = $this->db->prepare("SELECT DAYNAME(date), date(date) FROM date WHERE DAYNAME(date) = :day AND (month(date) = MONTH(curdate()) OR month(date) = MONTH(curdate())+1) AND year(date) = year(curdate()) AND date(date) >= date(curdate());");
        $statement->execute(array(':day' => $day));
        return $statement->fetchAll();
    }

}
