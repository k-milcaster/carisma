package carismadokter.controller;

import carismainterface.server.RekammedikpenyakitService;
import java.rmi.RemoteException;
import carismainterface.entity.Rekammedikpenyakit;



public class PenyakitRekamMedis {
    
    private RekammedikpenyakitService rekamMedisPenyakitService;
    
    public PenyakitRekamMedis(ClientSocket client) throws RemoteException{
        rekamMedisPenyakitService = client.getRekamMedisService();
    }
    
    public void insertRekamMedisPenyakit(String idRekamMedis, String idPenyakit) throws RemoteException{
        Rekammedikpenyakit rekamMedisPenyakit = new Rekammedikpenyakit();
        rekamMedisPenyakit.setRekammedikIdRekammedik(idRekamMedis);
        rekamMedisPenyakit.setRekammedikIdRekammedik(idPenyakit);
        rekamMedisPenyakitService.insertRekamMedikPenyakit(rekamMedisPenyakit);
    }
}
