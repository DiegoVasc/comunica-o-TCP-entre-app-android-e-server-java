package com.example.sockets;

import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    TextView x,y,z;
    float v1,v2,v3;
    private SensorManager sensorManager;
    public Sensor mAccelerometer;
    List<Sensor> sensors = new ArrayList<>();
    ArrayList<Float> valores = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x = (TextView) findViewById(R.id.xID);
        y = (TextView) findViewById(R.id.yID);
        z = (TextView) findViewById(R.id.zID);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }


    public void onResume(View v){
        super.onResume();
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensors = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (sensors.size() > 0){
            sensorManager.registerListener(this,sensors.get(0),SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    public void onPause(View v){
        sensorManager.unregisterListener(this);



        this.x.setText("X: 0.00000");
        this.y.setText("Y: 0.00000");
        this.z.setText("Z: 0.00000");

        //valores.clear();

        super.onPause();

    }

    public void enviar_dados(View v){

        BackgroundTask bl = new BackgroundTask();
            bl.execute(valores);
            //valores.clear();


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
            this.x.setText("X: " + event.values[SensorManager.DATA_X]);
            this.y.setText("Y: " + event.values[SensorManager.DATA_Y]);
            this.z.setText("Z: " + event.values[SensorManager.DATA_Z]);

        v1 = event.values[SensorManager.DATA_X];
        v2 = event.values[SensorManager.DATA_Y];
        v3 = event.values[SensorManager.DATA_Z];

        valores.add(v1);
        valores.add(v2);
        valores.add(v3);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    class BackgroundTask extends AsyncTask<ArrayList,Void,Void>{
        PrintWriter writer;
        Socket s;


        @Override
        protected Void doInBackground(ArrayList... voids) {
            try {
                //String mensagem = voids[0];
                s = new Socket("192.168.11.4",6000);
                writer = new PrintWriter(s.getOutputStream());
                for (int i = 0; i < valores.size(); i++){
                    Float mensagem = valores.get(i);
                    writer.write(String.valueOf(mensagem + " "));
                }

                writer.flush();
                writer.close();
                valores.clear();

            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }

    }
}
