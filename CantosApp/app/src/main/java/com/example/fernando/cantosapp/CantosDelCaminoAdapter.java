package com.example.fernando.cantosapp;

/**
 * Created by Fernando on 17/07/2016.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 05-21-16.
 */
public class CantosDelCaminoAdapter extends ArrayAdapter<CantosDelCamino> {

    Context myContext;
    int myLayoutResource;
    List<CantosDelCamino> myData;
    List<CantosDelCamino> originData;
    Filter filtroIndice;

    public  CantosDelCaminoAdapter(Context context, int layoutResourceID, List<CantosDelCamino> data)
    {
        super(context, layoutResourceID, data);

        this.myContext = context;
        this.myLayoutResource = layoutResourceID;
        this.originData = data;
        this.myData = data;
    }

    public int getCount(){ return myData.size();}
    public CantosDelCamino getItem(int position){return myData.get(position);}
    public long getItemId(int position){return myData.get(position).hashCode();}


    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row = convertView;

        CantosDelCaminoHolder holder = new CantosDelCaminoHolder();

        if(row == null)
        {
            LayoutInflater inflater = (LayoutInflater)myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(myLayoutResource, parent, false);

            holder = new CantosDelCaminoHolder();
            holder.numero = (TextView)row.findViewById(R.id.numeroCanto);
            holder.nombre = (TextView)row.findViewById(R.id.nombreCanto);

            row.setTag(holder);

        }
        else
        {
            holder = (CantosDelCaminoHolder)row.getTag();
        }

        CantosDelCamino cantosEHimnosEspirituales = myData.get(position);

        holder.numero.setText(cantosEHimnosEspirituales.numero);
        holder.nombre.setText(cantosEHimnosEspirituales.nombre);

        return row;
    }

    public void resetData(){myData = originData;}

    static class CantosDelCaminoHolder{
        TextView numero;
        TextView nombre;
    }

    public Filter getFilter() {
        if (filtroIndice == null)
            filtroIndice = new FiltroIndice();

        return filtroIndice;
    }

    private class FiltroIndice extends Filter{
        protected FilterResults performFiltering(CharSequence constraint)
        {
            FilterResults results = new FilterResults();

            if(constraint == null || constraint.length() == 0)
            {
                results.values = originData;
                results.count = originData.size();
            }
            else
            {
                List<CantosDelCamino> nCantos = new ArrayList<CantosDelCamino>();

                String datoARecorrer = constraint.toString().trim();
                boolean esNumero = false;

                for(int i = 0;i < datoARecorrer.length(); i++) {
                    if (!Character.isDigit(constraint.charAt(i))) {
                        esNumero = false;
                    }
                    else
                        esNumero = true;
                }

                if(!esNumero)
                {
                    for (CantosDelCamino p : myData) {
                        if (p.getName().toUpperCase().startsWith(constraint.toString().toUpperCase()))
                            nCantos.add(p);
                        else if (p.getName().toUpperCase().contains(constraint.toString().toUpperCase()))
                            nCantos.add(p);
                    }

                    results.values = nCantos;
                    results.count = nCantos.size();
                } else {
                    for (CantosDelCamino p : myData) {
                        if (p.getNumero().toUpperCase().startsWith(constraint.toString().toUpperCase()))
                            nCantos.add(p);
                        else if (p.getNumero().toUpperCase().contains(constraint.toString().toUpperCase()))
                            nCantos.add(p);
                    }

                    results.values = nCantos;
                    results.count = nCantos.size();
                }

            }

            return results;
        }

        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {

            // Now we have to inform the adapter about the new list filtered
            if (results.count == 0)
                notifyDataSetInvalidated();
            else {
                myData = (List<CantosDelCamino>) results.values;
                notifyDataSetChanged();
            }

        }

    }

}
