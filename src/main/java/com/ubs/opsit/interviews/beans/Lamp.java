package com.ubs.opsit.interviews.beans;

public enum Lamp {

    SECONDS_LAMP {
        @Override
        public String getLamp(int seconds) {
        	return seconds == 0 || seconds % 2 == 0 ? "Y" : "O";
        }
    }, UPPER_HOUR_LAMP {
    	@Override
        public String getLamp(int hours) {
        	if(hours == 0) {
    			return "OOOO";
    		}
        	String lamp = "";
        	int result = hours/5;
        	for(int i = 0; i < result && i < 4; i++)
        		lamp+="R";
        	for(int i = result; i < 4; i++)
        		lamp+="O";
            return lamp;
        }
    }, LOWER_HOUR_LAMP {
    	@Override
        public String getLamp(int hours) {
        	if(hours == 0) {
    			return "OOOO";
    		}
        	String lamp = "";
        	int result = hours%5;
        	for(int i = 0; i < result && i < 4; i++)
        		lamp+="R";
        	for(int i = result; i < 4; i++)
        		lamp+="O";
            return lamp;
        }
    }, UPPER_MIN_LAMP {
    	@Override
        public String getLamp(int hours) {
        	if(hours == 0) {
    			return "OOOO";
    		}
        	String lamp = "";
        	int result = hours/5;
        	for(int i = 1; i <= result && i <= 11; i++)
        		lamp+= (i%3==0 ? "R" : "Y");
        	for(int i = result+1; i <= 11; i++)
        		lamp+="O";
            return lamp;
        }
    }, LOWER_MIN_LAMP {
    	@Override
        public String getLamp(int hours) {
        	if(hours == 0) {
    			return "OOOO";
    		}
        	String lamp = "";
        	int result = hours%5;
        	for(int i = 0; i < result && i < 4; i++)
        		lamp+="Y";
        	for(int i = result; i < 4; i++)
        		lamp+="O";
            return lamp;
        }
    };

    public abstract String getLamp(int digits);
    
    public static String getTime(String time) {
    	StringBuilder sb = new StringBuilder();
    	String[] tarr = time.split(":");
    	for(Lamp lamp : Lamp.values()) {
    		switch(lamp) {
    			case SECONDS_LAMP:
    				sb.append(lamp.getLamp(Integer.parseInt(tarr[2]))).append("\n");
    				break;
    			case UPPER_HOUR_LAMP:
    				sb.append(lamp.getLamp(Integer.parseInt(tarr[0]))).append("\n");
    				break;
    			case LOWER_HOUR_LAMP:
    				sb.append(lamp.getLamp(Integer.parseInt(tarr[0]))).append("\n");
    				break;
    			case UPPER_MIN_LAMP:
    				sb.append(lamp.getLamp(Integer.parseInt(tarr[1]))).append("\n");
    				break;
    			case LOWER_MIN_LAMP:
    				sb.append(lamp.getLamp(Integer.parseInt(tarr[1])));
    				break;
    		}
    	}
    	return sb.toString();
    }
}
