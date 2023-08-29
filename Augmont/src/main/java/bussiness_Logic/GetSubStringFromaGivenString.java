
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

@Component("LIC11107_PJT1001_PE_NLP96f9af06-bb5b-402d-8cc3-35595124c22e")
public class GetSubStringFromaGivenString implements Nlp {
	String finalString;

	@InputParams({ @InputParam(name = "String", type = "java.lang.String"),
			@InputParam(name = "Beginning Index", type = "java.lang.Integer"),
			@InputParam(name = "Ending Index", type = "java.lang.Integer") })
	@ReturnType(name = "string3", type = "java.lang.String")

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
			String gString = (String) attributes.get("String");
			int begin = (Integer) attributes.get("Beginning Index");
			int end = (Integer) attributes.get("Ending Index");
			finalString = gString.substring(begin, end);
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully fetched the substring " + finalString);
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to fetched the substring" + e);
		}
		nlpResponseModel.getAttributes().put("string3", finalString);
		return nlpResponseModel;
	}
}