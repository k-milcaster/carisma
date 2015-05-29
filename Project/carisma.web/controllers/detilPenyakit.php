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
        $ambil = $this->model->getgrouppedpenyakit($us);
        $masukindums = '';
        $masukan;
        foreach ($ambil as $key => $value) {
           $masukindums = $masukindums . '
                            
                    <table >
                            <tr>
                                <td>
                               Hasil Untuk Penyakit dengan Inisial ' . $us . '
                                </td>
                                
                            </tr>
                            <tr>
                                <td >
                                    '.$value[0] .'
                                </td>
                                <td >
                                    '.$value[1] .'
                                </td>
                              
                            </tr>

                    </table>';
           $masukan = $value[0];
        }
//        $this->view->judul=$masukan;
        $this->view->isi=$masukindums;
        $this->view->title = "Service";
        $this->view->render('penyakit/detail', 1, 0);
    }
}


//