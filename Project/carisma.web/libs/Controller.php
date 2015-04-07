<?php

class Controller {

    function __construct() {
        $this->view = new View();
    }
    public function loadModel($arg){
        $path = 'models/'. $arg .'_Model.php';
        
        if (file_exists($path)) {
            require $path;
            $modelName = $arg .'_Model';
            $this->model = new $modelName();
        }
    } 
}