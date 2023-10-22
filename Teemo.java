package kadai;

public class Teemo extends Enemy {
	public Teemo(String name, int hp, int ad) {
		this.name = name;
		this.hp = hp;
		this.ad = ad;
	}

	public void attack(Character c) {
		
		if (this.hp > 0&&c.hp>0) {
			System.out.println(this.name + "の吹き矢攻撃！");
			System.out.println(c.name + "に" + (ad - c.ar) + "のダメージ！");
			c.hp = c.hp - (ad - c.ar);
		if(c.hp<=0) {
			c.die();
		}
		this.done();
		}

	}
}

