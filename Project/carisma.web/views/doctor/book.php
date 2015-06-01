<div id="contact" class="contact">
    <div class="map">
        <iframe src="#" > </iframe>
        <div class="contact-info">
            <div class="container">
                <!---- contact-grids ---->
                <div class="contact-grids">
                    <h3>Booking Form</h3>
                    <div class="col-md-5 contact-grid-left">
                        <h4>Booking details</h4>
                        <ul>
                            <li><label>Patient    : <?php echo $this->namaPasien; ?></label></li>
                            <li><label>Doctor     : <?php echo $this->namaDokter; ?></label></li>
                            <li><label>Specialist : <?php echo $this->poli; ?></label></li>                            
                        </ul>
                    </div>
                    <div class="col-md-7 contact-grid-right">
                        <h4>Available Date</h4>
                        <form method="POST" action="<?php echo URL; ?>book/doBook">
                            <input type="hidden" name="idDokter" value="<?php echo $this->idDokter ?>">
                            <input type="hidden" name="idDokter" value="<?php echo $this->idDokter ?>">
                            <?php echo $this->choose; ?>
                            <input type="submit" value="SUBMIT" />
                        </form>
                    </div>
                    <div class="clearfix"> </div>
                </div>
                <!---- contact-grids ---->
            </div>
        </div>
    </div>
</div>