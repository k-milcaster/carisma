package carismainterface.entity;

import carismainterface.entity.Pasien;
import carismainterface.entity.Rekammedis;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-09T19:38:35")
@StaticMetamodel(Kunjungan.class)
public class Kunjungan_ { 

    public static volatile SingularAttribute<Kunjungan, String> idKunjungan;
    public static volatile SingularAttribute<Kunjungan, Integer> biayaKunjungan;
    public static volatile SingularAttribute<Kunjungan, Rekammedis> rekammedisIdRekammedis;
    public static volatile SingularAttribute<Kunjungan, Pasien> pasienIdPasien;
    public static volatile SingularAttribute<Kunjungan, Date> tanggaljamKunjungan;

}