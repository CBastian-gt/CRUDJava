/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import modelo.Boleta;
import servicios.FactoriaServiciosImpl;

/**
 *
 * @author yerko
 */
public class BoletaDAOImpl implements BoletaDAOable{

    @Override
    public void create(Boleta t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        ArrayList<Boleta> al = new ArrayList();
        String sql = "INSERT INTO boleta (rutCliente, mayor18Anios, fechaCompra, metodoDePago, cantidadAPagar,  id_vendedor) VALUES (?,?,?,?,?,?);";
        PreparedStatement ps = FactoriaServiciosImpl.getFactoria().getConexionDB().getConexion().prepareStatement(sql);
        
        ps.setString(1, t.getRutCliente());
        ps.setBoolean(2, t.isMayor18Anios());
        ps.setDate(3, new java.sql.Date(t.getFechaCompra().getTime()));
        ps.setString(4, t.getMetodoPago());
        ps.setFloat(5, t.getCantidadAPagar());
        ps.setInt(6, t.getId_vendedor());
        
        ps.executeUpdate();
    }

    @Override
    public boolean read(Boleta t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Boleta> read() throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        
        ArrayList<Boleta> al = new ArrayList();
        String sql = "select bol.*, vend.nombreVendedor as vendedor from boleta as bol inner join vendedor vend on bol.id_vendedor = vend.idVendedor order by nroBoleta ;";
        PreparedStatement ps = FactoriaServiciosImpl.getFactoria().getConexionDB().getConexion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            int nroBoleta = rs.getInt("nroBoleta");
            String rutCliente = rs.getString("rutCliente");
            boolean mayor18Anios = rs.getBoolean("mayor18Anios");
            Date fechaCompra = rs.getDate("fechaCompra");
            String metodoPago = rs.getNString("metodoDePago");
            float cantidadAPagar = rs.getFloat("cantidadAPagar");
            
            int id_vendedor = rs.getInt("id_vendedor");
            String vendedor = rs.getNString("vendedor");
            
            Boleta boleta = new Boleta();
            boleta.setNroBoleta(nroBoleta);
            boleta.setRutCliente(rutCliente);
            boleta.setMayor18Anios(mayor18Anios);
            boleta.setFechaCompra(fechaCompra);
            boleta.setMetodoPago(metodoPago);
            boleta.setCantidadAPagar(cantidadAPagar);
            
            boleta.setId_vendedor(id_vendedor);
            boleta.setVendedor(vendedor);
            
            al.add(boleta);
        }        
        return al;
    }

    @Override
    public ArrayList<Boleta> readWhere(String whereSQL) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        ArrayList<Boleta> al = new ArrayList();
        String sql = "select bol.*,vend.nombreVendedor as vendedor from boleta bol inner join vendedor vend on bol.id_vendedor = vend.idVendedor  " + whereSQL + ";";
        PreparedStatement ps = FactoriaServiciosImpl.getFactoria().getConexionDB().getConexion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            int nroBoleta = rs.getInt("nroBoleta");
            String rutCliente = rs.getString("rutCliente");
            boolean mayor18Anios = rs.getBoolean("mayor18Anios");
            Date fechaCompra = rs.getDate("fechaCompra");
            String metodoPago = rs.getNString("metodoDePago");
            float cantidadAPagar = rs.getFloat("cantidadAPagar");
            
            int id_vendedor = rs.getInt("id_vendedor");
            String vendedor = rs.getNString("vendedor");
            
            Boleta boleta = new Boleta();
            boleta.setNroBoleta(nroBoleta);
            boleta.setRutCliente(rutCliente);
            boleta.setMayor18Anios(mayor18Anios);
            boleta.setFechaCompra(fechaCompra);
            boleta.setMetodoPago(metodoPago);
            boleta.setCantidadAPagar(cantidadAPagar);
            
            boleta.setId_vendedor(id_vendedor);
            boleta.setVendedor(vendedor);
            al.add(boleta);
        }        
        return al;    
    }
    
        public Boleta read(String whereSQL) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception 
        {
            
            Boleta boleta = null;
            
            
            String sql = "select bol.*,vend.nombreVendedor as vendedor from boleta bol inner join vendedor vend on bol.id_vendedor = vend.idVendedor  " + whereSQL + ";";
            PreparedStatement ps = FactoriaServiciosImpl.getFactoria().getConexionDB().getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                int nroBoleta = rs.getInt("nroBoleta");
                String rutCliente = rs.getString("rutCliente");
                boolean mayor18Anios = rs.getBoolean("mayor18Anios");
                Date fechaCompra = rs.getDate("fechaCompra");
                String metodoPago = rs.getNString("metodoDePago");
                float cantidadAPagar = rs.getFloat("cantidadAPagar");

                int id_vendedor = rs.getInt("id_vendedor");
                String vendedor = rs.getNString("vendedor");

                boleta = new Boleta();
                
                boleta.setNroBoleta(nroBoleta);
                boleta.setRutCliente(rutCliente);
                boleta.setMayor18Anios(mayor18Anios);
                boleta.setFechaCompra(fechaCompra);
                boleta.setMetodoPago(metodoPago);
                boleta.setCantidadAPagar(cantidadAPagar);

                boleta.setId_vendedor(id_vendedor);
                boleta.setVendedor(vendedor);
               
            }        
            return boleta;  
        }
    @Override
    public void update(Boleta t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
                
        String sql = "update boleta set mayor18Anios=?, fechaCompra=?, metodoDePago=?, cantidadAPagar=?, id_vendedor=? where nroBoleta=?;";
        PreparedStatement ps = FactoriaServiciosImpl.getFactoria().getConexionDB().getConexion().prepareStatement(sql);
        
        
        ps.setBoolean(1, t.isMayor18Anios());
        ps.setDate(2, new java.sql.Date(t.getFechaCompra().getTime()));
        ps.setString(3, t.getMetodoPago());
        ps.setFloat(4, t.getCantidadAPagar());
        ps.setInt(5, t.getId_vendedor());
        ps.setInt(6, t.getNroBoleta());      
        ps.executeUpdate();
    }
    

    @Override
    public void delete(Boleta t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        String sql = "delete from boleta where nroBoleta=?;";
        PreparedStatement ps = FactoriaServiciosImpl.getFactoria().getConexionDB().getConexion().prepareStatement(sql);
        ps.setInt(1, t.getNroBoleta());      
        ps.executeUpdate();
    }

    public int getVendedorByNroBoleta(int nroBoleta) throws InstantiationException, IllegalAccessException, Exception
    {
        Boleta b = this.read(" where nroBoleta='" + nroBoleta + "'");
        if ( b==null)
        {
            return 0;
        }
        else{
            return b.getId_vendedor();
        }
       
    }
}
