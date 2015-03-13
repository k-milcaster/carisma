package carismainterface.entity;

import carismainterface.entity.Dokter;
import carismainterface.entity.Pasien;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-09T19:38:36")
@StaticMetamodel(Antrian.class)
public class Antrian_ { 

    public static volatile SingularAttribute<Antrian, String> jenisAntrian;
    public static volatile SingularAttribute<Antrian, Dokter> dokterIdDokter;
    public static volatile SingularAttribute<Antrian, String> idAntrian;
    public static volatile SingularAttribute<Antrian, Date> tglAntrian;
    public static volatile SingularAttribute<Antrian, Pasien> pasienIdPasien;
    public static volatile SingularAttribute<Antrian, Integer> nomorAntrian;

}