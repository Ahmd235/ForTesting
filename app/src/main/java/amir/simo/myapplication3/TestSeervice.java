package amir.simo.myapplication3;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class TestSeervice extends Service {
    public TestSeervice() {
    }


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        try {

                Thread.sleep(10000);
                Toast.makeText(this, "Helllo from Service", Toast.LENGTH_SHORT).show();
                Intent it=new Intent(this,MainActivity3.class);
                    it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(it);

        } catch (Exception e) {

        }

        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}