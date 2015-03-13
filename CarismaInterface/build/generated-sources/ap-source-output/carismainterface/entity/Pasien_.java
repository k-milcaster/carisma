package carismainterface.entity;

import carismainterface.entity.Antrian;
import carismainterface.entity.Kartupasien;
import carismainterface.entity.Kota;
import carismainterface.entity.Kunjungan;
import carismainterface.entity.PasienKamar;
import carismainterface.entity.Rekammedis;
import carismainterface.entity.Transaksijualobat;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-09T19:38:35")
@StaticMetamodel(Pasien.class)
public class Pasien_ { 

    public static volatile CollectionAttribute<Pasien, Antrian> antrianCollection;
    public static volatile CollectionAttribute<Pasien, Rekammedis> rekammedisCollection;
    public static volatile SingularAttribute<Pasien, String> alamatPasien;
    public static volatile SingularAttribute<Pasien, String> nokartuidPasien;
    public static volatile SingularAttribute<Pasien, Date> regdatePasien;
    public static volatile SingularAttribute<Pasien, String> darahPasien;
    public static volatile SingularAttribute<Pasien, String> namaPasien;
    public static volatile SingularAttribute<Pasien, Kota> kotaIdKota;
    public static volatile CollectionAttribute<Pasien, PasienKamar> pasienKamarCollection;
    public static volatile SingularAttribute<Pasien, String> idPasien;
    public static volatile CollectionAttribute<Pasien, Kunjungan> kunjunganCollection;
    public static volatile SingularAttribute<Pasien, String> kelaminPasien;
    public static volatile SingularAttribute<Pasien, Date> tgllahirPasien;
    public static volatile CollectionAttribute<Pasien, Transaksijualobat> transaksijualobatCollection;
    public static volatile SingularAttribute<Pasien, String> kartuidPasien;
    public static volatile SingularAttribute<Pasien, String> telpPasien;
    public static volatile SingularAttribute<Pasien, String> tempatlahirPasien;
    public static volatile SingularAttribute<Pasien, String> hpPasien;
    public static volatile SingularAttribute<Pasien, Kartupasien> kartupasien;

}