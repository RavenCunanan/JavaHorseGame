# Horse Simulator 🐎  

Horse Simulator is a text-based Java game where you train your horse across 15 turns to prepare for the final race against **Speed Biscuit**. Manage energy, balance training and rest, and see if your horse has what it takes to become a champion.  

## Features  
- **Training System**: Improve speed, power, or stamina with randomized gains. Success rate depends on your horse’s current energy.  
- **Big Successes**: Rare chance to boost an extra stat when training.  
- **Energy Management**: Training consumes 1–3 energy, resting restores 1–5 energy (max 10).  
- **Failure Penalty**: Training can fail, reducing stats — but no stat ever falls below 0.  
- **Final Race**: After 15 turns, face off against Speed Biscuit in a narrated race to determine the champion.  

## How It Works  
- **Success Rate Formula**: `(energy × 10 + 1) > random(1–100)`  
- **Big Success Chance**: 1 in 10  
- **Turns**: 15 total before the final race  

## Getting Started  
1. Clone this repository:  
   ```bash
   git clone https://github.com/yourusername/Horse-Simulator.git
2. Compile the game:
   ```bash
    javac horseSim.java
3. Run the game:
   ```bash
     java horseSim

## Example Gameplay

- Train speed at 7/10 energy → ~70% chance of success

- Rest to regain energy and prepare for stronger training sessions

- After 15 turns, race against Speed Biscuit with narration
