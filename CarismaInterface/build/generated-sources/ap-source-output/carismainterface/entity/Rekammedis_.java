package carismainterface.entity;

import carismainterface.entity.Dokter;
import carismainterface.entity.Kunjungan;
import carismainterface.entity.Pasien;
import carismainterface.entity.Penyakit;
import carismainterface.entity.Resep;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-09T19:38:36")
@StaticMetamodel(Rekammedis.class)
public class Rekammedis_ { 

    public static volatile CollectionAttribute<Rekammedis, Penyakit> penyakitCollection;
    public static volatile SingularAttribute<Rekammedis, String> kesimpulanRekammedis;
    public static volatile SingularAttribute<Rekammedis, String> alergiobatRekammedis;
    public static volatile SingularAttribute<Rekammedis, String> pemeriksaanRekammedis;
    public static volatile SingularAttribute<Rekammedis, Resep> resepIdResep;
    public static volatile SingularAttribute<Rekammedis, String> idRekammedis;
    public static volatile SingularAttribute<Rekammedis, Dokter> dokterIdDokter;
    public static volatile SingularAttribute<Rekammedis, Date> tglRekammedis;
    public static volatile CollectionAttribute<Rekammedis, Kunjungan> kunjunganCollection;
    public static volatile SingularAttribute<Rekammedis, Pasien> pasienIdPasien;
    public static volatile SingularAttribute<Rekammedis, String> keluhanRekammedis;
    public static volatile SingularAttribute<Rekammedis, String> kondisipasienkeluarRekammedis;
    public static volatile SingularAttribute<Rekammedis, String> terapiRekammedis;

}