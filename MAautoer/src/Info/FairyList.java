package Info;

import java.util.ArrayList;

import model.GameUtil;

public class FairyList {
	public ArrayList<Fairy> data;

	public FairyList() {
		data = new ArrayList<Fairy>();
	}

	public void getDetailFairy() {
		for (Fairy fairy : data)
			//if ((!fairy.isAttacked || fairy.name.startsWith("觉醒")) && fairy.isLive)
			if (fairy.isLive)
				GameUtil.getFairyDetail(fairy);
	}

	public Fairy getFairyById(String id) {
		for (Fairy fairy : data)
			if (fairy.id.equals(id))
				return fairy;
		return null;
	}

	public void setFairyAttack(String username, String deck) {
		for (Fairy fairy : data) {
			if (fairy.userName.equals(username)) {
				fairy.orderAttack = true;
				fairy.orderAttackDeck = deck;
			}
		}
	}

	public void inheritInfo(FairyList fairyList) {
		for (Fairy fairy : fairyList.data) {
			if (fairy.isAttacked) {
				Fairy findFairy = getFairyById(fairy.id);
				if (findFairy != null && findFairy.isLive)
					findFairy.isAttacked = true;
			}
			if (fairy.isAlerted != 0) {
				Fairy findFairy = getFairyById(fairy.id);
				if (findFairy != null && findFairy.isLive)
					findFairy.isAlerted = fairy.isAlerted;
			}
			if (fairy.discoverTime != 0) {
				Fairy findFairy = getFairyById(fairy.id);
				if (findFairy != null && findFairy.isLive)
					findFairy.discoverTime = fairy.discoverTime;
			}
			if (fairy.orderAttack) {
				Fairy findFairy = getFairyById(fairy.id);
				if (findFairy != null && findFairy.isLive) {
					findFairy.orderAttack = true;
					findFairy.orderAttackDeck = fairy.orderAttackDeck;
				}
			}
		}
	}
}
