/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import dao.BoletaDAOImpl;
import dao.CrudDAOable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author yerko
 */
public class Boleta {
    
   private int nroBoleta;
   private String rutCliente;
   private boolean mayor18Anios;
   private Date fechaCompra;
   private String metodoPago;
   private float cantidadAPagar;
   private String mayor;
   private int id_vendedor;
   private String vendedor;

    public Boleta() {
    }
    
    public Boleta(int nroBoleta, String rutCliente, String mayor, boolean mayor18Anios, Date fechaCompra, String metodoPago, float cantidadAPagar, int id_vendedor, String vendedor) {
        this.nroBoleta = nroBoleta;
        this.rutCliente = rutCliente;
        this.mayor18Anios = mayor18Anios;
        this.fechaCompra = fechaCompra;
        this.metodoPago = metodoPago;
        this.cantidadAPagar = cantidadAPagar;
        this.mayor = mayor;
        this.id_vendedor = id_vendedor;
        this.vendedor = vendedor;
    }

    public String getMayor() {
        return mayor;
    }

    public void setMayor(String mayor) {
        this.mayor = mayor;
    }

    
        
    

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public int getNroBoleta() {
        return nroBoleta;
    }

    public void setNroBoleta(int nroBoleta) {
        this.nroBoleta = nroBoleta;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public boolean isMayor18Anios() {
        return mayor18Anios;
    }

    public void setMayor18Anios(boolean mayor18Anios) {
        this.mayor18Anios = mayor18Anios;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public float getCantidadAPagar() {
        return cantidadAPagar;
    }

    public void setCantidadAPagar(float cantidadAPagar) {
        this.cantidadAPagar = cantidadAPagar;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    
    @Override
    public String toString() {
        return "Boleta{" + "nroBoleta=" + nroBoleta + ", rutCliente=" + rutCliente + ", mayor18Anios=" + mayor18Anios + ", mayor=" + mayor +", fechaCompra=" + fechaCompra + ", metodoPago=" + metodoPago + ", cantidadAPagar=" + cantidadAPagar + ", id_vendedor=" + id_vendedor + ", vendedor=" + vendedor +'}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.nroBoleta;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Boleta other = (Boleta) obj;
        return this.nroBoleta == other.nroBoleta;
    }
    public ArrayList<Boleta> read() throws InstantiationException, IllegalAccessException, Exception {
        CrudDAOable<Boleta> uDAO = new BoletaDAOImpl();
        return uDAO.read(); 
    }
    
    public ArrayList<Boleta> readConWhere(String whereSQL) throws InstantiationException, IllegalAccessException, Exception {
        CrudDAOable<Boleta> uDAO = new BoletaDAOImpl();
        return uDAO.readWhere(whereSQL); 
    }

    public void create(Boleta b) throws InstantiationException, IllegalAccessException, Exception{
        CrudDAOable<Boleta> cDAO = new BoletaDAOImpl();
        cDAO.create(b); 
    }
    public void update(Boleta b) throws InstantiationException, IllegalAccessException, Exception{
        CrudDAOable<Boleta> cDAO = new BoletaDAOImpl();
        cDAO.update(b); 
    }
    
    public int getVendedorByNroBoleta(int nroBoleta) throws IllegalAccessException, Exception
    {
        BoletaDAOImpl uDAO = new BoletaDAOImpl();
        return uDAO.getVendedorByNroBoleta(nroBoleta); 
    }
    public Boleta getBoleta(Boleta b) throws InstantiationException, IllegalAccessException, Exception
    {
        BoletaDAOImpl uDAO = new BoletaDAOImpl();
        return uDAO.read(" where nroBoleta='" + b.getNroBoleta()+ "'");
    }
     public void delete(Boleta b) throws InstantiationException, IllegalAccessException, Exception{
        CrudDAOable<Boleta> cDAO = new BoletaDAOImpl();
        cDAO.delete(b);
    }       
         
}
