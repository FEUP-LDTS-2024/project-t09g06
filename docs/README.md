# LDTS_T09G06 Gauntlet

Welcome to our home made Gauntlet inspired game. Dive into relentless adventure where danger lurks around every corner, and only the most skilled players will survive.

What can you experience ? Take on the role of a brave hero as you face endless waves of foes, collect valuable loot and find doors to unlock new areas. As you progress things grow more difficult, and you, as the face of the good side, must have sharp reflexes and the best strategic thinking.

Project developed by André Gomes (up202304252@up.pt), Tiago Carvalho (up202103339@up.pt) and Vasco Alves (up202304912@up.pt) for **Software Design and Test Laboratory** subject of the second year of **Informatics and Computing Engineering Course**.


# Game Controls
## Menu
- **Navigation** - Up and Down Arrow keys to navigate through each menu option;
- **Selection** - Enter key to select option;

## Game
- **Movement** - Up, Down, Left and Right Arrow keys;
- **Shooting** - Space key;
- **Exiting** - 'q' key

# Implemented Features
- [x] **Starting Menu** - Menu displaying game options;
- [x] **Player Atack** - When a player atacks an enemy it gets hurt or dies;
- [x] **Random Enemy Movement** -  Enemies move randomly around the map;
- [x] **Hero Life** - If a enemy hits the hero, his life decreases, and the state of the hero's life shows in the screen (currently it's just a counter);
- [x] **Instructions Menu** -  Menu displaying game instructions;
- [x] **GameOver Screen** - When a player looses it's shown a game over screen.
- [x] **Map Movement** - When a player moves, the map moves around the player instead of the player, allowing dynamic views;
- [x] **Variety of Enemies** - There can be various type of enemies with diferent skills and power; 
- [x] **Enemies Atack** - Enemies atack the player hurting him or killing him;
- [x] **Enemy Movement** -  Enemies move in different ways, according to the desired map difficulty;
- [x] **Loot Items** - When the player sees a item in the map, he can pick it up(i.e. weapons and coins);
- [x] **Sound Effects** - When playing the game a background music can be heard, shooting makes a sound and hitting monsters too.
- [x] **Score Ranking** - After loosing the player can write is player name to be saved in the ranking;
- [x] **Selecting Levels** - Player can select map and difficulty to start game;

# Planned Features


- [ ] **Increasing Levels** - As time goes by the games gets more difficult (stronger enemies and higher enemies generation);
- [ ] **Save and Load Game** - A player may be able to load a previous game;
- [ ] **2nd Player** - Two players can play at the same time.


# UML Class Diagram
A UML Diagram representing the classes in the game and their methods.

![uml_image](/docs/images/UML_gauntlet.png)
<figcaption>Fig.1 - Game UML.</figcaption>



# Design
## Architectural Pattern

#### Problem in context

In game design the code can be extremely complex and extense. To ensure a good comprehension of the work done,  and in order to facilitate maintenance, the code structure must be easy to read.

A way to do it is to use the MVC pattern, where the internal logic is decoupled from the user interface.

### MVC Pattern

The pattern it's divided in three crutial parts:
- **Model** - It contains all the data and core logic to game functionality;
- **View** - It is responsible for displaying the data that the **Model** holds and presenting it to the user in a format they can understand and interact with;
- **Controller** - Acts as an intermediary between the **Model** and the **View**. It receives input from the user (through the **View**) and processes it, updating the **Model** as necessary. Then, it updates the View to reflect the changes.

In this game, as it's using the Lanterna FrameWork it was implemented with a **GUI** that extends the **View** to decouple Lanterna functionalities.

## States 

#### Problem in context
The game needs to manage different states during gameplay. These states could include the main menu, pause menu, gameplay, game over screen, and potentially more, depending on the player’s actions. As the game transitions between these states, it’s essential to handle each scenario effectively.

### State Pattern
The State Pattern provides an elegant solution to this problem. It allows an object to alter its behavior when its internal state changes. Essentially, the object appears to change its class depending on the state it is in. This pattern ensures that each state is handled by its own class, and the object can switch between them seamlessly.

To implement this it was used a concept of an abstract class, which defines methods that can be executed in different states.

## Game Loop

#### Problem in context

In any game, the core functionality involves continuously running the game while responding to user input, updating the game state, and rendering the game world. The game must be constantly checking for changes in state, updating the game’s logic, and drawing the scene for the player while keeping track of time.

### Game Loop Pattern
Designed to manage the flow of control within a game, ensuring the game continually updates and renders at a consistent rate. The core idea is to run the game in a loop where three major tasks occur on each iteration:
 -processing user input;
 - updating the game state;
 - and rendering the game view.

This pattern ensures that the state, controllers and viewers are updated in each loop.

Implemented in the game class.

## Singleton 

#### Problem in context 
In game development, managing resources efficiently is critical, especially when dealing with memory. If the game instantiates a new object every time it is called, memory consumption can quickly become unmanageable, leading to performance issues and crashes. To address this, it’s essential to ensure that only a single instance of the game object is created and used throughout the application, thereby minimizing resource overhead.

### Sigleton Pattern

The Singleton Pattern ensures that a class has only one instance throughout its entire lifecycle, providing a global point of access to that instance. This is particularly useful to avoid unnecessary duplication and resource wastage.

The pattern is implemented in the Game class, ensuring that no matter how many times the game is called or instantiated, only one instance of the game object exists.

## Element Factory

#### Problem in context
The game involves creating various types of game entities such as players, enemies, loot items, and obstacles. Each entity type might require specific initialization logic, attributes, and behaviors. Without a proper structure to handle the creation of these objects, it can become hard to instantiate them in multiple places throughout the game code. This can lead to redundant object creation logic, which is difficult to maintain and extend as the game grows in complexity.

### Factory Pattern
Provides a way to delegate the creation of objects to a specialized method instead of directly calling the constructor. It allows for the creation of objects without specifying the exact class of object that will be created. The factory method can decide which class to instantiate based on the context.

### Consequences:
Benefits of applying the above pattern:
- You avoid tight coupling between the creator and the concrete products.
- Open/Closed Principle. You can introduce new types of products into the program without breaking existing client code.
- You can construct objects step-by-step, defer construction steps or run steps recursively.

Implemented in ArenaBuilder, AudioLoader and SpriteLoader.

## Known-code smells

We have fixed all the errors reported by error-prone, except some we think it's not really an error, such as of the following code. Game is instantiated but then it's never called, but to be instatiated, with the implementation used, it has to be like this, so there's no other choice to leave the code as it is.

```Java
public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
       Game game =   Game.getInstance();
}
```

## Testing

As we were developing the game and trying to implement the planned features, we got lost in dependency hell. Existent tests from first submission broke, and fixing them turned almost impossible and doing new tests other than unit tests for models, was very challenging and for that we failed to implement more tests. As I (Tiago), was left responsible for this task, I take the responsibility for failing it.

# Self Evaluation

To streamline our collaborative work on the Gauntlet-like game, we divided the responsibilities among team members to optimize efficiency and leverage individual strengths in specific areas of the project. Each student focused on a particular group of features, contributing their skills to ensure a balanced distribution of tasks: Classes and Controllers, Viewer Classes and GUI, Tests and Otimization.

    André Gomes: 35%
    Tiago Carvalho: 30%
    Vasco Alves: 35%

This approach allowed each team member to specialize, enhancing productivity and cohesion throughout the development process.


