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
import modelo.Login;
import modelo.SupervisorDao;
import modelo.Usuarios;
import modelo.VendedorDao;
import vista.VistaLogin;
import vista.VistaMateria;
import vista.VistaOrden;
import vista.VistaReparaciones;
import vista.VistaRopaClinica;
import vista.VistaRopaVenta;
import vista.VistaSupervisor;
import vista.VistaUsuarios;
import vista.VistaVendedor;
import vista.VistaVenta;
/**
 *
 * @author hgust
 */
public class ControladorVendedor implements ActionListener{
    
    public Login login = new Login();
    public VistaVendedor vistaVendedor = new VistaVendedor();
    public VendedorDao vdao= new VendedorDao();
     public Usuarios vendedor = new Usuarios();
       public VistaVenta vista1 = new VistaVenta();
    
    

    public ControladorVendedor(VistaVendedor visV, Login log) {
        this.login = log;
        this.vistaVendedor=visV;
        this.vendedor=vdao.usuario(login.getCorreo());
        this.vistaVendedor.btnReparacion.addActionListener(this);
        this.vistaVendedor.btnVenta.addActionListener(this);
       this.vistaVendedor.btncerrar.addActionListener(this);
       this.vistaVendedor.btnPdf.addActionListener(this);
       
       vistaVendedor.LVendedor.setText("Hola Vendedor "+vendedor.getPersona_nombre());
       
       
    }

    public ControladorVendedor(VistaVendedor visvend) {
        this.vistaVendedor=visvend;
        this.vistaVendedor.btnReparacion.addActionListener(this);
        this.vistaVendedor.btnVenta.addActionListener(this);
       this.vistaVendedor.btncerrar.addActionListener(this);
       this.vistaVendedor.btnPdf.addActionListener(this);
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vistaVendedor.btnVenta){
            
            VistaVenta vVenta=new VistaVenta();
            ControladorVenta conV=new ControladorVenta(vVenta,vendedor);
            vVenta.setVisible(true);
            vVenta.setLocationRelativeTo(null);

            vistaVendedor.dispose();
            vVenta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(e.getSource()==vistaVendedor.btnReparacion){
            
            VistaReparaciones vR=new VistaReparaciones();
            ControladorReparaciones conR=new ControladorReparaciones(vR);
            vR.setVisible(true);
            vR.setLocationRelativeTo(null);

            vistaVendedor.dispose();
            vR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
       
            if (e.getSource()==vistaVendedor.btncerrar){
            VistaLogin log = new VistaLogin();
            
            ControladorLogin con = new ControladorLogin(log);
            log.setVisible(true);
            log.setSize(850, 600);
            log.setLocation(300, 10);
            vistaVendedor.dispose();
            log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
            if(e.getSource()==vistaVendedor.btnPdf){
                generarPdf();
            }
        
    }
    
    public void getStock(){
    
    }
     public void generarPdf() {
         Document documento = new Document();
         
         int id =Integer.parseInt(JOptionPane.showInputDialog(vistaVendedor,"Inserte el id del cliente"));
        try {
         String lugarGuardado=System.getProperty("user.home");
         File file = new File(lugarGuardado + "/Desktop/VENTAS_POR_CLIENTE.pdf");
        if (!file.getParentFile().exists()) {
        file.getParentFile().mkdirs(); // Crea el directorio si no existe
        }
         PdfWriter.getInstance(documento,new FileOutputStream(lugarGuardado+"/Desktop/VENTAS_POR_CLIENTE.pdf"));
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
         subtitulo.add("Lista Ventas por cliente\n\n");
         
         documento.add(encabezado);
         documento.add(subtitulo);
         documento.add(this.vdao.listarpdf(id));
        documento.close();
        JOptionPane.showMessageDialog(vistaVendedor, "Pdf creado");
        } catch ( Exception e) {
            JOptionPane.showMessageDialog(null,"Exception en el controlador"+e.toString());
        }
        
    }
}

