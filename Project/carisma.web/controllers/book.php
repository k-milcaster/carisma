<?php

class Book extends Controller {

    function __construct() {
        parent::__construct();
        Session::init();
        $this->index();
    }

    function index() {
        $this->view->title = "Doctors";
        $this->view->render('doctor/book', 1, 0);
    }

    function doBook() {
        $this->loadModel('Login');
        $temp = $this->model->getIdUser(Session::get('id'));
        $iduser = '';
        foreach ($temp as $key => $value) {
            $iduser = $value[0];
        }
        $this->loadModel('antrian');
        $getCount = $this->model->getCountAntrian();
        foreach ($getCount as $key => $value) {
            $count = $value[0];
        }
        $count = $count + 1;
        if ($count < 10) {
            $id = 'O00' . $count;
        } else if ($count >= 10) {
            $id = 'O0' . $count;
        } else {
            $id = 'O' . $count;
        }
        $idDokter = $_POST['idDokter'];
        $temp = $this->model->getLastNomorAntrian();
        foreach ($temp as $key => $value) {
            $noAntrian = $value[0];
        }
        $noAntrian = $noAntrian + 1;
        $tgl = $_POST['av'];
        $this->model->insertAntrian($id, $iduser, $idDokter, $noAntrian, 'ONLINE', $tgl);
    }

}
