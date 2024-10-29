# MegaPoly

MegaPoly is a Java-based application that replicates the classic Monopoly game using the Swing framework for the user interface. The game allows you to save and load your progress, and features various types of casillas (spaces) on the game board.

## Features

- Classic Monopoly gameplay
- Save and load game functionality
- Different types of casillas (spaces) with unique properties
- User-friendly interface built with Java Swing

## Requirements

- Java Development Kit (JDK) 8 or higher
- A compatible operating system (Windows, macOS, Linux)

## Installation

1. **Clone the repository**:
   ```sh
   git clone https://github.com/yourusername/megapoly.git
   cd megapoly
   ```

2. **Compile the application**:
   ```sh
   javac -d bin src/*.java
   ```

3. **Run the application**:
   ```sh
   java -cp bin Main
   ```

## Usage

1. **Starting the Game**:
   - Run the application using the command above.
   - The main menu will appear, allowing you to start a new game or load an existing one.

2. **Playing the Game**:
   - Follow the on-screen instructions to roll the dice, move your token, and interact with the game board.
   - The game follows the standard Monopoly rules.

## Saving and Loading Games

- **Save Game**: During your turn, you can save the game by selecting the "Save Game" option from the menu.
- **Load Game**: From the main menu, select "Load Game" to continue from a previously saved game.

## Casillas

The game board features various types of casillas:

- **Property**: Buyable spaces where players can build houses and hotels.
- **Chance**: Draw a card that can have positive or negative effects.
- **Community Chest**: Draw a card that can have positive or negative effects.
- **Tax**: Pay a specified amount of money.
- **Go to Jail**: Move your token directly to jail.
- **Free Parking**: A safe space with no actions required.
- **Go**: Collect $200 as you pass.


## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.


Enjoy playing MegaPoly!
