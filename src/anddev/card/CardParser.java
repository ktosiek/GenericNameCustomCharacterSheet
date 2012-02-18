package anddev.card;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TabHost;
import android.widget.TextView;

public class CardParser
{
	private String TAG = CardParser.class.getCanonicalName();
	
	private Context	context;
	private TabHost root;
	private DocumentBuilder builder;
	
	

	public CardParser(Context context) throws ParserConfigurationException {
		super();
		this.context = context;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
	}
	
	public View parse(File card)
	{
		Document doc;
		try {
			doc = builder.parse(card);
			NodeList all = doc.getChildNodes();
			for(int q = 0 ; q < all.getLength() ; ++q)
				root.addView(procesNode(all.item(q)));
		}
		catch (SAXException e)
		{
			Log.e(TAG, e.getLocalizedMessage());			
		}
		catch (IOException e)
		{
			Log.e(TAG, e.getLocalizedMessage());
		}
		return null;
	}
	
	View procesNode(Node node)
	{
		if(node.hasChildNodes())
		{
			LinearLayout all = new LinearLayout(context);
			NodeList list = node.getChildNodes();
			for(int q = 0 ; q < list.getLength(); ++q)
			{
				View tmp = procesNode(node);
				if(tmp != null)
					all.addView(tmp);
			}
			return all;
		}
		else
		{
			TextView t = new TextView(context);
			t.setText("Tekst");
			return t;
		}
	}
}
