<html>
    <head>
    </head>

    <body style="background: url(<?php echo URL ?>public/images/back.jpg); background-repeat: no-repeat;">

        <h1 style="font-family: sans-serif; color: #2B2B2B; font-size: 100px; padding-top: 100px; padding-left: 100px;" align="left"><?php echo $this->no; ?></h1>
        <p style="font-family: sans-serif; color: #333; padding-top: 175px;">NB : Cetak dan bawalah bukti pendaftaran antrian ini</p>
        <br>
        <button onclick="myFunction()">CETAK!</button>

        <script>
            function myFunction() {
                window.print();
            }
        </script>

    </body>

</html>