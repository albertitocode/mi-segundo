/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.AdminDao;
import modelo.VentaDao;
import vista.VistaAdmin;
import vista.VistaCategoria;
import vista.VistaClientes;
import vista.VistaEstado;
import vista.VistaLogin;
import vista.VistaOrden;
import vista.VistaOrdenVentas;
import vista.VistaRol;
import vista.VistaUsuarios;

/**
 *
 * @author hgust
 */
public class ControladorAdmin implements ActionListener{
    VistaAdmin visad=new VistaAdmin();
    AdminDao admin=new AdminDao();
    ControladorVenta contV=new ControladorVenta();
    public ControladorAdmin(VistaAdmin visdmin) {
        this.visad=visdmin;
        this.visad.btncategorias.addActionListener(this);
        this.visad.btnclientes.addActionListener(this);
        this.visad.btnestados.addActionListener(this);
        this.visad.btnperfil.addActionListener(this);
        this.visad.btnroles.addActionListener(this);
        this.visad.btnusuarios.addActionListener(this);
        this.visad.btncategorias.setFocusPainted(false);
        this.visad.btnclientes.setFocusPainted(false);
        this.visad.btnestados.setFocusPainted(false);
        this.visad.btnperfil.setFocusPainted(false);
        this.visad.btnroles.setFocusPainted(false);
        this.visad.btnusuarios.setFocusPainted(false);
        this.visad.btncerrar.addActionListener(this);
        visad.linsumos.setText("Señor Administrador hay " +admin.stock()+" insumos con pocas unidades");
        this.visad.btnPdf.addActionListener(this);
        this.visad.btnorden.addActionListener(this);
    }

    public ControladorAdmin() {
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==visad.btncategorias){
             VistaCategoria ca = new VistaCategoria();
        ControladorCategoria con = new ControladorCategoria(ca);
        ca.setVisible(true);
        ca.setSize(869, 588);
        ca.setLocation(300, 10);
         visad.dispose();
        ca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(ae.getSource()==visad.btnclientes){
//            JOptionPane.showMessageDialog(visad,"Boton clientes en mantenimiento");
               VistaClientes vclientes = new VistaClientes();
        ControladorClientes concli = new ControladorClientes(vclientes);
        vclientes.setVisible(true);
        vclientes.setSize(998, 659);
        vclientes.setLocation(300, 10);
        visad.dispose();
        vclientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(ae.getSource()==visad.btnestados){
            VistaEstado es = new VistaEstado();
            ControladorEstado con = new ControladorEstado(es);
            es.setVisible(true);
            es.setSize(869, 588);
            es.setLocation(300, 10);
            visad.dispose();
            es.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(ae.getSource()==visad.btnperfil){
            JOptionPane.showMessageDialog(visad,"Boton perfil en mantenimiento");
    
        }
        if(ae.getSource()==visad.btnroles){
             VistaRol ro = new VistaRol();
        ControladorRol conrol = new ControladorRol(ro);
        ro.setVisible(true);
        ro.setSize(869, 588);
        ro.setLocation(300, 10);
        visad.dispose();
        ro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(ae.getSource()==visad.btnusuarios){
              VistaUsuarios vis = new VistaUsuarios();
            ControladorUs conusu = new ControladorUs(vis);
            
            vis.setVisible(true);
            vis.setSize(869, 588);
            vis.setLocation(300, 10);
            visad.dispose();
            vis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(ae.getSource()==visad.btncerrar){
            if (ae.getSource()==visad.btncerrar){
            VistaLogin log = new VistaLogin();
            
            ControladorLogin con = new ControladorLogin(log);
            log.setVisible(true);
            log.setSize(869, 588);
            log.setLocation(300, 10);
            visad.dispose();
            log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        }
        if(ae.getSource()==visad.btnPdf){
            generarPdf();
        }
        if(ae.getSource()==visad.btnorden){
            JOptionPane.showMessageDialog(visad, admin.stock());
            
            VistaOrdenVentas vOrden=new VistaOrdenVentas();
            ControladorOrdenRopaVenta conO=new ControladorOrdenRopaVenta(vOrden);
            vOrden.setVisible(true);
            vOrden.setSize(869, 588);
            vOrden.setLocation(300, 10);
            visad.dispose();
            vOrden.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
     public void generarPdf() {
         Document documento = new Document();
         
           
        try {
         String lugarGuardado=System.getProperty("user.home");
         File file = new File(lugarGuardado + "/Desktop/VENTAS.pdf");
        if (!file.getParentFile().exists()) {
        file.getParentFile().mkdirs(); // Crea el directorio si no existe
        }
         PdfWriter.getInstance(documento,new FileOutputStream(lugarGuardado+"/Desktop/VENTAS.pdf"));
         documento.open();
         Image img1= Image.getInstance("src/img/grupo.png");
         Date fecha=new Date();
         SimpleDateFormat formatoFecha= new SimpleDateFormat("dd/MM/yyyy");
         String fechaActual= "Fecha "+formatoFecha.format(fecha);
         
         PdfPTable encabezado=new PdfPTable(4);
         encabezado.setWidthPercentage(100);
         encabezado.getDefaultCell().setBorder(0);
         float[] TamañoEncabezado=new float[]{20f,30f,70f,40f};
         encabezado.setWidths(TamañoEncabezado);
//         encabezado.setHorizontalAlignment(All);
         encabezado.addCell(img1);
         String nombre="Kell";
         String codigo="11883758393";
         String telefono="318479889";
         String direccion="Cali/Valle del Cauca";
         encabezado.addCell("");
         encabezado.addCell("Nombre "+nombre+ "\nCodigo "+codigo+ "\nTelefono "+telefono+ "\nDirección "+direccion);
         encabezado.addCell(fechaActual);
         
         Paragraph subtitulo = new Paragraph();
         subtitulo.add("Ventas realizadas\n\n");
         
         documento.add(encabezado);
         documento.add(subtitulo);
         documento.add(this.contV.dao1.listarpdf());
        documento.close();
        JOptionPane.showMessageDialog(visad, "Pdf creado");
        } catch ( Exception e) {
            JOptionPane.showMessageDialog(null,"Exception en el controlador"+e.toString());
        }
        
    }
    
}
