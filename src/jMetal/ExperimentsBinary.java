package jMetal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.uma.jmetal.algorithm.Algorithm;
import org.uma.jmetal.algorithm.multiobjective.mocell.MOCellBuilder;
import org.uma.jmetal.algorithm.multiobjective.mochc.MOCHCBuilder;
import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAIIBuilder;
import org.uma.jmetal.algorithm.multiobjective.paes.PAESBuilder;
import org.uma.jmetal.algorithm.multiobjective.randomsearch.RandomSearchBuilder;
import org.uma.jmetal.algorithm.multiobjective.smsemoa.SMSEMOABuilder;
import org.uma.jmetal.algorithm.multiobjective.spea2.SPEA2Builder;
import org.uma.jmetal.operator.impl.crossover.HUXCrossover;
import org.uma.jmetal.operator.impl.crossover.SinglePointCrossover;
import org.uma.jmetal.operator.impl.mutation.BitFlipMutation;
import org.uma.jmetal.operator.impl.selection.RandomSelection;
import org.uma.jmetal.operator.impl.selection.RankingAndCrowdingSelection;
import org.uma.jmetal.problem.BinaryProblem;
import org.uma.jmetal.qualityindicator.impl.hypervolume.PISAHypervolume;
import org.uma.jmetal.solution.BinarySolution;
import org.uma.jmetal.util.evaluator.impl.SequentialSolutionListEvaluator;
import org.uma.jmetal.util.experiment.Experiment;
import org.uma.jmetal.util.experiment.ExperimentBuilder;
import org.uma.jmetal.util.experiment.component.ComputeQualityIndicators;
import org.uma.jmetal.util.experiment.component.ExecuteAlgorithms;
import org.uma.jmetal.util.experiment.component.GenerateBoxplotsWithR;
import org.uma.jmetal.util.experiment.component.GenerateLatexTablesWithStatistics;
import org.uma.jmetal.util.experiment.component.GenerateReferenceParetoFront;
import org.uma.jmetal.util.experiment.util.ExperimentAlgorithm;
import org.uma.jmetal.util.experiment.util.ExperimentProblem;

import generic.Problem;
import ui.AdvancedConfigurationTab;
import ui.Gui;
import ui.RunTab;

public class ExperimentsBinary {
	private static final int INDEPENDENT_RUNS = Gui.getAdm().getIndRuns();
	private static final int maxEvaluations = Gui.getAdm().getMaxEval();
	public static int numberRuns;
	

	private static Problem prob;

	public ExperimentsBinary(Problem prob) {
		this.prob = prob;
	}

	public static void run() throws IOException {
		String experimentBaseDirectory = "experimentBaseDirectory";

		List<ExperimentProblem<BinarySolution>> problemList = new ArrayList<>();
		problemList.add(new ExperimentProblem<>(new ProblemBinary(prob)));

		List<ExperimentAlgorithm<BinarySolution, List<BinarySolution>>> algorithmList = configureAlgorithmList(
				problemList);

		numberRuns = INDEPENDENT_RUNS *maxEvaluations* prob.getAlgorithms().size();
		
		Experiment<BinarySolution, List<BinarySolution>> experiment = new ExperimentBuilder<BinarySolution, List<BinarySolution>>(
				"ExperimentsBinary").setAlgorithmList(algorithmList).setProblemList(problemList)
						.setExperimentBaseDirectory(experimentBaseDirectory).setOutputParetoFrontFileName("FUN")
						.setOutputParetoSetFileName("VAR")
						.setReferenceFrontDirectory(experimentBaseDirectory + "/referenceFronts")
						.setIndicatorList(Arrays.asList(new PISAHypervolume<BinarySolution>()))
						.setIndependentRuns(INDEPENDENT_RUNS).setNumberOfCores(8).build();

		new ExecuteAlgorithms<>(experiment).run();
		new GenerateReferenceParetoFront(experiment).run();
		new ComputeQualityIndicators<>(experiment).run();
		new GenerateLatexTablesWithStatistics(experiment).run();
		new GenerateBoxplotsWithR<>(experiment).setRows(1).setColumns(1).run();
	}

