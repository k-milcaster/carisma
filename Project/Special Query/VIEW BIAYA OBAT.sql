SELECT h.hargajual_obat * dt.qty as harga
FROM obat h, detailtransaksijualobat dt, transaksijualobat t, kunjungan k
WHERE k.transaksijualobat_id_transaksijual = t.id_transaksijual AND t.id_transaksijual = dt.transaksijualobat_id_transaksijual AND dt.obat_id_obat = h.id_obat;