<?php

class Book extends Controller {

    function __construct() {
        parent::__construct();
        Session::init();
        $this->index();
    }

    function index() {
        $this->view->title = "Doctors";
        $this->view->render('doctor/book', 1, 0);
    }
}
