package carismainterface.entity;

import carismainterface.entity.Antrian;
import carismainterface.entity.Jadwaldokter;
import carismainterface.entity.Poli;
import carismainterface.entity.Rekammedis;
import carismainterface.entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-09T19:38:36")
@StaticMetamodel(Dokter.class)
public class Dokter_ { 

    public static volatile SingularAttribute<Dokter, Double> gajikonsulDokter;
    public static volatile SingularAttribute<Dokter, String> namaDokter;
    public static volatile SingularAttribute<Dokter, String> bankDokter;
    public static volatile SingularAttribute<Dokter, Poli> poliIdPoli;
    public static volatile CollectionAttribute<Dokter, Antrian> antrianCollection;
    public static volatile CollectionAttribute<Dokter, Rekammedis> rekammedisCollection;
    public static volatile SingularAttribute<Dokter, User> userUsername;
    public static volatile SingularAttribute<Dokter, String> alamatDokter;
    public static volatile SingularAttribute<Dokter, String> hp1Dokter;
    public static volatile SingularAttribute<Dokter, String> kelaminDokter;
    public static volatile SingularAttribute<Dokter, Jadwaldokter> jadwaldokter;
    public static volatile SingularAttribute<Dokter, String> darahDokter;
    public static volatile SingularAttribute<Dokter, Integer> gajilemburDokter;
    public static volatile SingularAttribute<Dokter, String> telpDokter;
    public static volatile SingularAttribute<Dokter, String> norekDokter;
    public static volatile SingularAttribute<Dokter, Integer> gajifixDokter;
    public static volatile SingularAttribute<Dokter, Date> tgllahirDokter;
    public static volatile SingularAttribute<Dokter, String> idDokter;
    public static volatile SingularAttribute<Dokter, String> nokartuidDokter;
    public static volatile SingularAttribute<Dokter, String> hp2Dokter;
    public static volatile SingularAttribute<Dokter, String> tempatlahirDokter;
    public static volatile SingularAttribute<Dokter, byte[]> fotoDokter;

}