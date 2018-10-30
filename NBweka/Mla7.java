package mla7;
import weka.core.Instances;
//import weka.classifiers.*;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.evaluation.*;//Evaluation;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.Exception;
public class Mla7
{
		public Mla7()
		{
			try
			{
				BufferedReader trainReader = new BufferedReader(new FileReader("C:\\Users\\HyperX\\eclipse-workspace\\mla7\\src\\mla7\\IDSTr.arff"));
				BufferedReader classifyReader = new BufferedReader(new FileReader("C:\\Users\\HyperX\\eclipse-workspace\\mla7\\src\\mla7\\IDSTest.arff"));
				
				Instances trainInsts = new Instances(trainReader);
				Instances classifyInsts = new Instances(classifyReader);
				
				trainInsts.setClassIndex(trainInsts.numAttributes() - 1);
				classifyInsts.setClassIndex(classifyInsts.numAttributes() -1);
				
				NaiveBayes model=new NaiveBayes();
				model.buildClassifier(trainInsts);
				//System.out.println(model);
				Evaluation eTest = new Evaluation(classifyInsts);
				eTest.evaluateModel(model, classifyInsts);
				String[] cmarray = {"normal","anomaly"};
				ConfusionMatrix cm = new ConfusionMatrix(cmarray);
				System.out.println(cm.correct());
				for(int i=0;i<classifyInsts.numInstances();i++)
				{
					classifyInsts.instance(i).setClassMissing();
					double cls = model.classifyInstance(classifyInsts.instance(i));
					classifyInsts.instance(i).setClassValue(cls);
				}
				System.out.println("Error Rate: "+eTest.errorRate()*100);
				System.out.println("Pct Correct: "+eTest.pctCorrect());
				for (int i=0; i<trainInsts.numClasses(); i++)
				{
					
					System.out.println("Class "+ i);
					System.out.println("\tPrecision " +eTest.precision(i));
					System.out.println("\tRecall "+eTest.recall(i));
					System.out.println("\tArea under ROC "+eTest.areaUnderROC(i));
					System.out.println();
				}
				//System.out.println(classifyInsts);
			}//Try
			catch (Exception o)
			{
				System.err.println(o.getMessage());
			}
		}
public static void main(String[] args) {
			Mla7 nb = new Mla7();
	}

}
