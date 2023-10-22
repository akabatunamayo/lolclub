package kadai;

public abstract class Character {

	String name;
	int hp;
	int ad;
	int ar;
	boolean alive=true;
	boolean done=false;
	Weapon weapon;
	Item item;
	int itemnumber=0;
	//	
	//	public Character() {
	//
	//	}

	//	public Character(String name, int hp, int ad, int ar) {
	//		this.name = name;
	//		this.hp = hp;
	//		this.ad = ad;
	//		this.ar = ar;
	//		this.done = false;
	//	}

	public void turn() {
		this.done=false;
	}
	public void done() {
		this.done=true;
	}

	public void escape() {
		System.out.println(this.name + "は逃げ出した！");
	}

	public int a_select(Enemy[] es) {

		for (int a = 0; a < es.length; a++) {
			if (es[a].hp > 0) {
				System.out.print(a + ":" + es[a].name);
				System.out.println("");
			}
		}
		int b = Main.number();
		return b;

	}

	public void equip(Weapon w) {
		this.weapon = w;

		if (w.ad > 0) {
			this.ad = this.ad + w.ad;
		}
		if (w.ar > 0) {
			this.ar = this.ar + w.ar;
		}
		if (w.hp > 0) {
			this.hp = this.hp + w.hp;
		}

	}

	public void take(Item i) {
		this.item = i;
		this.itemnumber+=i.number;
	}

	public void item(Enemy[]es) {
		System.out.println("0:" + item.name + "×" + item.number);

		int use = Main.number();
		switch(use) {
		case 0:
		item.select(es);
		this.done();
		break;
	}
		}
	
	public void item(Character[]cs) {
		System.out.println("0:" + item.name + "×" + item.number);
		int use = Main.number();
		switch(use) {
		case 0:
			item.select(cs);
		break;
	}
	}
	public int select() {
		
		System.out.println(this.name + "の行動");

		System.out.println("0:通常攻撃　1:スキル　2:アイテム");
		int inputselect = new java.util.Scanner(System.in).nextInt();

		return inputselect;
	}
	public void die() {
		System.out.println(this.name + "は力尽きた・・・");
		this.hp = 0;
		this.alive=false;
	}
	

	public abstract void skill(Enemy[] es);

	public abstract void attack(Enemy e);

	public abstract void opening();

	public abstract void GoodEnding();

	public abstract void BadEnding();
}
