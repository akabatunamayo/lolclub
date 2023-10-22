package kadai;

public class Jarvanⅳ extends Character {

	public Jarvanⅳ(String name, int hp, int ad, int ar) {
		this.name = name;
		this.hp = hp;
		this.ad = ad;
		this.ar = ar;
		
	}
	public void flag(Enemy e) {
		System.out.println(this.name+"は旗を投げつける！");
		
		System.out.println(e.name+"に"+ad+"のダメージ！");
		e.hp=e.hp-ad;
		if (e.hp <= 0) {
			e.die();
		}
		System.out.println("デマーシアの御旗がジャーヴァン4世に力を与える！！");
		System.out.println("ジャーヴァン4世の力が50上がった！");
		this.ad=this.ad+50;
		this.done();
		

	}
	@Override
	public void skill(Enemy[] es) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println(" 0:デマーシアの旗印　1:戻る");
		int s_select = Main.number();
		switch(s_select){
		
		case 0:
			
		int c = this.a_select(es);
			this.flag(es[c]);
			
			break;
		
			
		}
	}

	@Override
	public void attack(Enemy e) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println(this.name+"が槍で突き上げる！");
		System.out.println(e.name+"に"+ad+"のダメージ！");
	    e.hp=e.hp-ad;
		if (e.hp <= 0) {
			e.die();
		}
		this.done();

	}

	@Override
	public void opening() {
		
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void GoodEnding() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void BadEnding() {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
}
