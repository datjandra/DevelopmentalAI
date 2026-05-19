# Developmental AI - IDEAL MOOC Homework Projects

Homework projects for the [IDEAL MOOC](http://liris.cnrs.fr/ideal/mooc/), implementing AI developmental cognitive systems and self-programming agents in Groovy.

## 🎯 Overview

This repository contains implementations of developmental AI concepts based on the IDEAL (Intelligent Developmental Embodied Agents Learning) MOOC. The projects explore agent-based learning through interactions with environments, focusing on constructivist, radical constructivist, and enactive paradigms in AI development.

## 📦 Key Modules

### 1. **Sensorimotor Paradigm** (`src/homework/sensorymotor/paradigm/`)
Implements basic sensorimotor learning where agents interact with their environment through simple stimulus-response patterns.

- **`InteractionalMotivationExistence`**: An agent that learns from experiences and results with mood-based motivation. Features:
  - Mood states: PLEASED, PAINED, BORED
  - Self-satisfaction counter with boredom threshold
  - Random experience selection when dissatisfied or bored
  - Configurable number of experiments and results

**Usage**:
```groovy
def agent = new InteractionalMotivationExistence(5, 3)  // 5 experiments, 3 results
(1..20).each {
    println agent.step()  // Returns: "e1r2 PLEASED"
}
```

### 2. **Constructivist Epistemology** (`src/homework/constructivist/epistomology/`)
Explores knowledge construction through anticipation and composite interactions using different existence levels.

- **`Existence030WithResult010`**: Anticipation-based learning with simple results
- **`Existence031WithResult010`**: Experience-selection based learning
- **`Existence031WithResult030`**: Composite interaction learning

**Usage**:
```groovy
Existence existence = new Existence031WithResult030()
(1..20).each {
    println existence.step()  // Prints enacted interactions and mood
}
```

### 3. **Radical Constructivism - Interactionism** (`src/homework/radical/interactionism/`)
Implements learning in environmental contexts, specifically a maze environment where agents navigate and learn.

- **`Existence050WithMaze`**: Agent navigating a maze environment with environmental feedback

**Usage**:
```groovy
Existence existence = new Existence050WithMaze()
(1..20).each {
    println "${it} - ${existence.step()}"
}
```

### 4. **Self-Programming Agent** (`src/homework/self/programming/`)
Demonstrates meta-learning where agents learn and optimize their interaction mechanisms.

- **`Existence040WithResult010`**: Basic self-programming with primitive interactions
- **`Existence040WithResult030`**: Self-programming with composite interactions

**Usage**:
```groovy
println " *** Running Existence040 *** "
Existence existence = new Existence040()
(1..20).each {
    println "${it} - ${existence.step()}"
}
```

## 🔧 Setup & Prerequisites

### Requirements
- **Java 8+** - Required to run Groovy
- **Groovy 2.0+** - Build and runtime language

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/datjandra/DevelopmentalAI.git
   cd DevelopmentalAI
   ```

2. Compile Groovy files (if using Groovy compiler):
   ```bash
   groovyc -d bin src/homework/**/*.groovy
   ```

3. Run a homework assignment:
   ```bash
   groovy -cp bin src/homework/sensorymotor/paradigm/Main.groovy
   ```

## 📋 Environment Variables & Configuration

Currently, the projects use hardcoded configurations. Common configurable parameters:

- **Number of iterations**: Typically `(1..20)` in main methods
- **Number of experiments/results**: Passed as parameters to `InteractionalMotivationExistence`
- **Mood thresholds**: `BOREDOME_LEVEL` in agent classes
- **Environment type**: `EnvironmentMaze` or custom environments in `Existence050WithMaze`

Example with custom parameters:
```groovy
InteractionalMotivationExistence agent = new InteractionalMotivationExistence(10, 5)
for (int i = 0; i < 50; i++) {
    String result = agent.step()
    if (result.contains("BORED")) {
        println "Agent got bored after $i steps"
        break
    }
}
```

## 💡 Usage Examples

### Example 1: Basic Sensorimotor Agent
```groovy
import homework.sensorymotor.paradigm.InteractionalMotivationExistence

def agent = new InteractionalMotivationExistence(3, 2)
(1..10).each { step ->
    String response = agent.step()
    println "Step $step: $response"
}
// Output:
// Step 1: e1r1 PLEASED
// Step 2: e1r2 PAINED
// Step 3: e2r1 PLEASED
// ...
```

### Example 2: Maze Navigation
```groovy
import homework.radical.interactionism.Main

def existence = new Main.Existence050WithMaze()
(1..10).each {
    println "Step $it: ${existence.step()}"
}
```

### Example 3: Self-Modifying Agent
```groovy
import homework.self.programming.Main

def agent = new Main.Existence040WithResult030()
(1..5).each { i ->
    def result = agent.step()
    println "Iteration $i: $result"
}
```

## 📚 Concepts

- **Existence**: Base agent class managing internal state and learning
- **Interaction**: Coupling between experience and result with valence (positive/negative)
- **Valence**: Positive (attractive/rewarding) or negative (aversive/punishing) outcome
- **Mood**: Agent emotional state affecting decision-making (PLEASED, PAINED, BORED)
- **Anticipation**: Agent prediction of outcomes based on learned interactions

## 📖 References

- [IDEAL MOOC Course](http://liris.cnrs.fr/ideal/mooc/)
- Concepts based on developmental psychology and enactive cognition
- Self-programming patterns inspired by meta-learning research

## 📄 License

Homework projects created for the IDEAL MOOC course.

## ✍️ Author

Created by **datjandra** for IDEAL MOOC assignments.
