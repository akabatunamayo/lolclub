package kadai;

public class Lux extends Character{
	

public Lux(String name,int hp,int ad,int ar) {
	this.name=name;
    this.hp=hp;
    this.ad=ad;
    this.ar=ar;
    
    
    
    }



	

          
public void attack(Enemy e) {
	System.out.println(this.name+"が杖をたたきつける！");
	System.out.println(e.name+"に"+ad+"のダメージ！");
    e.hp=e.hp-ad;
	if (e.hp <= 0) {
		e.die();
	}
	this.done();

}
public void escape() {
	System.out.println("今は逃げられる状態じゃない！");
	}
public void magic(Enemy e) {
	System.out.println(this.name+"は光の矢を放った！");
	System.out.println(e.name+"に"+ad*3+"のダメージ！");
	e.hp=e.hp-ad*3;
	if (e.hp <= 0) {
		e.die();
	}
	this.done();

}

	
public void skill(Enemy[] es){
	System.out.println(" 0:レイ　1:戻る");
	int s_select = Main.number();
	switch(s_select){
	
	case 0:
		
	int c = this.a_select(es);
		this.magic(es[c]);
		
		break;
	
		
	}
	}



public void opening() {
	 System.out.println("私はラックス。現在森で一人途方に暮れていた。");
	 System.out.println("遠征に無理を言ってついてきたはいいものの、");
	 System.out.println("部隊は壊滅、必死で逃げているうちに兄ともはぐれてしまった。");
	 System.out.println("なんとかして合流しなくては…　そう思った矢先");
	 System.out.println("「デマーシアァ！！」　遠くで叫び声、兄の声だ！");
	 System.out.println("・　・　・");
	 System.out.println("声のもとへ向かうと、倒れ伏した兄の前に吹き矢を構えたヨードルが！！");
	 System.out.println("「光よ！！」　魔力を込め放った光弾は後方にそれ、不敵な笑みがこちらへ向く");
	 System.out.println("やるしかないみたいね…");
	 System.out.println("");
	 
	 
}
public void GoodEnding() {
	 System.out.println("");
	 System.out.println("光の矢が小柄な体を捉える！");
	 System.out.println("ヨードルはうめきながら後退する。");
	 System.out.println("倒れた兄を一瞥すると、素早い動きで森の奥へ消えていった。");
	 System.out.println("どうやら一旦は退けたらしい、兄のもとへ駆け寄る。");
	 System.out.println("息があることを確認して、胸をなでおろす。");
	 System.out.println("さて、これからどうしたものか…");
	 System.out.println("");
     System.out.println("V　I　C　T　O　R　Y");
}
public void BadEnding() {
	System.out.println("小型の矢がラックスの鎧の隙間を抜いて突き刺さる。");
    System.out.println("毒が塗られていたのだろう。体に力が入らない。");
    System.out.println("「兄…さん…」　力尽き倒れるラックス");
    System.out.println("歪む視界が最後にとらえたのは悪魔の不気味な笑みだった。");
    System.out.println("");
	 System.out.println("D　F　E　E　T");
}
}



