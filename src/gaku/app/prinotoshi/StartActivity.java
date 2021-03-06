package gaku.app.prinotoshi;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class StartActivity extends Activity {

	private SurfaceView mSvMain;
    private PrinSurface mMainDrawArea;

    private ImageView item1,item2,item3;
    private static ImageView[] ITEM;

    private static String[] SETS;

    private SharedPreferences pref;

    // コンストラクタ
 	public StartActivity() {
 		super();
 	}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     	// タイトルバーを非表示
     	requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);

        pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SETS = pref.getString("item", "none,none,none").split(",");

        setItemView();

        // SurfaceViewを参照
        mSvMain = (SurfaceView)findViewById(R.id.Surface);


        // 作成したMainSurfaceViewクラスをインスタンス化
        mMainDrawArea = new PrinSurface(this, mSvMain);
    }

    @Override
    protected void onResume() {
    super.onResume();
    // SurfaceView のインスタンスを実体化し、ContentView としてセットする
    //SurfaceViewTest surfaceView = new SurfaceViewTest(this);
    setContentView(R.layout.main);

    setItemView();

    // SurfaceViewを参照
    mSvMain = (SurfaceView)findViewById(R.id.Surface);

    // 作成したMainSurfaceViewクラスをインスタンス化
    mMainDrawArea = new PrinSurface(this, mSvMain);

    }

    public void setItemView(){
    	// ImageViewを参照
        item1 = (ImageView)findViewById(R.id.itemSet1);
        item2 = (ImageView)findViewById(R.id.itemSet2);
        item3 = (ImageView)findViewById(R.id.itemSet3);

        ITEM = new ImageView[]{item1,item2,item3};



        pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        for(int i=0; i<3; i++){
        	Log.v("item",SETS[i]);
        	if(SETS[i].equals("muteki")){
        		ITEM[i].setImageResource(R.drawable.muteki5);
        	}
        	else if(SETS[i].equals("up10")){
        		ITEM[i].setImageResource(R.drawable.up10);
        	}
        	else if(SETS[i].equals("add5")){
        		ITEM[i].setImageResource(R.drawable.add5);
        	}
        	else if(SETS[i].equals("purin5")){
        		ITEM[i].setImageResource(R.drawable.purin5);
        	}
        	else if(SETS[i].equals("add1")){
        		ITEM[i].setImageResource(R.drawable.add1);
        	}
        	else if(SETS[i].equals("resurrection")){
        		ITEM[i].setImageResource(R.drawable.resurrection);
        	}
        }
    }
    public void item1click (View view){
    	PrinSurface.item1Go(view);
    	use(SETS[0],view);
    }

    public void item2click (View view){
    	PrinSurface.item2Go(view);
    	use(SETS[1],view);
    }

    public void item3click (View view){
    	PrinSurface.item3Go(view);
    	use(SETS[2],view);
    }

    public void use(String itemName,View view){
    	ImageView imageView = (ImageView)view;
    	if(itemName.equals("muteki")){
    		imageView.setImageResource(R.drawable.u_muteki5);
    	}else if(itemName.equals("purin5")){
    		imageView.setImageResource(R.drawable.u_purin5);
    	}
    }

    public static int useResurrection(){
    	for(int i=0;i<3;i++){
    		if(SETS[i].equals("resurrection")){
    			ITEM[i].setImageResource(R.drawable.u_resurrection);
    		}
    	}
		return 0;
    }

}