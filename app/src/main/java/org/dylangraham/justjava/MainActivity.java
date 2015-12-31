package org.dylangraham.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    protected static int quantity = 0;
    protected static int cost = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        updateScreen();
    }

    /**
     * Increment the quantity on button click
     */
    public void increment(View view) {
        quantity += 1;
        updateScreen();
    }

    /**
     * Decrement the quantity on button click
     */
    public void decrement(View view) {
        if (quantity > 0) {
            quantity -= 1;
            updateScreen();
        }
    }

    /**
     * Update screen
     */
    public void updateScreen() {
        display(quantity);
        displayPrice(cost * quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        String total;
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        total = "Total: " + NumberFormat.getCurrencyInstance().format(number);
        priceTextView.setText(total);
    }

}