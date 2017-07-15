import java.util.*;


import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Scraper {

	
	public static void main (String [] args)
	{
		String url = "http://www.sportsbettingonline.ag/sportsbook/betting-lines/main_mlb.php?id_league=782&league=MLB";
		Document doc = null;
		try {
			 doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements teamNames = doc.select(".team_name_odds");
		Elements homeSpread = doc.select("#home_spread");
		Elements homeMoney = doc.select("#home_money");
		Elements homeTotal = doc.select("#home_total");
		Elements awaySpread = doc.select("#away_spread");
		Elements awayMoney = doc.select("#away_money");
		Elements awayTotal = doc.select("#away_total");
		
		ArrayList<String> teams = new ArrayList<String>();
		ArrayList<String> homeSpreads = new ArrayList<String>();
		ArrayList<String> homeMoneyLines = new ArrayList<String>();
		ArrayList<String> homeTotals = new ArrayList<String>();
		ArrayList<String> awaySpreads = new ArrayList<String>();
		ArrayList<String> awayMoneyLines = new ArrayList<String>();
		ArrayList<String> awayTotals = new ArrayList<String>();

		for(Element e : teamNames)
		{
			teams.add(e.text());
		}
		for(Element e : homeSpread)
		{
			homeSpreads.add(e.text());
		}
		for(Element e : homeMoney)
		{
			homeMoneyLines.add(e.text());
		}
		for(Element e : homeTotal)
		{
			homeTotals.add(e.text());
		}
		for(Element e : awaySpread)
		{
			awaySpreads.add(e.text());
		}
		for(Element e : awayMoney)
		{
			awayMoneyLines.add(e.text());
		}
		for(Element e : awayTotal)
		{
			awayTotals.add(e.text());
		}
		
		
		for(int i=0; i<teams.size();i++)
		{
			if(i%2==0)
			{
				System.out.println("Away Team: "+teams.get(i) + "     "+awaySpreads.get(i/2)+ "   "+awayMoneyLines.get(i/2)+"     "+awayTotals.get(i/2));
			}
			else
			{
				System.out.println("Home Team: "+teams.get(i) + "     "+homeSpreads.get(i/2)+ "   "+homeMoneyLines.get(i/2)+"     "+homeTotals.get(i/2));
				System.out.println("");
			}
		}
	}
}
