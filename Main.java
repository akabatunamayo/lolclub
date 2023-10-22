package kadai;

import java.util.ArrayList;

public class Main {
	public static int number() {
		int number = new java.util.Scanner(System.in).nextInt();
		return number;
	}

	public static void main(String args[]) {

		int s = new java.util.Random().nextInt(2);
		Enemy[] enemys = new Enemy[s + 2];
		enemys[0] = new Teemo("ティーモ", 500, 300);

		for (int i = 1; i < s + 2; i++) {
			enemys[i] = new YordleScout("斥候ヨードル", 100, 150);
		}

		Item[] items = new Item[] {
				new ThrowingKnife("投げナイフ", 2),
				new Redpotion("レッドポーション", 2),
				new IronElixir("アイアンエリクサー", 1)
		};

		Character[] characters = new Character[] {
				new Garen("ガレン", 690, 69, 50),
				new Lux("ラックス", 450, 30, 0),
				new Jarvanⅳ("ジャーバン4世", 600, 50, 50),
				new Fiora("フィオラ", 500, 90, 5)
		};

		System.out.println("誰で物語を開始しますか？");
		System.out.println("0:ガレン　1:ラックス");
		int select = new java.util.Scanner(System.in).nextInt();

		System.out.println("連れていく仲間を二人選んでください");
		for (int i = 0; i < 4; i++) {
			if (i != select) {
				System.out.print(i + characters[i].name + "　");
			}
		}
		System.out.println("");
		int crew1 = new java.util.Scanner(System.in).nextInt();

		for (int i = 0; i < 4; i++) {
			if (i != select && i != crew1) {
				System.out.print(i + characters[i].name + "　");
			}
		}
		System.out.println("");
		int crew2 = new java.util.Scanner(System.in).nextInt();

		Character[] party = {
				characters[select], characters[crew1], characters[crew2],
		};

		System.out.println("ファーストアイテムを選択してください");
		System.out.println("0:ロングソード　1:ルビークリスタル　2：クロースアーマー");
		int weapon = new java.util.Scanner(System.in).nextInt();

		System.out.println("誰に装備させますか？");
		for (int i = 0; i < 3; i++) {
			System.out.print(i + party[i].name + "　");
		}
		System.out.println("");
		int weaponequip = new java.util.Scanner(System.in).nextInt();

		System.out.println("持ち物を選択してください");
		System.out.println("0:投げナイフ　1:レッドポーション　2：アイアンエリクサー");
		int item = new java.util.Scanner(System.in).nextInt();

		System.out.println("誰にもたせますか？");
		for (int i = 0; i < 3; i++) {
			System.out.print(i + party[i].name + "　");
		}
		System.out.println("");
		int itemtake = new java.util.Scanner(System.in).nextInt();

		party[itemtake].take(items[item]);

		Weapon[] weapons = new Weapon[3];
		weapons[0] = new Longsword();
		weapons[1] = new Rubycrystal();
		weapons[2] = new Clotharmor();

		party[weaponequip].equip(weapons[weapon]);

		characters[select].opening();

		System.out.println("ティーモが現れた！");
		System.out.println("斥候ヨードルが" + (s + 1) + "体現れた！　どうする？");

		ArrayList<Character> alivemember = new ArrayList<Character>();
		for (int i = 0; i < party.length; i++) {
			if (party[i].alive == true) {
				alivemember.add(party[i]);
			}
		}

		ArrayList<Enemy> aliveenemys = new ArrayList<Enemy>();
		for (int i = 0; i < enemys.length; i++) {
			if (enemys[i].alive == true) {
				aliveenemys.add(enemys[i]);
			}
		}
		
		while (alivemember.size() > 0 && aliveenemys.size() > 0) {

			System.out.println("0:たたかう　1:逃げる　2：体力確認");
			int input = new java.util.Scanner(System.in).nextInt();

			switch (input) {
			case 0:
				for (int i = 0; i < party.length; i++) {
					party[i].turn();
					if (party[i].alive == true && party[i].done == false) {

						switch (party[i].select()) {
						case 0:
							int attack = party[i].a_select(enemys);
							party[i].attack(enemys[attack]);

							break;

						case 1:
							party[i].skill(enemys);
							if (party[i].done == false) {
								battle(party[i], enemys, items[item], party);
							}

							break;

						case 2:
							if (party[i].itemnumber > 0) {
								System.out.println("0:" + items[item].name + "×" + items[item].number);
								int use = number();
								switch (use) {
								case 0:

									items[item].select(enemys);
									items[item].select(party);

									break;
								}

							} else {
								battle(party[i], enemys, items[item], party);
							}

							break;
						}
					}
				}

				for (int i = 0; i < enemys.length; i++) {
					enemys[i].turn();
					while (enemys[i].done == false && enemys[i].alive == true) {
						int enemyattack = new java.util.Random().nextInt(party.length);
						enemys[i].attack(party[enemyattack]);
					}
				}

				for (int i = 0; i < party.length; i++) {
					if (party[i].alive == false) {
						alivemember.remove(party[i]);
					}
				}

				for (int i = 0; i < enemys.length; i++) {
					if (enemys[i].alive == false) {
						aliveenemys.remove(enemys[i]);
					}
				}

				break;

			case 1:
				party[0].escape();
				for (int i = 0; i < s + 2; i++) {
					enemys[i].turn();
					while (enemys[i].done == false) {
						int enemyattack = new java.util.Random().nextInt(party.length);
						enemys[i].attack(party[enemyattack]);
					}
				}

				for (int i = 0; i < party.length; i++) {
					if (party[i].alive == false) {
						alivemember.remove(party[i]);
					}
				}

				break;

			case 2:

				for (int i = 0; i < party.length; i++) {
					if (party[i].hp < 0) {
						party[i].hp = 0;
					}
					System.out.print("　" + party[i].name + "のHP:" + party[i].hp);
				}
				for (int i = 0; i < enemys.length; i++) {
					if (enemys[i].hp > 0) {
						System.out.print("　" + enemys[i].name + "のHP:" + enemys[i].hp);

					}
					System.out.println("");

				}
				break;

			}

		}

		if (alivemember.size() == 0 && aliveenemys.size() > 0) {
			characters[select].BadEnding();
		}

		if (alivemember.size() > 0 && aliveenemys.size() == 0) {
			characters[select].GoodEnding();
		}
	}

	public static void battle(Character c, Enemy[] es, Item i, Character[] cs) {
		switch (c.select()) {
		case 0:
			int attack = c.a_select(es);
			c.attack(es[attack]);

			break;

		case 1:
			c.skill(es);

			break;

		case 2:
			if (c.itemnumber > 0) {
				System.out.println("0:" + i.name + "×" + i.number);
				int use = number();
				switch (use) {
				case 0:

					i.select(es);
					i.select(cs);

					break;
				}

			}

		}
	}
}
