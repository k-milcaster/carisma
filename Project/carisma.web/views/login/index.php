<div id="contact" class="contact">
    <div class="map">
        <div class="contact-info">
            <div class="container">
                <!---- contact-grids ---->
                <div class="contact-grids">
                    <div class="col-md-7 contact-grid-right">
                        <h3>Log In</h3> <?php
                    if (isset($this->ini)) {
                       // echo'<div class="col-md-5 contact-grid-left>';
                        echo '<h4>' . $this->ini . '</h4>';
                        //echo '</div>';
                    }
                    ?>
                        <form method="post" action="<?php echo URL ?>verifikasi/dologin">
                            <input type="text" name="username" value="Username:" onfocus="this.value = '';" onblur="if (this.value == '') {
                                        this.value = 'Username:';
                                    }">
                                    <input type="password" name="pass" placeholder="Password :">
                            <input type="submit" name="input" value="Log In" />
                        </form>
                        <div class="clearfix"> </div>
                    </div>
                   
                </div>
                <!---- contact-grids ---->
            </div>
        </div>
    </div>
</div>