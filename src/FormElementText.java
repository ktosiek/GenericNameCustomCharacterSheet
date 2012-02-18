import android.content.Context;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class FormElementText extends LinearLayout implements FormElement {
	
	TextView label;
	EditText edit;

	public FormElementText(Context context) {
		super(context);
		label = new TextView(this.getContext());
		edit = new EditText(this.getContext());
	}
	
	@Override
	public String getType() {
		return "text";
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

}
