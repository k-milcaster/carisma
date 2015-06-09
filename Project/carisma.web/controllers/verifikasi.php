<?php

class verifikasi extends Controller {

    function __construct() {
        parent::__construct();
        Session::init();
    }

    function index() {
        Index::__construct();
    }

    function dologin() {
        if ((($_POST['username']) != "Username:") && (($_POST['pass']) != "Password:")) {
            $us = $_POST['username'];
            $usa = $_POST['pass'];

            $ambil = "";
            $this->loadModel("Login");
            $ambil = $this->model->isTrue($us, $usa);


            if ($ambil == TRUE) {
                $this->loadModel('Pasien');
                $emp = $this->model->getPasienByUserName($us);
                foreach ($emp as $key => $valuess) {
                    Session::set('namaPas', $valuess[0]);
                    Session::set('id', $valuess[1]);
                }
                Redirect::go(URL);
            } else {
                $masukindums = 'Salah Password';
                $this->view->ini = $masukindums;
                $this->view->title = 'Login';
                $this->view->render('login/index', 1, 0);
            }
        } else {

            $masukindums = 'Username/ Password masih kosong';

            $this->view->ini = $masukindums;
            $this->view->title = "Login";
            $this->view->render('login/index', 1, 0);
        }
//        $_POST['username'];
//        $_POST['username'];
    }

    function dologout() {
        Session::kill();
        Redirect::go(URL);
    }

}
