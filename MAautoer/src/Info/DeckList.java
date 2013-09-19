package Info;

import java.util.ArrayList;

public class DeckList {
	public ArrayList<Deck> data;

	public DeckList() {
		data = new ArrayList<Deck>();
	}

	public Deck getDeckByName(String name) {
		for (Deck deck : data)
			if (deck.name.equals(name))
				return deck;

		return null;
	}

	public Deck getDeckByContent(String member, String leader) {
		for (Deck deck : data)
			if (deck.member.equals(member) && deck.leader.equals(leader))
				return deck;

		return null;
	}
}
