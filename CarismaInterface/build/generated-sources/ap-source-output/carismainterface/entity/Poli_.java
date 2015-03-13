package carismainterface.entity;

import carismainterface.entity.Dokter;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-09T19:38:36")
@StaticMetamodel(Poli.class)
public class Poli_ { 

    public static volatile SingularAttribute<Poli, String> namaPoli;
    public static volatile CollectionAttribute<Poli, Dokter> dokterCollection;
    public static volatile SingularAttribute<Poli, String> keterangan;
    public static volatile SingularAttribute<Poli, String> idPoli;

}