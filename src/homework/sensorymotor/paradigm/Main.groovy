package homework.sensorymotor.paradigm

import existence.Existence

class Main {
	static main(args) {
		Existence existence = new InteractionalMotivationExistence(7, 5)
		for (int i=0; i<20; i++) {
			String stepTrace = existence.step()
			println stepTrace
		}
	}
}
