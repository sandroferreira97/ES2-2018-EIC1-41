package jMetal;

import org.uma.jmetal.algorithm.Algorithm;
import org.uma.jmetal.algorithm.multiobjective.mocell.MOCellBuilder;
import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAIIBuilder;
import org.uma.jmetal.algorithm.multiobjective.paes.PAESBuilder;
import org.uma.jmetal.algorithm.multiobjective.randomsearch.RandomSearchBuilder;
import org.uma.jmetal.algorithm.multiobjective.smsemoa.SMSEMOABuilder;
import org.uma.jmetal.operator.impl.crossover.IntegerSBXCrossover;
import org.uma.jmetal.operator.impl.mutation.IntegerPolynomialMutation;
import org.uma.jmetal.qualityindicator.impl.hypervolume.PISAHypervolume;
import org.uma.jmetal.solution.IntegerSolution;
import org.uma.jmetal.util.JMetalException;
import org.uma.jmetal.util.experiment.Experiment;
import org.uma.jmetal.util.experiment.ExperimentBuilder;
import org.uma.jmetal.util.experiment.component.*;
import org.uma.jmetal.util.experiment.util.ExperimentAlgorithm;
import org.uma.jmetal.util.experiment.util.ExperimentProblem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExperimentsIntegeExternalViaJAR {
  private static final int INDEPENDENT_RUNS = 2;
  private static final int maxEvaluations = 250;
  
  public static void main(String[] args) throws IOException {
    String experimentBaseDirectory = "experimentBaseDirectory";

    List<ExperimentProblem<IntegerSolution>> problemList = new ArrayList<>();
    problemList.add(new ExperimentProblem<>(new ProblemInteger()));

    List<ExperimentAlgorithm<IntegerSolution, List<IntegerSolution>>> algorithmList =
            configureAlgorithmList(problemList);

    Experiment<IntegerSolution, List<IntegerSolution>> experiment =
        new ExperimentBuilder<IntegerSolution, List<IntegerSolution>>("ExperimentsIntegerExternalViaJAR")
            .setAlgorithmList(algorithmList)
            .setProblemList(problemList)
            .setExperimentBaseDirectory(experimentBaseDirectory)
            .setOutputParetoFrontFileName("FUN")
            .setOutputParetoSetFileName("VAR")
            .setReferenceFrontDirectory(experimentBaseDirectory+"/referenceFronts")
            .setIndicatorList(Arrays.asList(new PISAHypervolume<IntegerSolution>()))
            .setIndependentRuns(INDEPENDENT_RUNS)
            .setNumberOfCores(8)
            .build();

    new ExecuteAlgorithms<>(experiment).run();
    new GenerateReferenceParetoFront(experiment).run();
    new ComputeQualityIndicators<>(experiment).run() ;
    new GenerateLatexTablesWithStatistics(experiment).run() ;
    new GenerateBoxplotsWithR<>(experiment).setRows(1).setColumns(1).run() ;
  }

  static List<ExperimentAlgorithm<IntegerSolution, List<IntegerSolution>>> configureAlgorithmList(
          List<ExperimentProblem<IntegerSolution>> problemList) {
    List<ExperimentAlgorithm<IntegerSolution, List<IntegerSolution>>> algorithms = new ArrayList<>();

    for (int i = 0; i < problemList.size(); i++) {
      Algorithm<List<IntegerSolution>> algorithm1 = new NSGAIIBuilder<>(
              problemList.get(i).getProblem(),
              new IntegerSBXCrossover(0.9, 20.0),
              new IntegerPolynomialMutation(1/problemList.get(i).getProblem().getNumberOfVariables(), 20.0))
              .setMaxEvaluations(maxEvaluations)
              .setPopulationSize(100)
              .build();
      algorithms.add(new ExperimentAlgorithm<>(algorithm1, "NSGAII", problemList.get(i).getTag()));

      /* As simulações com ExternalViaJAR no nome tem as funções de avaliação 
      implementadas em .JAR externos que são invocados no método evaluate() 
      As simulações que executam .jar externos são muito mais demoradas, 
      maxEvaluations e INDEPENDENT_RUNS tem por isso valores mais baixos */      
      /* Deverão ser comentadas ou retiradas de comentário as linhas 
      correspondentes às simulações que se pretendem executar */      
      
//    Algorithm<List<IntegerSolution>> algorithm2 = new SMSEMOABuilder<>(problemList.get(i).getProblem(), new IntegerSBXCrossover(0.9, 20.0),new IntegerPolynomialMutation(1/problemList.get(i).getProblem().getNumberOfVariables(), 20.0)).setMaxEvaluations(maxEvaluations).build();      
//    algorithms.add(new ExperimentAlgorithm<>(algorithm2, "SMSEMOA", problemList.get(i).getTag()));
//	  Algorithm<List<IntegerSolution>> algorithm3 = new MOCellBuilder<>(problemList.get(i).getProblem(),new IntegerSBXCrossover(0.9, 20.0), new IntegerPolynomialMutation(1/problemList.get(i).getProblem().getNumberOfVariables(), 20.0)).setMaxEvaluations(maxEvaluations).build();
//	  algorithms.add(new ExperimentAlgorithm<>(algorithm3, "MOCell", problemList.get(i).getTag()));    
//	  Algorithm<List<IntegerSolution>> algorithm4 = new PAESBuilder<>(problemList.get(i).getProblem()).setMaxEvaluations(maxEvaluations).setArchiveSize(100).setBiSections(2).setMutationOperator(new IntegerPolynomialMutation(1/problemList.get(i).getProblem().getNumberOfVariables(), 20.0)).build();
//	  algorithms.add(new ExperimentAlgorithm<>(algorithm4, "PAES", problemList.get(i).getTag())); 	
//	  Algorithm<List<IntegerSolution>> algorithm5 = new RandomSearchBuilder<>(problemList.get(i).getProblem()).setMaxEvaluations(maxEvaluations).build();
//	  algorithms.add(new ExperimentAlgorithm<>(algorithm5, "RandomSearch", problemList.get(i).getTag()));
    }
    return algorithms;
  }

}