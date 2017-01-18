/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dima
 */
public class PointModel {
    
    private double[] features;
    private int classLabel;

    public PointModel(double[] features, int classLabel) {
        this.features = features;
        this.classLabel = classLabel;
    }

    public int getClassLabel() {
        return classLabel;
    }

    public double[] getFeatures() {
        return features;
    }
    
}
