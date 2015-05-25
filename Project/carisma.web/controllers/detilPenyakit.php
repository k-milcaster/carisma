<?php

class detilPenyakit extends Controller {

    function __construct() {
        parent::__construct();
        Session::init();
       
    }

    function index() {
        Index::__construct();
    }
    
    function carisatu() {
        $us = $_POST['masukan'];
        
        $this->loadModel("Penyakit");
        $ambil = $this->model->getpenyakit($us);
        $masukindums = '';
        $masukan;
        foreach ($ambil as $key => $value) {
           $masukindums = $masukindums . '
                            <tr>
                                <td >
                                    '.$value[1] .'
                                </td>
                              
                            </tr>';
           $masukan = $value[0];
        }
        $this->view->judul=$masukan;
        $this->view->isi=$masukindums;
        $this->view->title = "Service";
        $this->view->render('penyakit/detail', 1, 0);
    }
}
