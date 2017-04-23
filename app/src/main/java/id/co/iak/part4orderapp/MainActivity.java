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
    private TextView txtSummary;

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
        cbToppingWhippedCream = (CheckBox) findViewById(R.id.cb_whippedcream);
        btnIncrement = (Button) findViewById(R.id.btn_add);
        btnDecrement = (Button) findViewById(R.id.btn_substract);
        btnOrder = (Button) findViewById(R.id.btn_order);
        txtSummary = (TextView) findViewById(R.id.txt_summary);

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
     * @param v to bind the views from onclick event
     */
    public void submitOrder(View v) {
        createOrderSummary(edtName.getText().toString(), quantity, calculatePrice());
//        createOrderSummary("Nama Lengkap", quantity, calculatePrice(quantity));
    }

    private int calculatePrice(int qty) {
        return qty * 5;
    }

    private int calculatePrice(int qty, int initPrice) {
        return qty * initPrice;
    }

    private int calculatePrice() {
        return quantity * 5;
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
     * This method displays order summary
     *
     * @param name     user defined name
     * @param quantity of ordered coffee
     * @param price    of total coffee ordered
     */
    private void createOrderSummary(String name, int quantity, int price) {
        txtSummary.setText("Name: " + name +
                "\nQuantity: " + quantity +
                "\nTotal: $" + price +
                "\nThank You!");
//        if (cbToppingWhippedCream.isChecked()) {
//            txtTopping.setText("Topping: Whipped Cream");
//        } else
//        {
//            txtTopping.setText("Topping: ");
//        }

    }
}