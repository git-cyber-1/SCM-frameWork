package task;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webDriverUtility.WebDriverUtility;
import com.comcast.task.ObjectRepository.CrickBuzzHomePage;
import com.comcast.task.ObjectRepository.LiveCricketScorePage;
import com.comcast.task.ObjectRepository.ScoreTablePage;
import com.mysql.cj.jdbc.Driver;

public class Cricbuzz {

	@Test
	public void cricbuzz() throws IOException, SQLException {

		FileUtility flib = new FileUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		String BROWSER = flib.getdatafromproperties("browser");

		WebDriver driver = null;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		}

		driver.get("https://www.cricbuzz.com/");
		wlib.waitForPageToLoad(driver);
		wlib.maximizePage(driver);

		CrickBuzzHomePage chp = new CrickBuzzHomePage(driver);
		chp.getMatches().click();

		LiveCricketScorePage lcsp = new LiveCricketScorePage(driver);
		lcsp.getRecent().click();
		lcsp.getScoretable().click();

		ScoreTablePage stp = new ScoreTablePage(driver);
		List<WebElement> Runs = stp.getRuns();
		List<WebElement> Batters = stp.getBatters();
		List<WebElement> StrikeRate = stp.getStrikeRate();

		Iterator<WebElement> runs = Runs.iterator();
		Iterator<WebElement> batters = Batters.iterator();
		Iterator<WebElement> strikerate = StrikeRate.iterator();

		Driver dref = new Driver();
		DriverManager.registerDriver(dref);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/task", "root", "root");
		while (runs.hasNext() || batters.hasNext() || strikerate.hasNext()) {
			String r1 = runs.next().getText();
			int run = Integer.parseInt(r1);
			String batter = batters.next().getText();
			String sr1 = strikerate.next().getText();
			double sr = Double.parseDouble(sr1);

			if (run <= 30) {
				Statement stat = conn.createStatement();
				stat.executeUpdate("insert into cricbuzz(player_name,Runs,Strike_Rate) values ('" + batter + "','" + run
						+ "','" + sr + "');");
			}
		}
		Statement stat = conn.createStatement();
		ResultSet result = stat.executeQuery("select * from cricbuzz");
		System.out.println();
		System.out.println();
		System.out.println("player details having more than 10 runs");
		int prun = 0, psr = 0;
		String batsman = null;
		while (result.next()) {
			batsman = result.getString(1);
			prun = result.getInt(2);
			psr = result.getInt(3);

			if (prun >= 10) {
				System.out.println(batsman + ":" + prun + ":" + psr);
			}
		}
	     driver.quit();
	}
	
}
