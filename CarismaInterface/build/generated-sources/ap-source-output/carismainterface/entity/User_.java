package carismainterface.entity;

import carismainterface.entity.Dokter;
import carismainterface.entity.Pegawai;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-09T19:38:35")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> username;
    public static volatile SingularAttribute<User, Date> registered;
    public static volatile CollectionAttribute<User, Dokter> dokterCollection;
    public static volatile SingularAttribute<User, Date> lastlogin;
    public static volatile SingularAttribute<User, String> role;
    public static volatile SingularAttribute<User, String> password;
    public static volatile CollectionAttribute<User, Pegawai> pegawaiCollection;

}