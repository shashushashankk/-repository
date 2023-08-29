
package bussiness_Logic;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import io.appium.java_client.android.AndroidDriver;

import org.springframework.stereotype.Component;

@Component("LIC11107_PJT1001_PE_NLP6dd64a32-111c-4dca-8438-8365fc85a7ec")
public class MOB_TapOnElementUsingCoordinates implements Nlp {
	@InputParams({ @InputParam(name = "element", type = "org.openqa.selenium.WebElement"),
			@InputParam(name = "X Cord", type = "java.lang.Integer"),
			@InputParam(name = "Y Cord", type = "java.lang.Integer") })
//    @ReturnType(name = "string3", type = "java.lang.String")

	@Override
	public List<String> getTestParameters() throws NlpException {
		List<String> params = new ArrayList<>();
		return params;
	}

	@Override
	public StringBuilder getTestCode() throws NlpException {
		StringBuilder sb = new StringBuilder();
		return sb;
	}

	@Override
	public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {

		NlpResponseModel nlpResponseModel = new NlpResponseModel();
		Map<String, Object> attributes = nlpRequestModel.getAttributes();

		try {
			WebElement xpat = (WebElement) attributes.get("element");
			Integer x = (Integer) attributes.get("X Cord");
			Integer y = (Integer) attributes.get("Y Cord");
			System.setProperty("java.awt.headless", "false");
			AndroidDriver driver = (AndroidDriver) nlpRequestModel.getDriver().getSpecificIDriver();
			Point point = xpat.getLocation();
			int xcord = (point.getX() + x);
			int ycord = (point.getY() + y);
			PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence tap = new Sequence(input, 0);
			tap.addAction(
					input.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), xcord, ycord));
			tap.addAction(input.createPointerDown(0));
			tap.addAction(input.createPointerUp(0));
			driver.perform(Arrays.asList(tap));
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Tapped on the Element successfully " + x + " " + y);
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to Click on the Element " + e);
		}

		return nlpResponseModel;
	}
}