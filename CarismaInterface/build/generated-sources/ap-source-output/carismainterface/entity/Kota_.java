package carismainterface.entity;

import carismainterface.entity.KotaPK;
import carismainterface.entity.Pasien;
import carismainterface.entity.Provinsi;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-09T19:38:36")
@StaticMetamodel(Kota.class)
public class Kota_ { 

    public static volatile SingularAttribute<Kota, Provinsi> provinsi;
    public static volatile SingularAttribute<Kota, KotaPK> kotaPK;
    public static volatile CollectionAttribute<Kota, Pasien> pasienCollection;
    public static volatile SingularAttribute<Kota, String> namaKota;

}