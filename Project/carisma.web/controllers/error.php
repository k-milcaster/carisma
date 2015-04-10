<?php

class error extends Controller{
    function __construct() {
        parent::__construct();
        Session::init();
         $this->view->render('error/index', 0, 0);
    } 
    
    
    
}