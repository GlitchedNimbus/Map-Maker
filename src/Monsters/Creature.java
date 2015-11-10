package Monsters;
import java.util.Random;

public class Creature {

	int hp;
	double CR;
	int AC;
	String size;
	String type;
	String Traits = "";
	int number;

	Random gen = new Random();

	public Creature() {
		CR();
		if (CR != .5) {
			CR = CR - .5;
		}
		HP();
		AC();
		size();
		typing();
		int number = 2;
		adjusting();
		traits(number);

	}
	
	public Creature(double CR){
		this.CR = CR;
		if (CR != .5) {
			CR = CR - .5;
		}
		HP();
		AC();
		size();
		typing();
		int number = 2;
		adjusting();
		traits(number);
	}

	public void adjusting() {
		// sizing for hp and ac
		if (size.equals("Tiny")) {
			hp = hp - 5;
			AC = AC + 3;
		}

		if (size.equals("Small")) {
			hp = hp - 3;
			AC = AC + 1;
		}

		if (size.equals("Large")) {
			hp = hp + 10;
			AC = AC - 1;
		}

		if (size.equals("Huge")) {
			hp = hp + 25;
			AC = AC - 3;
		}

		if (AC > 22) {
			hp = (int) ((hp - (3 * CR)) * 10 / 10);
		}

		if (AC > 25) {
			hp = (int) ((hp - (1 * CR)) * 10 / 10);
		}
		if (AC > 27) {
			hp = (int) ((hp - (1 * CR)) * 10 / 10);
		}

	}

	public String tostring() {
		String str = "";
		str += "HP: " + hp + "\n\n";
		str += "CR: " + CR + "\n\n";
		str += "AC: " + AC + "\n\n";
		str += "Size: " + size + "\n\n";
		str += "Type: " + type + "\n";
		str += Traits + "\n";
		return str;
	}

	public void HP() {
		String hitpoints = "";

		// 20
		if (CR == 20.0) {
			hp = gen.nextInt(84) + 326;
		}

		// 19
		if (CR == 19.0) {
			hp = gen.nextInt(80) + 289;
		}

		// 18
		if (CR == 18.0) {
			hp = gen.nextInt(76) + 253;
		}

		// 17
		if (CR == 17.0) {
			hp = gen.nextInt(72) + 227;
		}

		// 16
		if (CR == 16.0) {
			hp = gen.nextInt(68) + 202;
		}

		// 15
		if (CR == 15.0) {
			hp = gen.nextInt(64) + 175;
		}

		// 14
		if (CR == 14.0) {
			hp = gen.nextInt(60) + 159;
		}

		// 13
		if (CR == 13.0) {
			hp = gen.nextInt(56) + 144;
		}

		// 12
		if (CR == 12.0) {
			hp = gen.nextInt(52) + 127;
		}

		// 11
		if (CR == 11.0) {
			hp = gen.nextInt(48) + 112;
		}

		// 10
		if (CR == 10.0) {
			hp = gen.nextInt(44) + 101;
		}

		// 9
		if (CR == 9.0) {
			hp = gen.nextInt(40) + 90;
		}

		// 8
		if (CR == 8.0) {
			hp = gen.nextInt(36) + 78;
		}

		// 7
		if (CR == 7.0) {
			hp = gen.nextInt(32) + 67;
		}

		// 6
		if (CR == 6.0) {
			hp = gen.nextInt(28) + 56;
		}

		// 5
		if (CR == 5.0) {
			hp = gen.nextInt(24) + 45;
		}

		// 4
		if (CR == 4.0) {
			hp = gen.nextInt(20) + 30;
		}

		// 3
		if (CR == 3.0) {
			hp = gen.nextInt(16) + 22;
		}

		// 2
		if (CR == 2.0) {
			hp = gen.nextInt(12) + 14;
		}

		// 1
		if (CR == 1.0) {
			hp = gen.nextInt(8) + 11;
		}

		// 1/2
		if (CR == .5) {
			hp = gen.nextInt(5) + 7;
		}

	}

	private void size() {
		// TODO Auto-generated method stub
		String[] sizeness = new String[5];
		sizeness[0] = "Tiny";
		sizeness[1] = "Small";
		sizeness[2] = "Medium";
		sizeness[3] = "Large";
		sizeness[4] = "Huge";

		size = sizeness[gen.nextInt(5)];
	}

	private void CR() {
		// TODO Auto-generated method stub
		CR = gen.nextInt(20) + .5;
	}

