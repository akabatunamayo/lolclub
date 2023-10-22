package kadai;

public class Redpotion extends Item {


	public Redpotion(String string,int number) {
		this.name = "レッドポーション";// TODO 自動生成されたコンストラクター・スタブ
		this.number=number;
	}



	public void use(Character c) {
		System.out.println("ポーションを飲んだ！" +c.name+"の体力が350回復した！");
		c.hp = c.hp + 350;
		this.number-=1;
	}

	public void select(Enemy[] es) {

	}

	public void select(Character[] cs) {
		for (int a = 0; a < cs.length; a++) {
			System.out.print(a + ":" + cs[a].name);
			System.out.println("");
		}
		int rp = new java.util.Scanner(System.in).nextInt();

		this.use(cs[rp]);

	}

}
