<?php

require_once ''.URL.'Login_Model.php';

class Login_Test extends PHPUnit_Framework_TestCase{
    
    public $username,$password;
    public function setup($username,$password) {
        $this->test= new Login_Model();
        
    }
    
    public function testUsernamepass(){
        
    }
    
}