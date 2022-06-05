package com.algorithms.demo.gof.adapter.csvadapter;

import com.algorithms.demo.gof.adapter.adaptee.CsvFormattable;
import com.algorithms.demo.gof.adapter.source.TextFormattable;

public class CsvAdapterImpl implements TextFormattable {
    CsvFormattable csvFormatter;
    public CsvAdapterImpl(CsvFormattable csvFormatter){
        this.csvFormatter=csvFormatter;
    }
    @Override
    public String formatText(String text)
    {
        String formattedText=csvFormatter.formatCsvText(text);
        return formattedText;
    }
}
