<?php

class Doctor extends Controller{

    function __construct() {
        parent::__construct();
        Session::init();
        $this->index();
    }

    function index() {
        $this->loadModel("Dokter");
        $rak = $this->model->getAllDoctor();

        $masukindums = "";
        $i = 1;

        foreach ($rak as $key => $value) {

            if ($i == 1) {
                $masukindums = $masukindums . '<div class="team-member-grids">';
                $masukindums = $masukindums . '<div class="team-member-grid">
                <a href="'.URL .'singleDoctor/id/'.$value[0].'"><img src="' . URL . 'public/images/t1.jpg"/></a>
                <div class="team-member-info bottom-t-info">
                    <span> </span>
                    <h3><a href="' . URL . 'singleDoctor/id/' . $value[0] . '">' . $value[3] . '</a></h3>
                    <p>Specialist : ' . $value[19] . ' <br>
                        Address : ' . $value[4] . ' <br>
                        Phone : ' . $value[6] . '<br>
                        Sex : ' . $value[11] . '<br>
                        Blood : ' . $value[12] . '<br>
                        <br>
                        <br>                                                        
                    </p>
                </div>
                </div>';
            }

            if ($i == 2) {
                $masukindums = $masukindums . '<div class="team-member-grid">
                <a href="'.URL .'singleDoctor/id/'.$value[0].'"><img src="http://localhost/carisma.web/public/images/t1.jpg" />
                <div class="team-member-info bottom-t-info">
                    <span> </span>
                    <h3><a href="' . URL . 'singleDoctor/id/' . $value[0] . '">' . $value[3] . '</a></h3>
                    <p>Specialist : ' . $value[19] . ' <br>
                        Address : ' . $value[4] . ' <br>
                        Phone : ' . $value[6] . '<br>
                        Sex : ' . $value[11] . '<br>
                        Blood : ' . $value[12] . '<br>
                        <br>
                        <br>                                                         
                    </p>
                </div>
                </div>';
            }
            if ($i == 3) {
                $masukindums = $masukindums . '<div class="team-member-grid">
                <a href="'.URL .'singleDoctor/id/'.$value[0].'"><img src="http://localhost/carisma.web/public/images/t1.jpg" />
                <div class="team-member-info bottom-t-info">
                    <span> </span>
                    <h3><a href="' . URL . 'singleDoctor/id/' . $value[0] . '">' . $value[3] . '</a></h3>
                    <p>Specialist : ' . $value[19] . ' <br>
                        Address : ' . $value[4] . ' <br>
                        Phone : ' . $value[6] . '<br>
                        Sex : ' . $value[11] . '<br>
                        Blood : ' . $value[12] . '<br>
                        <br>
                        <br>                                                         
                    </p>
                </div>
                </div>';
            }
            if ($i == 4) {
                $masukindums = $masukindums .
                        '<div class="team-member-grid">
                <div class="team-member-info bottom-t-info bottom-t-info-b">
                    <span> </span>
                   <h3><a href="' . URL . 'singleDoctor/id/' . $value[0] . '">' . $value[3] . '</a></h3>
                    <p>Specialist : ' . $value[19] . ' <br>
                        Address : ' . $value[4] . ' <br>
                        Phone : ' . $value[6] . '<br>
                        Sex : ' . $value[11] . '<br>
                        Blood : ' . $value[12] . '<br>
                        <br>
                        <br>                            
                        <br>
                        </p>
                </div>
                <a href="'.URL .'singleDoctor/id/'.$value[0].'"><img src="' . URL . 'public/images/t2.jpg" title="name" />
            </div>';
            }
            if ($i == 5) {
                $masukindums = $masukindums . '<div class="team-member-grid">
                <a href="'.URL .'singleDoctor/id/'.$value[0].'"><img src="' . URL . 'public/images/t1.jpg" title="name" />
                <div class="team-member-info bottom-t-info">
                    <span> </span>
                    <h3><a href="' . URL . 'singleDoctor/id/' . $value[0] . '">' . $value[3] . '</a></h3>
                    <p>Specialist : ' . $value[19] . ' <br>
                        Address : ' . $value[4] . ' <br>
                        Phone : ' . $value[6] . '<br>
                        Sex : ' . $value[11] . '<br>
                        Blood : ' . $value[12] . '<br>
                        <br>
                        <br>                                                
                    </p>
                </div>
                <div class="clearfix"> </div>
                </div>
                <div class="clearfix"> </div>
                </div>';
                
                $masukindums=$masukindums.'<div class="clearfix"> </div>';
                $i = 0;
                $masukindums=$masukindums.'<div class="clearfix"> </div>';
            }
            $i++;
        }

        $masukindums = $masukindums . '';

        $this->view->ini = $masukindums;
        $this->view->title = "Doctors";
        $this->view->render('doctor/index', 1, 0);
    }

}
