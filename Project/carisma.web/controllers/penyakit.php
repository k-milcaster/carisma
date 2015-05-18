<?php

class penyakit extends Controller {
    
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
                    <h3>Cari Penyakit</h3>
<br>                
                    <input type="text" name="cari">
                        <input type="submit" value="CARI PENYAKIT" />
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>';
        $masukindums = "";
        $masukindums = $masukindums .'<div id="contact" class="contact">
    <div class="map">
        <div class="contact-info">
            <div class="container">
                <div class="contact-grids">
                
                    <div class="col-md-7 contact-grid-right">
                    <h3>Cari Penyakit</h3>
<br>                
                    <input type="text" name="cari">
                        <input type="submit" value="CARI PENYAKIT" />
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>';
        $this->view->ini = $masukindums;
        $this->view->title = "Home";
        $this->view->render('penyakit/index', 1, 0);  
    
        
    } 
 
    function index(){
        Index::__construct();
    }
      
    
   
}