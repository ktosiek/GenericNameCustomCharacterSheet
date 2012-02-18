package anddev.genericNameCustomCharacterSheet;

import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class GenericNameCustomCharacterSheetActivity extends Activity {
	private static final String TAG = GenericNameCustomCharacterSheetActivity.class.getSimpleName();
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        FileSystemAccess a = new FileSystemAccess();
        try {
			Log.d(TAG, a.getTemplateFiles().toString());
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
    }
}
