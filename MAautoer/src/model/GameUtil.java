package model;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.message.BasicNameValuePair;

import Info.Area;
import Info.AreaList;
import Info.ActionResult;
import Info.CardList;
import Info.Deck;
import Info.Fairy;
import Info.Monster;
import Info.FairyList;
import Info.Player;
//import Info.Ranking;

public class GameUtil {
	public static String AP_RECOVER = "1";
	public static String BC_RECOVER = "2";
	private static String username;

	public static void init(String username) {
		//GameUtil.username = username;
	}

	public static Player login(String login_id, String password) {
		ArrayList<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("login_id", login_id));
		params.add(new BasicNameValuePair("password", password));
		System.out.println(login_id);
		System.out.println(password);
		String response = HttpUtil.connectPost("/connect/app/login?cyt=1",params);

		if (XmlUtil.getErrorCode(response) == 0)
			return XmlUtil.getLoginInfo(response);
		else {
			System.out.println("login Failed. Error Code: "
					+ XmlUtil.getErrorCode(response));
			System.out.println("login Failed. Error Msg: "
					+ XmlUtil.getErrorMessage(response));
			return null;
		}
	}

	public static Player getPlayerInfo() {
		String response = HttpUtil.connectPost("/connect/app/mainmenu?cyt=1",
				null);
		if (XmlUtil.getErrorCode(response) == 0)
			return XmlUtil.getPlayerInfo(response);
		else {
			System.out.println("getPlayerInfo Failed. Error Code: "
					+ XmlUtil.getErrorCode(response));
			System.out.println("getPlayerInfo Failed. Error Msg: "
					+ XmlUtil.getErrorMessage(response));
			return null;
		}
	}
	
	/*public static Ranking getMizugiRank(String username)
	{
		Ranking ranking = new Ranking();
		String response = HttpUtil.connectGet("http://game1-CBT.ma.sdo.com:10001/connect/web/201308_summer_campaign", 0);
		int index = response.indexOf("<th>比基尼数�?/th>");
		index = response.indexOf("<td>", index) + 4;
		if (index > 0)
			ranking.rank = Integer.parseInt(response.substring(index, response.indexOf("</td>", index)));
		return ranking;
	}*/
	
	public static String getFriend(String username)
	{
		ArrayList<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("move", "0"));
		String response = HttpUtil.connectPost(
				"/connect/app/menu/friendlist?cyt=1", params);
		
		if (XmlUtil.getErrorCode(response) == 0)
			return XmlUtil.getFriend(response, username);
		else {
			System.out.println("getFriend Failed. Error Code: "
					+ XmlUtil.getErrorCode(response));
			System.out.println("getFriend Failed. Error Msg: "
					+ XmlUtil.getErrorMessage(response));
			return null;
		}
	}
	
	public static void removeFriend(String id)
	{
		ArrayList<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("dialog", "1"));
		params.add(new BasicNameValuePair("user_id", id));
		String response = HttpUtil.connectPost(
				"/connect/app/friend/remove_friend?cyt=1", params);
	}

	public static AreaList getAreaList() {
		String response = HttpUtil.connectPost(
				"/connect/app/exploration/area?cyt=1", null);
		if (XmlUtil.getErrorCode(response) == 0)
			return XmlUtil.getAreaListInfo(response);
		else {
			System.out.println("getAreaList Failed. Error Code: "
					+ XmlUtil.getErrorCode(response));
			System.out.println("getAreaList Failed. Error Msg: "
					+ XmlUtil.getErrorMessage(response));
			return null;
		}
	}

	public static String getNowFloor(Area area) {
		ArrayList<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("area_id", area.id));
		String response = HttpUtil.connectPost(
				"/connect/app/exploration/floor?cyt=1", params);
		if (XmlUtil.getErrorCode(response) == 0)
			return XmlUtil.getNowFloor(response);
		else {
			System.out.println("getNowFloor Failed. Error Code: "
					+ XmlUtil.getErrorCode(response));
			System.out.println("getNowFloor Failed. Error Msg: "
					+ XmlUtil.getErrorMessage(response));
			return null;
		}
	}

	public static ActionResult explore(Area area, String floor) {
		ArrayList<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("area_id", area.id));
		params.add(new BasicNameValuePair("floor_id", floor));
		params.add(new BasicNameValuePair("auto_build", "1"));
		String response = HttpUtil.connectPost(
				"/connect/app/exploration/explore?cyt=1", params);

		if (XmlUtil.getErrorCode(response) == 0)
			return XmlUtil.getExploreResult(response);
		else {
			System.out.println("explore Failed. Error Code: "
					+ XmlUtil.getErrorCode(response));
			System.out.println("explore Failed. Error Msg: "
					+ XmlUtil.getErrorMessage(response));
			return null;
		}
	}

	public static Deck getDeck() {
		ArrayList<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("move", "1"));
		String response = HttpUtil.connectPost(
				"/connect/app/roundtable/edit?cyt=1", params);
		if (XmlUtil.getErrorCode(response) == 0)
			return XmlUtil.getDeck(response);
		else {
			System.out.println("getDeck Failed. Error Code: "
					+ XmlUtil.getErrorCode(response));
			System.out.println("getDeck Failed. Error Msg: "
					+ XmlUtil.getErrorMessage(response));
			return null;
		}
	}

	public static int setDeck(Deck deck) {
		ArrayList<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("C", deck.member));
		params.add(new BasicNameValuePair("lr", deck.leader));
		String response = HttpUtil.connectPost(
				"/connect/app/cardselect/savedeckcard?cyt=1", params);
		return XmlUtil.getErrorCode(response);
	}

	public static int useItem(String itemId) {
		ArrayList<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("item_id", itemId));
		String response = HttpUtil.connectPost("/connect/app/item/use?cyt=1",
				params);
		return XmlUtil.getErrorCode(response);
	}

	public static CardList getReward() {
		String response = HttpUtil.connectPost(
				"/connect/app/menu/fairyrewards?cyt=1", null);
		if (XmlUtil.getErrorCode(response) == 0
				|| XmlUtil.getErrorCode(response) == 8000)
			return XmlUtil.getCardList(response);
		else {
			System.out.println("getReward Failed. Error Code: "
					+ XmlUtil.getErrorCode(response));
			System.out.println("getReward Failed. Error Msg: "
					+ XmlUtil.getErrorMessage(response));
			return null;
		}
	}

	public static int sellCard(ArrayList<String> idList) {
		if (idList.size() == 0)
			return 0;
		int sellCount = 0;
		String sellString = "";
		while (idList.size() > 0) {
			sellString += idList.get(0) + ",";
			idList.remove(0);
			sellCount++;

			if (sellCount == 30) {
				if (GameUtil.sellCard(idList) != 1010)
					return -1;
			}
		}
		if (sellString.endsWith(","))
			sellString = sellString.substring(0, sellString.length() - 1);

		ArrayList<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("serial_id", sellString));
		String response = HttpUtil.connectPost("/connect/app/trunk/sell?cyt=1",
				params);
		// 1010 成功
		return XmlUtil.getErrorCode(response);
	}

	public static FairyList getFairyList() {
		String response = HttpUtil.connectPost(
				"/connect/app/menu/fairyselect?cyt=1", null);
		if (XmlUtil.getErrorCode(response) == 0)
			return XmlUtil.getFairyList(response);
		else {
			System.out.println("getFairyList Failed. Error Code: "
					+ XmlUtil.getErrorCode(response));
			System.out.println("getFairyList Failed. Error Msg: "
					+ XmlUtil.getErrorMessage(response));
			return null;
		}
	}

	public static int getFairyDetail(Fairy fairy) {
		ArrayList<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("serial_id", fairy.id));
		params.add(new BasicNameValuePair("user_id", fairy.userId));
		params.add(new BasicNameValuePair("check", "1"));
		String response = HttpUtil.connectPost(
				"/connect/app/exploration/fairy_floor?cyt=1", params);
		if (XmlUtil.getErrorCode(response) == 0)
			return XmlUtil.getFairyDetail(response, fairy, username);
		else {
			System.out.println("getFairyDetail Failed. Error Code: "
					+ XmlUtil.getErrorCode(response));
			System.out.println("getFairyDetail Failed. Error Msg: "
					+ XmlUtil.getErrorMessage(response));
			return -1;
		}
	}
	
	public static int setPoint(int ap, int bc)
	{
		ArrayList<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("ap", Integer.toString(ap)));
		params.add(new BasicNameValuePair("bc", Integer.toString(bc)));
		String response = HttpUtil.connectPost(
				"/connect/app/town/pointsetting?cyt=1", params);
		System.out.println(response);
		if (XmlUtil.getErrorCode(response) == 0)
			return 0;
		else if (XmlUtil.getErrorCode(response) == 8000)
			return 1;
		else {
			System.out.println("setPoint Failed. Error Code: "
					+ XmlUtil.getErrorCode(response));
			System.out.println("setPoint Failed. Error Msg: "
					+ XmlUtil.getErrorMessage(response));
			return -1;
		}
	}

	public static ActionResult doFairyBattle(Fairy fairy) {
		ArrayList<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("serial_id", fairy.id));
		params.add(new BasicNameValuePair("user_id", fairy.userId));
		String response = HttpUtil.connectPost(
				"/connect/app/exploration/fairybattle?cyt=1", params);

		// 0正常 1010怪死�?1050BC不够 8000重试
		int errorCode = XmlUtil.getErrorCode(response);
		if (errorCode == 0) {
			fairy.isAttacked = true;
			return XmlUtil.getBattleResult(response);
		} else if (errorCode == 1010) {
			ActionResult result = new ActionResult();
			result.isWinner = false;
			result.fairyDead = true;
			return result;
		} else if (errorCode == 1050) {
			ActionResult result = new ActionResult();
			result.isWinner = false;
			result.notEnoughBc = true;
			return result;
		} else if (errorCode == 8000) {
			if (XmlUtil.getErrorMessage(response).indexOf("持有的卡片数量已经超过上限!")!= -1) {
				ActionResult result = new ActionResult();
				result.isWinner = false;
				result.deckFull = true;
				return result;
			} else {
				try {
					Thread.currentThread().sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return doFairyBattle(fairy);
			}
		} else {
			System.out.println("BattleResult Failed. Error Code: "
					+ XmlUtil.getErrorCode(response));
			System.out.println("BattleResult Failed. Error Msg: "
					+ XmlUtil.getErrorMessage(response));
			return null;
		}
	}
}
