------------------------------------------------------------------------------------------				
#										DUNGEONS OF DOOM V1.0
------------------------------------------------------------------------------------------

Dungeons of Doom is a text based adventure game which can be run through command line.
to proceed with installation please locate where this folder ha been saved and note it down.

INSTALLATION INSTRUCTIONS:

to install Dungeon of Doom, first open your command line/ git bash and navigate to the folder that you want to clone 
Dungeons of DAoom to. After this git clone the repository to the target location and open the subsequent folder in
vscode. Here, open your git bash terminal and run the command "javac DoD.java", after a little while
an empty line will appear below that command - here type "java DoD" to run the program.

------------------
USER INSTRUCTIONS:
------------------

As Dungeons of doom is a text based game there is a key for hat items on the map mean, these are:

P - this represents the player
E - this represents the exit
G - this represents Gold
. - this represents an empty space
'#' - this represents a wall

The Available commands to you are:
look - this allows you to see around your current position on the map in a 5x5 grid

hello - tells you how much gold you are required to collect on the current map, in order to access the exit

pickup - this command allows you to pick up gold from the current tile you are standing on, if there is no gold
a fail message will be displayed and the turn will be spent!

quit - allows you to exit the game

move - this command has 4 variations after the word move, these are "n","e","s","w". 
	-> Move n wil move your character north - up the map, 
	-> Move e will move your character east - to the right of the map,
	-> Move s will move your character south - down the map
	-> move w will move your character west - to the left of the map. 

If you run in to a "#" a fail message will be displayed and your turn will be spent!
