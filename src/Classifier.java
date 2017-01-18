
import Jama.Matrix;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dima
 */
class Classifier {

    double[][] TrainingSet, TestSet;
    int[] ClassLabels;
    List<Integer> trainLabels = new ArrayList<Integer>();
    List<Integer> testLabels = new ArrayList<Integer>();
    final int TRAIN_SET = 0, TEST_SET = 1;

    public Classifier(int[] classLabels) {
        ClassLabels = classLabels;
    }

    void generateTraining_and_Test_Sets(double[][] Dataset, String TrainSetSize) {

        int[] Index = new int[Dataset[0].length];
        double Th = Double.parseDouble(TrainSetSize) / 100.0;
        int TrainCount = 0, TestCount = 0;
        for (int i = 0; i < Dataset[0].length; i++) {
            if (Math.random() <= Th) {
                Index[i] = TRAIN_SET;
                TrainCount++;
            } else {
                Index[i] = TEST_SET;
                TestCount++;
            }
        }
        TrainingSet = new double[TrainCount][Dataset.length];
        TestSet = new double[TestCount][Dataset.length];

        Matrix m = new Matrix(Dataset);
        Dataset = m.transpose().getArray();

        TrainCount = 0;
        TestCount = 0;
        // label vectors for training/test sets
        for (int i = 0; i < Index.length; i++) {
            if (Index[i] == TRAIN_SET) {
                System.arraycopy(Dataset[i], 0, TrainingSet[TrainCount++], 0, Dataset[0].length);
                trainLabels.add(ClassLabels[i]);
            } else {
                System.arraycopy(Dataset[i], 0, TestSet[TestCount++], 0, Dataset[0].length);
                testLabels.add(ClassLabels[i]);
            }
        }
    }

    protected double trainClassifierNN() {
        double distance;
        int index = -1;
        int correctCount = 0;
        for (int i = 0; i < TestSet.length; ++i) {
            distance = Double.MAX_VALUE;
            for (int j = 0; j < TrainingSet.length; ++j) {
                double tmpDistance = euklidesDistance(TestSet[i], TrainingSet[j]);
                if (tmpDistance < distance) {
                    distance = tmpDistance;
                    index = j;
                }
            }
            if (trainLabels.get(index).intValue() == testLabels.get(i).intValue()) {
                correctCount++;
            }
        }

        return correctCount * 100 / (TestSet.length);
    }

    protected double trainClassifierNM() {

        int classA = 0;
        int classB = 0;
        int correctCount = 0;

        double[] classAmean = new double[TrainingSet[0].length];
        double[] classBmean = new double[TrainingSet[0].length];

        for (int i = 0; i < TrainingSet.length; ++i) {
            for (int j = 0; j < TrainingSet[0].length; ++j) {
                if (trainLabels.get(i) == 0) {
                    if (j == 0) {
                        classA++;
                    }
                    classAmean[j] += TrainingSet[i][j];
                } else {
                    if (j == 0) {
                        classB++;
                    }
                    classBmean[j] += TrainingSet[i][j];
                }
            }
        }

        for (int i = 0; i < TrainingSet[0].length; ++i) {
            classAmean[i] /= classA;
            classBmean[i] /= classB;
        }

        for (int i = 0; i < TestSet.length; ++i) {
            double distanceA = euklidesDistance(TestSet[i], classAmean);
            double distanceB = euklidesDistance(TestSet[i], classBmean);

            if (distanceA < distanceB) {
                if (0 == testLabels.get(i)) {
                    correctCount++;
                }
            } else {
                if (1 == testLabels.get(i)) {
                    correctCount++;
                }
            }

        }

        return correctCount * 100 / (TestSet.length);

    }

    protected double trainClassifierKNN(int k) {

        List<Double[]> distances;

        int correctCount = 0;
        for (int i = 0; i < TestSet.length; ++i) {

            distances = new LinkedList<Double[]>();

            for (int j = 0; j < TrainingSet.length; ++j) {
                double tmpDistance = euklidesDistance(TestSet[i], TrainingSet[j]);
                Double[] tmp = {tmpDistance, (double) trainLabels.get(j)};
                distances.add(tmp);
            }

            Collections.sort(distances, new Comparator<Double[]>() {
                @Override
                public int compare(Double[] lhs, Double[] rhs) {
                    return lhs[0] > rhs[0] ? 1 : (lhs[0] < rhs[0]) ? -1 : 0;
                }

            });

            int class1 = 0, class2 = 0;
            int pointLabel;

            for (int l = 0; l < k; ++l) {

                if (distances.get(l)[1] == 0) {
                    class1++;
                } else {
                    class2++;
                }

            }

            if (class1 > class2) {
                pointLabel = 0;
            } else {
                pointLabel = 1;
            }

            if (pointLabel == testLabels.get(i)) {
                correctCount++;
            }
        }

        return correctCount * 100 / (TestSet.length);
    }

