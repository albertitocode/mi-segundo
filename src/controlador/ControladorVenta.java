/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Clientes;
import modelo.Login;
import modelo.RopaVenta;
import modelo.Usuarios;
import modelo.UsuariosDao;
import modelo.Venta;
import modelo.VentaDao;
import vista.VistaClientes;
import vista.VistaLogin;
import vista.VistaReparaciones;
import vista.VistaSupervisor;
import vista.VistaUsuarios;
import vista.VistaVendedor;
import vista.VistaVenta;

/**
 *
 * @author hgust
 */
public class ControladorVenta implements ActionListener {

    public RopaVenta rpv = new RopaVenta();
    public Usuarios vendedor = new Usuarios();
    public Clientes client = new Clientes();
    public VentaDao dao1 = new VentaDao();
    public Venta ven = new Venta();
    public VistaVenta vista1 = new VistaVenta();
    DefaultTableModel modelitoVenta = new DefaultTableModel();
    public ControladorRopaVenta contrpv=new ControladorRopaVenta();
    int total;
    JTable tabla;
    public ControladorLogin lg=new ControladorLogin();
//    public RopaVenta rp = new RopaVenta();
//    DefaultTableModel modelito=new DefaultTableModel();
    public ControladorVenta() {
    }

    public ControladorVenta(VistaVenta visvent, Usuarios vendedor) {
        this.vista1 = visvent;
        this.vendedor = vendedor;
        this.vista1.ventas.addActionListener(this);
        this.vista1.vender.addActionListener(this);
//        vista1.LTotal.setText("TOTAL: " + total);
        this.tabla = tabla;
        this.vista1.btncerrar.addActionListener(this);
        this.vista1.btnRegresar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vista1.ventas) {
            int id_v = Integer.parseInt(vista1.tid.getText().toString());
            mostrarPrenda(id_v);

           
        }
        if(ae.getSource()== vista1.btnRegresar){
            VistaVendedor vistaV = new VistaVendedor();
            ControladorVendedor conVend = new ControladorVendedor(vistaV);
            vistaV.setVisible(true);
            vistaV.setSize(882, 588);
            vistaV.setLocation(300, 10);
            vista1.dispose();
            vistaV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if (ae.getSource()==vista1.btncerrar){
            VistaLogin log = new VistaLogin();
            
            ControladorLogin con = new ControladorLogin(log);
            log.setVisible(true);
            log.setSize(869, 588);
            log.setLocation(300, 10);
            vista1.dispose();
            log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if (ae.getSource() == vista1.vender) {
            int id = Integer.parseInt(vista1.tid.getText().toString());
            this.contrpv.rpv=dao1.getPrenda(id);
            int cant = Integer.parseInt(JOptionPane.showInputDialog("Inserte la cantidad que desea comprar "));

            if (cant <= this.contrpv.rpv.getRpv_stock() && this.contrpv.rpv.getRpv_stock() > 0 && cant > 0) {
                JOptionPane.showMessageDialog(vista1, "normal "+this.contrpv.rpv.getRpv_stock());
                int actualizazion_stock=this.contrpv.rpv.getRpv_stock()-cant;
                this.contrpv.rpv.setRpv_stock(actualizazion_stock);
//                rpv.setRpv_stock(rpv.getRpv_stock() - cant);
                JOptionPane.showMessageDialog(vista1, "resta  "+this.contrpv.rpv.getRpv_stock() );
//                int f=rpv.getRpv_stock();
                

                int vend = vendedor.getUsuario_id();
                int cliente = Integer.parseInt(JOptionPane.showInputDialog("Inserte el id del cliente"));
                client = dao1.cliente(cliente);

                if (client == null) {
                    JOptionPane.showMessageDialog(vista1, "El cliente con id " + cliente + " no se encuentra registrado en el sistema\n"
                            + "a continuacion seras redirigido a registrar el cliente");
                    VistaClientes vistaC = new VistaClientes();
                    ControladorClientes conC = new ControladorClientes(vistaC);
                    vistaC.setVisible(true);
                    vistaC.setLocationRelativeTo(null);
                    vista1.dispose();
                    vistaC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                } else {
                    
                    int id_v = Integer.parseInt(vista1.tid.getText().toString());
                    setVenta(client.getCliente_id(), vendedor.getUsuario_id(), id_v);
                    JOptionPane.showMessageDialog(vista1, this.contrpv.rpv.getRpv_stock());
                    dao1.modificar(id,this.contrpv.rpv.getRpv_stock());
                    JOptionPane.showMessageDialog(vista1, "Venta registrada  " + id_v + "\n" + client.getCliente_id() + "\n" + vendedor.getUsuario_id());

                }

            } else {
                JOptionPane.showMessageDialog(vista1, "La cantidad no es valida, solo hay " + this.contrpv.rpv.getRpv_stock() + " prendas disponibles");
            }

        }

    }
    
    public void setVenta(int c, int v, int p) {
        int resultado;

        resultado = dao1.getVenta(c, v, p);

        if (resultado == 1) {
         
            JOptionPane.showMessageDialog(vista1, "Se ingreso correctamente");
        } else {
            if (resultado == 0) {
                JOptionPane.showMessageDialog(vista1, "Error de insercion " + JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void mostrarPrenda(int id) {
        RopaVenta rp = dao1.getPrenda(id);
        if (rp != null) {
            vista1.lnombre.setText(rp.getRp_nombre());
            vista1.ldescri.setText(rp.getRp_descripcion());
            vista1.lpre.setText("" + rp.getRpv_precio());
            vista1.lstock.setText("" + rp.getRpv_stock());

        } else {
            JOptionPane.showMessageDialog(vista1, "No se encontró la prenda");
        }
//        boolean b = false;
//        modelitoVenta = (DefaultTableModel) tabla.getModel();
//        RopaVenta rpv = new RopaVenta();
//        Object[] object = new Object[4];
//        rpv = dao1.listar(id);
//        ArrayList<Integer> listaId = new ArrayList<>();
//        HashSet<Integer> listaId = new HashSet<>();
//        if (listaId.contains(id)) {
//                JOptionPane.showMessageDialog(vista1, "El producto ya existe en la lista");
//        } else {
//                JOptionPane.showMessageDialog(vista1, "El producto se agrego");
//            listaId.add(id); // Agregamos el número al conjunto
//            b=true;
//        }
//           for (int i = 0; i <= listaId.size(); i++) {
//            if (listaId.contains(id)) {
//                JOptionPane.showMessageDialog(vista1, "El producto ya existe en la lista");
//            } else {
//                listaId.add(id);
//                b = true;
//            }
//
//        }
//        if (b == true) {
//            if (rpv != null) {
//                int cant = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad que desea llevar"));
//                if (cant <= 0) {
//                    JOptionPane.showMessageDialog(vista1, "Cantidad invalida,el número ingresado no puede ser cero o menor que cero");
//
//                } else if (cant <= rpv.getRpv_stock() && rpv.getRpv_stock() > 0) {
//                    JOptionPane.showMessageDialog(null, rpv.getRpv_stock());
//
//                    object[0] = rpv.getRp_nombre();
//                    object[1] = rpv.getRp_descripcion();
//                    object[2] = rpv.getRpv_precio();
//                    object[3] = cant;
//                    rpv.setRpv_stock(rpv.getRpv_stock() - cant);
//
//                    modelitoVenta.addRow(object);
//
//                } else {
//                    JOptionPane.showMessageDialog(vista1, "Cantidad invalida, solo hay " + rpv.getRpv_stock() + "prendas disponibles");
//                }
//
//                total += rpv.getRpv_precio() * cant;
//                vista1.LTotal.setText("TOTAL:" + total);
//
//                vista1.tablaVenta.setModel(modelitoVenta);
//
//            } else {
//                JOptionPane.showMessageDialog(vista1, "No se encontró la prenda");
//            }

    }

}
