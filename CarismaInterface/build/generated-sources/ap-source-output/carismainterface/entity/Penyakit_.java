package carismainterface.entity;

import carismainterface.entity.Rekammedis;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-09T19:38:35")
@StaticMetamodel(Penyakit.class)
public class Penyakit_ { 

    public static volatile SingularAttribute<Penyakit, String> idPenyakit;
    public static volatile CollectionAttribute<Penyakit, Rekammedis> rekammedisCollection;
    public static volatile SingularAttribute<Penyakit, String> namaPenyakit;
    public static volatile SingularAttribute<Penyakit, String> deskripsiPenyakit;

}