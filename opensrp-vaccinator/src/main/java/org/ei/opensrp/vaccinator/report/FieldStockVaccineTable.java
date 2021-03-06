package org.ei.opensrp.vaccinator.report;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.ei.opensrp.commonregistry.CommonPersonObject;
import org.ei.opensrp.util.Log;
import org.ei.opensrp.vaccinator.R;
import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class FieldStockVaccineTable extends Fragment {

   private CommonPersonObject fieldObject;
    CommonPersonObject childObject;
    CommonPersonObject womanObject;
    public FieldStockVaccineTable(CommonPersonObject fieldObject,CommonPersonObject childObject,CommonPersonObject womanObject) {
        this.fieldObject=fieldObject;
        this.childObject=childObject;
        this.womanObject=womanObject;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView =inflater.inflate(R.layout.fragment_field_stock_vaccine_table2, container, false);
       // View rootView = inflater.inflate(R.layout.fragment_child_vaccine_table, container, false);
        TextView bcgBalanceTextView=(TextView)rootView.findViewById(R.id.field_table_bcgbalance);
        TextView bcgReceivedTextView=(TextView)rootView.findViewById(R.id.field_table_bcgreceived);
        TextView bcgUsedTextView=(TextView)rootView.findViewById(R.id.field_table_bcgused);
        TextView bcgWastedTextView=(TextView)rootView.findViewById(R.id.field_table_bcgwasted);
        bcgBalanceTextView.setText(fieldObject.getDetails().get("bcg_balance_in_hand")!=null?fieldObject.getDetails().get("bcg_balance_in_hand"):"N/A");
        bcgReceivedTextView.setText(fieldObject.getDetails().get("bcg_received")!=null?fieldObject.getDetails().get("bcg_received"):"N/A");
        bcgUsedTextView.setText(childObject.getColumnmaps().get("bcg"));


        TextView opvBalanceTextView=(TextView)rootView.findViewById(R.id.field_table_opvbalance);
        TextView opvReceivedTextView=(TextView)rootView.findViewById(R.id.field_table_opvreceived);
        TextView opvUsedTextView=(TextView)rootView.findViewById(R.id.field_table_opvused);
        TextView opvWastedTextView=(TextView)rootView.findViewById(R.id.field_table_opvwasted);
        opvBalanceTextView.setText(fieldObject.getDetails().get("opv_balance_in_hand")!=null?fieldObject.getDetails().get("opv_balance_in_hand"):"N/A");
        opvReceivedTextView.setText(fieldObject.getDetails().get("opv_received")!=null?fieldObject.getDetails().get("opv_received"):"N/A");

        int opv0=Integer.parseInt(childObject.getColumnmaps().get("opv_0")!=null?childObject.getColumnmaps().get("opv_0"):"0");
        int opv1=Integer.parseInt(childObject.getColumnmaps().get("opv_1")!=null?childObject.getColumnmaps().get("opv_1"):"0");
        int opv2=Integer.parseInt(childObject.getColumnmaps().get("opv_2")!=null?childObject.getColumnmaps().get("opv_2"):"0");
        int opv3=Integer.parseInt(childObject.getColumnmaps().get("opv_3")!=null?childObject.getColumnmaps().get("opv_3"):"0");

        int opvUsed=opv0+opv1+opv2+opv3;//Integer.parseInt(usedVaccines.get("opv_0")!=null?usedVaccines.get("opv_0"):"0")+Integer.parseInt(usedVaccines.get("opv_1")!=null?usedVaccines.get("opv_1"):"0")+Integer.parseInt(usedVaccines.get("opv_2)"!=null?usedVaccines.get("opv_2"):"0"));

        opvUsedTextView.setText(opvUsed+"");

        TextView pentaBalanceTextView=(TextView)rootView.findViewById(R.id.field_table_pentabalance);
        TextView pentaReceivedTextView=(TextView)rootView.findViewById(R.id.field_table_pentareceived);
        TextView pentaUsedTextView=(TextView)rootView.findViewById(R.id.field_table_pentaused);
        TextView pentaWastedTextView=(TextView)rootView.findViewById(R.id.field_table_pentawasted);

        pentaBalanceTextView.setText(fieldObject.getDetails().get("penta_balance_in_hand")!=null?fieldObject.getDetails().get("penta_balance_in_hand"):"N/A");
        pentaReceivedTextView.setText(fieldObject.getDetails().get("penta_received")!=null?fieldObject.getDetails().get("penta_received"):"N/A");
        int pentaUsed= Integer.parseInt(childObject.getColumnmaps().get("pentavalent_1")!=null?childObject.getColumnmaps().get("pentavalent_1"):"0")+Integer.parseInt(childObject.getColumnmaps().get("pentavalent_2")!=null?childObject.getColumnmaps().get("pentavalent_2"):"0")+Integer.parseInt(childObject.getColumnmaps().get("pentavalent_3")!=null?childObject.getColumnmaps().get("pentavalent_3"):"0");

        pentaUsedTextView.setText(pentaUsed+"");


        TextView pcvBalanceTextView=(TextView)rootView.findViewById(R.id.field_table_pcvbalance);
        TextView pcvReceivedTextView=(TextView)rootView.findViewById(R.id.field_table_pcvreceived);
        TextView pcvUsedTextView=(TextView)rootView.findViewById(R.id.field_table_pcvused);
        TextView pcvWastedTextView=(TextView)rootView.findViewById(R.id.field_table_pcvwasted);
        pcvBalanceTextView.setText(fieldObject.getDetails().get("pcv_balance_in_hand")!=null?fieldObject.getDetails().get("pcv_balance_in_hand"):"N/A");
        pcvReceivedTextView.setText(fieldObject.getDetails().get("pcv_received")!=null?fieldObject.getDetails().get("pcv_received"):"N/A");
       int pcv1=Integer.parseInt(childObject.getColumnmaps().get("pcv_1")!=null?childObject.getColumnmaps().get("pcv_1"):"0");
       int pcv2=Integer.parseInt(childObject.getColumnmaps().get("pcv_2")!=null?childObject.getColumnmaps().get("pcv_2"):"0");
        int pcv3=Integer.parseInt(childObject.getColumnmaps().get("pcv_3")!=null?childObject.getColumnmaps().get("pcv_3"):"0");
        int pcvUsed= pcv1+pcv2+pcv3;
        pcvUsedTextView.setText(pcvUsed+"");


        TextView measlesBalanceTextView=(TextView)rootView.findViewById(R.id.field_table_measlesbalance);
        TextView measlesReceivedTextView=(TextView)rootView.findViewById(R.id.field_table_measlesreceived);
        TextView measlesUsedTextView=(TextView)rootView.findViewById(R.id.field_table_measlesused);
        TextView measlesWastedTextView=(TextView)rootView.findViewById(R.id.field_table_measleswasted);
        measlesBalanceTextView.setText(fieldObject.getDetails().get("measles_balance_in_hand")!=null?fieldObject.getDetails().get("measles_balance_in_hand"):"N/A");
        measlesReceivedTextView.setText(fieldObject.getDetails().get("measles_received")!=null?fieldObject.getDetails().get("measles_received"):"N/A");

        int measlesUsed= Integer.parseInt(childObject.getColumnmaps().get("measles_1")!=null?childObject.getColumnmaps().get("measles_1"):"0")+Integer.parseInt(childObject.getColumnmaps().get("measles_2")!=null?childObject.getColumnmaps().get("measles_2"):"0");
        measlesUsedTextView.setText(measlesUsed+"");

        TextView ttBalanceTextView=(TextView)rootView.findViewById(R.id.field_table_ttbalance);
        TextView ttReceivedTextView=(TextView)rootView.findViewById(R.id.field_table_ttreceived);
        TextView ttUsedTextView=(TextView)rootView.findViewById(R.id.field_table_ttused);
        TextView ttWastedTextView=(TextView)rootView.findViewById(R.id.field_table_ttwasted);
        ttBalanceTextView.setText(fieldObject.getDetails().get("tt_balance_in_hand")!=null?fieldObject.getDetails().get("tt_balance_in_hand"):"N/A");
        ttReceivedTextView.setText(fieldObject.getDetails().get("tt_received")!=null?fieldObject.getDetails().get("tt_received"):"N/A");


        int tt1=Integer.parseInt(womanObject.getColumnmaps().get("tt1")!=null?womanObject.getColumnmaps().get("tt1"):"0");
        int tt2=Integer.parseInt(womanObject.getColumnmaps().get("tt2")!=null?womanObject.getColumnmaps().get("tt2"):"0");
        int tt3=Integer.parseInt(womanObject.getColumnmaps().get("tt3")!=null?womanObject.getColumnmaps().get("tt3"):"0");
        int tt4=Integer.parseInt(womanObject.getColumnmaps().get("tt4")!=null?womanObject.getColumnmaps().get("tt4"):"0");
        int tt5=Integer.parseInt(womanObject.getColumnmaps().get("tt5")!=null?womanObject.getColumnmaps().get("tt5"):"0");
        int ttUsed=tt1+tt2+tt3+tt4+tt5;
        ttUsedTextView.setText(ttUsed+"");

        // Inflate the layout for this fragment
        return rootView;//inflater.inflate(R.layout.fragment_field_stock_vaccine_table2, container, false);
    }


}
