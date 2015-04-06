<?php

class singleDoctor extends Controller {

    function __construct() {
        parent::__construct();
        Session::init();       
    }

    function id($param) {
        $this->view->go = 'id = '.$param;
        $this->view->title = "Doctors";
        $this->view->render('doctor/single', 1, 0);
    }

}
