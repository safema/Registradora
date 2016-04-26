/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regitradora.ejb;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import registradora.entity.Asociado;



/**
 *
 * @author mario
 */
@Stateless
@Stateful
public class AsociadoEjb {
    
    private Integer currentOrder;
    private Integer newOrderId;
    private String selectedNombre;
    private char newOrderStatus;
    private int newOrderDiscount;
    
    private List<String> asociadoSearchResults;
    private String asociadoName;
    private int selectedPartRevision;
    private Long selectedVendorPartNumber;
    private Boolean findAsociadobleDisabled = false;
    private Boolean partsTableDisabled = true;
    @PersistenceContext
    private EntityManager em;
    
    
    private static final Logger logger =
            Logger.getLogger("registradora.ejb.asociadoEjb");
 
    
    public List<String> buscarAsoaciadoPorNombre(String name) {
        
        List<String> names = new ArrayList<>();
        try {
            List vendors = em.createNamedQuery(
                    "Asociado.findByNombre")
                    .setParameter("name", name)
                    .getResultList();
            for (Iterator iterator = vendors.iterator(); iterator.hasNext();) {
                Asociado asociado = (Asociado)iterator.next();
                names.add(asociado.getNombre());
            }
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
        return names;
    }

    
}
