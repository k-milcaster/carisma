


<div id="about" class="about">
    <div class="container">
        <div class="header about-header text-center">
            <h2>Deskripsi Penyakit </h2>
            
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
                        <p>Deskripsi Penyakit <?php echo $this->judul ?></p>
                    </div>
                </div>
            </div>
            <div class="col-md-8">
                
                
                    <div class="about-grid-info text-center">
                        <table >
                            <tr>
                                <td>
                                   <?php echo $this->judul ?>
                                </td>
                                
                            </tr>
                            
<?php echo $this->isi ?> 
                        </table>
                    </div>
                </div>
            </div>
            <!--</div>-->


            <!---- About-grids ---->
        </div>
</div>    <!---- about ---->