<!----start-slider-script---->
<script src="<?php echo URL; ?>public/js/responsiveslides.min.js"></script>
<script>
    // You can also use "$(window).load(function() {"
    $(function () {
        // Slideshow 4
        $("#slider4").responsiveSlides({
            auto: true,
            pager: true,
            nav: true,
            speed: 500,
            namespace: "callbacks",
            before: function () {
                $('.events').append("<li>before event fired.</li>");
            },
            after: function () {
                $('.events').append("<li>after event fired.</li>");
            }
        });

    });
</script>
<!----//End-slider-script---->
<!-- Slideshow 4 -->
<div  id="top" class="callbacks_container">
    <ul class="rslides" id="slider4">
        <li>
            <img src="<?php echo URL; ?>public/images/slide1.jpg" alt="">
            <div class="caption">
                <div class="slide-text-info">
                    <h1>providing</h1>
                    <label>highquality doctors</label>
                    <a class="slide-btn" href="#team" >learn more</a>
                </div>
            </div>
        </li>
        <li>
            <img src="<?php echo URL; ?>public/images/slide1.jpg" alt="">
            <div class="caption">
                <div class="slide-text-info">
                    <h1>featuring</h1>
                    <label>highquality service for men & women</label>
                    <a class="slide-btn" href="#">learn more</a>
                </div>
            </div>
        </li>
        <li>
            <img src="<?php echo URL; ?>public/images/slide1.jpg" alt="">
            <div class="caption">
                <div class="slide-text-info">
                    <h1>integrated</h1>
                    <label>highquality service for men & women</label>
                    <a class="slide-btn" href="#">learn more</a>
                </div>
            </div>
        </li>
    </ul>
</div>
<div class="clearfix"> </div>
<!----- //End-slider---->
<!--- team --->
<div>
<div id="team" class="team">
    <div class="container">
        <div class="header team-head text-center">
            <h2>doctors</h2>
            <p>Para dokter yang sudah terlatih di carisma</p>
        </div>
        <!--- teammember-grids ---->
                <?php
 echo $this->ini
         ?>
        <a class="slide-btn" href="<?php echo URL; ?>doctor/">more . . .</a>
        <!---//teammember-grids ---->
    </div>
<div class="clearfix"> </div>
</div>
    <div class="clearfix"> </div>
</div>
<!--- team --->

<!--- services --->
<div id="services" class="services">
    <div class="container">
        <div class="header services-header text-center">
            <h2>Jenis Penyakit</h2>
            <p>Ensiklopedia Penyakit yang ada di Indonesia menurut kategorinya</p>
        </div>
        <!---- service-grids--->
        <div class="service-grids">
            <div class="col-md-3">
                <div class="service-grid text-center">
                    <a href="#"><span class="s1-icon"> </span></a>
                    <h3><a href="#">Heart problem</a></h3>
                </div>
            </div>
            <div class="col-md-3">
                <div class="service-grid text-center">
                    <a href="#"><span class="s2-icon"> </span></a>
                    <h3><a href="#">brain problem</a></h3>
                </div>
            </div>
            <div class="col-md-3">
                <div class="service-grid text-center">
                    <a href="#"><span class="s3-icon"> </span></a>
                    <h3><a href="#">knee problem</a></h3>
                </div>
            </div>
            <div class="col-md-3">
                <div class="service-grid text-center">
                    <a href="#"><span class="s4-icon"> </span></a>
                    <h3><a href="#">human bones problem</a></h3>
                </div>
            </div>
            
            <div class="col-md-1 contact-grid-left">
                        
                    </div>
           <div class="col-md-1 contact-grid-right">
               <br>
               <a href="<?php echo URL; ?>penyakit/">   <input type="submit" value="CARI DETAIL PENYAKIT ANDA" /></a>
                        </div>
            
            
            
            <div class="clearfix"> </div>
        </div>
        <!----//service-grids--->
    </div>

</div>

<!--- services --->
<!---- about ---->
<div id="about" class="about">
    <div class="container">
        <div class="header about-header text-center">
            <h2>about us</h2>
            <p>The Man That You know Who</p>
        </div>
        <!---- About-grids ---->
        <div class="about-grids">
            <div class="col-md-4">
                <div class="about-grid n-about-grid n-about-grid1">
                    <img src="<?php echo URL; ?>public/images/img1.jpg" title="name" />
                    <span class="t-icon1"> </span>
                    <div class="about-grid-info text-center">
                        <h3><a href="https://www.facebook.com/indra.kharisma.r">Indra Kharisma Raharjana</a></h3>
                        <p>Lecturer at Universitas Airlangga.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-8">
                <p>Penjelasan tentang Carisma</p>
                <br>
                <p>CARISMA (Clinical Information System Multi Functional). Yaitu sistem 
                    informasi terintegrasi yang berfungsi untuk memudahkan proses utama 
                    poliklinik sebagai health caring service serta dapat memanajemen karyawan 
                    dan tenaga medis (multi functional)</p>
                <br>
<!--                <p>Carisma Menawarkan Fitur Sistem Informasi Klinik meliputi</p>
                <br>
                <p>     1. Sistem Login Tiap Karyawan             || 6. Sistem Pencatatan Diagnosis Pasien</p>
                <p>     2. Sistem Absensi Pegawai                 || 7. Sistem Apoteker</p>
                <p>     3. Sistem Penggajian Karyawan dan Dokter  || 8. Sistem Antrian Pasien</p>
                <p>     4. Sistem Pendaftaran Pasien              || 9. Aplikasi Apoteker</p>
                <p>     5. Aplikasi Dokter                        || 10. Sistem Rekam medis Pasien</p>-->
               


                
            </div>
            
            <div class="clearfix"> </div>
        </div>
        <!---- About-grids ---->
    </div>
</div>
<!---- about ---->

<!---- contact ---->
<div id="contact" class="contact">
    <div class="map">
        <iframe src="" > </iframe>
        <div class="contact-info">
            <div class="container">
                <!---- contact-grids ---->
                <div class="contact-grids">
                    <h3>contact us</h3>
                    <div class="col-md-5 contact-grid-left">
                        <h4>contact information</h4>
                        <ul>
                            <li><span class="cal"> </span><label>Monday - Friday :</label><small>9:30 AM to 6:30 PM</small></li>
                            <li><span class="pin"> </span><label>Address :</label><small>123 Some Street , London, UK, CP 123</small></li>
                            <li><span class="phone"> </span><label>Phone :</label><small>(032) 987-1235</small></li>
                            <li><span class="fax"> </span><label>Fax :</label><small>(123) 984-1234</small></li>
                            <li><span class="mail"> </span><label>Email :</label><small> info@doctor.com</small></li>
                        </ul>
                    </div>
                    <div class="col-md-7 contact-grid-right">
                        <h4>leave us a message</h4>
                        <form>
                            <input type="text" value="Name:" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                                                    this.value = 'Name:';
                                                                                }">
                            <input type="text" value="Email:" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                                                    this.value = 'Email:';
                                                                                }">
                            <input type="text" value="Phone No:" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                                                    this.value = 'Phone No:';
                                                                                }">
                            <textarea rows="2" cols="70" onfocus="if (this.value == 'Message:')
                                                                                    this.value = '';" onblur="if (this.value == '')
                                                                                                this.value = 'Message:';">Message:</textarea>
                            <input type="submit" value="SEND MESSAGE" />
                        </form>
                    </div>
                    <div class="clearfix"> </div>
                </div>
                <!---- contact-grids ---->
            </div>
        </div>
    </div>
</div>
<!---- contact ---->
<div class="clearfix"> </div>