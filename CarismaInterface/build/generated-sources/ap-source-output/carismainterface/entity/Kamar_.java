package carismainterface.entity;

import carismainterface.entity.PasienKamar;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-09T19:38:36")
@StaticMetamodel(Kamar.class)
public class Kamar_ { 

    public static volatile SingularAttribute<Kamar, String> namaKamar;
    public static volatile SingularAttribute<Kamar, Integer> idKamar;
    public static volatile SingularAttribute<Kamar, String> kelas;
    public static volatile CollectionAttribute<Kamar, PasienKamar> pasienKamarCollection;
    public static volatile SingularAttribute<Kamar, Integer> tarif;

}