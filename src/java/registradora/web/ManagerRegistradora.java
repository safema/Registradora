/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registradora.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;
import regitradora.ejb.AsociadoEjb;

/**
 *
 * @author mario
 */
@ManagedBean
@SessionScoped
public class ManagerRegistradora implements Serializable {   
    private static final long serialVersionUID = 2142383151318489373L;
    @EJB
    private AsociadoEjb asociado;
    private Boolean findAsociadoTableDisabled = false;
    private List<String> asociadoSearchResults;
    private String asociadoName;
    private static final Logger logger = Logger.getLogger("registradora.web.ManagerRegisrador");    
        
    public void findAsociado() {
        try {
            this.findAsociadoTableDisabled = true;
            this.asociadoSearchResults = (List<String>) asociado.buscarAsoaciadoPorNombre(asociadoName);
            logger.log(Level.INFO, "Encontrados {0} equipo(s).", 
                    new Object[]{asociadoSearchResults.size(), asociadoName});
        } catch (Exception e) {
            logger.warning("Problem calling RequestBean.locateVendorsByPartialName from findVendor");
        }
    }

    
    
    
}

    