    protected double trainClassifierKNM(int k) {
        List<Double[]> distances = new ArrayList<Double[]>();
        List<PointModel[]> modes = new ArrayList<PointModel[]>();

        List<PointModel> data = new LinkedList<PointModel>();

        for (int i = 0; i < TrainingSet.length; ++i) {
            double[] features = new double[TrainingSet[i].length];
            for (int j = 0; j < TrainingSet[i].length; ++j) {
                features[j] = TrainingSet[i][j];
            }
            PointModel point = new PointModel(features, trainLabels.get(i));
            data.add(point);
        }

        int pointsCount = TrainingSet.length / k;
        int left = TrainingSet.length % k;

        Random rand = new Random();

        for (int i = 0; i < k; ++i) {
            PointModel[] pointModels;
            if ((i == 0) && (left != 0)) {
                pointModels = new PointModel[pointsCount + left];
            } else {
                pointModels = new PointModel[pointsCount];
            }

            for (int j = 0; j < pointsCount; ++j) {
                int randomNum = rand.nextInt(data.size());
                pointModels[j] = data.get(randomNum);
                data.remove(randomNum);
            }

            while (!data.isEmpty() && left != 0) {
                pointModels[pointsCount + left - 1] = data.get(0);
                data.remove(0);
                --left;
            }

            modes.add(pointModels);
        }

        int classA = 0;
        int classB = 0;

        List<PointModel> means = new ArrayList<PointModel>();

        for (int m = 0; m < modes.size(); ++m) {

            double[] meanA = new double[modes.get(m)[0].getFeatures().length];
            double[] meanB = new double[modes.get(m)[0].getFeatures().length];

            for (int i = 0; i < modes.get(m).length; ++i) {

                for (int j = 0; j < modes.get(m)[i].getFeatures().length; ++j) {
                    if (modes.get(m)[i].getClassLabel() == 0) {
                        meanA[j] += modes.get(m)[i].getFeatures()[j];
                    } else {
                        meanB[j] += modes.get(m)[i].getFeatures()[j];
                    }
                }

                if (modes.get(m)[i].getClassLabel() == 0) {
                    ++classA;
                } else {
                    ++classB;
                }
            }

            for (int i = 0; i < meanA.length; ++i) {
                meanA[i] /= classA;
                meanB[i] /= classB;
            }

            means.add(new PointModel(meanA, 0));
            means.add(new PointModel(meanB, 1));
        }

        int correctCount = 0;

        for (int i = 0; i < TestSet.length; ++i) {
            for (int j = 0; j < means.size(); ++j) {
                Double distance = euklidesDistance(TestSet[i], means.get(j).getFeatures());
                Double[] arr = new Double[]{distance, (double) means.get(j).getClassLabel()};
                distances.add(arr);
            }

            distances.sort(new Comparator<Double[]>() {
                @Override
                public int compare(Double[] lhs, Double[] rhs) {
                    return lhs[0] > rhs[0] ? 1 : (lhs[0] < rhs[0]) ? -1 : 0;
                }
            });

            int class1 = 0;
            int class2 = 0;
            int pointLabel = -1;

            for (int l = 0; l < k; ++l) {

                if (distances.get(l)[1] == 0) {
                    class1++;
                } else {
                    class2++;
                }

            }

            if (class1 > class2) {
                pointLabel = 0;
            } else {
                pointLabel = 1;
            }

            if (pointLabel == testLabels.get(i)) {
                correctCount++;
            }
            
            distances.clear();
        }

        return correctCount * 100 / TestSet.length;
    }

    private double euklidesDistance(double[] trainPoint, double[] testPoint) {

        double distance = 0;

        for (int i = 0; i < trainPoint.length; ++i) {
            distance += (trainPoint[i] - testPoint[i]) * (trainPoint[i] - testPoint[i]);
        }

        return Math.sqrt(distance);
    }

}
