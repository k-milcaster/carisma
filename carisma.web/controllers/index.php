<?php

class Index extends Controller {

    function __construct() {
        parent::__construct();
        Session::init();
        parent::loadModel('Events');
        $this->view->render('index/index', 1, 0);
    }

    function index() {
        Index::__construct();
    }

}

?>