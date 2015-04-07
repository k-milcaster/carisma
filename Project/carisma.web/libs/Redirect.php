<?php
class Redirect extends View{
    public static function go($arg){                
          echo '<script>            
          location.href = "'.$arg.'"                
          </script>';
    }
    public static function notif($arg){
        $this->view->msg = $arg;
        $this->view->render('pages/notification');
    }
}