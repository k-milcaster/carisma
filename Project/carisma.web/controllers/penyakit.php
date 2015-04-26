<?php

class error extends Controller {
    
    function __construct() {
        parent::__construct();
        Session::init();
            
       $masukindums = "";
        $masukindums = $masukindums .'<div id="contact" class="contact">
    <div class="map">
        <div class="contact-info">
            <div class="container">
                <div class="contact-grids">
                    <div class="col-md-7 contact-grid-right">
                        <h3>404 Not Found</h3> 
                        <h4> The requested URL 404 was not found on site.</h4>
                        <div class="clearfix"> </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>';
        $this->view->ini = $masukindums;
        $this->view->title = "Home";
        $this->view->render('error/index', 1, 0);  
    
        
    } 
 
    function index(){
        Index::__construct();
    }
      
    
   
}