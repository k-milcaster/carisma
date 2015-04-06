<?php

class View {

    function __construct() {
        
    }

    public function render($name, $includeHeader, $index) {
        if ($index) {
            require_once 'views/headerIndex.php';
            require_once 'views/index/index.php';
            require_once 'views/footer.php';
        } else {
            if ($includeHeader) {
                require_once 'views/header.php';
                require_once 'views/' . $name . '.php';
                require_once 'views/footer.php';
            } else {
                require_once 'views/' . $name . '.php';
            }
        }
    }

    public function renderAdm($name) {
        require 'views/headerAdmin.php';
        require 'views/' . $name . '.php';
        require 'views/footer.php';
    }

    public function renderSend($name, $param) {
        require 'views/' . $name . '.php';
    }

}
