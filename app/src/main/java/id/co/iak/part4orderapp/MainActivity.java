package id.co.iak.part4orderapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Views
    private EditText edtName;
    private TextView txtQuantity;
    private CheckBox cbToppingWhippedCream;
    private Button btnIncrement;
    private Button btnDecrement;
    private Button btnOrder;

    // Output
    private TextView txtName;
    private TextView txtTopping;
    private TextView txtPrice;

    // Data
    private String topping = "";
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
        edtName = (EditText) findViewById(R.id.edt_name);
        txtQuantity = (TextView) findViewById(R.id.txt_quantity);
        btnIncrement = (Button) findViewById(R.id.btn_add);
        btnDecrement = (Button) findViewById(R.id.btn_substract);
        btnOrder = (Button) findViewById(R.id.btn_order);
        txtName = (TextView) findViewById(R.id.txt_name);
        txtTopping = (TextView) findViewById(R.id.txt_topping);
        txtPrice = (TextView) findViewById(R.id.txt_price);

        displayQuantity(quantity);
    }

    /**
     * This method increment the Quantity text
     *
     * @param v is to binding the views
     */
    public void increment(View v) {
        quantity++;
        displayQuantity(quantity);
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
        displayQuantity(quantity);
    }

    /**
     * This method will count the price
     */
    public void submitOrder(View v) {
        display(calculatePrice(quantity));
    }

    private int calculatePrice(int quantity) {
        return quantity * 10;
    }

    /**
     * This method display the output messages
     *
     * @param quantity the string to output
     */
    private void displayQuantity(int quantity) {
        txtQuantity.setText("" + quantity);
    }

    /**
     * This method display the output messages
     *
     * @param price the string to output
     */
    private void display(int price) {
        txtName.setText("Name: " + edtName.getText().toString());
   if (cbToppingWhippedCream.isChecked()) txtTopping.setText("Whipped Cream");     txtPrice.setText("Total: $" + price);
    }
}