	private void AC() {
		if (CR == .5) {
			AC = gen.nextInt(4) + 9;
		}

		if (CR == 1.0) {
			AC = gen.nextInt(4) + 9;
		}

		if (CR == 2.0) {
			AC = gen.nextInt(4) + 11;
		}

		if (CR == 3.0) {
			AC = gen.nextInt(4) + 13;
		}

		if (CR == 4.0) {
			AC = gen.nextInt(4) + 14;
		}

		if (CR == 5.0) {
			AC = gen.nextInt(4) + 15;
		}

		if (CR == 6.0) {
			AC = gen.nextInt(4) + 16;
		}

		if (CR == 7.0) {
			AC = gen.nextInt(4) + 18;
		}

		if (CR == 8.0) {
			AC = gen.nextInt(4) + 19;
		}

		if (CR == 9.0) {
			AC = gen.nextInt(4) + 20;
		}

		if (CR == 10.0) {
			AC = gen.nextInt(4) + 21;
		}

		if (CR == 11.0) {
			AC = gen.nextInt(5) + 22;
		}

		if (CR == 12.0) {
			AC = gen.nextInt(5) + 23;
		}

		if (CR == 13.0) {
			AC = gen.nextInt(5) + 24;
		}

		if (CR == 14.0) {
			AC = gen.nextInt(5) + 25;
		}

		if (CR == 15.0) {
			AC = gen.nextInt(5) + 26;
		}

		if (CR == 16.0) {
			AC = gen.nextInt(6) + 27;
		}

		if (CR == 17.0) {
			AC = gen.nextInt(6) + 28;
		}

		if (CR == 18.0) {
			AC = gen.nextInt(6) + 29;
		}

		if (CR == 19.0) {
			AC = gen.nextInt(6) + 30;
		}

		if (CR == 20.0) {
			AC = gen.nextInt(6) + 33;
		}

	}

	private void typing() {
		String[] types = new String[20];
		types[0] = "Aberration";
		types[1] = "Winged Animal";
		types[2] = "Construct";
		types[3] = "Dragon";
		types[4] = "Fey";
		types[5] = "Humanoid";
		types[6] = "Magical Beast";
		types[7] = "Monstrous Humanoid";
		types[8] = "Ooze";
		types[9] = "Outsider";
		types[10] = "Plant";
		types[11] = "Undead";
		types[12] = "Vermin";
		types[13] = "Fanged Animal";
		types[14] = "Clawed Animal";
		// types[15] = "";
		// types[16] = "";
		// types[17] = "";
		// types[18] = "";
		// types[19] = "";

		type = types[gen.nextInt(11)];
	}

