/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import vista.VistaVenta;

/**
 *
 * @author hgust
 */


public class VentaDao {
     Conexion conectar= new Conexion();
    Connection conex;
    PreparedStatement ps;
    ResultSet rs;
    VistaVenta venta = new VistaVenta();
    
    
     public int stockRopaVenta(int prenda){
        String sql="UPDATE ropa_venta SET rpv_stock=(rpv_stock-1) WHERE rpv_id=?";
        
        try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            
//           ps.setInt(1,us.getPersona_id());
            ps.setInt(1,prenda);
           
            
            ps.executeUpdate();
            return 1;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.toString());
        return 0;
        }finally{
            try{
                if(conex!=null){
                    conex.close();
                }
            }catch(SQLException sqle){
                JOptionPane.showMessageDialog(null,sqle.toString());
                }
        }
    }
   
    
    public Usuarios usuario(String correo){
        String sql="SELECT  persona_nombre, persona_apellido, usuario_id FROM usuarios WHERE usuario_email=?";
        Usuarios u= null;
         try {
        conex = (Connection) conectar.getConnection();
        ps = (PreparedStatement) conex.prepareStatement(sql);
        ps.setString(1, correo);
        rs = ps.executeQuery();
        
        if(rs.next()){
            u= new Usuarios();
            
                u.setPersona_nombre(rs.getString(1));
                u.setPersona_apellido(rs.getString(2));
                u.setUsuario_id(rs.getInt(3));
                
            
        }
         
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.toString());
    } finally {
        try {
            if (conex != null) {
                conex.close();
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.toString());
        }
        
         return u;
        
    }
    }

    
    public Clientes cliente(int idCliente){
        String sql="SELECT * FROM clientes WHERE cliente_id=?";
        Clientes cliente= null;
         try {
        conex = (Connection) conectar.getConnection();
        ps = (PreparedStatement) conex.prepareStatement(sql);
        ps.setInt(1, idCliente);
        rs = ps.executeQuery();
        
        if(rs.next()){
            cliente= new Clientes();
            
            cliente.setCliente_id(rs.getInt("cliente_id"));
            cliente.setCliente_direccion(rs.getString("cliente_direccion"));
            cliente.setCliente_telefono(rs.getInt("cliente_telefono"));
            
        }
         
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.toString());
    } finally {
        try {
            if (conex != null) {
                conex.close();
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.toString());
        }
        
         return cliente;
        
    }
    }
    
    
    
    public int getVenta(int cVenta, int vVenta, int pVenta){
        String sql = "INSERT INTO ventas (fecha_venta, cliente_venta, vendedor_venta, prenda_venta) VALUES (CURRENT_TIMESTAMP,?,?,?)";
        
         try {
        conex = (Connection) conectar.getConnection();
        ps = (PreparedStatement) conex.prepareStatement(sql);
        ps.setInt(1, cVenta);
        ps.setInt(2, vVenta);
        ps.setInt(3, pVenta);

        
        ps.executeUpdate();
        return 1;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.toString());
        return 0;
    } finally {
        try {
            if (conex != null) {
                conex.close();
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.toString());
        }
    }
    
   }
    
    
    
   public RopaVenta getPrenda(int id) {
    String sql = "SELECT rp_nombre, rp_descripcion, rpv_precio, rpv_stock FROM ropa_venta WHERE rpv_id=?";
   RopaVenta rpv=null;
    try {
        conex = (Connection) conectar.getConnection();
        ps = (PreparedStatement) conex.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        
        if (rs.next()) { 
          
            String nombre = rs.getString("rp_nombre");
            String descripcion = rs.getString("rp_descripcion");
            int precio = rs.getInt("rpv_precio");
            int stock = rs.getInt("rpv_stock");
            
            rpv=new RopaVenta();
            rpv.setRp_nombre(nombre);
            rpv.setRp_descripcion(descripcion);
            rpv.setRpv_precio(precio);
            rpv.setRpv_stock(stock);
//            venta.lnombre.setText(nombre);
//            venta.ldescri.setText(descripcion);
//            venta.lpre.setText(""+precio);
//            venta.lstock.setText(""+stock);
           
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.toString());
    } finally {
        try {
            if (conex != null) {
                conex.close();
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.toString());
        }
    }
    
    return rpv; 
   }
    public void modificar(int idi,int stoc){
         String sql= "UPDATE ropa_venta SET  rpv_stock=? WHERE rpv_id=?";
        
         try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            
            
            ps.setInt(1, stoc);
            ps.setInt(2, idi);
            ps.executeUpdate();
            
            
            
//         return 1;
          
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"dao 1"+e.toString());
//         return 0;
        }finally{
            try{
                if(conex!=null){
                    conex.close();
                }
            }catch(SQLException sqle){
                JOptionPane.showMessageDialog(null,sqle.toString());
                }
        }
    
     }
    
    public PdfPTable listarpdf() throws DocumentException{
        BaseColor verdi= new BaseColor(0,102,0);
        Font letraBlanca = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.WHITE);
         PdfPTable mitablapdf= new PdfPTable(5);   
//         float[] TamanoTabla=new float[]{10f,10f,10f};
//         mitablapdf.setWidths(TamanoTabla);
         PdfPCell cel1=new PdfPCell(new Phrase("Id_venta",letraBlanca));
         cel1.setBackgroundColor(verdi);
         PdfPCell cel2=new PdfPCell(new Phrase("Fecha venta",letraBlanca));
         cel2.setBackgroundColor(verdi);
         PdfPCell cel3=new PdfPCell(new Phrase("Cliente venta",letraBlanca));
         cel3.setBackgroundColor(verdi);
         PdfPCell cel4=new PdfPCell(new Phrase("vendedor venta",letraBlanca));
         cel4.setBackgroundColor(verdi);
         PdfPCell cel5=new PdfPCell(new Phrase("prenda venta",letraBlanca));
         cel5.setBackgroundColor(verdi);
         
         mitablapdf.addCell(cel1);
         mitablapdf.addCell(cel2);
         mitablapdf.addCell(cel3);
         mitablapdf.addCell(cel4);
         mitablapdf.addCell(cel5);
      
        String sql="SELECT v.id_venta,v.fecha_venta,c.cliente_nombre,u.persona_nombre,p.rp_nombre FROM ventas v JOIN clientes c ON v.cliente_venta=c.cliente_id JOIN usuarios u ON v.vendedor_venta=u.usuario_id JOIN ropa_venta p ON v.prenda_venta=p.rpv_id";
        try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            rs=ps.executeQuery();
            
            if(rs.next()){
//                PdfPTable tablapdf= new PdfPTable(11);
                do{
                    mitablapdf.addCell(rs.getString(1));
                    mitablapdf.addCell(rs.getString(2));
                    mitablapdf.addCell(rs.getString(3));
                    mitablapdf.addCell(rs.getString(4));
                    mitablapdf.addCell(rs.getString(5));
                    
                }while(rs.next());
//                documento.add(tablapdf);
               
            }
        }catch( Exception e){
            JOptionPane.showMessageDialog(null,e.toString());
        }finally{
            try{
                if(conex!=null){
                    conex.close();
                }
                
            }catch(SQLException sqle){
                JOptionPane.showMessageDialog(null, sql.toString());
            }
        }
        return mitablapdf;
    }
  
 }

