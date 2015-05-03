<?php

class detilPenyakit extends Controller {

    function __construct() {
        parent::__construct();
        Session::init();
       
    }

    function index() {
        $this->loadModel("Kunjungan");
        $username = Session::get('Etok');
        $password = Session::get('Wuryanto');
        
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
        $this->view->render('penyakit/detail', 1, 0);
    }

}
