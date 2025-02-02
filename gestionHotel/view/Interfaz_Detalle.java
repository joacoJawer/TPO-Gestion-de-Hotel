package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSeparator;
import com.toedter.calendar.JDayChooser;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Interfaz_Detalle extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTable table_1;
    private JRadioButton rdbtnCredito;
    private JRadioButton rdbtnDebito;
    private JRadioButton rdbtnTransferencia;
    private ButtonGroup grupoMetodoPago = new ButtonGroup();
    static DefaultTableModel tablaFuncional = new DefaultTableModel();
    static DefaultTableModel tablaFuncional1 = new DefaultTableModel();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Interfaz_Detalle frame = new Interfaz_Detalle();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Interfaz_Detalle() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1180, 683);
        contentPane = new BackgroundPanel4();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(226, 198, 255), new Color(226, 198, 255), new Color(226, 198, 255), new Color(226, 198, 255)));
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(206, 157, 255));
        panel_1.setBounds(0, 123, 1164, 51);
        contentPane.add(panel_1);
        
        JLabel lblDetalle = new JLabel("Detalle de la reserva");
        lblDetalle.setFont(new Font("Calibri", Font.BOLD, 19));
        lblDetalle.setBounds(482, 12, 175, 32);
        panel_1.add(lblDetalle);
        
        JButton btnNewButton_1 = new JButton("Atrás");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Interfaz_Reserva atras = new Interfaz_Reserva();
        		atras.setVisible(true);
        		atras.setLocationRelativeTo(null); // Centrar la nueva ventana
                dispose(); // Cerrar la ventana actual si lo deseas
            }
        });
        
        btnNewButton_1.setBounds(20, 8, 76, 34);
        panel_1.add(btnNewButton_1);
        btnNewButton_1.setForeground(Color.WHITE);
        btnNewButton_1.setFont(new Font("Calibri", Font.PLAIN, 14));
        btnNewButton_1.setBackground(new Color(63, 63, 63));
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 1164, 115);
        contentPane.add(panel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(Interfaz_Detalle.class.getResource("/img/BostonResort (6).png")));
        lblNewLabel_1.setBounds(0, 0, 1164, 115);
        panel.add(lblNewLabel_1);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel_3.setLayout(null);
        panel_3.setBackground(new Color(206, 157, 255));
        panel_3.setBounds(0, 588, 1164, 56);
        contentPane.add(panel_3);
        
        JButton btnReservar = new JButton("Reservar");
        btnReservar.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JOptionPane.showMessageDialog(null, "Reserva realizada, vuelva pronto :)");
			}
		});
        
        btnReservar.setForeground(Color.WHITE);
        btnReservar.setFont(new Font("Calibri", Font.BOLD, 14));
        btnReservar.setBackground(new Color(63, 63, 63));
        btnReservar.setBounds(1042, 11, 89, 34);
        panel_3.add(btnReservar);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(22, 191, 444, 100);
        scrollPane.getViewport().setBackground(Color.WHITE); // Color de fondo del viewport
        scrollPane.setBackground(Color.WHITE); // Color de fondo del scrollPane
        contentPane.add(scrollPane);
        
        // Definir las columnas antes de establecer el modelo en la tabla
        tablaFuncional.addColumn("Habitacion");
        tablaFuncional.addColumn("Descripción");
        tablaFuncional.addColumn("Precio");

        table = new JTable(tablaFuncional);
        table.setBorder(new LineBorder(new Color(0, 0, 0)));
        table.setFont(new Font("Calibri", Font.PLAIN, 12));
        table.setBackground(new Color(255, 255, 255));
        table.getTableHeader().setBackground(new Color(206, 157, 255)); // Color de fondo del header
        table.getTableHeader().setForeground(Color.BLACK); // Color del texto del header
        
        // Aplicar el renderer personalizado a las celdas
        CustomTableCellRenderer cellRenderer = new CustomTableCellRenderer();
        table.setDefaultRenderer(Object.class, cellRenderer);
        
        scrollPane.setViewportView(table);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 255, 255));
        panel_2.setLayout(null);
        panel_2.setBounds(22, 317, 444, 245);
        contentPane.add(panel_2);
        
        JLabel lblNewLabel = new JLabel("Check In");
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        lblNewLabel.setBounds(23, 11, 68, 20);
        panel_2.add(lblNewLabel);
        
        JLabel lblCheckOut = new JLabel("Check Out\r\n");
        lblCheckOut.setFont(new Font("Calibri", Font.BOLD, 16));
        lblCheckOut.setBounds(247, 11, 82, 20);
        panel_2.add(lblCheckOut);
        
        JDateChooser dateCheckIn = new JDateChooser();
        dateCheckIn.getCalendarButton().setForeground(new Color(206, 157, 255));
        dateCheckIn.setBounds(23, 42, 170, 32);
        panel_2.add(dateCheckIn);
        
        JDateChooser dateCheckOut = new JDateChooser();
        dateCheckOut.getCalendarButton().setForeground(new Color(206, 157, 255));
        dateCheckOut.setBounds(247, 42, 170, 32);
        panel_2.add(dateCheckOut);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(226, 198, 255));
        panel_4.setBounds(23, 28, 170, 3);
        panel_2.add(panel_4);
        
        JPanel panel_4_1 = new JPanel();
        panel_4_1.setBackground(new Color(226, 198, 255));
        panel_4_1.setBounds(247, 28, 170, 3);
        panel_2.add(panel_4_1);
        
        JLabel lblExtra = new JLabel("Tipo");
        lblExtra.setFont(new Font("Calibri", Font.BOLD, 16));
        lblExtra.setBounds(23, 95, 68, 20);
        panel_2.add(lblExtra);
        
        JLabel lblExtra_1 = new JLabel("Extra");
        lblExtra_1.setFont(new Font("Calibri", Font.BOLD, 16));
        lblExtra_1.setBounds(23, 168, 68, 20);
        panel_2.add(lblExtra_1);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Habitacion", "Suite"}));
        comboBox.setToolTipText("");
        comboBox.setBounds(23, 116, 394, 32);
        panel_2.add(comboBox);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Servicio Despertador", "TV ", "Minibar"}));
        comboBox_1.setToolTipText("");
        comboBox_1.setBounds(23, 188, 394, 32);
        panel_2.add(comboBox_1);
        
        JPanel panel_2_1 = new JPanel();
        panel_2_1.setBackground(new Color(255, 255, 255));
        panel_2_1.setLayout(null);
        panel_2_1.setBounds(484, 191, 657, 371);
        contentPane.add(panel_2_1);
        
        JLabel precio = new JLabel("precio");
        precio.setFont(new Font("Calibri", Font.PLAIN, 16));
        precio.setBounds(576, 320, 62, 22);
        panel_2_1.add(precio);
        
        JLabel lblClienteResgistrado = new JLabel("Cliente Resgistrado:");
        lblClienteResgistrado.setFont(new Font("Calibri", Font.BOLD, 16));
        lblClienteResgistrado.setBounds(230, 11, 143, 32);
        panel_2_1.add(lblClienteResgistrado);
        
        JLabel cliente = new JLabel("nombre");
        cliente.setFont(new Font("Calibri", Font.PLAIN, 15));
        cliente.setBounds(370, 20, 74, 14);
        panel_2_1.add(cliente);
        
        JComboBox comboBox_2 = new JComboBox();
        comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
        comboBox_2.setToolTipText("");
        comboBox_2.setBounds(143, 40, 74, 32);
        panel_2_1.add(comboBox_2);
        
        JButton  btnResgistrarHuesped = new JButton("Registrar Huésped");
        btnResgistrarHuesped.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mostrar la ventana de Registrar Huésped
                Interfaz_RegistrarHuesped registrarHuespedFrame = new Interfaz_RegistrarHuesped();
                registrarHuespedFrame.setVisible(true);
                registrarHuespedFrame.setLocationRelativeTo(null); // Centrar la ventana secundaria
            }
        });
        
        
        btnResgistrarHuesped.setForeground(Color.WHITE);
        btnResgistrarHuesped.setFont(new Font("Calibri", Font.PLAIN, 14));
        btnResgistrarHuesped.setBackground(new Color(63, 63, 63));
        btnResgistrarHuesped.setBounds(495, 114, 143, 34);
        panel_2_1.add(btnResgistrarHuesped);
        
        JButton btnEliminarHuesped = new JButton("Eliminar Huésped");
        btnEliminarHuesped.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Mostrar la ventana de Eliminar Huésped
        		Interfaz_EliminarHuesped registrarHuespedFrame = new Interfaz_EliminarHuesped();
                registrarHuespedFrame.setVisible(true);
                registrarHuespedFrame.setLocationRelativeTo(null); // Centrar la ventana secundaria
        	}
        });
        btnEliminarHuesped.setForeground(Color.WHITE);
        btnEliminarHuesped.setFont(new Font("Calibri", Font.PLAIN, 14));
        btnEliminarHuesped.setBackground(new Color(63, 63, 63));
        btnEliminarHuesped.setBounds(495, 159, 143, 34);
        panel_2_1.add(btnEliminarHuesped);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBackground(Color.WHITE);
        scrollPane_1.getViewport().setBackground(Color.WHITE); // Color de fondo del viewport
        scrollPane_1.setBackground(Color.WHITE); // Color de fondo del scrollPane
        scrollPane_1.setBounds(20, 88, 458, 128);
        panel_2_1.add(scrollPane_1);

        // Definir las columnas antes de establecer el modelo en la tabla_1
        tablaFuncional1.addColumn("DNI");
        tablaFuncional1.addColumn("Nombre");
        tablaFuncional1.addColumn("Apellido");

        table_1 = new JTable(tablaFuncional1);
        table_1.setFont(new Font("Calibri", Font.PLAIN, 12));
        table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        table_1.setBackground(Color.WHITE);
        table_1.getTableHeader().setBackground(new Color(206, 157, 255)); // Color de fondo del header
        table_1.getTableHeader().setForeground(Color.BLACK); // Color del texto del header
        
        // Aplicar el renderer personalizado a las celdas de table_1
        table_1.setDefaultRenderer(Object.class, cellRenderer);

        scrollPane_1.setViewportView(table_1);
        
        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.activeCaption, null));
        panel_5.setBounds(20, 40, 197, 32);
        panel_2_1.add(panel_5);
        panel_5.setLayout(null);
        
        JLabel lblCantidadHusped = new JLabel("Cantidad Huésped");
        lblCantidadHusped.setBounds(6, 3, 113, 32);
        panel_5.add(lblCantidadHusped);
        lblCantidadHusped.setFont(new Font("Calibri", Font.BOLD, 14));
        
        JLabel lblNewLabel_2_1_1 = new JLabel("Seleccione método de pago");
        lblNewLabel_2_1_1.setFont(new Font("Calibri", Font.BOLD, 16));
        lblNewLabel_2_1_1.setBounds(20, 238, 203, 22);
        panel_2_1.add(lblNewLabel_2_1_1);
        
        
        rdbtnCredito = new JRadioButton("Crédito");
        rdbtnCredito.setBackground(new Color(255, 255, 255));
        rdbtnCredito.setFont(new Font("Calibri", Font.PLAIN, 15));
        rdbtnCredito.setActionCommand("rdbtnCredito");
        rdbtnCredito.setBounds(20, 267, 109, 23);
        panel_2_1.add(rdbtnCredito);

        // Botón de débito
        rdbtnDebito = new JRadioButton("Débito");
        rdbtnDebito.setBackground(new Color(255, 255, 255));
        rdbtnDebito.setFont(new Font("Calibri", Font.PLAIN, 15));
        rdbtnDebito.setActionCommand("rdbtnDebito");
        rdbtnDebito.setBounds(20, 293, 109, 23);
        panel_2_1.add(rdbtnDebito);

        // Botón de transferencia
        rdbtnTransferencia = new JRadioButton("Transferencia");
        rdbtnTransferencia.setBackground(new Color(255, 255, 255));
        rdbtnTransferencia.setFont(new Font("Calibri", Font.PLAIN, 15));
        rdbtnTransferencia.setActionCommand("rdbtnTransferencia");
        rdbtnTransferencia.setBounds(20, 319, 109, 23);
        panel_2_1.add(rdbtnTransferencia);

        // Agrega los botones al grupo
        grupoMetodoPago.add(rdbtnCredito);
        grupoMetodoPago.add(rdbtnDebito);
        grupoMetodoPago.add(rdbtnTransferencia);
        
        JLabel lblNewLabel_2_1_1_1 = new JLabel("Monto:");
        lblNewLabel_2_1_1_1.setFont(new Font("Calibri", Font.BOLD, 16));
        lblNewLabel_2_1_1_1.setBounds(495, 320, 62, 22);
        panel_2_1.add(lblNewLabel_2_1_1_1);
        
        JLabel signo = new JLabel("$");
        signo.setFont(new Font("Calibri", Font.PLAIN, 16));
        signo.setBounds(556, 320, 18, 22);
        panel_2_1.add(signo);
    }
    
    
    // Renderer personalizado para las celdas
    class CustomTableCellRenderer extends JPanel implements TableCellRenderer {
        private JLabel label;

        public CustomTableCellRenderer() {
            setLayout(new java.awt.BorderLayout());
            label = new JLabel();
            label.setOpaque(true);
            add(label, java.awt.BorderLayout.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            label.setText(value != null ? value.toString() : "");
            label.setBackground(new Color(206, 157, 255)); // Color de fondo específico
            label.setForeground(Color.BLACK);
            return this;
        }
    }
}

class BackgroundPanel4 extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel4() {
        // Cargar la imagen
        ImageIcon icon = new ImageIcon("C:\\Users\\marti\\Documents\\GitHub\\Gestion-Hotel\\gestionHoteles\\img\\blob-login.png");
        backgroundImage = icon.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen escalada para llenar todo el panel
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
