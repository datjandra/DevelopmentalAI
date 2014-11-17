package homework.self.programming

import coupling.Experiment;
import coupling.Result;
import coupling.interaction.Interaction030;
import coupling.interaction.Interaction040;
import existence.Existence
import existence.Existence030;
import existence.Existence040

class Main {

	static class Existence040WithResult010 extends Existence040 {
		@Override
		Interaction040 enactPrimitiveIntearction(Interaction030 intendedPrimitiveInteraction) {
			Experiment experience = intendedPrimitiveInteraction.getExperience();
			Result result = returnResult010(experience);
			return (Interaction040)this.addOrGetPrimitiveInteraction(experience, result)
		}	
	}
	
	static class Existence040WithResult030 extends Existence040 {
		@Override
		Interaction040 enactPrimitiveIntearction(Interaction030 intendedPrimitiveInteraction) {
			Experiment experience = intendedPrimitiveInteraction.getExperience();
			Result result = returnResult030(experience);
			return (Interaction040)this.addOrGetPrimitiveInteraction(experience, result)
		}
	}
	
	static main(args) {
		println " *** Running Existence040 *** "
		Existence existence = new Existence040()
		(1..20).each {
			println "${it} - ${existence.step()}"			
		}
		
		println " *** Running Existence040 with Result010 *** "		
		existence = new Existence040WithResult010()
		(1..20).each {
			println "${it} - ${existence.step()}"
		}
		
		println " *** Running Existence040 with Result030 *** "
		existence = new Existence040WithResult030()
		(1..20).each {
			println "${it} - ${existence.step()}"
		}
	}
}
