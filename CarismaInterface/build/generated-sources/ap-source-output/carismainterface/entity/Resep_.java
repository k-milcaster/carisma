package carismainterface.entity;

import carismainterface.entity.Rekammedis;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-09T19:38:36")
@StaticMetamodel(Resep.class)
public class Resep_ { 

    public static volatile SingularAttribute<Resep, String> idResep;
    public static volatile CollectionAttribute<Resep, Rekammedis> rekammedisCollection;
    public static volatile SingularAttribute<Resep, String> keterangan;

}