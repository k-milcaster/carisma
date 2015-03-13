package carismainterface.entity;

import carismainterface.entity.Kamar;
import carismainterface.entity.Pasien;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-09T19:38:35")
@StaticMetamodel(PasienKamar.class)
public class PasienKamar_ { 

    public static volatile SingularAttribute<PasienKamar, Kamar> kamarIdKamar;
    public static volatile SingularAttribute<PasienKamar, String> keterangan;
    public static volatile SingularAttribute<PasienKamar, Pasien> pasienIdPasien;
    public static volatile SingularAttribute<PasienKamar, String> idPeminjaman;
    public static volatile SingularAttribute<PasienKamar, Date> dateinPasienKamar;
    public static volatile SingularAttribute<PasienKamar, Date> dateoutPasienKamar;

}