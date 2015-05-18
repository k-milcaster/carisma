<?php

require_once ''.URL.'verifikasi.php';

class verifikasi_Test extends PHPUnit_Framework_TestCase{
    
    public $username,$password;
    public function setup($username,$password) {
        $this->test= new Login_Model();
        
    }
    
    public function testUsernamepass(){
        
    }
    
}