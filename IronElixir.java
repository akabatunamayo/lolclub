package kadai;

public class IronElixir extends Item {


	public IronElixir(String string,int number) {
		this.name = "アイアンエリクサー"; // TODO 自動生成されたコンストラクター・スタブ
		this.number=number;
	}


	public void use(Character c) {
		System.out.println("アイアンエリクサーを使った！" + c.name + "の防御力が上がった！");
		c.ar = c.ar + 100;
	}

	public void select(Enemy[] es) {

	}

	public void select(Character[] cs) {
		for (int a = 0; a < cs.length; a++) {
			System.out.print(a + ":" + cs[a].name);
			System.out.println("");
		}
		int ie = new java.util.Scanner(System.in).nextInt();

		this.use(cs[ie]);
	}

}
