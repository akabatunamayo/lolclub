package kadai;

public class Fiora extends Character {

	public Fiora(String name, int hp, int ad, int ar) {
		this.name = name;
		this.hp = hp;
		this.ad = ad;
		this.ar = ar;
		
	}
	public void repost(Enemy e) {
		System.out.println(this.name+"は狙いすました突きを繰り出した！");
		int critical = new java.util.Random().nextInt(3);
		switch(critical) {
		case 0:
		case 1:
		System.out.println(e.name+"に"+(ad+20)+"のダメージ！");
		e.hp=e.hp-(ad+20);
		if (e.hp <= 0) {
			e.die();
			}
			break;
		case 2: 
			System.out.println("急所に当たった！！");
			e.hp=0;
			e.die();
			break;
		}
		
		
		this.done();

	}
	@Override
	public void skill(Enemy[] es) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println(" 0:リポスト　1:戻る");
		int s_select = Main.number();
		switch(s_select){
		
		case 0:
			
		int c = this.a_select(es);
			this.repost(es[c]);
			
	}
	}
	
	@Override
	public void attack(Enemy e) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println(this.name+"は鋭い突きを繰り出した！");
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
