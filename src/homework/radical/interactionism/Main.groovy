package homework.radical.interactionism

import existence.Existence
import existence.Existence050

class Main {

	static main(args) {
		Existence existence = new Existence050()
		(1..20).each {
			println "${it} - ${existence.step()}"
		}
	}

}
