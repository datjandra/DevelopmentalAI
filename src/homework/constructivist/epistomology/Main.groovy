package homework.constructivist.epistomology

import agent.Anticipation
import coupling.Experiment
import coupling.Result
import coupling.interaction.Interaction030
import coupling.interaction.Interaction031
import existence.Existence
import existence.Existence030
import existence.Existence031
import existence.Existence010.Mood

class Main {

	static class Existence030WithResult010 extends Existence030 {
		@Override
		String step() {
			List<Anticipation> anticipations = anticipate();
			Experiment experience =  selectInteraction(anticipations).getExperience();

			Result result = returnResult010(experience);
			Interaction030 enactedInteraction = getInteraction(experience.getLabel() + result.getLabel());
			println("Enacted "+ enactedInteraction.toString());

			if (enactedInteraction.getValence() >= 0)
				this.setMood(Mood.PLEASED);
			else
				this.setMood(Mood.PAINED);

			this.learnCompositeInteraction(enactedInteraction);
			this.setEnactedInteraction(enactedInteraction);
			return "" + this.getMood();
		}
	}

	static class Existence031WithResult010 extends Existence031 {
		@Override
		String step() {
			List<Anticipation> anticipations = anticipate();
			Experiment experience = selectExperience(anticipations);

			Result result = returnResult010(experience);
			Interaction031 enactedInteraction = getInteraction(experience.getLabel() + result.getLabel());
			println("Enacted "+ enactedInteraction.toString());

			if (enactedInteraction.getValence() >= 0)
				this.setMood(Mood.PLEASED);
			else
				this.setMood(Mood.PAINED);

			this.learnCompositeInteraction(enactedInteraction);
			this.setEnactedInteraction(enactedInteraction);
			return "" + this.getMood();
		}
	}

	static class Existence031WithResult030 extends Existence031 {
		@Override
		String step() {
			List<Anticipation> anticipations = anticipate();
			Experiment experience = selectExperience(anticipations);

			Result result = returnResult030(experience);
			Interaction031 enactedInteraction = getInteraction(experience.getLabel() + result.getLabel());
			println("Enacted "+ enactedInteraction.toString());

			if (enactedInteraction.getValence() >= 0)
				this.setMood(Mood.PLEASED);
			else
				this.setMood(Mood.PAINED);

			this.learnCompositeInteraction(enactedInteraction);
			this.setEnactedInteraction(enactedInteraction);
			return "" + this.getMood();
		}
	}

	static void runExistence030() {
		Existence existence = new Existence030()
		for (int i=0; i<20; i++) {
			String stepTrace = existence.step()
			println stepTrace
		}
	}

	static void runExistence030WithResult010() {
		Existence030WithResult010 existence = new Existence030WithResult010()
		for (int i=0; i<20; i++) {
			String stepTrace = existence.step()
			println stepTrace
		}
	}

	static void runExistence031() {
		Existence existence = new Existence031()
		for (int i=0; i<20; i++) {
			String stepTrace = existence.step()
			println stepTrace
		}
	}

	static void runExistence031WithResult010() {
		Existence existence = new Existence031()
		for (int i=0; i<20; i++) {
			String stepTrace = existence.step()
			println stepTrace
		}
	}

	static void runExistence031WithResult030() {
		Existence existence = new Existence031()
		for (int i=0; i<20; i++) {
			String stepTrace = existence.step()
			println stepTrace
		}
	}

	static main(args) {
		runExistence031WithResult030()
	}
}
