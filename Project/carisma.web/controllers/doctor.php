<?php

class Doctor extends Controller {

    function __construct() {
        parent::__construct();
        Session::init();
        $this->index();
    }

    function index() {
        $this->loadModel("Dokter");
        $rak = $this->model->getAlldoctor();

        $masukindums = '<div class="team-member-grids">';
        $i = 1;
        foreach ($rak as $key => $value) {

            if ($i == 1) {
                $masukindums = $masukindums . '<div class="team-member-grid">
                <img src="http://localhost/carisma.web/public/images/t1.jpg" />
                <div class="team-member-info bottom-t-info">
                    <span> </span>
                    <h3><a href="#">' . $value[3] . '</a></h3>
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
                <div class="team-member-info bottom-t-info bottom-t-info-b">
                    <span> </span>
                    <h3><a href="#">' . $value[3] . '</a></h3>
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
                <img src="http://localhost/carisma.web/public/images/t2.jpg"/>
            </div>';
            }
            if ($i == 3) {
                $masukindums = $masukindums . '<div class="team-member-grid">
                <img src="http://localhost/carisma.web/public/images/t1.jpg" />
                <div class="team-member-info bottom-t-info">
                    <span> </span>
                    <h3><a href="#">' . $value[3] . '</a></h3>
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
                   <h3><a href="#">' . $value[3] . '</a></h3>
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
                <img src="http://localhost/carisma.web/public/images/t2.jpg" title="name" />
            </div>';
            }
            if ($i == 5) {
                $masukindums = $masukindums . '<div class="team-member-grid">
                <img src="http://localhost/carisma.web/public/images/t1.jpg" title="name" />
                <div class="team-member-info bottom-t-info">
                    <span> </span>
                    <h3><a href="#">' . $value[3] . '</a></h3>
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



            $i++;
        }

        $masukindums = $masukindums . '</div>';

        $this->view->ini = $masukindums;
        $this->view->title = "Doctors";
        $this->view->render('doctor/index', 1, 0);
    }

}
