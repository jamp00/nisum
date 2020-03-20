package nisum.com.dto;

import java.util.HashMap;
import java.util.Map;

public class UsuarioResponse {

	private boolean base64Encoded;
	private int statusCode;
  	private Map<String, String> headers;
  	private String body;
  	private String httpMethod;
	
   /**
   * Constructor para retornar un json como body.
   *
   * @param body string en formato json
   * @param sCode codigo error http para respuesta ApiGateway
   */
  	public UsuarioResponse(final String body, final int sCode) {
	    statusCode = sCode;
	    headers = new HashMap<>();
	    headers.put("Content-Type", "application/json");
	    this.body = body;
	}

	public boolean isBase64Encoded() {
		return base64Encoded;
	}
	public void setBase64Encoded(boolean base64Encoded) {
		this.base64Encoded = base64Encoded;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public Map<String, String> getHeaders() {
		return headers;
	}
	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getHttpMethod() {
		return httpMethod;
	}
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}


	

}
