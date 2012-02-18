package anddev.card.form;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class FormElementInt extends LinearLayout implements FormElement {
	
	TextView label;
	EditText edit;

	public FormElementInt(Context context) {
		super(context);
		label = new TextView(this.getContext());
		edit = new EditText(this.getContext());
		this.addView(label);
		this.addView(edit);
	}

	@Override
	public void setTitle(String v) {
		label.setText(v);
	}

	@Override
	public String getTitle() {
		return label.getText().toString();
	}

	@Override
	public void setValue(String v) {
		edit.setText(v);
	}

	@Override
	public String getValue() {
		return edit.getText().toString();
	}

	@Override
	public String getType() {
		return "int";
	}

}
