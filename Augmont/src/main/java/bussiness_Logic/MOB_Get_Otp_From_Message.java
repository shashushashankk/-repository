
package bussiness_Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import org.springframework.stereotype.Component;

@Component("LIC11107_PJT1001_PE_NLP3a370bac-b3e3-4b9e-94ac-2d9c9bd2d9c7")
public class MOB_Get_Otp_From_Message implements Nlp {
	@InputParams({ @InputParam(name = "Message", type = "java.lang.String") })
	@ReturnType(name = "actMsg", type = "java.lang.String")

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
		String actMsg = "";
		try {
			String msg = (String) attributes.get("Message");
			actMsg = msg.replaceAll("[^0-9]", "");
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully Extracted OTP from Message "+actMsg);
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to Extracted OTP from Message "+e);
		}

		// Your program element business logic goes here ...

		// String string3 = "Return Value";
		nlpResponseModel.getAttributes().put("actMsg", actMsg);
		return nlpResponseModel;
	}
}