package kadai;

public abstract class Enemy {
	 String name;
     int hp;
	 int ad;
	 boolean alive=true;
	 boolean done=false;
//	 public Enemy() {
//		 
//	 }
//	 public Enemy(String name,int hp,int ad) {
//		 this.name=name;
//		    this.hp=hp;
//		    this.ad=ad;
//	 }
	public abstract void attack(Character c);
	
	public void turn() {
		this.done=false;
	}
	public void done() {
		this.done=true;
	}
	
	public void die() {
		System.out.println(this.name + "は倒れた！");
		this.hp = 0;
		this.alive=false;
	}
}
