<?php

class Bootstrap {

    function __construct() {


        if (empty($_GET['url'])) {
            require 'controllers/index.php';
            $controller = new Index();
            return false;
        }
        $url = $_GET['url'];
        $url = rtrim($url, '/');
        $url = explode('/', $url);
        $file = 'controllers/' . $url[0] . '.php';

        if (file_exists($file)) {
            require $file;
        } else {
            require 'controllers/error.php';
            $controller = new Error();
            return false;
        }

        $controller = new $url[0];
        
        if ($url[0] === 'administrator' && !isset($url[1])) {
            $controller->loadModel($url[0]);
            $controller->index();
        } else if ($url[0] === 'notification') {
            $controller->{$url[1]}($url[2], $url[3]);
        } else {            
            if (isset($url[2])) {
                $controller->{$url[1]}($url[2]);
            } else {
                if (isset($url[1])) {
                    $controller->{$url[1]}();
                }
            }
        }
    }

}

?>