<?php
class dashboard extends Controller{
     function __construct() {
        parent::__construct();
        Session::init();
        if(Session::get('id')!=NULL){
        $this->index();
        }
        else{
        $this->view->title = "Login";
        $this->view->render('login/index', 1, 0);
            
        }
    }

    function index () {
        $this->view->title = "Dashboard";
        $this->view->render('dashboard/index', 1, 0);
    }
    
    
     }