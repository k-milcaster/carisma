package carismainterface.entity;

import carismainterface.entity.Detailobat;
import carismainterface.entity.Detailtransaksibeliobat;
import carismainterface.entity.Detailtransaksijualobat;
import carismainterface.entity.Rakobat;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-09T19:38:35")
@StaticMetamodel(Obat.class)
public class Obat_ { 

    public static volatile SingularAttribute<Obat, String> jenisObat;
    public static volatile CollectionAttribute<Obat, Detailtransaksibeliobat> detailtransaksibeliobatCollection;
    public static volatile SingularAttribute<Obat, String> namaObat;
    public static volatile CollectionAttribute<Obat, Detailobat> detailobatCollection;
    public static volatile SingularAttribute<Obat, Integer> idObat;
    public static volatile SingularAttribute<Obat, String> keterangan;
    public static volatile CollectionAttribute<Obat, Rakobat> rakobatCollection;
    public static volatile CollectionAttribute<Obat, Detailtransaksijualobat> detailtransaksijualobatCollection;
    public static volatile SingularAttribute<Obat, Integer> qtyObat;
    public static volatile SingularAttribute<Obat, String> hargajualObat;

}