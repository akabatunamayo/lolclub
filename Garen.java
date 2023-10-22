package kadai;

public class Garen extends Character {
	
	 
	
	public Garen(String name, int hp, int ad, int ar) {
		this.name = name;
		this.hp = hp;
		this.ad = ad;
		this.ar = ar;
		
	
	}
	


	public void opening() {
		System.out.println("私はガレン。");
		System.out.println("現在敵地で敗走中、部下たちは一人また一人と倒れ、今は副官しか残っていない。");
		System.out.println("「ぐぁっ！」　背後で悲鳴、振り返ると倒れた副官の首に矢が刺さっていた。");
		System.out.println("奴だ。姿の見えない追手、音も無く敵を葬り去る“悪魔”");
		System.out.println("「姿を見せろ！！」　剣を構え、力の限り叫ぶ。生きて帰るにはここで迎え撃つしかない。");
		System.out.println("「ここにいるよ」　声がした方を向くと視えていたの茂みから浮かび上がるようにして小さな体が現れる。");
		System.out.println("驚愕に目を見開くのも束の間、すぐさま覚悟を決め、剣に力を込める。　「祖国のために…！」");
		System.out.println("");

	}

	public void judgment(Enemy[] es) {
		System.out.println("ガレンが剣を振り回す");
		System.out.println("敵全体に" + (ad + 10) + "のダメージ");

		for (Enemy i : es) {
			i.hp = i.hp - (ad + 10);
			if (i.hp <= 0) {
			i.die();
		}
		
		}

	}

	public void skill(Enemy[] es) {
		System.out.println(" 0:ジャッジメント　1:戻る");
		int s_select = new java.util.Scanner(System.in).nextInt();
		switch (s_select) {
		case 0:

			this.judgment(es);
			for(int a=0;a<es.length;a++) {
			if (es[a].hp <= 0) {
				es[a].die();
			}
			}
			this.done();
			break;
		
			

		}
	}

	public void attack(Enemy e) {
		System.out.println(this.name + "が剣で切りつける！");
		System.out.println(e.name + "に" + ad + "のダメージ！");
		e.hp = e.hp - ad;
		if (e.hp <= 0) {
			e.die();
		}
		this.done();

	}

	public void escape() {
		System.out.println("今は逃げられる状態じゃない！");
	}

	public void GoodEnding() {
		System.out.println("");
		System.out.println("「デマーシアアアア！！」");
		System.out.println("ガレンの渾身の一撃が小柄な体躯を確かに捉える。");
		System.out.println("部隊を恐怖に陥れた悪魔は最期まで不気味な笑みを崩すことはなかった。");
		System.out.println("ガレンは呼吸を整え、立ち上がった。");
		System.out.println("逃げなければ…");
		System.out.println("欲を言えば同胞を弔いたかったが、いつ次の追手がくるかもわからない");
		System.out.println("ここはいまだ敵地なのだ。");
		System.out.println("");
		System.out.println("V　I　C　T　O　R　Y");
	}

	public void BadEnding() {
		System.out.println("");
		System.out.println("小型の矢がガレンの鎧の隙間を抜いて突き刺さる。");
		System.out.println("毒が塗られていたのだろう。体に力が入らない。");
		System.out.println("「デマ……シア…」　力尽き倒れるガレン");
		System.out.println("歪む視界が最後にとらえたのは悪魔の不気味な笑みだった。");
		System.out.println("");
		System.out.println("D　F　E　E　T");
	}
}
