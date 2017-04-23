package id.co.iak.part4orderapp;

import android.content.Intent;
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
    private CheckBox cbTopWcream;
    private CheckBox cbTopChoco;
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
        cbTopWcream = (CheckBox) findViewById(R.id.cb_wc);
        cbTopChoco = (CheckBox) findViewById(R.id.cb_cho);
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
     *
     * @param v to bind the views from onclick event
     */
    public void submitOrder(View v) {
        txtSummary.setText(createOrderSummary(edtName.getText().toString(),
                quantity, calculatePrice()));
//        createOrderSummary("Nama Lengkap", quantity, calculatePrice(quantity));
        Intent send = new Intent();
        send.setAction(Intent.ACTION_SEND);
        send.putExtra(Intent.EXTRA_TEXT, createOrderSummary(edtName.getText().toString(),
                quantity, calculatePrice()));
        send.setType("text/plain");

        if (send.resolveActivity(getPackageManager()) != null) {
            startActivity(send);
        }
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
     * @return summary of order
     */
    private String createOrderSummary(String name, int quantity, int price) {
        return "Name: " + name +
                "\nAdd whipped cream? " + isWhippedCreamChecked() +
                "\nAdd chocolate? " + isChocolateChecked() +
                "\nQuantity: " + quantity +
                "\nTotal: $" + price +
                "\nThank You!";
    }

    /**
     * This method will check
     * for whipped cream topping state
     *
     * @return true if checked
     */
    private boolean isWhippedCreamChecked() {
        return cbTopWcream.isChecked();
    }

    /**
     * This method will check
     * for chocolate topping state
     *
     * @return true if checked
     */
    private boolean isChocolateChecked() {
        return cbTopChoco.isChecked();
    }
}