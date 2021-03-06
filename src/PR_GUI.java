
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import Jama.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * PR_GUI.java
 *
 * Created on 2015-03-05, 19:40:56
 */
/**
 *
 * @author krzy
 */
public class PR_GUI extends javax.swing.JFrame {

    String InData; // dataset from a text file will be placed here
    int ClassCount = 0, FeatureCount = 0;
    double[][] F, FNew; // original feature matrix and transformed feature matrix
    int[] ClassLabels, SampleCount;
    String[] ClassNames;

    /**
     * Creates new form PR_GUI
     */
    public PR_GUI() {
        initComponents();
        setSize(720, 410);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbg_F = new javax.swing.ButtonGroup();
        b_read = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        l_dataset_name_l = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        l_dataset_name = new javax.swing.JLabel();
        l_nfeatures = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        selbox_nfeat = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        f_rb_extr = new javax.swing.JRadioButton();
        f_rb_sel = new javax.swing.JRadioButton();
        b_deriveFS = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        f_combo_criterion = new javax.swing.JComboBox();
        f_combo_PCA_LDA = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        tf_PCA_Energy = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        l_NewDim = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        methodComboBox = new javax.swing.JComboBox();
        b_Train = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        tf_TrainSetSize = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        resLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        k_input = new javax.swing.JTextField();
        bootstrap_btn = new javax.swing.JButton();
        bootstrap_repeats_label = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        crossvalidation_btn = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        parts_input = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        l_FLD_winner = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        l_FLD_val = new javax.swing.JLabel();
        SFSbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 500));
        getContentPane().setLayout(null);

        b_read.setText("Read dataset");
        b_read.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_readActionPerformed(evt);
            }
        });
        getContentPane().add(b_read);
        b_read.setBounds(20, 10, 130, 35);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setText("Dataset info");

        l_dataset_name_l.setText("Name:");

        jLabel3.setText("Classes:");

        jLabel4.setText("Features:");

        l_dataset_name.setText("...");

        l_nfeatures.setText("...");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(l_dataset_name_l)
                        .addGap(18, 18, 18)
                        .addComponent(l_dataset_name, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l_nfeatures, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(105, 105, 105))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_dataset_name_l)
                    .addComponent(jLabel4)
                    .addComponent(l_dataset_name)
                    .addComponent(l_nfeatures))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 50, 320, 80);

        jButton2.setText("Parse dataset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(190, 10, 130, 35);

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel5.setText("Feature space");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(14, 2, 123, 22);

        jLabel6.setText("FS Dimension");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(178, 9, 91, 21);

        selbox_nfeat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        selbox_nfeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selbox_nfeatActionPerformed(evt);
            }
        });
        jPanel3.add(selbox_nfeat);
        selbox_nfeat.setBounds(268, 6, 57, 31);
        jPanel3.add(jSeparator1);
        jSeparator1.setBounds(14, 41, 290, 10);

        f_rb_extr.setBackground(new java.awt.Color(255, 255, 204));
        rbg_F.add(f_rb_extr);
        f_rb_extr.setText("Feature extraction");
        f_rb_extr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f_rb_extrActionPerformed(evt);
            }
        });
        jPanel3.add(f_rb_extr);
        f_rb_extr.setBounds(10, 110, 146, 23);

        f_rb_sel.setBackground(new java.awt.Color(255, 255, 204));
        rbg_F.add(f_rb_sel);
        f_rb_sel.setSelected(true);
        f_rb_sel.setText("Feature selection");
        f_rb_sel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f_rb_selActionPerformed(evt);
            }
        });
        jPanel3.add(f_rb_sel);
        f_rb_sel.setBounds(10, 60, 139, 23);

        b_deriveFS.setText("Derive Feature Space");
        b_deriveFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_deriveFSActionPerformed(evt);
            }
        });
        jPanel3.add(b_deriveFS);
        b_deriveFS.setBounds(10, 180, 292, 35);

        jLabel10.setText("Criterion");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(200, 50, 59, 21);

        f_combo_criterion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fisher discriminant", "Classification error" }));
        f_combo_criterion.setEnabled(false);
        jPanel3.add(f_combo_criterion);
        f_combo_criterion.setBounds(160, 70, 140, 31);

        f_combo_PCA_LDA.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PCA", "LDA" }));
        f_combo_PCA_LDA.setEnabled(false);
        jPanel3.add(f_combo_PCA_LDA);
        f_combo_PCA_LDA.setBounds(190, 110, 70, 31);

        jLabel12.setText("Energy");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(20, 150, 47, 21);

        tf_PCA_Energy.setText("80");
        jPanel3.add(tf_PCA_Energy);
        tf_PCA_Energy.setBounds(70, 150, 30, 31);

        jLabel14.setText("%");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(110, 150, 20, 21);

        jLabel15.setText("New dimension:");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(160, 150, 150, 21);

        l_NewDim.setText("...");
        jPanel3.add(l_NewDim);
        l_NewDim.setBounds(270, 150, 30, 21);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(10, 170, 330, 220);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(350, 140, 160, 130);

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel8.setText("Classifier");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(10, 0, 79, 22);

        jLabel9.setText("Method");
        jPanel4.add(jLabel9);
        jLabel9.setBounds(14, 44, 52, 21);

        methodComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nearest neighbor (NN)", "Nearest Mean (NM)", "k-Nearest Neighbor (k-NN)", "k-Nearest Mean (k-NM)" }));
        jPanel4.add(methodComboBox);
        methodComboBox.setBounds(74, 41, 220, 31);

        b_Train.setText("Train");
        b_Train.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_TrainActionPerformed(evt);
            }
        });
        jPanel4.add(b_Train);
        b_Train.setBounds(40, 130, 98, 35);

        jButton4.setText("Execute");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4);
        jButton4.setBounds(210, 130, 96, 35);

        jLabel16.setText("Training part:");
        jPanel4.add(jLabel16);
        jLabel16.setBounds(20, 170, 80, 21);

        tf_TrainSetSize.setText("80");
        jPanel4.add(tf_TrainSetSize);
        tf_TrainSetSize.setBounds(100, 170, 30, 31);

        jLabel17.setText("%");
        jPanel4.add(jLabel17);
        jLabel17.setBounds(140, 170, 20, 21);
        jPanel4.add(resLabel);
        resLabel.setBounds(140, 90, 90, 30);

        jLabel7.setText("K:");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(30, 90, 20, 21);

        k_input.setText("5");
        jPanel4.add(k_input);
        k_input.setBounds(50, 80, 50, 31);

        bootstrap_btn.setText("bootstrap");
        bootstrap_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bootstrap_btnActionPerformed(evt);
            }
        });
        jPanel4.add(bootstrap_btn);
        bootstrap_btn.setBounds(10, 210, 130, 35);

        bootstrap_repeats_label.setText("100");
        jPanel4.add(bootstrap_repeats_label);
        bootstrap_repeats_label.setBounds(70, 250, 60, 31);

        jLabel11.setText("Repeats");
        jPanel4.add(jLabel11);
        jLabel11.setBounds(10, 250, 54, 21);

        crossvalidation_btn.setText("cross-validation");
        crossvalidation_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crossvalidation_btnActionPerformed(evt);
            }
        });
        jPanel4.add(crossvalidation_btn);
        crossvalidation_btn.setBounds(180, 210, 160, 35);

        jLabel18.setText("Parts:");
        jPanel4.add(jLabel18);
        jLabel18.setBounds(160, 250, 38, 21);

        parts_input.setText("25");
        jPanel4.add(parts_input);
        parts_input.setBounds(230, 250, 30, 30);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(520, 140, 350, 290);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Results"));
        jPanel5.setLayout(null);

        jLabel2.setText("FS Winner:");
        jPanel5.add(jLabel2);
        jLabel2.setBounds(10, 30, 80, 21);

        l_FLD_winner.setText("xxx");
        jPanel5.add(l_FLD_winner);
        l_FLD_winner.setBounds(90, 30, 430, 21);

        jLabel13.setText("FLD value: ");
        jPanel5.add(jLabel13);
        jLabel13.setBounds(10, 60, 80, 21);

        l_FLD_val.setText("vvv");
        jPanel5.add(l_FLD_val);
        l_FLD_val.setBounds(90, 60, 430, 21);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(340, 10, 530, 130);

        SFSbtn.setText("SFS");
        SFSbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SFSbtnActionPerformed(evt);
            }
        });
        getContentPane().add(SFSbtn);
        SFSbtn.setBounds(390, 370, 90, 35);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void f_rb_selActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_rb_selActionPerformed
        f_combo_criterion.setEnabled(true);
        f_combo_PCA_LDA.setEnabled(false);
    }//GEN-LAST:event_f_rb_selActionPerformed

    private void f_rb_extrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_rb_extrActionPerformed
        f_combo_criterion.setEnabled(false);
        f_combo_PCA_LDA.setEnabled(true);
    }//GEN-LAST:event_f_rb_extrActionPerformed

    private void b_readActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_readActionPerformed
        // reads in a text file; contents is placed into a variable of String type
        InData = readDataSet();
    }//GEN-LAST:event_b_readActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Analyze text inputted from a file: determine class number and labels and number
        // of features; build feature matrix: columns - samples, rows - features
        try {
            if (InData != null) {
                getDatasetParameters();
                l_nfeatures.setText(FeatureCount + "");
                fillFeatureMatrix();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void b_deriveFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_deriveFSActionPerformed

        // derive optimal feature space
        if (F == null) {
            return;
        }
        if (f_rb_sel.isSelected()) {
            // the chosen strategy is feature selection
            int[] flags = new int[FeatureCount];

            selectFeatures(flags, dimenssionFisher);
        } else if (f_rb_extr.isSelected()) {
            double TotEnergy = Double.parseDouble(tf_PCA_Energy.getText()) / 100.0;
            // Target dimension (if k>0) or flag for energy-based dimension (k=0)
            int k = 0;
//            double[][] FF = { {1,1}, {1,2}};
//            double[][] FF = { {-2,0,2}, {-1,0,1}};
            // F is an array of initial features, FNew is the resulting array
            double[][] FFNorm = centerAroundMean(F);
            Matrix Cov = computeCovarianceMatrix(FFNorm);
            Matrix TransformMat = extractFeatures(Cov, TotEnergy, k);
            FNew = projectSamples(new Matrix(FFNorm), TransformMat);
            // FNew is a matrix with samples projected to a new feature space
            l_NewDim.setText(FNew.length + "");
        }
    }//GEN-LAST:event_b_deriveFSActionPerformed

    Classifier Cl;

    private void b_TrainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_TrainActionPerformed
        // first step: split dataset (in new feature space) into training / testing parts
        if (F == null || fisherWinnersIndexes == null) {
            return; // no reduced feature space have been derived
        }

        Cl = new Classifier(ClassLabels);
        Cl.generateTraining_and_Test_Sets(getSubF(), tf_TrainSetSize.getText());
    }//GEN-LAST:event_b_TrainActionPerformed

    private void selbox_nfeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selbox_nfeatActionPerformed
        dimenssionFisher = Integer.parseInt((String) selbox_nfeat.getSelectedItem());
    }//GEN-LAST:event_selbox_nfeatActionPerformed

    private void SFSbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SFSbtnActionPerformed
        SFS(dimenssionFisher);
    }//GEN-LAST:event_SFSbtnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (Cl == null) {
            return;
        }

        double result = 0;

        switch (methodComboBox.getSelectedIndex()) {
            case 0:
                result = Cl.trainClassifierNN();
                break;
            case 1:
                result = Cl.trainClassifierNM();
                break;
            case 2:
                result = Cl.trainClassifierKNN(Integer.parseInt(k_input.getText()));
                break;
            case 3:
                result = Cl.trainClassifierKNM(Integer.parseInt(k_input.getText()));
                break;
            default:
                return;
        }

        resLabel.setText(result + "%");
    }//GEN-LAST:event_jButton4ActionPerformed

    private double[][] getSubF() {
        double[][] data = new double[fisherWinnersIndexes.size()][F[0].length];

        for (int i = 0; i < fisherWinnersIndexes.size(); ++i) {
            data[i] = F[fisherWinnersIndexes.get(i)];
        }

        return data;
    }

    private void bootstrap_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bootstrap_btnActionPerformed
        if (Cl == null) {
            Cl = new Classifier(ClassLabels);
        }

        if (fisherWinnersIndexes == null) {
            return;
        }

        System.out.println("------->>>> bootstrap...");

        int reps = Integer.parseInt(bootstrap_repeats_label.getText());
        int k = Integer.parseInt(k_input.getText());

        double[] res = new double[4];

        for (int i = 0; i < reps; ++i) {
            double[] tmp = Cl.bootstrap(getSubF(), reps, k);
            for (int j = 0; j < tmp.length; ++j) {
                res[j] += tmp[j];
            }
        }

        for (int i = 0; i < res.length; ++i) {
            res[i] /= reps;
        }

        System.out.println("NN: " + res[0] + "%");
        System.out.println("NM: " + res[1] + "%");
        System.out.println("KNN: " + res[2] + "%");
        System.out.println("KNM: " + res[3] + "%");
    }//GEN-LAST:event_bootstrap_btnActionPerformed

    private void crossvalidation_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crossvalidation_btnActionPerformed
        if (Cl == null) {
            Cl = new Classifier(ClassLabels);
        }

        if (fisherWinnersIndexes == null) {
            return;
        }

        System.out.println("------->>>> Cross-Validation...");

        int k = Integer.parseInt(k_input.getText());
        int parts = Integer.parseInt(parts_input.getText());

        Cl.crossValidation(getSubF(), parts, k);
    }//GEN-LAST:event_crossvalidation_btnActionPerformed

    private int dimenssionFisher;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PR_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SFSbtn;
    private javax.swing.JButton b_Train;
    private javax.swing.JButton b_deriveFS;
    private javax.swing.JButton b_read;
    private javax.swing.JButton bootstrap_btn;
    private javax.swing.JTextField bootstrap_repeats_label;
    private javax.swing.JButton crossvalidation_btn;
    private javax.swing.JComboBox f_combo_PCA_LDA;
    private javax.swing.JComboBox f_combo_criterion;
    private javax.swing.JRadioButton f_rb_extr;
    private javax.swing.JRadioButton f_rb_sel;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField k_input;
    private javax.swing.JLabel l_FLD_val;
    private javax.swing.JLabel l_FLD_winner;
    private javax.swing.JLabel l_NewDim;
    private javax.swing.JLabel l_dataset_name;
    private javax.swing.JLabel l_dataset_name_l;
    private javax.swing.JLabel l_nfeatures;
    private javax.swing.JComboBox methodComboBox;
    private javax.swing.JTextField parts_input;
    private javax.swing.ButtonGroup rbg_F;
    private javax.swing.JLabel resLabel;
    private javax.swing.JComboBox selbox_nfeat;
    private javax.swing.JTextField tf_PCA_Energy;
    private javax.swing.JTextField tf_TrainSetSize;
    // End of variables declaration//GEN-END:variables

    private String readDataSet() {

        String s_tmp, s_out = "";
        JFileChooser jfc = new JFileChooser();
        jfc.setCurrentDirectory(new File(".."));
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Datasets - plain text files", "txt");
        jfc.setFileFilter(filter);
        if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(jfc.getSelectedFile()));
                while ((s_tmp = br.readLine()) != null) {
                    s_out += s_tmp + '$';
                }
                br.close();
                l_dataset_name.setText(jfc.getSelectedFile().getName());
            } catch (Exception e) {
            }
        }
        return s_out;
    }

    private void getDatasetParameters() throws Exception {
        // based on data stored in InData determine: class count and names, number of samples 
        // and number of features; set the corresponding variables
        String stmp = InData, saux = "";
        // analyze the first line and get feature count: assume that number of features
        // equals number of commas
        saux = InData.substring(InData.indexOf(',') + 1, InData.indexOf('$'));
        if (saux.length() == 0) {
            throw new Exception("The first line is empty");
        }
        // saux stores the first line beginning from the first comma
        int count = 0;
        while (saux.indexOf(',') > 0) {
            saux = saux.substring(saux.indexOf(',') + 1);
            count++;
        }
        FeatureCount = count + 1; // the first parameter
        // Determine number of classes, class names and number of samples per class
        boolean New;
        int index = -1;
        List<String> NameList = new ArrayList<String>();
        List<Integer> CountList = new ArrayList<Integer>();
        List<Integer> LabelList = new ArrayList<Integer>();
        while (stmp.length() > 1) {
            saux = stmp.substring(0, stmp.indexOf(' '));
            New = true;
            index++; // new class index
            for (int i = 0; i < NameList.size(); i++) {
                if (saux.equals(NameList.get(i))) {
                    New = false;
                    index = i; // class index
                }
            }
            if (New) {
                NameList.add(saux);
                CountList.add(0);
            } else {
                CountList.set(index, CountList.get(index).intValue() + 1);
            }
            LabelList.add(index); // class index for current row
            stmp = stmp.substring(stmp.indexOf('$') + 1);
        }
        // based on results of the above analysis, create variables
        ClassNames = new String[NameList.size()];
        for (int i = 0; i < ClassNames.length; i++) {
            ClassNames[i] = NameList.get(i);
        }
        SampleCount = new int[CountList.size()];
        for (int i = 0; i < SampleCount.length; i++) {
            SampleCount[i] = CountList.get(i).intValue() + 1;
        }
        ClassLabels = new int[LabelList.size()];
        for (int i = 0; i < ClassLabels.length; i++) {
            ClassLabels[i] = LabelList.get(i).intValue();
        }
    }

    private void fillFeatureMatrix() throws Exception {
        // having determined array size and class labels, fills in the feature matrix
        int n = 0;
        String saux, stmp = InData;
        for (int i = 0; i < SampleCount.length; i++) {
            n += SampleCount[i];
        }
        if (n <= 0) {
            throw new Exception("no samples found");
        }
        F = new double[FeatureCount][n]; // samples are placed column-wise
        for (int j = 0; j < n; j++) {
            saux = stmp.substring(0, stmp.indexOf('$'));
            saux = saux.substring(stmp.indexOf(',') + 1);
            for (int i = 0; i < FeatureCount - 1; i++) {
                F[i][j] = Double.parseDouble(saux.substring(0, saux.indexOf(',')));
                saux = saux.substring(saux.indexOf(',') + 1);
            }
            F[FeatureCount - 1][j] = Double.parseDouble(saux);
            stmp = stmp.substring(stmp.indexOf('$') + 1);
        }
        int cc = 1;
    }

    private void selectFeatures(int[] flags, int d) {
        if (d == 1 || d == 0) {
            double FLD = 0, tmp;
            int max_ind = -1;
            for (int i = 0; i < FeatureCount; i++) {
                if ((tmp = computeFisherLD(F[i])) > FLD) {
                    FLD = tmp;
                    max_ind = i;
                }
            }
            l_FLD_winner.setText(max_ind + "");
            l_FLD_val.setText(FLD + "");
            return;
        }

        CombinationsGenerator cominationsGenerator = new CombinationsGenerator(FeatureCount, d);

        List<int[]> combinations = cominationsGenerator.getCombinations();

        double FLD = 0, tmp;
        int index = -1;

        ArrayList<double[]> set = new ArrayList<double[]>();

        double[][] arr = new double[d][F[0].length];

        for (int i = 0; i < combinations.size(); ++i) {
            for (int j = 0; j < d; ++j) {
                arr[j] = F[combinations.get(i)[j]];
                tmp = computeFisherLD(arr, d);
                System.out.println(Arrays.toString(combinations.get(i)) + " FLD: " + tmp);
                if (tmp > FLD) {
                    if (tmp == Double.POSITIVE_INFINITY) {
                        tmp = 0;
                    }
                    FLD = tmp;
                    index = i;
                }
            }
        }
        l_FLD_winner.setText(Arrays.toString(combinations.get(index)));
        l_FLD_val.setText(FLD + "");
    }

    List<Integer> fisherWinnersIndexes;

    private void SFS(int d) {
        if (d < 1) {
            d = 1;
        }
        
        if (F == null)
            return;

        List<Integer> indexes = new ArrayList<Integer>();
        double tmp = 0, FLD = 0;
        double[][] f;

        while (indexes.size() != d) {

            indexes.add(0);
            f = new double[indexes.size()][F[0].length];
            for (int j = 0; j < indexes.size(); ++j) {
                f[j] = F[indexes.get(j)];
            }
            for (int i = 0; i < F.length; ++i) {
                if (!indexes.contains(i)) {

                    f[indexes.size() - 1] = F[i];

                    if (indexes.size() <= 1) {
                        tmp = computeFisherLD(F[i]);
                    } else {
                        tmp = computeFisherLD(f, indexes.size());
                    }
                    
                    if (tmp > FLD) {
                        FLD = tmp;
                        indexes.set(indexes.size() - 1, i);
                    }
                }
            }
        }
        fisherWinnersIndexes = indexes;
        l_FLD_winner.setText(Arrays.toString(indexes.toArray()));
        l_FLD_val.setText(FLD + "");
    }

    private double computeFisherLD(double[] vec) {
        // 1D, 2-classes
        double mA = 0, mB = 0, sA = 0, sB = 0;
        for (int i = 0; i < vec.length; i++) {
            if (ClassLabels[i] == 0) {
                mA += vec[i];
                sA += vec[i] * vec[i];
            } else {
                mB += vec[i];
                sB += vec[i] * vec[i];
            }
        }
        mA /= SampleCount[0];
        mB /= SampleCount[1];
        sA = sA / SampleCount[0] - mA * mA;
        sB = sB / SampleCount[1] - mB * mB;
        return Math.abs(mA - mB) / (Math.sqrt(sA) + Math.sqrt(sB));
    }

    private double computeFisherLD(double[][] vec, int dim) { ///funkcja Fishera n cech

        double[] mA = new double[dim], mB = new double[dim];
        double[][] sA = new double[dim][], sB = new double[dim][];
        double licznik = 0, mianownik = 0;
        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec[i].length; j++) {
                if (ClassLabels[j] == 0) {
                    mA[i] += vec[i][j];
                    //sA[i] += vec[i][j]*vec[i][j];
                } else {
                    mB[i] += vec[i][j];
                    //sB[i]+= vec[i][j]*vec[i][j];
                }
            }

            mA[i] /= SampleCount[0];
            mB[i] /= SampleCount[1];
            sA[i] = new double[SampleCount[0]];
            sB[i] = new double[SampleCount[1]];
            for (int j = 0, a = 0, b = 0; j < vec[i].length; j++) {
                if (ClassLabels[j] == 0) {
                    sA[i][a++] = vec[i][j] - mA[i];
                } else {
                    sB[i][b++] = vec[i][j] - mB[i];
                }
            }
            licznik += (mA[i] - mB[i]) * (mA[i] - mB[i]);

        }
        licznik = Math.sqrt(licznik);
        Matrix macierz = computeCovarianceMatrix(sA);
        //macierz = macierz.times(1 / SampleCount[0]);
        mianownik = computeCovarianceMatrix(sA).det()
                + computeCovarianceMatrix(sB).det();
        return licznik / mianownik;
    }

    private Matrix extractFeatures(Matrix C, double Ek, int k) {

        Matrix evecs, evals;
        // compute eigenvalues and eigenvectors
        evecs = C.eig().getV();
        evals = C.eig().getD();

        // PM: projection matrix that will hold a set dominant eigenvectors
        Matrix PM;
        if (k > 0) {
            // preset dimension of new feature space
//            PM = new double[evecs.getRowDimension()][k];
            PM = evecs.getMatrix(0, evecs.getRowDimension() - 1,
                    evecs.getColumnDimension() - k, evecs.getColumnDimension() - 1);
        } else {
            // dimension will be determined based on scatter energy
            double TotEVal = evals.trace(); // total energy
            double EAccum = 0;
            int m = evals.getColumnDimension() - 1;
            while (EAccum < Ek * TotEVal) {
                EAccum += evals.get(m, m);
                m--;
            }
            PM = evecs.getMatrix(0, evecs.getRowDimension() - 1, m + 1, evecs.getColumnDimension() - 1);
        }

        /*            System.out.println("Eigenvectors");                
            for(int i=0; i<r; i++){
                for(int j=0; j<c; j++){
                    System.out.print(evecs[i][j]+" ");
                }
                System.out.println();                
            }
            System.out.println("Eigenvalues");                
            for(int i=0; i<r; i++){
                for(int j=0; j<c; j++){
                    System.out.print(evals[i][j]+" ");
                }
                System.out.println();                
            }
         */
        return PM;
    }

    private Matrix computeCovarianceMatrix(double[][] m) {
//        double[][] C = new double[M.length][M.length];

        Matrix M = new Matrix(m);
        Matrix MT = M.transpose();
        Matrix C = M.times(MT);
        return C;
    }

    private double[][] centerAroundMean(double[][] M) {

        double[] mean = new double[M.length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                mean[i] += M[i][j];
            }
        }
        for (int i = 0; i < M.length; i++) {
            mean[i] /= M[0].length;
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                M[i][j] -= mean[i];
            }
        }
        return M;
    }

    private double[][] projectSamples(Matrix FOld, Matrix TransformMat) {

        return (FOld.transpose().times(TransformMat)).transpose().getArrayCopy();
    }
}
