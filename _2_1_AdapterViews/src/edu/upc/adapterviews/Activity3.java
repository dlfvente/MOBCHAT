package edu.upc.adapterviews;

import edu.upc.adapters.MyAdapter3;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class Activity3 extends Activity {

  private ListView listView;
  private MyAdapter3 adapter;
  private ArrayList<String> messages;
  private EditText input_text;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main3);

    listView = (ListView) findViewById(R.id.main3ListView);
    messages = new ArrayList<String>();
    adapter = new MyAdapter3(this, messages);
    listView.setAdapter(adapter);
    input_text = (EditText) findViewById(R.id.input);
    
    for(int i=0; i<5; i++)
      messages.add("content of message nº"+i);
    
  }

  public void addText(final View view) {
    
    if(input_text.getEditableText().toString().equals("")) return;

    messages.add(input_text.getEditableText().toString());
    input_text.setText("");
    
    listView.post(new Runnable() {
        @Override
        public void run() {
            listView.setSelection(listView.getCount() - 1);
        }
    });
    
    adapter.notifyDataSetChanged();
  }

}
