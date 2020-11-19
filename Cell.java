

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manny
 */
public class Cell {
    int coordX;
    int coordY;
    boolean isStart;
    boolean isEnd;
//Array with 4 elements, N S E W respectively. 1 = wall, 0 = no wall
    int[] walls; 
    boolean hasMob;
    boolean isMobDefeated;
    Mob mob;
    String description;
    final String startDescription;
    final String endDescription;
    final String[] descriptors = {
        
"You enter the room and realize these are the sleeping quarters. It is fairly \n"
    + "quiet. You tread carefully, being wary of your surroundings.\n",

"This must be the engine room. You gaze at the giant structures and marvel at \n"
    + "the sheer size of them. You quickly focus again, remembering that this \n"
    + "area may not be safe.\n",

"A restroom? Now is really not the time for that!\n",

"These were the showers used by the crew. You glance around and see the pipes \n"
    + "rusting and in disarray. A shower is the last thing on your mind, but \n"
    + "maybe there is useful here?\n",

"You go through the door and down some stairs into the lower level. This would \n"
    + "definitely be a bad place to encounter a ghoul...\n",

"The captain's quarters! You had never seen it before yourself. Quite \n"
    + "extravagant and pretentious compared to the crew's quarters. Elitism \n"
    + "is all too real. You walk in and get a closer look.\n",

"You enter an armory. You see dozens of weapons and supplies behind the \n"
    + "secure access door. Maybe we can open it up and get some goodies... \n"
    + "Feeling lucky?\n",

"This looks like the storage compartment. There's various containers of all \n"
    + "sizes. There could be some some useful supplies within them. On the \n"
    + "other hand, shuffling them wouldn't be very quiet or subtle. \n"
    + "Decisions, decisions.\n",

"Just a simple hallway. Not much to look at here...\n",

"The security control compartment! This would definitely help out getting \n"
    + "a better layout of the area! The door is locked with a keypad. On \n"
    + "the side of the door you see something scrawled on the wall, \"78#\", \n"
    + "with the last number being illegible. We can try guessing the last \n"
    + "number to gain access... there's just no telling if the alarms are \n"
    + "still functioning...\n",

"You find some sleeping quarters. You notice a note on one of the bunks, \n"
    + "reading, \"You must costruct additional pylons.\". You wonder what \n"
    + "that's all about...\n",

"You've reached the crow's nest. You gaze at the vast darkness of space, \n"
    + "seeing an occasional star. How long has the ship been drifting away, \n"
    + "where in the universe have you found yourself? You look at the \n"
    + "navigation table in the middle of the room and see that it is comletely \n"
    + "smashed. Your heart sinks, feeling more desolate than ever. You try to \n"
    + "pull yourself together and continue looking through the room.\n",

"You enter the room and see that the room is not only empty, but it seems \n"
    + "that construction was never finished. A sign on the wall says \n"
    + "\"ERRCODE 404 - ROOM NOT FOUND\". Probably some of the laziest design \n"
    + "you've ever seen.\n",

"You've found the trash compactor. The accumulated dust suggests that \n"
    + "it has not been touched in quite some time. You look inside and \n"
    + "see some strange containers. You try to reach in and grab it, but \n"
    + "fail to reach them. You can attempt to jump in to retrieve them, \n"
    + "but there's no telling if the compactor is still functional. \n"
    + "What to do?\n",

"You found the Medical Bay! This would be a great time to assess yourself \n"
    + "and get some supplies if needed. The room looks clear, but there's no \n"
    + "telling for how long. If you're gonna look around, better make it quick.\n",

"Looks like this is the communication room. You see trancievers littered all \n"
    + "over the floor. You pick some of them up and notice that they are broken. \n"
    + "You throw them to the floor and continue looking around. A computer \n"
    + "system catches your eye. You see a black screen with white text displaying \n"
    + "the words \"Hello, World!\". What can this mean?\n"
        
        };
    
    public Cell() {
        this.coordX = 0;
        this.coordY = 0;
        this.isStart = false;
        this.isEnd = false;
        this.walls = new int[] {1,1,1,1};
        this.hasMob = false;
        this.isMobDefeated = false;
        this.mob = null;
        this.startDescription = "Pain...ughh...this throbbing...where am I? \n"
            + "You look around and find yourself in a strange room with tube-like \n"
            + "containers. Disoriented and vision blurry, you struggle to make out \n"
            + "what the words on the wall say...\"Cryogenic Containment Unit\". \n"
            + "Cryogenic stasis? Why would you have been in hypersleep? This makes \n"
            + "no sense. You stumble out of your chamber and make your way towards \n"
            + "the exit.\n";
        
        this.endDescription = "You enter the room and glance at a ring-like \n"
            + "structure in the middle of the room. You faintly recognize some of \n"
            + "its construction... it almost resembles a memory. You place your \n"
            + "hands over the controls and subconsciously start entering commands. \n"
            + "The structure begins to power up, glowing in a faint blue light. \n"
            + "The hollow center of the ring begins to swirl, materializing an eerie \n"
            + "plasma like substance. \"Sequence complete\", you hear being \n"
            + "announced over the intercom. You feel compelled to walk through the \n"
            + "ring, but there's no telling what is on the other side. What should \n"
            + "we do?\n";
        
        this.description = descriptors[(int) Math.ceil(Math.random() * 15)];
    }

    public boolean isIsMobDefeated() {
        return isMobDefeated;
    }

    public String getStartDescription() {
        return startDescription;
    }

    public String getEndDescription() {
        return endDescription;
    }

    public String[] getDescriptors() {
        return descriptors;
    }

    public void setIsMobDefeated(boolean isMobDefeated) {
        this.isMobDefeated = isMobDefeated;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public boolean isIsStart() {
        return isStart;
    }

    public void setIsStart(boolean isStart) {
        this.isStart = isStart;
    }

    public boolean isIsEnd() {
        return isEnd;
    }

    public void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public int[] getWalls() {
        return walls;
    }

    public void setWalls(int[] walls) {
        this.walls = walls;
    }

    public boolean isHasMob() {
        return hasMob;
    }

    public void setHasMob(boolean hasMob) {
        this.hasMob = hasMob;
    }

    public Mob getMob() {
        return mob;
    }

    public void setMob(Mob mob) {
        this.mob = mob;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
