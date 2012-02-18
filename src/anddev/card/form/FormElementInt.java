package anddev.card.form;
import android.content.Context;
import android.view.View;


public class FormElementInt extends View implements FormElement {

	public FormElementInt(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setTitle(String v) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValue(String v) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType() {
		return "int";
	}

}
