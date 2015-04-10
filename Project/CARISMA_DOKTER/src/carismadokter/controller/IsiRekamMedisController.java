/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismadokter.controller;
import carismainterface.entity.Rekammedik;
import carismainterface.server.RekammedikService;
import java.rmi.RemoteException;
/**
 *
 * @author User
 */

public class IsiRekamMedisController {
    
    private RekammedikService rekamMedikService;
    
    public IsiRekamMedisController(ClientSocket client) throws RemoteException{
        rekamMedikService = client.getRekamMedikService();
    }
    
    public void insertRekamMedis(String idRekammedik, String nama) throws RemoteException{
        Rekammedik rekamMedik = new Rekammedik();
        rekamMedik.setIdRekammedik(idRekammedik);
        rekamMedik.setDokterIdDokter(nama);
        rekamMedikService.insertRekamMedik(rekamMedik);
    }
    
    public Rekammedik getIdDokter(){
        Rekammedik rekamMedik = new Rekammedik();
        rekamMedik.getIdRekammedik();
        return rekamMedik;
    }
}
