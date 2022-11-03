

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


import dao.CrudDAOable;
import dao.VendedorDAOImpl;
import java.util.ArrayList;

/**
 *
 * @author yerko
 */
public class Vendedor {
    private int idVendedor;
    private String nombreVendedor;

    public Vendedor() {
    }

    public Vendedor(int idVendedor, String nombreVendedor) {
        this.idVendedor = idVendedor;
        this.nombreVendedor = nombreVendedor;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    @Override
    public String toString() {
        return nombreVendedor +"[" + idVendedor + "]";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idVendedor;
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
        final Vendedor other = (Vendedor) obj;
        return this.idVendedor == other.idVendedor;
    }
    
    public ArrayList read() throws InstantiationException, IllegalAccessException, Exception{
         CrudDAOable<Vendedor> uDAO = new VendedorDAOImpl();
         return uDAO.read(); 
    }
}
