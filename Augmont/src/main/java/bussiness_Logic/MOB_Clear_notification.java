package bussiness_Logic;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("LIC11107_PJT1001_PE_NLP5ccd25a5-a7c9-4895-9262-426c7a29b220")
public class MOB_Clear_notification implements Nlp {
	@InputParams({ @InputParam(name = "locatorValue", type = "java.lang.String") })

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
		String loctorValue = (String) attributes.get("locatorValue");

		try {

			log.info("Entered Try Block");
			AndroidDriver driver = (AndroidDriver) nlpRequestModel.getDriver().getSpecificIDriver();

			if (driver.findElement(By.xpath(loctorValue)).isEnabled()) {
				log.info("Entered into If condition");
				driver.findElement(By.xpath(loctorValue)).click();
				nlpResponseModel.setStatus(CommonConstants.pass);
				nlpResponseModel.setMessage("Successfully cleared  notification ");
			} else {
				log.info("Entered into else condition");
				driver.navigate().back();
				nlpResponseModel.setStatus(CommonConstants.pass);
				nlpResponseModel.setMessage("Notification is not present at the movement");
			}

		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to clear notification");
		}
		return nlpResponseModel;
	}
}
