/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import static java.lang.Float.parseFloat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.JOptionPane;
import modelo.Boleta;

import modelo.Vendedor;

import vista.ModificarBoleta;





/**
 *
 * @author yerko
 */
public class ControladorModificarBoleta {
        //private Vista vista;
    ModificarBoleta vista;
    private Boleta modelo;
   
    
    
    public ControladorModificarBoleta(ModificarBoleta v, Boleta m)
    {
        this.vista = v;
        this.modelo = m;     
        
    }
    
    
    
     public void inicializar() throws InstantiationException, IllegalAccessException, Exception
    {
        this.vista.setVisible(true);
        Vendedor v = new Vendedor();
        ArrayList vendedores = v.read();
        
        this.vista.agregarVendedor(vendedores,this.modelo.getVendedorByNroBoleta(this.modelo.getNroBoleta()));
        this.vista.setearBoleta(modelo.getBoleta(modelo));
         
        this.vista.getAgregarBoleta().addActionListener( e-> {
            try {
               update();
               this.modelo.read();
            } catch (Exception ex) {
                Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }
   
     
     
     
     
     public void update() {
         int a = 0;
         Date fechaactual = new Date(System.currentTimeMillis());
         Boleta b = new Boleta();
         if(a==0);{
         
         String fechaCompra = this.vista.getFechaCompra().getText();
               SimpleDateFormat procesadorDeFechasStringChilensis = new SimpleDateFormat ("dd-MM-yyyy"); 
               Date fechaCompraTipoDate; 
               try {
                   
                    fechaCompraTipoDate = procesadorDeFechasStringChilensis.parse(fechaCompra);
                    b.setFechaCompra(fechaCompraTipoDate);
                    if (fechaCompraTipoDate.compareTo(fechaactual)>0) {
                         this.vista.errorFecha();
                         a++;                        
                    }
                    
                } catch (ParseException ex) {
                    this.vista.errorFecha();
                    a++;
                    }
         
         try
            {   
                if(parseFloat(this.vista.getCantidadPagar().getText()) <= 0){
                    this.vista.errorCantidadCompra();
                    
                    a++;
                }else{
                    float cantidadPagar = Float.parseFloat(this.vista.getCantidadPagar().getText());
                    b.setCantidadAPagar(cantidadPagar); 
                }
                
            }
            catch(NumberFormatException ex)
            {
                this.vista.errorCantidadCompra();
                a++;
            } 
         
         int nroBoleta = Integer.parseInt(this.vista.getjTextField1().getText());
            
            String rutCliente = this.vista.getRutCliente().getText();
            
            boolean mayor18Anios = false;
            if (this.vista.getjCheckBox1().isSelected())
            {
                mayor18Anios = true;
            }
            
        
            
            String metodoPago = null;
            
            if (this.vista.getjRadioButton1().isSelected())
            {
                metodoPago = "E";
            }
            if (this.vista.getjRadioButton2().isSelected())
            {
                metodoPago = "C";
            }
            if (this.vista.getjRadioButton3().isSelected())
            {
                metodoPago = "D";
            }

            
            String vendedorSelecto = null;
            int codigoVendedor = 0;
            String nombreVendedor = null;
            if (this.vista.getSelectVendedor().getModel().getSize() != 0) 
            {
                vendedorSelecto = (String)this.vista.getSelectVendedor().getSelectedItem();
                
                String corcheteAbiertoADerecha="[";
                String corcheteAbiertoAIzquierda="]";
                
                int dondeCorcheteAbiertoADerecha = vendedorSelecto.indexOf(corcheteAbiertoADerecha);
                int dondeCorcheteAbiertoAIzquierda = vendedorSelecto.indexOf(corcheteAbiertoAIzquierda);
                
                String codigoDentroDeLosCorchetes = vendedorSelecto.substring(dondeCorcheteAbiertoADerecha+1, dondeCorcheteAbiertoAIzquierda);
                codigoVendedor = Integer.parseInt(codigoDentroDeLosCorchetes);
                
                nombreVendedor = vendedorSelecto.substring(0, dondeCorcheteAbiertoADerecha).trim();
                
                b.setNroBoleta(nroBoleta);
                b.setRutCliente(rutCliente);
                b.setMayor18Anios(mayor18Anios);           
                b.setMetodoPago(metodoPago);            
                b.setId_vendedor(codigoVendedor);
                b.setVendedor(nombreVendedor);
            }
            if (a==0){
            try {
                this.modelo.update(b);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ControladorModificarBoleta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ControladorModificarBoleta.class.getName()).log(Level.SEVERE, null, ex);
            }
                JOptionPane.showMessageDialog(null, "registro AGREGADO");
                this.vista.setVisible(false);
                }
            
            
     }

     }
     
}
