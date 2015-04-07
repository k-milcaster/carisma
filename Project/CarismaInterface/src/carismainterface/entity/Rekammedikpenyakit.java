package carismainterface.entity;

/**
 *
 * @author K-MiL Caster
 */
public class Rekammedikpenyakit {

    private String rekammedikIdRekammedik;
    private String penyakitIdPenyakit;

    public Rekammedikpenyakit() {

    }

    public Rekammedikpenyakit(String rekammedikIdRekammedik, String penyakitIdPenyakit) {
        this.rekammedikIdRekammedik = rekammedikIdRekammedik;
        this.penyakitIdPenyakit = penyakitIdPenyakit;
    }

    public void setRekammedikIdRekammedik(String rekammedikIdRekammedik) {
        this.rekammedikIdRekammedik = rekammedikIdRekammedik;
    }

    public String getRekammedikIdRekammedik() {
        return this.rekammedikIdRekammedik;
    }

    public void setPenyakitIdPenyakit(String penyakitIdPenyakit) {
        this.penyakitIdPenyakit = penyakitIdPenyakit;
    }

    public String getPenyakitIdPenyakit() {
        return this.penyakitIdPenyakit;
    }
}
