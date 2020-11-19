

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manny
 */
public class Mob {
    String name;
    String description;
    int hp;
    int atk;
    int def;
    
    final String[] names = {
        "Cerebrocrustacean", "Celestialsapien" , "Zabrak", "Zerg", "Florauna", 
        "Fulmini", "Appoplexian", "Andalite", "Orishan", "Plorgonarian"};
    
    final String[] descriptors = {
    "Crab-like aliens from Encephalonus IV with massive \n"
        + "heads due to super-sized brains. They are extremely intelligent \n"
        + "(their IQ is at one nonillion) and can use their enhanced intelligence \n"
        + "to perfectly calculate the trajectory of objects,operate complicated \n"
        + "machinery, and come up with strategies for combat on the fly.\n",
    "Horned humanoids with a body similar to that of a starry night sky from the \n"
        + "Forge of Creation, they can warp space, time and reality. However, they \n"
        + "are limited by their psyche: their minds are divided into separate \n"
        + "personalities that need to agree in order to do even simple tasks, causing \n"
        + "them to remain motionless for long periods of time.\n",
    "Alternative name for the humanoid Iridonian race whose most distinctive feature \n"
        + "is the array of small horns on top of their heads. Their home planet is \n"
        + "Iridonia, though they have established many colonies on planets throughout \n"
        + "the galaxy.\n",
    "Operating as a hive mind-linked \"chain of command\", the Zerg strive for \"genetic \n"
        + "perfection\" by assimilating the unique genetic code of advanced species \n"
        + "deemed \"worthy\" into their own gene pool, creating numerous variations of \n"
        + "specialized strains of Zerg gifted with unique adaptations.\n",
    "Cycloptic, plant-like creatures from planet Flors Verdance who can control \n"
        + "plants. They can generate seed bombs that unleash knockout gas or vines \n"
        + "to trap enemies, stretch their arms far distances, generate thorns on \n"
        + "their bodies, and merge with plant life.\n",
    "A race of energy beings hailing from planet Fulmas, these warlike aliens are \n"
        + "very dangerous. Resembling stone-armored beings made of blue electricity, \n"
        + "they are masters of controlling electricity, and are able to absorb energy \n"
        + "as well. Their MO is to create a wormhole to a new planet and suck it dry \n"
        + "of energy, as they need the energy to keep Fulmas from falling apart.\n",
    "Muscular tiger-like humanoids from the planet Apploplexia. They value emotional \n"
        + "openness, but this can be a problem since their primary emotion is rage, \n"
        + "and they are proud fighters. Primarily, they use claws on their wrists that \n"
        + "elongate when their rage increases, but are skilled in wrestling, though are \n"
        + "fatally vulnerable to certain high pitched noises.\n",
    "Centaur-like aliens, they have non-poisonous scorpion tails as a formidable weapon. \n"
        + "They lack mouths, so they use a technique called \"thought-speak\", similar \n"
        + "to but not quite telepathy, and they have four eyes: two on their face, and \n"
        + "two on stalks that give them 360 degree vision.\n",
    "A race of red-shelled mollusk-like humanoids from the desert planet Kiusana in \n"
        + "the Andromeda Galaxy. They are very important in the society of their arid \n"
        + "home planet, as they are powerful hydrokinetics, able to draw in moisture from \n"
        + "the air, unleash water blasts from portholes in their hands, and control \n"
        + "existing water at will. They are also quite durable in spite of their thin appearance.\n",
    "One-eyed, two-tongued, three-legged, squid-like creatures with green skin, narrow \n"
        + "bodies, three fingers on each hand, and an antenna on top of their heads that \n"
        + "functions as both a nose and an ear, and turns orange as they age. Their \n"
        + "home planet, Plorgonar, resembles the head of a Plorgonarian when seen \n"
        + "from space.\n"
    };
    
    public Mob() {
        this.name = names[(int) Math.ceil(Math.random() * 10) - 1];
        this.description = descriptors[(int) Math.ceil(Math.random() * 10) - 1];
        this.hp  = 10 + (int) Math.ceil(Math.random() * 19);
        this.atk = 75 + (int) Math.ceil(Math.random() * 49);
        this.def = 75 + (int) Math.ceil(Math.random() * 49);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
    
    
}
