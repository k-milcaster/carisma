<?php

class dashboard extends Controller {

    function __construct() {
        parent::__construct();
        Session::init();
        if (Session::get('id') != NULL) {
            $this->index();
        } else {
            $this->view->title = "Login";
            $this->view->render('login/index', 1, 0);
        }
    }

    function index() {
        $this->loadModel("Kunjungan");
        $username = Session::get('id');
        $password = Session::get('pas');
        
        $rak = $this->model->getkunjunganpasien($username,$password);

        $masukindums = "";
        $i = 1;


        $masukindums = "";
        foreach ($rak as $key => $value) {
            $masukindums = $masukindums . '
                            <tr>
                                <td >
                                    '.$value[0] .'
                                </td>
                                <td>
                                    '.$value[1].'
                                </td>
                                <td>
                                    '.$value[2].'
                                </td>
                            </tr>';
        }
        $this->view->ini=$masukindums;
        $this->view->title = "Dashboard";
        $this->view->render('dashboard/index', 1, 0);
    }

}
