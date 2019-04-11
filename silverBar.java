//=========================================================================
//	silverBar.java	v1.0	Authour - Dave Ratcliffe
//
//	Main method is displaySummary where an array of silverBarVO is expected
//	This is then split by order type, then sorted and the summary displayed.
//	I used an array instead of a collection as the sort seemed simpler and
//	arrays are faster.

package CreditSuisse;

import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;
import java.sql.Timestamp;
import java.time.*;

import CreditSuisse.silverBarVO;

public class silverBar
{

	//==============================================
	public silverBarVO[] getBuyOrSell(silverBarVO[] sb, String bors){

		if (sb.length == 0) return null;

		int i = 0;
		List<silverBarVO> sbl = new ArrayList<silverBarVO>();
		while (i < sb.length){
			//System.out.println("sbl="+sb.length+" i="+i+" ot="+sb[i].getUserId());
			if (sb[i].getOrderType().equals(bors)) sbl.add(sb[i]);
			i++;
		}
		if (sbl.size()==0) return null;
		silverBarVO[] svo = new silverBarVO[sbl.size()];
		svo = sbl.toArray(svo);
		return svo;
	}

	//==============================================
	public silverBarVO[] sortBuyOrSell(silverBarVO[] sb, int ord){

		Arrays.sort(sb, new Comparator<silverBarVO>() {
			@Override
			public int compare(silverBarVO sb1, silverBarVO sb2) {
				if (sb1.getPriceperkg() > sb2.getPriceperkg()){	
					return ord;				
				}else{
					return ord*-1;
				}
			}
		});
		return sb;
	}
	//==============================================
	public void outputSummary(silverBarVO[] sb, String str){

		float ppk = 0.0f;
		float quant = 0.0f;

		System.out.println("Summary of "+str);
		for (int i = 0; i < sb.length; i++){
			quant += sb[i].getQuantity();
			ppk = sb[i].getPriceperkg();
			if ((i + 1) < sb.length && sb[i].getPriceperkg() != sb[i+1].getPriceperkg()){ 
				System.out.println(quant+" for £"+ppk);
				quant = 0.0f;
			}
		}
		System.out.println(quant+" for £"+ppk);
	}
	//==============================================
	public void displaySummary(silverBarVO[] sb){

		if (sb == null) return;

		silverBar sbar = new silverBar();
		//split array into order types BUY and SELL
		silverBarVO[] buy = sbar.getBuyOrSell(sb,"BUY");
		silverBarVO[] sell = sbar.getBuyOrSell(sb,"SELL");

		//sort array price per kg
		silverBarVO[] sortbuy = buy;
		silverBarVO[] sortsell = sell;
		if (buy != null) sortbuy = sbar.sortBuyOrSell(buy,-1);
		if (sell != null) sortsell = sbar.sortBuyOrSell(sell,1);

		if (buy != null) sbar.outputSummary(sortbuy,"BUY");
		if (sell != null) sbar.outputSummary(sortsell,"SELL");
	}
}
