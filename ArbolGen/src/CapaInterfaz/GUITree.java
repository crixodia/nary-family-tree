package CapaInterfaz;

import CapaNegocio.GenObj;
import CapaNegocio.Node;
import CapaNegocio.Tree;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

public class GUITree extends javax.swing.JFrame {

    Tree arbol;
    boolean flag = true;

    public GenObj o2;
    public JComboBox cbm;

    FileNameExtensionFilter ff = new FileNameExtensionFilter("GenObjTree .gentree", "gentree");
    ImageIcon icon = new ImageIcon(".//res//tree.png");

    public GUITree() {
        initComponents();
        this.setIconImage(icon.getImage());

        DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) TreeView.getCellRenderer();
        renderer.setLeafIcon(null);
        renderer.setClosedIcon(null);
        renderer.setOpenIcon(null);

        fileDialog.addChoosableFileFilter(ff);
        fileDialog.setFileFilter(ff);
        fileDialog.setSelectedFile(new File("*.gentree"));
        fileDialog.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        fileDialog.setApproveButtonText("");
        fileDialog.setApproveButtonToolTipText("");
        fileDialog.setDialogTitle("Seleccione una ubicación");
        fileDialog.setFileFilter(ff);
        fileDialog.setDragEnabled(true);

        cbm = this.ComboNodos;
        this.TreeView.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) TreeView.getLastSelectedPathComponent();
                if (selectedNode != null) {
                    String[] sp = selectedNode.toString().trim().split(":");
                    GenObj o = new GenObj(sp[0], sp.length > 1 ? sp[1] : "");
                    Node n = arbol.searchNode(o);
                    o2 = (GenObj) n.getRoot();
                    System.out.println(o);
                }
                cbm.setSelectedItem(o2.toString());
                System.out.println("Nodo seleccionado: " + selectedNode);
                updateData();
            }
        });

        defaultTree();
        updateGui();
    }

    public void updateData() {
        if (this.o2 != null) {
            this.LblCNombre.setText(o2.getNombre());
            this.LblCConyuge.setText(o2.getConyuge());
            this.LblCAnioNace.setText(Integer.toString(o2.getAnioNace()));
            this.LblCAnioFallece.setText(Integer.toString(o2.getAnioFallece()));
        }
    }

    private void updateGui() {
        TreeView.setModel(new DefaultTreeModel(Tree.text2DTree(arbol.toString())));
        this.ComboNodos.removeAllItems();
        for (String line : arbol.nodes2StringArray()) {
            this.ComboNodos.addItem(line);
        }
    }

    private void defaultTree() {
        GenObj urano = new GenObj("Urano", "Gea", 1, 2);
        GenObj afrodita = new GenObj("Afrodita", "", 3, 4);
        GenObj cronos = new GenObj("Cronos", "Rea", 5, 6);
        GenObj atlas = new GenObj("Atlas", "", 7, 8);
        GenObj prometeo = new GenObj("Prometeo", "", 9, 10);
        GenObj eros = new GenObj("Eros", "", 11, 12);
        GenObj zeus = new GenObj("Zeus", "", 13, 14);
        GenObj poseidon = new GenObj("Poseidón", "", 15, 16);
        GenObj hades = new GenObj("Hades", "", 17, 18);
        GenObj ares = new GenObj("Ares", "", 19, 20);
        GenObj apolo = new GenObj("Apolo", "", 21, 22);
        GenObj atenea = new GenObj("Atenea", "", 23, 24);
        GenObj hermes = new GenObj("Hermes", "", 25, 26);
        GenObj heracles = new GenObj("Heracles", "", 27, 28);

        arbol = new Tree(urano);
        arbol.addNewNode(urano, afrodita);
        arbol.addNewNode(afrodita, eros);

        arbol.addNewNode(urano, cronos);

        arbol.addNewNode(cronos, zeus);
        arbol.addNewNode(zeus, apolo);
        arbol.addNewNode(zeus, atenea);
        arbol.addNewNode(zeus, hermes);
        arbol.addNewNode(zeus, heracles);

        arbol.addNewNode(cronos, poseidon);
        arbol.addNewNode(cronos, hades);
        arbol.addNewNode(cronos, ares);

        arbol.addNewNode(urano, atlas);
        arbol.addNewNode(urano, prometeo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileDialog = new javax.swing.JFileChooser();
        TxtAnioFallece = new javax.swing.JTextField();
        BtnInsertar = new javax.swing.JButton();
        ComboNodos = new javax.swing.JComboBox<>();
        BtnEliminar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnExpanAll = new javax.swing.JButton();
        BtnNuevo = new javax.swing.JButton();
        LblNombre = new javax.swing.JLabel();
        LblConyuge = new javax.swing.JLabel();
        LblAnioNace = new javax.swing.JLabel();
        LblAnioFallece = new javax.swing.JLabel();
        Scroll = new javax.swing.JScrollPane();
        TreeView = new javax.swing.JTree();
        TxtNombre = new javax.swing.JTextField();
        TxtConyuge = new javax.swing.JTextField();
        TxtAnioNace = new javax.swing.JTextField();
        LblAnioFallece1 = new javax.swing.JLabel();
        LblAnioNace1 = new javax.swing.JLabel();
        LblConyuge1 = new javax.swing.JLabel();
        LblNombre1 = new javax.swing.JLabel();
        LblCNombre = new javax.swing.JLabel();
        LblCAnioFallece = new javax.swing.JLabel();
        LblCAnioNace = new javax.swing.JLabel();
        LblCConyuge = new javax.swing.JLabel();
        BtnAbrir = new javax.swing.JButton();
        BtnGuardar = new javax.swing.JButton();
        LblTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GenTree");
        setResizable(false);

        BtnInsertar.setText("Insertar");
        BtnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInsertarActionPerformed(evt);
            }
        });

        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        BtnModificar.setText("Modificar");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        BtnExpanAll.setText("Expandir");
        BtnExpanAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExpanAllActionPerformed(evt);
            }
        });

        BtnNuevo.setText("Nuevo");
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });

        LblNombre.setText("Nombre:");

        LblConyuge.setText("Conyuge:");

        LblAnioNace.setText("Año de nacimiento:");

        LblAnioFallece.setText("Año fallecimiento:");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("A");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("B");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("C");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("D");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("E");
        treeNode1.add(treeNode2);
        TreeView.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        Scroll.setViewportView(TreeView);

        LblAnioFallece1.setText("Año fallecimiento:");

        LblAnioNace1.setText("Año de nacimiento:");

        LblConyuge1.setText("Conyuge:");

        LblNombre1.setText("Nombre:");

        LblCNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LblCNombre.setText("___");

        LblCAnioFallece.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LblCAnioFallece.setText("___");

        LblCAnioNace.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LblCAnioNace.setText("___");

        LblCConyuge.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LblCConyuge.setText("___");

        BtnAbrir.setText("Abrir");
        BtnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAbrirActionPerformed(evt);
            }
        });

        BtnGuardar.setText("Guardar");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        LblTitle.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        LblTitle.setForeground(new java.awt.Color(51, 0, 255));
        LblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblTitle.setText("Datos de nodo seleccionado");

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Erick Vera, Cristian Bastidas, Carlos Estrada");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("EPN 2021 -Estructura de Datos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ComboNodos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblAnioFallece1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LblConyuge1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LblNombre1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LblAnioNace1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblCAnioNace, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LblCConyuge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LblCAnioFallece, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LblCNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(LblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblAnioFallece, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LblConyuge, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LblNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LblAnioNace, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtConyuge)
                            .addComponent(TxtAnioNace)
                            .addComponent(TxtAnioFallece)
                            .addComponent(TxtNombre)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnExpanAll, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnAbrir)
                            .addComponent(BtnGuardar)
                            .addComponent(BtnNuevo)
                            .addComponent(BtnExpanAll))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblNombre)
                            .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblConyuge)
                            .addComponent(TxtConyuge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblAnioNace)
                            .addComponent(TxtAnioNace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblAnioFallece)
                            .addComponent(TxtAnioFallece, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboNodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnInsertar)
                            .addComponent(BtnEliminar)
                            .addComponent(BtnModificar))
                        .addGap(18, 18, 18)
                        .addComponent(LblTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblNombre1)
                            .addComponent(LblCNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblConyuge1)
                            .addComponent(LblCConyuge, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblAnioNace1)
                            .addComponent(LblCAnioNace, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblAnioFallece1)
                            .addComponent(LblCAnioFallece, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInsertarActionPerformed
        if (this.ComboNodos.getSelectedIndex() != -1) {
            if (this.TxtNombre.getText().equals("")) {
                JOptionPane.showMessageDialog(
                        this,
                        "El nombre es obligatorio"
                );
                this.TxtNombre.requestFocus();
            } else {
                try {
                    int anioNace = this.TxtAnioNace.getText().equals("") ? 0 : Integer.valueOf(this.TxtAnioNace.getText());
                    int anioFallece = this.TxtAnioFallece.getText().equals("") ? 0 : Integer.valueOf(this.TxtAnioFallece.getText());
                    GenObj genobj = new GenObj(
                            this.TxtNombre.getText(),
                            this.TxtConyuge.getText(),
                            anioNace,
                            anioFallece
                    );
                    String[] sp = this.ComboNodos.getSelectedItem().toString().split(":");
                    arbol.addNewNode(new GenObj(sp[0], sp.length > 1 ? sp[1] : ""), genobj);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, e);
                }
                updateGui();
            }
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "No ha seleccionado el padre del nodo a insertar"
            );
        }
    }//GEN-LAST:event_BtnInsertarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        if (this.ComboNodos.getSelectedIndex() != -1) {
            String[] sp = this.ComboNodos.getSelectedItem().toString().split(":");
            GenObj o = new GenObj(sp[0], sp.length > 1 ? sp[1] : "");
            System.out.println("Eliminando a: " + o);

            //long start = System.nanoTime();
            arbol.removeNode(o);
            //long end = System.nanoTime();
            //System.out.println(end - start);
            updateGui();
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "No ha seleccionado el nodo a eliminar"
            );
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnExpanAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExpanAllActionPerformed
        expandAllNodes(this.TreeView, flag);
    }//GEN-LAST:event_BtnExpanAllActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        if (this.ComboNodos.getSelectedIndex() != -1) {
            if (this.TxtNombre.getText().equals("")) {
                JOptionPane.showMessageDialog(
                        this,
                        "El nombre es obligatorio"
                );
                this.TxtNombre.requestFocus();
            } else {
                try {
                    int anioNace = this.TxtAnioNace.getText().equals("") ? 0 : Integer.valueOf(this.TxtAnioNace.getText());
                    int anioFallece = this.TxtAnioFallece.getText().equals("") ? 0 : Integer.valueOf(this.TxtAnioFallece.getText());
                    GenObj genobj = new GenObj(
                            this.TxtNombre.getText(),
                            this.TxtConyuge.getText(),
                            anioNace,
                            anioFallece
                    );
                    String[] sp = this.ComboNodos.getSelectedItem().toString().split(":");
                    if (!arbol.modifyNode(new GenObj(sp[0], sp.length > 1 ? sp[1] : ""), genobj)) {
                        JOptionPane.showMessageDialog(this, "El nodo no se puede modificar porque hay otro nodo con el mismo objeto");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, e);
                }
                updateGui();
            }
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "No ha seleccionado el nodo a modificar"
            );
        }
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        if (this.TxtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(
                    this,
                    "El nombre es obligatorio"
            );
            this.TxtNombre.requestFocus();
        } else {
            try {
                int anioNace = this.TxtAnioNace.getText().equals("") ? 0 : Integer.valueOf(this.TxtAnioNace.getText());
                int anioFallece = this.TxtAnioFallece.getText().equals("") ? 0 : Integer.valueOf(this.TxtAnioFallece.getText());
                GenObj genobj = new GenObj(
                        this.TxtNombre.getText(),
                        this.TxtConyuge.getText(),
                        anioNace,
                        anioFallece
                );
                arbol = new Tree(genobj);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, e);
            }
            updateGui();
        }
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void BtnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAbrirActionPerformed
        fileDialog.setDialogType(javax.swing.JFileChooser.OPEN_DIALOG);
        fileDialog.setDialogTitle("Seleccione un archivo");
        int fd = fileDialog.showDialog(this, "Open");
        if (fd == JFileChooser.APPROVE_OPTION) {
            try {
                File path = fileDialog.getSelectedFile();
                arbol = new Tree(path.toString());
                this.setTitle("GenTree - " + path.toString());
                updateGui();
            } catch (IOException ex) {
                Logger.getLogger(GUITree.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_BtnAbrirActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        int fd = fileDialog.showDialog(this, "Save");
        if (fd == JFileChooser.APPROVE_OPTION) {
            File path = fileDialog.getSelectedFile();
            if (path.exists()) {
                int reply = JOptionPane.showConfirmDialog(
                        this,
                        "¿Desea sobreescribir el archivo seleccionado?",
                        "GenTree",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );
                if (reply == JOptionPane.YES_OPTION) {
                    if (path.delete()) {
                        try {
                            saveFile(path.toString());
                            this.setTitle("GenTree - " + path.toString());
                        } catch (IOException ex) {
                            Logger.getLogger(GUITree.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showConfirmDialog(
                                this,
                                "Un error ha ocurrido",
                                "GenTree",
                                JOptionPane.ERROR,
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                }
            } else {
                try {
                    saveFile(path.toString());
                    this.setTitle("GenTree - " + path.toString());
                } catch (IOException ex) {
                    Logger.getLogger(GUITree.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void saveFile(String path) throws IOException {
        try ( FileWriter writer = new FileWriter(path, true)) {
            writer.write(arbol.toStringText());
        }
    }

    private void expandAllNodes(JTree tree, boolean mode) {
        int j = tree.getRowCount();
        int i = 0;
        while (i < j) {
            if (mode) {
                tree.expandRow(i);
                this.BtnExpanAll.setText("Colapsar");
                flag = false;
            } else {
                tree.collapseRow(i);
                this.BtnExpanAll.setText("Expandir");
                flag = true;
            }
            i += 1;
            j = tree.getRowCount();
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUITree.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUITree.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUITree.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUITree.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, e, "Look and feel error", 0);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUITree().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAbrir;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnExpanAll;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnInsertar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JComboBox<String> ComboNodos;
    private javax.swing.JLabel LblAnioFallece;
    private javax.swing.JLabel LblAnioFallece1;
    private javax.swing.JLabel LblAnioNace;
    private javax.swing.JLabel LblAnioNace1;
    private javax.swing.JLabel LblCAnioFallece;
    private javax.swing.JLabel LblCAnioNace;
    private javax.swing.JLabel LblCConyuge;
    private javax.swing.JLabel LblCNombre;
    private javax.swing.JLabel LblConyuge;
    private javax.swing.JLabel LblConyuge1;
    private javax.swing.JLabel LblNombre;
    private javax.swing.JLabel LblNombre1;
    private javax.swing.JLabel LblTitle;
    private javax.swing.JScrollPane Scroll;
    private javax.swing.JTree TreeView;
    private javax.swing.JTextField TxtAnioFallece;
    private javax.swing.JTextField TxtAnioNace;
    private javax.swing.JTextField TxtConyuge;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JFileChooser fileDialog;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
