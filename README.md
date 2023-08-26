--------------------				
# DUNGEONS OF DOOM
--------------------

Dungeons of Doom is a text-based adventure game which can be run through the command line.
to proceed with installation please follow the instructions below.

INSTALLATION INSTRUCTIONS:

to install Dungeon of Doom, first, open your command line/ git bash and navigate to the folder that you want to clone 
Dungeons of Doom to. After this git clone the repository to the target location and open the subsequent folder in
vscode. Here, open your git bash terminal and run the command "javac DoD.java", after a little while
an empty line will appear below that command - here type "java DoD" to run the program.

------------------
### USER INSTRUCTIONS:
------------------

As Dungeons of Doom is a text-based game there is a key for the items on the map, these are:

- **P** - this represents the player
- **E** - this represents the exit
- **G** - this represents Gold
- **.** - this represents an empty space
- **#** - this represents a wall

The Available commands to you are:

1. **look** - this allows you to see around your current position on the map in a 5x5 grid

2. **hello** - tells you how much gold you are required to collect on the current map, in order to access the exit

3. **pickup** - this command allows you to pick up gold from the current tile you are standing on, if there is no gold
a fail message will be displayed and the turn will be spent!

4. **quit** - allows you to exit the game

5. **move** - this command has 4 variations after the word move, these are "n","e","s","w". 
    * Move n will move your character north - up the map, 
    * Move e will move your character east - to the right of the map,
    * Move s will move your character south - down the map
    * move w will move your character west - to the left of the map. 

If you run into a "#" a fail message will be displayed and your turn will be spent!

------------------
### HOW TO PLAY:
------------------
The main focus of the game is to collect the required gold and exit the dungeon before the other players. Leaving you to be the last one standing!
**Key details:**

1. each player must take turns performing an action (look, hello, pickup, and move). Whether the move is successful or not, an action point will be used up.
2. Avoid your robotic counterparts, they may not be living but they still pack a punch
3. Collect the required Gold to be able to exit the dungeon! (easy enough)
4. And most importantly, have fun and good luck!
------------------
### KNOWN ISSUES:
------------------
* if the player character is placed on an E, G or a # too many times due to recursion the game could crash.
* players are able to use maps where it is impossible to complete or load the game :( 

----------------------------
### FEATURES IN DEVELOPMENT:
----------------------------

| Task # | Task                                                                     | progress| Done?                  |
| :----- |:-------------------------------------------------------------------------| :------:|:----------------------:|
| 1      | <ol><li> The ability randomly place player on map:</li><ul><li> The ability to check player isn't surronded by walls</li></ul><ol>                                                                             | 3/ 3    |<ul><li>- [X] </li></ul>|
| 2      | <ol><li>The ability to load on maps:</li><ul><li>Anounce whether default or loaded map is used</li><li>Anounce name of map</li><li>Update GameLogic class</li><li>Update HumanPlayer class</li><li>Check the format of the text file</li><li>Check that there is a path for the player to get to the required amount of gold and exit</li></ul></ol>                                              | 4/ 11    |<ul><li>- [ ] </li></ul>|
| 3      | Adding a Bot that will look for, follow and attack the player            | / ?     |<ul><li>- [ ] </li></ul>|
| 4      | Multiplayer connectivity - allowing more than one player to play together| / ?     |<ul><li>- [ ] </li></ul>|
| 5      | UI interface                                                             | / ?     |<ul><li>- [ ] </li></ul>|
| 6      | Option to play UI or CLI                                                 | / ?     |<ul><li>- [ ] </li></ul>|
| 7      | Ability to create maps using UI                                          | / ?     |<ul><li>- [ ] </li></ul>|
