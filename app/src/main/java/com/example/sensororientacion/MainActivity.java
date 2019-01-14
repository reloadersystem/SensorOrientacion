package com.example.sensororientacion;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
TextView x,y,z;
Sensor magnetometro,giroscopio;
SensorManager sm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x=(TextView)findViewById(R.id.x);
        y=(TextView)findViewById(R.id.y);
        z=(TextView)findViewById(R.id.z);

        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        magnetometro=sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        giroscopio=sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sm.registerListener(this,magnetometro,SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(this,giroscopio,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
       /* x.setText(String.valueOf(event.values[0]));
        y.setText(String.valueOf(event.values[1]));
        z.setText(String.valueOf(event.values[2]));*/
       // 2  sensores en 1
        switch (event.sensor.getType())
        {
            case Sensor.TYPE_MAGNETIC_FIELD:
                x.setText(String.valueOf(event.values[0]));
                y.setText(String.valueOf(event.values[1]));
                z.setText(String.valueOf(event.values[2]));
                break;

            case Sensor.TYPE_GYROSCOPE:
                x.setText(String.valueOf(event.values[0]));
                y.setText(String.valueOf(event.values[1]));
                z.setText(String.valueOf(event.values[2]));
                break;

            default:
                break;
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
