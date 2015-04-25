<div id="about" class="about">
    <div class="container">
        <div class="header about-header text-center">
            <h2>Dashboard </h2>
            
        </div>
        <!---- About-grids ---->
        <div class="about-grids">
            <div class="col-md-4">
                <div class="about-grid n-about-grid n-about-grid1">
                    <img src="<?php echo URL; ?>public/images/img3.jpg" title="name" />
                    <span class="t-icon1"> </span>
                    <div class="about-grid-info text-center">
                        <h3><a href="https://www.facebook.com/indra.kharisma.r"><?php
                echo  Session::get('id');
                ?></a></h3>
                        <p>Pasien Rumah sakit Carisma</p>
                    </div>
                </div>
            </div>
            <div class="col-md-8">
                <p>Kunjungan Terakhir Sdr <?php
                echo Session::get('id');
                ?></p>
                
                    <div class="about-grid-info text-center">
                        <table >
                            <tr>
                                <td>
                                    Tanggal Kunjungan
                                </td>
                                <td >
                                    Keluhan pada saat berkunjung
                                </td>
                                <td>
                                    Nama Dokter yang Menangani
                                </td>
                            </tr>
                            
<?php echo $this->ini ?> 
                        </table>
                    </div>
                </div>
            </div>
            <!--</div>-->


            <!---- About-grids ---->
        </div>
</div>    <!---- about ---->