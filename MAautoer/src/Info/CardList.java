package Info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CardList {
	public ArrayList<Card> data;

	public static HashMap<String, String> cardMap = new HashMap<String, String>();
	public static ArrayList<String> autoSellCardId = new ArrayList<String>();
	//TODO:将列表外置
	public CardList() {
		data = new ArrayList<Card>();
		if (cardMap.size() == 0) {
			cardMap.put("1", "第一型兰斯洛特:5:19");
			cardMap.put("2", "第二型加雷斯:4:10");
			cardMap.put("3", "支援型金发伊索德:4:9");
			cardMap.put("4", "支援型莉奥妮丝:1:5");
			cardMap.put("5", "第二型崔斯纽:3:7");
			cardMap.put("6", "复原型乌瑟:4:19");
			cardMap.put("7", "支援型阿斯特拉艾琳:4:10");
			cardMap.put("8", "支援型丽奈特:2:3");
			cardMap.put("9", "支援型依缇尔:1:3");
			cardMap.put("10", "支援型白手伊索德:3:8");
			cardMap.put("11", "亚瑟 -剑术之城-:3:7");
			cardMap.put("12", "第二型昂兹雷克:2:5");
			cardMap.put("13", "第二型加荷里斯:2:5");
			cardMap.put("15", "第二型兰马洛克:1:4");
			cardMap.put("16", "试作型伏提庚:1:10");
			cardMap.put("17", "第二型艾力克:2:5");
			cardMap.put("18", "第二型玛洛斯:2:4");
			cardMap.put("19", "第二型达玛斯:2:5");
			cardMap.put("20", "特异型威廉:4:16");
			cardMap.put("21", "特异型奥德修斯:2:7");
			cardMap.put("22", "特异型凯撒:4:10");
			cardMap.put("23", "特异型希格露恩:6:17");
			cardMap.put("24", "特异型纳杰吉塔:4:16");
			cardMap.put("25", "特异型汉尼拔:4:13");
			cardMap.put("26", "特异型玛丽:3:10");
			cardMap.put("27", "特异型罗宾汉:5:13");
			cardMap.put("29", "复制型渔夫王:4:16");
			cardMap.put("32", "试作型洛特:4:14");
			cardMap.put("33", "第二型格里弗雷特:4:9");
			cardMap.put("34", "第二型贝兰:3:7");
			cardMap.put("35", "特殊型哥罗亚斯:2:6");
			cardMap.put("36", "预言型梅林:3:8");
			cardMap.put("37", "虏获型摩高斯:4:9");
			cardMap.put("38", "第一型高文:5:16");
			cardMap.put("39", "第一型莫德雷德:6:19");
			cardMap.put("40", "制御型贝德维尔:1:3");
			cardMap.put("41", "特殊型尤文之狮:1:5");
			cardMap.put("42", "外敌型本:2:11");
			cardMap.put("43", "第二型柯尔格利万斯:4:12");
			cardMap.put("44", "第二型尤文:4:10");
			cardMap.put("46", "第二型亚格拉文:1:6");
			cardMap.put("47", "第二型卡尔迪斯:1:6");
			cardMap.put("48", "第二型迪拿丹:5:14");
			cardMap.put("49", "支援型律涅特:3:5");
			cardMap.put("50", "外敌型波尔斯:3:13");
			cardMap.put("51", "第二型凯尔丹:1:6");
			cardMap.put("52", "第二型卡洛格雷南:1:11");
			cardMap.put("53", "支援型洛蒂涅:2:5");
			cardMap.put("54", "第二型马伯纳格林:1:9");
			cardMap.put("56", "特异型维尔薇尤:3:10");
			cardMap.put("57", "特异型猎户座:4:13");
			cardMap.put("58", "特异型乔治:4:10");
			cardMap.put("59", "特异型贞德:5:18");
			cardMap.put("60", "特异型迪特里希:3:8");
			cardMap.put("61", "特异型拿破仑:4:12");
			cardMap.put("62", "特异型黑沃尔:3:8");
			cardMap.put("64", "特异型鲁克蕾齐亚:4:10");
			cardMap.put("65", "特殊型格林格莱特:1:3");
			cardMap.put("66", "教练型凯:1:5");
			cardMap.put("67", "试作型尤廉斯:3:8");
			cardMap.put("68", "第二型伯纳德:1:4");
			cardMap.put("69", "第二型路坎:2:4");
			cardMap.put("71", "王位型君士坦丁:6:20");
			cardMap.put("72", "第一型加拉哈德:5:15");
			cardMap.put("73", "第二型艾恩赛德:1:7");
			cardMap.put("76", "第二型罗恩格林:3:12");
			cardMap.put("77", "归化型妮妙:5:14");
			cardMap.put("78", "支援型奥尔特莉特:1:4");
			cardMap.put("79", "第二型提尔拉蒙:1:6");
			cardMap.put("80", "第二型贝琳:4:12");
			cardMap.put("82", "支援型布兰克韦恩:2:6");
			cardMap.put("83", "支援型贝莉珊:1:3");
			cardMap.put("85", "第二型布鲁诺:1:4");
			cardMap.put("86", "支援型艾妮多:4:11");
			cardMap.put("87", "支援型艾尔莎:1:7");
			cardMap.put("89", "第二型梅利甘斯:1:4");
			cardMap.put("90", "特异型安托瓦内特:4:9");
			cardMap.put("91", "特异型克娄巴特拉:3:13");
			cardMap.put("92", "特异型莎乐美:3:11");
			cardMap.put("93", "特异型圣日耳曼:3:7");
			cardMap.put("95", "特异型白雪公主:3:7");
			cardMap.put("96", "特异型达芬奇:5:16");
			cardMap.put("97", "特异型小灰人:6:20");
			cardMap.put("98", "特异型甲斐姬:4:14");
			cardMap.put("99", "特异型卑弥呼:4:10");
			cardMap.put("100", "支援型布兰奇芙蓉:1:9");
			cardMap.put("101", "支援型克莱尔:6:14");
			cardMap.put("102", "支援型圣杯伊莱恩:3:9");
			cardMap.put("103", "第二型艾塔德:3:6");
			cardMap.put("104", "第二型加隆:2:4");
			cardMap.put("105", "第二型卡多:1:6");
			cardMap.put("106", "第二型塔奎恩:2:7");
			cardMap.put("107", "第二型珀西瓦尔:4:13");
			cardMap.put("108", "第二型佩里诺亚:1:3");
			cardMap.put("109", "统御型桂妮薇儿:4:9");
			cardMap.put("110", "虏获型摩根:5:20");
			cardMap.put("111", "复制型艾尔:5:9");
			cardMap.put("112", "凯特西:5:14");
			cardMap.put("113", "凯尔皮:5:17");
			cardMap.put("114", "塔姆琳:5:20");
			cardMap.put("115", "杜拉尔汗:3:11");
			cardMap.put("116", "树妖:5:16");
			cardMap.put("117", "复制型菲:5:10");
			cardMap.put("118", "美人鱼:5:14");
			cardMap.put("119", "玛纳南:1:10");
			cardMap.put("120", "复制型莉菲:5:11");
			cardMap.put("121", "莉瓦亚珊:5:13");
			cardMap.put("122", "露:3:9");
			cardMap.put("123", "蕾普菈荷:5:12");
			cardMap.put("124", "第二型毕斯克拉乌莉特:2:2");
			cardMap.put("126", "第二型柏德玛戈斯:1:6");
			cardMap.put("127", "第二型吉夫雷斯:2:6");
			cardMap.put("128", "第二型索尔:5:14");
			cardMap.put("132", "第二型小波尔斯:1:3");
			cardMap.put("135", "第二型罗恩法尔:1:4");
			cardMap.put("136", "第二型佩里亚丝:4:10");
			cardMap.put("139", "第二型海琳:1:3");
			cardMap.put("140", "特殊型安波罗修:1:11");
			cardMap.put("141", "支援型奥尔温:1:5");
			cardMap.put("142", "第二型兰索尔:2:3");
			cardMap.put("143", "支援型艾文:3:6");
			cardMap.put("145", "特殊型罗艾娜:2:5");
			cardMap.put("146", "蓝帽子:5:19");
			cardMap.put("147", "斯普林甘:4:11");
			cardMap.put("148", "莉娅南希:5:19");
			cardMap.put("149", "希尔奇:5:19");
			cardMap.put("150", "雪莉柯特:4:12");
			cardMap.put("151", "佩格帕乌拉:3:10");
			cardMap.put("152", "格拉盖丝安努恩:6:15");
			cardMap.put("153", "古亚加:5:23");
			cardMap.put("154", "普卡:5:9");
			cardMap.put("155", "匹克西:5:17");
			cardMap.put("156", "姆莉安:5:18");
			cardMap.put("157", "塔尔威斯提格:5:15");
			cardMap.put("158", "绿之骑士:4:11");
			cardMap.put("159", "异界的女王:5:14");
			cardMap.put("160", "选拔骑士:3:8");
			cardMap.put("175", "第二型橄榄石:5:15");
			cardMap.put("176", "支援型甜心:4:9");
			cardMap.put("177", "支援型芙瓦妮塔:4:13");
			cardMap.put("178", "支援型提妮亚:4:13");
			cardMap.put("179", "支援型潘茜:3:11");
			cardMap.put("180", "支援型诗多莲:5:14");
			cardMap.put("181", "第二型丝莉特:2:9");
			cardMap.put("182", "第二型切利尼:2:7");
			cardMap.put("188", "第二型丝瓦莉:3:10");
			cardMap.put("190", "第二型巴基:2:8");
			cardMap.put("191", "第二型拉瓦:3:10");
			cardMap.put("197", "支援型罗索菲亚:5:16");
			cardMap.put("198", "第二型皮凯:3:11");
			cardMap.put("200", "支援型基安蒂:3:11");
			cardMap.put("201", "支援型梅尔特:4:14");
			cardMap.put("205", "支援型艾吉:3:10");
			cardMap.put("206", "第二型弗朗西斯:3:11");
			cardMap.put("208", "支援型爱尔兰:2:8");
			cardMap.put("215", "支援型乔治:2:12");
			cardMap.put("216", "支援型艾多尔利亚:4:16");
			cardMap.put("217", "支援型兰克:3:13");
			cardMap.put("223", "波寇:5:16");
			cardMap.put("224", "西西莉亚:5:13");
			cardMap.put("227", "支援型奥达:3:13");
			cardMap.put("262", "第二型艾伦:5:14");
			cardMap.put("280", "支援型索菲德:4:16");
			cardMap.put("287", "第二型罗恩:5:16");
			cardMap.put("288", "炎夏型菲:6:24");
			cardMap.put("289", "炎夏型摩高斯:4:16");
			cardMap.put("298", "炎夏型亚瑟-技巧之场-:6:25");
			cardMap.put("299", "炎夏型莉芙:5:22");
			cardMap.put("300", "炎夏型伊莱恩:4:18");
			cardMap.put("306", "支援型克罗基思:4:20");
			cardMap.put("307", "炎夏型艾尔:5:21");
			cardMap.put("308", "炎夏型加拉哈德:4:19");
			cardMap.put("309", "炎夏型摩根:4:17");
			cardMap.put("310", "炎夏型妮妙:6:23");
			cardMap.put("311", "炎夏型桂妮薇儿:5:20");
			cardMap.put("319", "学徒型橄榄石:5:20");
			cardMap.put("320", "学徒型玛丽:4:17");
			cardMap.put("327", "第二型蕾克香:3:9");
			cardMap.put("367", "支援型阿尔凯:4:18");
			cardMap.put("390", "切尔莉:1:99");
			cardMap.put("391", "超级切尔莉:3:99");
			cardMap.put("392", "究极切尔莉:5:99");
			cardMap.put("395", "异界型甜甜圈猫:5:22");
			cardMap.put("404", "极限突破切尔莉:6:99");
			cardMap.put("405", "库鲁敏:5:16");
			cardMap.put("407", "学徒型尼卡尔:4:13");
			cardMap.put("548", "幻兽型天马:5:14");
			cardMap.put("600", "特异型小龙女:5:14");
			cardMap.put("601", "特异型太乙真人:5:15");
			cardMap.put("602", "第一型塞拉利昂:6:18");
			cardMap.put("603", "特异型杨过:5:16");
			cardMap.put("604", "幻兽型梦魔亚:5:17");
			cardMap.put("605", "幻兽型月兔:5:14");
			cardMap.put("606", "特异型天山童姥:6:18");
			cardMap.put("607", "第二型骨姬:5:16");
			cardMap.put("608", "特异型杨过&小龙女:5:19");
			cardMap.put("609", "炎夏型丝麦茵:5:17");
			cardMap.put("610", "炎夏型琪妮安:5:19");
			cardMap.put("611", "炎夏型布露丹:5:15");
			cardMap.put("612", "炎夏型莉卡纳:5:18");
			cardMap.put("613", "炎夏型诺蕾:5:16");
			cardMap.put("615", "炎夏型艾丽菲尔:4:14");
			cardMap.put("618", "学徒型奥莉薇尔:5:16");
			cardMap.put("620", "学徒型德斯菲亚:5:17");
			cardMap.put("621", "学徒型菲妮斯:5:15");
			cardMap.put("622", "学徒型希绘美:5:14");
		}

		if (autoSellCardId.size() == 0) {
			autoSellCardId.add(getMasterIdByName("特殊型格林格莱特"));
			autoSellCardId.add(getMasterIdByName("支援型贝莉珊"));
			autoSellCardId.add(getMasterIdByName("支援型布兰克韦恩"));
			autoSellCardId.add(getMasterIdByName("第二型伯纳德"));
			autoSellCardId.add(getMasterIdByName("第二型玛洛斯"));
			autoSellCardId.add(getMasterIdByName("第二型加隆"));
			autoSellCardId.add(getMasterIdByName("支援型依缇尔"));
			autoSellCardId.add(getMasterIdByName("制御型贝德维尔"));
			autoSellCardId.add(getMasterIdByName("外敌型本"));
			autoSellCardId.add(getMasterIdByName("第二型凯尔丹"));
			autoSellCardId.add(getMasterIdByName("第二型卡洛格雷南"));
			autoSellCardId.add(getMasterIdByName("第二型马伯纳格林"));
			autoSellCardId.add(getMasterIdByName("第二型路坎"));
			autoSellCardId.add(getMasterIdByName("第二型梅利甘斯"));
			autoSellCardId.add(getMasterIdByName("第二型加隆"));
			autoSellCardId.add(getMasterIdByName("第二型佩里诺亚"));
			autoSellCardId.add(getMasterIdByName("特殊型罗艾娜"));
			autoSellCardId.add(getMasterIdByName("第二型亚格拉文"));
			autoSellCardId.add(getMasterIdByName("支援型奥尔温"));
			autoSellCardId.add(getMasterIdByName("第二型布鲁诺"));
			autoSellCardId.add(getMasterIdByName("第二型小波尔斯"));
			autoSellCardId.add(getMasterIdByName("支援型奥尔特莉特"));
			autoSellCardId.add(getMasterIdByName("特殊型安波罗修"));
			autoSellCardId.add(getMasterIdByName("第二型艾恩赛德"));
			autoSellCardId.add(getMasterIdByName("第二型提尔拉蒙"));
			autoSellCardId.add(getMasterIdByName("第二型卡尔迪斯"));
			autoSellCardId.add(getMasterIdByName("第二型海琳"));
			autoSellCardId.add(getMasterIdByName("支援型布兰奇芙蓉"));
			autoSellCardId.add(getMasterIdByName("支援型丽奈特"));
			autoSellCardId.add(getMasterIdByName("教练型凯"));
			autoSellCardId.add(getMasterIdByName("特殊型尤文之狮"));
			autoSellCardId.add(getMasterIdByName("特殊型哥罗亚斯"));
			autoSellCardId.add(getMasterIdByName("试作型伏提庚"));
			autoSellCardId.add(getMasterIdByName("第二型罗恩法尔"));
			autoSellCardId.add(getMasterIdByName("第二型加荷里斯"));
			autoSellCardId.add(getMasterIdByName("第二型柏德玛戈斯"));
			autoSellCardId.add(getMasterIdByName("第二型卡多"));
			autoSellCardId.add(getMasterIdByName("第二型吉夫雷斯"));
			autoSellCardId.add(getMasterIdByName("第二型兰索尔"));
			autoSellCardId.add(getMasterIdByName("第二型兰马洛克"));
			autoSellCardId.add(getMasterIdByName("第二型切利尼"));
			autoSellCardId.add(getMasterIdByName("支援型莉奥妮丝"));
			autoSellCardId.add(getMasterIdByName("支援型洛蒂涅"));
			autoSellCardId.add(getMasterIdByName("支援型乔治"));
			autoSellCardId.add(getMasterIdByName("第二型巴基"));
			autoSellCardId.add(getMasterIdByName("支援型爱尔兰"));
		}

	}

	public boolean shouldSell(Card card) {
		if (autoSellCardId.contains(card.master_id) && card.level < 10
				&& card.limit_over == 0
				&& Long.parseLong(card.serial_id) > 46000000
				&& card.holography == 0 && card.critical == 0) {
			// System.out.println("shouldSell: " + card.serial_id + ", " +
			// card.name + ", lv:" + card.level + ", atk:" + card.atk);
			return true;
		}
		return false;
	}

	public void add(Card card) {
		boolean hasMapData = (cardMap.get(card.master_id) != null);
		card.name = hasMapData ? cardMap.get(card.master_id).split(":")[0]
				: card.master_id;
		card.stars = hasMapData ? Integer.parseInt(cardMap.get(card.master_id)
				.split(":")[1]) : 0;
		card.cost = hasMapData ? Integer.parseInt(cardMap.get(card.master_id)
				.split(":")[2]) : 99;
		data.add(card);
	}

	public Card getCardBySerialId(String serial_id) {
		for (Card card : data)
			if (card.serial_id.equals(serial_id))
				return card;
		return null;
	}

	public int getStarsByName(String name) {
		for (String cardString : cardMap.values())
			if (cardString.split(":")[0].equals(name))
				return Integer.parseInt(cardString.split(":")[1]);
		return 0;
	}

	public String getMasterIdByName(String name) {
		for (Map.Entry<String, String> entry : cardMap.entrySet())
			if (entry.getValue().split(":")[0].equals(name))
				return entry.getKey();
		return null;
	}

	public void inheritInfo(CardList cardList) {
		for (Card card : cardList.data) {
			if (card.isShown) {
				Card findCard = getCardBySerialId(card.serial_id);
				if (findCard != null)
					findCard.isShown = true;
			}
		}
	}

}
