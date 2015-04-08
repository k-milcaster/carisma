SELECT (DATE(dateout_pasien_kamar) - DATE(datein_pasien_kamar)) * (SELECT tarif from kamar r, pasien_kamar p where p.kamar_id_kamar = r.id_kamar)
FROM pasien_kamar p, kunjungan k
WHERE p.id_peminjaman = k.pasien_kamar_id_peminjaman;