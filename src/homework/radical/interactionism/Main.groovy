package homework.radical.interactionism

import environment.Environment
import environment.EnvironmentMaze
import existence.Existence
import existence.Existence050

class Main {

	static class Existence050WithMaze extends Existence050 {
		
		private Environment localEnvironment
		
		@Override
		protected void initExistence() {
			localEnvironment = new EnvironmentMaze(this)
		}
		
		@Override
		protected Environment getEnvironment() {
			return localEnvironment
		}
	}
	
	static main(args) {
		Existence existence = new Existence050WithMaze()
		(1..20).each {
			println "${it} - ${existence.step()}"
		}
	}

}
