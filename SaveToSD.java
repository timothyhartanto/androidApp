public class SaveToSD extends Activity implements OnClickListener{
	
	Button savePic;
	Button saveSound;
	EditText filename;
	boolean isSDAvail=false, isSDWriteable =false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.savetosd);
		savePic = (Button) findViewById(R.id.savePicture);
		saveSound =(Button)findViewById(R.id.saveSound);
		filename =(EditText)findViewById(R.id.filename);
		savePic.setOnClickListener(this);
		saveSound.setOnClickListener(this);
		
		checkSDStuff();
	}

	private void checkSDStuff() {
		// TODO Auto-generated method stub
		String state = Environment.getExternalStorageState();
		if(Environment.MEDIA_MOUNTED.equals(state)){
			//write
			isSDAvail = true;
			isSDWriteable =true;
		}else if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){
			//read only
			isSDAvail = true;
			isSDWriteable =false;
		}else{
			//uh-oh
			isSDAvail = false;
			isSDWriteable =false;
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.savePicture:
			if(isSDAvail && isSDWriteable){
			File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
			String name = filename.getText().toString();
			File file = new File(path, name + ".png");
			
			
				try {
					path.mkdirs();
					InputStream is = getResources().openRawResource(R.drawable.exit);
					OutputStream os;
					os = new FileOutputStream(file);
					byte[] data = new byte[is.available()];
					is.read(data);
					os.write(data);
					is.close();
					os.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			break;
		case R.id.saveSound:
			
		}
	}
}
