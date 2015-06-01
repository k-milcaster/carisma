<?php

class singleDoctor extends Controller {

    function __construct() {
        parent::__construct();
        Session::init();        
//        $this->single();
    }

    function id($param) {
        $masukindums = "";

        $this->loadModel("Dokter");
//        $this->loadModel("Jadwaldokter");
        $rak = $this->model->getDokter($param);
        $rakdua = $this->model->getJadwalDokter($param);
        foreach ($rak as $key => $value) {
            $masukindums = $masukindums . '<div class="container">
        <div class="header about-header text-center">
            <h2>' . $value[3] . '</h2>
            <p>detail about ' . $value[3] . '</p>
        </div>
        <!---- About-grids ---->
        <div class="about-grids">
            <div class="col-md-4">
                <div class="about-grid n-about-grid n-about-grid1">
                    <img src="data:image/jpeg;base64,'.base64_encode( $value[15] ).'"/>
                    <span class="t-icon2"> </span>
                    <div class="about-grid-info text-center">
                        <h3><a href="#">' . $value[3] . '</a></h3>
                    </div>
                </div>
            </div>
            <div class="col-md-8">
                <p>Specialist : ' . $value[19] . '<br>
                        Address : ' . $value[4] . '<br>
                        Phone : ' . $value[6] . ' <br>
                        Sex : ' . $value[11] . ' <br>
                        Blood : ' . $value[12] . ' <br>
                        <br>';
            $masukindums = $masukindums . 'Schedule  =  ';
            foreach ($rakdua as $key => $values) {
                $masukindums = $masukindums . ' ' . $values[1] . ' || ' . $values[2] . ';';
            }
            $masukindums = $masukindums . '</p> <a href="' . URL . 'book/form/' . $value[0] . '">BOOK NOW!!</a>               
            </div>
            <div class="clearfix"> </div>
        </div>
        <!---- About-grids ---->
    </div>';
        }



        // $masukindums = $masukindums . '';
        $this->view->ini = $masukindums;
        $this->view->title = "Doctors";
        $this->view->render('doctor/single', 1, 0);
    }

}
