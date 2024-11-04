/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.MateriaDao;
import modelo.MateriaPrima;
import modelo.RopaVDao;
import modelo.RopaVenta;
import vista.VistaAdmin;
import vista.VistaMateria;
import vista.VistaOrden;
import vista.VistaOrdenVentas;
import vista.VistaSupervisor;
/**
 *
 * @author hgust
 */

    public class ControladorOrdenRopaVenta implements ActionListener {

    public RopaVDao daoRPV = new RopaVDao();
    public RopaVenta mp = new RopaVenta();
    public VistaOrdenVentas vOrden = new VistaOrdenVentas();
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorOrdenRopaVenta(VistaOrdenVentas visOrden) {
        this.vOrden=visOrden;
        getRopa(vOrden.jtInsumos);
     
        this.vOrden.btnNo.addActionListener(this);
        this.vOrden.btnGenerar.addActionListener(this);
        this.vOrden.btnRegresar.addActionListener(this);
    }

    public ControladorOrdenRopaVenta() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vOrden.btnGenerar) {
            getActualizarStock();
            limpiarTabla();
            getRopa(vOrden.jtInsumos);
            JOptionPane.showMessageDialog(vOrden ,"Orden generada con éxito");
           
        }
        if(e.getSource()== vOrden.btnNo){
             JOptionPane.showMessageDialog(vOrden ,"Orden cancelada");
            VistaAdmin visadmin = new VistaAdmin();
            ControladorAdmin coneadmin = new ControladorAdmin(visadmin);
            visadmin.setVisible(true);
            visadmin.setSize(869, 588);
            visadmin.setLocation(300, 10);
            vOrden.dispose();
            visadmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(e.getSource()== vOrden.btnRegresar){
            VistaAdmin visadmin = new VistaAdmin();
            ControladorAdmin coneadmin = new ControladorAdmin(visadmin);
            visadmin.setVisible(true);
            visadmin.setSize(869, 588);
            visadmin.setLocation(300, 10);
            vOrden.dispose();
            visadmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    }

    public void getRopa(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<RopaVenta> lista = daoRPV.getRopav();
        Object[] object = new Object[9];

        for (int indice = 0; indice < lista.size(); indice++) {
            object[0] = lista.get(indice).getRp_id();
            object[1] = lista.get(indice).getRpv_id();
            object[2] = lista.get(indice).getRp_nombre();
            object[3] = lista.get(indice).getRp_marca();
            object[4] = lista.get(indice).getRp_descripcion();
            object[5] = lista.get(indice).getRp_color();
            object[6] = lista.get(indice).getRp_categoria();
            object[7] = lista.get(indice).getRpv_precio();
            object[8] = lista.get(indice).getRpv_stock();
            

            modelo.addRow(object);
        }
        vOrden.jtInsumos.setModel(modelo);
    }

    public void getActualizarStock() {
            daoRPV.setActualizarStock();
        

    }

    public void limpiarTabla() {
        for (int i = 0; i < vOrden.jtInsumos.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

}


