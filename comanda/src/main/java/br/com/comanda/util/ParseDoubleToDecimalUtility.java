/**
 * 
 */
package br.com.comanda.util;

import java.text.DecimalFormat;

/**
 * @author Bruno Fernando Yamada
 * 21 de nov de 2017
 *	
 */
public class ParseDoubleToDecimalUtility {
	
	public Double parseToDecimalFormat(Double precoDouble) {
		
		DecimalFormat fmt = new DecimalFormat("0.00");
		String string = fmt.format(precoDouble);
		String[] part = string.split("[,]");
		String string2 = part[0]+"."+part[1];
		double preco = Double.parseDouble(string2);
		return preco;
		
	}

}
