package com.example.javarecyclerview;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;

import androidx.appcompat.app.AlertDialog;

import com.example.javarecyclerview.databinding.WeightPickerDialogBinding;

public class WeightPicker {

    /**
     * There are 9 TODOs in this file, locate them using the window for it given at the bottom.
     * Also, complete them in order.
     *
     *  Design layout weight_picker_dialog.xml for this WeightPicker Dialog
     *          with 2 NumberPickers (for kg & g)
     */

    public void show(Context context, final OnWeightPickedListener listener){
        WeightPickerDialogBinding b = WeightPickerDialogBinding.inflate(
                LayoutInflater.from(context)
        );

        new AlertDialog.Builder(context)
                .setTitle("Pick Weight")
                .setView(b.getRoot())
                .setPositiveButton("SELECT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Replace 0s & assign kg & g values from respective NumberPickers
//                        int kg = 0, g = 0;
                        int kg = b.numberPickerKg.getValue();
                        int g = b.numberPickerG.getValue();

                        // Add GuardCode to prevent user from selecting 0kg 0g. If so, then return
                        if(kg == 0 && g == 0) {
                            return;
                        }

                        listener.onWeightPicked(kg, g);
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listener.onWeightPickerCancelled();
                    }
                })
                .show();

        setupNumberPickers(b.numberPickerKg, b.numberPickerG);

        // Call new WeightPicker().show() in MainActivity and pass (this, new OnWeight...)

        // Show toast of selected weight in onWeightPicked() method

        // Find appropriate solution for : NumberPicker not formatting the first item

        // Test your code :)

        // Try to understand the flow as to how our Listener interface is working
    }

    private void setupNumberPickers(NumberPicker numberPickerKg, NumberPicker numberPickerG) {
        // Define this method to setup kg & g NumberPickers as per the given ranges
        //kg Range - 0kg to 10kg
        //g Range - 0g to 950g
        numberPickerKg.setMinValue(0);
        numberPickerKg.setMaxValue(10);
        numberPickerG.setMinValue(0);
        numberPickerG.setMaxValue(19);

        numberPickerKg.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return value + " " + "kg";
            }
        });

        numberPickerG.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return (value * 50) + " " + "g";
            }
        });

        View firstItemKg = numberPickerKg.getChildAt(0);
        if (firstItemKg != null) {
            firstItemKg.setVisibility(View.INVISIBLE);
        }

        View firstItemG = numberPickerG.getChildAt(0);
        if (firstItemG != null) {
            firstItemG.setVisibility(View.INVISIBLE);
        }

    }

    interface OnWeightPickedListener{
        void onWeightPicked(int kg, int g);
        void onWeightPickerCancelled();
    }

}