	static List<ExperimentAlgorithm<BinarySolution, List<BinarySolution>>> configureAlgorithmList(
			List<ExperimentProblem<BinarySolution>> problemList) {
		List<ExperimentAlgorithm<BinarySolution, List<BinarySolution>>> algorithms = new ArrayList<>();

		for (int i = 0; i < problemList.size(); i++) {
			for (int j = 0; j < prob.getAlgorithms().size(); j++) {
				switch (prob.getAlgorithms().get(j)) {

				case "NSGAII":

					Algorithm<List<BinarySolution>> algorithm = new NSGAIIBuilder<>(problemList.get(i).getProblem(),
							new SinglePointCrossover(1.0),
							new BitFlipMutation(
									1.0 / ((ProblemBinary) problemList.get(i).getProblem()).getNumberOfBits(0)))
											.setMaxEvaluations(maxEvaluations).setPopulationSize(10).build();
					algorithms.add(new ExperimentAlgorithm<>(algorithm, "NSGAII", problemList.get(i).getTag()));
					break;

				default:
					System.out.println("Error!");
					break;

				case "SMSEMOA":
					Algorithm<List<BinarySolution>> algorithmsmsemoa = new SMSEMOABuilder<>(
							problemList.get(i).getProblem(), new SinglePointCrossover(1.0),
							new BitFlipMutation(
									1.0 / ((BinaryProblem) problemList.get(i).getProblem()).getNumberOfBits(0)))
											.setMaxEvaluations(maxEvaluations).setPopulationSize(10).build();
					algorithms.add(new ExperimentAlgorithm<>(algorithmsmsemoa, "SMSEMOA", problemList.get(i).getTag()));
					break;

				case "MOCell":
					Algorithm<List<BinarySolution>> algorithmmocell = new MOCellBuilder<>(
							problemList.get(i).getProblem(), new SinglePointCrossover(1.0),
							new BitFlipMutation(
									1.0 / ((BinaryProblem) problemList.get(i).getProblem()).getNumberOfBits(0)))
											.setMaxEvaluations(maxEvaluations).setPopulationSize(10).build();
					algorithms.add(new ExperimentAlgorithm<>(algorithmmocell, "MOCell", problemList.get(i).getTag()));
					break;

				case "MOCH":
					Algorithm<List<BinarySolution>> algorithm4 = new MOCHCBuilder(
							(BinaryProblem) problemList.get(i).getProblem()).setMaxEvaluations(maxEvaluations).setPopulationSize(10)
									.setCrossover(new HUXCrossover(1.0))
									.setNewGenerationSelection(new RankingAndCrowdingSelection<BinarySolution>(100))
									.setCataclysmicMutation(new BitFlipMutation(0.35))
									.setParentSelection(new RandomSelection<BinarySolution>())
									.setEvaluator(new SequentialSolutionListEvaluator<BinarySolution>()).build();
					algorithms.add(new ExperimentAlgorithm<>(algorithm4, "MOCH", problemList.get(i).getTag()));
					break;

				case "PAES":
					Algorithm<List<BinarySolution>> algorithmpaes = new PAESBuilder<>(problemList.get(i).getProblem())
							.setMaxEvaluations(maxEvaluations).setArchiveSize(100).setBiSections(2)
							.setMutationOperator(new BitFlipMutation(
									1.0 / ((BinaryProblem) problemList.get(i).getProblem()).getNumberOfBits(0)))
							.build();
					algorithms.add(new ExperimentAlgorithm<>(algorithmpaes, "PAES", problemList.get(i).getTag()));
					break;

				case "RandomSearch":
					Algorithm<List<BinarySolution>> algorithm6 = new RandomSearchBuilder<>(
							problemList.get(i).getProblem()).setMaxEvaluations(maxEvaluations).build();
					algorithms.add(new ExperimentAlgorithm<>(algorithm6, "RandomSearch", problemList.get(i).getTag()));
					break;

				case "SPEA2":
					Algorithm<List<BinarySolution>> algorithmspea2 = new SPEA2Builder<>(problemList.get(i).getProblem(),
							new SinglePointCrossover(1.0),
							new BitFlipMutation(
									1.0 / ((BinaryProblem) problemList.get(i).getProblem()).getNumberOfBits(0)))
											.setMaxIterations(maxEvaluations).setPopulationSize(10).build();
					algorithms.add(new ExperimentAlgorithm<>(algorithmspea2, "SPEA2", problemList.get(i).getTag()));
				}
			}
		}
		return algorithms;
	}

}
