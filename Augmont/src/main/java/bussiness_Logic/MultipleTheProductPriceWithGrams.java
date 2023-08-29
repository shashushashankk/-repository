
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

@Component("LIC11107_PJT1001_PE_NLPb8cbec43-1c3d-48b1-8830-103b7531a9b6")
public class MultipleTheProductPriceWithGrams implements Nlp {
	String finalPrice;

	@InputParams({ @InputParam(name = "Product Price", type = "java.lang.String"),
			@InputParam(name = "Grams", type = "java.lang.String") })
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
			String price = (String) attributes.get("Product Price");
			String grams = (String) attributes.get("Grams");
			double gr = Double.parseDouble(grams);
			String output = price.replaceAll("\\u20B9", "").replaceAll("/", "").replaceAll("\\s", "").replaceAll("gm",
					"");
			double d = Double.parseDouble(output);
			double Price = d * gr;
			finalPrice=Price+"";
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Successfully fetched the price " + finalPrice);
		} catch (Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to fetch " + e);
		}
		nlpResponseModel.getAttributes().put("string3", finalPrice);
		return nlpResponseModel;
	}
}