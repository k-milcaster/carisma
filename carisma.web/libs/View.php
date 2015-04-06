<?php

class View {

    function __construct() {
        
    }

    public function render($name, $includeHeader, $index) {
        if ($index) {
            require 'views/headerIndex.php';
            require 'views/index/index.php';
            require 'views/footer.php';            
        }
        else{
            if ($includeHeader){
                require 'views/header.php';
                require 'views/' . $name . '.php';
                require 'views/footer.php';                            
            }
            else{
                require 'views/' . $name . '.php';
            }
        }
    }    
    public function renderAdm($name) {
            require 'views/headerAdmin.php';
            require 'views/'. $name .'.php';
            require 'views/footer.php';                        
    }    
    public function renderSend($name, $param) {
        require 'views/' . $name . '.php';
    }
}
