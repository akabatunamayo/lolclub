package kadai;

public class ThrowingKnife extends Item {
	

	public ThrowingKnife(String name,int number) {
		this.name = "投げナイフ"; // TODO 自動生成されたコンストラクター・スタブ
	this.number=number;
	}


	public void use(Enemy e) {
		System.out.println("投げナイフを放った！" + e.name + "に150のダメージ！");
		e.hp = e.hp - 150;
		this.number-=1;
		if (e.hp <= 0) {
			e.die();
		}
	}

	public void select(Enemy[] es) {
		for (int a = 0; a < es.length; a++) {
			if(es[a].hp>0) {
			System.out.print(a + ":" + es[a].name);
			System.out.println("");
			}
		}
		int tk = new java.util.Scanner(System.in).nextInt();

		this.use(es[tk]);

	}

	public void select(Character[] cs) {

	}

}
