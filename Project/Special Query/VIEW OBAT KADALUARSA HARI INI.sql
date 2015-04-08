SELECT d.id_detail, o.nama_obat
FROM obat o, detailobat d
WHERE d.obat_id_obat = o.id_obat AND d.tglkadaluarsa_detail >= curdate();