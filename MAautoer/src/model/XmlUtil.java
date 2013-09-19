package model;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import Info.Area;
import Info.AreaList;
import Info.ActionResult;
import Info.Card;
import Info.CardList;
import Info.Deck;
import Info.DeckList;
import Info.Fairy;
import Info.FairyList;
import Info.Player;
import Info.Ranking;

public class XmlUtil {
	private static String configPath;

	public static void init(String configPath) {
		XmlUtil.configPath = configPath;
	}

	public static int getErrorCode(String xmlString) {
		try {
			Document doc = DocumentHelper.parseText(xmlString);
			Node error_code = doc
					.selectSingleNode("//response/header/error/code");
			return Integer.parseInt(error_code.getText());
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return -1;
	}

	public static String getErrorMessage(String xmlString) {
		try {
			Document doc = DocumentHelper.parseText(xmlString);
			Node error_msg = doc
					.selectSingleNode("//response/header/error/message");
			return error_msg.getText();
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return "";
	}

	@SuppressWarnings("unchecked")
	public static Player getLoginInfo(String xmlString) {
		try {
			Player player = new Player();
			player.itemAp = XmlUtil.getItemNum(xmlString, 1);
			player.itemBc = XmlUtil.getItemNum(xmlString, 2);
			player.itemCollect = XmlUtil.getItemNum(xmlString, 46);
			player.cardList = XmlUtil.getCardList(xmlString);
			return player;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static Ranking getMizugiRank(String xmlString, String username){
		try {
			Ranking ranking = new Ranking();
			Document doc = DocumentHelper.parseText(xmlString);
			List<Node> nameList = doc
					.selectNodes("//response/body/ranking/user_list/user/name");
			List<Node> rankList = doc
					.selectNodes("//response/body/ranking/user_list/user/rank");
			List<Node> pointList = doc
					.selectNodes("//response/body/ranking/user_list/user/battle_event_point");
			
			int itemCount = (nameList.size() == rankList.size() &&
							 nameList.size() == pointList.size()) ? nameList.size() : -1;
			
			for (int i = 0; i < itemCount; i++)
			{
				if (nameList.get(i).getText().equals(username))
				{
					ranking.rank = Integer.parseInt(rankList.get(i).getText());
					ranking.next = Integer.parseInt(pointList.get(i-1).getText()) - Integer.parseInt(pointList.get(i).getText());
					ranking.prev = Integer.parseInt(pointList.get(i).getText()) - Integer.parseInt(pointList.get(i+1).getText());
					return ranking;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static String getFriend(String xmlString, String username)
	{
		try {
			Document doc = DocumentHelper.parseText(xmlString);
			List<Node> nameList = doc
					.selectNodes("//response/body/friend_list/user/name");
			List<Node> idList = doc
					.selectNodes("//response/body/friend_list/user/id");
			
			int userCount = (nameList.size() == idList.size()) ? nameList.size() : -1;
			
			for (int i = 0; i < userCount; i++)
				if (nameList.get(i).getText().equals(username))
					return idList.get(i).getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static int getItemNum(String xmlString, int itemId)
	{
		try {
			Document doc = DocumentHelper.parseText(xmlString);
			List<Node> itemNumList = doc
					.selectNodes("//response/header/your_data/itemlist/num");
			List<Node> itemIdList = doc
					.selectNodes("//response/header/your_data/itemlist/item_id");
			
			int itemCount = (itemNumList.size() == itemIdList.size()) ? itemNumList.size() : -1;
			
			for (int i = 0; i < itemCount; i++)
				if (itemIdList.get(i).getText().equals(Integer.toString(itemId)))
					return Integer.parseInt(itemNumList.get(i).getText());
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	public static CardList getCardList(String xmlString) {
		try {
			Document doc = DocumentHelper.parseText(xmlString);
			CardList cardList = new CardList();
			List<Node> serialIdList = doc
					.selectNodes("//response/header/your_data/owner_card_list/user_card/serial_id");
			List<Node> masterIdList = doc
					.selectNodes("//response/header/your_data/owner_card_list/user_card/master_card_id");
			List<Node> levelList = doc
					.selectNodes("//response/header/your_data/owner_card_list/user_card/lv");
			List<Node> levelMaxList = doc
					.selectNodes("//response/header/your_data/owner_card_list/user_card/lv_max");
			List<Node> hpList = doc
					.selectNodes("//response/header/your_data/owner_card_list/user_card/hp");
			List<Node> atkList = doc
					.selectNodes("//response/header/your_data/owner_card_list/user_card/power");
			List<Node> limitOverList = doc
					.selectNodes("//response/header/your_data/owner_card_list/user_card/limit_over");
			List<Node> holographyList = doc
					.selectNodes("//response/header/your_data/owner_card_list/user_card/holography");
			List<Node> criticalList = doc
					.selectNodes("//response/header/your_data/owner_card_list/user_card/critical");

			int cardCount = (serialIdList.size() == masterIdList.size()
					&& serialIdList.size() == levelList.size()
					&& serialIdList.size() == levelMaxList.size()
					&& serialIdList.size() == hpList.size()
					&& serialIdList.size() == atkList.size()
					&& serialIdList.size() == limitOverList.size()
					&& serialIdList.size() == holographyList.size() && serialIdList
					.size() == criticalList.size()) ? serialIdList.size() : -1;

			for (int i = 0; i < cardCount; i++) {
				Card card = new Card();
				card.serial_id = serialIdList.get(i).getText();
				card.master_id = masterIdList.get(i).getText();
				card.level = Integer.parseInt(levelList.get(i).getText());
				card.levelMax = Integer.parseInt(levelMaxList.get(i).getText());
				card.hp = Integer.parseInt(hpList.get(i).getText());
				card.atk = Integer.parseInt(atkList.get(i).getText());
				card.limit_over = Integer.parseInt(limitOverList.get(i)
						.getText());
				card.holography = Integer.parseInt(holographyList.get(i)
						.getText());
				card.critical = Integer.parseInt(criticalList.get(i).getText());
				cardList.add(card);
			}

			return cardList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static AreaList getAreaListInfo(String xmlString) {
		try {
			AreaList areaList = new AreaList();
			Document doc = DocumentHelper.parseText(xmlString);
			List<Node> idList = doc
					.selectNodes("//response/body/exploration_area/area_info_list/area_info/id");
			List<Node> nameList = doc
					.selectNodes("//response/body/exploration_area/area_info_list/area_info/name");
			List<Node> progressList = doc
					.selectNodes("//response/body/exploration_area/area_info_list/area_info/prog_area");
			List<Node> typeList = doc
					.selectNodes("//response/body/exploration_area/area_info_list/area_info/area_type");

			int areaCount = (idList.size() == nameList.size()
					&& idList.size() == progressList.size() && idList.size() == typeList
					.size()) ? idList.size() : -1;

			for (int i = 0; i < areaCount; i++) {
				Area area = new Area();
				area.id = idList.get(i).getText();
				area.name = nameList.get(i).getText();
				area.progress = progressList.get(i).getText();
				area.type = typeList.get(i).getText();
				areaList.data.add(area);
			}
			return areaList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static String getNowFloor(String xmlString) {
		try {
			Document doc = DocumentHelper.parseText(xmlString);
			List<Node> idList = doc
					.selectNodes("//response/body/exploration_floor/floor_info_list/floor_info/id");
			return idList.get(idList.size() - 1).getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Player getPlayerInfo(String xmlString) {
		try {
			Player player = new Player();
			Document doc = DocumentHelper.parseText(xmlString);
			Node username = doc
					.selectSingleNode("//response/header/your_data/name");
			Node gold = doc
					.selectSingleNode("//response/header/your_data/gold");
			Node nowAp = doc
					.selectSingleNode("//response/header/your_data/ap/current");
			Node maxAp = doc
					.selectSingleNode("//response/header/your_data/ap/max");
			Node nowBc = doc
					.selectSingleNode("//response/header/your_data/bc/current");
			Node maxBc = doc
					.selectSingleNode("//response/header/your_data/bc/max");
			player.username = username.getText();
			player.gold = Integer.parseInt(gold.getText());
			player.nowAp = Integer.parseInt(nowAp.getText());
			player.maxAp = Integer.parseInt(maxAp.getText());
			player.nowBc = Integer.parseInt(nowBc.getText());
			player.maxBc = Integer.parseInt(maxBc.getText());
			return player;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Deck getDeck(String xmlString) {
		try {
			Deck deck = new Deck();
			Document doc = DocumentHelper.parseText(xmlString);
			Node deck_cards = doc
					.selectSingleNode("//response/body/roundtable_edit/deck_cards");
			Node leader_card = doc
					.selectSingleNode("//response/body/roundtable_edit/leader_card");
			deck.member = deck_cards.getText();
			deck.leader = leader_card.getText();
			return deck;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int saveDeck(DeckList deckList) {
		try {
			File deckFile = new File(configPath);
			if (!deckFile.exists())
				deckFile.createNewFile();

			Document doc = DocumentHelper.createDocument();
			Element rootElement = doc.addElement("DeckList");
			for (Deck deck : deckList.data) {
				Element deckElement = rootElement.addElement("Deck");
				Element nameElement = deckElement.addElement("name");
				Element memberElement = deckElement.addElement("member");
				Element leaderElement = deckElement.addElement("leader");
				nameElement.setText(deck.name);
				memberElement.setText(deck.member);
				leaderElement.setText(deck.leader);
			}

			XMLWriter output = new XMLWriter(new FileWriter(deckFile));
			output.write(doc);
			output.close();
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	public static DeckList loadDeck() {
		try {
			DeckList deckList = new DeckList();
			File deckFile = new File(configPath);
			if (!deckFile.exists())
				return deckList;

			SAXReader reader = new SAXReader();
			Document doc = reader.read(deckFile);
			List<Node> nameList = doc.selectNodes("//DeckList/Deck/name");
			List<Node> memberList = doc.selectNodes("//DeckList/Deck/member");
			List<Node> leaderList = doc.selectNodes("//DeckList/Deck/leader");

			int deckCount = (nameList.size() == memberList.size() && nameList
					.size() == leaderList.size()) ? nameList.size() : -1;

			for (int i = 0; i < deckCount; i++) {
				Deck deck = new Deck();
				deck.name = nameList.get(i).getText();
				deck.member = memberList.get(i).getText();
				deck.leader = leaderList.get(i).getText();
				deckList.data.add(deck);
			}
			return deckList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static FairyList getFairyList(String xmlString) {
		try {
			FairyList fairyList = new FairyList();
			Document doc = DocumentHelper.parseText(xmlString);
			List<Node> fairyNameList = doc
					.selectNodes("//response/body/fairy_select/fairy_event/fairy/name");
			List<Node> fairyIdList = doc
					.selectNodes("//response/body/fairy_select/fairy_event/fairy/serial_id");
			List<Node> fairyLevelList = doc
					.selectNodes("//response/body/fairy_select/fairy_event/fairy/lv");
			List<Node> userNameList = doc
					.selectNodes("//response/body/fairy_select/fairy_event/user/name");
			List<Node> userIdList = doc
					.selectNodes("//response/body/fairy_select/fairy_event/user/id");
			List<Node> startTimeList = doc
					.selectNodes("//response/body/fairy_select/fairy_event/start_time");
			List<Node> isLiveList = doc
					.selectNodes("//response/body/fairy_select/fairy_event/put_down");
			List<Node> limitTimeList = doc
					.selectNodes("//response/body/fairy_select/fairy_event/fairy/time_limit");
			int fairyCount = (fairyNameList.size() == fairyIdList.size()
					&& fairyNameList.size() == fairyLevelList.size()
					&& fairyNameList.size() == userNameList.size()
					&& fairyNameList.size() == userIdList.size()
					&& fairyNameList.size() == startTimeList.size()
					&& fairyNameList.size() == isLiveList.size() && fairyNameList
					.size() == limitTimeList.size()) ? fairyNameList.size()
					: -1;

			if (fairyCount == -1)
				throw new Exception();

			for (int i = 0; i < fairyCount; i++) {
				Fairy fairy = new Fairy();
				fairy.name = fairyNameList.get(i).getText();
				fairy.id = fairyIdList.get(i).getText();
				fairy.level = Integer.parseInt(fairyLevelList.get(i).getText());
				fairy.userName = userNameList.get(i).getText();
				fairy.userId = userIdList.get(i).getText();
				fairy.startTime = Long
						.parseLong(startTimeList.get(i).getText());
				fairy.isLive = isLiveList.get(i).getText().equals("1");
				fairy.limitTime = Integer.parseInt(limitTimeList.get(i)
						.getText());
				fairyList.data.add(fairy);
			}
			return fairyList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static int getFairyDetail(String xmlString, Fairy fairy,
			String username) {
		try {
			Document doc = DocumentHelper.parseText(xmlString);
			Node fairyNowHp = doc
					.selectSingleNode("//response/body/fairy_floor/explore/fairy/hp");
			Node fairyMaxHp = doc
					.selectSingleNode("//response/body/fairy_floor/explore/fairy/hp_max");
			Node fairyRare = doc
					.selectSingleNode("//response/body/fairy_floor/explore/fairy/rare_flg");
			List<Node> attackers = doc
					.selectNodes("//response/body/fairy_floor/explore/fairy/attacker_history/attacker/user_name");

			fairy.nowHp = Integer.parseInt(fairyNowHp.getText());
			fairy.maxHp = Integer.parseInt(fairyMaxHp.getText());
			fairy.isRare = fairyRare.getText().equals("1");
			fairy.isLive = (fairy.nowHp != 0);
			for (Node attacker : attackers)
				if (attacker.getText().equals(username))
					fairy.isAttacked = true;

			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	public static ActionResult getBattleResult(String xmlString) {
		try {
			ActionResult battleResult = new ActionResult();
			Document doc = DocumentHelper.parseText(xmlString);
			Node winner = doc.selectSingleNode("//response/body/battle_result/winner");
			battleResult.isWinner = winner.getText().equals("1");
			battleResult.cardList = XmlUtil.getCardList(xmlString);
			battleResult.collectNum = XmlUtil.getItemNum(xmlString, 46);
			
			battleResult.damageDeal = 0;
			List<Node> actionList = doc.selectNodes("//response/body/battle_battle/battle_action_list");
			for (Node actionNode : actionList)
			{
				Node actPlayer = actionNode.selectSingleNode("action_player");
				Node atkDamage = actionNode.selectSingleNode("attack_damage");
				
				if (actPlayer != null && actPlayer.getText().equals("0") && atkDamage != null)
				{
					battleResult.damageDeal += Integer.parseInt(atkDamage.getText());
				}
			}

			return battleResult;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ActionResult getExploreResult(String xmlString) {
		try {
			ActionResult exploreResult = new ActionResult();
			exploreResult.deckFull = (XmlUtil.getErrorCode(xmlString) == 8000);
			exploreResult.cardList = XmlUtil.getCardList(xmlString);
			exploreResult.collectNum = XmlUtil.getItemNum(xmlString, 46);
			return exploreResult;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
