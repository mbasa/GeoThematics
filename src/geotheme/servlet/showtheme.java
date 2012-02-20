package geotheme.servlet;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import geotheme.bean.*;
import geotheme.wfsUtil.*;

/**
 * Servlet implementation class showtheme
 */
public class showtheme extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String geoserverURL = new String();
	private String googleKey    = new String();
	private String colorNames   = new String();
	private String labelScale   = new String();
	private String themeRanges  = new String();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showtheme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, 
	        HttpServletResponse res) throws ServletException, IOException {

	    String thisUrl   = this.getUrl(req);
	    String layerName = "topp:states";
	    
	    if(req.getParameter("layer") != null &&
	       req.getParameter("layer").length() > 1 ) {
	        layerName = req.getParameter("layer");
	    }	    	    
	    
	    wfsParse wfs = new wfsParse( this.geoserverURL );
	    wfs.parsePropAndBnd(layerName);
	    
	    themeBean tb = new themeBean();
	    
	    tb.setLayerName(layerName);
	    tb.setGoogleKey(this.googleKey);
	    tb.setColorNames(this.colorNames);
	    tb.setGsldUrl(thisUrl + "/gsld");
	    tb.setWmsUrl(thisUrl  + "/wms");
	    
	    tb.setPropList(wfs.getProp());
	    tb.setBounds(wfs.getBnd());
	    tb.setLayerType(wfs.getLayerType());
	    
	    tb.setLabelScale(this.labelScale);
	    tb.setThemeRanges(this.themeRanges);
	    
	    req.setAttribute("themeBean", tb);
	    
	    RequestDispatcher dispatcher = 
	        getServletContext().getRequestDispatcher("/jsp/showtheme.jsp");
	    
	    dispatcher.forward(req,res);
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		ResourceBundle rb = 
			ResourceBundle.getBundle("properties.thematic");
		
		this.geoserverURL = rb.getString("GEOSERVER.BASE.URL");
	  //this.googleKey    = rb.getString("GOOGLE.LICENCE.KEY");
		this.colorNames   = rb.getString("THEMATIC.COLOR.NAMES");
		this.labelScale   = rb.getString("THEMATIC.LABEL.MAXSCALE");
		this.themeRanges  = rb.getString("THEMATIC.RANGES");
		
    	try {
    		byte[] byteData = this.colorNames.getBytes("ISO_8859_1");
    		this.colorNames = new String(byteData, "UTF-8");
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}

	}

	public String getUrl(HttpServletRequest req) { 
	    String scheme = req.getScheme();           // http 
	    String serverName = req.getServerName();   // hostname.com 
	    int serverPort = req.getServerPort();      // 8080 
	    String contextPath = req.getContextPath(); // /mywebapp 
	     
	    StringBuffer sb = new StringBuffer();
	    
	    sb.append(scheme);
	    sb.append("://").append(serverName);
	    sb.append(":").append(serverPort);
	    sb.append(contextPath);
	    
	    return sb.toString();
	}
}
