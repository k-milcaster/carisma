/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaapoteker.controller;

import carismainterface.entity.Obat;
import carismainterface.server.ObatService;

/**
 *
 * @author Hana Mahrifah
 */
public class StokObatServiceController {
    private ObatService obat;
    
    public StokObatServiceController (ClientSocket client){
        Obat obat = new Obat();
        this.obat = client.getObatService();
        
    }
   
}
