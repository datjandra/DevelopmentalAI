package homework.interactional.motivation

import coupling.Experiment
import coupling.Result
import coupling.interaction.Interaction020;
import existence.Existence010
import existence.Existence010.Mood

/**
 * Copy of Existence020 implemented in Groovy with additional modifications:
 * 
 * 1. Agent gets bored if satisfied too many times
 * 2. Number of experiments and results are variable
 * 3. Past experiences are selected randomly 
 *  
 * @author datjandra
 *
 */
class InteractionalMotivationExistence extends Existence010 {

	InteractionalMotivationExistence(int numberExperiments, int numberResults) {
		initExistence(numberExperiments, numberResults)
	}
		
	@Override
	String step() {
		Experiment experience = previousExperience
		if (mood == Mood.BORED) {			
			experience = randomlyGetAnotherExperience(experience)
			selfSatisfactionCounter = 0
		} else if (mood == Mood.PAINED) {
			experience = randomlyGetAnotherExperience(experience)
		}
		
		Result result = returnResult010(experience)
		Interaction020 enactedInteraction = (Interaction020) this.addOrGetPrimitiveInteraction(experience, result)
			
		if (enactedInteraction.valence >= 0) {			
			mood = Mood.PLEASED
			super.incSelfSatisfactionCounter()
		} else {			
			mood = Mood.PAINED
			selfSatisfactionCounter = 0
		}
				
		if (selfSatisfactionCounter >= BOREDOME_LEVEL) {
			mood = Mood.BORED
		}
		
		previousExperience = experience
		return "${experience.label}${result.label} ${mood}"
	}			
	
	/**
	 * Create an interaction as a tuple <experience, result>.
	 * @param experience: The experience.
	 * @param result: The result.
	 * @param valence: the interaction's valence
	 * @return The created interaction
	 */
	protected Interaction020 addOrGetPrimitiveInteraction(Experiment experience, Result result, int valence) {
		String label = experience.label + result.label
		if (!INTERACTIONS.containsKey(label)) {
			Interaction020 interaction = createInteraction(label)
			interaction.setExperience(experience)
			interaction.setResult(result)
			interaction.setValence(valence)
			INTERACTIONS.put(label, interaction)
		}
		Interaction020 interaction = (Interaction020) INTERACTIONS.get(label)
		return interaction
	}
		
	@Override
	protected Interaction020 createInteraction(String label){
		return new Interaction020(label)
	}

	@Override
	protected Interaction020 getInteraction(String label){
		return (Interaction020) INTERACTIONS.get(label)
	}			
	
	private void initExistence(int numberExperiments, int numberResults) {
		createExperiments(numberExperiments)
		createResults(numberResults)
		Stack<Integer> valencies = createValencies(numberExperiments * numberResults)
		addInteractions(valencies)
		previousExperience = (EXPERIENCES.values() as List).first()
	}
	
	private void createExperiments(int numberExperiments) {		
		(1..numberExperiments).each {
			Experiment experiment = addOrGetExperience("e${it}")
		}
	}	
	
	private void createResults(numberResults) {
		(1..numberResults).each {
			Result result = createOrGetResult("r${it}")
		}
	}	
	
	private Stack<Integer> createValencies(int numberValencies) {
		Stack<Integer> valencies = new Stack<Integer>()
		(1..numberValencies).each {
			valencies.push((it % 2 ? 1 : -1 ))					
		}
		return valencies
	}
	
	private void addInteractions(Stack<Integer> valencies) {
		Collection<Experiment> experiences = EXPERIENCES.values()
		Collection<Result> results = RESULTS.values()		
		for (Experiment experience : experiences) {
			for (Result result : results) {
				if (!valencies.isEmpty()) {
					Integer valency = valencies.pop()
					addOrGetPrimitiveInteraction(experience, result, valency)					
				}
			}
		}
	}
	
	private Experiment randomlyGetAnotherExperience(Experiment experience) {
		Experiment otherExperience = null
		List<Experiment> experimentList = new ArrayList<Experiment>(EXPERIENCES.values())
		Collections.shuffle(experimentList)
		for (Experiment e : experimentList) {
			if (!e.equals(experience)) {
				otherExperience =  e
				break
			}
		}
		return otherExperience
	}
}
