package id.co.iak.part4orderapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Views
    private TextView txtQuantity;
    private Button btnIncrement;
    private Button btnDecrement;
    private Button btnOrder;
    private TextView txtPrice;

    // Data
    private int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    /**
     * This method initiate the views
     */
    private void initView() {
        txtQuantity = (TextView) findViewById(R.id.txt_quantity);
        btnIncrement = (Button) findViewById(R.id.btn_add);
        btnDecrement = (Button) findViewById(R.id.btn_substract);
        btnOrder = (Button) findViewById(R.id.btn_order);
        txtPrice = (TextView) findViewById(R.id.txt_price);

        display(Integer.toString(quantity));
    }

    /**
     * This method increment the Quantity text
     *
     * @param v is to binding the views
     */
    public void increment(View v) {
        quantity++;
        display(Integer.toString(quantity));
    }

    /**
     * This method decrement the Quantity text
     *
     * @param v is to binding the views
     */
    public void decrement(View v) {
        quantity--;
        if (quantity < 0) {
            quantity = 0;
        }
        display(Integer.toString(quantity));
    }

    /**
     * This method will count the price
     */
    public void submitOrder(View v) {
        int totalPrice = quantity * 10;
        display(totalPrice);
    }

    /**
     * This method display the output messages
     *
     * @param quantity the string to output
     */
    private void display(String quantity) {
        txtQuantity.setText(quantity);
    }

    /**
     * This method display the output messages
     *
     * @param price the string to output
     */
    private void display(int price) {
        txtPrice.setText("Total: $" + price);
    }
}
