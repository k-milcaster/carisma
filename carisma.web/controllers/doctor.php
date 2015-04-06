<?php

class Doctor extends Controller {

    function __construct() {
        parent::__construct();
        Session::init();
        $this->index();
    }

    function index() {
        $this->view->title = "Doctors";
        $this->view->render('doctor/index', 1, 0);
    }
}
