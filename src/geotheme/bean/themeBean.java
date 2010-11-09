package geotheme.bean;

import java.util.ArrayList;

public class themeBean {

    String layerName = new String();
    String layerType = new String();
    String wmsUrl    = new String();
    String gsldUrl   = new String();
    String propList  = new String();
    String firstProp = new String();
    String bounds    = new String();
    String srs       = new String();
    String googleKey = new String();
    String colorNames= new String();
    String firstColor= new String();
    String themeRanges=new String();
    String labelScale= new String();
    String firstRange= new String();
    
    public String getFirstRange() {
		return firstRange;
	}
	public void setFirstRange(String firstRange) {
		this.firstRange = firstRange;
	}
	public String getThemeRanges() {
		return themeRanges;
	}
	public void setThemeRanges(String themeRanges) {
		String[] s = themeRanges.split(",");
		StringBuffer sb = new StringBuffer();
		
		for(int i=0;i<s.length-1;i++) {
			sb.append("['").append(s[i]).append("','");
            sb.append(s[i]).append("'],");
		}
		sb.append("['").append(s[s.length-1]).append("','");
        sb.append(s[s.length-1]).append("']");

        this.setFirstRange(s[0]);
		this.themeRanges = sb.toString();
	}
	public String getLabelScale() {
		return labelScale;
	}
	public void setLabelScale(String labelScale) {
		this.labelScale = labelScale;
	}
	public String getFirstColor() {
		return firstColor;
	}
	public void setFirstColor(String firstColor) {
		this.firstColor = firstColor;
	}
	public String getGoogleKey() {
		return googleKey;
	}
	public void setGoogleKey(String googleKey) {
		this.googleKey = googleKey;
	}
	public String getColorNames() {
		return colorNames;
	}
	public void setColorNames(String colorNames) {
		String[] s = colorNames.split(",");
		StringBuffer sb = new StringBuffer();
		
		for(int i=0;i<s.length-1;i++) {
			sb.append("['").append(s[i]).append("','");
            sb.append(s[i]).append("'],");
		}
		sb.append("['").append(s[s.length-1]).append("','");
        sb.append(s[s.length-1]).append("']");

        this.setFirstColor(s[0]);
		this.colorNames = sb.toString();
	}
	public String getSrs() {
        return srs;
    }
    public void setSrs(String srs) {
        this.srs = srs;
    }
    public String getBounds() {
        return bounds;
    }
    public void setBounds(String[] bounds) {
        StringBuffer sb = new StringBuffer();
        sb.append(bounds[1]).append(",");
        sb.append(bounds[2]).append(",");
        sb.append(bounds[3]).append(",");
        sb.append(bounds[4]);
        
        this.setSrs(bounds[0]);        
        this.bounds = sb.toString();
    }
    public String getFirstProp() {
        return firstProp;
    }
    public void setFirstProp(String firstProp) {
        this.firstProp = firstProp;
    }
    public String getPropList() {
        return propList;
    }
    public void setPropList(ArrayList<String> propList) {
        StringBuffer sb = new StringBuffer();
        
        if( propList.size() > 0 ) {
           int listSize = propList.size();
           this.setFirstProp(propList.get(0));
           
           for(int i=0;i<listSize-1;i++) {
              sb.append("['").append(propList.get(i)).append("','");
              sb.append(propList.get(i)).append("'],");
           }

           sb.append("['").append(propList.get(listSize-1)).append("','");
           sb.append(propList.get(listSize-1)).append("']");

        }
        
        this.propList = sb.toString();
    }
    public String getLayerName() {
        return layerName;
    }
    public void setLayerName(String layerName) {
        this.layerName = layerName;
    }
    public String getLayerType() {
        return layerType;
    }
    public void setLayerType(String layerType) {
        this.layerType = layerType;
    }
    public String getWmsUrl() {
        return wmsUrl;
    }
    public void setWmsUrl(String wmsUrl) {
        this.wmsUrl = wmsUrl;
    }
    public String getGsldUrl() {
        return gsldUrl;
    }
    public void setGsldUrl(String gsldUrl) {
        this.gsldUrl = gsldUrl;
    }
    
    
}
