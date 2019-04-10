package edd.ecosdedestruccion.calculadorabsica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Variables para los componentes
    private EditText num1, num2;
    private RadioButton opc1, opc2, opc3, opc4;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Instaciamos lod componenetes del View
        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        opc1 = (RadioButton) findViewById(R.id.opc1);
        opc2 = (RadioButton) findViewById(R.id.opc2);
        opc3 = (RadioButton) findViewById(R.id.opc3);
        opc4 = (RadioButton) findViewById(R.id.opc4);
        resultado = (TextView) findViewById(R.id.txtResul);


    }

    public void calcular (View view){

        //Preparación de los datos
        String n1s = num1.getText().toString();
        int n1 = Integer.parseInt(n1s);
        String n2s = num2.getText().toString();
        int n2 = Integer.parseInt(n2s);

        //Zona de calculo
        if(opc1.isChecked()) {
            int suma = n1 + n2;
            String resul = String.valueOf(suma);
            resultado.setText(resul);
        } else if(opc2.isChecked()){
            int resta = n1 - n2;
            String result = String.valueOf(resta);
            resultado.setText(result);
        } else if (opc3.isChecked()){
            int multi = n1 * n2;
            String result = String.valueOf(multi);
            resultado.setText(result);
        } else if(opc4.isChecked()){
            try{
                int divi = n1 / n2;
                String result = String.valueOf(divi);
                resultado.setText(result);
            } catch (ArithmeticException e){
                Toast.makeText(this, "División imposible", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "Fallo en la operación", Toast.LENGTH_SHORT).show();
        }
    }
}
