package anddev.card.form;
import java.lang.reflect.InvocationTargetException;

import android.content.Context;


public class FormElementBuilder {
	FormElement formElement;
	
	public FormElementBuilder(Class cl, Context ctx) {
		try {
			formElement = (FormElement) cl.getConstructor(Context.class).newInstance(ctx);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block// TODO Auto-generated method stub
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public FormElementBuilder setTitle(String v) {
		formElement.setTitle(v);
		return this;
	}
	
	public FormElementBuilder setValue(String v) {
		formElement.setValue(v);
		return this;
	}
	
	public FormElement get() {
		return formElement;
	}
}
