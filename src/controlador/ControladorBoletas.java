/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Boleta;
import modelo.Excepcion;


import vista.Boletas;
import vista.ModificarBoleta;


/**
 *
 * @author yerko
 */
public class ControladorBoletas {
        //private Vista vista;
    Boletas vista;
    private Boleta modelo;
   
    
    
    public ControladorBoletas(Boletas v, Boleta m)
    {
        this.vista = v;
        this.modelo = m;        
    }
    
    
    
     public void inicializar() throws InstantiationException, IllegalAccessException, Exception
    {
        this.vista.setVisible(true);
        this.read();
        
        
        this.vista.getjButton2().addActionListener( e-> {
            try {
                read();
            } catch (Exception ex) {
                Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.vista.getModificar().addActionListener( e-> {
            try {
                update();
            } catch (Exception ex) {
                Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        });
        this.vista.getjButton4().addActionListener( e-> {
            try {
                delete();
            } catch (Exception ex) {
                Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.vista.setVisible(true);
        
    }
   
     
     
     
     
     public void read() {
        try 
        {   
             ArrayList al = null;
             if(this.vista.getCuadroTexto().getText().isEmpty())
            {
                al = this.modelo.read();
            }
             else
             {
                 String rutCliente = this.vista.getCuadroTexto().getText().trim();
                 al =  this.modelo.readConWhere(" where rutCliente like '%" + rutCliente + "%'");
                 
             }
             this.vista.llenarTablas(al);
            
        } 
        
        catch (com.mysql.jdbc.exceptions.jdbc4.CommunicationsException ex)
        {
            JOptionPane.showMessageDialog(null, "Posible falla del servidor BD, puede que no este dando el servicio o hay un problema con la red. Intente nuevamente o llame a soporte. ");
        }
        catch (Excepcion ex)
        {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        catch (Exception ex)
        {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }    
     }
     public void update()
     {
                 DefaultTableModel m = (DefaultTableModel) this.vista.getjTable1().getModel();
        int filas = m.getRowCount();
        if (filas>0)
        {
            if (this.vista.getjTable1().getSelectedRow()==-1)
            {
                JOptionPane.showMessageDialog(null, "Debe elejir una fila", "Informacion", JOptionPane.INFORMATION_MESSAGE + JOptionPane.OK_OPTION);
            }
            else
            {
                int fila = this.vista.getjTable1().getSelectedRow();
                
                int nroBoleta = (int) m.getValueAt(fila, 0);
                
                ModificarBoleta unaVista = new ModificarBoleta(null,false, nroBoleta);
                Boleta b = new Boleta();
                b.setNroBoleta(nroBoleta);
                
                ControladorModificarBoleta c = new ControladorModificarBoleta(unaVista, b);
                
                
                
                
                try {
                    c.inicializar();
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ControladorBoletas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ControladorBoletas.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No hay registros", "Información", JOptionPane.INFORMATION_MESSAGE + JOptionPane.OK_OPTION);    
        }
         
     }
     public void delete()
     {
        DefaultTableModel m = (DefaultTableModel) this.vista.getjTable1().getModel();
        int filas = m.getRowCount();
        if (filas>0)
        {
            if (this.vista.getjTable1().getSelectedRow()==-1)
            {
                JOptionPane.showMessageDialog(null, "Debe elejir una fila", "Informacion", JOptionPane.INFORMATION_MESSAGE + JOptionPane.OK_OPTION);
            }
            else
            {
                int fila = this.vista.getjTable1().getSelectedRow();
                int nroBoleta = (int) m.getValueAt(fila, 0);
                
                ModificarBoleta unaVista = new ModificarBoleta(null,false, nroBoleta);
                Boleta b = new Boleta();
                b.setNroBoleta(nroBoleta);
                
               try
               { 
                    if (JOptionPane.showConfirmDialog(null, "¿Seguro de eliminar boleta= ?" + b.getNroBoleta()+ "?", "Salir", JOptionPane.WARNING_MESSAGE + JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                    {
                        b.delete(b);
                        this.read();
                    }
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ControladorBoletas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ControladorBoletas.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No hay registros", "Información", JOptionPane.INFORMATION_MESSAGE + JOptionPane.OK_OPTION);    
        }
         
     }
}
