package carismainterface.entity;

import carismainterface.entity.Obat;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-09T19:38:35")
@StaticMetamodel(Detailobat.class)
public class Detailobat_ { 

    public static volatile SingularAttribute<Detailobat, Integer> idDetail;
    public static volatile SingularAttribute<Detailobat, Date> tglkadaluarsaDetail;
    public static volatile SingularAttribute<Detailobat, Obat> obatIdObat;

}