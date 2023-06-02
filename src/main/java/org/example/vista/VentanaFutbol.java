package org.example.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaFutbol extends JFrame {
    private JLabel lblId;
    private JLabel lblLiga;
    private JLabel lblEquipo;
    private JLabel lblMejorJugador;
    private JLabel lblEdadJugador;
    private JLabel lblNacionalidadJugador;
    private JLabel lblURL;
    private JTextField txtId;
    private JTextField txtLiga;
    private JTextField txtEquipo;
    private JTextField txtMejorJugador;
    private JTextField txtEdadJugador;
    private JTextField txtNacionalidadJugador;
    private JTextField txtURL;
    private JButton btnAgregar;
    private JButton btnCargar;
    private JButton btnEliminar;
    private JButton btnActualizar;
    private JTable tblTablaFutbol;
    private JScrollPane scroll;
    private GridLayout layout;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JLabel foto;

    public VentanaFutbol(String title) throws HeadlessException {
        super(title);
        this.setSize(1920, 1080);
        layout = new GridLayout(2, 2);
        this.getContentPane().setLayout(layout);

        //panel1
        panel1 = new JPanel();
        panel1.setBackground(new Color(96, 147, 152));
        lblId = new JLabel("Id: ");
        lblLiga = new JLabel("Liga: ");
        lblEquipo = new JLabel("Equipo: ");
        lblMejorJugador = new JLabel("Mejor Jugador: ");
        lblEdadJugador = new JLabel("Edad: ");
        lblNacionalidadJugador = new JLabel("Nacionalidad: ");
        lblURL = new JLabel("Imagen: ");
        txtId = new JTextField(2);
        txtId.setText("0");
        txtId.setEnabled(false);
        txtLiga = new JTextField(10);
        txtEquipo = new JTextField(10);
        txtMejorJugador = new JTextField(10);
        txtEdadJugador = new JTextField(2);
        txtNacionalidadJugador = new JTextField(10);
        txtURL = new JTextField(20);
        btnAgregar = new JButton("Agregar");

        panel1.add(lblId);
        panel1.add(txtId);
        panel1.add(lblLiga);
        panel1.add(txtLiga);
        panel1.add(lblEquipo);
        panel1.add(txtEquipo);
        panel1.add(lblMejorJugador);
        panel1.add(txtMejorJugador);
        panel1.add(lblEdadJugador);
        panel1.add(txtEdadJugador);
        panel1.add(lblNacionalidadJugador);
        panel1.add(txtNacionalidadJugador);
        panel1.add(lblURL);
        panel1.add(txtURL);
        panel1.add(btnAgregar);


        //panel2
        panel2 = new JPanel();
        panel2.setBackground(new Color(171, 78, 78));
        btnCargar = new JButton("Cargar");
        panel2.add(btnCargar);
        tblTablaFutbol = new JTable();
        scroll = new JScrollPane(tblTablaFutbol);
        panel2.add(scroll);


        //panel3
        panel3 = new JPanel();
        panel3.setBackground(new Color(153, 99, 157));
        foto =  new JLabel("...");
        panel3.add(foto);


        //panel4
        panel4 = new JPanel();
        panel4.setBackground(new Color(137, 182, 96));
        btnEliminar = new JButton("Eliminar");
        btnActualizar = new JButton("Actualizar");
        panel4.add(btnEliminar);
        panel4.add(btnActualizar);


        this.getContentPane().add(panel1, 0);
        this.getContentPane().add(panel2, 1);
        this.getContentPane().add(panel3, 2);
        this.getContentPane().add(panel4, 3);


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblLiga() {
        return lblLiga;
    }

    public void setLblLiga(JLabel lblLiga) {
        this.lblLiga = lblLiga;
    }

    public JLabel getLblEquipo() {
        return lblEquipo;
    }

    public void setLblEquipo(JLabel lblEquipo) {
        this.lblEquipo = lblEquipo;
    }

    public JLabel getLblMejorJugador() {
        return lblMejorJugador;
    }

    public void setLblMejorJugador(JLabel lblMejorJugador) {
        this.lblMejorJugador = lblMejorJugador;
    }

    public JLabel getLblEdadJugador() {
        return lblEdadJugador;
    }

    public void setLblEdadJugador(JLabel lblEdadJugador) {
        this.lblEdadJugador = lblEdadJugador;
    }

    public JLabel getLblNacionalidadJugador() {
        return lblNacionalidadJugador;
    }

    public void setLblNacionalidadJugador(JLabel lblNacionalidadJugador) {
        this.lblNacionalidadJugador = lblNacionalidadJugador;
    }

    public JLabel getLblURL() {
        return lblURL;
    }

    public void setLblURL(JLabel lblURL) {
        this.lblURL = lblURL;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtLiga() {
        return txtLiga;
    }

    public void setTxtLiga(JTextField txtLiga) {
        this.txtLiga = txtLiga;
    }

    public JTextField getTxtEquipo() {
        return txtEquipo;
    }

    public void setTxtEquipo(JTextField txtEquipo) {
        this.txtEquipo = txtEquipo;
    }

    public JTextField getTxtMejorJugador() {
        return txtMejorJugador;
    }

    public void setTxtMejorJugador(JTextField txtMejorJugador) {
        this.txtMejorJugador = txtMejorJugador;
    }

    public JTextField getTxtEdadJugador() {
        return txtEdadJugador;
    }

    public void setTxtEdadJugador(JTextField txtEdadJugador) {
        this.txtEdadJugador = txtEdadJugador;
    }

    public JTextField getTxtNacionalidadJugador() {
        return txtNacionalidadJugador;
    }

    public void setTxtNacionalidadJugador(JTextField txtNacionalidadJugador) {
        this.txtNacionalidadJugador = txtNacionalidadJugador;
    }

    public JTextField getTxtURL() {
        return txtURL;
    }

    public void setTxtURL(JTextField txtURL) {
        this.txtURL = txtURL;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JTable getTblTablaFutbol() {
        return tblTablaFutbol;
    }

    public void setTblTablaFutbol(JTable tblTablaFutbol) {
        this.tblTablaFutbol = tblTablaFutbol;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JLabel getFoto() {
        return foto;
    }

    public void setFoto(JLabel foto) {
        this.foto = foto;
    }

    public void limpiar() {
        txtLiga.setText("");
        txtEquipo.setText("");
        txtMejorJugador.setText("");
        txtEdadJugador.setText("");
        txtNacionalidadJugador.setText("");
        txtURL.setText("");
    }
}