	private void traits(int n) {
		String[] list = new String[7];

		if (type.equals("Aberration")) {
			list[0] = "Creature has Darkvision up to 60ft\n";
			list[1] = "Creature has tentacles that can snare opponent with succesful Grapple check (+10)\n";
			list[2] = "Creature has a potent mind, can use (Dominate Person) once every 4 turns as a spell\n like ability (Check is 10 + CR)\n";
			list[3] = "Creature does not breath, cannot be smothered or drowned\n";
			list[4] = "Creature has Ink sacs, can use (Color Spray) once every 3 turns\nas a spell like\n ability (CR as Caster Level)\n";
			list[5] = "Creature is alien in apearance, characters who fail will save have -2 on all\n rolls(except for damage) while in pressence of creature (Check is 10 + CR)\n";
			list[6] = "Creature can invade Dreams, characters who fail will save\ntake 4 Wisdom and Intelligence Damage (Check is 10 + CR) \n";
		}
		if (type.equals("Winged Animal")) {
			list[0] = "Creature can fly extraordinarily fast, fy spead is 110\n";
			list[1] = "Talons: 2d6+1 with +8 to hit\n";
			list[2] = "Beak: 1d8+2 with +9 to hit\n";
			list[3] = "Creature has Psonar/Psycholocation, can detect living creatures\n+30 to pecreption checks against the living\n";
			list[4] = "Creature has Darkvision up to 60ft\n";
			list[5] = "Screach: Creature lets out a violent screach, targets that fail\nwill save become shaken for 1d4+1\n";
			list[6] = "Creature is not suited for landing, when on ground creature is\n considered helpess\n";
		}
		if (type.equals("Construct")) {
			list[0] = "Construct is made with sturdy materials,\n damage resist +5\n";
			list[1] = "Construct is made by an exceptional\n magic user, +25 to HP\n";
			list[2] = "Construct has low light vision 60ft\n";
			list[3] = "Construct has Darkvision 60ft\n";
			list[4] = "Construct has a permanent mend spell, heals 5hp per turn\n";
			list[5] = "Construct is lighter than usual at the cost of sturdiness,\n 60 move speed and -20 hp\n";
			list[6] = "Construct radiates heat, deals 1d4+2 to ALL creatures within 5ft\n";
		}
		if (type.equals("Dragon")) {
			list[0] = "Dragon has well developed eyes darkvision 120ft\n";
			list[1] = "Dragon has a strong mind, immune to enchant affects\n";
			list[2] = "Dragon's scales are oddly smooth, +3 to armor class\n";
			list[3] = "Dragon spends most of its time flying, fly speed is 120\n";
			list[4] = "Dragon is borderline omniscient, you may ask one question prior to battle\n";
			list[5] = "Dragons breath attack is faster, 1d2+1 between uses\n";
			list[6] = "Dragon is older than it looks, + 30hp\n";
		}
		if (type.equals("Fey")) {
			list[0] = "Fey can affect the mind directly, can cast (Dominate Person)\nas a spell-like ability (Check is 10 + CR)\n";
			list[1] = "Fey has wings, fly speed is 60ft (if size is larger than medium, 90 ft)\n";
			list[2] = "Fey has psycho-empathy, and is unable to be lied to\n";
			list[3] = "Fey has perfect vision, dark vision 60ft\n";
			list[4] = "Fey is physicaly powerful, Smash: 1d6+5\n";
			list[5] = "Fey is strongly bound to nature, can cast (Black Tentacles)\nas a spell-like ability, tentacles are replaced by roots\n";
			list[6] = "Fey is able to shift dimensions, can cast (Dimension Door)\nas a spell like ability\n";
		}
		if (type.equals("Humanoid")) {
			list[0] = "Treat human as Class (Fighter) of level equal to challenge rating\n";
			list[1] = "Treat human as Class (Magician) of level equal to challenge rating\n";
			list[2] = "Treat human as Class (Rogue) of level equal to challenge rating\n";
			list[3] = "Treat human as Class (Ranger) of level equal to challenge rating\n";
			list[4] = "Treat human as Class (Barbarian) of level equal to challenge rating\n";
			list[5] = "Treat human as Class (Bard) of level equal to challenge rating\n";
			list[6] = "Treat human as Class (Cleric) of level equal to challenge rating\n";
		}
		if (type.equals("Magical Beast")) {
			list[0] = "Claws: 2d6+3 with plus 7 to hit\n";
			list[1] = "Bite: 1d8+6 with plus 8 to hit\n";
			list[2] = "Natural attacks are treated as Cold Iron\n";
			list[3] = "Beast has darkvision up to 60ft\n";
			list[4] = "Beast is able to speak a language currently known by party\n";
			list[5] = "Pounce: Beast makes a charge attack 1d6+4 with plus 10 to hit\nand a chance to grapple with plus 8 to grapple\n";
			list[6] = "Beast has a strong sense of smell, +15 to perception checks\nmade against non-constructs\n";
		}
		// trades ac for hp
		if (type.equals("Monstrous Humanoid")) {
			list[0] = "Monstrous Humanoid has 60ft darkvision\n";
			list[1] = "Monstrous Humanoid has Claws, Claws: 2d6+3\n";
			list[2] = "Monstrous Humanoid has an elemental resistance +10\n";
			list[3] = "Monstrous Humanoid has breath weapon, 15 foot cone,\n1d4+1 cooldown (reflex is 7 + CR\n)";
			list[4] = "Monstrous Humanoid has pebbled skin, +2 to Natural Armor\n";
			list[5] = "Monstrous Humanoid has edged scales, enemys whoattack with natural weapons take 1d6+2\n";
			list[6] = "Monstrous Humanoid has quick reflexes, +1 dodge AC, 45 move speed\n";
		}
		if (type.equals("Ooze")) {
			list[0] = "Ooze is extremely caustic, metal and objects that are softer are corroded, after 4 turns\nof contact non magical items are dissolved\n";
			list[1] = "Ooze has one type of elemental damage, contact deals 1d4+3\n";
			list[2] = "Ooze is extremely viscuous +5 CMD\n";
			list[3] = "Ooze moves quickly 30ft move speed\n";
			list[4] = "Ooze has pores, making a ranged touch attack with its slime at twice its size categories range,\nan affected character moves at half speed for 1d4+1\n";
			list[5] = "Ooze rebounds bludgeoning weapons, bounced attacks require a reflex save equal to CR + 10, or take\nnormal wepaon damage\n";
			list[6] = "Ooze has strong body acids, when grappled ooze steals 5 hp per turn, grapple + CR\n";
		}
		if (type.equals("Outsider")) {
			list[0] = "Outsider has a hostile arua, dealing 1d8 damage of their planar type per turn\n";
			list[1] = "Outsider is sinister in stature, will save equal to 10 + CR or be shaken for 1d4+1 turns\n";
			list[2] = "Outsider has full damage resistance to the opposite energy type\n";
			list[3] = "Outsider is extremely charismatic, can cast (Charm Monster) as a spell like\nability once per day, save is equal to 10 + CR\n";
			list[4] = "Outsider can cast (Summon Monster)(level equal to its level divided by three)\nas a spell like ability one per day\n";
			list[5] = "Outsider can cast (limited wish)(or Wish if CR > 10) if befriended\n";
			list[6] = "Outsider has (True Sight) and is immune to Illusion magic\n";
		}
		if (type.equals("Plant")) {
			list[0] = "Plant has elder bark, and is resistant +15 to fire\n";
			list[1] = "Thorns: Natural attacks made against the plant take 1d4+2 damage\n";
			list[2] = "Thorn Shot: ranged touch attack 1d6+3 plus CR/2 to hit\n";
			list[3] = "Poison Pods: When hit with a bludgeoning weapon the plant releases poison spores\nthat if inhaled are treated as(Night Mare Vapor)\n";
			list[4] = "Swallow Whole: Plant attacks a character that it has grappled, if swallowed\ncharacter takes 1d8 acid damage per turn\n";
			list[5] = "Plant has low-light vision for 60ft\n";
			list[6] = "Plant can detect vibrations within 30ft, +20 to perception against moving targets\n";
		}
		if (type.equals("Undead")) {
			list[0] = "";
			list[1] = "";
			list[2] = "";
			list[3] = "";
			list[4] = "";
			list[5] = "";
			list[6] = "";
		}
		if (type.equals("Vermin")) {
			list[1] = "";
			list[1] = "";
			list[1] = "";
			list[1] = "";
			list[1] = "";
			list[1] = "";
			list[1] = "";
		}
		if (type.equals("14")) {
			list[1] = "";
			list[1] = "";
			list[1] = "";
			list[1] = "";
			list[1] = "";
			list[1] = "";
			list[1] = "";

		}
		if (type.equals("15")) {
			list[1] = "";
			list[1] = "";
			list[1] = "";
			list[1] = "";
			list[1] = "";
			list[1] = "";
			list[1] = "";

		}

		// humanoid adjustment
		if (type.equals("Humanoid")) {
			n = 1;
		}

		for (int i = 0; i < n; i++) {
			String Temp = list[gen.nextInt(7)];

			while (Traits.contains(Temp)) {
				Temp = list[gen.nextInt(7)];
			}
			Traits += "\nTrait " + (i + 1) + ":" + Temp;
		}

		// Health adjustment for winged beast
		if (type.equals("Winged Animal")) {
			for (int i = 0; i < CR; i++)
				hp = hp - gen.nextInt(4);
		}

		// special stat boosts for constructs
		if (type.equals("Construct")) {
			if (size.equals("Small")) {
				hp = hp + 10;
			}
			if (size.equals("Medium")) {
				hp = hp + 20;
			}
			if (size.equals("Large")) {
				hp = hp + 30;
			}
			if (size.equals("Huge")) {
				hp = hp + 40;
			}

			if (Traits.contains(list[1])) {
				hp = hp + 25;
			}
			if (Traits.contains(list[5])) {
				hp = hp + 20;
			}
		}
		// special stat boosts for dragons
		if (type.equals("Dragon")) {
			if (Traits.contains(list[2])) {
				AC = AC + 3;
			}

			if (Traits.contains(list[6])) {
				hp = hp + 30;
			}
		}
		// Fey hp adjustments
		if (type.equals("Fey")) {
			for (int i = 0; i < CR; i++)
				hp = hp - gen.nextInt(4);
		}

		// Outsider

		// Monstrous Humanoid
		if (type.equals("Monstrous Humanoid")) {
			for (int i = 0; i < CR; i++) {
				AC = AC - (gen.nextInt(2) / 2);
				hp = hp + gen.nextInt(6);
			}

			if (Traits.contains(list[6])) {
				AC = AC + 1;
			}

			if (Traits.contains(list[4])) {
				AC = AC + 2;
			}
		}
	}
}