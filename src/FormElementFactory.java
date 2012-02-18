import java.util.Dictionary;
import java.util.HashMap;

import android.content.Context;


public class FormElementFactory {
	HashMap<String, Class> typeToClass = new HashMap<String, Class>();
	
	public FormElementFactory() {
		typeToClass.put("text", FormElementText.class);
		typeToClass.put("long_text", FormElementLongText.class);
		typeToClass.put("int", FormElementInt.class);
	}

	public FormElementBuilder getFormElement(String type, Context ctx) {
		if(typeToClass.containsKey(type)) {
			return new FormElementBuilder(typeToClass.get(type), ctx);
		} else {
			return null;
		}
	}

}
