package kadai;

public abstract class Item {
	String name;
	int number;
	Item() {

	}

	public Item(String name) {
		this.name = name;
	}

	public abstract void select(Enemy[] es);

	public abstract void select(Character[] cs);
}
