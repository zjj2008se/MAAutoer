package Info;

import java.util.ArrayList;

public class AreaList {
	public ArrayList<Area> data;

	public AreaList() {
		data = new ArrayList<Area>();
	}

	public Area getAreaByName(String name) {
		for (Area area : data) {
			if (area.name.equals(name))
				return area;
		}
		return null;
	}
}
