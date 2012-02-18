package anddev.card.form;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class FormElementLongText extends LinearLayout implements FormElement {

	TextView label;
	EditText edit;
	
	public FormElementLongText(Context context) {
		super(context);
		label = new TextView(this.getContext());
		edit = new EditText(this.getContext());
		this.addView(label);
		this.addView(edit);
		edit.setLines(4);
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
		return "long_text";
	}

}
