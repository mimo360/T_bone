import android.app.Application;

import com.parse.Parse;

/**
 * Created by mimo360 on 2015/7/23.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this,"v5Q8S4HAzG55jr612w9q6vphtWVh28uM8Ll1fdwi","vpswxujLmyZYOUKa08EUC3GdZprN0VrVD8ICWVTP");

    }
}
