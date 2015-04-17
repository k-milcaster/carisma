<?php

class Login extends Controller {

    function __construct() {
        parent::__construct();
        Session::init();
        $this->view->title = "Login";
        $this->view->render('login/index', 1, 0);
//        Session::get($key)
        
    }

    function index() {
        Index::__construct();
    }
    
}

?>