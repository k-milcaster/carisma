<?php

class Login_Model extends Model {

    function __construct() {
        parent::__construct();
    }

    function isTrue($username, $password) {
        $statement = $this->db->prepare("Select * from user WHERE username = :username AND password = :password");
        $statement->execute(array(":username" => $username, ":password" => $password));
        $rak = $statement->fetchall();
        $i = 0;
        foreach ($rak as $key => $value) {
            $i++;
        }
        if ($i == 0) {
            return FALSE;
        } else {
            return TRUE;
        }
    }

}
