<?php 

echo $this->ini;
        
?>        
                            <div class="col-md-7 contact-grid-right">
                    <h3>Cari Penyakit</h3>
<br>                
                        
                        <form method="post" action="<?php echo URL ?>detilPenyakit/carisatu">
                            <input type="text" name="masukan" value="Username:" onfocus="this.value = '';" onblur="if (this.value == '') {
                                        this.value = 'Username:';
                                    }">
                                    
                            <input type="submit" name="input" value="CARI PENYAKIT" />
                        </form>
                        
                        
                        
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>';

