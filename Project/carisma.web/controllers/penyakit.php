<?php

class penyakit extends Controller {
    
    function __construct() {
        parent::__construct();
        Session::init();
       
        $this->view->title = "Service";
        $this->view->render('penyakit/index', 1, 0);  
    
        
    } 
 
    function index(){
        Index::__construct();
    }
      
    
   
}