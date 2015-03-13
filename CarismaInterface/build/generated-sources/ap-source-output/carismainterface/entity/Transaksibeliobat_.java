package carismainterface.entity;

import carismainterface.entity.Detailtransaksibeliobat;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-09T19:38:35")
@StaticMetamodel(Transaksibeliobat.class)
public class Transaksibeliobat_ { 

    public static volatile CollectionAttribute<Transaksibeliobat, Detailtransaksibeliobat> detailtransaksibeliobatCollection;
    public static volatile SingularAttribute<Transaksibeliobat, String> keterangan;
    public static volatile SingularAttribute<Transaksibeliobat, String> idTransaksibeliobat;
    public static volatile SingularAttribute<Transaksibeliobat, Date> dateTransaksibeli;

}