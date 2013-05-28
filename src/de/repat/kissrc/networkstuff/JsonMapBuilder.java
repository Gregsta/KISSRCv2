package de.repat.kissrc.networkstuff;

import java.util.HashMap;
import java.util.Map;

public class JsonMapBuilder {
	private JsonMapBuilder() {
	}

	public static Map<String, Object> buildJsonMap(String item ,Map<String, String> valueMap) {
		Map<String, Object> aendernMap = new HashMap<String, Object>();

		aendernMap.put("action", item);
		aendernMap.put("values", valueMap);
		aendernMap.put("Id", "TEAM_ROCKET");
		aendernMap.put("Version", null);

		return aendernMap;
	}

}
