package carismainterface.entity;

import carismainterface.entity.Detailtransaksijualobat;
import carismainterface.entity.Pasien;
import carismainterface.entity.TransaksijualobatPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-09T19:38:36")
@StaticMetamodel(Transaksijualobat.class)
public class Transaksijualobat_ { 

    public static volatile SingularAttribute<Transaksijualobat, String> keterangan;
    public static volatile SingularAttribute<Transaksijualobat, TransaksijualobatPK> transaksijualobatPK;
    public static volatile CollectionAttribute<Transaksijualobat, Detailtransaksijualobat> detailtransaksijualobatCollection;
    public static volatile SingularAttribute<Transaksijualobat, Pasien> pasien;
    public static volatile SingularAttribute<Transaksijualobat, Date> dateTransaksijual;

}