package geotheme.bean;

public class wmsParamBean {
    
    String BBOX        = "";   
    String CQL_FILTER  = "";
    String EXCEPTIONS  = "";
    String FORMAT      = "";
    String HEIGHT      = "";
    String LAYERS      = "";
    String LAYER       = "";
    String REQUEST     = "";
    String SERVICE     = "";
    String SLD         = "";
    String SLD_BODY    = "";
    String SRS         = "";
    String STYLES      = "";
    String TILED       = "";
    String TILESORIGIN = "";
    String TRANSPARENT = "";
    String VERSION     = "1.0.0";
    String WIDTH       = "";
    
    public String getBBOX() {
        return BBOX;
    }
    public void setBBOX(String bbox) {
        BBOX = bbox;
    }
    public String getCQL_FILTER() {
        return CQL_FILTER;
    }
    public void setCQL_FILTER(String cql) {
        CQL_FILTER = cql;
    }
    public String getEXCEPTIONS() {
        return EXCEPTIONS;
    }
    public void setEXCEPTIONS(String exceptions) {
        EXCEPTIONS = exceptions;
    }
    public String getFORMAT() {
        return FORMAT;
    }
    public void setFORMAT(String format) {
        FORMAT = format;
    }
    public String getHEIGHT() {
        return HEIGHT;
    }
    public void setHEIGHT(String height) {
        HEIGHT = height;
    }
    public String getLAYERS() {
        return LAYERS;
    }
    public void setLAYERS(String layers) {
        LAYERS = layers;
    }
    public String getLAYER() {
        return LAYER;
    }
    public void setLAYER(String layer) {
        LAYER = layer;
    }
    public String getREQUEST() {
        return REQUEST;
    }
    public void setREQUEST(String request) {
        REQUEST = request;
    }
    public String getSERVICE() {
        return SERVICE;
    }
    public void setSERVICE(String service) {
        SERVICE = service;
    }
    public String getSLD() {
        return SLD;
    }
    public void setSLD(String sld) {
        SLD = sld;
    }
    public String getSRS() {
        return SRS;
    }
    public void setSRS(String srs) {
        SRS = srs;
    }
    public String getSTYLES() {
        return STYLES;
    }
    public void setSTYLES(String styles) {
        STYLES = styles;
    }
    public String getSLD_BODY() {
        return SLD_BODY;
    }
    public void setSLD_BODY(String sld_body) {
        try {
          SLD_BODY = sld_body;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public String getTILESORIGIN() {
        return TILESORIGIN;
    }
    public void setTILESORIGIN(String tilesorigin) {
        TILESORIGIN = tilesorigin;
    }
    public String getTILED() {
		return TILED;
	}
	public void setTILED(String tILED) {
		TILED = tILED;
	}
	public String getTRANSPARENT() {
        return TRANSPARENT;
    }
    public void setTRANSPARENT(String transparent) {
        TRANSPARENT = transparent;
    }
    public String getVERSION() {
        return VERSION;
    }
    public void setVERSION(String version) {
        VERSION = version;
    }
    public String getWIDTH() {
        return WIDTH;
    }
    public void setWIDTH(String width) {
        WIDTH = width;
    }
    public String getURL_PARAM() {
        StringBuffer sb = new StringBuffer();
        
        sb.append("REQUEST=").append(this.getREQUEST());
        sb.append("&FORMAT=").append(this.getFORMAT());
        
        if( this.getCQL_FILTER() != "" ) {
            sb.append("&CQL_FILTER=").append(this.getCQL_FILTER());
        }
        if( this.getSRS() != "" ) {
            sb.append("&SRS=").append(this.getSRS());                
        }
        if( this.getTRANSPARENT() != "" ) {
            sb.append("&TRANSPARENT=").append(this.getTRANSPARENT());                
        }
        if( this.getBBOX() != "" ) {
            sb.append("&BBOX=").append(this.getBBOX());
        }
        if( this.getEXCEPTIONS() != "" ) {
            sb.append("&EXCEPTIONS=").append(this.getEXCEPTIONS());
        }
        if( this.getSERVICE() != "" ) {
            sb.append("&SERVICE=").append(this.getSERVICE());   
        }
        if(this.getLAYER() != "") {
            sb.append("&LAYER=").append(this.getLAYER());
        }
        if(this.getLAYERS() != "") {
            sb.append("&LAYERS=").append(this.getLAYERS());
        }
        if(this.getWIDTH() != "" && this.getHEIGHT() != "") {
            sb.append("&HEIGHT=").append(this.getHEIGHT());
            sb.append("&WIDTH=").append(this.getWIDTH());
        }
        if(this.getVERSION() != "") {
            sb.append("&VERSION=").append(this.getVERSION());    
        }
        if(this.getTILESORIGIN() != "" && this.getTILED() != "") {
        	sb.append("&TILED=").append(this.getTILED());
            sb.append("&TILESORIGIN=").append(this.getTILESORIGIN());
        } 
        if( this.getSLD() != "") {
            sb.append("&SLD=").append(this.getSLD());
        }
        if( this.getSTYLES() != "" ){
            sb.append("&STYLES=").append(this.getSTYLES());
        }
        if( this.getSLD_BODY() != "" ){
            sb.append("&SLD_BODY=").append(this.getSLD_BODY());
        }

        return sb.toString();
    }
    
}
