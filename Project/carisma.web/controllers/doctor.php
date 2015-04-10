<?php

class Doctor extends Controller {

    function __construct() {
        parent::__construct();
        Session::init();
        $this->index();
    }

    
    
    function index() {
        $this->loadModel("Dokter");
        $rak=$this->model->getAlldoctor();
        
        $masukindums = '<div class="team-member-grids">
            
            </div>';
        $i = 1;
        foreach ($rak as $key => $value) {
            $masukindums = $masukindums . '<div class="team-member-grid">
                <img src="<?php echo URL; ?>public/images/t1.jpg" title="name" />
                <div class="team-member-info bottom-t-info">
                    <span> </span>
                    <h3><a href="#">'.$value[3].'</a></h3>
                    <p>Specialist : <br>
                        Origin : <br>
                        Phone : <br>
                        Sex : <br>
                        Blood : <br>
                        <br>
                        <br>                                                
                    </p>
                </div>';
        }
        
        $this->view->ini = $masukindums;                                
        $this->view->title = "Doctors";
        $this->view->render('doctor/index', 1, 0);
    
        
        
        
        
    }    
    
    
    
}
