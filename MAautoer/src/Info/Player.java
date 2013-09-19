package Info;

import java.util.ArrayList;

public class Player {
	public String username;
	public int gold;
	public int nowAp;
	public int maxAp;
	public int nowBc;
	public int maxBc;
	public int itemAp;
	public int itemBc;
	public int itemCollect;
	public Ranking ranking;
	public boolean haveFairy = false;
	public CardList cardList;
	public ArrayList<String> shouldSellIdList = new ArrayList<String>();
}
