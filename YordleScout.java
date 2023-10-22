package kadai;

public class YordleScout extends Enemy {
	public YordleScout(String name, int hp, int ad) {
		this.name = name;
		this.hp = hp;
		this.ad = ad;
	}

	public void attack(Character c) {
		
		if (hp > 0&&c.hp>0) {
			if (ad > c.ar) {
				System.out.println(this.name + "の吹き矢攻撃！");
				System.out.println(c.name + "に" + ad + "のダメージ！");
				c.hp = c.hp - (ad - c.ar);
			}
			if (ad <= c.ar) {
				System.out.println(this.name + "の吹き矢攻撃！");
				System.out.println(c.name + "に0のダメージ！");
			}
			if(c.hp<=0) {
				c.die();
			}
			this.done();
		}

	}


}
